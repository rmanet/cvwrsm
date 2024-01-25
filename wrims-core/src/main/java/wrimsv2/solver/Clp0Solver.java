package wrimsv2.solver;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;

import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.commondata.solverdata.*;
import wrimsv2.components.ControlData;
import wrimsv2.components.Error;
import wrimsv2.components.IntDouble;
import wrimsv2.evaluator.DataTimeSeries;
import wrimsv2.evaluator.DssDataSetFixLength;
import wrimsv2.evaluator.DssOperation;
import wrimsv2.evaluator.EvalConstraint;
import wrimsv2.ilp.ILP;
import wrimsv2.solver.clp.FilePassingUtils;
import wrimsv2.wreslparser.elements.Tools;
import lpsolve.*;

public class Clp0Solver {
	
	public static int errorCode;  // 11 : error in batch // 12: error in dvar value
	public static Map <String, Double> varDoubleMap;
	private static String lpFilePath;
	private static String soluPath;
	private static String clpPath;
	private static String tolerance1 = "-primalT 1e-008";
	private static String tolerance2 = "-primalT 1e-007";
	
	public static void init() {
		
		//set batch file path
		clpPath = System.getenv("CLP0_PATH");
		
	}
	
    public static void setLP(String filePath){

		 // set lp file path and solution file path
    	lpFilePath = filePath;
    	soluPath = FilenameUtils.removeExtension(lpFilePath)+".sn";
    	File soluF = new File(soluPath);
    	if (soluF.exists()){
    		soluF.delete();
    	}
		  
	}
	
	public static void solve(){
	    		
		// call clp to solve
		
		String soluName = FilenameUtils.getBaseName(soluPath)+".sn";
		String soluDir  = new File(soluPath).getParent();

		String arg_lpPath = "\""+lpFilePath+"\"";
		String arg_soluDir = "\""+soluDir+"\"";
		String arg_soluName = "\""+soluName+"\"";
		
		ControlData.clp_cbc_objective = null;
		ControlData.clp_cbc_note ="";
		
		try {

			String msg=callClp(arg_lpPath, arg_soluDir, arg_soluName, tolerance1);
			
			if (!msg.startsWith("optimal")) {
				String note = msg+"\n"+"Retry with "+tolerance2;
				ControlData.clp_cbc_note = note;
				System.out.println(ILP.getYearMonthCycle()+": "+note);
				msg=callClp(arg_lpPath, arg_soluDir, arg_soluName, tolerance2);
			}
			
			errorCode=FilePassingUtils.parseReturnFile(soluPath);

		} catch (Exception ex) {
			
			errorCode=11;
			Error.addSolvingError("CLP solver error code: "+errorCode + ": possible batch file error.");
		}
		
		
		if (errorCode!=0) {
			
			Error.addSolvingError("CLP solver error code: "+errorCode);
			Error.addSolvingError("CLP solver error message: "+FilePassingUtils.solverMessage);
			
		}
				
			// if no error then: 
			// 1. assign objective, 
			// 2. collect dvar, 
			// 3. feedback dvar to wrims2
		
		  if (Error.error_solving.size()==0) {
			  ControlData.clp_cbc_objective = FilePassingUtils.objective_value;
			  collectDvar();
		      assignDvar();				  
		  }	
	    	
	    }

	private static String callClp(String arg_lpPath, String arg_soluDir, String arg_soluName, String tolerance) throws IOException, InterruptedException {
		
		Runtime rt = Runtime.getRuntime();
		//String toPass = "cmd /c start /min \"Clp0 solver\" " + batchPath + " " + args1 +" "+ args2 +" "+ args3;
		String directCall = clpPath+" "+arg_lpPath+" "+tolerance+" -solv -directory "+arg_soluDir+" -solu "+arg_soluName ;
		//System.out.println(directCall);
		Process proc = rt.exec(directCall);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		String line;
		String lastLine="";
		while ((line = reader.readLine()) != null){
		    lastLine=line;
		}
		
		int exitVal = proc.waitFor();  // TODO: exitVal not works
		
		return lastLine.toLowerCase();
		
	}	
	
	
	private static void collectDvar() {
		
		varDoubleMap = FilePassingUtils.varDoubleMap;
		
	}

