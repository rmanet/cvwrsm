package wrimsv2.wreslplus.elements.procedures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import wrimsv2.commondata.wresldata.Dvar;
import wrimsv2.commondata.wresldata.External;
import wrimsv2.commondata.wresldata.Goal;
import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.commondata.wresldata.Param;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.commondata.wresldata.Svar;
import wrimsv2.commondata.wresldata.Timeseries;
import wrimsv2.commondata.wresldata.WeightElement;
import wrimsv2.wreslplus.elements.AliasTemp;
import wrimsv2.wreslplus.elements.DvarTemp;
import wrimsv2.wreslplus.elements.ExternalTemp;
import wrimsv2.wreslplus.elements.GoalCase;
import wrimsv2.wreslplus.elements.GoalTemp;
import wrimsv2.wreslplus.elements.IncFileTemp;
import wrimsv2.wreslplus.elements.ModelTemp;
import wrimsv2.wreslplus.elements.SequenceTemp;
import wrimsv2.wreslplus.elements.StudyTemp;
import wrimsv2.wreslplus.elements.SvarTemp;
import wrimsv2.wreslplus.elements.TimeseriesTemp;
import wrimsv2.wreslplus.elements.Tools;
import wrimsv2.wreslplus.elements.WeightTable;
import wrimsv2.wreslplus.elements.WeightTemp;

public class ToLowerCase {
	
	
	private ToLowerCase(){}

	
	//TODO: model must be in sequence obj, also condition not linked yet
	public static void convert (StudyTemp s){		

		// sequence
		for (String key : s.seqList) {
			SequenceTemp n = s.seqMap.get(key);
			s.seqMap.remove(key);
			s.seqMap.put( key.toLowerCase(), sequence(n));
		}
		s.seqList = Tools.allToLowerCase(s.seqList);
		// model
		for (String key : s.modelList) {
			ModelTemp n = s.modelMap.get(key);
			s.modelMap.remove( key);
			convert(n);
			s.modelMap.put( key.toLowerCase(), n);
		}
		s.modelList = Tools.allToLowerCase(s.modelList);
	}	
	
	public static SequenceTemp sequence (SequenceTemp w){
		
		SequenceTemp o = new SequenceTemp();
		
		o.id = w.id;
		o.model = w.model.toLowerCase();
		o.condition = w.condition.toLowerCase();
		o.order = w.order.toLowerCase();
		
		return o;
	
	}


	public static void convert (ModelTemp j){
		
		for (String key : j.svList) {
			SvarTemp o = svar(j.svMap.get(key));
			j.svMap.remove(key);
			j.svMap.put( key.toLowerCase(), o);
		}
		for (String key : j.dvList) {
			DvarTemp o = dvar(j.dvMap.get(key));
			j.dvMap.remove(key);
			j.dvMap.put( key.toLowerCase(), o);
		}
		for (String key : j.tsList) {
			TimeseriesTemp o = timeseries(j.tsMap.get(key));
			j.tsMap.remove(key);
			j.tsMap.put( key.toLowerCase(), o);
		}
		for (String key : j.exList) {
			ExternalTemp o = external(j.exMap.get(key));
			j.exMap.remove(key);
			j.exMap.put( key.toLowerCase(), o);
		}
		for (String key : j.glList) {
			GoalTemp o = goal(j.glMap.get(key));
			j.glMap.remove(key);
			j.glMap.put( key.toLowerCase(), o);
		}
//		for (String key : j.ssList) {
//			DvarTemp o = dvar(j.ssMap.get(key));
//			j.ssMap.remove(key);
//			j.ssMap.put( key.toLowerCase(), o);
//		}
//		for (String key : j.ssList) {
//			WeightTemp o = weight(j.ssWeightMap_hasCase.get(key));
//			j.ssWeightMap_hasCase.remove(key);
//			j.ssWeightMap_hasCase.put( key.toLowerCase(), o);
//		}
		for (String key : j.asList) {	
			AliasTemp o = alias(j.asMap.get(key));
			j.asMap.remove(key);
			j.asMap.put( key.toLowerCase(), o);
		}		
		for (int i=0; i<j.wTableObjList.size();i++) {	
			WeightTable o = weightTable(j.wTableObjList.get(i));
			j.wTableObjList.remove(i);
			j.wTableObjList.add(i, o);
		}
		for (String key : j.incFileIDList) {	
			IncFileTemp o = incFile(j.incFileMap.get(key));
			j.incFileMap.remove(key);
			j.incFileMap.put( key.toLowerCase(), o);
		}	
		
		//j.svIncFileList = Tools.allToLowerCase(j.svIncFileList);
		j.incModelList = Tools.allToLowerCase(j.incModelList);
		j.incFileIDList=Tools.allToLowerCase(j.incFileIDList);
		j.itemList = Tools.allToLowerCase(j.itemList);
		j.svList = Tools.allToLowerCase(j.svList);
		j.dvList = Tools.allToLowerCase(j.dvList);
		j.dvList_fromAlias = Tools.allToLowerCase(j.dvList_fromAlias);
		j.glList = Tools.allToLowerCase(j.glList);
		j.gl2List = Tools.allToLowerCase(j.gl2List);
		j.glList_fromAlias = Tools.allToLowerCase(j.glList_fromAlias);
		j.tsList = Tools.allToLowerCase(j.tsList);
		//j.ssList = Tools.allToLowerCase(j.ssList);
		j.exList = Tools.allToLowerCase(j.exList);
		j.asList = Tools.allToLowerCase(j.asList);
		//j.asList_reduced = Tools.allToLowerCase(j.asList_reduced);
		j.wvList_defaultType = Tools.allToLowerCase(j.wvList_defaultType);
		
		
	}

