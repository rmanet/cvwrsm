
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

public class TestWreslWalker_timeseries {
	
	public String projectPath = "src\\test\\test_wreslparser\\wresl_files\\";	
	public String inputFilePath;
	public String logFilePath;	
	public String csvFolderPath;
	public String testName;	
	
	@Test(groups = { "WRESL_elements" })
		public void dss() throws RecognitionException, IOException {
			
			testName = "TestWreslWalker_timeseries_dss";
			csvFolderPath = TestParam.csvFolderPrepend + "testResult_v1\\"+testName;
			inputFilePath = projectPath + testName + ".wresl";
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
			
			WriteCSV.study(sd, csvFolderPath ) ;
		
			String logText = Tools.readFileAsString(logFilePath);	
			
			int totalErrs = RegUtils.timesOfMatches(logText, "# Error:");
			Assert.assertEquals(totalErrs, 0);	
			
			String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\timeseries.csv");	
	
			int r1 = RegUtils.timesOfMatches(csvText, "complex.+ud_ccwd.+demand-cvp.+taf.+cfs");
			Assert.assertEquals(r1, 1);	
			
			Assert.assertEquals(sd.getModelDataSetMap().get(modelName).tsList_global.get(0),"simple" );
			Assert.assertEquals(sd.getModelDataSetMap().get(modelName).tsList_local.get(0),"complex" );
		}

	@Test(groups = { "WRESL_elements" })
	public void dss2() throws RecognitionException, IOException {
		
		testName = "TestWreslWalker_timeseries_dss2";
		csvFolderPath = TestParam.csvFolderPrepend + "testResult_v1\\"+testName;
		inputFilePath = projectPath + testName + ".wresl";
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
		
		WriteCSV.study(sd, csvFolderPath ) ;
	
		String logText = Tools.readFileAsString(logFilePath);	
		
		int totalErrs = RegUtils.timesOfMatches(logText, "# Error:");
		Assert.assertEquals(totalErrs, 0);	
		
		String csvText = Tools.readFileAsString(csvFolderPath+"\\first\\timeseries.csv");	
	
		int r1 = RegUtils.timesOfMatches(csvText, "complex.+ud_ccwd.+demand-cvp.+taf.+cfs");
		Assert.assertEquals(r1, 1);	
		
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).tsList_global.get(0),"simple" );
		Assert.assertEquals(sd.getModelDataSetMap().get(modelName).tsList_local.get(0),"complex" );
	}
}
