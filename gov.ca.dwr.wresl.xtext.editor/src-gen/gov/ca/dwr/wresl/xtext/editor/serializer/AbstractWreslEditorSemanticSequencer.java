package gov.ca.dwr.wresl.xtext.editor.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import gov.ca.dwr.wresl.xtext.editor.services.WreslEditorGrammarAccess;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Add;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Alias;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Assignment;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.CaseContent;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Condition;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.ConditionalTerm;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.ConstDef;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Constraint;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVarIntegerStd;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVarNonStd;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVarStd;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Define;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.DvarDef;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.ElseIfTerm;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.ElseTerm;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.External;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.ExternalFunction;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Goal;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalCase;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalCaseContent;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalNoCaseContent;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalSimple;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Ident;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.IfIncIitems;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.IfTerm;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.IncludeFile;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Initial;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.IntFunction;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.LhsGtRhs;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.LhsLtRhs;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.LogicalExpression;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Lower;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.MaxFunction;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.MinFunction;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Model;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Multiply;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Objective;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Penalty;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarCase;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarDSS;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarExpression;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarSum;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarTable;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Sequence;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.SubContent;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.SumContent;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.SumHeader;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.SvarDef;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.TableContent;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Term;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Upper;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.ValueContent;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.WeightItem;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.WhereItems;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEditorPackage;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEvaluator;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.lowerUpper;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.upperLower;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("restriction")
public class AbstractWreslEditorSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected WreslEditorGrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	
	@Override
	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == WreslEditorPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case WreslEditorPackage.ADD:
				if(context == grammarAccess.getAddRule() ||
				   context == grammarAccess.getExpressionRule()) {
					sequence_Add(context, (Add) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.ALIAS:
				if(context == grammarAccess.getAliasRule() ||
				   context == grammarAccess.getPatternRule()) {
					sequence_Alias(context, (Alias) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.ASSIGNMENT:
				if(context == grammarAccess.getAssignmentRule()) {
					sequence_Assignment(context, (Assignment) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.CASE_CONTENT:
				if(context == grammarAccess.getCaseContentRule()) {
					sequence_CaseContent(context, (CaseContent) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.CONDITION:
				if(context == grammarAccess.getConditionRule()) {
					sequence_Condition(context, (Condition) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.CONDITIONAL_TERM:
				if(context == grammarAccess.getConditionalTermRule() ||
				   context == grammarAccess.getConditionalUnaryRule()) {
					sequence_ConditionalTerm(context, (ConditionalTerm) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.CONST_DEF:
				if(context == grammarAccess.getConstDefRule() ||
				   context == grammarAccess.getPatternRule()) {
					sequence_ConstDef(context, (ConstDef) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.CONSTRAINT:
				if(context == grammarAccess.getConstraintRule()) {
					sequence_Constraint(context, (Constraint) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.DVAR_INTEGER_STD:
				if(context == grammarAccess.getDVarIntegerRule() ||
				   context == grammarAccess.getDVarIntegerStdRule()) {
					sequence_DVarIntegerStd(context, (DVarIntegerStd) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.DVAR_NON_STD:
				if(context == grammarAccess.getDVarRule() ||
				   context == grammarAccess.getDVarNonStdRule()) {
					sequence_DVarNonStd(context, (DVarNonStd) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.DVAR_STD:
				if(context == grammarAccess.getDVarRule() ||
				   context == grammarAccess.getDVarStdRule()) {
					sequence_DVarStd(context, (DVarStd) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.DEFINE:
				if(context == grammarAccess.getDefineRule() ||
				   context == grammarAccess.getPatternRule()) {
					sequence_Define(context, (Define) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.DVAR_DEF:
				if(context == grammarAccess.getDvarDefRule() ||
				   context == grammarAccess.getPatternRule()) {
					sequence_DvarDef(context, (DvarDef) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.ELSE_IF_TERM:
				if(context == grammarAccess.getElseIfTermRule()) {
					sequence_ElseIfTerm(context, (ElseIfTerm) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.ELSE_TERM:
				if(context == grammarAccess.getElseTermRule()) {
					sequence_ElseTerm(context, (ElseTerm) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.EXTERNAL:
				if(context == grammarAccess.getExternalRule()) {
					sequence_External(context, (External) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.EXTERNAL_FUNCTION:
				if(context == grammarAccess.getExternalFunctionRule() ||
				   context == grammarAccess.getFunctionRule() ||
				   context == grammarAccess.getTermSimpleRule()) {
					sequence_ExternalFunction(context, (ExternalFunction) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.GOAL:
				if(context == grammarAccess.getGoalRule() ||
				   context == grammarAccess.getPatternRule()) {
					sequence_Goal(context, (Goal) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.GOAL_CASE:
				if(context == grammarAccess.getGoalCaseRule()) {
					sequence_GoalCase(context, (GoalCase) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.GOAL_CASE_CONTENT:
				if(context == grammarAccess.getGoalCaseContentRule()) {
					sequence_GoalCaseContent(context, (GoalCaseContent) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.GOAL_NO_CASE_CONTENT:
				if(context == grammarAccess.getGoalNoCaseContentRule()) {
					sequence_GoalNoCaseContent(context, (GoalNoCaseContent) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.GOAL_SIMPLE:
				if(context == grammarAccess.getGoalSimpleRule()) {
					sequence_GoalSimple(context, (GoalSimple) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.IDENT:
				if(context == grammarAccess.getIdentRule()) {
					sequence_Ident(context, (Ident) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.IF_INC_IITEMS:
				if(context == grammarAccess.getIfIncIitemsRule()) {
					sequence_IfIncIitems(context, (IfIncIitems) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.IF_TERM:
				if(context == grammarAccess.getIfTermRule()) {
					sequence_IfTerm(context, (IfTerm) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.INCLUDE_FILE:
				if(context == grammarAccess.getIncludeFileRule() ||
				   context == grammarAccess.getPatternRule()) {
					sequence_IncludeFile(context, (IncludeFile) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.INITIAL:
				if(context == grammarAccess.getInitialRule()) {
					sequence_Initial(context, (Initial) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.INT_FUNCTION:
				if(context == grammarAccess.getFunctionRule() ||
				   context == grammarAccess.getIntFunctionRule() ||
				   context == grammarAccess.getTermSimpleRule()) {
					sequence_IntFunction(context, (IntFunction) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.LHS_GT_RHS:
				if(context == grammarAccess.getLhsGtRhsRule()) {
					sequence_LhsGtRhs(context, (LhsGtRhs) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.LHS_LT_RHS:
				if(context == grammarAccess.getLhsLtRhsRule()) {
					sequence_LhsLtRhs(context, (LhsLtRhs) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.LOGICAL_EXPRESSION:
				if(context == grammarAccess.getLogicalExpressionRule()) {
					sequence_LogicalExpression(context, (LogicalExpression) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.LOWER:
				if(context == grammarAccess.getLowerRule()) {
					sequence_Lower(context, (Lower) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.MAX_FUNCTION:
				if(context == grammarAccess.getFunctionRule() ||
				   context == grammarAccess.getMaxFunctionRule() ||
				   context == grammarAccess.getTermSimpleRule()) {
					sequence_MaxFunction(context, (MaxFunction) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.MIN_FUNCTION:
				if(context == grammarAccess.getFunctionRule() ||
				   context == grammarAccess.getMinFunctionRule() ||
				   context == grammarAccess.getTermSimpleRule()) {
					sequence_MinFunction(context, (MinFunction) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.MULTIPLY:
				if(context == grammarAccess.getMultiplyRule()) {
					sequence_Multiply(context, (Multiply) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.OBJECTIVE:
				if(context == grammarAccess.getObjectiveRule() ||
				   context == grammarAccess.getPatternRule()) {
					sequence_Objective(context, (Objective) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.PENALTY:
				if(context == grammarAccess.getPenaltyRule()) {
					sequence_Penalty(context, (Penalty) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.SVAR_CASE:
				if(context == grammarAccess.getSVarRule() ||
				   context == grammarAccess.getSVarCaseRule()) {
					sequence_SVarCase(context, (SVarCase) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.SVAR_DSS:
				if(context == grammarAccess.getSVarRule() ||
				   context == grammarAccess.getSVarDSSRule()) {
					sequence_SVarDSS(context, (SVarDSS) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.SVAR_EXPRESSION:
				if(context == grammarAccess.getSVarRule() ||
				   context == grammarAccess.getSVarExpressionRule()) {
					sequence_SVarExpression(context, (SVarExpression) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.SVAR_SUM:
				if(context == grammarAccess.getSVarRule() ||
				   context == grammarAccess.getSVarSumRule()) {
					sequence_SVarSum(context, (SVarSum) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.SVAR_TABLE:
				if(context == grammarAccess.getSVarRule() ||
				   context == grammarAccess.getSVarTableRule()) {
					sequence_SVarTable(context, (SVarTable) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.SEQUENCE:
				if(context == grammarAccess.getSequenceRule()) {
					sequence_Sequence(context, (Sequence) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.SUB_CONTENT:
				if(context == grammarAccess.getSubContentRule()) {
					sequence_SubContent(context, (SubContent) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.SUM_CONTENT:
				if(context == grammarAccess.getSumContentRule()) {
					sequence_SumContent(context, (SumContent) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.SUM_HEADER:
				if(context == grammarAccess.getSumHeaderRule()) {
					sequence_SumHeader(context, (SumHeader) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.SVAR_DEF:
				if(context == grammarAccess.getPatternRule() ||
				   context == grammarAccess.getSvarDefRule()) {
					sequence_SvarDef(context, (SvarDef) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.TABLE_CONTENT:
				if(context == grammarAccess.getTableContentRule()) {
					sequence_TableContent(context, (TableContent) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.TERM:
				if(context == grammarAccess.getTermRule() ||
				   context == grammarAccess.getUnaryRule()) {
					sequence_Term(context, (Term) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.UPPER:
				if(context == grammarAccess.getUpperRule()) {
					sequence_Upper(context, (Upper) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.VALUE_CONTENT:
				if(context == grammarAccess.getValueContentRule()) {
					sequence_ValueContent(context, (ValueContent) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.WEIGHT_ITEM:
				if(context == grammarAccess.getWeightItemRule()) {
					sequence_WeightItem(context, (WeightItem) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.WHERE_ITEMS:
				if(context == grammarAccess.getWhereItemsRule()) {
					sequence_WhereItems(context, (WhereItems) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.WRESL_EVALUATOR:
				if(context == grammarAccess.getWreslEvaluatorRule()) {
					sequence_WreslEvaluator(context, (WreslEvaluator) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.LOWER_UPPER:
				if(context == grammarAccess.getDVarIntegerRule() ||
				   context == grammarAccess.getDVarIntegerNonStdRule()) {
					sequence_DVarIntegerNonStd(context, (lowerUpper) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getLowerAndOrUpperRule() ||
				   context == grammarAccess.getLowerUpperRule()) {
					sequence_lowerUpper(context, (lowerUpper) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.UPPER_LOWER:
				if(context == grammarAccess.getDVarIntegerRule() ||
				   context == grammarAccess.getDVarIntegerNonStdRule()) {
					sequence_DVarIntegerNonStd(context, (upperLower) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getLowerAndOrUpperRule() ||
				   context == grammarAccess.getUpperLowerRule()) {
					sequence_upperLower(context, (upperLower) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (m1=Multiply m2+=Multiply*)
	 *
	 * Features:
	 *    m1[1, 1]
	 *    m2[0, *]
	 */
	protected void sequence_Add(EObject context, Add semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((local?='local' | local?='LOCAL')? name=ID expression=Expression kind=STRING? units=STRING?)
	 *
	 * Features:
	 *    local[0, 2]
	 *    name[1, 1]
	 *    expression[1, 1]
	 *    kind[0, 1]
	 *    units[0, 1]
	 */
	protected void sequence_Alias(EObject context, Alias semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (term=TermSimple expression=Expression)
	 *
	 * Features:
	 *    term[1, 1]
	 *    expression[1, 1]
	 */
	protected void sequence_Assignment(EObject context, Assignment semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.ASSIGNMENT__TERM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.ASSIGNMENT__TERM));
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.ASSIGNMENT__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.ASSIGNMENT__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAssignmentAccess().getTermTermSimpleParserRuleCall_0_0(), semanticObject.getTerm());
		feeder.accept(grammarAccess.getAssignmentAccess().getExpressionExpressionParserRuleCall_2_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (caseName=ID condition=Condition (content=TableContent | content=ValueContent | content=SumContent))
	 *
	 * Features:
	 *    caseName[1, 1]
	 *    condition[1, 1]
	 *    content[0, 3]
	 */
	protected void sequence_CaseContent(EObject context, CaseContent semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {Condition}
	 *
	 * Features:
	 */
	protected void sequence_Condition(EObject context, Condition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (e1=Expression e2=Expression)
	 *
	 * Features:
	 *    e1[1, 1]
	 *    e2[1, 1]
	 */
	protected void sequence_ConditionalTerm(EObject context, ConditionalTerm semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.CONDITIONAL_TERM__E1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.CONDITIONAL_TERM__E1));
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.CONDITIONAL_TERM__E2) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.CONDITIONAL_TERM__E2));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getConditionalTermAccess().getE1ExpressionParserRuleCall_0_0_0(), semanticObject.getE1());
		feeder.accept(grammarAccess.getConditionalTermAccess().getE2ExpressionParserRuleCall_0_2_0(), semanticObject.getE2());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((local?='local' | local?='LOCAL')? name=ID definition=Number)
	 *
	 * Features:
	 *    local[0, 2]
	 *    name[1, 1]
	 *    definition[1, 1]
	 */
	protected void sequence_ConstDef(EObject context, ConstDef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (lhs=Expression (operator='<' | operator='>' | operator='=') rhs=Expression)
	 *
	 * Features:
	 *    lhs[1, 1]
	 *    operator[0, 3]
	 *    rhs[1, 1]
	 */
	protected void sequence_Constraint(EObject context, Constraint semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (lower=Lower upper=Upper? kind=STRING units=STRING)
	 *
	 * Features:
	 *    kind[1, 1]
	 *    units[1, 1]
	 *    upper[0, 1]
	 *    lower[1, 1]
	 */
	protected void sequence_DVarIntegerNonStd(EObject context, lowerUpper semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (upper=Upper lower=Lower? kind=STRING units=STRING)
	 *
	 * Features:
	 *    kind[1, 1]
	 *    units[1, 1]
	 *    upper[1, 1]
	 *    lower[0, 1]
	 */
	protected void sequence_DVarIntegerNonStd(EObject context, upperLower semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (kind=STRING units=STRING)
	 *
	 * Features:
	 *    kind[1, 1]
	 *    units[1, 1]
	 */
	protected void sequence_DVarIntegerStd(EObject context, DVarIntegerStd semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.DVAR_INTEGER_STD__KIND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.DVAR_INTEGER_STD__KIND));
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.DVAR_INTEGER_STD__UNITS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.DVAR_INTEGER_STD__UNITS));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDVarIntegerStdAccess().getKindSTRINGTerminalRuleCall_3_0(), semanticObject.getKind());
		feeder.accept(grammarAccess.getDVarIntegerStdAccess().getUnitsSTRINGTerminalRuleCall_5_0(), semanticObject.getUnits());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (lowerUpper=LowerAndOrUpper kind=STRING units=STRING)
	 *
	 * Features:
	 *    kind[1, 1]
	 *    units[1, 1]
	 *    lowerUpper[1, 1]
	 */
	protected void sequence_DVarNonStd(EObject context, DVarNonStd semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.DVAR__KIND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.DVAR__KIND));
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.DVAR__UNITS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.DVAR__UNITS));
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.DVAR_NON_STD__LOWER_UPPER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.DVAR_NON_STD__LOWER_UPPER));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDVarNonStdAccess().getLowerUpperLowerAndOrUpperParserRuleCall_0_0(), semanticObject.getLowerUpper());
		feeder.accept(grammarAccess.getDVarNonStdAccess().getKindSTRINGTerminalRuleCall_2_0(), semanticObject.getKind());
		feeder.accept(grammarAccess.getDVarNonStdAccess().getUnitsSTRINGTerminalRuleCall_4_0(), semanticObject.getUnits());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (kind=STRING units=STRING)
	 *
	 * Features:
	 *    kind[1, 1]
	 *    units[1, 1]
	 */
	protected void sequence_DVarStd(EObject context, DVarStd semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.DVAR__KIND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.DVAR__KIND));
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.DVAR__UNITS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.DVAR__UNITS));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDVarStdAccess().getKindSTRINGTerminalRuleCall_2_0(), semanticObject.getKind());
		feeder.accept(grammarAccess.getDVarStdAccess().getUnitsSTRINGTerminalRuleCall_4_0(), semanticObject.getUnits());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((local?='local' | local?='LOCAL')? name=ID (definition=DVar | definition=SVar | definition=DVarInteger | definition=External))
	 *
	 * Features:
	 *    local[0, 2]
	 *    name[1, 1]
	 *    definition[0, 4]
	 */
	protected void sequence_Define(EObject context, Define semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((local?='local' | local?='LOCAL')? name=ID (definition=DVar | definition=DVarInteger))
	 *
	 * Features:
	 *    local[0, 2]
	 *    name[1, 1]
	 *    definition[0, 2]
	 */
	protected void sequence_DvarDef(EObject context, DvarDef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (logical=LogicalExpression pattern+=Pattern+)
	 *
	 * Features:
	 *    logical[1, 1]
	 *    pattern[1, *]
	 */
	protected void sequence_ElseIfTerm(EObject context, ElseIfTerm semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     pattern+=Pattern+
	 *
	 * Features:
	 *    pattern[1, *]
	 */
	protected void sequence_ElseTerm(EObject context, ElseTerm semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (e1=Expression e2+=Expression*)
	 *
	 * Features:
	 *    e1[1, 1]
	 *    e2[0, *]
	 */
	protected void sequence_ExternalFunction(EObject context, ExternalFunction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {External}
	 *
	 * Features:
	 */
	protected void sequence_External(EObject context, External semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (caseName=ID condition=Condition rhs=Expression subContent=SubContent?)
	 *
	 * Features:
	 *    caseName[1, 1]
	 *    condition[1, 1]
	 *    rhs[1, 1]
	 *    subContent[0, 1]
	 */
	protected void sequence_GoalCaseContent(EObject context, GoalCaseContent semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (lhs=Expression (content=GoalNoCaseContent | caseContent+=GoalCaseContent+))
	 *
	 * Features:
	 *    lhs[1, 1]
	 *    content[0, 1]
	 *         EXCLUDE_IF_SET caseContent
	 *    caseContent[0, *]
	 *         EXCLUDE_IF_SET content
	 */
	protected void sequence_GoalCase(EObject context, GoalCase semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (rhs=Expression subContent=SubContent?)
	 *
	 * Features:
	 *    rhs[1, 1]
	 *    subContent[0, 1]
	 */
	protected void sequence_GoalNoCaseContent(EObject context, GoalNoCaseContent semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     constraint=Constraint
	 *
	 * Features:
	 *    constraint[1, 1]
	 */
	protected void sequence_GoalSimple(EObject context, GoalSimple semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.GOAL_SIMPLE__CONSTRAINT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.GOAL_SIMPLE__CONSTRAINT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getGoalSimpleAccess().getConstraintConstraintParserRuleCall_0(), semanticObject.getConstraint());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((local?='local' | local?='LOCAL')? name=ID (definition=GoalSimple | definition=GoalCase))
	 *
	 * Features:
	 *    local[0, 2]
	 *    name[1, 1]
	 *    definition[0, 2]
	 */
	protected void sequence_Goal(EObject context, Goal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 *
	 * Features:
	 *    name[1, 1]
	 */
	protected void sequence_Ident(EObject context, Ident semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.IDENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.IDENT__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIdentAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (ifterm=IfTerm elseifterm=ElseIfTerm* elseterm=ElseTerm?)
	 *
	 * Features:
	 *    ifterm[1, 1]
	 *    elseifterm[0, *]
	 *    elseterm[0, 1]
	 */
	protected void sequence_IfIncIitems(EObject context, IfIncIitems semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (logical=LogicalExpression pattern+=Pattern+)
	 *
	 * Features:
	 *    logical[1, 1]
	 *    pattern[1, *]
	 */
	protected void sequence_IfTerm(EObject context, IfTerm semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((local?='local' | local?='LOCAL')? file=STRING)
	 *
	 * Features:
	 *    local[0, 2]
	 *    file[1, 1]
	 */
	protected void sequence_IncludeFile(EObject context, IncludeFile semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     pattern+=Pattern+
	 *
	 * Features:
	 *    pattern[1, *]
	 */
	protected void sequence_Initial(EObject context, Initial semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     e=Expression
	 *
	 * Features:
	 *    e[1, 1]
	 */
	protected void sequence_IntFunction(EObject context, IntFunction semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.INT_FUNCTION__E) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.INT_FUNCTION__E));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIntFunctionAccess().getEExpressionParserRuleCall_2_0(), semanticObject.getE());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {LhsGtRhs}
	 *
	 * Features:
	 */
	protected void sequence_LhsGtRhs(EObject context, LhsGtRhs semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {LhsLtRhs}
	 *
	 * Features:
	 */
	protected void sequence_LhsLtRhs(EObject context, LhsLtRhs semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (c1=ConditionalUnary c2+=ConditionalUnary*)
	 *
	 * Features:
	 *    c1[1, 1]
	 *    c2[0, *]
	 */
	protected void sequence_LogicalExpression(EObject context, LogicalExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {Lower}
	 *
	 * Features:
	 */
	protected void sequence_Lower(EObject context, Lower semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (e1=Expression e2+=Expression*)
	 *
	 * Features:
	 *    e1[1, 1]
	 *    e2[0, *]
	 */
	protected void sequence_MaxFunction(EObject context, MaxFunction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (e1=Expression e2+=Expression*)
	 *
	 * Features:
	 *    e1[1, 1]
	 *    e2[0, *]
	 */
	protected void sequence_MinFunction(EObject context, MinFunction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (pattern+=Pattern | ifincitems+=IfIncIitems)+)
	 *
	 * Features:
	 *    name[1, 1]
	 *    pattern[0, *]
	 *    ifincitems[0, *]
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (u1=Unary u2+=Unary*)
	 *
	 * Features:
	 *    u1[1, 1]
	 *    u2[0, *]
	 */
	protected void sequence_Multiply(EObject context, Multiply semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((local?='local' | local?='LOCAL')? name=ID weights+=WeightItem+)
	 *
	 * Features:
	 *    local[0, 2]
	 *    name[1, 1]
	 *    weights[1, *]
	 */
	protected void sequence_Objective(EObject context, Objective semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     expression=Expression
	 *
	 * Features:
	 *    expression[1, 1]
	 */
	protected void sequence_Penalty(EObject context, Penalty semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.PENALTY__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.PENALTY__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPenaltyAccess().getExpressionExpressionParserRuleCall_1_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     caseContent+=CaseContent+
	 *
	 * Features:
	 *    caseContent[1, *]
	 */
	protected void sequence_SVarCase(EObject context, SVarCase semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (bPart=STRING? kind=STRING units=STRING convert=STRING?)
	 *
	 * Features:
	 *    bPart[0, 1]
	 *    kind[1, 1]
	 *    units[1, 1]
	 *    convert[0, 1]
	 */
	protected void sequence_SVarDSS(EObject context, SVarDSS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     expression=Expression
	 *
	 * Features:
	 *    expression[1, 1]
	 */
	protected void sequence_SVarExpression(EObject context, SVarExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.SVAR_EXPRESSION__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.SVAR_EXPRESSION__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSVarExpressionAccess().getExpressionExpressionParserRuleCall_1_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     sumContent=SumContent
	 *
	 * Features:
	 *    sumContent[1, 1]
	 */
	protected void sequence_SVarSum(EObject context, SVarSum semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.SVAR_SUM__SUM_CONTENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.SVAR_SUM__SUM_CONTENT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSVarSumAccess().getSumContentSumContentParserRuleCall_0(), semanticObject.getSumContent());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     tableContent=TableContent
	 *
	 * Features:
	 *    tableContent[1, 1]
	 */
	protected void sequence_SVarTable(EObject context, SVarTable semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.SVAR_TABLE__TABLE_CONTENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.SVAR_TABLE__TABLE_CONTENT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSVarTableAccess().getTableContentTableContentParserRuleCall_0(), semanticObject.getTableContent());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID model=[Model|ID] condition=Condition? order=INT?)
	 *
	 * Features:
	 *    name[1, 1]
	 *    model[1, 1]
	 *    condition[0, 1]
	 *    order[0, 1]
	 */
	protected void sequence_Sequence(EObject context, Sequence semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((gt=LhsGtRhs lt=LhsLtRhs?) | (lt=LhsLtRhs gt=LhsGtRhs?))
	 *
	 * Features:
	 *    gt[0, 2]
	 *    lt[0, 2]
	 */
	protected void sequence_SubContent(EObject context, SubContent semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (header=SumHeader expression=Expression)
	 *
	 * Features:
	 *    header[1, 1]
	 *    expression[1, 1]
	 */
	protected void sequence_SumContent(EObject context, SumContent semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.SUM_CONTENT__HEADER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.SUM_CONTENT__HEADER));
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.SUM_CONTENT__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.SUM_CONTENT__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSumContentAccess().getHeaderSumHeaderParserRuleCall_1_0(), semanticObject.getHeader());
		feeder.accept(grammarAccess.getSumContentAccess().getExpressionExpressionParserRuleCall_2_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (expression1=Expression expression2=Expression)
	 *
	 * Features:
	 *    expression1[1, 1]
	 *    expression2[1, 1]
	 */
	protected void sequence_SumHeader(EObject context, SumHeader semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.SUM_HEADER__EXPRESSION1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.SUM_HEADER__EXPRESSION1));
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.SUM_HEADER__EXPRESSION2) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.SUM_HEADER__EXPRESSION2));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSumHeaderAccess().getExpression1ExpressionParserRuleCall_2_0(), semanticObject.getExpression1());
		feeder.accept(grammarAccess.getSumHeaderAccess().getExpression2ExpressionParserRuleCall_4_0(), semanticObject.getExpression2());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((local?='local' | local?='LOCAL')? name=ID definition=SVar)
	 *
	 * Features:
	 *    local[0, 2]
	 *    name[1, 1]
	 *    definition[1, 1]
	 */
	protected void sequence_SvarDef(EObject context, SvarDef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (tableName=ID from=ID (given=Assignment use=ID)? where=WhereItems?)
	 *
	 * Features:
	 *    tableName[1, 1]
	 *    from[1, 1]
	 *    given[0, 1]
	 *         EXCLUDE_IF_UNSET use
	 *         MANDATORY_IF_SET use
	 *    use[0, 1]
	 *         EXCLUDE_IF_UNSET given
	 *         MANDATORY_IF_SET given
	 *    where[0, 1]
	 */
	protected void sequence_TableContent(EObject context, TableContent semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (i=Ident | n=Number | f=Function | e2=Expression)
	 *
	 * Features:
	 *    i[0, 1]
	 *         EXCLUDE_IF_SET n
	 *         EXCLUDE_IF_SET f
	 *         EXCLUDE_IF_SET e2
	 *    n[0, 1]
	 *         EXCLUDE_IF_SET i
	 *         EXCLUDE_IF_SET f
	 *         EXCLUDE_IF_SET e2
	 *    f[0, 1]
	 *         EXCLUDE_IF_SET i
	 *         EXCLUDE_IF_SET n
	 *         EXCLUDE_IF_SET e2
	 *    e2[0, 1]
	 *         EXCLUDE_IF_SET i
	 *         EXCLUDE_IF_SET n
	 *         EXCLUDE_IF_SET f
	 */
	protected void sequence_Term(EObject context, Term semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {Upper}
	 *
	 * Features:
	 */
	protected void sequence_Upper(EObject context, Upper semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     expression=Expression
	 *
	 * Features:
	 *    expression[1, 1]
	 */
	protected void sequence_ValueContent(EObject context, ValueContent semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.VALUE_CONTENT__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.VALUE_CONTENT__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getValueContentAccess().getExpressionExpressionParserRuleCall_1_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID expression=Expression)
	 *
	 * Features:
	 *    name[1, 1]
	 *    expression[1, 1]
	 */
	protected void sequence_WeightItem(EObject context, WeightItem semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.WEIGHT_ITEM__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.WEIGHT_ITEM__NAME));
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.WEIGHT_ITEM__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.WEIGHT_ITEM__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getWeightItemAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getWeightItemAccess().getExpressionExpressionParserRuleCall_3_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (assignment+=Assignment assignment+=Assignment*)
	 *
	 * Features:
	 *    assignment[1, *]
	 */
	protected void sequence_WhereItems(EObject context, WhereItems semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((pattern+=Pattern | ifincitem+=IfIncIitems)+ | (initial=Initial? sequence+=Sequence+ model+=Model+))
	 *
	 * Features:
	 *    pattern[0, *]
	 *         EXCLUDE_IF_SET initial
	 *         EXCLUDE_IF_SET sequence
	 *         EXCLUDE_IF_SET model
	 *    ifincitem[0, *]
	 *         EXCLUDE_IF_SET initial
	 *         EXCLUDE_IF_SET sequence
	 *         EXCLUDE_IF_SET model
	 *    initial[0, 1]
	 *         EXCLUDE_IF_UNSET sequence
	 *         EXCLUDE_IF_UNSET model
	 *         EXCLUDE_IF_SET pattern
	 *         EXCLUDE_IF_SET ifincitem
	 *    sequence[0, *]
	 *         MANDATORY_IF_SET initial
	 *         EXCLUDE_IF_UNSET model
	 *         MANDATORY_IF_SET model
	 *         EXCLUDE_IF_SET pattern
	 *         EXCLUDE_IF_SET ifincitem
	 *    model[0, *]
	 *         MANDATORY_IF_SET initial
	 *         EXCLUDE_IF_UNSET sequence
	 *         MANDATORY_IF_SET sequence
	 *         EXCLUDE_IF_SET pattern
	 *         EXCLUDE_IF_SET ifincitem
	 */
	protected void sequence_WreslEvaluator(EObject context, WreslEvaluator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (lower=Lower upper=Upper?)
	 *
	 * Features:
	 *    upper[0, 1]
	 *    lower[1, 1]
	 */
	protected void sequence_lowerUpper(EObject context, lowerUpper semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (upper=Upper lower=Lower?)
	 *
	 * Features:
	 *    upper[1, 1]
	 *    lower[0, 1]
	 */
	protected void sequence_upperLower(EObject context, upperLower semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