	public static SvarTemp svar (SvarTemp s){
		
		SvarTemp o = new SvarTemp();
		
		o.id = s.id;
		o.fromWresl = s.fromWresl.toLowerCase();
		o.kind = s.kind.toLowerCase();
		o.units = s.units.toLowerCase();
		o.caseName = Tools.allToLowerCase(s.caseName);
		o.dependants = Tools.allToLowerCase(s.dependants);
		o.neededVarInCycleSet = Tools.allToLowerCase(s.neededVarInCycleSet);
		o.needVarFromEarlierCycle = s.needVarFromEarlierCycle;
		
		o.caseCondition = Tools.allToLowerCase(s.caseCondition);
		o.caseCondition = Tools.replace_with_space(o.caseCondition);
		//o.caseCondition = Tools.replace_seperator(o.caseCondition);
		o.caseCondition = Tools.add_space_between_logical(o.caseCondition);
		
		o.caseExpression = Tools.allToLowerCase(s.caseExpression);
		o.caseExpression = Tools.replace_with_space(o.caseExpression);
		//o.caseExpression = Tools.replace_seperator(o.caseExpression);
		o.caseExpression = Tools.add_space_between_logical(o.caseExpression);
		
		return o;
		
	}	
	
	public static TimeseriesTemp timeseries (TimeseriesTemp t){
		
		TimeseriesTemp o = new TimeseriesTemp();
		
		o.id = t.id;
		o.fromWresl = t.fromWresl.toLowerCase();
		o.dssBPart = t.dssBPart.toLowerCase();
		o.convertToUnits = t.convertToUnits.toLowerCase();
		o.kind = t.kind.toLowerCase();
		o.units = t.units.toLowerCase();
		
		return o;
		
	}
	
	public static DvarTemp dvar (DvarTemp d){
		
		DvarTemp o = new DvarTemp();
		
		o.id = d.id;
		o.fromWresl = d.fromWresl.toLowerCase();
		o.lowerBound = d.lowerBound.toLowerCase();
		o.upperBound = d.upperBound.toLowerCase();
		o.kind = d.kind.toLowerCase();
		o.units = d.units.toLowerCase();
		o.condition = d.condition.toLowerCase();
		
		o.isInteger = d.isInteger;
		o.isFromAlias = d.isFromAlias;
		
		return o;
	}


