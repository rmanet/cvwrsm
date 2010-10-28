grammar ConvertWRESL;

options {
  language = Java;
}

@header {
  package WRESL;
  import java.util.Map;
  import java.util.HashMap;
}

@lexer::header {
  package WRESL;
}

@members {

  public Map<String, String>   error_var_redefined = new HashMap<String, String> ();
  public Map<String, String>   var_all             = new HashMap<String, String> ();
  public Map<String, String>   svar_expression     = new HashMap<String, String>();
    
  public Map<String, ArrayList<String>>  dvar_nonstd = new HashMap<String, ArrayList<String>>();  
  public Map<String, ArrayList<String>>  dvar_std    = new HashMap<String, ArrayList<String>>(); 
  public Map<String, ArrayList<String>>  svar_table  = new HashMap<String, ArrayList<String>>(); 
  public Map<String, ArrayList<String>>  svar_dss    = new HashMap<String, ArrayList<String>>(); 
  public Map<String, String>   goal_simple = new HashMap<String, String>();
  
  private ArrayList<String> list;

  public String strip(String s) {
    return s.substring(1, s.length()-1);
    }
  
  
}

evaluator //returns [Map<String, String> map1]
	:	modules EOF //{ $map1 = constants; }
	;

modules
	:	module*
	;

module
	:   goal_simple
	|   define
	;

define //returns [Map<String, String> map]
	:	DEFINE (svar_expression|dvar_std|dvar_nonstd|svar_table|svar_dss)  
	;


goal_simple
	: GOAL i=IDENT  '{' v=relationStatement '}'  {		
				if (var_all.containsKey($i.text)){
				//System.out.println("error... variable redefined: " + $i.text);
				error_var_redefined.put($i.text, "goal_simple");
				}
				else {
				goal_simple.put($i.text, $v.text);
				var_all.put($i.text, "goal_simple");
				}
		}
	;

goal_lhs
	: 'lhs' IDENT
	;

//svar_constant //returns [Map<String, String> map]
//	:	i=IDENT '{' 'value' v=number '}' { 
//				
//				if (var_all.containsKey($i.text)){
//				//System.out.println("error... variable redefined: " + $i.text);
//				error_var_redefined.put($i.text, "svar_constant");
//				}
//				else {
//				svar_constant.put($i.text, $v.text);
//				var_all.put($i.text, "svar_constant");
//				}
//		}
//	;

svar_expression //returns [Map<String, String> map]
	:	i=IDENT '{' 'value' v=expression '}' { 
				
				if (var_all.containsKey($i.text)){
				//System.out.println("error... variable redefined: " + $i.text);
				error_var_redefined.put($i.text, "svar_expression");
				}
				else {
				svar_expression.put($i.text, $v.text);
				var_all.put($i.text, "svar_expression");
				}
		}
	;


svar_table
	:	i=IDENT '{' t=tableSQL '}' { 
				
				if (var_all.containsKey($i.text)){
				//System.out.println("error... variable redefined: " + $i.text);
				error_var_redefined.put($i.text, "svar_table");
				}
				else {
				svar_table.put($i.text, $t.list);
				var_all.put($i.text, "svar_table");
				}
		}
	;

tableSQL returns[ArrayList<String> list]
	: 'select' i1=IDENT 'from' i2=IDENT ('given' i3=relationStatement)? ('use' i4=IDENT)? 'where' i5=relationStatement {       
				list = new ArrayList<String>();
				list.add($i1.text);
				list.add($i2.text);
				list.add($i3.text);
				list.add($i4.text);
				list.add($i5.text);
		}
	;


svar_dss
	:	i=IDENT '{' 'timeseries' kind units'}' { 
				
				if (var_all.containsKey($i.text)){
				//System.out.println("error... variable redefined: " + $i.text);
				error_var_redefined.put($i.text, "svar_dss");
				}
				else {
				list = new ArrayList<String>();
				list.add($kind.str);
				list.add($units.str);
				svar_dss.put($i.text, list);
				var_all.put($i.text, "svar_dss");
				}
		} 
	;

