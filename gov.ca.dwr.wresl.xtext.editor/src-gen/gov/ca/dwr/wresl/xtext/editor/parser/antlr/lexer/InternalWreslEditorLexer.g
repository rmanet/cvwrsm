
/*
* generated by Xtext
*/
lexer grammar InternalWreslEditorLexer;


@header {
package gov.ca.dwr.wresl.xtext.editor.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}




KEYWORD_95 : ('D'|'d')('A'|'a')('Y'|'y')('S'|'s')('I'|'i')('N'|'n')('M'|'m')('O'|'o')('N'|'n')('T'|'t')('H'|'h');

KEYWORD_94 : ('T'|'t')('I'|'i')('M'|'m')('E'|'e')('S'|'s')('E'|'e')('R'|'r')('I'|'i')('E'|'e')('S'|'s');

KEYWORD_89 : ('C'|'c')('O'|'o')('N'|'n')('D'|'d')('I'|'i')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

KEYWORD_90 : ('C'|'c')('O'|'o')('N'|'n')('S'|'s')('T'|'t')('R'|'r')('A'|'a')('I'|'i')('N'|'n');

KEYWORD_91 : ('O'|'o')('B'|'b')('J'|'j')('E'|'e')('C'|'c')('T'|'t')('I'|'i')('V'|'v')('E'|'e');

KEYWORD_92 : ('U'|'u')('N'|'n')('B'|'b')('O'|'o')('U'|'u')('N'|'n')('D'|'d')('E'|'e')('D'|'d');

KEYWORD_93 : ('W'|'w')('A'|'a')('T'|'t')('E'|'e')('R'|'r')('Y'|'y')('E'|'e')('A'|'a')('R'|'r');

KEYWORD_86 : ('E'|'e')('X'|'x')('T'|'t')('E'|'e')('R'|'r')('N'|'n')('A'|'a')('L'|'l');

KEYWORD_87 : ('S'|'s')('E'|'e')('Q'|'q')('U'|'u')('E'|'e')('N'|'n')('C'|'c')('E'|'e');

KEYWORD_88 : ('T'|'t')('I'|'i')('M'|'m')('E'|'e')('S'|'s')('T'|'t')('E'|'e')('P'|'p');

KEYWORD_66 : ('C'|'c')('O'|'o')('N'|'n')('V'|'v')('E'|'e')('R'|'r')('T'|'t');

KEYWORD_67 : ('D'|'d')('E'|'e')('C'|'c')('L'|'l')('A'|'a')('R'|'r')('E'|'e');

KEYWORD_68 : ('I'|'i')('N'|'n')('C'|'c')('L'|'l')('U'|'u')('D'|'d')('E'|'e');

KEYWORD_69 : ('I'|'i')('N'|'n')('I'|'i')('T'|'t')('I'|'i')('A'|'a')('L'|'l');

KEYWORD_70 : ('I'|'i')('N'|'n')('T'|'t')('E'|'e')('G'|'g')('E'|'e')('R'|'r');

KEYWORD_71 : ('P'|'p')('E'|'e')('N'|'n')('A'|'a')('L'|'l')('T'|'t')('Y'|'y');

KEYWORD_72 : ('C'|'c')('F'|'f')('S'|'s')'_'('T'|'t')('A'|'a')('F'|'f');

KEYWORD_73 : ('P'|'p')('R'|'r')('E'|'e')('V'|'v')('A'|'a')('P'|'p')('R'|'r');

KEYWORD_74 : ('P'|'p')('R'|'r')('E'|'e')('V'|'v')('A'|'a')('U'|'u')('G'|'g');

KEYWORD_75 : ('P'|'p')('R'|'r')('E'|'e')('V'|'v')('D'|'d')('E'|'e')('C'|'c');

KEYWORD_76 : ('P'|'p')('R'|'r')('E'|'e')('V'|'v')('F'|'f')('E'|'e')('B'|'b');

