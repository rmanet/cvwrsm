package wrimsv2.commondata.wresldata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import wrimsv2.commondata.solverdata.SolverData;
import wrimsv2.components.ControlData;
import wrimsv2.components.IntDouble;
import wrimsv2.evaluator.DataTimeSeries;
import wrimsv2.evaluator.DssDataSetFixLength;
import wrimsv2.evaluator.Evaluation;
import wrimsv2.evaluator.EvaluatorParser;
import wrimsv2.evaluator.ValueEvaluatorLexer;
import wrimsv2.evaluator.ValueEvaluatorParser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import wrimsv2.components.Error;


public class ModelDataSet implements Serializable {
	
	private static final long serialVersionUID = 1L;
	// / weight table   // <objName,  <itemName, value>>
	public ArrayList<String> wtList = new ArrayList<String>();
	public ArrayList<String> wtSlackSurplusList = new ArrayList<String>();

//	public ArrayList<String> wtList_global = new ArrayList<String>();
//	public ArrayList<String> wtList_local = new ArrayList<String>();
	public Map<String, WeightElement> wtMap = new HashMap<String, WeightElement>();
	public Map<String, WeightElement> wtSlackSurplusMap = new HashMap<String, WeightElement>();	

	// / external function structure
	public ArrayList<String> exList = new ArrayList<String>();
	public ArrayList<String> exList_global = new ArrayList<String>();
	public ArrayList<String> exList_local = new ArrayList<String>();
	public Map<String, External> exMap = new HashMap<String, External>();
	
	
//    //  / sv, ts, and dv list
//	public ArrayList<String> svTsDvList = new ArrayList<String>();	
//	
//	//  / sv and ts list
//	public ArrayList<String> svTsList = new ArrayList<String>();
	
	// / svar timeseries data structure
	public ArrayList<String> tsList = new ArrayList<String>();
	public ArrayList<String> tsList_global = new ArrayList<String>();
	public ArrayList<String> tsList_local = new ArrayList<String>();
	public Map<String, Timeseries> tsMap = new HashMap<String, Timeseries>();
	
	// / svar data structure
	public Set<String> svSet_unknown = new HashSet<String>();
	public ArrayList<String> svList = new ArrayList<String>();
	public ArrayList<String> svList_global = new ArrayList<String>();
	public ArrayList<String> svList_local = new ArrayList<String>();
	public Map<String, Svar> svMap = new HashMap<String, Svar>();

	// / dvar data structure
	public ArrayList<String> dvList = new ArrayList<String>();
	public ArrayList<String> dvSlackSurplusList = new ArrayList<String>();
	public ArrayList<String> dvList_global = new ArrayList<String>();
	public ArrayList<String> dvList_local = new ArrayList<String>();
	public Map<String, Dvar> dvMap = new HashMap<String, Dvar>();
	public Map<String, Dvar> dvSlackSurplusMap = new HashMap<String, Dvar>();

	// / alias data structure
	public Set<String> asSet_unknown = new HashSet<String>();
	public ArrayList<String> asList = new ArrayList<String>();
	public ArrayList<String> asList_global = new ArrayList<String>();
	public ArrayList<String> asList_local = new ArrayList<String>();
	public Map<String, Alias> asMap = new HashMap<String, Alias>();

	// / goal data structure
	public ArrayList<String> gList = new ArrayList<String>();
	public ArrayList<String> gList_global = new ArrayList<String>();
	public ArrayList<String> gList_local = new ArrayList<String>();
	public Map<String, Goal> gMap = new HashMap<String, Goal>();
	
	public ArrayList<String> incFileList=new ArrayList<String>();
	public ArrayList<String> incFileList_global=new ArrayList<String>();
	public ArrayList<String> incFileList_local=new ArrayList<String>();
	
	public Set<String> varUsedByLaterCycle = new HashSet<String>();
	
	public Set<String> dvarUsedByLaterCycle = new HashSet<String>();
	public Set<String> svarUsedByLaterCycle = new HashSet<String>();
	public Set<String> aliasUsedByLaterCycle = new HashSet<String>();
		
	public void processModel(){
		resetWeight(); // this clears slack and surplus vars
		processTimeseries();
		System.out.println("Process Timeseries Done.");
		processSvar();
		System.out.println("Process Svar Done.");
		processDvar();	
		System.out.println("Process Dvar Done.");
		processGoal();	
		System.out.println("Process Goal Done.");
		processWeight();
		System.out.println("Process Weight Done.");
	}

	public void resetWeight(){
		wtList.removeAll(wtSlackSurplusList);
		for (String e: wtSlackSurplusList){
			wtMap.remove(e);
		}
	}
	