	public static void setDefaultOption() {
		
	}

	public static void getSolverInformation(int modelStatus){

//		Error.addSolvingError(solver.getStatustext(modelStatus)); 
//		Error.addSolvingError(lpFilePath); 		
	}
	
	
	private static void assignDvar() {
		Map<String, Map<String, IntDouble>> varCycleValueMap=ControlData.currStudyDataSet.getVarCycleValueMap();
		Map<String, Map<String, IntDouble>> varTimeArrayCycleValueMap=ControlData.currStudyDataSet.getVarTimeArrayCycleValueMap();
		Set<String> dvarUsedByLaterCycle = ControlData.currModelDataSet.dvarUsedByLaterCycle;
		Set<String> dvarTimeArrayUsedByLaterCycle = ControlData.currModelDataSet.dvarTimeArrayUsedByLaterCycle;
		ArrayList<String> timeArrayDvList = ControlData.currModelDataSet.timeArrayDvList;
		String model=ControlData.currCycleName;
		
		StudyDataSet sds = ControlData.currStudyDataSet;
		ArrayList<String> varCycleIndexList = sds.getVarCycleIndexList();
		ArrayList<String> dvarTimeArrayCycleIndexList = sds.getDvarTimeArrayCycleIndexList();
		Map<String, Map<String, IntDouble>> varCycleIndexValueMap = sds.getVarCycleIndexValueMap();
		
		Map<String, Dvar> dvarMap = SolverData.getDvarMap();
		Set dvarCollection = dvarMap.keySet();
		Iterator dvarIterator = dvarCollection.iterator();
			
		while(dvarIterator.hasNext()){ 
			String dvName=(String)dvarIterator.next();
			Dvar dvar=dvarMap.get(dvName);
			
			double value = -77777777;
			try {
				if ( varDoubleMap.keySet().contains(dvName) ) {
					value=varDoubleMap.get(dvName);
				} else {
					value = 0;  // if not listed in clp solution file then it's 0
					varDoubleMap.put(dvName, value);
				}
				
			} catch (Exception e) {
				errorCode=12;
				Error.addSolvingError("CLP solution dvar value error. Dvar: "+dvName+" Value: "+varDoubleMap.get(dvName));
				
			}
			IntDouble id=new IntDouble(value,false);
			dvar.setData(id);
			if(dvarUsedByLaterCycle.contains(dvName)){
				varCycleValueMap.get(dvName).put(model, id);
			}else if (dvarTimeArrayUsedByLaterCycle.contains(dvName)){
				if (varTimeArrayCycleValueMap.containsKey(dvName)){
					varTimeArrayCycleValueMap.get(dvName).put(model, dvar.data);
				}else{
					Map<String, IntDouble> cycleValue = new HashMap<String, IntDouble>();
					cycleValue.put(model, dvar.data);
					varTimeArrayCycleValueMap.put(dvName, cycleValue);
				}
			}
			if (varCycleIndexList.contains(dvName) || dvarTimeArrayCycleIndexList.contains(dvName)){
				if (varCycleIndexValueMap.containsKey(dvName)){
					varCycleIndexValueMap.get(dvName).put(model, dvar.data);
				}else{
					Map<String, IntDouble> cycleValue = new HashMap<String, IntDouble>();
					cycleValue.put(model, dvar.data);
					varCycleIndexValueMap.put(dvName, cycleValue);
				}
			}
			String entryNameTS=DssOperation.entryNameTS(dvName, ControlData.timeStep);
			DataTimeSeries.saveDataToTimeSeries(dvName, entryNameTS, value, dvar);
			if (timeArrayDvList.contains(dvName)){
				entryNameTS=DssOperation.entryNameTS(dvName+"__fut__0", ControlData.timeStep);
				DataTimeSeries.saveDataToTimeSeries(entryNameTS, value, dvar, 0);
			}
		}
		
		if (ControlData.showRunTimeMessage) {
			System.out.println("Objective Value: "+ControlData.clp_cbc_objective);
			System.out.println("Assign Dvar Done.");
		}
	}

}