KEYWORD_77 : ('P'|'p')('R'|'r')('E'|'e')('V'|'v')('J'|'j')('A'|'a')('N'|'n');

KEYWORD_78 : ('P'|'p')('R'|'r')('E'|'e')('V'|'v')('J'|'j')('U'|'u')('L'|'l');

KEYWORD_79 : ('P'|'p')('R'|'r')('E'|'e')('V'|'v')('J'|'j')('U'|'u')('N'|'n');

KEYWORD_80 : ('P'|'p')('R'|'r')('E'|'e')('V'|'v')('M'|'m')('A'|'a')('R'|'r');

KEYWORD_81 : ('P'|'p')('R'|'r')('E'|'e')('V'|'v')('M'|'m')('A'|'a')('Y'|'y');

KEYWORD_82 : ('P'|'p')('R'|'r')('E'|'e')('V'|'v')('N'|'n')('O'|'o')('V'|'v');

KEYWORD_83 : ('P'|'p')('R'|'r')('E'|'e')('V'|'v')('O'|'o')('C'|'c')('T'|'t');

KEYWORD_84 : ('P'|'p')('R'|'r')('E'|'e')('V'|'v')('S'|'s')('E'|'e')('P'|'p');

KEYWORD_85 : ('T'|'t')('A'|'a')('F'|'f')'_'('C'|'c')('F'|'f')('S'|'s');

KEYWORD_61 : ('D'|'d')('E'|'e')('F'|'f')('I'|'i')('N'|'n')('E'|'e');

KEYWORD_62 : ('S'|'s')('E'|'e')('L'|'l')('E'|'e')('C'|'c')('T'|'t');

KEYWORD_63 : ('A'|'a')('F'|'f')'_'('C'|'c')('F'|'f')('S'|'s');

KEYWORD_64 : ('C'|'c')('F'|'f')('S'|'s')'_'('A'|'a')('F'|'f');

KEYWORD_65 : ('D'|'d')('A'|'a')('Y'|'y')('S'|'s')('I'|'i')('N'|'n');

KEYWORD_50 : ('A'|'a')('L'|'l')('I'|'i')('A'|'a')('S'|'s');

KEYWORD_51 : ('C'|'c')('O'|'o')('N'|'n')('S'|'s')('T'|'t');

KEYWORD_52 : ('G'|'g')('I'|'i')('V'|'v')('E'|'e')('N'|'n');

KEYWORD_53 : ('L'|'l')('O'|'o')('C'|'c')('A'|'a')('L'|'l');

KEYWORD_54 : ('L'|'l')('O'|'o')('W'|'w')('E'|'e')('R'|'r');

KEYWORD_55 : ('M'|'m')('O'|'o')('D'|'d')('E'|'e')('L'|'l');

KEYWORD_56 : ('U'|'u')('N'|'n')('I'|'i')('T'|'t')('S'|'s');

KEYWORD_57 : ('U'|'u')('P'|'p')('P'|'p')('E'|'e')('R'|'r');

KEYWORD_58 : ('V'|'v')('A'|'a')('L'|'l')('U'|'u')('E'|'e');

KEYWORD_59 : ('W'|'w')('H'|'h')('E'|'e')('R'|'r')('E'|'e');

KEYWORD_60 : ('M'|'m')('O'|'o')('N'|'n')('T'|'t')('H'|'h');

KEYWORD_41 : '.'('D'|'d')('L'|'l')('L'|'l');

KEYWORD_42 : '1'('D'|'d')('A'|'a')('Y'|'y');

KEYWORD_43 : '1'('M'|'m')('O'|'o')('N'|'n');

KEYWORD_44 : ('C'|'c')('A'|'a')('S'|'s')('E'|'e');

KEYWORD_45 : ('D'|'d')('V'|'v')('A'|'a')('R'|'r');

