package test.test_wreslplus;

import java.io.File;
import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.elements.RegUtils;
import wrimsv2.wreslparser.elements.Tools;
import wrimsv2.wreslparser.elements.WriteCSV;
import wrimsv2.wreslplus.elements.StudyTemp;
import wrimsv2.wreslplus.elements.Workflow;
import wrimsv2.wreslplus.elements.procedures.ToWreslData;


public class TestWreslPlus_includeModel {
	
	public String projectPath = TestParam.projectPath_wp;	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;
	public String testName;	
	
	@Test(groups = { "WRESLPLUS_elements" })
	public void includeModel1() throws RecognitionException, IOException {
		
	
		testName = "TestWreslPlus_includeModel1";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_wreslplus2\\"+testName;
		
		inputFilePath = projectPath + testName + TestParam.fileExt;
		logFilePath = csvFolderPath + ".log";
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		StudyTemp styTemp=Workflow.checkStudy(absFilePath);
		
		//StudyDataSet sd = ToWreslData.convertStudy(styTemp);
		
		//WriteCSV.study(sd, this.csvFolderPath);
		
		LogUtils.closeLogFile();
	
		String logText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 1);		

		int Err = RegUtils.timesOfMatches(logText, "Error: Include model \\[Inc2_typo\\] not exist in model \\[iNc\\]");
		Assert.assertEquals(Err, 1);	
	}

	@Test(groups = { "WRESLPLUS_elements" })
	public void includeModel2() throws RecognitionException, IOException {
		
	
		testName = "TestWreslPlus_includeModel2";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_wreslplus2\\"+testName;
		
		inputFilePath = projectPath + testName + TestParam.fileExt;
		logFilePath = csvFolderPath + ".log";
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		StudyTemp styTemp=Workflow.checkStudy(absFilePath);
		
		//StudyDataSet sd = ToWreslData.convertStudy(styTemp);
		
		//WriteCSV.study(sd, this.csvFolderPath);
		
		LogUtils.closeLogFile();
	
		String logText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 1);		
	
		int Err = RegUtils.timesOfMatches(logText, "# Error: Model \\[inc2\\] redefined in main file.");
		Assert.assertEquals(Err, 1);	
	}

	@Test(groups = { "WRESLPLUS_elements" })
	public void includeModel3() throws RecognitionException, IOException {
		
	
		testName = "TestWreslPlus_includeModel3";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_wreslplus2\\"+testName;
		
		inputFilePath = projectPath + testName + TestParam.fileExt;
		logFilePath = csvFolderPath + ".log";
		LogUtils.setLogFile(logFilePath);
		
		File absFile = new File(inputFilePath).getAbsoluteFile();
		String absFilePath = absFile.getCanonicalPath().toLowerCase();
		
		StudyTemp styTemp=Workflow.checkStudy(absFilePath);
		
		//StudyDataSet sd = ToWreslData.convertStudy(styTemp);
		
		//WriteCSV.study(sd, this.csvFolderPath);
		
		LogUtils.closeLogFile();
	
		String logText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
		Assert.assertEquals(totalErrs, 0);		
	
//		// var name same as model name
//		int Err = RegUtils.timesOfMatches(logText, "# Error: ---");
//		Assert.assertEquals(Err, 1);	
	}
}
