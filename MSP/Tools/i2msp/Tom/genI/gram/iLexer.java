// $ANTLR 3.2 Sep 23, 2009 12:02:23 gram/i.g 2016-01-18 21:51:01
 package gram; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class iLexer extends Lexer {
    public static final int Soma=29;
    public static final int Decl=20;
    public static final int CHAR=75;
    public static final int Empty=33;
    public static final int DChar=71;
    public static final int DVoid=68;
    public static final int Neg=50;
    public static final int EOF=-1;
    public static final int Int=44;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__90=90;
    public static final int Parametro=24;
    public static final int Char=43;
    public static final int Comentario=61;
    public static final int MaiorQ=57;
    public static final int MenorQ=56;
    public static final int Vazio=60;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int E=38;
    public static final int Mod=63;
    public static final int ListaDecl=21;
    public static final int T__83=83;
    public static final int DFloat=69;
    public static final int Maior=59;
    public static final int ListaArgumentos=23;
    public static final int Atribuicao=19;
    public static final int INT=73;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int Dec=26;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int Menor=58;
    public static final int T__88=88;
    public static final int Menos=64;
    public static final int DBoolean=70;
    public static final int Float=40;
    public static final int T__125=125;
    public static final int Input=36;
    public static final int WS=82;
    public static final int SeqInstrucao=11;
    public static final int Inc=27;
    public static final int SufixoFloat=80;
    public static final int Condicional=45;
    public static final int Funcao=13;
    public static final int ExpNum=53;
    public static final int Comp=37;
    public static final int Nao=49;
    public static final int DIGITO=79;
    public static final int T__118=118;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int COMENTARIO_LINHAS=78;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int False=41;
    public static final int T__115=115;
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int T__122=122;
    public static final int T__121=121;
    public static final int FLOAT=74;
    public static final int T__120=120;
    public static final int While=16;
    public static final int ID=76;
    public static final int Atrib=32;
    public static final int IncDepois=46;
    public static final int Expressoes=34;
    public static final int COMENTARIO_LINHA=77;
    public static final int Call=48;
    public static final int Argumento=22;
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int ListaParametros=25;
    public static final int T__103=103;
    public static final int T__104=104;
    public static final int Print=35;
    public static final int Dif=55;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int DInt=72;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int Ou=39;
    public static final int T__113=113;
    public static final int T__112=112;
    public static final int Comentarios=62;
    public static final int Return=14;
    public static final int True=42;
    public static final int Id=52;
    public static final int If=17;
    public static final int Div=30;
    public static final int Igual=54;
    public static final int Exp=12;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int Mais=67;
    public static final int T__100=100;
    public static final int For=15;
    public static final int Divide=65;
    public static final int Sub=28;
    public static final int Declaracao=18;
    public static final int Mult=31;
    public static final int Vezes=66;
    public static final int IntWrap=10;
    public static final int Pos=51;
    public static final int IncAntes=47;
    public static final int LETRA=81;

    // delegates
    // delegators

    public iLexer() {;} 
    public iLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public iLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "gram/i.g"; }

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:9:7: ( 'char' )
            // gram/i.g:9:9: 'char'
            {
            match("char"); 


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
            // gram/i.g:10:7: ( 'int' )
            // gram/i.g:10:9: 'int'
            {
            match("int"); 


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
            // gram/i.g:11:7: ( 'boolean' )
            // gram/i.g:11:9: 'boolean'
            {
            match("boolean"); 


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
            // gram/i.g:12:7: ( 'float' )
            // gram/i.g:12:9: 'float'
            {
            match("float"); 


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
            // gram/i.g:13:7: ( 'void' )
            // gram/i.g:13:9: 'void'
            {
            match("void"); 


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
            // gram/i.g:14:7: ( ';' )
            // gram/i.g:14:9: ';'
            {
            match(';'); 

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
            // gram/i.g:15:7: ( ',' )
            // gram/i.g:15:9: ','
            {
            match(','); 

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
            // gram/i.g:16:7: ( '=' )
            // gram/i.g:16:9: '='
            {
            match('='); 

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
            // gram/i.g:17:7: ( '(' )
            // gram/i.g:17:9: '('
            {
            match('('); 

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
            // gram/i.g:18:7: ( ')' )
            // gram/i.g:18:9: ')'
            {
            match(')'); 

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
            // gram/i.g:19:7: ( 'if' )
            // gram/i.g:19:9: 'if'
            {
            match("if"); 


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
            // gram/i.g:20:7: ( 'else' )
            // gram/i.g:20:9: 'else'
            {
            match("else"); 


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
            // gram/i.g:21:7: ( 'for' )
            // gram/i.g:21:9: 'for'
            {
            match("for"); 


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
            // gram/i.g:22:7: ( 'while' )
            // gram/i.g:22:9: 'while'
            {
            match("while"); 


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
            // gram/i.g:23:7: ( 'return' )
            // gram/i.g:23:9: 'return'
            {
            match("return"); 


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
            // gram/i.g:24:7: ( 'print' )
            // gram/i.g:24:9: 'print'
            {
            match("print"); 


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
            // gram/i.g:25:7: ( 'input' )
            // gram/i.g:25:9: 'input'
            {
            match("input"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__99"

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:26:8: ( '{' )
            // gram/i.g:26:10: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__100"

    // $ANTLR start "T__101"
    public final void mT__101() throws RecognitionException {
        try {
            int _type = T__101;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:27:8: ( '}' )
            // gram/i.g:27:10: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__101"

    // $ANTLR start "T__102"
    public final void mT__102() throws RecognitionException {
        try {
            int _type = T__102;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:28:8: ( '?' )
            // gram/i.g:28:10: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__102"

    // $ANTLR start "T__103"
    public final void mT__103() throws RecognitionException {
        try {
            int _type = T__103;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:29:8: ( ':' )
            // gram/i.g:29:10: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__103"

    // $ANTLR start "T__104"
    public final void mT__104() throws RecognitionException {
        try {
            int _type = T__104;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:30:8: ( '||' )
            // gram/i.g:30:10: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__104"

    // $ANTLR start "T__105"
    public final void mT__105() throws RecognitionException {
        try {
            int _type = T__105;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:31:8: ( '&&' )
            // gram/i.g:31:10: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__105"

    // $ANTLR start "T__106"
    public final void mT__106() throws RecognitionException {
        try {
            int _type = T__106;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:32:8: ( '>' )
            // gram/i.g:32:10: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__106"

    // $ANTLR start "T__107"
    public final void mT__107() throws RecognitionException {
        try {
            int _type = T__107;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:33:8: ( '<' )
            // gram/i.g:33:10: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__107"

    // $ANTLR start "T__108"
    public final void mT__108() throws RecognitionException {
        try {
            int _type = T__108;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:34:8: ( '>=' )
            // gram/i.g:34:10: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__108"

    // $ANTLR start "T__109"
    public final void mT__109() throws RecognitionException {
        try {
            int _type = T__109;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:35:8: ( '<=' )
            // gram/i.g:35:10: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__109"

    // $ANTLR start "T__110"
    public final void mT__110() throws RecognitionException {
        try {
            int _type = T__110;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:36:8: ( '!=' )
            // gram/i.g:36:10: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__110"

    // $ANTLR start "T__111"
    public final void mT__111() throws RecognitionException {
        try {
            int _type = T__111;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:37:8: ( '==' )
            // gram/i.g:37:10: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__111"

    // $ANTLR start "T__112"
    public final void mT__112() throws RecognitionException {
        try {
            int _type = T__112;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:38:8: ( '*=' )
            // gram/i.g:38:10: '*='
            {
            match("*="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__112"

    // $ANTLR start "T__113"
    public final void mT__113() throws RecognitionException {
        try {
            int _type = T__113;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:39:8: ( '/=' )
            // gram/i.g:39:10: '/='
            {
            match("/="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__113"

    // $ANTLR start "T__114"
    public final void mT__114() throws RecognitionException {
        try {
            int _type = T__114;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:40:8: ( '+=' )
            // gram/i.g:40:10: '+='
            {
            match("+="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__114"

    // $ANTLR start "T__115"
    public final void mT__115() throws RecognitionException {
        try {
            int _type = T__115;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:41:8: ( '-=' )
            // gram/i.g:41:10: '-='
            {
            match("-="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__115"

    // $ANTLR start "T__116"
    public final void mT__116() throws RecognitionException {
        try {
            int _type = T__116;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:42:8: ( '+' )
            // gram/i.g:42:10: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__116"

    // $ANTLR start "T__117"
    public final void mT__117() throws RecognitionException {
        try {
            int _type = T__117;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:43:8: ( '-' )
            // gram/i.g:43:10: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__117"

    // $ANTLR start "T__118"
    public final void mT__118() throws RecognitionException {
        try {
            int _type = T__118;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:44:8: ( '*' )
            // gram/i.g:44:10: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__118"

    // $ANTLR start "T__119"
    public final void mT__119() throws RecognitionException {
        try {
            int _type = T__119;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:45:8: ( '/' )
            // gram/i.g:45:10: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__119"

    // $ANTLR start "T__120"
    public final void mT__120() throws RecognitionException {
        try {
            int _type = T__120;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:46:8: ( '%' )
            // gram/i.g:46:10: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__120"

    // $ANTLR start "T__121"
    public final void mT__121() throws RecognitionException {
        try {
            int _type = T__121;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:47:8: ( '++' )
            // gram/i.g:47:10: '++'
            {
            match("++"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__121"

    // $ANTLR start "T__122"
    public final void mT__122() throws RecognitionException {
        try {
            int _type = T__122;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:48:8: ( '--' )
            // gram/i.g:48:10: '--'
            {
            match("--"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__122"

    // $ANTLR start "T__123"
    public final void mT__123() throws RecognitionException {
        try {
            int _type = T__123;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:49:8: ( '!' )
            // gram/i.g:49:10: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__123"

    // $ANTLR start "T__124"
    public final void mT__124() throws RecognitionException {
        try {
            int _type = T__124;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:50:8: ( 'true' )
            // gram/i.g:50:10: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__124"

    // $ANTLR start "T__125"
    public final void mT__125() throws RecognitionException {
        try {
            int _type = T__125;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:51:8: ( 'false' )
            // gram/i.g:51:10: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__125"

    // $ANTLR start "COMENTARIO_LINHA"
    public final void mCOMENTARIO_LINHA() throws RecognitionException {
        try {
            int _type = COMENTARIO_LINHA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:225:2: ( '//' (~ ( '\\r' | '\\n' ) )* )
            // gram/i.g:225:4: '//' (~ ( '\\r' | '\\n' ) )*
            {
            match("//"); 

            // gram/i.g:225:9: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // gram/i.g:225:9: ~ ( '\\r' | '\\n' )
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
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMENTARIO_LINHA"

    // $ANTLR start "COMENTARIO_LINHAS"
    public final void mCOMENTARIO_LINHAS() throws RecognitionException {
        try {
            int _type = COMENTARIO_LINHAS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:229:2: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // gram/i.g:229:4: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // gram/i.g:229:9: ( options {greedy=false; } : . )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='*') ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1=='/') ) {
                        alt2=2;
                    }
                    else if ( ((LA2_1>='\u0000' && LA2_1<='.')||(LA2_1>='0' && LA2_1<='\uFFFF')) ) {
                        alt2=1;
                    }


                }
                else if ( ((LA2_0>='\u0000' && LA2_0<=')')||(LA2_0>='+' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // gram/i.g:229:37: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end "COMENTARIO_LINHAS"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            int _type = CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gram/i.g:241:2: ( '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\'' | '\\\\' ) ) '\\'' )
            // gram/i.g:241:4: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 
            // gram/i.g:241:9: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\'' | '\\\\' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\\') ) {
                alt3=1;
            }
            else if ( ((LA3_0>='\u0000' && LA3_0<='&')||(LA3_0>='(' && LA3_0<='[')||(LA3_0>=']' && LA3_0<='\uFFFF')) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // gram/i.g:241:11: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    // gram/i.g:241:55: ~ ( '\\'' | '\\\\' )
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
            // gram/i.g:245:3: ( ( '0' .. '9' )+ )
            // gram/i.g:245:5: ( '0' .. '9' )+
            {
            // gram/i.g:245:5: ( '0' .. '9' )+
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
            	    // gram/i.g:245:6: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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
            // gram/i.g:249:2: ( ( DIGITO )+ '.' ( DIGITO )* ( SufixoFloat )? | '.' ( DIGITO )+ ( SufixoFloat )? | INT SufixoFloat )
            int alt10=3;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // gram/i.g:249:4: ( DIGITO )+ '.' ( DIGITO )* ( SufixoFloat )?
                    {
                    // gram/i.g:249:4: ( DIGITO )+
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
                    	    // gram/i.g:249:4: DIGITO
                    	    {
                    	    mDIGITO(); 

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

                    match('.'); 
                    // gram/i.g:249:16: ( DIGITO )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // gram/i.g:249:16: DIGITO
                    	    {
                    	    mDIGITO(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    // gram/i.g:249:24: ( SufixoFloat )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==':') ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // gram/i.g:249:24: SufixoFloat
                            {
                            mSufixoFloat(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // gram/i.g:250:4: '.' ( DIGITO )+ ( SufixoFloat )?
                    {
                    match('.'); 
                    // gram/i.g:250:8: ( DIGITO )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // gram/i.g:250:8: DIGITO
                    	    {
                    	    mDIGITO(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);

                    // gram/i.g:250:16: ( SufixoFloat )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==':') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // gram/i.g:250:16: SufixoFloat
                            {
                            mSufixoFloat(); 

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // gram/i.g:251:4: INT SufixoFloat
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
            // gram/i.g:255:2: ( ':f' | ':F' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==':') ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1=='f') ) {
                    alt11=1;
                }
                else if ( (LA11_1=='F') ) {
                    alt11=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // gram/i.g:255:4: ':f'
                    {
                    match(":f"); 


                    }
                    break;
                case 2 :
                    // gram/i.g:255:9: ':F'
                    {
                    match(":F"); 


                    }
                    break;

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
            // gram/i.g:259:2: ( ( '0' | '1' .. '9' ( DIGITO )* ) )
            // gram/i.g:259:4: ( '0' | '1' .. '9' ( DIGITO )* )
            {
            // gram/i.g:259:4: ( '0' | '1' .. '9' ( DIGITO )* )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='0') ) {
                alt13=1;
            }
            else if ( ((LA13_0>='1' && LA13_0<='9')) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // gram/i.g:259:5: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // gram/i.g:259:11: '1' .. '9' ( DIGITO )*
                    {
                    matchRange('1','9'); 
                    // gram/i.g:259:20: ( DIGITO )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // gram/i.g:259:20: DIGITO
                    	    {
                    	    mDIGITO(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
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
            // gram/i.g:262:5: ( LETRA ( LETRA | '0' .. '9' )* )
            // gram/i.g:262:7: LETRA ( LETRA | '0' .. '9' )*
            {
            mLETRA(); 
            // gram/i.g:262:13: ( LETRA | '0' .. '9' )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='0' && LA14_0<='9')||(LA14_0>='A' && LA14_0<='Z')||LA14_0=='_'||(LA14_0>='a' && LA14_0<='z')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // gram/i.g:
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
            	    break loop14;
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
            // gram/i.g:266:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' )
            // gram/i.g:
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
            // gram/i.g:269:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // gram/i.g:269:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
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
        // gram/i.g:1:8: ( T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | COMENTARIO_LINHA | COMENTARIO_LINHAS | CHAR | FLOAT | SufixoFloat | INT | ID | WS )
        int alt15=51;
        alt15 = dfa15.predict(input);
        switch (alt15) {
            case 1 :
                // gram/i.g:1:10: T__83
                {
                mT__83(); 

                }
                break;
            case 2 :
                // gram/i.g:1:16: T__84
                {
                mT__84(); 

                }
                break;
            case 3 :
                // gram/i.g:1:22: T__85
                {
                mT__85(); 

                }
                break;
            case 4 :
                // gram/i.g:1:28: T__86
                {
                mT__86(); 

                }
                break;
            case 5 :
                // gram/i.g:1:34: T__87
                {
                mT__87(); 

                }
                break;
            case 6 :
                // gram/i.g:1:40: T__88
                {
                mT__88(); 

                }
                break;
            case 7 :
                // gram/i.g:1:46: T__89
                {
                mT__89(); 

                }
                break;
            case 8 :
                // gram/i.g:1:52: T__90
                {
                mT__90(); 

                }
                break;
            case 9 :
                // gram/i.g:1:58: T__91
                {
                mT__91(); 

                }
                break;
            case 10 :
                // gram/i.g:1:64: T__92
                {
                mT__92(); 

                }
                break;
            case 11 :
                // gram/i.g:1:70: T__93
                {
                mT__93(); 

                }
                break;
            case 12 :
                // gram/i.g:1:76: T__94
                {
                mT__94(); 

                }
                break;
            case 13 :
                // gram/i.g:1:82: T__95
                {
                mT__95(); 

                }
                break;
            case 14 :
                // gram/i.g:1:88: T__96
                {
                mT__96(); 

                }
                break;
            case 15 :
                // gram/i.g:1:94: T__97
                {
                mT__97(); 

                }
                break;
            case 16 :
                // gram/i.g:1:100: T__98
                {
                mT__98(); 

                }
                break;
            case 17 :
                // gram/i.g:1:106: T__99
                {
                mT__99(); 

                }
                break;
            case 18 :
                // gram/i.g:1:112: T__100
                {
                mT__100(); 

                }
                break;
            case 19 :
                // gram/i.g:1:119: T__101
                {
                mT__101(); 

                }
                break;
            case 20 :
                // gram/i.g:1:126: T__102
                {
                mT__102(); 

                }
                break;
            case 21 :
                // gram/i.g:1:133: T__103
                {
                mT__103(); 

                }
                break;
            case 22 :
                // gram/i.g:1:140: T__104
                {
                mT__104(); 

                }
                break;
            case 23 :
                // gram/i.g:1:147: T__105
                {
                mT__105(); 

                }
                break;
            case 24 :
                // gram/i.g:1:154: T__106
                {
                mT__106(); 

                }
                break;
            case 25 :
                // gram/i.g:1:161: T__107
                {
                mT__107(); 

                }
                break;
            case 26 :
                // gram/i.g:1:168: T__108
                {
                mT__108(); 

                }
                break;
            case 27 :
                // gram/i.g:1:175: T__109
                {
                mT__109(); 

                }
                break;
            case 28 :
                // gram/i.g:1:182: T__110
                {
                mT__110(); 

                }
                break;
            case 29 :
                // gram/i.g:1:189: T__111
                {
                mT__111(); 

                }
                break;
            case 30 :
                // gram/i.g:1:196: T__112
                {
                mT__112(); 

                }
                break;
            case 31 :
                // gram/i.g:1:203: T__113
                {
                mT__113(); 

                }
                break;
            case 32 :
                // gram/i.g:1:210: T__114
                {
                mT__114(); 

                }
                break;
            case 33 :
                // gram/i.g:1:217: T__115
                {
                mT__115(); 

                }
                break;
            case 34 :
                // gram/i.g:1:224: T__116
                {
                mT__116(); 

                }
                break;
            case 35 :
                // gram/i.g:1:231: T__117
                {
                mT__117(); 

                }
                break;
            case 36 :
                // gram/i.g:1:238: T__118
                {
                mT__118(); 

                }
                break;
            case 37 :
                // gram/i.g:1:245: T__119
                {
                mT__119(); 

                }
                break;
            case 38 :
                // gram/i.g:1:252: T__120
                {
                mT__120(); 

                }
                break;
            case 39 :
                // gram/i.g:1:259: T__121
                {
                mT__121(); 

                }
                break;
            case 40 :
                // gram/i.g:1:266: T__122
                {
                mT__122(); 

                }
                break;
            case 41 :
                // gram/i.g:1:273: T__123
                {
                mT__123(); 

                }
                break;
            case 42 :
                // gram/i.g:1:280: T__124
                {
                mT__124(); 

                }
                break;
            case 43 :
                // gram/i.g:1:287: T__125
                {
                mT__125(); 

                }
                break;
            case 44 :
                // gram/i.g:1:294: COMENTARIO_LINHA
                {
                mCOMENTARIO_LINHA(); 

                }
                break;
            case 45 :
                // gram/i.g:1:311: COMENTARIO_LINHAS
                {
                mCOMENTARIO_LINHAS(); 

                }
                break;
            case 46 :
                // gram/i.g:1:329: CHAR
                {
                mCHAR(); 

                }
                break;
            case 47 :
                // gram/i.g:1:334: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 48 :
                // gram/i.g:1:340: SufixoFloat
                {
                mSufixoFloat(); 

                }
                break;
            case 49 :
                // gram/i.g:1:352: INT
                {
                mINT(); 

                }
                break;
            case 50 :
                // gram/i.g:1:356: ID
                {
                mID(); 

                }
                break;
            case 51 :
                // gram/i.g:1:359: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA10_eotS =
        "\7\uffff";
    static final String DFA10_eofS =
        "\7\uffff";
    static final String DFA10_minS =
        "\2\56\1\uffff\1\56\2\uffff\1\56";
    static final String DFA10_maxS =
        "\1\71\1\72\1\uffff\1\72\2\uffff\1\72";
    static final String DFA10_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\1\3\1\uffff";
    static final String DFA10_specialS =
        "\7\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\2\1\uffff\1\1\11\3",
            "\1\4\1\uffff\12\4\1\5",
            "",
            "\1\4\1\uffff\12\6\1\5",
            "",
            "",
            "\1\4\1\uffff\12\6\1\5"
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "248:1: FLOAT : ( ( DIGITO )+ '.' ( DIGITO )* ( SufixoFloat )? | '.' ( DIGITO )+ ( SufixoFloat )? | INT SufixoFloat );";
        }
    }
    static final String DFA15_eotS =
        "\1\uffff\5\42\2\uffff\1\55\2\uffff\4\42\3\uffff\1\63\2\uffff\1\65"+
        "\1\67\1\71\1\73\1\77\1\102\1\105\1\uffff\1\42\1\uffff\1\107\1\uffff"+
        "\1\107\2\uffff\2\42\1\114\5\42\2\uffff\4\42\24\uffff\1\42\1\uffff"+
        "\1\107\1\42\1\130\1\42\1\uffff\2\42\1\134\7\42\1\144\1\uffff\3\42"+
        "\1\uffff\1\42\1\151\1\152\3\42\1\156\1\uffff\1\157\1\42\1\161\1"+
        "\162\2\uffff\1\163\1\42\1\165\2\uffff\1\42\3\uffff\1\167\1\uffff"+
        "\1\170\2\uffff";
    static final String DFA15_eofS =
        "\171\uffff";
    static final String DFA15_minS =
        "\1\11\1\150\1\146\1\157\1\141\1\157\2\uffff\1\75\2\uffff\1\154\1"+
        "\150\1\145\1\162\3\uffff\1\106\2\uffff\4\75\1\52\1\53\1\55\1\uffff"+
        "\1\162\1\uffff\1\56\1\uffff\1\56\2\uffff\1\141\1\160\1\60\2\157"+
        "\1\162\1\154\1\151\2\uffff\1\163\1\151\1\164\1\151\24\uffff\1\165"+
        "\1\uffff\1\56\1\162\1\60\1\165\1\uffff\1\154\1\141\1\60\1\163\1"+
        "\144\1\145\1\154\1\165\1\156\1\145\1\60\1\uffff\1\164\1\145\1\164"+
        "\1\uffff\1\145\2\60\1\145\1\162\1\164\1\60\1\uffff\1\60\1\141\2"+
        "\60\2\uffff\1\60\1\156\1\60\2\uffff\1\156\3\uffff\1\60\1\uffff\1"+
        "\60\2\uffff";
    static final String DFA15_maxS =
        "\1\175\1\150\1\156\3\157\2\uffff\1\75\2\uffff\1\154\1\150\1\145"+
        "\1\162\3\uffff\1\146\2\uffff\7\75\1\uffff\1\162\1\uffff\1\72\1\uffff"+
        "\1\72\2\uffff\1\141\1\164\1\172\2\157\1\162\1\154\1\151\2\uffff"+
        "\1\163\1\151\1\164\1\151\24\uffff\1\165\1\uffff\1\72\1\162\1\172"+
        "\1\165\1\uffff\1\154\1\141\1\172\1\163\1\144\1\145\1\154\1\165\1"+
        "\156\1\145\1\172\1\uffff\1\164\1\145\1\164\1\uffff\1\145\2\172\1"+
        "\145\1\162\1\164\1\172\1\uffff\1\172\1\141\2\172\2\uffff\1\172\1"+
        "\156\1\172\2\uffff\1\156\3\uffff\1\172\1\uffff\1\172\2\uffff";
    static final String DFA15_acceptS =
        "\6\uffff\1\6\1\7\1\uffff\1\11\1\12\4\uffff\1\22\1\23\1\24\1\uffff"+
        "\1\26\1\27\7\uffff\1\46\1\uffff\1\56\1\uffff\1\57\1\uffff\1\62\1"+
        "\63\10\uffff\1\35\1\10\4\uffff\1\60\1\25\1\32\1\30\1\33\1\31\1\34"+
        "\1\51\1\36\1\44\1\37\1\54\1\55\1\45\1\40\1\47\1\42\1\41\1\50\1\43"+
        "\1\uffff\1\61\4\uffff\1\13\13\uffff\1\2\3\uffff\1\15\7\uffff\1\1"+
        "\4\uffff\1\5\1\14\3\uffff\1\52\1\21\1\uffff\1\4\1\53\1\16\1\uffff"+
        "\1\20\1\uffff\1\17\1\3";
    static final String DFA15_specialS =
        "\171\uffff}>";
    static final String[] DFA15_transitionS = {
            "\2\43\1\uffff\2\43\22\uffff\1\43\1\27\3\uffff\1\34\1\24\1\36"+
            "\1\11\1\12\1\30\1\32\1\7\1\33\1\40\1\31\1\37\11\41\1\22\1\6"+
            "\1\26\1\10\1\25\1\21\1\uffff\32\42\4\uffff\1\42\1\uffff\1\42"+
            "\1\3\1\1\1\42\1\13\1\4\2\42\1\2\6\42\1\16\1\42\1\15\1\42\1\35"+
            "\1\42\1\5\1\14\3\42\1\17\1\23\1\20",
            "\1\44",
            "\1\46\7\uffff\1\45",
            "\1\47",
            "\1\52\12\uffff\1\50\2\uffff\1\51",
            "\1\53",
            "",
            "",
            "\1\54",
            "",
            "",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "",
            "",
            "",
            "\1\62\37\uffff\1\62",
            "",
            "",
            "\1\64",
            "\1\66",
            "\1\70",
            "\1\72",
            "\1\76\4\uffff\1\75\15\uffff\1\74",
            "\1\101\21\uffff\1\100",
            "\1\104\17\uffff\1\103",
            "",
            "\1\106",
            "",
            "\1\40\1\uffff\13\40",
            "",
            "\1\40\1\uffff\12\110\1\40",
            "",
            "",
            "\1\111",
            "\1\113\3\uffff\1\112",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "",
            "",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
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
            "",
            "\1\126",
            "",
            "\1\40\1\uffff\12\110\1\40",
            "\1\127",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\131",
            "",
            "\1\132",
            "\1\133",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\1\145",
            "\1\146",
            "\1\147",
            "",
            "\1\150",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\153",
            "\1\154",
            "\1\155",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\160",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\164",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "",
            "\1\166",
            "",
            "",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | COMENTARIO_LINHA | COMENTARIO_LINHAS | CHAR | FLOAT | SufixoFloat | INT | ID | WS );";
        }
    }
 

}