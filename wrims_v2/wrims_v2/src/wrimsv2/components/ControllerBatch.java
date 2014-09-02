package wrimsv2.components;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import org.antlr.runtime.RecognitionException;
import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.commondata.wresldata.Param;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.config.ConfigUtils;
import wrimsv2.evaluator.AssignPastCycleVariable;
import wrimsv2.evaluator.DssOperation;
import wrimsv2.evaluator.PreEvaluator;
import wrimsv2.evaluator.ValueEvaluatorParser;
import wrimsv2.ilp.ILP;
import wrimsv2.solver.LPSolveSolver;
import wrimsv2.solver.XASolver;
import wrimsv2.solver.SetXALog;
import wrimsv2.solver.InitialXASolver;
import wrimsv2.solver.Gurobi.GurobiSolver;
import wrimsv2.solver.mpmodel.MPModel;
import wrimsv2.solver.ortools.OrToolsSolver;
import wrimsv2.wreslparser.elements.StudyUtils;
import wrimsv2.wreslparser.elements.Tools;
import wrimsv2.wreslplus.elements.procedures.ErrorCheck;

public class ControllerBatch {
	
	public boolean enableProgressLog = false;
	
	public ControllerBatch() {} // do nothing
	
	public ControllerBatch(String[] args) {
		long startTimeInMillis = Calendar.getInstance().getTimeInMillis();
		try {
			processArgs(args);
			StudyDataSet sds = parse();
			if (!StudyUtils.loadParserData && !FilePaths.fullMainPath.endsWith(".par")){
				StudyUtils.writeObj(sds, FilePaths.fullMainPath+".par");
			}
			long afterParsing = Calendar.getInstance().getTimeInMillis();
			int parsingPeriod=(int) (afterParsing-startTimeInMillis);
			System.out.println("Parsing Time is "+parsingPeriod/60000+"min"+Math.round((parsingPeriod/60000.0-parsingPeriod/60000)*60)+"sec");
			
			if (StudyUtils.total_errors+Error.getTotalError()==0 && !StudyUtils.compileOnly){
				new PreEvaluator(sds);
				new PreRunModel(sds);
				generateStudyFile();
				runModel(sds);
				long endTimeInMillis = Calendar.getInstance().getTimeInMillis();
				int runPeriod=(int) (endTimeInMillis-startTimeInMillis);
				System.out.println("=================Run Time is "+runPeriod/60000+"min"+Math.round((runPeriod/60000.0-runPeriod/60000)*60)+"sec====");

			} else {
				System.out.println("=================Run ends with errors=================");
			}
			
		} catch (RecognitionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

	public void processArgs(String[] args){
	
		if(args[0].startsWith("-")) {
			ConfigUtils.loadArgs(args);
		} else {		
			setControlData(args);
		}	
		
	}
	
	public void setControlData(String[] args){
		FilePaths.groundwaterDir=args[0];
        FilePaths.setMainFilePaths(args[1]);
        FilePaths.setSvarDssPaths(args[2]);
        FilePaths.setInitDssPaths(args[3]);
        FilePaths.setDvarDssPaths(args[4]);
		ControlData.svDvPartF=args[5];
		ControlData.initPartF=args[6];
		ControlData.partA = args[7];
		ControlData.defaultTimeStep = args[8];
		ControlData.startYear=Integer.parseInt(args[9]);
		ControlData.startMonth=Integer.parseInt(args[10]);
		ControlData.startDay=Integer.parseInt(args[11]);
		ControlData.endYear=Integer.parseInt(args[12]);
		ControlData.endMonth=Integer.parseInt(args[13]);
		ControlData.endDay=Integer.parseInt(args[14]);
		ControlData.solverName=args[15];
		FilePaths.csvFolderName = args[16];
		ControlData.currYear=ControlData.startYear;
		ControlData.currMonth=ControlData.startMonth;
		ControlData.currDay=ControlData.startDay;
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
			out.write(FilePaths.fullSvarDssPath+"\n");
			out.write(FilePaths.fullDvarDssPath+"\n");
			out.write(FilePaths.fullInitDssPath+"\n");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public StudyDataSet parse()throws RecognitionException, IOException{		
		
		if (Error.getTotalError()>0){
			
			System.out.println("============================================");
			System.out.println("Total errors in the config file: "+Error.getTotalError());
			System.out.println("============================================");

			return null;
			
		} else if(StudyUtils.loadParserData) {

			return StudyUtils.loadObject(StudyUtils.parserDataPath);
		
		} else if(StudyUtils.compileOnly) {
			
			return StudyUtils.compileStudy(FilePaths.fullMainPath);
		
		} else {
			
			return StudyUtils.checkStudy(FilePaths.fullMainPath);
		
		}
	}
	
	
	public void runModel(StudyDataSet sds){
		System.out.println("==============Run Study Start============");
		
		if (ControlData.solverName.equalsIgnoreCase("Gurobi")){
			runModelGurobi(sds);
		} else if (ControlData.solverName.equalsIgnoreCase("Glpk")){
			runModelOrTools(sds, "GLPK_MIXED_INTEGER_PROGRAMMING");	
		} else if (ControlData.solverName.equalsIgnoreCase("Cbc")){
			runModelOrTools(sds, "CBC_MIXED_INTEGER_PROGRAMMING");		
		} else if (ILP.logging){
			runModelILP(sds);
	    } else if (ControlData.solverName.equalsIgnoreCase("XA") || ControlData.solverName.equalsIgnoreCase("XALOG") ){
			runModelXA(sds);
		} else {
			Error.addConfigError("Solver name not recognized: "+ControlData.solverName);
			Error.writeErrorLog();
		}

		if (Error.getTotalError()>0){
			System.out.println("=================Run ends with errors====");
		} else {
			System.out.println("=================Run ends!================");
		}
	}
	public void runModelXA(StudyDataSet sds){
		ArrayList<String> modelList=sds.getModelList();
		Map<String, ModelDataSet> modelDataSetMap=sds.getModelDataSetMap();		
		
		new InitialXASolver();
		if (Error.getTotalError()>0){
			System.out.println("Model run exits due to error.");
			System.exit(1);
		}
		ArrayList<ValueEvaluatorParser> modelConditionParsers=sds.getModelConditionParsers();
		boolean noError=true;
		VariableTimeStep.initialCurrTimeStep(modelList);
		VariableTimeStep.initialCycleStartDate();
		VariableTimeStep.setCycleEndDate(sds);
		while (VariableTimeStep.checkEndDate(ControlData.cycleStartDay, ControlData.cycleStartMonth, ControlData.cycleStartYear, ControlData.endDay, ControlData.endMonth, ControlData.endYear)<=0 && noError){
			if (ControlData.solverName.equalsIgnoreCase("XALOG")) SetXALog.enableXALog();
			ClearValue.clearValues(modelList, modelDataSetMap);
			sds.clearVarTimeArrayCycleValueMap();
			sds.clearVarCycleIndexByTimeStep();
			int i=0;
			while (i<modelList.size()  && noError){  
				
				String model=modelList.get(i);
				ModelDataSet mds=modelDataSetMap.get(model);
				ControlData.currModelDataSet=mds;
				ControlData.currCycleName=model;
				ControlData.currCycleIndex=i;
				VariableTimeStep.setCycleTimeStep(sds);
				VariableTimeStep.setCurrentDate(sds, ControlData.cycleStartDay, ControlData.cycleStartMonth, ControlData.cycleStartYear);
				
				while(VariableTimeStep.checkEndDate(ControlData.currDay, ControlData.currMonth, ControlData.currYear, ControlData.cycleEndDay, ControlData.cycleEndMonth, ControlData.cycleEndYear)<0 && noError){
					ValueEvaluatorParser modelCondition=modelConditionParsers.get(i);
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
						new XASolver();
						
						// check monitored dvar list. they are slack and surplus generated automatically 
						// from the weight group deviation penalty
						// give error if they are not zero or greater than a small tolerance.
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
						System.out.println("Cycle "+(i+1)+" in "+ControlData.currYear+"/"+ControlData.currMonth+"/"+ControlData.currDay+" Done. ("+model+")");
						if (Error.error_evaluation.size()>=1) noError=false;

						ControlData.currTimeStep.set(ControlData.currCycleIndex, ControlData.currTimeStep.get(ControlData.currCycleIndex)+1);
						if (ControlData.timeStep.equals("1MON")){
							VariableTimeStep.currTimeAddOneMonth();
						}else{
							VariableTimeStep.currTimeAddOneDay();
						}
					}else{
						System.out.println("Cycle "+(i+1)+" in "+ControlData.currYear+"/"+ControlData.currMonth+"/"+ControlData.currDay+" Skipped. ("+model+")");
						new AssignPastCycleVariable();
						ControlData.currTimeStep.set(ControlData.currCycleIndex, ControlData.currTimeStep.get(ControlData.currCycleIndex)+1);
						if (ControlData.timeStep.equals("1MON")){
							VariableTimeStep.currTimeAddOneMonth();
						}else{
							VariableTimeStep.currTimeAddOneDay();
						}	
					}
				}
				i=i+1;
			}
			VariableTimeStep.setCycleStartDate(ControlData.cycleEndDay, ControlData.cycleEndMonth, ControlData.cycleEndYear);
			VariableTimeStep.setCycleEndDate(sds);
			if (enableProgressLog) {
				try {
					//FileWriter progressFile = new FileWriter(FilePaths.mainDirectory + "progress.txt", true);
					FileWriter progressFile = new FileWriter(FilePaths.mainDirectory + "progress.txt");
					PrintWriter pw = new PrintWriter(progressFile);
					int cy = 0;
					if (ControlData.currYear > cy) {
						cy = ControlData.currYear;
						pw.println(ControlData.startYear + " " + ControlData.endYear + " " + ControlData.currYear +" "+ ControlData.currMonth);
						pw.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		ControlData.xasolver.close();
		if (ControlData.writeInitToDVOutput){
			DssOperation.writeInitDvarAliasToDSS();
		}
		DssOperation.writeDVAliasToDSS();
		ControlData.writer.closeDSSFile();
		
		// write complete or fail
		if (enableProgressLog) {
			try {
				FileWriter progressFile = new FileWriter(FilePaths.mainDirectory + "progress.txt", true);
				PrintWriter pw = new PrintWriter(progressFile);
				if (Error.getTotalError() > 0) {
					pw.println("Run failed.");
				} else {
					pw.println("Run completed.");
				}
				pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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

	public static void main(String[] args){
		new ControllerBatch(args);
	}

	public void runModelILP(StudyDataSet sds){
		
		ILP.initializeIlp();
		
		ArrayList<String> modelList=sds.getModelList();
		Map<String, ModelDataSet> modelDataSetMap=sds.getModelDataSetMap();		
		
		if (ControlData.solverName.equalsIgnoreCase("lpsolve")) {
			ControlData.solverType = Param.SOLVER_LPSOLVE;
			// initiate lpsolve
		} else if (ControlData.solverName.toLowerCase().contains("xa")) {
			ControlData.solverType = Param.SOLVER_XA; //default
			new InitialXASolver();
		} else {
			Error.addConfigError("Solver name not recognized: "+ControlData.solverName);
			Error.writeErrorLog();
		}
		
		ArrayList<ValueEvaluatorParser> modelConditionParsers=sds.getModelConditionParsers();
		boolean noError=true;
		VariableTimeStep.initialCurrTimeStep(modelList);
		VariableTimeStep.initialCycleStartDate();
		VariableTimeStep.setCycleEndDate(sds);
		while (VariableTimeStep.checkEndDate(ControlData.cycleStartDay, ControlData.cycleStartMonth, ControlData.cycleStartYear, ControlData.endDay, ControlData.endMonth, ControlData.endYear)<=0 && noError){
			if (ControlData.solverType == Param.SOLVER_XA && ControlData.solverName.toLowerCase().contains("xalog")) SetXALog.enableXALog();
			ClearValue.clearValues(modelList, modelDataSetMap);
			sds.clearVarTimeArrayCycleValueMap();
			sds.clearVarCycleIndexByTimeStep();
			int i=0;
			while (i<modelList.size()  && noError){  
				
				String model=modelList.get(i);
				ModelDataSet mds=modelDataSetMap.get(model);
				ControlData.currModelDataSet=mds;
				ControlData.currCycleName=model;
				ControlData.currCycleIndex=i;
				VariableTimeStep.setCycleTimeStep(sds);
				VariableTimeStep.setCurrentDate(sds, ControlData.cycleStartDay, ControlData.cycleStartMonth, ControlData.cycleStartYear);
				
				while(VariableTimeStep.checkEndDate(ControlData.currDay, ControlData.currMonth, ControlData.currYear, ControlData.cycleEndDay, ControlData.cycleEndMonth, ControlData.cycleEndYear)<0 && noError){
					ValueEvaluatorParser modelCondition=modelConditionParsers.get(i);
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
					
						boolean isLastCycle = (i == modelList.size() - 1);
						
						if (ILP.logging && (ILP.loggingAllCycles || isLastCycle ) ) {

							ILP.setIlpFile();
							ILP.writeIlp();
							if (ILP.loggingVariableValue) {
								ILP.setVarFile();
								ILP.writeSvarValue();
							}
						}
					
						if (Error.error_evaluation.size()>=1){
							Error.writeEvaluationErrorFile("Error_evaluation.txt");
							Error.writeErrorLog();
							noError=false;
						}
					
						// choose solver to solve. TODO: this is not efficient. need to be done outside ILP
				        if (ControlData.solverType == Param.SOLVER_LPSOLVE.intValue()) {
				            LPSolveSolver.setLP(ILP.lpSolveFilePath);
				            LPSolveSolver.solve();
				            if (Error.error_solving.size()<1) {
				            	if (ILP.logging && (ILP.loggingAllCycles || isLastCycle ) )  {
				            		ILP.writeObjValue_LPSOLVE();
				            		if (ILP.loggingVariableValue) ILP.writeDvarValue_LPSOLVE();
				            	}
				            }
				        } else {
							//long startTimeInMillis = Calendar.getInstance().getTimeInMillis();
							new XASolver(); // default
							//System.exit(9);
							//long endTimeInMillis = Calendar.getInstance().getTimeInMillis();
							//long runPeriod=(long) (endTimeInMillis-startTimeInMillis);
							//System.out.println(" XA runtime: "+runPeriod/60000+"min"+Math.round((runPeriod/60000.0-runPeriod/60000)*60)+"sec");
							
							if (ILP.logging && (ILP.loggingAllCycles || isLastCycle ) ) {
								ILP.writeObjValue_XA();
								if (ILP.loggingVariableValue) ILP.writeDvarValue_XA();
							}
				        }



						ILP.closeIlpFile();

						// check monitored dvar list. they are slack and surplus generated automatically 
						// from the weight group deviation penalty
						// give error if they are not zero or greater than a small tolerance.
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
						System.out.println("Cycle "+(i+1)+" in "+ControlData.currYear+"/"+ControlData.currMonth+"/"+ControlData.currDay+" Done. ("+model+")");
						if (Error.error_evaluation.size()>=1) noError=false;

						ControlData.currTimeStep.set(ControlData.currCycleIndex, ControlData.currTimeStep.get(ControlData.currCycleIndex)+1);
						if (ControlData.timeStep.equals("1MON")){
							VariableTimeStep.currTimeAddOneMonth();
						}else{
							VariableTimeStep.currTimeAddOneDay();
						}
					}else{
						System.out.println("Cycle "+(i+1)+" in "+ControlData.currYear+"/"+ControlData.currMonth+"/"+ControlData.currDay+" Skipped. ("+model+")");
						new AssignPastCycleVariable();
						ControlData.currTimeStep.set(ControlData.currCycleIndex, ControlData.currTimeStep.get(ControlData.currCycleIndex)+1);
						if (ControlData.timeStep.equals("1MON")){
							VariableTimeStep.currTimeAddOneMonth();
						}else{
							VariableTimeStep.currTimeAddOneDay();
						}	
					}
				}
				i=i+1;
			}
			VariableTimeStep.setCycleStartDate(ControlData.cycleEndDay, ControlData.cycleEndMonth, ControlData.cycleEndYear);
			VariableTimeStep.setCycleEndDate(sds);
		}
		if (ControlData.solverType == Param.SOLVER_LPSOLVE) {
			//ControlData.lpssolver.deleteLp();
		} else {
			ControlData.xasolver.close();
		}
		if (ControlData.writeInitToDVOutput){
		DssOperation.writeInitDvarAliasToDSS();
		}
		DssOperation.writeDVAliasToDSS();
		ControlData.writer.closeDSSFile();
	}

	public void runModelGurobi(StudyDataSet sds){
		ArrayList<String> modelList=sds.getModelList();
		Map<String, ModelDataSet> modelDataSetMap=sds.getModelDataSetMap();		
		
		ArrayList<ValueEvaluatorParser> modelConditionParsers=sds.getModelConditionParsers();
		boolean noError=true;
		VariableTimeStep.initialCurrTimeStep(modelList);
		VariableTimeStep.initialCycleStartDate();
		VariableTimeStep.setCycleEndDate(sds);
		
		ILP.initializeIlp();
		GurobiSolver.initialize();
		
		while (VariableTimeStep.checkEndDate(ControlData.cycleStartDay, ControlData.cycleStartMonth, ControlData.cycleStartYear, ControlData.endDay, ControlData.endMonth, ControlData.endYear)<=0 && noError){

			ClearValue.clearValues(modelList, modelDataSetMap);
			sds.clearVarTimeArrayCycleValueMap();
			sds.clearVarCycleIndexByTimeStep();
			int i=0;
			while (i<modelList.size()  && noError){  
				
				String model=modelList.get(i);
				ModelDataSet mds=modelDataSetMap.get(model);
				ControlData.currModelDataSet=mds;
				ControlData.currCycleName=model;
				ControlData.currCycleIndex=i;
				VariableTimeStep.setCycleTimeStep(sds);
				VariableTimeStep.setCurrentDate(sds, ControlData.cycleStartDay, ControlData.cycleStartMonth, ControlData.cycleStartYear);
				
				while(VariableTimeStep.checkEndDate(ControlData.currDay, ControlData.currMonth, ControlData.currYear, ControlData.cycleEndDay, ControlData.cycleEndMonth, ControlData.cycleEndYear)<0 && noError){
					ValueEvaluatorParser modelCondition=modelConditionParsers.get(i);
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
							Error.addSolvingError("evaluation error(s)");
							Error.writeErrorLog();
							noError=false;
						} else {	
							ILP.setIlpFile();
							ILP.writeIlp();
							if (ILP.loggingVariableValue) {
								ILP.setVarFile();
								ILP.writeSvarValue();
							}
							GurobiSolver.setLp(ILP.cplexLpFilePath);
							GurobiSolver.solve();
						}

						// check monitored dvar list. they are slack and surplus generated automatically 
						// from the weight group deviation penalty
						// give error if they are not zero or greater than a small tolerance.
						noError = !ErrorCheck.checkDeviationSlackSurplus(mds.deviationSlackSurplus_toleranceMap, mds.dvMap);
						
						if (ControlData.showRunTimeMessage) System.out.println("Solving Done.");
						if (Error.error_solving.size()<1){
							
		            		ILP.writeObjValue_Gurobi();
		            		if (ILP.loggingVariableValue) ILP.writeDvarValue_Gurobi();
		            		
		            		ILP.closeIlpFile();
		            		
							ControlData.isPostProcessing=true;
							mds.processAlias();
							if (ControlData.showRunTimeMessage) System.out.println("Assign Alias Done.");
						}else{
							Error.writeSolvingErrorFile("Error_solving.txt");
							Error.writeErrorLog();
							noError=false;
						}
						System.out.println("Cycle "+(i+1)+" in "+ControlData.currYear+"/"+ControlData.currMonth+"/"+ControlData.currDay+" Done. ("+model+")");
						if (Error.error_evaluation.size()>=1) noError=false;

						ControlData.currTimeStep.set(ControlData.currCycleIndex, ControlData.currTimeStep.get(ControlData.currCycleIndex)+1);
						if (ControlData.timeStep.equals("1MON")){
							VariableTimeStep.currTimeAddOneMonth();
						}else{
							VariableTimeStep.currTimeAddOneDay();
						}
					}else{
						System.out.println("Cycle "+(i+1)+" in "+ControlData.currYear+"/"+ControlData.currMonth+"/"+ControlData.currDay+" Skipped. ("+model+")");
						new AssignPastCycleVariable();
						ControlData.currTimeStep.set(ControlData.currCycleIndex, ControlData.currTimeStep.get(ControlData.currCycleIndex)+1);
						if (ControlData.timeStep.equals("1MON")){
							VariableTimeStep.currTimeAddOneMonth();
						}else{
							VariableTimeStep.currTimeAddOneDay();
						}	
					}
				}
				i=i+1;
			}
			VariableTimeStep.setCycleStartDate(ControlData.cycleEndDay, ControlData.cycleEndMonth, ControlData.cycleEndYear);
			VariableTimeStep.setCycleEndDate(sds);
		}
		GurobiSolver.dispose();
		if (ControlData.writeInitToDVOutput){
			DssOperation.writeInitDvarAliasToDSS();
		}
		DssOperation.writeDVAliasToDSS();
		ControlData.writer.closeDSSFile();
	}

	public void runModelGurobiTest(StudyDataSet sds){


		File ilpRootDir = new File(FilePaths.mainDirectory, "=ILP=");  
	    File ilpDir = new File(ilpRootDir, StudyUtils.configFileName); 
	    File cplexLpDir = new File(ilpDir,"cplexlp_input");
	    PrintWriter objValueFile = null;
	    try {
			objValueFile = Tools.openFile(ilpDir.getAbsolutePath(), "ObjValues.log");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		GurobiSolver.initialize();
		
		//while (VariableTimeStep.checkEndDate(ControlData.cycleStartDay, ControlData.cycleStartMonth, ControlData.cycleStartYear, ControlData.endDay, ControlData.endMonth, ControlData.endYear)<=0 && noError){
		for (int year = ControlData.startYear; year <= ControlData.endYear; year++) {

			for (int month = 1; month <= 12; month++) {

				for (int cycle = 1; cycle <= sds.getModelList().size(); cycle++) {
					
					String twoDigitMonth = String.format("%02d", month);
					String twoDigitCycle = String.format("%02d", cycle);
					String lpFileName = year + "_" + twoDigitMonth + "_c" + twoDigitCycle + ".lp";
					
					String msg = year + "_" + twoDigitMonth + "_c" + twoDigitCycle;

					File lpFile = new File(cplexLpDir, lpFileName);
					
					if (lpFile.exists()){
					
						GurobiSolver.setLp(lpFile.getAbsolutePath());
						GurobiSolver.solve();
						
						double objValue = ControlData.gurobi_objective;
						String objValueStr = Double.toString(objValue);
						
						ILP.writeObjValueLog(msg, objValueStr, objValueFile);
				    
					}

				}
			}
		}

		GurobiSolver.dispose();

	}
	
	public void runModelOrTools(StudyDataSet sds, String mpSolverType){
		ArrayList<String> modelList=sds.getModelList();
		Map<String, ModelDataSet> modelDataSetMap=sds.getModelDataSetMap();		
		
		ArrayList<ValueEvaluatorParser> modelConditionParsers=sds.getModelConditionParsers();
		boolean noError=true;
		VariableTimeStep.initialCurrTimeStep(modelList);
		VariableTimeStep.initialCycleStartDate();
		VariableTimeStep.setCycleEndDate(sds);
		
		if (ILP.logging) ILP.initializeIlp();
		OrToolsSolver.initialize();
		ControlData.otsolver = new OrToolsSolver(mpSolverType);
		
		while (VariableTimeStep.checkEndDate(ControlData.cycleStartDay, ControlData.cycleStartMonth, ControlData.cycleStartYear, ControlData.endDay, ControlData.endMonth, ControlData.endYear)<=0 && noError){

			ClearValue.clearValues(modelList, modelDataSetMap);
			sds.clearVarTimeArrayCycleValueMap();
			sds.clearVarCycleIndexByTimeStep();
			int i=0;
			while (i<modelList.size()  && noError){  
				
				String model=modelList.get(i);
				ModelDataSet mds=modelDataSetMap.get(model);
				ControlData.currModelDataSet=mds;
				ControlData.currCycleName=model;
				ControlData.currCycleIndex=i;
				VariableTimeStep.setCycleTimeStep(sds);
				VariableTimeStep.setCurrentDate(sds, ControlData.cycleStartDay, ControlData.cycleStartMonth, ControlData.cycleStartYear);
				
				while(VariableTimeStep.checkEndDate(ControlData.currDay, ControlData.currMonth, ControlData.currYear, ControlData.cycleEndDay, ControlData.cycleEndMonth, ControlData.cycleEndYear)<0 && noError){
					ValueEvaluatorParser modelCondition=modelConditionParsers.get(i);
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
							Error.addSolvingError("evaluation error(s)");
							Error.writeErrorLog();
							noError=false;
						} else {	
							
							MPModel m = ControlData.otsolver.createModel();							
							
							if (Error.error_solving.size()>=1){
								Error.writeErrorLog();
								noError=false;
								break;
							}
							
							
							if (ILP.logging) {
								ILP.setIlpFile();
								if (ILP.loggingMPModel) ILP.writeMPModelFile(m);
								ILP.writeIlp();
								if (ILP.loggingVariableValue) {
									ILP.setVarFile();
									ILP.writeSvarValue();
								}
							}

							ControlData.otsolver.run();
						}

						// check monitored dvar list. they are slack and surplus generated automatically 
						// from the weight group deviation penalty
						// give error if they are not zero or greater than a small tolerance.
						noError = !ErrorCheck.checkDeviationSlackSurplus(mds.deviationSlackSurplus_toleranceMap, mds.dvMap);
						
						if (ControlData.showRunTimeMessage) System.out.println("Solving Done.");
						if (Error.error_solving.size()<1){
							
							if (ILP.logging) {
								ILP.writeObjValue_OrTools();
								if (ILP.loggingVariableValue) ILP.writeDvarValue_OrTools();
		            		
								ILP.closeIlpFile();
							}
							ControlData.isPostProcessing=true;
							mds.processAlias();
							if (ControlData.showRunTimeMessage) System.out.println("Assign Alias Done.");
						}else{
							Error.writeSolvingErrorFile("Error_solving.txt");
							Error.writeErrorLog();
							noError=false;
						}
						System.out.println("Cycle "+(i+1)+" in "+ControlData.currYear+"/"+ControlData.currMonth+"/"+ControlData.currDay+" Done. ("+model+")");
						if (Error.error_evaluation.size()>=1) noError=false;

						ControlData.currTimeStep.set(ControlData.currCycleIndex, ControlData.currTimeStep.get(ControlData.currCycleIndex)+1);
						if (ControlData.timeStep.equals("1MON")){
							VariableTimeStep.currTimeAddOneMonth();
						}else{
							VariableTimeStep.currTimeAddOneDay();
						}
					}else{
						System.out.println("Cycle "+(i+1)+" in "+ControlData.currYear+"/"+ControlData.currMonth+"/"+ControlData.currDay+" Skipped. ("+model+")");
						new AssignPastCycleVariable();
						ControlData.currTimeStep.set(ControlData.currCycleIndex, ControlData.currTimeStep.get(ControlData.currCycleIndex)+1);
						if (ControlData.timeStep.equals("1MON")){
							VariableTimeStep.currTimeAddOneMonth();
						}else{
							VariableTimeStep.currTimeAddOneDay();
						}	
					}
				}
				i=i+1;
			}
			VariableTimeStep.setCycleStartDate(ControlData.cycleEndDay, ControlData.cycleEndMonth, ControlData.cycleEndYear);
			VariableTimeStep.setCycleEndDate(sds);
		}
		ControlData.otsolver.delete();
		if (ControlData.writeInitToDVOutput){
			DssOperation.writeInitDvarAliasToDSS();
		}
		DssOperation.writeDVAliasToDSS();
		ControlData.writer.closeDSSFile();
	}
}