KEYWORD_46 : ('F'|'f')('R'|'r')('O'|'o')('M'|'m');

KEYWORD_47 : ('G'|'g')('O'|'o')('A'|'a')('L'|'l');

KEYWORD_48 : ('K'|'k')('I'|'i')('N'|'n')('D'|'d');

KEYWORD_49 : ('S'|'s')('V'|'v')('A'|'a')('R'|'r');

KEYWORD_22 : ('F'|'f')'9''0';

KEYWORD_23 : ('L'|'l')('H'|'h')('S'|'s');

KEYWORD_24 : ('R'|'r')('H'|'h')('S'|'s');

KEYWORD_25 : ('S'|'s')('T'|'t')('D'|'d');

KEYWORD_26 : ('S'|'s')('U'|'u')('M'|'m');

KEYWORD_27 : ('U'|'u')('S'|'s')('E'|'e');

KEYWORD_28 : ('A'|'a')('P'|'p')('R'|'r');

KEYWORD_29 : ('A'|'a')('U'|'u')('G'|'g');

KEYWORD_30 : ('D'|'d')('A'|'a')('Y'|'y');

KEYWORD_31 : ('D'|'d')('E'|'e')('C'|'c');

KEYWORD_32 : ('F'|'f')('E'|'e')('B'|'b');

KEYWORD_33 : ('J'|'j')('A'|'a')('N'|'n');

KEYWORD_34 : ('J'|'j')('U'|'u')('L'|'l');

KEYWORD_35 : ('J'|'j')('U'|'u')('N'|'n');

KEYWORD_36 : ('M'|'m')('A'|'a')('R'|'r');

KEYWORD_37 : ('M'|'m')('A'|'a')('Y'|'y');

KEYWORD_38 : ('N'|'n')('O'|'o')('V'|'v');

KEYWORD_39 : ('O'|'o')('C'|'c')('T'|'t');

KEYWORD_40 : ('S'|'s')('E'|'e')('P'|'p');

KEYWORD_16 : '$'('M'|'m');

KEYWORD_17 : '/''=';

KEYWORD_18 : '<''=';

KEYWORD_19 : '=''=';

KEYWORD_20 : '>''=';

KEYWORD_21 : ('I'|'i')'=';

KEYWORD_1 : '(';

KEYWORD_2 : ')';

KEYWORD_3 : '*';

KEYWORD_4 : '+';

KEYWORD_5 : ',';

KEYWORD_6 : '-';

KEYWORD_7 : '/';

KEYWORD_8 : '<';

KEYWORD_9 : '=';

KEYWORD_10 : '>';

KEYWORD_11 : '[';

KEYWORD_12 : ']';

KEYWORD_13 : ('I'|'i');

KEYWORD_14 : '{';

KEYWORD_15 : '}';



RULE_IF : ('If'|'IF'|'if');

RULE_ELSEIF : ('Elseif'|'ELSEIF'|'elseif'|'ElseIf');

RULE_ELSE : ('Else'|'ELSE'|'else');

RULE_RANGE : ('range'|'RANGE'|'Range');

RULE_MIN : ('min'|'MIN');

RULE_MAX : ('max'|'MAX');

RULE_MOD : ('mod'|'MOD');

RULE_INTFUNC : ('int'|'INT');

RULE_ABS : ('abs'|'ABS');

RULE_POW : ('pow'|'POW');

RULE_LOG : ('log'|'LOG'|'log10'|'LOG10');

RULE_FLOAT : (RULE_INT '.' RULE_INT*|'.' RULE_INT+);

RULE_AND : ('.and.'|'.AND.');

RULE_OR : ('.or.'|'.OR.');

RULE_NOT : ('.not.'|'.NOT.');

RULE_ALWAYS : 'always';

RULE_ORDER : 'order';

RULE_STRING : '\'' ~(('\''|'\n'|'\r'))* '\'';

RULE_SL_COMMENT : '!' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_ID : ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;



