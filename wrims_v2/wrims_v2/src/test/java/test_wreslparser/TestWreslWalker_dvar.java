
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
import wrimsv2.wreslparser.elements.TempData;
import wrimsv2.wreslparser.elements.Tools;
import wrimsv2.wreslparser.elements.WriteCSV;

public class TestWreslWalker_dvar {
	
	public String projectPath = "src\\test\\test_wreslparser\\wresl_files\\";	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;
	public String testName;	
	
	@Test(groups = { "WRESL_elements" })
	public void negation() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_dvar_negation";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_v1\\"+testName;
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
		
		String modelName = sd.getModelList().get(0);
		
		WriteCSV.study(sd,csvFolderPath ) ;
		
		String logText = Tools.readFileAsString(logFilePath);	

		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 0);	
		
	
		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\dvar.csv");	
		
		String s;
		int n;
	
		s ="dvar_global,##always,-99999,999999,n,cfs,channel";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);

		
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).dvList_global.get(0),"dvar_global" );
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).dvList_local.get(0),"dvar_local" );
	}
	
	@Test(groups = { "WRESL_elements" })
	public void globalShare() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_dvar_globalShare";
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
		
		sd.getModelDataSetMap().get("second").dvMap.get("x").kind = "overwritten";
		
		WriteCSV.study(sd, this.csvFolderPath);

		String originalKind = sd.getModelDataSetMap().get("first").dvMap.get("x").kind;
		
		Assert.assertEquals(originalKind, "overwritten");	

	}

	@Test(groups = { "WRESL_elements" })
	public void nonStd() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_dvar_nonStd";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_v1\\"+testName;
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
		
		String modelName = sd.getModelList().get(0);
		
		WriteCSV.study(sd, csvFolderPath) ;
		
		String logText = Tools.readFileAsString(logFilePath);	
	
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 0);	
		
	
		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\dvar.csv");	
		
		String s;
		int n;
	
		s = "c_slcvp,##always,lower_unbounded,upper_unbounded,n,cfs,flow-channel";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
	
		s = "c_sacfea,##always,0,8+(6150*taf_cfs),n,cfs,flow-channel";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
	
		s = "d852_sb_lcp_err,##always,lower_unbounded,upper_unbounded";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
		
		s = "negative_dvar,##always,-333,-99";
		s = Tools.replace_regex(s);
		n = RegUtils.timesOfMatches(csvText, s );
		Assert.assertEquals(n, 1);
	}

	@Test(groups = { "WRESL_elements" })
	public void std() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_dvar_std";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_v1\\"+testName;
		inputFilePath = projectPath + testName+".wresl";
		logFilePath = csvFolderPath+".log";
		
				
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		TempData td = new TempData();
	
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
		
		td.model_dataset_map=StudyParser.parseModels(sc,td);
		
		StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
		
		LogUtils.closeLogFile();
		
		WriteCSV.study(sd, csvFolderPath) ;
		
		String fileText = Tools.readFileAsString(logFilePath);
		int redefineErrs = RegUtils.timesOfMatches(fileText, "# Error: Dvar redefined: c_banks");
		int totalErrs = RegUtils.timesOfMatches(fileText, "# Error:");
		Assert.assertEquals(redefineErrs, 1);
		Assert.assertEquals(totalErrs, 2);		
	}
	
}