	public static WeightTemp weight (WeightTemp w){
		
		WeightTemp o = new WeightTemp();
		
		o.id = w.id;
		o.fromWresl = w.fromWresl.toLowerCase();
		o.condition = w.condition.toLowerCase();
		o.weight = w.weight.toLowerCase();
		
		return o;

	}

	
	public static WeightTable weightTable (WeightTable w){
		
		WeightTable o = new WeightTable();
		
		o.id = w.id;
		o.line = w.line;
		o.fromWresl = w.fromWresl.toLowerCase();
		o.condition = w.condition.toLowerCase();
		o.varList = Tools.allToLowerCase(w.varList);
		o.varWeightMap = Tools.allToLowerCase_string(w.varWeightMap);
		o.subgroupMap = Tools.allToLowerCase_weightSubgroup(w.subgroupMap);
		o.dependants = Tools.allToLowerCase(w.dependants);
		o.commonWeight = w.commonWeight.toLowerCase();
		o.commonPenalty = w.commonPenalty.toLowerCase();
		o.isWeightGroup = w.isWeightGroup;
		
		return o;

	}
	

	public static ExternalTemp external (ExternalTemp e){
		
		ExternalTemp o = new ExternalTemp();
		
		o.id = e.id;
		o.fromWresl = e.fromWresl.toLowerCase();
		o.fileName = e.fileName.toLowerCase();
		
		return o;
		
	}

	// GoalCase is not converted to lowercase
	public static GoalTemp goal (GoalTemp g){

		// TODO: convert fields in class GoalCase to lowercase 
		
		GoalTemp o = new GoalTemp();

		ArrayList<String> cn = new ArrayList<String>(g.caseMap.keySet());
		for (String key: cn){		
			GoalCase gc = goalCase(g.caseMap.get(key));
			//g.caseMap.remove(key);
			o.caseMap.put( key.toLowerCase(), gc);	
		}
			
		o.id = g.id;
		o.fromWresl = g.fromWresl.toLowerCase();
		o.caseName = Tools.allToLowerCase(g.caseName);
		o.dependants = Tools.allToLowerCase(g.dependants);
		o.neededVarInCycleSet = Tools.allToLowerCase(g.neededVarInCycleSet);
		o.needVarFromEarlierCycle = g.needVarFromEarlierCycle;

		o.hasCase = g.hasCase;
		o.hasLhs = g.hasLhs;
		
		if (g.hasLhs) {
			
			o.lhs = g.lhs.toLowerCase();
		
		} else {  // simple goal
		
			o.caseCondition = Tools.allToLowerCase(g.caseCondition);
			o.caseCondition = Tools.replace_with_space(o.caseCondition);
			//o.caseCondition = Tools.replace_seperator(o.caseCondition);
			o.caseCondition = Tools.add_space_between_logical(o.caseCondition);
			
			o.caseExpression = Tools.allToLowerCase(g.caseExpression);
			o.caseExpression = Tools.replace_with_space(o.caseExpression);
			//o.caseExpression = Tools.replace_seperator(o.caseExpression);
			o.caseExpression = Tools.add_space_between_logical(o.caseExpression);
		
		}
		
		return o;
				
	}


	public static AliasTemp alias (AliasTemp d){
		
		AliasTemp o = new AliasTemp();
		
		o.id = d.id;
		o.fromWresl = d.fromWresl.toLowerCase();
		o.expression = d.expression.toLowerCase();
		o.kind = d.kind.toLowerCase();
		o.units = d.units.toLowerCase();
		o.condition = d.condition.toLowerCase();
		o.dependants = Tools.allToLowerCase(d.dependants);
		o.neededVarInCycleSet = Tools.allToLowerCase(d.neededVarInCycleSet);
		o.needVarFromEarlierCycle = d.needVarFromEarlierCycle;
		o.isMovedToDvar = d.isMovedToDvar;

		
		return o;
	}


	public static GoalCase goalCase (GoalCase d){
		
		GoalCase o = new GoalCase();
		
		o.id = d.id;
		o.rhs = d.rhs.toLowerCase();
		o.lhs_gt_rhs = d.lhs_gt_rhs.toLowerCase();
		o.lhs_lt_rhs = d.lhs_lt_rhs.toLowerCase();
		o.condition = d.condition.toLowerCase();

		
		return o;
	}


	public static IncFileTemp incFile (IncFileTemp w){
		
		if (w==null) return null;
		
		IncFileTemp o = new IncFileTemp();
		
		o.id = w.id;
		o.rawPath = w.rawPath.toLowerCase();
		
		return o;
	
	}

}
	