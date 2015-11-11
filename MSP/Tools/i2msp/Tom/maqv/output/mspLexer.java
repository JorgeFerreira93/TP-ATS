// $ANTLR 3.x /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g 2013-02-16 19:26:44
 package maqv; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class mspLexer extends Lexer {
	public static final int EOF=-1;
	public static final int F=40;
	public static final int Instrucoes=10;
	public static final int S=42;
	public static final int Decl=11;
	public static final int IOut=17;
	public static final int Stackk=44;
	public static final int Load=13;
	public static final int I=43;
	public static final int Lt=24;
	public static final int Jumpf=15;
	public static final int False=37;
	public static final int Push=14;
	public static final int Mul=30;
	public static final int B=41;
	public static final int And=20;
	public static final int Add=33;
	public static final int LoEq=23;
	public static final int Or=21;
	public static final int Neq=27;
	public static final int Store=12;
	public static final int GoEq=25;
	public static final int True=38;
	public static final int Div=31;
	public static final int Ret=34;
	public static final int Call=35;
	public static final int Eq=28;
	public static final int Gt=26;
	public static final int Mod=29;
	public static final int Vazio=39;
	public static final int Sub=32;
	public static final int Jump=16;
	public static final int IIn=18;
	public static final int Nott=22;
	public static final int ALabel=36;
	public static final int Halt=19;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int T__56=56;
	public static final int T__57=57;
	public static final int T__58=58;
	public static final int T__59=59;
	public static final int T__60=60;
	public static final int T__61=61;
	public static final int T__62=62;
	public static final int T__63=63;
	public static final int T__64=64;
	public static final int T__65=65;
	public static final int T__66=66;
	public static final int T__67=67;
	public static final int T__68=68;
	public static final int T__69=69;
	public static final int T__70=70;
	public static final int T__71=71;
	public static final int T__72=72;
	public static final int T__73=73;
	public static final int T__74=74;
	public static final int T__75=75;
	public static final int T__76=76;
	public static final int T__77=77;
	public static final int T__78=78;
	public static final int T__79=79;
	public static final int T__80=80;
	public static final int T__81=81;
	public static final int T__82=82;
	public static final int T__83=83;
	public static final int T__84=84;
	public static final int T__85=85;
	public static final int T__86=86;
	public static final int CHAR=45;
	public static final int DIGITO=46;
	public static final int FLOAT=47;
	public static final int ID=48;
	public static final int INT=49;
	public static final int LETRA=50;
	public static final int STRING=51;
	public static final int SufixoFloat=52;
	public static final int WS=53;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public mspLexer() {} 
	public mspLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public mspLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g"; }

	// $ANTLR start "T__54"
	public final void mT__54() throws RecognitionException {
		try {
			int _type = T__54;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:9:7: ( ',' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:9:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__54"

	// $ANTLR start "T__55"
	public final void mT__55() throws RecognitionException {
		try {
			int _type = T__55;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:10:7: ( 'ALabel' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:10:9: 'ALabel'
			{
			match("ALabel"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__55"

	// $ANTLR start "T__56"
	public final void mT__56() throws RecognitionException {
		try {
			int _type = T__56;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:11:7: ( 'Add' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:11:9: 'Add'
			{
			match("Add"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__56"

	// $ANTLR start "T__57"
	public final void mT__57() throws RecognitionException {
		try {
			int _type = T__57;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:12:7: ( 'And' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:12:9: 'And'
			{
			match("And"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__57"

	// $ANTLR start "T__58"
	public final void mT__58() throws RecognitionException {
		try {
			int _type = T__58;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:13:7: ( 'Call' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:13:9: 'Call'
			{
			match("Call"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__58"

	// $ANTLR start "T__59"
	public final void mT__59() throws RecognitionException {
		try {
			int _type = T__59;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:14:7: ( 'Decl' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:14:9: 'Decl'
			{
			match("Decl"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__59"

	// $ANTLR start "T__60"
	public final void mT__60() throws RecognitionException {
		try {
			int _type = T__60;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:15:7: ( 'Div' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:15:9: 'Div'
			{
			match("Div"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__60"

	// $ANTLR start "T__61"
	public final void mT__61() throws RecognitionException {
		try {
			int _type = T__61;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:16:7: ( 'Eq' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:16:9: 'Eq'
			{
			match("Eq"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__61"

	// $ANTLR start "T__62"
	public final void mT__62() throws RecognitionException {
		try {
			int _type = T__62;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:17:7: ( 'GoEq' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:17:9: 'GoEq'
			{
			match("GoEq"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__62"

	// $ANTLR start "T__63"
	public final void mT__63() throws RecognitionException {
		try {
			int _type = T__63;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:18:7: ( 'Gt' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:18:9: 'Gt'
			{
			match("Gt"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__63"

	// $ANTLR start "T__64"
	public final void mT__64() throws RecognitionException {
		try {
			int _type = T__64;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:19:7: ( 'Halt' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:19:9: 'Halt'
			{
			match("Halt"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__64"

	// $ANTLR start "T__65"
	public final void mT__65() throws RecognitionException {
		try {
			int _type = T__65;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:20:7: ( 'IIn' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:20:9: 'IIn'
			{
			match("IIn"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__65"

	// $ANTLR start "T__66"
	public final void mT__66() throws RecognitionException {
		try {
			int _type = T__66;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:21:7: ( 'IOut' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:21:9: 'IOut'
			{
			match("IOut"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__66"

	// $ANTLR start "T__67"
	public final void mT__67() throws RecognitionException {
		try {
			int _type = T__67;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:22:7: ( 'Jump' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:22:9: 'Jump'
			{
			match("Jump"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__67"

	// $ANTLR start "T__68"
	public final void mT__68() throws RecognitionException {
		try {
			int _type = T__68;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:23:7: ( 'Jumpf' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:23:9: 'Jumpf'
			{
			match("Jumpf"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__68"

	// $ANTLR start "T__69"
	public final void mT__69() throws RecognitionException {
		try {
			int _type = T__69;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:24:7: ( 'LoEq' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:24:9: 'LoEq'
			{
			match("LoEq"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__69"

	// $ANTLR start "T__70"
	public final void mT__70() throws RecognitionException {
		try {
			int _type = T__70;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:25:7: ( 'Load' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:25:9: 'Load'
			{
			match("Load"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__70"

	// $ANTLR start "T__71"
	public final void mT__71() throws RecognitionException {
		try {
			int _type = T__71;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:26:7: ( 'Lt' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:26:9: 'Lt'
			{
			match("Lt"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__71"

	// $ANTLR start "T__72"
	public final void mT__72() throws RecognitionException {
		try {
			int _type = T__72;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:27:7: ( 'Mod' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:27:9: 'Mod'
			{
			match("Mod"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__72"

	// $ANTLR start "T__73"
	public final void mT__73() throws RecognitionException {
		try {
			int _type = T__73;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:28:7: ( 'Mul' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:28:9: 'Mul'
			{
			match("Mul"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__73"

	// $ANTLR start "T__74"
	public final void mT__74() throws RecognitionException {
		try {
			int _type = T__74;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:29:7: ( 'Neq' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:29:9: 'Neq'
			{
			match("Neq"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__74"

	// $ANTLR start "T__75"
	public final void mT__75() throws RecognitionException {
		try {
			int _type = T__75;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:30:7: ( 'Not' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:30:9: 'Not'
			{
			match("Not"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__75"

	// $ANTLR start "T__76"
	public final void mT__76() throws RecognitionException {
		try {
			int _type = T__76;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:31:7: ( 'Or' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:31:9: 'Or'
			{
			match("Or"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__76"

	// $ANTLR start "T__77"
	public final void mT__77() throws RecognitionException {
		try {
			int _type = T__77;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:32:7: ( 'Pushb' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:32:9: 'Pushb'
			{
			match("Pushb"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__77"

	// $ANTLR start "T__78"
	public final void mT__78() throws RecognitionException {
		try {
			int _type = T__78;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:33:7: ( 'Pushc' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:33:9: 'Pushc'
			{
			match("Pushc"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__78"

	// $ANTLR start "T__79"
	public final void mT__79() throws RecognitionException {
		try {
			int _type = T__79;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:34:7: ( 'Pushf' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:34:9: 'Pushf'
			{
			match("Pushf"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__79"

	// $ANTLR start "T__80"
	public final void mT__80() throws RecognitionException {
		try {
			int _type = T__80;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:35:7: ( 'Pushi' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:35:9: 'Pushi'
			{
			match("Pushi"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__80"

	// $ANTLR start "T__81"
	public final void mT__81() throws RecognitionException {
		try {
			int _type = T__81;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:36:7: ( 'Pushv' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:36:9: 'Pushv'
			{
			match("Pushv"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__81"

	// $ANTLR start "T__82"
	public final void mT__82() throws RecognitionException {
		try {
			int _type = T__82;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:37:7: ( 'Ret' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:37:9: 'Ret'
			{
			match("Ret"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__82"

	// $ANTLR start "T__83"
	public final void mT__83() throws RecognitionException {
		try {
			int _type = T__83;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:38:7: ( 'Store' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:38:9: 'Store'
			{
			match("Store"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__83"

	// $ANTLR start "T__84"
	public final void mT__84() throws RecognitionException {
		try {
			int _type = T__84;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:39:7: ( 'Sub' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:39:9: 'Sub'
			{
			match("Sub"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__84"

	// $ANTLR start "T__85"
	public final void mT__85() throws RecognitionException {
		try {
			int _type = T__85;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:40:7: ( 'false' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:40:9: 'false'
			{
			match("false"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__85"

	// $ANTLR start "T__86"
	public final void mT__86() throws RecognitionException {
		try {
			int _type = T__86;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:41:7: ( 'true' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:41:9: 'true'
			{
			match("true"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__86"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:77:2: ( '\\\"' (~ ( '\"' ) )* '\\\"' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:77:4: '\\\"' (~ ( '\"' ) )* '\\\"'
			{
			match('\"'); 
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:77:9: (~ ( '\"' ) )*
			loop1:
			do {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '\u0000' && LA1_0 <= '!')||(LA1_0 >= '#' && LA1_0 <= '\uFFFF')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
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
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "CHAR"
	public final void mCHAR() throws RecognitionException {
		try {
			int _type = CHAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:81:2: ( '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) |~ ( '\\'' | '\\\\' ) ) '\\'' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:81:4: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) |~ ( '\\'' | '\\\\' ) ) '\\''
			{
			match('\''); 
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:81:9: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) |~ ( '\\'' | '\\\\' ) )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='\\') ) {
				alt2=1;
			}
			else if ( ((LA2_0 >= '\u0000' && LA2_0 <= '&')||(LA2_0 >= '(' && LA2_0 <= '[')||(LA2_0 >= ']' && LA2_0 <= '\uFFFF')) ) {
				alt2=2;
			}
			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:81:11: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
					{
					match('\\'); 
					if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 2 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:81:55: ~ ( '\\'' | '\\\\' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			match('\''); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHAR"

	// $ANTLR start "DIGITO"
	public final void mDIGITO() throws RecognitionException {
		try {
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:85:3: ( ( '0' .. '9' )+ )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:85:5: ( '0' .. '9' )+
			{
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:85:5: ( '0' .. '9' )+
			int cnt3=0;
			loop3:
			do {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
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
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIGITO"

	// $ANTLR start "FLOAT"
	public final void mFLOAT() throws RecognitionException {
		try {
			int _type = FLOAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:89:2: ( ( DIGITO )+ '.' ( DIGITO )* ( SufixoFloat )? | '.' ( DIGITO )+ ( SufixoFloat )? | INT SufixoFloat )
			int alt9=3;
			alt9 = dfa9.predict(input);
			switch (alt9) {
				case 1 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:89:4: ( DIGITO )+ '.' ( DIGITO )* ( SufixoFloat )?
					{
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:89:4: ( DIGITO )+
					int cnt4=0;
					loop4:
					do {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:89:4: DIGITO
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
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:89:16: ( DIGITO )*
					loop5:
					do {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:89:16: DIGITO
							{
							mDIGITO(); 

							}
							break;

						default :
							break loop5;
						}
					} while (true);

					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:89:24: ( SufixoFloat )?
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0=='F'||LA6_0=='f') ) {
						alt6=1;
					}
					switch (alt6) {
						case 1 :
							// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:
							{
							if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

					}

					}
					break;
				case 2 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:90:4: '.' ( DIGITO )+ ( SufixoFloat )?
					{
					match('.'); 
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:90:8: ( DIGITO )+
					int cnt7=0;
					loop7:
					do {
						int alt7=2;
						int LA7_0 = input.LA(1);
						if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
							alt7=1;
						}

						switch (alt7) {
						case 1 :
							// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:90:8: DIGITO
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

					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:90:16: ( SufixoFloat )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0=='F'||LA8_0=='f') ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:
							{
							if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

					}

					}
					break;
				case 3 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:91:4: INT SufixoFloat
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
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT"

	// $ANTLR start "SufixoFloat"
	public final void mSufixoFloat() throws RecognitionException {
		try {
			int _type = SufixoFloat;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:95:2: ( 'f' | 'F' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:
			{
			if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SufixoFloat"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:99:2: ( ( '0' | '1' .. '9' ( DIGITO )* ) )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:99:4: ( '0' | '1' .. '9' ( DIGITO )* )
			{
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:99:4: ( '0' | '1' .. '9' ( DIGITO )* )
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0=='0') ) {
				alt11=1;
			}
			else if ( ((LA11_0 >= '1' && LA11_0 <= '9')) ) {
				alt11=2;
			}
			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:99:5: '0'
					{
					match('0'); 
					}
					break;
				case 2 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:99:11: '1' .. '9' ( DIGITO )*
					{
					matchRange('1','9'); 
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:99:20: ( DIGITO )*
					loop10:
					do {
						int alt10=2;
						int LA10_0 = input.LA(1);
						if ( ((LA10_0 >= '0' && LA10_0 <= '9')) ) {
							alt10=1;
						}

						switch (alt10) {
						case 1 :
							// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:99:20: DIGITO
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
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:102:5: ( LETRA ( LETRA | '0' .. '9' )* )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:102:7: LETRA ( LETRA | '0' .. '9' )*
			{
			mLETRA(); 

			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:102:13: ( LETRA | '0' .. '9' )*
			loop12:
			do {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( ((LA12_0 >= '0' && LA12_0 <= '9')||(LA12_0 >= 'A' && LA12_0 <= 'Z')||LA12_0=='_'||(LA12_0 >= 'a' && LA12_0 <= 'z')) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
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
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "LETRA"
	public final void mLETRA() throws RecognitionException {
		try {
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:106:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LETRA"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:109:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:109:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
			{
			if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:8: ( T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | STRING | CHAR | FLOAT | SufixoFloat | INT | ID | WS )
		int alt13=40;
		alt13 = dfa13.predict(input);
		switch (alt13) {
			case 1 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:10: T__54
				{
				mT__54(); 

				}
				break;
			case 2 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:16: T__55
				{
				mT__55(); 

				}
				break;
			case 3 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:22: T__56
				{
				mT__56(); 

				}
				break;
			case 4 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:28: T__57
				{
				mT__57(); 

				}
				break;
			case 5 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:34: T__58
				{
				mT__58(); 

				}
				break;
			case 6 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:40: T__59
				{
				mT__59(); 

				}
				break;
			case 7 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:46: T__60
				{
				mT__60(); 

				}
				break;
			case 8 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:52: T__61
				{
				mT__61(); 

				}
				break;
			case 9 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:58: T__62
				{
				mT__62(); 

				}
				break;
			case 10 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:64: T__63
				{
				mT__63(); 

				}
				break;
			case 11 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:70: T__64
				{
				mT__64(); 

				}
				break;
			case 12 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:76: T__65
				{
				mT__65(); 

				}
				break;
			case 13 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:82: T__66
				{
				mT__66(); 

				}
				break;
			case 14 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:88: T__67
				{
				mT__67(); 

				}
				break;
			case 15 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:94: T__68
				{
				mT__68(); 

				}
				break;
			case 16 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:100: T__69
				{
				mT__69(); 

				}
				break;
			case 17 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:106: T__70
				{
				mT__70(); 

				}
				break;
			case 18 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:112: T__71
				{
				mT__71(); 

				}
				break;
			case 19 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:118: T__72
				{
				mT__72(); 

				}
				break;
			case 20 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:124: T__73
				{
				mT__73(); 

				}
				break;
			case 21 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:130: T__74
				{
				mT__74(); 

				}
				break;
			case 22 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:136: T__75
				{
				mT__75(); 

				}
				break;
			case 23 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:142: T__76
				{
				mT__76(); 

				}
				break;
			case 24 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:148: T__77
				{
				mT__77(); 

				}
				break;
			case 25 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:154: T__78
				{
				mT__78(); 

				}
				break;
			case 26 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:160: T__79
				{
				mT__79(); 

				}
				break;
			case 27 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:166: T__80
				{
				mT__80(); 

				}
				break;
			case 28 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:172: T__81
				{
				mT__81(); 

				}
				break;
			case 29 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:178: T__82
				{
				mT__82(); 

				}
				break;
			case 30 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:184: T__83
				{
				mT__83(); 

				}
				break;
			case 31 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:190: T__84
				{
				mT__84(); 

				}
				break;
			case 32 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:196: T__85
				{
				mT__85(); 

				}
				break;
			case 33 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:202: T__86
				{
				mT__86(); 

				}
				break;
			case 34 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:208: STRING
				{
				mSTRING(); 

				}
				break;
			case 35 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:215: CHAR
				{
				mCHAR(); 

				}
				break;
			case 36 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:220: FLOAT
				{
				mFLOAT(); 

				}
				break;
			case 37 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:226: SufixoFloat
				{
				mSufixoFloat(); 

				}
				break;
			case 38 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:238: INT
				{
				mINT(); 

				}
				break;
			case 39 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:242: ID
				{
				mID(); 

				}
				break;
			case 40 :
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:1:245: WS
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
		"\2\uffff\1\2\1\uffff\1\1\1\3\1\uffff";
	static final String DFA9_specialS =
		"\7\uffff}>";
	static final String[] DFA9_transitionS = {
			"\1\2\1\uffff\1\1\11\3",
			"\1\4\1\uffff\12\4\14\uffff\1\5\37\uffff\1\5",
			"",
			"\1\4\1\uffff\12\6\14\uffff\1\5\37\uffff\1\5",
			"",
			"",
			"\1\4\1\uffff\12\6\14\uffff\1\5\37\uffff\1\5"
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
		@Override
		public String getDescription() {
			return "88:1: FLOAT : ( ( DIGITO )+ '.' ( DIGITO )* ( SufixoFloat )? | '.' ( DIGITO )+ ( SufixoFloat )? | INT SufixoFloat );";
		}
	}

	static final String DFA13_eotS =
		"\2\uffff\17\31\1\64\1\31\2\uffff\1\66\1\uffff\1\66\1\64\2\uffff\6\31\1"+
		"\76\1\31\1\100\5\31\1\107\4\31\1\114\5\31\1\uffff\1\31\1\uffff\1\66\1"+
		"\31\1\124\1\125\2\31\1\130\1\uffff\1\31\1\uffff\1\31\1\133\4\31\1\uffff"+
		"\1\140\1\141\1\142\1\143\1\uffff\1\31\1\145\1\31\1\147\3\31\2\uffff\1"+
		"\153\1\154\1\uffff\1\155\1\156\1\uffff\1\157\1\161\1\162\1\163\4\uffff"+
		"\1\31\1\uffff\1\31\1\uffff\1\31\1\173\1\31\5\uffff\1\175\3\uffff\1\176"+
		"\1\177\1\u0080\1\u0081\1\u0082\1\u0083\1\u0084\1\uffff\1\u0085\11\uffff";
	static final String DFA13_eofS =
		"\u0086\uffff";
	static final String DFA13_minS =
		"\1\11\1\uffff\1\114\1\141\1\145\1\161\1\157\1\141\1\111\1\165\2\157\1"+
		"\145\1\162\1\165\1\145\1\164\1\60\1\162\2\uffff\1\56\1\uffff\1\56\1\60"+
		"\2\uffff\1\141\2\144\1\154\1\143\1\166\1\60\1\105\1\60\1\154\1\156\1\165"+
		"\1\155\1\105\1\60\1\144\1\154\1\161\1\164\1\60\1\163\1\164\1\157\1\142"+
		"\1\154\1\uffff\1\165\1\uffff\1\56\1\142\2\60\2\154\1\60\1\uffff\1\161"+
		"\1\uffff\1\164\1\60\1\164\1\160\1\161\1\144\1\uffff\4\60\1\uffff\1\150"+
		"\1\60\1\162\1\60\1\163\2\145\2\uffff\2\60\1\uffff\2\60\1\uffff\4\60\4"+
		"\uffff\1\142\1\uffff\1\145\1\uffff\1\145\1\60\1\154\5\uffff\1\60\3\uffff"+
		"\7\60\1\uffff\1\60\11\uffff";
	static final String DFA13_maxS =
		"\1\172\1\uffff\1\156\1\141\1\151\1\161\1\164\1\141\1\117\1\165\1\164\1"+
		"\165\1\157\1\162\1\165\1\145\1\165\1\172\1\162\2\uffff\1\146\1\uffff\1"+
		"\146\1\172\2\uffff\1\141\2\144\1\154\1\143\1\166\1\172\1\105\1\172\1\154"+
		"\1\156\1\165\1\155\1\141\1\172\1\144\1\154\1\161\1\164\1\172\1\163\1\164"+
		"\1\157\1\142\1\154\1\uffff\1\165\1\uffff\1\146\1\142\2\172\2\154\1\172"+
		"\1\uffff\1\161\1\uffff\1\164\1\172\1\164\1\160\1\161\1\144\1\uffff\4\172"+
		"\1\uffff\1\150\1\172\1\162\1\172\1\163\2\145\2\uffff\2\172\1\uffff\2\172"+
		"\1\uffff\4\172\4\uffff\1\166\1\uffff\1\145\1\uffff\1\145\1\172\1\154\5"+
		"\uffff\1\172\3\uffff\7\172\1\uffff\1\172\11\uffff";
	static final String DFA13_acceptS =
		"\1\uffff\1\1\21\uffff\1\42\1\43\1\uffff\1\44\2\uffff\1\47\1\50\31\uffff"+
		"\1\45\1\uffff\1\46\7\uffff\1\10\1\uffff\1\12\6\uffff\1\22\4\uffff\1\27"+
		"\7\uffff\1\3\1\4\2\uffff\1\7\2\uffff\1\14\4\uffff\1\23\1\24\1\25\1\26"+
		"\1\uffff\1\35\1\uffff\1\37\3\uffff\1\5\1\6\1\11\1\13\1\15\1\uffff\1\16"+
		"\1\20\1\21\7\uffff\1\41\1\uffff\1\17\1\30\1\31\1\32\1\33\1\34\1\36\1\40"+
		"\1\2";
	static final String DFA13_specialS =
		"\u0086\uffff}>";
	static final String[] DFA13_transitionS = {
			"\2\32\1\uffff\2\32\22\uffff\1\32\1\uffff\1\23\4\uffff\1\24\4\uffff\1"+
			"\1\1\uffff\1\26\1\uffff\1\25\11\27\7\uffff\1\2\1\31\1\3\1\4\1\5\1\30"+
			"\1\6\1\7\1\10\1\11\1\31\1\12\1\13\1\14\1\15\1\16\1\31\1\17\1\20\7\31"+
			"\4\uffff\1\31\1\uffff\5\31\1\21\15\31\1\22\6\31",
			"",
			"\1\33\27\uffff\1\34\11\uffff\1\35",
			"\1\36",
			"\1\37\3\uffff\1\40",
			"\1\41",
			"\1\42\4\uffff\1\43",
			"\1\44",
			"\1\45\5\uffff\1\46",
			"\1\47",
			"\1\50\4\uffff\1\51",
			"\1\52\5\uffff\1\53",
			"\1\54\11\uffff\1\55",
			"\1\56",
			"\1\57",
			"\1\60",
			"\1\61\1\62",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\1\63\31\31",
			"\1\65",
			"",
			"",
			"\1\26\1\uffff\12\26\14\uffff\1\26\37\uffff\1\26",
			"",
			"\1\26\1\uffff\12\67\14\uffff\1\26\37\uffff\1\26",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"",
			"",
			"\1\70",
			"\1\71",
			"\1\72",
			"\1\73",
			"\1\74",
			"\1\75",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\77",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\101",
			"\1\102",
			"\1\103",
			"\1\104",
			"\1\105\33\uffff\1\106",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\110",
			"\1\111",
			"\1\112",
			"\1\113",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\115",
			"\1\116",
			"\1\117",
			"\1\120",
			"\1\121",
			"",
			"\1\122",
			"",
			"\1\26\1\uffff\12\67\14\uffff\1\26\37\uffff\1\26",
			"\1\123",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\126",
			"\1\127",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"",
			"\1\131",
			"",
			"\1\132",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\134",
			"\1\135",
			"\1\136",
			"\1\137",
			"",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"",
			"\1\144",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\146",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\150",
			"\1\151",
			"\1\152",
			"",
			"",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\5\31\1\160\24\31",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"",
			"",
			"",
			"",
			"\1\164\1\165\2\uffff\1\166\2\uffff\1\167\14\uffff\1\170",
			"",
			"\1\171",
			"",
			"\1\172",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\174",
			"",
			"",
			"",
			"",
			"",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"",
			"",
			"",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
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
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | STRING | CHAR | FLOAT | SufixoFloat | INT | ID | WS );";
		}
	}

}
