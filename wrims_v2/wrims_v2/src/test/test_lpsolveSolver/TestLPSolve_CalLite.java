package test.test_lpsolveSolver;

import java.io.IOException;

import org.antlr.runtime.RecognitionException;
import org.testng.annotations.Test;

import wrimsv2.components.Controller;

public class TestLPSolve_CalLite {
	
	private double tolerance_perc = 0.1/1000000; // 0.1 ppm
	private String logFilePath;	
	private String studyPath;	
	private String dssPath;	
	private String objMatchString = "L P   O P T I M A L   S O L U T I O N ---> OBJ:\\s+\\d+.\\d+";
	private double expected;
	
	@Test(groups = { "xa_solver_example_studies" })
	public void example1_step1() throws RecognitionException, IOException{
		
		studyPath = "D:\\cvwrsm\\CalLite_Beta_071511_newsv\\run\\";
		dssPath = "D:\\cvwrsm\\CalLite_Beta_071511_newsv\\DSS\\";
		
		/// set control data		
		String[] controlDataString = {
		studyPath + "gw",
		studyPath + "main_BO.wresl",
		dssPath +   "CL_FUTURE_BO_080911_SV.dss",
		dssPath +   "CalLite2020D09EINIT.dss",
		dssPath +   "LPSolve_FutureDV.dss",

		"CALSIM",
		"2020D09E",
		"CALSIM",
		"1MON",
		"1921",
		"10",
		 "31",
		 "1922",
		 "10",
		 "31", 
		 "Gurobi", 
		 "csv_Example1"};
		
        new Controller(controlDataString);

		// TODO: compare objective function value 
        // wrims v1 XA16 OBJ: 41169932.383266 
        // wrims v2 XA16 OBJ: 41169932.835543
        
        expected = 41169932.383266;
        
        
//        logFilePath = studyPath+"run//xa.log";
//		String logText = Tools.readFileAsString(logFilePath);	
//
//		int n = RegUtils.timesOfMatches(logText, objMatchString);
//		Assert.assertEquals(n, 1);
//		
//		String line = RegUtils.getLastMatch(logText, objMatchString);
//		String value = RegUtils.getLastMatch(line, "\\d+.\\d+");
//		
//		double obj_value =  Double.parseDouble(value);
//		
//		Assert.assertEquals(obj_value, expected, expected*tolerance_perc);	

	}
}