dvar_std
	:	i=IDENT '{' 'std' kind units'}' { 
				
				if (var_all.containsKey($i.text)){
				//System.out.println("error... variable redefined: " + $i.text);
				error_var_redefined.put($i.text, "dvar_std");
				}
				else {
				list = new ArrayList<String>();
				list.add($kind.str);
				list.add($units.str);
				dvar_std.put($i.text, list);
				var_all.put($i.text, "dvar_std");
				}
		}
	;
	
dvar_nonstd 
	:	i=IDENT '{' c=lower_or_upper kind units '}' { 
				
				if (var_all.containsKey($i.text)){
				//System.out.println("error... variable redefined: " + $i.text);
				error_var_redefined.put($i.text, "dvar_nonstd");
				}
				else {
				list = new ArrayList<String>();
				list.add($kind.str);
				list.add($units.str);
				list.addAll($c.list);
				dvar_nonstd.put($i.text, list);
				var_all.put($i.text, "dvar_nonstd");
				}
		} 
	;


lower_or_upper returns[ArrayList<String> list]
	:	lower upper? {       
				list = new ArrayList<String>();
				list.add($lower.str);
				if ($upper.str==null) {
				list.add("unbounded");
				}
				else {
				list.add($upper.str);
				}		
	    }
	|	upper {       
				list = new ArrayList<String>();
				list.add("0");
				list.add($upper.str);
		}		

	;
 



lower returns[String str]
	: 'lower' e=expression {$str =$e.str; }
	;

upper returns[String str]
	: 'upper' e=expression {$str =$e.str; }
	;
	
kind returns [String str]
	: 'kind'  s=QUOTE_STRING_with_MINUS  { $str =strip($s.text); } 
	;

units returns [String str]
	: 'units' CFS {$str = "CFS";}
	| 'units' TAF {$str = "TAF";} 
	| 'units' ACRES {$str = "ACRES";}
	| 'units' IN {$str = "IN";}
	;

///////////////////////////
/// Intrinsic functions ///
///////////////////////////

max_func
	: MAX '(' expression ',' expression ')'
	;

min_func
	: MIN '(' expression ',' expression ')'
	;

inline_func 
	: IDENT '(' '-' INTEGER ')'
	;

///////////////////
/// basic rules ///
///////////////////


term
	:	IDENT 
	|	'(' e=expression ')' 
	|	number
	|   inline_func
	|   max_func
	|   min_func	
	;
	
unary
	:	('-')? term
	;

mult
	:	unary (('*' | '/' | 'mod') unary)*
	;
	
add 
	:	mult (('+' | '-') mult)*
	;

expression returns [String str]
	:	i=add {$str = $i.text; }
	;

relation
	: '='
	| '<'
	| '>'
	;	

relationStatement
	:	expression relation expression 
	;

number
	: INTEGER
	| FLOAT
	;

MULTILINE_COMMENT : '/*' .* '*/' {$channel = HIDDEN;} ;


fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT : '0'..'9';
fragment SYMBOLS : '_';


INTEGER : DIGIT+ ;
FLOAT : INTEGER? '.' INTEGER 
	  | INTEGER '.' 
	  ;

// INLINE_FUNC : LETTER (LETTER | DIGIT | SYMBOLS )*'(' '-'? INTEGER ')';
MAX : 'max' ;
MIN : 'min' ;
GOAL :'goal';
DEFINE :'define';
TAF :'\''  'TAF'  '\'';
CFS :'\''  'CFS' '\'';
ACRES :'\''  'ACRES' '\'';
IN :'\''  'IN' '\'';
QUOTE_STRING_with_MINUS : '\'' IDENT ( '-' | IDENT )+ '\'';
IDENT : LETTER (LETTER | DIGIT | SYMBOLS )*;

WS : (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;};
COMMENT : '!' .* ('\n'|'\r') {$channel = HIDDEN;};
