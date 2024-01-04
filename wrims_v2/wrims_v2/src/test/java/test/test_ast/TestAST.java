
package test.test_ast;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.testng.annotations.Test;

import wrimsv2.commondata.wresldata.Svar;

import wrimsv2.evaluator.EvalConstraint;
import wrimsv2.evaluator.EvalExpression;
import wrimsv2.evaluator.EvaluatorLexer;
import wrimsv2.evaluator.EvaluatorParser;
import wrimsv2.evaluator.TableOperation;
import wrimsv2.evaluator.ValueEvaluatorTreeLexer;
import wrimsv2.evaluator.ValueEvaluatorTreeParser;
import wrimsv2.evaluator.ValueEvaluatorTreeWalker;
import wrimsv2.external.LoadAllDll;
import wrimsv2.components.ControlData;
import wrimsv2.components.Error;
import wrimsv2.components.FilePaths;
import wrimsv2.components.IntDouble;

public class TestAST extends TestCase{
	
	
	public String inputFilePath;
	public String logFilePath;
	
	public void testRelationStatement() throws RecognitionException, IOException {
		ANTLRStringStream stream = new ANTLRStringStream("g: (2+a)*3.4-(5+6*7.0)*b+4*f<(2+b)*6+3*f");
		EvaluatorLexer lexer = new EvaluatorLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		EvaluatorParser evaluator = new EvaluatorParser(tokenStream);
		evaluator.evaluator();
		EvalConstraint ec=evaluator.evalConstraint;
		EvalExpression ee=ec.getEvalExpression();
		System.out.println(ec.getSign());
		System.out.println(ee.getValue().getData());
		System.out.println(ee.getMultiplier().get("a").getData());
		System.out.println(ee.getMultiplier().get("b").getData());
		System.out.println(ee.getMultiplier().get("f").getData());
	}

	public void testInternalFunctions() throws RecognitionException, IOException {
		ANTLRStringStream stream = new ANTLRStringStream("g: max(4;-3)*a+min(3.1;100.2)*b+pow(3;abs(-2))*c+int(5.43)*d+log(2)*e<log10(10.0)");
		EvaluatorLexer lexer = new EvaluatorLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		EvaluatorParser evaluator = new EvaluatorParser(tokenStream);
		evaluator.evaluator();
		EvalConstraint ec=evaluator.evalConstraint;
		EvalExpression ee=ec.getEvalExpression();
		System.out.println(ec.getSign());
		System.out.println(ee.getValue().getData());
		System.out.println(ee.getMultiplier().get("a").getData());
		System.out.println(ee.getMultiplier().get("b").getData());
		System.out.println(ee.getMultiplier().get("c").getData());
		System.out.println(ee.getMultiplier().get("d").getData());
		System.out.println(ee.getMultiplier().get("e").getData());
	}

