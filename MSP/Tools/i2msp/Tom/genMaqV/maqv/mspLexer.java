// $ANTLR 3.2 Sep 23, 2009 12:02:23 maqv/msp.g 2015-12-01 12:19:43
 package maqv; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class mspLexer extends Lexer {
    public static final int Decl=11;
    public static final int Jump=17;
    public static final int Pusha=14;
    public static final int Push=15;
    public static final int CHAR=54;
    public static final int Mul=33;
    public static final int Stackk=51;
    public static final int DChar=44;
    public static final int EOF=-1;
    public static final int Neq=28;
    public static final int Ret=37;
    public static final int T__93=93;
    public static final int Lt=25;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__90=90;
    public static final int Vazio=46;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int Mod=32;
    public static final int F=47;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int B=48;
    public static final int T__83=83;
    public static final int Halt=20;
    public static final int I=50;
    public static final int DFloat=42;
    public static final int Eq=29;
    public static final int INT=53;
    public static final int S=49;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int Nott=23;
    public static final int Dec=30;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int DBoolean=43;
    public static final int WS=60;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int Inc=31;
    public static final int SufixoFloat=57;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int Load=13;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int DIGITO=56;
    public static final int False=40;
    public static final int Gt=27;
    public static final int FLOAT=55;
    public static final int ID=59;
    public static final int T__61=61;
    public static final int Add=36;
    public static final int Jumpf=16;
    public static final int Call=38;
    public static final int DInt=45;
    public static final int Or=22;
    public static final int True=41;
    public static final int And=21;
    public static final int Div=34;
    public static final int ALabel=39;
    public static final int Store=12;
    public static final int GoEq=26;
    public static final int Instrucoes=10;
    public static final int Sub=35;
    public static final int IIn=19;
    public static final int IOut=18;
    public static final int LETRA=58;
    public static final int STRING=52;
    public static final int LoEq=24;

    // delegates
    // delegators

    public mspLexer() {;} 
    public mspLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public mspLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "maqv/msp.g"; }

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:9:7: ( ',' )
            // maqv/msp.g:9:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:10:7: ( 'ALabel' )
            // maqv/msp.g:10:9: 'ALabel'
            {
            match("ALabel"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:11:7: ( 'Call' )
            // maqv/msp.g:11:9: 'Call'
            {
            match("Call"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:12:7: ( 'Ret' )
            // maqv/msp.g:12:9: 'Ret'
            {
            match("Ret"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:13:7: ( 'Add' )
            // maqv/msp.g:13:9: 'Add'
            {
            match("Add"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:14:7: ( 'Sub' )
            // maqv/msp.g:14:9: 'Sub'
            {
            match("Sub"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:15:7: ( 'Div' )
            // maqv/msp.g:15:9: 'Div'
            {
            match("Div"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:16:7: ( 'Mul' )
            // maqv/msp.g:16:9: 'Mul'
            {
            match("Mul"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:17:7: ( 'Mod' )
            // maqv/msp.g:17:9: 'Mod'
            {
            match("Mod"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:18:7: ( 'Inc' )
            // maqv/msp.g:18:9: 'Inc'
            {
            match("Inc"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:19:7: ( 'Dec' )
            // maqv/msp.g:19:9: 'Dec'
            {
            match("Dec"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:20:7: ( 'Eq' )
            // maqv/msp.g:20:9: 'Eq'
            {
            match("Eq"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:21:7: ( 'Neq' )
            // maqv/msp.g:21:9: 'Neq'
            {
            match("Neq"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:22:7: ( 'Gt' )
            // maqv/msp.g:22:9: 'Gt'
            {
            match("Gt"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:23:7: ( 'GoEq' )
            // maqv/msp.g:23:9: 'GoEq'
            {
            match("GoEq"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:24:7: ( 'Lt' )
            // maqv/msp.g:24:9: 'Lt'
            {
            match("Lt"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:25:7: ( 'LoEq' )
            // maqv/msp.g:25:9: 'LoEq'
            {
            match("LoEq"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:26:7: ( 'Not' )
            // maqv/msp.g:26:9: 'Not'
            {
            match("Not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:27:7: ( 'Or' )
            // maqv/msp.g:27:9: 'Or'
            {
            match("Or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:28:7: ( 'And' )
            // maqv/msp.g:28:9: 'And'
            {
            match("And"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:29:7: ( 'Halt' )
            // maqv/msp.g:29:9: 'Halt'
            {
            match("Halt"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:30:7: ( 'IIn' )
            // maqv/msp.g:30:9: 'IIn'
            {
            match("IIn"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:31:7: ( 'IOut' )
            // maqv/msp.g:31:9: 'IOut'
            {
            match("IOut"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:32:7: ( 'Jump' )
            // maqv/msp.g:32:9: 'Jump'
            {
            match("Jump"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:33:7: ( 'Jumpf' )
            // maqv/msp.g:33:9: 'Jumpf'
            {
            match("Jumpf"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:34:7: ( 'Pusha' )
            // maqv/msp.g:34:9: 'Pusha'
            {
            match("Pusha"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:35:7: ( 'Pushi' )
            // maqv/msp.g:35:9: 'Pushi'
            {
            match("Pushi"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:36:7: ( 'Pushc' )
            // maqv/msp.g:36:9: 'Pushc'
            {
            match("Pushc"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:37:7: ( 'Pushf' )
            // maqv/msp.g:37:9: 'Pushf'
            {
            match("Pushf"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:38:7: ( 'Pushb' )
            // maqv/msp.g:38:9: 'Pushb'
            {
            match("Pushb"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:39:7: ( 'Load' )
            // maqv/msp.g:39:9: 'Load'
            {
            match("Load"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:40:7: ( 'Store' )
            // maqv/msp.g:40:9: 'Store'
            {
            match("Store"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:41:7: ( 'Decl' )
            // maqv/msp.g:41:9: 'Decl'
            {
            match("Decl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:42:7: ( 'true' )
            // maqv/msp.g:42:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "T__95"
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:43:7: ( 'false' )
            // maqv/msp.g:43:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "T__96"
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:44:7: ( 'char' )
            // maqv/msp.g:44:9: 'char'
            {
            match("char"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__96"

    // $ANTLR start "T__97"
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:45:7: ( 'int' )
            // maqv/msp.g:45:9: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__97"

    // $ANTLR start "T__98"
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:46:7: ( 'boolean' )
            // maqv/msp.g:46:9: 'boolean'
            {
            match("boolean"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__98"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:47:7: ( 'float' )
            // maqv/msp.g:47:9: 'float'
            {
            match("float"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__99"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:84:2: ( '\\\"' (~ ( '\"' ) )* '\\\"' )
            // maqv/msp.g:84:4: '\\\"' (~ ( '\"' ) )* '\\\"'
            {
            match('\"'); 
            // maqv/msp.g:84:9: (~ ( '\"' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='!')||(LA1_0>='#' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // maqv/msp.g:84:9: ~ ( '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;

                setText(getText().substring(1, getText().length()-1));
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            int _type = CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:92:2: ( '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\'' | '\\\\' ) ) '\\'' )
            // maqv/msp.g:92:4: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 
            // maqv/msp.g:92:9: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\'' | '\\\\' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\\') ) {
                alt2=1;
            }
            else if ( ((LA2_0>='\u0000' && LA2_0<='&')||(LA2_0>='(' && LA2_0<='[')||(LA2_0>=']' && LA2_0<='\uFFFF')) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // maqv/msp.g:92:11: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 
                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // maqv/msp.g:92:55: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;

                setText(getText().substring(1, getText().length()-1));
        }
        finally {
        }
    }
    // $ANTLR end "CHAR"

    // $ANTLR start "DIGITO"
    public final void mDIGITO() throws RecognitionException {
        try {
            // maqv/msp.g:96:3: ( ( '0' .. '9' )+ )
            // maqv/msp.g:96:5: ( '0' .. '9' )+
            {
            // maqv/msp.g:96:5: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // maqv/msp.g:96:6: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGITO"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:100:2: ( ( DIGITO )+ '.' ( DIGITO )* ( SufixoFloat )? | '.' ( DIGITO )+ ( SufixoFloat )? | INT SufixoFloat )
            int alt9=3;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // maqv/msp.g:100:4: ( DIGITO )+ '.' ( DIGITO )* ( SufixoFloat )?
                    {
                    // maqv/msp.g:100:4: ( DIGITO )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // maqv/msp.g:100:4: DIGITO
                    	    {
                    	    mDIGITO(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);

                    match('.'); 
                    // maqv/msp.g:100:16: ( DIGITO )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // maqv/msp.g:100:16: DIGITO
                    	    {
                    	    mDIGITO(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    // maqv/msp.g:100:24: ( SufixoFloat )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='F'||LA6_0=='f') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // maqv/msp.g:100:24: SufixoFloat
                            {
                            mSufixoFloat(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // maqv/msp.g:101:4: '.' ( DIGITO )+ ( SufixoFloat )?
                    {
                    match('.'); 
                    // maqv/msp.g:101:8: ( DIGITO )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // maqv/msp.g:101:8: DIGITO
                    	    {
                    	    mDIGITO(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);

                    // maqv/msp.g:101:16: ( SufixoFloat )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='F'||LA8_0=='f') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // maqv/msp.g:101:16: SufixoFloat
                            {
                            mSufixoFloat(); 

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // maqv/msp.g:102:4: INT SufixoFloat
                    {
                    mINT(); 
                    mSufixoFloat(); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "SufixoFloat"
    public final void mSufixoFloat() throws RecognitionException {
        try {
            int _type = SufixoFloat;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:106:2: ( 'f' | 'F' )
            // maqv/msp.g:
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
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
    // $ANTLR end "SufixoFloat"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:110:2: ( ( '0' | '1' .. '9' ( DIGITO )* ) )
            // maqv/msp.g:110:4: ( '0' | '1' .. '9' ( DIGITO )* )
            {
            // maqv/msp.g:110:4: ( '0' | '1' .. '9' ( DIGITO )* )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='0') ) {
                alt11=1;
            }
            else if ( ((LA11_0>='1' && LA11_0<='9')) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // maqv/msp.g:110:5: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // maqv/msp.g:110:11: '1' .. '9' ( DIGITO )*
                    {
                    matchRange('1','9'); 
                    // maqv/msp.g:110:20: ( DIGITO )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // maqv/msp.g:110:20: DIGITO
                    	    {
                    	    mDIGITO(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
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
    // $ANTLR end "INT"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:113:5: ( LETRA ( LETRA | '0' .. '9' )* )
            // maqv/msp.g:113:7: LETRA ( LETRA | '0' .. '9' )*
            {
            mLETRA(); 
            // maqv/msp.g:113:13: ( LETRA | '0' .. '9' )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='0' && LA12_0<='9')||(LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='z')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // maqv/msp.g:
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
            	    break loop12;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "LETRA"
    public final void mLETRA() throws RecognitionException {
        try {
            // maqv/msp.g:117:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' )
            // maqv/msp.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETRA"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // maqv/msp.g:120:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // maqv/msp.g:120:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // maqv/msp.g:1:8: ( T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | STRING | CHAR | FLOAT | SufixoFloat | INT | ID | WS )
        int alt13=46;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // maqv/msp.g:1:10: T__61
                {
                mT__61(); 

                }
                break;
            case 2 :
                // maqv/msp.g:1:16: T__62
                {
                mT__62(); 

                }
                break;
            case 3 :
                // maqv/msp.g:1:22: T__63
                {
                mT__63(); 

                }
                break;
            case 4 :
                // maqv/msp.g:1:28: T__64
                {
                mT__64(); 

                }
                break;
            case 5 :
                // maqv/msp.g:1:34: T__65
                {
                mT__65(); 

                }
                break;
            case 6 :
                // maqv/msp.g:1:40: T__66
                {
                mT__66(); 

                }
                break;
            case 7 :
                // maqv/msp.g:1:46: T__67
                {
                mT__67(); 

                }
                break;
            case 8 :
                // maqv/msp.g:1:52: T__68
                {
                mT__68(); 

                }
                break;
            case 9 :
                // maqv/msp.g:1:58: T__69
                {
                mT__69(); 

                }
                break;
            case 10 :
                // maqv/msp.g:1:64: T__70
                {
                mT__70(); 

                }
                break;
            case 11 :
                // maqv/msp.g:1:70: T__71
                {
                mT__71(); 

                }
                break;
            case 12 :
                // maqv/msp.g:1:76: T__72
                {
                mT__72(); 

                }
                break;
            case 13 :
                // maqv/msp.g:1:82: T__73
                {
                mT__73(); 

                }
                break;
            case 14 :
                // maqv/msp.g:1:88: T__74
                {
                mT__74(); 

                }
                break;
            case 15 :
                // maqv/msp.g:1:94: T__75
                {
                mT__75(); 

                }
                break;
            case 16 :
                // maqv/msp.g:1:100: T__76
                {
                mT__76(); 

                }
                break;
            case 17 :
                // maqv/msp.g:1:106: T__77
                {
                mT__77(); 

                }
                break;
            case 18 :
                // maqv/msp.g:1:112: T__78
                {
                mT__78(); 

                }
                break;
            case 19 :
                // maqv/msp.g:1:118: T__79
                {
                mT__79(); 

                }
                break;
            case 20 :
                // maqv/msp.g:1:124: T__80
                {
                mT__80(); 

                }
                break;
            case 21 :
                // maqv/msp.g:1:130: T__81
                {
                mT__81(); 

                }
                break;
            case 22 :
                // maqv/msp.g:1:136: T__82
                {
                mT__82(); 

                }
                break;
            case 23 :
                // maqv/msp.g:1:142: T__83
                {
                mT__83(); 

                }
                break;
            case 24 :
                // maqv/msp.g:1:148: T__84
                {
                mT__84(); 

                }
                break;
            case 25 :
                // maqv/msp.g:1:154: T__85
                {
                mT__85(); 

                }
                break;
            case 26 :
                // maqv/msp.g:1:160: T__86
                {
                mT__86(); 

                }
                break;
            case 27 :
                // maqv/msp.g:1:166: T__87
                {
                mT__87(); 

                }
                break;
            case 28 :
                // maqv/msp.g:1:172: T__88
                {
                mT__88(); 

                }
                break;
            case 29 :
                // maqv/msp.g:1:178: T__89
                {
                mT__89(); 

                }
                break;
            case 30 :
                // maqv/msp.g:1:184: T__90
                {
                mT__90(); 

                }
                break;
            case 31 :
                // maqv/msp.g:1:190: T__91
                {
                mT__91(); 

                }
                break;
            case 32 :
                // maqv/msp.g:1:196: T__92
                {
                mT__92(); 

                }
                break;
            case 33 :
                // maqv/msp.g:1:202: T__93
                {
                mT__93(); 

                }
                break;
            case 34 :
                // maqv/msp.g:1:208: T__94
                {
                mT__94(); 

                }
                break;
            case 35 :
                // maqv/msp.g:1:214: T__95
                {
                mT__95(); 

                }
                break;
            case 36 :
                // maqv/msp.g:1:220: T__96
                {
                mT__96(); 

                }
                break;
            case 37 :
                // maqv/msp.g:1:226: T__97
                {
                mT__97(); 

                }
                break;
            case 38 :
                // maqv/msp.g:1:232: T__98
                {
                mT__98(); 

                }
                break;
            case 39 :
                // maqv/msp.g:1:238: T__99
                {
                mT__99(); 

                }
                break;
            case 40 :
                // maqv/msp.g:1:244: STRING
                {
                mSTRING(); 

                }
                break;
            case 41 :
                // maqv/msp.g:1:251: CHAR
                {
                mCHAR(); 

                }
                break;
            case 42 :
                // maqv/msp.g:1:256: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 43 :
                // maqv/msp.g:1:262: SufixoFloat
                {
                mSufixoFloat(); 

                }
                break;
            case 44 :
                // maqv/msp.g:1:274: INT
                {
                mINT(); 

                }
                break;
            case 45 :
                // maqv/msp.g:1:278: ID
                {
                mID(); 

                }
                break;
            case 46 :
                // maqv/msp.g:1:281: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA9 dfa9 = new DFA9(this);
    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA9_eotS =
        "\7\uffff";
    static final String DFA9_eofS =
        "\7\uffff";
    static final String DFA9_minS =
        "\2\56\1\uffff\1\56\2\uffff\1\56";
    static final String DFA9_maxS =
        "\1\71\1\146\1\uffff\1\146\2\uffff\1\146";
    static final String DFA9_acceptS =
        "\2\uffff\1\2\1\uffff\1\3\1\1\1\uffff";
    static final String DFA9_specialS =
        "\7\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\2\1\uffff\1\1\11\3",
            "\1\5\1\uffff\12\5\14\uffff\1\4\37\uffff\1\4",
            "",
            "\1\5\1\uffff\12\6\14\uffff\1\4\37\uffff\1\4",
            "",
            "",
            "\1\5\1\uffff\12\6\14\uffff\1\4\37\uffff\1\4"
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "99:1: FLOAT : ( ( DIGITO )+ '.' ( DIGITO )* ( SufixoFloat )? | '.' ( DIGITO )+ ( SufixoFloat )? | INT SufixoFloat );";
        }
    }
    static final String DFA13_eotS =
        "\2\uffff\20\34\1\72\3\34\2\uffff\1\76\1\uffff\1\76\1\72\2\uffff"+
        "\16\34\1\116\2\34\1\121\1\34\1\123\1\34\1\126\6\34\1\uffff\3\34"+
        "\1\uffff\1\76\1\34\1\141\1\142\1\34\1\144\1\145\1\34\1\147\1\151"+
        "\1\152\1\153\1\154\1\155\1\34\1\uffff\1\157\1\160\1\uffff\1\34\1"+
        "\uffff\2\34\1\uffff\7\34\1\173\2\34\2\uffff\1\176\2\uffff\1\34\1"+
        "\uffff\1\u0080\5\uffff\1\u0081\2\uffff\1\u0082\1\u0083\1\u0084\1"+
        "\u0085\1\u0087\1\34\1\u008d\2\34\1\u0090\1\uffff\2\34\1\uffff\1"+
        "\u0093\6\uffff\1\u0094\1\uffff\1\u0095\1\u0096\1\u0097\1\u0098\1"+
        "\u0099\1\uffff\1\u009a\1\u009b\1\uffff\1\34\1\u009d\11\uffff\1\34"+
        "\1\uffff\1\u009f\1\uffff";
    static final String DFA13_eofS =
        "\u00a0\uffff";
    static final String DFA13_minS =
        "\1\11\1\uffff\1\114\1\141\1\145\1\164\1\145\1\157\1\111\1\161\1"+
        "\145\2\157\1\162\1\141\2\165\1\162\1\60\1\150\1\156\1\157\2\uffff"+
        "\1\56\1\uffff\1\56\1\60\2\uffff\1\141\2\144\1\154\1\164\1\142\1"+
        "\157\1\166\1\143\1\154\1\144\1\143\1\156\1\165\1\60\1\161\1\164"+
        "\1\60\1\105\1\60\1\105\1\60\1\154\1\155\1\163\1\165\1\154\1\157"+
        "\1\uffff\1\141\1\164\1\157\1\uffff\1\56\1\142\2\60\1\154\2\60\1"+
        "\162\6\60\1\164\1\uffff\2\60\1\uffff\1\161\1\uffff\1\161\1\144\1"+
        "\uffff\1\164\1\160\1\150\1\145\1\163\1\141\1\162\1\60\1\154\1\145"+
        "\2\uffff\1\60\2\uffff\1\145\1\uffff\1\60\5\uffff\1\60\2\uffff\5"+
        "\60\1\141\1\60\1\145\1\164\1\60\1\uffff\1\145\1\154\1\uffff\1\60"+
        "\6\uffff\1\60\1\uffff\5\60\1\uffff\2\60\1\uffff\1\141\1\60\11\uffff"+
        "\1\156\1\uffff\1\60\1\uffff";
    static final String DFA13_maxS =
        "\1\172\1\uffff\1\156\1\141\1\145\1\165\1\151\1\165\1\156\1\161\1"+
        "\157\2\164\1\162\1\141\2\165\1\162\1\172\1\150\1\156\1\157\2\uffff"+
        "\1\146\1\uffff\1\146\1\172\2\uffff\1\141\2\144\1\154\1\164\1\142"+
        "\1\157\1\166\1\143\1\154\1\144\1\143\1\156\1\165\1\172\1\161\1\164"+
        "\1\172\1\105\1\172\1\141\1\172\1\154\1\155\1\163\1\165\1\154\1\157"+
        "\1\uffff\1\141\1\164\1\157\1\uffff\1\146\1\142\2\172\1\154\2\172"+
        "\1\162\6\172\1\164\1\uffff\2\172\1\uffff\1\161\1\uffff\1\161\1\144"+
        "\1\uffff\1\164\1\160\1\150\1\145\1\163\1\141\1\162\1\172\1\154\1"+
        "\145\2\uffff\1\172\2\uffff\1\145\1\uffff\1\172\5\uffff\1\172\2\uffff"+
        "\5\172\1\151\1\172\1\145\1\164\1\172\1\uffff\1\145\1\154\1\uffff"+
        "\1\172\6\uffff\1\172\1\uffff\5\172\1\uffff\2\172\1\uffff\1\141\1"+
        "\172\11\uffff\1\156\1\uffff\1\172\1\uffff";
    static final String DFA13_acceptS =
        "\1\uffff\1\1\24\uffff\1\50\1\51\1\uffff\1\52\2\uffff\1\55\1\56\34"+
        "\uffff\1\53\3\uffff\1\54\17\uffff\1\14\2\uffff\1\16\1\uffff\1\20"+
        "\2\uffff\1\23\12\uffff\1\5\1\24\1\uffff\1\4\1\6\1\uffff\1\7\1\uffff"+
        "\1\13\1\10\1\11\1\12\1\26\1\uffff\1\15\1\22\12\uffff\1\45\2\uffff"+
        "\1\3\1\uffff\1\41\1\27\1\17\1\21\1\37\1\25\1\uffff\1\30\5\uffff"+
        "\1\42\2\uffff\1\44\2\uffff\1\40\1\31\1\32\1\33\1\34\1\35\1\36\1"+
        "\43\1\47\1\uffff\1\2\1\uffff\1\46";
    static final String DFA13_specialS =
        "\u00a0\uffff}>";
    static final String[] DFA13_transitionS = {
            "\2\35\1\uffff\2\35\22\uffff\1\35\1\uffff\1\26\4\uffff\1\27\4"+
            "\uffff\1\1\1\uffff\1\31\1\uffff\1\30\11\32\7\uffff\1\2\1\34"+
            "\1\3\1\6\1\11\1\33\1\13\1\16\1\10\1\17\1\34\1\14\1\7\1\12\1"+
            "\15\1\20\1\34\1\4\1\5\7\34\4\uffff\1\34\1\uffff\1\34\1\25\1"+
            "\23\2\34\1\22\2\34\1\24\12\34\1\21\6\34",
            "",
            "\1\36\27\uffff\1\37\11\uffff\1\40",
            "\1\41",
            "\1\42",
            "\1\44\1\43",
            "\1\46\3\uffff\1\45",
            "\1\50\5\uffff\1\47",
            "\1\52\5\uffff\1\53\36\uffff\1\51",
            "\1\54",
            "\1\55\11\uffff\1\56",
            "\1\60\4\uffff\1\57",
            "\1\62\4\uffff\1\61",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\1\70\12\34\1\71\16"+
            "\34",
            "\1\73",
            "\1\74",
            "\1\75",
            "",
            "",
            "\1\31\1\uffff\12\31\14\uffff\1\31\37\uffff\1\31",
            "",
            "\1\31\1\uffff\12\77\14\uffff\1\31\37\uffff\1\31",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\117",
            "\1\120",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\122",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\124\33\uffff\1\125",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "",
            "\1\135",
            "\1\136",
            "\1\137",
            "",
            "\1\31\1\uffff\12\77\14\uffff\1\31\37\uffff\1\31",
            "\1\140",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\143",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\146",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\13\34\1\150\16\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\156",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\1\161",
            "",
            "\1\162",
            "\1\163",
            "",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\174",
            "\1\175",
            "",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            "\1\177",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            "",
            "",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\5\34\1\u0086\24\34",
            "\1\u0088\1\u008c\1\u008a\2\uffff\1\u008b\2\uffff\1\u0089",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u008e",
            "\1\u008f",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\1\u0091",
            "\1\u0092",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\1\u009c",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u009e",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | STRING | CHAR | FLOAT | SufixoFloat | INT | ID | WS );";
        }
    }
 

}