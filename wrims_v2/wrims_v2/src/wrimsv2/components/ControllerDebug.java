package wrimsv2.components;

import gurobi.GRBException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Date;
import java.util.Set;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import com.sunsetsoft.xa.Optimizer;

import vista.db.dss.DSSDataWriter;
import vista.db.dss.DSSUtil;
import wrimsv2.commondata.solverdata.SolverData;
import wrimsv2.commondata.wresldata.Alias;
import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.commondata.wresldata.External;
import wrimsv2.commondata.wresldata.Goal;
import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.commondata.wresldata.Param;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.commondata.wresldata.Svar;
import wrimsv2.commondata.wresldata.Timeseries;
import wrimsv2.commondata.wresldata.WeightElement;
import wrimsv2.config.ConfigUtils;
import wrimsv2.debug.ReProcessExternal;
import wrimsv2.evaluator.AssignPastCycleVariable;
import wrimsv2.evaluator.CsvOperation;
import wrimsv2.evaluator.DataTimeSeries;
import wrimsv2.evaluator.DssDataSet;
import wrimsv2.evaluator.DssDataSetFixLength;
import wrimsv2.evaluator.DssOperation;
import wrimsv2.evaluator.EvalConstraint;
import wrimsv2.evaluator.EvalExpression;
import wrimsv2.evaluator.Evaluation;
import wrimsv2.evaluator.EvaluatorLexer;
import wrimsv2.evaluator.EvaluatorParser;
import wrimsv2.evaluator.PreEvaluator;
import wrimsv2.evaluator.TimeOperation;
import wrimsv2.evaluator.ValueEvaluation;
import wrimsv2.evaluator.ValueEvaluatorLexer;
import wrimsv2.evaluator.ValueEvaluatorParser;
import wrimsv2.evaluator.WeightEval;
import wrimsv2.external.LoadAllDll;
import wrimsv2.hdf5.HDF5Writer;
import wrimsv2.ilp.ILP;
import wrimsv2.launch.LaunchConfiguration;
import wrimsv2.solver.CbcSolver;
import wrimsv2.solver.CloseCurrentSolver;
import wrimsv2.solver.LPSolveSolver;
import wrimsv2.solver.XASolver;
import wrimsv2.solver.SetXALog;
import wrimsv2.solver.InitialXASolver;
import wrimsv2.solver.Gurobi.GurobiSolver;
import wrimsv2.sql.DataBaseProfile;
import wrimsv2.sql.MySQLCWriter;
import wrimsv2.sql.MySQLRWriter;
import wrimsv2.sql.SQLServerRWriter;
import wrimsv2.tools.General;
import wrimsv2.tools.RCCComparison;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.elements.StudyConfig;
import wrimsv2.wreslparser.elements.StudyParser;
import wrimsv2.wreslparser.elements.StudyUtils;
import wrimsv2.wreslparser.elements.TempData;
import wrimsv2.wreslparser.elements.WriteCSV;
import wrimsv2.wreslplus.elements.procedures.ErrorCheck;
import lpsolve.*;

public class ControllerDebug extends Thread {
	private DebugInterface di;
	public int debugYear;
	public int debugMonth;
	public int debugDay;
	public int debugCycle;
	public int totalCycles=0;
	public String conditionalBreakpoint;
	public ValueEvaluatorParser conditionalBreakpointParser;
	public String[] args;
	public int modelIndex;
	public static ArrayList<Integer> initialTimeStep;
	
	private MySQLCWriter mySQLCWriter;
	private MySQLRWriter mySQLRWriter;
	private SQLServerRWriter sqlServerRWriter;
		
	public ControllerDebug(String[] args, DebugInterface di) {
		this.di=di;
		this.args=args;
	}
	
