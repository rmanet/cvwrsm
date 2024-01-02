
package test.test_wreslparser;

import java.io.File;
import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;


import test.test_wreslplus.TestParam;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.elements.RegUtils;
import wrimsv2.wreslparser.elements.StudyConfig;
import wrimsv2.wreslparser.elements.StudyParser;
import wrimsv2.wreslparser.elements.StudyUtils;
import wrimsv2.wreslparser.elements.TempData;
import wrimsv2.wreslparser.elements.Tools;
import wrimsv2.wreslparser.elements.WriteCSV;

public class TestWreslWalker_error {
	
	public String projectPath = "src\\test\\test_wreslparser\\wresl_files\\";	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;
	public String testName;	
	
	@Test(groups = { "WRESL_elements" })
	public void redefine2() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_error_redefine2";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";

		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();

		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td,false,false);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 

		LogUtils.studySummary_details(sd);

		LogUtils.closeLogFile();
		
		//String modelName = sd.getModelList().get(1);
		
		WriteCSV.study(sd,csvFolderPath ) ;
	
		String logText = Tools.readFileAsString(logFilePath);	

		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 16);	
		
		Assert.assertEquals(StudyParser.total_errors, 16);
		
		StudyUtils.checkStudy(absFilePath);
		Assert.assertEquals(StudyUtils.total_errors, 16);	
		
		Assert.assertEquals(sd.getModelDataSetMap().get("second").tsMap.get("ts").kind,"second-model-only" );
		Assert.assertEquals(sd.getModelDataSetMap().get("second").svMap.get("sv").caseExpression.get(0),"second_model_only" );
		Assert.assertEquals(sd.getModelDataSetMap().get("second").svMap.get("sv2").caseCondition.get(0),"second-mmodel-only>0" );
		Assert.assertEquals(sd.getModelDataSetMap().get("second").dvMap.get("dv").kind,"second-model-only" );
		Assert.assertEquals(sd.getModelDataSetMap().get("second").dvMap.get("dv2").kind,"second-model-only" );
		Assert.assertEquals(sd.getModelDataSetMap().get("second").asMap.get("as").kind,"second-model-only" );
		Assert.assertEquals(sd.getModelDataSetMap().get("second").gMap.get("gl").caseCondition.get(0),"second-mmodel-only>0" );
		Assert.assertEquals(sd.getModelDataSetMap().get("second").svMap.get("tab").dependants.toString(),"[second_model_only]" );
		//		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).gList_local.get(0),"a2" );

	}

	@Test(groups = { "WRESL_elements" })
	public void redefine_global() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_error_redefine_global";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";
	
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();
	
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
	
		LogUtils.studySummary_details(sd);
	
		LogUtils.closeLogFile();
		
		//String modelName = sd.getModelList().get(1);
		
		WriteCSV.study(sd,csvFolderPath ) ;
	
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 15);	
		Assert.assertEquals(StudyParser.total_errors, 15);
		
		StudyUtils.checkStudy(absFilePath);
		Assert.assertEquals(StudyUtils.total_errors, 15);


	
	}

	@Test(groups = { "WRESL_elements" })
	public void redefine() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_error_redefine";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";
	
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();
	
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td,false,false);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
	
		LogUtils.studySummary_details(sd);
	
		LogUtils.closeLogFile();
		
		//String modelName = sd.getModelList().get(1);
		
		WriteCSV.study(sd,csvFolderPath ) ;
	
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 24);	
		
		Assert.assertEquals(StudyParser.total_errors, 24);
		
		StudyUtils.checkStudy(absFilePath);
		Assert.assertEquals(StudyUtils.total_errors, 24);
		
		Assert.assertEquals(sd.getModelDataSetMap().get("second").tsMap.get("ts").kind,"second-model-only" );
		Assert.assertEquals(sd.getModelDataSetMap().get("second").svMap.get("sv").caseExpression.get(0),"second_model_only" );
		Assert.assertEquals(sd.getModelDataSetMap().get("second").svMap.get("sv2").caseCondition.get(0),"second-mmodel-only>0" );
		Assert.assertEquals(sd.getModelDataSetMap().get("second").dvMap.get("dv").kind,"second-model-only" );
		Assert.assertEquals(sd.getModelDataSetMap().get("second").dvMap.get("dv2").kind,"second-model-only" );
		Assert.assertEquals(sd.getModelDataSetMap().get("second").asMap.get("as").kind,"second-model-only" );
		Assert.assertEquals(sd.getModelDataSetMap().get("second").gMap.get("gl").caseCondition.get(0),"second-mmodel-only>0" );
		Assert.assertEquals(sd.getModelDataSetMap().get("second").svMap.get("tab").dependants.toString(),"[second_model_only]" );
		//		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).gList_local.get(0),"a2" );
	
	}	
}