	public void processWeight(){
		ModelDataSet mds=ControlData.currModelDataSet;
		ArrayList<String> wtList = mds.wtList;
		Map<String, WeightElement> wtMap =mds.wtMap;
		SolverData.setWeightMap(wtMap);
		ControlData.currEvalTypeIndex=5;
		for (String wtName: wtList){
			ControlData.currEvalName=wtName;
			//System.out.println("Process weight "+wtName);
			WeightElement wt=wtMap.get(wtName);
			ValueEvaluatorParser evaluator=wt.weightParser;
			try {
				evaluator.evaluator();
				wt.setValue(evaluator.evalValue.getData().doubleValue());
			} catch (RecognitionException e) {
				Error.addEvaluationError("weight definition has error");
				wt.setValue(0.0);
			}
			evaluator.reset();
		}
	}
		
	public void processSvar(){
		ModelDataSet mds=ControlData.currModelDataSet;
		ArrayList<String> svList = mds.svList;
		Map<String, Svar> svMap =mds.svMap;
		ControlData.currEvalTypeIndex=0;
		Map<String, Map<String, IntDouble>> varCycleValueMap=ControlData.currStudyDataSet.getVarCycleValueMap();
		Set<String> svarUsedByLaterCycle = mds.svarUsedByLaterCycle;
		String model=ControlData.currCycleName;
		for (String svName: svList){
			ControlData.currEvalName=svName;
			//System.out.println("Process svar "+svName);
			Svar svar=svMap.get(svName);
			ArrayList<ValueEvaluatorParser> caseConditions=svar.caseConditionParsers;
			boolean condition=false;
			int i=-1;
			while(!condition && i<=caseConditions.size()-2){
				i=i+1;
				ValueEvaluatorParser caseCondition=caseConditions.get(i);
				try{
					caseCondition.evaluator();
					condition=caseCondition.evalCondition;
				}catch (Exception e){
					Error.addEvaluationError("Case condition evaluation has error.");
					condition=false;
				}
				caseCondition.reset();
			}
			if (condition){
				ArrayList<ValueEvaluatorParser> caseExpressions=svar.caseExpressionParsers;
				ValueEvaluatorParser caseExpression=caseExpressions.get(i);
				try {
					caseExpression.evaluator();
					IntDouble evalValue=caseExpression.evalValue;
					svar.setData(evalValue);
					if (svarUsedByLaterCycle.contains(svName)){
						varCycleValueMap.get(svName).put(model, evalValue);
					}
				} catch (RecognitionException e) {
					Error.addEvaluationError("Case expression evaluation has error.");
					IntDouble evalValue=new IntDouble(1.0, false);
					svar.setData(evalValue);
					if (svarUsedByLaterCycle.contains(svName)){
						varCycleValueMap.get(svName).put(model, evalValue);
					}
				}
				caseExpression.reset();
			}else{
				Error.addEvaluationError("None of the case conditions is satisfied.");
				svar.setData(new IntDouble(1.0, false));
			}
		}
	}
		
	public void processTimeseries(){
		ModelDataSet mds=ControlData.currModelDataSet;
		ArrayList<String> tsList = mds.tsList;
		Map<String, Timeseries> tsMap =mds.tsMap;
		ControlData.currEvalTypeIndex=5;
		for (String tsName:tsList){
			ControlData.currEvalName=tsName;
			//System.out.println("process timeseries "+tsName);
			Timeseries ts=tsMap.get(tsName);
			ts.setData(new IntDouble(Evaluation.timeseries(tsName),false));
		}
	}
	
	public void processDvar(){
		ModelDataSet mds=ControlData.currModelDataSet;
		ArrayList<String> dvList = mds.dvList;
		Map<String, Dvar> dvMap =mds.dvMap;
		SolverData.setDvarMap(dvMap);
		ControlData.currDvMap=dvMap;
		ControlData.currEvalTypeIndex=1;
		for (String dvName: dvList){
			ControlData.currEvalName=dvName;
			//System.out.println("Process dvar "+dvName);
			Dvar dvar=dvMap.get(dvName);
			
			ValueEvaluatorParser evaluator=dvar.lowerBoundParser;
			try {
				evaluator.evaluator();
				dvar.lowerBoundValue=evaluator.evalValue.getData();
			} catch (RecognitionException e) {
				Error.addEvaluationError("Lowerbound evaluation has error.");
				dvar.lowerBoundValue=-901.0;
			}
			evaluator.reset();
			
			evaluator =dvar.upperBoundParser;
			try {
				evaluator.evaluator();
				dvar.upperBoundValue=evaluator.evalValue.getData();
			} catch (RecognitionException e) {
				Error.addEvaluationError("Lowerbound evaluation has error.");
				dvar.lowerBoundValue=-901.0;
			}
			evaluator.reset();
		}
	}
	