	@Override
	public void run() {
		new DataBaseProfile(args);
		if (args[0].toLowerCase().startsWith("-launch")){
			procLaunch(args);
		}else{
			ConfigUtils.loadArgs(args);
		}
		connectToDataBase();
		//generateStudyFile();
		try {
			StudyDataSet sds = parse();
			if (StudyParser.total_errors==0){
				if (!StudyUtils.loadParserData && !FilePaths.fullMainPath.endsWith(".par")){
					StudyUtils.writeObj(sds, FilePaths.mainDirectory+File.separator+StudyUtils.configFileName+".par");
				}
				totalCycles=sds.getModelList().size();
				di.sendEvent("totalcycle#"+totalCycles);
				new PreEvaluator(sds);
				runModel(sds);
			}
		} catch (RecognitionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		di.isDebugging=false;
		try {
			di.sendEvent("terminate");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setControlData(String[] args){
		FilePaths.groundwaterDir=args[0];
        FilePaths.setMainFilePaths(args[1]);
        FilePaths.setSvarFilePaths(args[2]);
        FilePaths.setInitFilePaths(args[3]);
        FilePaths.setDvarFilePaths(args[4]);
		ControlData cd=new ControlData();
		cd.svDvPartF=args[5];
		cd.initPartF=args[6];
		cd.partA = args[7];
		cd.defaultTimeStep = args[8];
		cd.startYear=Integer.parseInt(args[9]);
		cd.startMonth=Integer.parseInt(args[10]);
		cd.startDay=Integer.parseInt(args[11]);
		cd.endYear=Integer.parseInt(args[12]);
		cd.endMonth=Integer.parseInt(args[13]);
		cd.endDay=Integer.parseInt(args[14]);
		cd.solverName=args[15];
		FilePaths.csvFolderName = args[16];
		cd.currYear=cd.startYear;
		cd.currMonth=cd.startMonth;
		cd.currDay=cd.startDay;       
	}
	
	public void generateStudyFile(){
		String outPath=System.getenv("temp_wrims2")+"\\study.sty";
		FileWriter outstream;
		try {
			outstream = new FileWriter(outPath);
			BufferedWriter out = new BufferedWriter(outstream);
			out.write("Study File: Generated by WRIMS. Do Not Edit!\n");
			out.write("Study Name\n");
			out.write("Author\n");
			out.write("Time\n");
			out.write("Note\n");
			out.write("Version\n");
			out.write(FilePaths.groundwaterDir+"\n");
			out.write("StudyFileFullPath\n");
			out.write(FilePaths.fullMainPath+"\n");
			out.write(FilePaths.fullSvarFilePath+"\n");
			out.write(FilePaths.fullDvarDssPath+"\n");
			out.write(FilePaths.fullInitFilePath+"\n");
			out.write(ControlData.defaultTimeStep+"\n");
			out.write(VariableTimeStep.getTotalTimeStep(ControlData.defaultTimeStep)+"\n");
			out.write(ControlData.startDay+"\n");
			out.write(ControlData.startMonth+"\n");
			out.write(ControlData.startYear+"\n");
			out.write("SLP\n");
			out.write("CycleNumber\n");
			out.write("FALSE\n");
			out.write("NONE\n");
			out.write("FALSE\n");
			out.write("FALSE\n");
			out.write(" \n");
			out.write("FALSE\n");
			out.write("FALSE\n");
			out.write("FALSE\n");
			out.write("FALSE\n");
			out.write("FALSE\n");
			out.write("FALSE\n");
			out.write("FALSE\n");
			out.write("CALSIM\n");
			out.write(ControlData.initPartF+"\n");
			out.write(ControlData.svDvPartF+"\n");
			out.write("FALSE\n");
			out.write("TRUE\n");
			out.write("FALSE\n");
			out.write("SINGLE\n");
			out.write("NODEBUG\n");
			out.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public StudyDataSet parse()throws RecognitionException, IOException{
		if(StudyUtils.loadParserData) {
			StudyDataSet sds = StudyUtils.loadObject(StudyUtils.parserDataPath);
			LoadParameter.process(sds);
			return sds;
		}else{
			return StudyUtils.checkStudy(FilePaths.fullMainPath);
		}
	}
	
	public void runModel(StudyDataSet sds){
		System.out.println("=============Prepare Run Study===========");
		new PreRunModel(sds);
		System.out.println("==============Run Study Start============");
		if (ControlData.solverName.equalsIgnoreCase("XA") || ControlData.solverName.equalsIgnoreCase("XALOG") || ControlData.solverName.equalsIgnoreCase("CBC") || ControlData.solverName.equalsIgnoreCase("Gurobi")){
			runModelSolvers(sds);
		}else{
			Error.addConfigError("Solver name not recognized: "+ControlData.solverName);
			Error.writeErrorLog();
			if (ControlData.outputType!=1) ControlData.writer.closeDSSFile();
			return;
		}
		System.out.println("=================Run ends!================");
	}
	
	public void runModelSolvers(StudyDataSet sds){
		
		ILP.getIlpDir();
		ILP.setVarDir();
		ILP.createNoteFile();
		ILP.setMaximumFractionDigits();
		ILP.initializeIlp();
		
		ArrayList<String> modelList=sds.getModelList();
		Map<String, ModelDataSet> modelDataSetMap=sds.getModelDataSetMap();		
		
		if (ControlData.solverName.equalsIgnoreCase("XA") || ControlData.solverName.equalsIgnoreCase("XALOG")) {
			new InitialXASolver();
			if (Error.getTotalError()>0){
				System.out.println("Model run suspends due to error.");
				di.handleRequest("suspend");
			}
		}else if (ControlData.solverName.equalsIgnoreCase("CBC")){
			CbcSolver.init(false, sds);
			if (ControlData.cbc_debug_routeXA || ControlData.cbc_debug_routeCbc) {new InitialXASolver();}
		}else if (ControlData.solverName.equalsIgnoreCase("Gurobi")){
			GurobiSolver.initialize();
		}
		
		TimeOperation.initOutputDate(ControlData.yearOutputSection);
		TimeOperation.initMemDate(ControlData.monMemSection);
		
		ArrayList<ValueEvaluatorParser> modelConditionParsers=sds.getModelConditionParsers();
		boolean noError=true;
		VariableTimeStep.initialCurrTimeStep(modelList);
		VariableTimeStep.initialCycleStartDate();
		VariableTimeStep.setCycleEndDate(sds);
		int sectionI=0;
		while (VariableTimeStep.checkEndDate(ControlData.cycleStartDay, ControlData.cycleStartMonth, ControlData.cycleStartYear, ControlData.endDay, ControlData.endMonth, ControlData.endYear)<=0 && noError){
			if (ControlData.solverName.equalsIgnoreCase("XALOG")) SetXALog.enableXALog();
			ClearValue.clearValues(modelList, modelDataSetMap);
			sds.clearVarTimeArrayCycleValueMap();
			sds.clearVarCycleIndexByTimeStep();
			modelIndex=0;
			prepareInitialTimeStep();
			while (modelIndex<modelList.size()  && noError){  
				int cycleI=modelIndex+1;
				String strCycleI=cycleI+"";
				boolean isSelectedCycleOutput=General.isSelectedCycleOutput(strCycleI);
				
				String model=modelList.get(modelIndex);
				ModelDataSet mds=modelDataSetMap.get(model);
				ControlData.currModelDataSet=mds;
				ControlData.currCycleName=model;
				ControlData.currCycleIndex=modelIndex;
				ControlData.currTimeStep.set(modelIndex, initialTimeStep.get(modelIndex));
				VariableTimeStep.setCycleTimeStep(sds);
				VariableTimeStep.setCurrentDate(sds, ControlData.cycleStartDay, ControlData.cycleStartMonth, ControlData.cycleStartYear);
				
				while(VariableTimeStep.checkEndDate(ControlData.currDay, ControlData.currMonth, ControlData.currYear, ControlData.cycleEndDay, ControlData.cycleEndMonth, ControlData.cycleEndYear)<0 && noError){
					ValueEvaluatorParser modelCondition=modelConditionParsers.get(modelIndex);
					boolean condition=false;
					try{
						modelCondition.evaluator();
						condition=modelCondition.evalCondition;
					}catch (Exception e){
						Error.addEvaluationError("Model condition evaluation has error.");
						condition=false;
					}
					modelCondition.reset();
				
					if (condition){
						ClearValue.clearCycleLoopValue(modelList, modelDataSetMap);
						ControlData.currSvMap=mds.svMap;
						ControlData.currSvFutMap=mds.svFutMap;
						ControlData.currDvMap=mds.dvMap;
						ControlData.currDvSlackSurplusMap=mds.dvSlackSurplusMap;
						ControlData.currAliasMap=mds.asMap;
						ControlData.currGoalMap=mds.gMap;
						ControlData.currTsMap=mds.tsMap;
						ControlData.isPostProcessing=false;
						mds.processModel();
					
						if (Error.error_evaluation.size()>=1){
							Error.writeEvaluationErrorFile("Error_evaluation.txt");
							Error.writeErrorLog();
							noError=false;
						}
					
						if (ControlData.solverName.equalsIgnoreCase("XA")) {
							new XASolver(); 						
				        }else if (ControlData.solverName.equalsIgnoreCase("XALOG")){
				        	if (isSelectedCycleOutput){
				        		ILP.setIlpFile();
				        		ILP.writeIlp();
				        		ILP.setVarFile();
				        		ILP.writeSvarValue();
				        	}
							new XASolver();
							if (isSelectedCycleOutput){
								ILP.writeObjValue_XA();
								ILP.writeDvarValue_XA();
							}
				        }else if (ControlData.solverName.equalsIgnoreCase("CBC")){
				        	HashSet<String> originalDvarKeys=null;
				        	if (ControlData.cbc_debug_routeCbc || ControlData.cbc_debug_routeXA) {
								originalDvarKeys = new LinkedHashSet<String>(SolverData.getDvarMap().keySet());
//								ILP.getIlpDir();
//								ILP.setVarDir();
								ILP.setSvarFile();
//								ILP.setMaximumFractionDigits();
								// write svar
								ILP.writeSvarValue();
							}else if (ILP.logging && isSelectedCycleOutput) {
				        		ILP.setIlpFile();
				        		ILP.writeIlp();
				        		if (ILP.loggingVariableValue){
				        			ILP.setVarFile();
				        			ILP.writeSvarValue();
				        		}
				        	}
				        	
				        	if (ControlData.cbc_debug_routeCbc) {
								new XASolver();
								SolverData.getDvarMap().keySet().retainAll(originalDvarKeys);
								if (Error.error_solving.size() > 0) {
									String msg = "XA solving error.";
									ILP.writeNoteLn("", msg);
									System.out.println("" + msg);
									Error.writeErrorLog();
									Error.error_solving.clear();
								}
								
							}
				        	
							CbcSolver.newProblem();
							
							if (ControlData.cbc_debug_routeXA) {
								SolverData.getDvarMap().keySet().retainAll(originalDvarKeys);
								new XASolver();
							}
							
							if (ControlData.cbc_debug_routeXA ||ControlData.cbc_debug_routeCbc ) {										
								CbcSolver.logCbcDebug(sds);
							}else if (ControlData.watchList!=null) {
								CbcSolver.logCbcWatchList(sds);
							}else if (Error.error_solving.size()<1) {
				            	if (ILP.logging && isSelectedCycleOutput) {
				            		ILP.writeObjValue_Clp0_Cbc0();
				            		if (ILP.loggingVariableValue) ILP.writeDvarValue_Clp0_Cbc0(CbcSolver.varDoubleMap);
				            	}
							}
				        }else if (ControlData.solverName.equalsIgnoreCase("LPSolve")) {
							ILP.setIlpFile();
							ILP.writeIlp();
							if (ILP.loggingVariableValue && isSelectedCycleOutput) {
								ILP.setVarFile();
								ILP.writeSvarValue();
							}
				        	LPSolveSolver.setLP(ILP.lpSolveFilePath);
				            LPSolveSolver.solve();
				            if (Error.error_solving.size()<1) {
				            	if (ILP.logging && isSelectedCycleOutput) {
				            		ILP.writeObjValue_LPSOLVE();
				            		if (ILP.loggingVariableValue) ILP.writeDvarValue_LPSOLVE();
				            	}
				            }
				        }else if (ControlData.solverName.equalsIgnoreCase("Gurobi")){
				        	ILP.setIlpFile();
							ILP.writeIlp();
							if (ILP.loggingVariableValue && isSelectedCycleOutput) {
								ILP.setVarFile();
								ILP.writeSvarValue();
							}
							GurobiSolver.setLp(ILP.cplexLpFilePath);
							GurobiSolver.solve();
							if (Error.error_solving.size()<1) {
				            	if (ILP.logging && isSelectedCycleOutput) {
				            		ILP.writeObjValue_LPSOLVE();
				            		if (ILP.loggingVariableValue) ILP.writeDvarValue_Gurobi();
				            	}
				            }
				        }
						ILP.closeIlpFile();
						noError = !ErrorCheck.checkDeviationSlackSurplus(mds.deviationSlackSurplus_toleranceMap, mds.dvMap);
								
						if (ControlData.showRunTimeMessage) System.out.println("Solving Done.");
						if (Error.error_solving.size()<1){
							ControlData.isPostProcessing=true;
							mds.processAlias();
							if (ControlData.showRunTimeMessage) System.out.println("Assign Alias Done.");
						}else{
							Error.writeSolvingErrorFile("Error_solving.txt");
							Error.writeErrorLog();
							noError=false;
						}
						if (ControlData.outputType==1){
							if (ControlData.isOutputCycle && isSelectedCycleOutput){
								HDF5Writer.writeOneCycleSv(mds, cycleI);
							}
						}
						System.out.println("Cycle "+cycleI+" in "+ControlData.currYear+"/"+ControlData.currMonth+"/"+ControlData.currDay+" Done. ("+model+")");
						if (CbcSolver.intLog && ControlData.solverName.equalsIgnoreCase("CBC")) {
							CbcSolver.logIntCheck(sds);	
						}
						if (ControlData.solverName.equalsIgnoreCase("CBC")){CbcSolver.resetModel();}
						pauseForDebug(modelIndex);
						if (Error.error_evaluation.size()>=1) noError=false;
						if (Error.getTotalError()==0) noError=true;
						//if (ControlData.currTimeStep==0 && ControlData.currCycleIndex==2) new RCCComparison();
						ControlData.currTimeStep.set(ControlData.currCycleIndex, ControlData.currTimeStep.get(ControlData.currCycleIndex)+1);
						if (ControlData.timeStep.equals("1MON")){
							VariableTimeStep.currTimeAddOneMonth();
						}else{
							VariableTimeStep.currTimeAddOneDay();
						}
					}else{
						if (ControlData.outputType==1){
							if (ControlData.isOutputCycle && isSelectedCycleOutput){
								HDF5Writer.skipOneCycle(mds, cycleI);
							}
						}
						System.out.println("Cycle "+cycleI+" in "+ControlData.currYear+"/"+ControlData.currMonth+"/"+ControlData.currDay+" skipped. ("+model+")");
						new AssignPastCycleVariable();
						deferPause(modelIndex);
						ControlData.currTimeStep.set(ControlData.currCycleIndex, ControlData.currTimeStep.get(ControlData.currCycleIndex)+1);
						if (ControlData.timeStep.equals("1MON")){
							VariableTimeStep.currTimeAddOneMonth();
						}else{
							VariableTimeStep.currTimeAddOneDay();
						}	
					}
				}
				modelIndex=modelIndex+1;
			}
			Date date1= new Date(ControlData.currYear-1900, ControlData.currMonth-1, ControlData.currDay);
			Date date2= new Date(ControlData.outputYear-1900, ControlData.outputMonth-1, ControlData.outputDay);
			if (ControlData.yearOutputSection>0 && date1.after(date2)){
				if (ControlData.writeInitToDVOutput && sectionI==0){
					DssOperation.writeInitDvarAliasToDSS();
				}
				sectionI++;
				TimeOperation.setMemDate(ControlData.monMemSection);
				DssOperation.writeDVAliasToDSS();
				DssOperation.shiftData();
				TimeOperation.setOutputDate(ControlData.yearOutputSection);
			}
			updateVarMonitor();
			if (ControlData.resimDate){
				ControlData.resimDate=false;
				noError=true;
				sds=ControlData.currStudyDataSet;
				modelList=sds.getModelList();
				modelDataSetMap=sds.getModelDataSetMap();		
				modelConditionParsers=sds.getModelConditionParsers();
				new ReProcessExternal(sds);
				resetStartDate(sds);
			}
			VariableTimeStep.setCycleStartDate(ControlData.cycleEndDay, ControlData.cycleEndMonth, ControlData.cycleEndYear);
			VariableTimeStep.setCycleEndDate(sds);
		}
		new CloseCurrentSolver(ControlData.solverName);

		DssOperation.writeDVAliasToDSS();
		ControlData.writer.closeDSSFile();
		if (ControlData.outputType==1){
			HDF5Writer.createDvarAliasLookup();
			HDF5Writer.writeTimestepData();
			HDF5Writer.writeCyclesDvAlias();
			HDF5Writer.closeDataStructure();
		}else if (ControlData.outputType==2){
			mySQLCWriter.process();
		}else if (ControlData.outputType==3){
			mySQLRWriter.process();
		}else if (ControlData.outputType==4){
			sqlServerRWriter.process();
		}else if (ControlData.outputType==5){
			CsvOperation co = new CsvOperation();
			co.ouputCSV(FilePaths.fullCsvPath, 0);
		}
		
		WeightEval.outputWtTableAR();
	}
	
	public void prepareInitialTimeStep(){
		initialTimeStep=new ArrayList<Integer>();
		for (Integer timeStep: ControlData.currTimeStep){
			initialTimeStep.add(timeStep.intValue());
		}
	}
	
	public void resetStartDate(StudyDataSet sds){
		int diffTimeStep;
		VariableTimeStep.procCycleTimeStep(sds);
		for(int i=0; i<initialTimeStep.size(); i++){
			String timeStep=sds.getModelTimeStepList().get(i);
			if (timeStep.equals("1MON")){
				diffTimeStep=(ControlData.cycleStartYear-ControlData.resimYear)*12+(ControlData.cycleStartMonth-ControlData.resimMonth);
			}else{
				Date startDate = new Date (ControlData.resimYear-1900, ControlData.resimMonth-1, ControlData.resimDay);
				Date endDate=new Date (ControlData.cycleStartYear-1900, ControlData.cycleStartMonth-1, ControlData.cycleStartDay);
				long startTime=startDate.getTime();
				long endTime=endDate.getTime();
				diffTimeStep=(int)((endTime-startTime)/(24*60*60*1000l));
			}
			ControlData.currTimeStep.set(i, initialTimeStep.get(i)-diffTimeStep);
		}
		ControlData.cycleEndYear=ControlData.resimYear;
		ControlData.cycleEndMonth=ControlData.resimMonth;
		ControlData.cycleEndDay=ControlData.resimDay;
	}
	
	public void pauseForDebug(int i){
		if (ControlData.timeStep.equals("1MON")){
			if (ControlData.currYear==debugYear && ControlData.currMonth==debugMonth && i==debugCycle-1){
				try {
					di.sendEvent("suspended!"+debugYear+"#"+debugMonth+"#"+debugDay+"#"+debugCycle);
					System.out.println("paused");
				} catch (IOException e) {
					e.printStackTrace();
				}
				this.suspend();
			}
		}else{
			if (ControlData.currYear==debugYear && ControlData.currMonth==debugMonth && ControlData.currDay==debugDay && i==debugCycle-1){
				try {
					di.sendEvent("suspended!"+debugYear+"#"+debugMonth+"#"+debugDay+"#"+debugCycle);
					System.out.println("paused");
				} catch (IOException e) {
					e.printStackTrace();
				}
				this.suspend();
			}
		}
		if (Error.getTotalError()>0){
			try {
				int cycle=ControlData.currCycleIndex+1;
				di.sendEvent("suspended!"+ControlData.currYear+"#"+ControlData.currMonth+"#"+ControlData.currDay+"#"+cycle);
				System.out.println("Error! Paused");
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.suspend();
		}else{
			checkConditionalBreakpoint();
		}
	}
	
	public void deferPause(int i){
		if (ControlData.timeStep.equals("1MON")){
			if (ControlData.currYear==debugYear && ControlData.currMonth==debugMonth && i==debugCycle-1){
				debugCycle=debugCycle+1;
				if (debugCycle>totalCycles){
					debugCycle=1;
					debugTimeAddOneMonth();
				}
			}
		}else{
			if (ControlData.currYear==debugYear && ControlData.currMonth==debugMonth && ControlData.currDay==debugDay && i==debugCycle-1){
				debugCycle=debugCycle+1;
				if (debugCycle>totalCycles){
					debugCycle=1;
					debugTimeAddOneDay();
				}
			}
		}
	}
	
	
	public void debugTimeAddOneMonth(){
		debugMonth=debugMonth+1;
		if (debugMonth>12){
			debugMonth=debugMonth-12;
			debugYear=debugYear+1;
		}
		debugDay=TimeOperation.numberOfDays(debugMonth, debugYear);
	}

	public void debugTimeAddOneDay(){
		Date debugDate = new Date (debugYear-1900, debugMonth-1, debugDay);
		long debugTime=debugDate.getTime()+1 * 24 * 60 * 60 * 1000l;
		debugDate = new Date (debugTime);
		debugMonth=debugDate.getMonth()+1;
		debugYear=debugDate.getYear()+1900;
		debugDay=debugDate.getDate();
	}
	
	private void checkConditionalBreakpoint() {
		boolean condition=false;
		ControlData.currEvalTypeIndex=1000;
		if (conditionalBreakpointParser!=null){		
			try{
				conditionalBreakpointParser.evaluator();
				condition=conditionalBreakpointParser.evalCondition;
			}catch (Exception e){
				condition=false;
			}
		
			conditionalBreakpointParser.reset();
			Error.error_evaluation.clear();
		}
		
		if (condition){
			try {
				di.sendEvent("suspended!"+debugYear+"#"+debugMonth+"#"+debugDay+"#"+debugCycle);
				System.out.println("conditional breakpoint of " + conditionalBreakpoint + " reached");
				System.out.println("paused");
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.suspend();
		}
	}

	public void updateVarMonitor(){
		String dataString="updateVarMonitor!";
		for (int k=0; k<di.monitorVarNames.length; k++){
			String monitorVarName=di.monitorVarNames[k];
			dataString=dataString+monitorVarName+"$";
			String monitorVarTimeStep=di.monitorVarTimeStep;
			String entryName=DssOperation.entryNameTS(monitorVarName, monitorVarTimeStep);
			HashMap<String, DssDataSetFixLength> dvAliasTSMap = DataTimeSeries.dvAliasTS;
		
			if (dvAliasTSMap.containsKey(entryName)){
				DssDataSetFixLength ddsf = dvAliasTSMap.get(entryName);
				double[] dataArray = ddsf.getData();
				TimeOperation.findTime(-1);
				int currIndex=ValueEvaluation.timeSeriesIndex(ddsf)-1;
				for (int i=0; i<=currIndex; i++){
					double value=dataArray[i];
					if (!(value==-901.0 || value==-902.0)){
						int timestepListed=i-currIndex;
						TimeOperation.findTime(timestepListed);
						dataString=dataString+timestepListed+":"+ControlData.dataMonth+"-"+ControlData.dataDay+"-"+ControlData.dataYear+":"+di.df.format(value)+"#";
					}
				}
			}else{
				HashMap<String, DssDataSet> svTSMap = DataTimeSeries.svTS;
				if (svTSMap.containsKey(entryName)){
					DssDataSet dds = svTSMap.get(entryName);
					ArrayList<Double> dataArrayList = dds.getData();
					TimeOperation.findTime(-1);
					int currIndex=ValueEvaluation.timeSeriesIndex(dds);
					for (int i=0; i<=currIndex; i++){
						double value=dataArrayList.get(i);
						if (!(value==-901.0 || value==-902.0)){
							int timestepListed=i-currIndex;
							TimeOperation.findTime(timestepListed);
							dataString=dataString+timestepListed+":"+ControlData.dataMonth+"-"+ControlData.dataDay+"-"+ControlData.dataYear+":"+di.df.format(value)+"#";
						}
					}
				}
			}
			dataString=dataString+"!";
		}
		if (dataString.endsWith("!")) dataString=dataString.substring(0, dataString.length()-1);
		if (dataString.endsWith("#")) dataString=dataString.substring(0, dataString.length()-1);
		try {
			di.sendEvent(dataString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeOutputDssEveryTenYears(){
		if (ControlData.currMonth==12 && ControlData.currYear%10==0){
			if (ControlData.timeStep.equals("1MON")){
				DssOperation.writeDVAliasToDSS();
			}else if(ControlData.timeStep.equals("1DAY") && ControlData.currDay==31){
				DssOperation.writeDVAliasToDSS();
			}
		}
	}
	
	public void connectToDataBase(){
		if (ControlData.outputType==2){
			mySQLCWriter=new MySQLCWriter();
		}else if (ControlData.outputType==3){
			mySQLRWriter=new MySQLRWriter();
		}else if (ControlData.outputType==4){
			sqlServerRWriter=new SQLServerRWriter();
		}
	}
	
	public void procLaunch(String[] args){
		String launchFilePath = args[0].substring(args[0].indexOf("=") + 1, args[0].length());
		new LaunchConfiguration(launchFilePath);
	}
}