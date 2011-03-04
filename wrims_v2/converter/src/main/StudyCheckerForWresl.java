package main;

import java.io.IOException;
import org.antlr.runtime.RecognitionException;

import components_tree.LogUtils;
import components_tree.StudyConfig;
import components_tree.StudyParser;

public class StudyCheckerForWresl {
	
	
	public static void main(String[] args) throws RecognitionException, IOException {

		String f;
		
		if (args.length > 0 ){
			f = args[0];
		} else {
			f = "D:\\cvwrsm\\trunk\\wrims_v2\\converter\\src\\test\\TestWreslWalker_mainFile2.wresl";
		}
		
		//System.out.println("main file: "+f);

		LogUtils.setLogFile("studyChecker.log");
		StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(f);
		StudyParser.parseSubFiles(sc);
		

		
		LogUtils._logFile.close();
		

	}

}