	public void processGoal(){
		ModelDataSet mds=ControlData.currModelDataSet;
		ArrayList<String> gList = mds.gList;
		Map<String, Goal> gMap =mds.gMap;
		ControlData.currEvalTypeIndex=3;
		SolverData.clearConstraintDataMap();
		for (String goalName: gList){
			ControlData.currEvalName=goalName;
			//System.out.println("Process constraint "+goalName);
			Goal goal=gMap.get(goalName);
			ArrayList<ValueEvaluatorParser> caseConditions=goal.caseConditionParsers;
			boolean condition=false;
			int i=-1;
			while(!condition && i<=caseConditions.size()-2){
				i=i+1;
				ValueEvaluatorParser caseCondition=caseConditions.get(i);
				try{
					caseCondition.evaluator();
					condition=caseCondition.evalCondition;
				}catch (Exception e){
					Error.addEvaluationError("Case condition evaluation has error.");
					condition=false;
				}
				caseCondition.reset();
			}
			if (condition){		
				ArrayList<EvaluatorParser> caseExpressions=goal.caseExpressionParsers;
				EvaluatorParser caseExpression=caseExpressions.get(i);				
				try {
					caseExpression.evaluator();
					SolverData.getConstraintDataMap().put(goalName,caseExpression.evalConstraint);
				} catch (RecognitionException e) {
					Error.addEvaluationError("Case expression evaluation has error.");
				}
				caseExpression.reset();
				
				// add slack or surplus as dvar and weight
				if (goal.dvarWeightMapList.size()>i && goal.dvarWeightMapList.get(i)!=null ){
					
					Map<String,String> dwm = goal.dvarWeightMapList.get(i);
					
					try {
						for (String d : dwm.keySet()){
							
							WeightElement wt = new WeightElement();
							wt.weight = dwm.get(d).toLowerCase();
							
							// preEvaluate
							String evalString="v: "+dwm.get(d).toLowerCase();
							ANTLRStringStream stream = new ANTLRStringStream(evalString);
							ValueEvaluatorLexer lexer = new ValueEvaluatorLexer(stream);
							TokenStream tokenStream = new CommonTokenStream(lexer);
							wt.weightParser = new ValueEvaluatorParser(tokenStream);
							
							// add to weight map
							mds.wtMap.put(d.toLowerCase(), wt);
							mds.wtList.add(d.toLowerCase());
					
						}
						
					} catch (Exception e) {
						Error.addEvaluationError("Case slack or surplus weight evaluation has error.");
					}
				}
			}
		}
	}
	
	public void processAlias(){
		ModelDataSet mds=ControlData.currModelDataSet;
		ArrayList<String> asList = mds.asList;
		Map<String, Alias> asMap =mds.asMap;
		ControlData.currEvalTypeIndex=2;
		Map<String, Map<String, IntDouble>> varCycleValueMap=ControlData.currStudyDataSet.getVarCycleValueMap();
		Set<String> aliasUsedByLaterCycle = mds.aliasUsedByLaterCycle;
		String model=ControlData.currCycleName;
		for (String asName: asList){
			ControlData.currEvalName=asName;
			//System.out.println("Process alias "+asName);
			Alias alias=asMap.get(asName);
			
			ValueEvaluatorParser evaluator = alias.expressionParser;
			try {
				evaluator.evaluator();
				IntDouble id=evaluator.evalValue;
				alias.data=id;
				if (aliasUsedByLaterCycle.contains(asName)){
					varCycleValueMap.get(asName).put(model, id);
				}
				if (!DataTimeSeries.dvAliasTS.containsKey(asName)){
					DssDataSetFixLength dds=new DssDataSetFixLength();
					double[] data=new double[ControlData.totalTimeStep];
					dds.setData(data);
					dds.setTimeStep(ControlData.partE);
					dds.setStartTime(ControlData.startTime);
					dds.setUnits(alias.units);
					dds.setKind(alias.kind);
					DataTimeSeries.dvAliasTS.put(asName,dds);
				}
				double[] dataList=DataTimeSeries.dvAliasTS.get(asName).getData();
				dataList[ControlData.currTimeStep]=id.getData().doubleValue();
			} catch (RecognitionException e) {
				Error.addEvaluationError("Alias evaluation has error.");
				IntDouble id=new IntDouble(-901.0,false);
				alias.data=id;
				if (aliasUsedByLaterCycle.contains(asName)){
					varCycleValueMap.get(asName).put(model, id);
				}
				double[] dataList=DataTimeSeries.dvAliasTS.get(asName).getData();
				dataList[ControlData.currTimeStep]=-901.0;
			}
			evaluator.reset();
		}
	}
	 
}

