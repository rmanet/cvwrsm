package gov.ca.dwr.wresl.xtext.editor.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalWreslEditorLexer extends Lexer {
    public static final int RULE_ID=68;
    public static final int RULE_ANY_OTHER=71;
    public static final int RULE_OR=62;
    public static final int KEYWORD_19=41;
    public static final int RULE_MAX=58;
    public static final int KEYWORD_17=39;
    public static final int KEYWORD_18=40;
    public static final int RULE_AND=61;
    public static final int KEYWORD_52=4;
    public static final int KEYWORD_15=37;
    public static final int KEYWORD_51=8;
    public static final int KEYWORD_16=38;
    public static final int KEYWORD_13=54;
    public static final int KEYWORD_50=7;
    public static final int KEYWORD_14=55;
    public static final int KEYWORD_11=52;
    public static final int KEYWORD_12=53;
    public static final int EOF=-1;
    public static final int RULE_NOT=63;
    public static final int KEYWORD_10=51;
    public static final int KEYWORD_6=47;
    public static final int KEYWORD_7=48;
    public static final int KEYWORD_8=49;
    public static final int KEYWORD_9=50;
    public static final int KEYWORD_28=28;
    public static final int KEYWORD_29=29;
    public static final int RULE_INT=59;
    public static final int KEYWORD_24=35;
    public static final int KEYWORD_25=36;
    public static final int KEYWORD_26=26;
    public static final int KEYWORD_27=27;
    public static final int KEYWORD_20=31;
    public static final int KEYWORD_21=32;
    public static final int KEYWORD_22=33;
    public static final int KEYWORD_23=34;
    public static final int RULE_ORDER=65;
    public static final int RULE_MIN=57;
    public static final int KEYWORD_30=30;
    public static final int KEYWORD_1=42;
    public static final int KEYWORD_5=46;
    public static final int KEYWORD_34=20;
    public static final int KEYWORD_4=45;
    public static final int KEYWORD_33=19;
    public static final int KEYWORD_3=44;
    public static final int KEYWORD_32=18;
    public static final int KEYWORD_31=17;
    public static final int KEYWORD_2=43;
    public static final int RULE_FLOAT=60;
    public static final int KEYWORD_38=24;
    public static final int RULE_SL_COMMENT=67;
    public static final int KEYWORD_37=23;
    public static final int KEYWORD_36=22;
    public static final int KEYWORD_35=21;
    public static final int RULE_ML_COMMENT=69;
    public static final int RULE_RANGE=56;
    public static final int KEYWORD_39=25;
    public static final int RULE_STRING=66;
    public static final int RULE_ALWAYS=64;
    public static final int KEYWORD_41=16;
    public static final int KEYWORD_40=15;
    public static final int KEYWORD_43=12;
    public static final int KEYWORD_42=11;
    public static final int KEYWORD_45=14;
    public static final int KEYWORD_44=13;
    public static final int RULE_WS=70;
    public static final int KEYWORD_47=10;
    public static final int KEYWORD_46=9;
    public static final int KEYWORD_49=6;
    public static final int KEYWORD_48=5;

    // delegates
    // delegators

    public InternalWreslEditorLexer() {;} 
    public InternalWreslEditorLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalWreslEditorLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g"; }

    // $ANTLR start "KEYWORD_52"
    public final void mKEYWORD_52() throws RecognitionException {
        try {
            int _type = KEYWORD_52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:19:12: ( ( 'T' | 't' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'E' | 'e' ) ( 'S' | 's' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:19:14: ( 'T' | 't' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'E' | 'e' ) ( 'S' | 's' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_52"

    // $ANTLR start "KEYWORD_48"
    public final void mKEYWORD_48() throws RecognitionException {
        try {
            int _type = KEYWORD_48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:21:12: ( ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:21:14: ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_48"

    // $ANTLR start "KEYWORD_49"
    public final void mKEYWORD_49() throws RecognitionException {
        try {
            int _type = KEYWORD_49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:23:12: ( ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'I' | 'i' ) ( 'N' | 'n' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:23:14: ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'I' | 'i' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_49"

    // $ANTLR start "KEYWORD_50"
    public final void mKEYWORD_50() throws RecognitionException {
        try {
            int _type = KEYWORD_50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:25:12: ( ( 'O' | 'o' ) ( 'B' | 'b' ) ( 'J' | 'j' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'V' | 'v' ) ( 'E' | 'e' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:25:14: ( 'O' | 'o' ) ( 'B' | 'b' ) ( 'J' | 'j' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'V' | 'v' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='J'||input.LA(1)=='j' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_50"

    // $ANTLR start "KEYWORD_51"
    public final void mKEYWORD_51() throws RecognitionException {
        try {
            int _type = KEYWORD_51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:27:12: ( ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'B' | 'b' ) ( 'O' | 'o' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'D' | 'd' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:27:14: ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'B' | 'b' ) ( 'O' | 'o' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_51"

    // $ANTLR start "KEYWORD_46"
    public final void mKEYWORD_46() throws RecognitionException {
        try {
            int _type = KEYWORD_46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:29:12: ( ( 'E' | 'e' ) ( 'X' | 'x' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'N' | 'n' ) ( 'A' | 'a' ) ( 'L' | 'l' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:29:14: ( 'E' | 'e' ) ( 'X' | 'x' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'N' | 'n' ) ( 'A' | 'a' ) ( 'L' | 'l' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_46"

    // $ANTLR start "KEYWORD_47"
    public final void mKEYWORD_47() throws RecognitionException {
        try {
            int _type = KEYWORD_47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:31:12: ( ( 'S' | 's' ) ( 'E' | 'e' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'E' | 'e' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:31:14: ( 'S' | 's' ) ( 'E' | 'e' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_47"

    // $ANTLR start "KEYWORD_42"
    public final void mKEYWORD_42() throws RecognitionException {
        try {
            int _type = KEYWORD_42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:33:12: ( ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:33:14: ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_42"

    // $ANTLR start "KEYWORD_43"
    public final void mKEYWORD_43() throws RecognitionException {
        try {
            int _type = KEYWORD_43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:35:12: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'D' | 'd' ) ( 'E' | 'e' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:35:14: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'D' | 'd' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_43"

    // $ANTLR start "KEYWORD_44"
    public final void mKEYWORD_44() throws RecognitionException {
        try {
            int _type = KEYWORD_44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:37:12: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:37:14: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'E' | 'e' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_44"

    // $ANTLR start "KEYWORD_45"
    public final void mKEYWORD_45() throws RecognitionException {
        try {
            int _type = KEYWORD_45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:39:12: ( ( 'P' | 'p' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'T' | 't' ) ( 'Y' | 'y' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:39:14: ( 'P' | 'p' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'T' | 't' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_45"

    // $ANTLR start "KEYWORD_40"
    public final void mKEYWORD_40() throws RecognitionException {
        try {
            int _type = KEYWORD_40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:41:12: ( ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'E' | 'e' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:41:14: ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_40"

    // $ANTLR start "KEYWORD_41"
    public final void mKEYWORD_41() throws RecognitionException {
        try {
            int _type = KEYWORD_41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:43:12: ( ( 'S' | 's' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'T' | 't' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:43:14: ( 'S' | 's' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_41"

    // $ANTLR start "KEYWORD_31"
    public final void mKEYWORD_31() throws RecognitionException {
        try {
            int _type = KEYWORD_31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:45:12: ( ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'A' | 'a' ) ( 'S' | 's' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:45:14: ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'A' | 'a' ) ( 'S' | 's' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_31"

    // $ANTLR start "KEYWORD_32"
    public final void mKEYWORD_32() throws RecognitionException {
        try {
            int _type = KEYWORD_32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:47:12: ( ( 'G' | 'g' ) ( 'I' | 'i' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'N' | 'n' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:47:14: ( 'G' | 'g' ) ( 'I' | 'i' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_32"

    // $ANTLR start "KEYWORD_33"
    public final void mKEYWORD_33() throws RecognitionException {
        try {
            int _type = KEYWORD_33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:49:12: ( ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'L' | 'l' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:49:14: ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'L' | 'l' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_33"

    // $ANTLR start "KEYWORD_34"
    public final void mKEYWORD_34() throws RecognitionException {
        try {
            int _type = KEYWORD_34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:51:12: ( ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'W' | 'w' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:51:14: ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'W' | 'w' ) ( 'E' | 'e' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_34"

    // $ANTLR start "KEYWORD_35"
    public final void mKEYWORD_35() throws RecognitionException {
        try {
            int _type = KEYWORD_35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:53:12: ( ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:53:14: ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_35"

    // $ANTLR start "KEYWORD_36"
    public final void mKEYWORD_36() throws RecognitionException {
        try {
            int _type = KEYWORD_36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:55:12: ( ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'S' | 's' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:55:14: ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'S' | 's' )
            {
            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_36"

    // $ANTLR start "KEYWORD_37"
    public final void mKEYWORD_37() throws RecognitionException {
        try {
            int _type = KEYWORD_37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:57:12: ( ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'P' | 'p' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:57:14: ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'P' | 'p' ) ( 'E' | 'e' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_37"

    // $ANTLR start "KEYWORD_38"
    public final void mKEYWORD_38() throws RecognitionException {
        try {
            int _type = KEYWORD_38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:59:12: ( ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:59:14: ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_38"

    // $ANTLR start "KEYWORD_39"
    public final void mKEYWORD_39() throws RecognitionException {
        try {
            int _type = KEYWORD_39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:61:12: ( ( 'W' | 'w' ) ( 'H' | 'h' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'E' | 'e' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:61:14: ( 'W' | 'w' ) ( 'H' | 'h' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_39"

    // $ANTLR start "KEYWORD_26"
    public final void mKEYWORD_26() throws RecognitionException {
        try {
            int _type = KEYWORD_26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:63:12: ( '.' ( 'D' | 'd' ) ( 'L' | 'l' ) ( 'L' | 'l' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:63:14: '.' ( 'D' | 'd' ) ( 'L' | 'l' ) ( 'L' | 'l' )
            {
            match('.'); 
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_26"

    // $ANTLR start "KEYWORD_27"
    public final void mKEYWORD_27() throws RecognitionException {
        try {
            int _type = KEYWORD_27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:65:12: ( ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:65:14: ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_27"

    // $ANTLR start "KEYWORD_28"
    public final void mKEYWORD_28() throws RecognitionException {
        try {
            int _type = KEYWORD_28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:67:12: ( ( 'F' | 'f' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'M' | 'm' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:67:14: ( 'F' | 'f' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'M' | 'm' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_28"

    // $ANTLR start "KEYWORD_29"
    public final void mKEYWORD_29() throws RecognitionException {
        try {
            int _type = KEYWORD_29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:69:12: ( ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'A' | 'a' ) ( 'L' | 'l' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:69:14: ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'A' | 'a' ) ( 'L' | 'l' )
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_29"

    // $ANTLR start "KEYWORD_30"
    public final void mKEYWORD_30() throws RecognitionException {
        try {
            int _type = KEYWORD_30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:71:12: ( ( 'K' | 'k' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'D' | 'd' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:71:14: ( 'K' | 'k' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_30"

    // $ANTLR start "KEYWORD_20"
    public final void mKEYWORD_20() throws RecognitionException {
        try {
            int _type = KEYWORD_20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:73:12: ( ( 'F' | 'f' ) '9' '0' )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:73:14: ( 'F' | 'f' ) '9' '0'
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('9'); 
            match('0'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_20"

    // $ANTLR start "KEYWORD_21"
    public final void mKEYWORD_21() throws RecognitionException {
        try {
            int _type = KEYWORD_21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:75:12: ( ( 'L' | 'l' ) ( 'H' | 'h' ) ( 'S' | 's' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:75:14: ( 'L' | 'l' ) ( 'H' | 'h' ) ( 'S' | 's' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_21"

    // $ANTLR start "KEYWORD_22"
    public final void mKEYWORD_22() throws RecognitionException {
        try {
            int _type = KEYWORD_22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:77:12: ( ( 'R' | 'r' ) ( 'H' | 'h' ) ( 'S' | 's' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:77:14: ( 'R' | 'r' ) ( 'H' | 'h' ) ( 'S' | 's' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_22"

    // $ANTLR start "KEYWORD_23"
    public final void mKEYWORD_23() throws RecognitionException {
        try {
            int _type = KEYWORD_23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:79:12: ( ( 'S' | 's' ) ( 'T' | 't' ) ( 'D' | 'd' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:79:14: ( 'S' | 's' ) ( 'T' | 't' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_23"

    // $ANTLR start "KEYWORD_24"
    public final void mKEYWORD_24() throws RecognitionException {
        try {
            int _type = KEYWORD_24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:81:12: ( ( 'S' | 's' ) ( 'U' | 'u' ) ( 'M' | 'm' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:81:14: ( 'S' | 's' ) ( 'U' | 'u' ) ( 'M' | 'm' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_24"

    // $ANTLR start "KEYWORD_25"
    public final void mKEYWORD_25() throws RecognitionException {
        try {
            int _type = KEYWORD_25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:83:12: ( ( 'U' | 'u' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:83:14: ( 'U' | 'u' ) ( 'S' | 's' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_25"

    // $ANTLR start "KEYWORD_15"
    public final void mKEYWORD_15() throws RecognitionException {
        try {
            int _type = KEYWORD_15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:85:12: ( '/' '=' )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:85:14: '/' '='
            {
            match('/'); 
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_15"

    // $ANTLR start "KEYWORD_16"
    public final void mKEYWORD_16() throws RecognitionException {
        try {
            int _type = KEYWORD_16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:87:12: ( '<' '=' )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:87:14: '<' '='
            {
            match('<'); 
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_16"

    // $ANTLR start "KEYWORD_17"
    public final void mKEYWORD_17() throws RecognitionException {
        try {
            int _type = KEYWORD_17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:89:12: ( '=' '=' )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:89:14: '=' '='
            {
            match('='); 
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_17"

    // $ANTLR start "KEYWORD_18"
    public final void mKEYWORD_18() throws RecognitionException {
        try {
            int _type = KEYWORD_18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:91:12: ( '>' '=' )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:91:14: '>' '='
            {
            match('>'); 
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_18"

    // $ANTLR start "KEYWORD_19"
    public final void mKEYWORD_19() throws RecognitionException {
        try {
            int _type = KEYWORD_19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:93:12: ( ( 'I' | 'i' ) '=' )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:93:14: ( 'I' | 'i' ) '='
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_19"

    // $ANTLR start "KEYWORD_1"
    public final void mKEYWORD_1() throws RecognitionException {
        try {
            int _type = KEYWORD_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:95:11: ( '(' )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:95:13: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_1"

    // $ANTLR start "KEYWORD_2"
    public final void mKEYWORD_2() throws RecognitionException {
        try {
            int _type = KEYWORD_2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:97:11: ( ')' )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:97:13: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_2"

    // $ANTLR start "KEYWORD_3"
    public final void mKEYWORD_3() throws RecognitionException {
        try {
            int _type = KEYWORD_3;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:99:11: ( '*' )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:99:13: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_3"

    // $ANTLR start "KEYWORD_4"
    public final void mKEYWORD_4() throws RecognitionException {
        try {
            int _type = KEYWORD_4;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:101:11: ( '+' )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:101:13: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_4"

    // $ANTLR start "KEYWORD_5"
    public final void mKEYWORD_5() throws RecognitionException {
        try {
            int _type = KEYWORD_5;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:103:11: ( ',' )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:103:13: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_5"

    // $ANTLR start "KEYWORD_6"
    public final void mKEYWORD_6() throws RecognitionException {
        try {
            int _type = KEYWORD_6;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:105:11: ( '-' )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:105:13: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_6"

    // $ANTLR start "KEYWORD_7"
    public final void mKEYWORD_7() throws RecognitionException {
        try {
            int _type = KEYWORD_7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:107:11: ( '/' )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:107:13: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_7"

    // $ANTLR start "KEYWORD_8"
    public final void mKEYWORD_8() throws RecognitionException {
        try {
            int _type = KEYWORD_8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:109:11: ( '<' )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:109:13: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_8"

    // $ANTLR start "KEYWORD_9"
    public final void mKEYWORD_9() throws RecognitionException {
        try {
            int _type = KEYWORD_9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:111:11: ( '=' )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:111:13: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_9"

    // $ANTLR start "KEYWORD_10"
    public final void mKEYWORD_10() throws RecognitionException {
        try {
            int _type = KEYWORD_10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:113:12: ( '>' )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:113:14: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_10"

    // $ANTLR start "KEYWORD_11"
    public final void mKEYWORD_11() throws RecognitionException {
        try {
            int _type = KEYWORD_11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:115:12: ( '[' )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:115:14: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_11"

    // $ANTLR start "KEYWORD_12"
    public final void mKEYWORD_12() throws RecognitionException {
        try {
            int _type = KEYWORD_12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:117:12: ( ']' )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:117:14: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_12"

    // $ANTLR start "KEYWORD_13"
    public final void mKEYWORD_13() throws RecognitionException {
        try {
            int _type = KEYWORD_13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:119:12: ( '{' )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:119:14: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_13"

    // $ANTLR start "KEYWORD_14"
    public final void mKEYWORD_14() throws RecognitionException {
        try {
            int _type = KEYWORD_14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:121:12: ( '}' )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:121:14: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_14"

    // $ANTLR start "RULE_RANGE"
    public final void mRULE_RANGE() throws RecognitionException {
        try {
            int _type = RULE_RANGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:125:12: ( ( 'range' | 'RANGE' | 'Range' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:125:14: ( 'range' | 'RANGE' | 'Range' )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:125:14: ( 'range' | 'RANGE' | 'Range' )
            int alt1=3;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='r') ) {
                alt1=1;
            }
            else if ( (LA1_0=='R') ) {
                int LA1_2 = input.LA(2);

                if ( (LA1_2=='A') ) {
                    alt1=2;
                }
                else if ( (LA1_2=='a') ) {
                    alt1=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:125:15: 'range'
                    {
                    match("range"); 


                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:125:23: 'RANGE'
                    {
                    match("RANGE"); 


                    }
                    break;
                case 3 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:125:31: 'Range'
                    {
                    match("Range"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_RANGE"

    // $ANTLR start "RULE_MIN"
    public final void mRULE_MIN() throws RecognitionException {
        try {
            int _type = RULE_MIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:127:10: ( ( 'min' | 'MIN' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:127:12: ( 'min' | 'MIN' )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:127:12: ( 'min' | 'MIN' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='m') ) {
                alt2=1;
            }
            else if ( (LA2_0=='M') ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:127:13: 'min'
                    {
                    match("min"); 


                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:127:19: 'MIN'
                    {
                    match("MIN"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_MIN"

    // $ANTLR start "RULE_MAX"
    public final void mRULE_MAX() throws RecognitionException {
        try {
            int _type = RULE_MAX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:129:10: ( ( 'max' | 'MAX' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:129:12: ( 'max' | 'MAX' )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:129:12: ( 'max' | 'MAX' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='m') ) {
                alt3=1;
            }
            else if ( (LA3_0=='M') ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:129:13: 'max'
                    {
                    match("max"); 


                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:129:19: 'MAX'
                    {
                    match("MAX"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_MAX"

    // $ANTLR start "RULE_FLOAT"
    public final void mRULE_FLOAT() throws RecognitionException {
        try {
            int _type = RULE_FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:131:12: ( ( RULE_INT '.' ( RULE_INT )* | '.' ( RULE_INT )+ ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:131:14: ( RULE_INT '.' ( RULE_INT )* | '.' ( RULE_INT )+ )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:131:14: ( RULE_INT '.' ( RULE_INT )* | '.' ( RULE_INT )+ )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                alt6=1;
            }
            else if ( (LA6_0=='.') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:131:15: RULE_INT '.' ( RULE_INT )*
                    {
                    mRULE_INT(); 
                    match('.'); 
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:131:28: ( RULE_INT )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:131:28: RULE_INT
                    	    {
                    	    mRULE_INT(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:131:38: '.' ( RULE_INT )+
                    {
                    match('.'); 
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:131:42: ( RULE_INT )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:131:42: RULE_INT
                    	    {
                    	    mRULE_INT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_FLOAT"

    // $ANTLR start "RULE_AND"
    public final void mRULE_AND() throws RecognitionException {
        try {
            int _type = RULE_AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:133:10: ( ( '.and.' | '.AND.' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:133:12: ( '.and.' | '.AND.' )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:133:12: ( '.and.' | '.AND.' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='.') ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1=='a') ) {
                    alt7=1;
                }
                else if ( (LA7_1=='A') ) {
                    alt7=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:133:13: '.and.'
                    {
                    match(".and."); 


                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:133:21: '.AND.'
                    {
                    match(".AND."); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_AND"

    // $ANTLR start "RULE_OR"
    public final void mRULE_OR() throws RecognitionException {
        try {
            int _type = RULE_OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:135:9: ( ( '.or.' | '.OR.' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:135:11: ( '.or.' | '.OR.' )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:135:11: ( '.or.' | '.OR.' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='.') ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1=='o') ) {
                    alt8=1;
                }
                else if ( (LA8_1=='O') ) {
                    alt8=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:135:12: '.or.'
                    {
                    match(".or."); 


                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:135:19: '.OR.'
                    {
                    match(".OR."); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_OR"

    // $ANTLR start "RULE_NOT"
    public final void mRULE_NOT() throws RecognitionException {
        try {
            int _type = RULE_NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:137:10: ( ( '.not.' | '.NOT.' ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:137:12: ( '.not.' | '.NOT.' )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:137:12: ( '.not.' | '.NOT.' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='.') ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1=='n') ) {
                    alt9=1;
                }
                else if ( (LA9_1=='N') ) {
                    alt9=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:137:13: '.not.'
                    {
                    match(".not."); 


                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:137:21: '.NOT.'
                    {
                    match(".NOT."); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NOT"

    // $ANTLR start "RULE_ALWAYS"
    public final void mRULE_ALWAYS() throws RecognitionException {
        try {
            int _type = RULE_ALWAYS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:139:13: ( 'always' )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:139:15: 'always'
            {
            match("always"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ALWAYS"

    // $ANTLR start "RULE_ORDER"
    public final void mRULE_ORDER() throws RecognitionException {
        try {
            int _type = RULE_ORDER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:141:12: ( 'order' )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:141:14: 'order'
            {
            match("order"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ORDER"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:143:13: ( '\\'' (~ ( ( '\\'' | '\\n' | '\\r' ) ) )* '\\'' )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:143:15: '\\'' (~ ( ( '\\'' | '\\n' | '\\r' ) ) )* '\\''
            {
            match('\''); 
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:143:20: (~ ( ( '\\'' | '\\n' | '\\r' ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='&')||(LA10_0>='(' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:143:20: ~ ( ( '\\'' | '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:145:17: ( '!' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:145:19: '!' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match('!'); 
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:145:23: (~ ( ( '\\n' | '\\r' ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\u0000' && LA11_0<='\t')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:145:23: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:145:39: ( ( '\\r' )? '\\n' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\n'||LA13_0=='\r') ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:145:40: ( '\\r' )? '\\n'
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:145:40: ( '\\r' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='\r') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:145:40: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:147:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:147:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:147:11: ( '^' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='^') ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:147:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:147:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='0' && LA15_0<='9')||(LA15_0>='A' && LA15_0<='Z')||LA15_0=='_'||(LA15_0>='a' && LA15_0<='z')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:149:10: ( ( '0' .. '9' )+ )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:149:12: ( '0' .. '9' )+
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:149:12: ( '0' .. '9' )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='0' && LA16_0<='9')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:149:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:151:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:151:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:151:24: ( options {greedy=false; } : . )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0=='*') ) {
                    int LA17_1 = input.LA(2);

                    if ( (LA17_1=='/') ) {
                        alt17=2;
                    }
                    else if ( ((LA17_1>='\u0000' && LA17_1<='.')||(LA17_1>='0' && LA17_1<='\uFFFF')) ) {
                        alt17=1;
                    }


                }
                else if ( ((LA17_0>='\u0000' && LA17_0<=')')||(LA17_0>='+' && LA17_0<='\uFFFF')) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:151:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:153:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:153:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:153:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>='\t' && LA18_0<='\n')||LA18_0=='\r'||LA18_0==' ') ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:155:16: ( . )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:155:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:8: ( KEYWORD_52 | KEYWORD_48 | KEYWORD_49 | KEYWORD_50 | KEYWORD_51 | KEYWORD_46 | KEYWORD_47 | KEYWORD_42 | KEYWORD_43 | KEYWORD_44 | KEYWORD_45 | KEYWORD_40 | KEYWORD_41 | KEYWORD_31 | KEYWORD_32 | KEYWORD_33 | KEYWORD_34 | KEYWORD_35 | KEYWORD_36 | KEYWORD_37 | KEYWORD_38 | KEYWORD_39 | KEYWORD_26 | KEYWORD_27 | KEYWORD_28 | KEYWORD_29 | KEYWORD_30 | KEYWORD_20 | KEYWORD_21 | KEYWORD_22 | KEYWORD_23 | KEYWORD_24 | KEYWORD_25 | KEYWORD_15 | KEYWORD_16 | KEYWORD_17 | KEYWORD_18 | KEYWORD_19 | KEYWORD_1 | KEYWORD_2 | KEYWORD_3 | KEYWORD_4 | KEYWORD_5 | KEYWORD_6 | KEYWORD_7 | KEYWORD_8 | KEYWORD_9 | KEYWORD_10 | KEYWORD_11 | KEYWORD_12 | KEYWORD_13 | KEYWORD_14 | RULE_RANGE | RULE_MIN | RULE_MAX | RULE_FLOAT | RULE_AND | RULE_OR | RULE_NOT | RULE_ALWAYS | RULE_ORDER | RULE_STRING | RULE_SL_COMMENT | RULE_ID | RULE_INT | RULE_ML_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt19=68;
        alt19 = dfa19.predict(input);
        switch (alt19) {
            case 1 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:10: KEYWORD_52
                {
                mKEYWORD_52(); 

                }
                break;
            case 2 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:21: KEYWORD_48
                {
                mKEYWORD_48(); 

                }
                break;
            case 3 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:32: KEYWORD_49
                {
                mKEYWORD_49(); 

                }
                break;
            case 4 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:43: KEYWORD_50
                {
                mKEYWORD_50(); 

                }
                break;
            case 5 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:54: KEYWORD_51
                {
                mKEYWORD_51(); 

                }
                break;
            case 6 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:65: KEYWORD_46
                {
                mKEYWORD_46(); 

                }
                break;
            case 7 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:76: KEYWORD_47
                {
                mKEYWORD_47(); 

                }
                break;
            case 8 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:87: KEYWORD_42
                {
                mKEYWORD_42(); 

                }
                break;
            case 9 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:98: KEYWORD_43
                {
                mKEYWORD_43(); 

                }
                break;
            case 10 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:109: KEYWORD_44
                {
                mKEYWORD_44(); 

                }
                break;
            case 11 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:120: KEYWORD_45
                {
                mKEYWORD_45(); 

                }
                break;
            case 12 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:131: KEYWORD_40
                {
                mKEYWORD_40(); 

                }
                break;
            case 13 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:142: KEYWORD_41
                {
                mKEYWORD_41(); 

                }
                break;
            case 14 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:153: KEYWORD_31
                {
                mKEYWORD_31(); 

                }
                break;
            case 15 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:164: KEYWORD_32
                {
                mKEYWORD_32(); 

                }
                break;
            case 16 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:175: KEYWORD_33
                {
                mKEYWORD_33(); 

                }
                break;
            case 17 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:186: KEYWORD_34
                {
                mKEYWORD_34(); 

                }
                break;
            case 18 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:197: KEYWORD_35
                {
                mKEYWORD_35(); 

                }
                break;
            case 19 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:208: KEYWORD_36
                {
                mKEYWORD_36(); 

                }
                break;
            case 20 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:219: KEYWORD_37
                {
                mKEYWORD_37(); 

                }
                break;
            case 21 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:230: KEYWORD_38
                {
                mKEYWORD_38(); 

                }
                break;
            case 22 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:241: KEYWORD_39
                {
                mKEYWORD_39(); 

                }
                break;
            case 23 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:252: KEYWORD_26
                {
                mKEYWORD_26(); 

                }
                break;
            case 24 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:263: KEYWORD_27
                {
                mKEYWORD_27(); 

                }
                break;
            case 25 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:274: KEYWORD_28
                {
                mKEYWORD_28(); 

                }
                break;
            case 26 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:285: KEYWORD_29
                {
                mKEYWORD_29(); 

                }
                break;
            case 27 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:296: KEYWORD_30
                {
                mKEYWORD_30(); 

                }
                break;
            case 28 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:307: KEYWORD_20
                {
                mKEYWORD_20(); 

                }
                break;
            case 29 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:318: KEYWORD_21
                {
                mKEYWORD_21(); 

                }
                break;
            case 30 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:329: KEYWORD_22
                {
                mKEYWORD_22(); 

                }
                break;
            case 31 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:340: KEYWORD_23
                {
                mKEYWORD_23(); 

                }
                break;
            case 32 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:351: KEYWORD_24
                {
                mKEYWORD_24(); 

                }
                break;
            case 33 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:362: KEYWORD_25
                {
                mKEYWORD_25(); 

                }
                break;
            case 34 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:373: KEYWORD_15
                {
                mKEYWORD_15(); 

                }
                break;
            case 35 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:384: KEYWORD_16
                {
                mKEYWORD_16(); 

                }
                break;
            case 36 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:395: KEYWORD_17
                {
                mKEYWORD_17(); 

                }
                break;
            case 37 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:406: KEYWORD_18
                {
                mKEYWORD_18(); 

                }
                break;
            case 38 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:417: KEYWORD_19
                {
                mKEYWORD_19(); 

                }
                break;
            case 39 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:428: KEYWORD_1
                {
                mKEYWORD_1(); 

                }
                break;
            case 40 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:438: KEYWORD_2
                {
                mKEYWORD_2(); 

                }
                break;
            case 41 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:448: KEYWORD_3
                {
                mKEYWORD_3(); 

                }
                break;
            case 42 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:458: KEYWORD_4
                {
                mKEYWORD_4(); 

                }
                break;
            case 43 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:468: KEYWORD_5
                {
                mKEYWORD_5(); 

                }
                break;
            case 44 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:478: KEYWORD_6
                {
                mKEYWORD_6(); 

                }
                break;
            case 45 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:488: KEYWORD_7
                {
                mKEYWORD_7(); 

                }
                break;
            case 46 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:498: KEYWORD_8
                {
                mKEYWORD_8(); 

                }
                break;
            case 47 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:508: KEYWORD_9
                {
                mKEYWORD_9(); 

                }
                break;
            case 48 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:518: KEYWORD_10
                {
                mKEYWORD_10(); 

                }
                break;
            case 49 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:529: KEYWORD_11
                {
                mKEYWORD_11(); 

                }
                break;
            case 50 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:540: KEYWORD_12
                {
                mKEYWORD_12(); 

                }
                break;
            case 51 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:551: KEYWORD_13
                {
                mKEYWORD_13(); 

                }
                break;
            case 52 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:562: KEYWORD_14
                {
                mKEYWORD_14(); 

                }
                break;
            case 53 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:573: RULE_RANGE
                {
                mRULE_RANGE(); 

                }
                break;
            case 54 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:584: RULE_MIN
                {
                mRULE_MIN(); 

                }
                break;
            case 55 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:593: RULE_MAX
                {
                mRULE_MAX(); 

                }
                break;
            case 56 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:602: RULE_FLOAT
                {
                mRULE_FLOAT(); 

                }
                break;
            case 57 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:613: RULE_AND
                {
                mRULE_AND(); 

                }
                break;
            case 58 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:622: RULE_OR
                {
                mRULE_OR(); 

                }
                break;
            case 59 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:630: RULE_NOT
                {
                mRULE_NOT(); 

                }
                break;
            case 60 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:639: RULE_ALWAYS
                {
                mRULE_ALWAYS(); 

                }
                break;
            case 61 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:651: RULE_ORDER
                {
                mRULE_ORDER(); 

                }
                break;
            case 62 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:662: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 63 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:674: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 64 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:690: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 65 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:698: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 66 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:707: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 67 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:723: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 68 :
                // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/lexer/InternalWreslEditorLexer.g:1:731: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA19_eotS =
        "\1\uffff\17\56\1\54\3\56\1\125\1\127\1\131\1\133\12\uffff\2\56"+
        "\1\152\2\56\1\54\1\uffff\1\54\3\uffff\1\56\1\uffff\14\56\1\uffff"+
        "\15\56\5\uffff\5\56\23\uffff\4\56\1\uffff\1\152\3\uffff\10\56\1"+
        "\u00a0\3\56\1\u00a4\1\u00a5\12\56\1\u00b0\1\56\1\u00b2\1\u00b3\3"+
        "\56\1\u00b7\1\56\1\u00b9\3\56\1\u00b2\1\u00b3\4\56\1\u00c1\5\56"+
        "\1\uffff\3\56\2\uffff\7\56\1\u00d1\2\56\1\uffff\1\56\2\uffff\2\56"+
        "\1\u00d7\1\uffff\1\u00d8\1\uffff\7\56\1\uffff\1\56\1\u00e1\1\56"+
        "\1\u00e3\1\u00e4\7\56\1\u00ec\1\56\1\u00ee\1\uffff\1\u00ef\1\u00f0"+
        "\1\u00f1\1\u00f2\1\u00f3\2\uffff\3\u00f4\5\56\1\uffff\1\56\2\uffff"+
        "\2\56\1\u00fd\3\56\1\u0101\1\uffff\1\u0102\7\uffff\3\56\1\u0106"+
        "\4\56\1\uffff\1\u010b\1\u010c\1\u010d\2\uffff\3\56\1\uffff\2\56"+
        "\1\u0113\1\u0114\3\uffff\1\56\1\u0116\1\u0117\1\u0118\1\u0119\2"+
        "\uffff\1\u011a\5\uffff";
    static final String DFA19_eofS =
        "\u011b\uffff";
    static final String DFA19_minS =
        "\1\0\1\111\1\101\1\102\1\116\1\130\1\105\1\75\2\105\1\114\1\111"+
        "\1\110\1\117\1\101\1\110\1\60\1\71\1\111\1\110\1\52\3\75\12\uffff"+
        "\2\101\1\56\1\114\1\102\1\0\1\uffff\1\101\3\uffff\1\115\1\uffff"+
        "\1\116\1\123\1\112\1\144\1\102\1\120\1\105\1\124\1\114\1\104\1\115"+
        "\1\103\1\uffff\1\116\1\106\2\111\1\126\1\101\1\103\1\123\1\104\1"+
        "\156\1\170\1\114\1\105\5\uffff\1\117\1\60\1\116\1\123\1\156\23\uffff"+
        "\1\116\1\156\1\116\1\130\1\uffff\1\56\3\uffff\1\105\1\104\2\105"+
        "\1\145\1\117\1\124\1\105\1\60\1\105\1\125\1\105\2\60\1\114\1\105"+
        "\1\101\1\111\1\101\1\141\1\105\1\114\1\101\1\105\1\60\1\105\2\60"+
        "\1\125\1\122\1\115\1\60\1\104\1\60\1\147\1\107\1\147\2\60\1\123"+
        "\1\111\1\124\1\105\1\60\1\103\1\162\1\125\1\123\1\122\1\uffff\1"+
        "\122\1\105\1\103\2\uffff\1\125\1\107\1\114\1\116\1\123\1\171\1\116"+
        "\1\60\1\114\1\122\1\uffff\1\114\2\uffff\2\105\1\60\1\uffff\1\60"+
        "\1\uffff\1\145\1\105\1\145\1\105\1\124\2\122\1\uffff\1\124\1\60"+
        "\1\116\2\60\2\116\1\124\1\104\1\105\1\124\1\105\1\60\1\163\1\60"+
        "\1\uffff\5\60\2\uffff\3\60\1\122\1\111\1\101\1\124\1\111\1\uffff"+
        "\1\104\2\uffff\1\101\1\103\1\60\1\105\1\122\1\131\1\60\1\uffff\1"+
        "\60\7\uffff\1\111\1\117\1\111\1\60\1\126\1\105\1\114\1\105\1\uffff"+
        "\3\60\2\uffff\1\105\2\116\1\uffff\1\105\1\104\2\60\3\uffff\1\123"+
        "\4\60\2\uffff\1\60\5\uffff";
    static final String DFA19_maxS =
        "\1\uffff\1\151\1\157\1\162\1\163\1\170\1\165\1\156\2\145\1\154"+
        "\3\157\1\141\1\150\1\157\1\162\1\151\1\150\4\75\12\uffff\1\150\1"+
        "\157\1\71\1\154\1\142\1\uffff\1\uffff\1\172\3\uffff\1\155\1\uffff"+
        "\1\156\1\163\1\152\1\144\1\151\1\160\1\145\1\164\1\161\1\144\1\155"+
        "\1\164\1\uffff\1\156\1\146\1\167\1\151\1\166\1\141\1\167\1\163\1"+
        "\144\1\156\1\170\1\154\1\145\5\uffff\1\157\1\60\1\156\1\163\1\156"+
        "\23\uffff\1\116\1\156\1\116\1\130\1\uffff\1\71\3\uffff\1\145\1\166"+
        "\3\145\1\157\1\164\1\145\1\172\1\145\1\165\1\145\2\172\1\154\1\145"+
        "\1\141\1\151\2\141\1\145\1\154\1\141\1\145\1\172\1\145\2\172\1\165"+
        "\1\162\1\155\1\172\1\144\1\172\1\147\1\107\1\147\2\172\1\163\1\151"+
        "\1\164\1\145\1\172\1\143\1\162\1\165\1\163\1\162\1\uffff\1\162\1"+
        "\145\1\143\2\uffff\1\165\1\147\1\154\1\156\1\163\1\171\1\156\1\172"+
        "\1\154\1\162\1\uffff\1\154\2\uffff\2\145\1\172\1\uffff\1\172\1\uffff"+
        "\1\145\1\105\2\145\1\164\2\162\1\uffff\1\164\1\172\1\156\2\172\2"+
        "\156\1\164\1\144\1\145\1\164\1\145\1\172\1\163\1\172\1\uffff\5\172"+
        "\2\uffff\3\172\1\162\1\151\1\141\1\164\1\151\1\uffff\1\144\2\uffff"+
        "\1\141\1\143\1\172\1\145\1\162\1\171\1\172\1\uffff\1\172\7\uffff"+
        "\1\151\1\157\1\151\1\172\1\166\1\145\1\154\1\145\1\uffff\3\172\2"+
        "\uffff\1\145\2\156\1\uffff\1\145\1\144\2\172\3\uffff\1\163\4\172"+
        "\2\uffff\1\172\5\uffff";
    static final String DFA19_acceptS =
        "\30\uffff\1\47\1\50\1\51\1\52\1\53\1\54\1\61\1\62\1\63\1\64\6\uffff"+
        "\1\77\1\uffff\1\100\1\103\1\104\1\uffff\1\100\14\uffff\1\46\15\uffff"+
        "\1\27\1\71\1\72\1\73\1\70\5\uffff\1\42\1\102\1\55\1\43\1\56\1\44"+
        "\1\57\1\45\1\60\1\47\1\50\1\51\1\52\1\53\1\54\1\61\1\62\1\63\1\64"+
        "\4\uffff\1\101\1\uffff\1\76\1\77\1\103\61\uffff\1\41\3\uffff\1\37"+
        "\1\40\12\uffff\1\35\1\uffff\1\66\1\67\3\uffff\1\34\1\uffff\1\36"+
        "\7\uffff\1\30\17\uffff\1\32\5\uffff\1\31\1\33\10\uffff\1\75\1\uffff"+
        "\1\23\1\24\7\uffff\1\16\1\uffff\1\17\1\20\1\21\1\22\1\25\1\26\1"+
        "\65\10\uffff\1\15\3\uffff\1\14\1\74\3\uffff\1\10\4\uffff\1\11\1"+
        "\12\1\13\5\uffff\1\6\1\7\1\uffff\1\2\1\3\1\4\1\5\1\1";
    static final String DFA19_specialS =
        "\1\1\46\uffff\1\0\u00f3\uffff}>";
    static final String[] DFA19_transitionS = {
            "\11\54\2\53\2\54\1\53\22\54\1\53\1\50\5\54\1\47\1\30\1\31\1"+
            "\32\1\33\1\34\1\35\1\20\1\24\12\44\2\54\1\25\1\26\1\27\2\54"+
            "\1\45\1\52\1\2\1\11\1\5\1\21\1\13\1\52\1\7\1\52\1\22\1\14\1"+
            "\43\1\52\1\46\1\10\1\52\1\42\1\6\1\1\1\4\1\16\1\17\3\52\1\36"+
            "\1\54\1\37\1\51\1\52\1\54\1\12\1\52\1\2\1\11\1\5\1\21\1\13\1"+
            "\52\1\7\1\52\1\22\1\14\1\15\1\52\1\3\1\10\1\52\1\23\1\6\1\1"+
            "\1\4\1\16\1\17\3\52\1\40\1\54\1\41\uff82\54",
            "\1\55\37\uffff\1\55",
            "\1\60\15\uffff\1\57\21\uffff\1\60\15\uffff\1\57",
            "\1\61\37\uffff\1\61\17\uffff\1\62",
            "\1\63\1\uffff\1\64\2\uffff\1\65\32\uffff\1\63\1\uffff\1\64"+
            "\2\uffff\1\65",
            "\1\66\37\uffff\1\66",
            "\1\67\16\uffff\1\70\1\71\17\uffff\1\67\16\uffff\1\70\1\71",
            "\1\73\20\uffff\1\72\37\uffff\1\72",
            "\1\74\37\uffff\1\74",
            "\1\75\37\uffff\1\75",
            "\1\77\37\uffff\1\76",
            "\1\100\5\uffff\1\101\31\uffff\1\100\5\uffff\1\101",
            "\1\103\6\uffff\1\102\30\uffff\1\103\6\uffff\1\102",
            "\1\104\21\uffff\1\106\7\uffff\1\105\5\uffff\1\104",
            "\1\107\37\uffff\1\107",
            "\1\110\37\uffff\1\110",
            "\12\115\7\uffff\1\112\2\uffff\1\111\11\uffff\1\114\1\113\21"+
            "\uffff\1\112\2\uffff\1\111\11\uffff\1\114\1\113",
            "\1\117\30\uffff\1\116\37\uffff\1\116",
            "\1\120\37\uffff\1\120",
            "\1\121\30\uffff\1\122\6\uffff\1\121",
            "\1\124\22\uffff\1\123",
            "\1\126",
            "\1\130",
            "\1\132",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\146\6\uffff\1\121\30\uffff\1\147\6\uffff\1\121",
            "\1\151\7\uffff\1\150\5\uffff\1\104\37\uffff\1\104",
            "\1\115\1\uffff\12\153",
            "\1\77\37\uffff\1\77",
            "\1\61\37\uffff\1\61",
            "\12\154\1\uffff\2\154\1\uffff\ufff2\154",
            "",
            "\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "",
            "",
            "\1\157\37\uffff\1\157",
            "",
            "\1\160\37\uffff\1\160",
            "\1\161\37\uffff\1\161",
            "\1\162\37\uffff\1\162",
            "\1\163",
            "\1\164\6\uffff\1\165\30\uffff\1\164\6\uffff\1\165",
            "\1\166\37\uffff\1\166",
            "\1\167\37\uffff\1\167",
            "\1\170\37\uffff\1\170",
            "\1\172\4\uffff\1\171\32\uffff\1\172\4\uffff\1\171",
            "\1\173\37\uffff\1\173",
            "\1\174\37\uffff\1\174",
            "\1\175\20\uffff\1\176\16\uffff\1\175\20\uffff\1\176",
            "",
            "\1\177\37\uffff\1\177",
            "\1\u0080\37\uffff\1\u0080",
            "\1\u0081\37\uffff\1\u0081\15\uffff\1\u0082",
            "\1\u0081\37\uffff\1\u0081",
            "\1\u0083\37\uffff\1\u0083",
            "\1\u0084\37\uffff\1\u0084",
            "\1\u0085\23\uffff\1\u0086\13\uffff\1\u0085\23\uffff\1\u0086",
            "\1\u0087\37\uffff\1\u0087",
            "\1\u0088\37\uffff\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b\37\uffff\1\u008b",
            "\1\u008c\37\uffff\1\u008c",
            "",
            "",
            "",
            "",
            "",
            "\1\u008d\37\uffff\1\u008d",
            "\1\u008e",
            "\1\u008f\37\uffff\1\u008f",
            "\1\u0090\37\uffff\1\u0090",
            "\1\u0091",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "",
            "\1\115\1\uffff\12\153",
            "",
            "",
            "",
            "\1\u0096\37\uffff\1\u0096",
            "\1\u0097\16\uffff\1\u0098\2\uffff\1\u0099\15\uffff\1\u0097"+
            "\16\uffff\1\u0098\2\uffff\1\u0099",
            "\1\u009a\37\uffff\1\u009a",
            "\1\u009b\37\uffff\1\u009b",
            "\1\u009c",
            "\1\u009d\37\uffff\1\u009d",
            "\1\u009e\37\uffff\1\u009e",
            "\1\u009f\37\uffff\1\u009f",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u00a1\37\uffff\1\u00a1",
            "\1\u00a2\37\uffff\1\u00a2",
            "\1\u00a3\37\uffff\1\u00a3",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u00a6\37\uffff\1\u00a6",
            "\1\u00a7\37\uffff\1\u00a7",
            "\1\u00a8\37\uffff\1\u00a8",
            "\1\u00a9\37\uffff\1\u00a9",
            "\1\u00aa\37\uffff\1\u00aa",
            "\1\u00ab",
            "\1\u00ac\37\uffff\1\u00ac",
            "\1\u00ad\37\uffff\1\u00ad",
            "\1\u00ae\37\uffff\1\u00ae",
            "\1\u00af\37\uffff\1\u00af",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u00b1\37\uffff\1\u00b1",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u00b4\37\uffff\1\u00b4",
            "\1\u00b5\37\uffff\1\u00b5",
            "\1\u00b6\37\uffff\1\u00b6",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u00b8\37\uffff\1\u00b8",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u00bd\37\uffff\1\u00bd",
            "\1\u00be\37\uffff\1\u00be",
            "\1\u00bf\37\uffff\1\u00bf",
            "\1\u00c0\37\uffff\1\u00c0",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u00c2\37\uffff\1\u00c2",
            "\1\u00c3",
            "\1\u00c4\37\uffff\1\u00c4",
            "\1\u00c5\37\uffff\1\u00c5",
            "\1\u00c6\37\uffff\1\u00c6",
            "",
            "\1\u00c7\37\uffff\1\u00c7",
            "\1\u00c8\37\uffff\1\u00c8",
            "\1\u00c9\37\uffff\1\u00c9",
            "",
            "",
            "\1\u00ca\37\uffff\1\u00ca",
            "\1\u00cb\37\uffff\1\u00cb",
            "\1\u00cc\37\uffff\1\u00cc",
            "\1\u00cd\37\uffff\1\u00cd",
            "\1\u00ce\37\uffff\1\u00ce",
            "\1\u00cf",
            "\1\u00d0\37\uffff\1\u00d0",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u00d2\37\uffff\1\u00d2",
            "\1\u00d3\37\uffff\1\u00d3",
            "",
            "\1\u00d4\37\uffff\1\u00d4",
            "",
            "",
            "\1\u00d5\37\uffff\1\u00d5",
            "\1\u00d6\37\uffff\1\u00d6",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\1\u00d9",
            "\1\u00da",
            "\1\u00db",
            "\1\u00dc\37\uffff\1\u00dc",
            "\1\u00dd\37\uffff\1\u00dd",
            "\1\u00de\37\uffff\1\u00de",
            "\1\u00df\37\uffff\1\u00df",
            "",
            "\1\u00e0\37\uffff\1\u00e0",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u00e2\37\uffff\1\u00e2",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u00e5\37\uffff\1\u00e5",
            "\1\u00e6\37\uffff\1\u00e6",
            "\1\u00e7\37\uffff\1\u00e7",
            "\1\u00e8\37\uffff\1\u00e8",
            "\1\u00e9\37\uffff\1\u00e9",
            "\1\u00ea\37\uffff\1\u00ea",
            "\1\u00eb\37\uffff\1\u00eb",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u00ed",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u00f5\37\uffff\1\u00f5",
            "\1\u00f6\37\uffff\1\u00f6",
            "\1\u00f7\37\uffff\1\u00f7",
            "\1\u00f8\37\uffff\1\u00f8",
            "\1\u00f9\37\uffff\1\u00f9",
            "",
            "\1\u00fa\37\uffff\1\u00fa",
            "",
            "",
            "\1\u00fb\37\uffff\1\u00fb",
            "\1\u00fc\37\uffff\1\u00fc",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u00fe\37\uffff\1\u00fe",
            "\1\u00ff\37\uffff\1\u00ff",
            "\1\u0100\37\uffff\1\u0100",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0103\37\uffff\1\u0103",
            "\1\u0104\37\uffff\1\u0104",
            "\1\u0105\37\uffff\1\u0105",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u0107\37\uffff\1\u0107",
            "\1\u0108\37\uffff\1\u0108",
            "\1\u0109\37\uffff\1\u0109",
            "\1\u010a\37\uffff\1\u010a",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "",
            "\1\u010e\37\uffff\1\u010e",
            "\1\u010f\37\uffff\1\u010f",
            "\1\u0110\37\uffff\1\u0110",
            "",
            "\1\u0111\37\uffff\1\u0111",
            "\1\u0112\37\uffff\1\u0112",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "",
            "",
            "\1\u0115\37\uffff\1\u0115",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( KEYWORD_52 | KEYWORD_48 | KEYWORD_49 | KEYWORD_50 | KEYWORD_51 | KEYWORD_46 | KEYWORD_47 | KEYWORD_42 | KEYWORD_43 | KEYWORD_44 | KEYWORD_45 | KEYWORD_40 | KEYWORD_41 | KEYWORD_31 | KEYWORD_32 | KEYWORD_33 | KEYWORD_34 | KEYWORD_35 | KEYWORD_36 | KEYWORD_37 | KEYWORD_38 | KEYWORD_39 | KEYWORD_26 | KEYWORD_27 | KEYWORD_28 | KEYWORD_29 | KEYWORD_30 | KEYWORD_20 | KEYWORD_21 | KEYWORD_22 | KEYWORD_23 | KEYWORD_24 | KEYWORD_25 | KEYWORD_15 | KEYWORD_16 | KEYWORD_17 | KEYWORD_18 | KEYWORD_19 | KEYWORD_1 | KEYWORD_2 | KEYWORD_3 | KEYWORD_4 | KEYWORD_5 | KEYWORD_6 | KEYWORD_7 | KEYWORD_8 | KEYWORD_9 | KEYWORD_10 | KEYWORD_11 | KEYWORD_12 | KEYWORD_13 | KEYWORD_14 | RULE_RANGE | RULE_MIN | RULE_MAX | RULE_FLOAT | RULE_AND | RULE_OR | RULE_NOT | RULE_ALWAYS | RULE_ORDER | RULE_STRING | RULE_SL_COMMENT | RULE_ID | RULE_INT | RULE_ML_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA19_39 = input.LA(1);

                        s = -1;
                        if ( ((LA19_39>='\u0000' && LA19_39<='\t')||(LA19_39>='\u000B' && LA19_39<='\f')||(LA19_39>='\u000E' && LA19_39<='\uFFFF')) ) {s = 108;}

                        else s = 44;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA19_0 = input.LA(1);

                        s = -1;
                        if ( (LA19_0=='T'||LA19_0=='t') ) {s = 1;}

                        else if ( (LA19_0=='C'||LA19_0=='c') ) {s = 2;}

                        else if ( (LA19_0=='o') ) {s = 3;}

                        else if ( (LA19_0=='U'||LA19_0=='u') ) {s = 4;}

                        else if ( (LA19_0=='E'||LA19_0=='e') ) {s = 5;}

                        else if ( (LA19_0=='S'||LA19_0=='s') ) {s = 6;}

                        else if ( (LA19_0=='I'||LA19_0=='i') ) {s = 7;}

                        else if ( (LA19_0=='P'||LA19_0=='p') ) {s = 8;}

                        else if ( (LA19_0=='D'||LA19_0=='d') ) {s = 9;}

                        else if ( (LA19_0=='a') ) {s = 10;}

                        else if ( (LA19_0=='G'||LA19_0=='g') ) {s = 11;}

                        else if ( (LA19_0=='L'||LA19_0=='l') ) {s = 12;}

                        else if ( (LA19_0=='m') ) {s = 13;}

                        else if ( (LA19_0=='V'||LA19_0=='v') ) {s = 14;}

                        else if ( (LA19_0=='W'||LA19_0=='w') ) {s = 15;}

                        else if ( (LA19_0=='.') ) {s = 16;}

                        else if ( (LA19_0=='F'||LA19_0=='f') ) {s = 17;}

                        else if ( (LA19_0=='K'||LA19_0=='k') ) {s = 18;}

                        else if ( (LA19_0=='r') ) {s = 19;}

                        else if ( (LA19_0=='/') ) {s = 20;}

                        else if ( (LA19_0=='<') ) {s = 21;}

                        else if ( (LA19_0=='=') ) {s = 22;}

                        else if ( (LA19_0=='>') ) {s = 23;}

                        else if ( (LA19_0=='(') ) {s = 24;}

                        else if ( (LA19_0==')') ) {s = 25;}

                        else if ( (LA19_0=='*') ) {s = 26;}

                        else if ( (LA19_0=='+') ) {s = 27;}

                        else if ( (LA19_0==',') ) {s = 28;}

                        else if ( (LA19_0=='-') ) {s = 29;}

                        else if ( (LA19_0=='[') ) {s = 30;}

                        else if ( (LA19_0==']') ) {s = 31;}

                        else if ( (LA19_0=='{') ) {s = 32;}

                        else if ( (LA19_0=='}') ) {s = 33;}

                        else if ( (LA19_0=='R') ) {s = 34;}

                        else if ( (LA19_0=='M') ) {s = 35;}

                        else if ( ((LA19_0>='0' && LA19_0<='9')) ) {s = 36;}

                        else if ( (LA19_0=='A') ) {s = 37;}

                        else if ( (LA19_0=='O') ) {s = 38;}

                        else if ( (LA19_0=='\'') ) {s = 39;}

                        else if ( (LA19_0=='!') ) {s = 40;}

                        else if ( (LA19_0=='^') ) {s = 41;}

                        else if ( (LA19_0=='B'||LA19_0=='H'||LA19_0=='J'||LA19_0=='N'||LA19_0=='Q'||(LA19_0>='X' && LA19_0<='Z')||LA19_0=='_'||LA19_0=='b'||LA19_0=='h'||LA19_0=='j'||LA19_0=='n'||LA19_0=='q'||(LA19_0>='x' && LA19_0<='z')) ) {s = 42;}

                        else if ( ((LA19_0>='\t' && LA19_0<='\n')||LA19_0=='\r'||LA19_0==' ') ) {s = 43;}

                        else if ( ((LA19_0>='\u0000' && LA19_0<='\b')||(LA19_0>='\u000B' && LA19_0<='\f')||(LA19_0>='\u000E' && LA19_0<='\u001F')||(LA19_0>='\"' && LA19_0<='&')||(LA19_0>=':' && LA19_0<=';')||(LA19_0>='?' && LA19_0<='@')||LA19_0=='\\'||LA19_0=='`'||LA19_0=='|'||(LA19_0>='~' && LA19_0<='\uFFFF')) ) {s = 44;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 19, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}