	public void testConditionStatement() throws RecognitionException, IOException {
        String mainFile="z:\\temp\\test";
        FilePaths fp=new FilePaths();
        fp.setMainFilePaths(mainFile);
		
		ANTLRStringStream stream = new ANTLRStringStream("c: (6+8)*4>(3-2) .and. 100-4<3");
		ValueEvaluatorTreeLexer lexer = new ValueEvaluatorTreeLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ValueEvaluatorTreeParser evaluator = new ValueEvaluatorTreeParser(tokenStream);
		ValueEvaluatorTreeParser.evaluator_return parser_evaluator = evaluator.evaluator();
		CommonTree commonTree = (CommonTree) parser_evaluator.getTree();
		System.out.println(commonTree.toStringTree());
		
		CommonTreeNodeStream nodeStream = new CommonTreeNodeStream(commonTree);
		nodeStream.setTokenStream(tokenStream); 
		ValueEvaluatorTreeWalker walker = new ValueEvaluatorTreeWalker(nodeStream);
		
		walker.evaluator();
		boolean eCondition=walker.evalCondition;
		if (eCondition){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
	
		Error.writeEvaluationErrorFile("log.txt");
	}
	
	@Test
	public void testAST() throws RecognitionException, IOException {
        String mainFile="z:\\temp\\test";
        FilePaths fp=new FilePaths();
        fp.setMainFilePaths(mainFile);
		
		ANTLRStringStream stream = new ANTLRStringStream("v: select flow from trinity_import where month=month;trinity_lev=trinity_level;shasta_lev=shasta_level");
		ValueEvaluatorTreeLexer lexer = new ValueEvaluatorTreeLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ValueEvaluatorTreeParser evaluator = new ValueEvaluatorTreeParser(tokenStream);
		ValueEvaluatorTreeParser.evaluator_return parser_evaluator = evaluator.evaluator();
		CommonTree commonTree = (CommonTree) parser_evaluator.getTree();
		System.out.println(commonTree.toStringTree());
		
		CommonTreeNodeStream nodeStream = new CommonTreeNodeStream(commonTree);
		nodeStream.setTokenStream(tokenStream); 
		ValueEvaluatorTreeWalker walker = new ValueEvaluatorTreeWalker(nodeStream);
		
		walker.evaluator();
		boolean eCondition=walker.evalCondition;
		if (eCondition){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
	
		Error.writeEvaluationErrorFile("log.txt");
	}

	public void testExternalFunction() throws RecognitionException, IOException {
        new LoadAllDll();

        String mainFile="z:\\temp\\test";
        FilePaths fp=new FilePaths();
        fp.setMainFilePaths(mainFile);
		
		ANTLRStringStream stream = new ANTLRStringStream("v: 1+annlinegen(6472.58740234; 8065.77587891; 9674.55859375; 7614.22070313; 1844.08239746; 829.421325684; 0.0; 2808.64648438;  1565.21533203; 799.454162598; 645.070129395; 816.196533203; 1269.01464844; 0.0; 26.0; 31.0; 31.0; 30.0; 1061.79003906; 3956.91992188; 3897.29638672; 2362.15014648; 1330.7467041; 200.450531006; 241.239242554; 0.0; 54.8862113953; -141; 330.817657471; 365.760253906; 384.316558838; 375.362304688; 346.135650635; 603.290405273; 648.479736328; 647.118896484; 647.933044434; 637.05291748; 31; 30; 31; 31; 30; 964.91; 10000; 12000; 2; 2; 1; 12; 1990; 3)");
		EvaluatorLexer lexer = new EvaluatorLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		EvaluatorParser evaluator = new EvaluatorParser(tokenStream);
		evaluator.evaluator();
		System.out.println(evaluator.evalValue.getData());
		
		Error.writeEvaluationErrorFile("log.txt");
	}

	public void testInteger() throws RecognitionException, IOException {

        String mainFile="z:\\temp\\test";
        FilePaths fp=new FilePaths();
        fp.setMainFilePaths(mainFile);
		
		ANTLRStringStream stream = new ANTLRStringStream("g: 3*a/2<1"); 
		EvaluatorLexer lexer = new EvaluatorLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		EvaluatorParser evaluator = new EvaluatorParser(tokenStream);
		evaluator.evaluator();
		System.out.println(evaluator.evalConstraint.getEvalExpression().getMultiplier().get("a").getData());
		
		Error.writeEvaluationErrorFile("log.txt");
	}

	public void testDaysIn() throws RecognitionException, IOException {

        String mainFile="z:\\temp\\test";
        FilePaths fp=new FilePaths();
        fp.setMainFilePaths(mainFile);
		
        ControlData.currMonth=2;
        ControlData.currYear=2000;
		ANTLRStringStream stream = new ANTLRStringStream("v: daysin"); 
		ValueEvaluatorTreeLexer lexer = new ValueEvaluatorTreeLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ValueEvaluatorTreeParser evaluator = new ValueEvaluatorTreeParser(tokenStream);
		ValueEvaluatorTreeParser.evaluator_return parser_evaluator = evaluator.evaluator();
		CommonTree commonTree = (CommonTree) parser_evaluator.getTree();
		System.out.println(commonTree.toStringTree());
		
		CommonTreeNodeStream nodeStream = new CommonTreeNodeStream(commonTree);
		nodeStream.setTokenStream(tokenStream); 
		ValueEvaluatorTreeWalker walker = new ValueEvaluatorTreeWalker(nodeStream);
		
		walker.evaluator();
		System.out.println(walker.evalValue.getData());
		
		Error.writeEvaluationErrorFile("log.txt");
	}

	public void testTafcfs() throws RecognitionException, IOException {

        String mainFile="z:\\temp\\test";
        FilePaths fp=new FilePaths();
        fp.setMainFilePaths(mainFile);
		
        ControlData.currMonth=4;
        ControlData.currYear=2000;
		ANTLRStringStream stream = new ANTLRStringStream("v: taf_cfs(-1)"); 
		ValueEvaluatorTreeLexer lexer = new ValueEvaluatorTreeLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ValueEvaluatorTreeParser evaluator = new ValueEvaluatorTreeParser(tokenStream);
		ValueEvaluatorTreeParser.evaluator_return parser_evaluator = evaluator.evaluator();
		CommonTree commonTree = (CommonTree) parser_evaluator.getTree();
		System.out.println(commonTree.toStringTree());
		
		CommonTreeNodeStream nodeStream = new CommonTreeNodeStream(commonTree);
		nodeStream.setTokenStream(tokenStream); 
		ValueEvaluatorTreeWalker walker = new ValueEvaluatorTreeWalker(nodeStream);
		
		walker.evaluator();
		System.out.println(walker.evalValue.getData());
		
		Error.writeEvaluationErrorFile("log.txt");
	}

	public void testTimeseries() throws RecognitionException, IOException {

        String mainFile="z:\\temp\\test";
        FilePaths fp=new FilePaths();
        fp.setMainFilePaths(mainFile);
		
        new ControlData();
        FilePaths.fullInitFilePath="D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\test\\test_evaluator\\2020D09EINIT.DSS";
		ANTLRStringStream stream = new ANTLRStringStream("v: cvp_sl(-1)"); 
		ValueEvaluatorTreeLexer lexer = new ValueEvaluatorTreeLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ValueEvaluatorTreeParser evaluator = new ValueEvaluatorTreeParser(tokenStream);
		ValueEvaluatorTreeParser.evaluator_return parser_evaluator = evaluator.evaluator();
		CommonTree commonTree = (CommonTree) parser_evaluator.getTree();
		System.out.println(commonTree.toStringTree());
		
		CommonTreeNodeStream nodeStream = new CommonTreeNodeStream(commonTree);
		nodeStream.setTokenStream(tokenStream); 
		ValueEvaluatorTreeWalker walker = new ValueEvaluatorTreeWalker(nodeStream);
		
		walker.evaluator();
		System.out.println(walker.evalValue.getData());
		
		Error.writeEvaluationErrorFile("log.txt");
	}

	public void testSVTimeseries() throws RecognitionException, IOException {

        String mainFile="z:\\temp\\test";
        FilePaths fp=new FilePaths();
        fp.setMainFilePaths(mainFile);
		
        new ControlData();
        FilePaths.fullSvarFilePath="D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\test\\test_evaluator\\2020D09ESV.dss";
        FilePaths.fullInitFilePath="D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\test\\test_evaluator\\2020D09EINIT.DSS";
        ControlData.currEvalName="bf601";
		ANTLRStringStream stream = new ANTLRStringStream("v: timeseries"); 
		EvaluatorLexer lexer = new EvaluatorLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		EvaluatorParser evaluator = new EvaluatorParser(tokenStream);
		evaluator.evaluator();
		System.out.println(evaluator.evalValue.getData());
		
		Error.writeEvaluationErrorFile("log.txt");
	}
	
	public void testSumExpression() throws RecognitionException, IOException {

        String mainFile="z:\\temp\\test";
        FilePaths fp=new FilePaths();
        fp.setMainFilePaths(mainFile);
		
        new ControlData();
        Svar svar=new Svar();
        svar.kind="bf-flow";
        svar.units="cfs";
        Map<String, Svar> svMap =new HashMap<String, Svar>();
        svMap.put("bf601", svar);
        ControlData.currSvMap=svMap;
        FilePaths.fullSvarFilePath="D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\test\\test_evaluator\\2020D09ESV.dss";
        FilePaths.fullInitFilePath="D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\test\\test_evaluator\\2020D09EINIT.DSS";
        ControlData.currEvalName="bf601";
		ANTLRStringStream stream = new ANTLRStringStream("v: timeseries"); 
		EvaluatorLexer lexer = new EvaluatorLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		EvaluatorParser evaluator = new EvaluatorParser(tokenStream);
		evaluator.evaluator();
		stream = new ANTLRStringStream("v: sum(i=4;1;-2) 3.0*bf601(i)"); 
		lexer = new EvaluatorLexer(stream);
		tokenStream = new CommonTokenStream(lexer);
		evaluator = new EvaluatorParser(tokenStream);
		evaluator.evaluator();
		System.out.println(evaluator.evalValue.getData());
		
		Error.writeEvaluationErrorFile("log.txt");
	}

	public void testPastMonth() throws RecognitionException, IOException {

        String mainFile="z:\\temp\\test";
        FilePaths fp=new FilePaths();
        fp.setMainFilePaths(mainFile);
		
        new ControlData();
        FilePaths.fullSvarFilePath="D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\test\\test_evaluator\\2020D09ESV.dss";
        FilePaths.fullInitFilePath="D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\test\\test_evaluator\\2020D09EINIT.DSS";
        ControlData.currEvalName="bf601";
		ANTLRStringStream stream = new ANTLRStringStream("v: timeseries"); 
		EvaluatorLexer lexer = new EvaluatorLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		EvaluatorParser evaluator = new EvaluatorParser(tokenStream);
		evaluator.evaluator();
		stream = new ANTLRStringStream("v: sum(i=month-prevjul;oct;-2) 3.0*bf601(i)"); 
		lexer = new EvaluatorLexer(stream);
		tokenStream = new CommonTokenStream(lexer);
		evaluator = new EvaluatorParser(tokenStream);
		evaluator.evaluator();
		System.out.println(evaluator.evalValue.getData());
		
		Error.writeEvaluationErrorFile("log.txt");
	}

	public void testLookUpTable() throws RecognitionException, IOException {

        String mainFile="D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\test\\test_evaluator\\main.wresl";
        FilePaths fp=new FilePaths();
        fp.setMainFilePaths(mainFile);
		
        new ControlData();
        String table="swp_3pattern_demands";
        String select="demand";
        String use="linear";
        HashMap<String, Number> given = new HashMap<String, Number>();
        given.put("percent", 75);
        HashMap<String, Number> where = new HashMap<String, Number>();
        where.put("contractor", 1);
        where.put("month",7);
        
        IntDouble id=TableOperation.findData(table, select, where, given, use);
		System.out.println(id.getData());
		
		Error.writeEvaluationErrorFile("log.txt");
	}

	public void testLookUp() throws RecognitionException, IOException {

        String mainFile="D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\test\\test_evaluator\\main.wresl";
        FilePaths fp=new FilePaths();
        fp.setMainFilePaths(mainFile);
		
        new ControlData();

        ANTLRStringStream stream = new ANTLRStringStream("v: select demand from swp_3pattern_demands given percent=75 use linear where contractor=1; month=7"); 
		EvaluatorLexer  lexer = new EvaluatorLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		EvaluatorParser evaluator = new EvaluatorParser(tokenStream);
		evaluator.evaluator();
		System.out.println(evaluator.evalValue.getData());
		
		Error.writeEvaluationErrorFile("log.txt");
	}
	
	public void testLookUp1() throws RecognitionException, IOException {

        FilePaths.setMainFilePaths("D:\\CALSIM3.0_070110\\D1641\\Run\\maind1641.wresl");
		
        new ControlData();

        ANTLRStringStream stream = new ANTLRStringStream("v: select ossjid from stan_yrossjid given nmf2 = nmforecast2 use  linear"); 
		EvaluatorLexer  lexer = new EvaluatorLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		EvaluatorParser evaluator = new EvaluatorParser(tokenStream);
		evaluator.evaluator();
		System.out.println(evaluator.evalValue.getData());
		
		Error.writeEvaluationErrorFile("log.txt");
	}
	
	public void testA56_allocation() throws RecognitionException, IOException {
        new LoadAllDll();

        String mainFile="z:\\temp\\test";
        FilePaths fp=new FilePaths();
        fp.setMainFilePaths(mainFile);
		
		ANTLRStringStream stream = new ANTLRStringStream("v: a56_allocation(1; 1; 0.0; 80.62; 0.0; 42.0; 0.0; 141.4; 0.0; 12.7; 0.0; 9.6; 0.0; 133.1; 0.0; 27.5; 0.0; 9.0; 0.0; 5.8; 0.0; 54.0; 0.0; 57.34; 0.0; 3.0; 0.0; 848.13; 0.0; 2.3; 0.0; 1911.5; 0.0; 75.8; 0.0; 29.02; 0.0; 5.7; 0.0; 21.3; 0.0; 102.6; 0.0; 28.8; 0.0; 17.3; 0.0; 25.0; 0.0; 45.49; 0.0; 100.0; 0.0; 47.76; 0.0; 96.23; 0.0; 20.0; 0.0; 134.6; 0.0; 82.5; 0.0)");
		EvaluatorLexer lexer = new EvaluatorLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		EvaluatorParser evaluator = new EvaluatorParser(tokenStream);
		evaluator.evaluator();
		System.out.println(evaluator.evalValue.getData());
		
		
		stream = new ANTLRStringStream("v: 1+a56_allocation(0;4)");
		lexer = new EvaluatorLexer(stream);
		tokenStream = new CommonTokenStream(lexer);
		evaluator = new EvaluatorParser(tokenStream);
		evaluator.evaluator();
		System.out.println(evaluator.evalValue.getData());
		
		Error.writeEvaluationErrorFile("log.txt");
	}
	
}
