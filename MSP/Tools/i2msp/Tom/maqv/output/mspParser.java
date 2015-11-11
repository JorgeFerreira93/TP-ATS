// $ANTLR 3.x /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g 2013-02-16 19:26:44
 package maqv; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class mspParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Instrucoes", "Decl", "Store", "Load", "Push", "Jumpf", "Jump", "IOut", "IIn", "Halt", "And", "Or", "Nott", "LoEq", "Lt", "GoEq", "Gt", "Neq", "Eq", "Mod", "Mul", "Div", "Sub", "Add", "Ret", "Call", "ALabel", "False", "True", "Vazio", "F", "B", "S", "I", "Stackk", "CHAR", "DIGITO", "FLOAT", "ID", "INT", "LETRA", "STRING", "SufixoFloat", "WS", "','", "'ALabel'", "'Add'", "'And'", "'Call'", "'Decl'", "'Div'", "'Eq'", "'GoEq'", "'Gt'", "'Halt'", "'IIn'", "'IOut'", "'Jump'", "'Jumpf'", "'LoEq'", "'Load'", "'Lt'", "'Mod'", "'Mul'", "'Neq'", "'Not'", "'Or'", "'Pushb'", "'Pushc'", "'Pushf'", "'Pushi'", "'Pushv'", "'Ret'", "'Store'", "'Sub'", "'false'", "'true'"
	};

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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public mspParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public mspParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
	this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
	return adaptor;
}
	@Override public String[] getTokenNames() { return mspParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g"; }


	public static class programa_return extends ParserRuleReturnScope {
		Tree tree;
		public Object getTree() { return tree; }
	};


	// $ANTLR start "programa"
	// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:14:1: programa : instrucao ( ',' instrucao )* EOF -> ^( Instrucoes ( instrucao )+ ) ;
	public final mspParser.programa_return programa() throws RecognitionException {
		mspParser.programa_return retval = new mspParser.programa_return();
		retval.start = input.LT(1);

		Tree root_0 = null;

		Token char_literal2=null;
		Token EOF4=null;
		ParserRuleReturnScope instrucao1 =null;
		ParserRuleReturnScope instrucao3 =null;

		Tree char_literal2_tree=null;
		Tree EOF4_tree=null;
		RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
		RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
		RewriteRuleSubtreeStream stream_instrucao=new RewriteRuleSubtreeStream(adaptor,"rule instrucao");

		try {
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:14:10: ( instrucao ( ',' instrucao )* EOF -> ^( Instrucoes ( instrucao )+ ) )
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:15:2: instrucao ( ',' instrucao )* EOF
			{
			pushFollow(FOLLOW_instrucao_in_programa54);
			instrucao1=instrucao();
			state._fsp--;

			stream_instrucao.add(instrucao1.getTree());
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:15:12: ( ',' instrucao )*
			loop1:
			do {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==54) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:15:13: ',' instrucao
					{
					char_literal2=(Token)match(input,54,FOLLOW_54_in_programa57);  
					stream_54.add(char_literal2);

					pushFollow(FOLLOW_instrucao_in_programa59);
					instrucao3=instrucao();
					state._fsp--;

					stream_instrucao.add(instrucao3.getTree());
					}
					break;

				default :
					break loop1;
				}
			} while (true);

			EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_programa63);  
			stream_EOF.add(EOF4);

			// AST REWRITE
			// elements: instrucao
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Tree)adaptor.nil();
			// 15:33: -> ^( Instrucoes ( instrucao )+ )
			{
				// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:15:36: ^( Instrucoes ( instrucao )+ )
				{
				Tree root_1 = (Tree)adaptor.nil();
				root_1 = (Tree)adaptor.becomeRoot(
				(Tree)adaptor.create(Instrucoes, "Instrucoes")
				, root_1);

				if ( !(stream_instrucao.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_instrucao.hasNext() ) {
					adaptor.addChild(root_1, stream_instrucao.nextTree());

				}
				stream_instrucao.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Tree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Tree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "programa"


	public static class instrucao_return extends ParserRuleReturnScope {
		Tree tree;
		public Object getTree() { return tree; }
	};


	// $ANTLR start "instrucao"
	// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:18:1: instrucao : ( 'ALabel' STRING -> ^( ALabel STRING ) | 'Call' STRING -> ^( Call STRING ) | 'Ret' -> ^( Ret ) | 'Add' -> ^( Add ) | 'Sub' -> ^( Sub ) | 'Div' -> ^( Div ) | 'Mul' -> ^( Mul ) | 'Mod' -> ^( Mod ) | 'Eq' -> ^( Eq ) | 'Neq' -> ^( Neq ) | 'Gt' -> ^( Gt ) | 'GoEq' -> ^( GoEq ) | 'Lt' -> ^( Lt ) | 'LoEq' -> ^( LoEq ) | 'Not' -> ^( Nott ) | 'Or' -> ^( Or ) | 'And' -> ^( And ) | 'Halt' -> ^( Halt ) | 'IIn' -> ^( IIn ) | 'IOut' -> ^( IOut ) | 'Jump' STRING -> ^( Jump STRING ) | 'Jumpf' STRING -> ^( Jumpf STRING ) | 'Pushv' STRING -> ^( Push ^( S STRING ) ) | 'Pushi' INT -> ^( Push ^( I INT ) ) | 'Pushc' CHAR -> ^( Push ^( S CHAR ) ) | 'Pushf' FLOAT -> ^( Push ^( F FLOAT ) ) | 'Pushb' boolean_ -> ^( Push boolean_ ) | 'Load' -> ^( Load ) | 'Store' -> ^( Store ) | 'Decl' STRING valor -> ^( Decl STRING valor ) );
	public final mspParser.instrucao_return instrucao() throws RecognitionException {
		mspParser.instrucao_return retval = new mspParser.instrucao_return();
		retval.start = input.LT(1);

		Tree root_0 = null;

		Token string_literal5=null;
		Token STRING6=null;
		Token string_literal7=null;
		Token STRING8=null;
		Token string_literal9=null;
		Token string_literal10=null;
		Token string_literal11=null;
		Token string_literal12=null;
		Token string_literal13=null;
		Token string_literal14=null;
		Token string_literal15=null;
		Token string_literal16=null;
		Token string_literal17=null;
		Token string_literal18=null;
		Token string_literal19=null;
		Token string_literal20=null;
		Token string_literal21=null;
		Token string_literal22=null;
		Token string_literal23=null;
		Token string_literal24=null;
		Token string_literal25=null;
		Token string_literal26=null;
		Token string_literal27=null;
		Token STRING28=null;
		Token string_literal29=null;
		Token STRING30=null;
		Token string_literal31=null;
		Token STRING32=null;
		Token string_literal33=null;
		Token INT34=null;
		Token string_literal35=null;
		Token CHAR36=null;
		Token string_literal37=null;
		Token FLOAT38=null;
		Token string_literal39=null;
		Token string_literal41=null;
		Token string_literal42=null;
		Token string_literal43=null;
		Token STRING44=null;
		ParserRuleReturnScope boolean_40 =null;
		ParserRuleReturnScope valor45 =null;

		Tree string_literal5_tree=null;
		Tree STRING6_tree=null;
		Tree string_literal7_tree=null;
		Tree STRING8_tree=null;
		Tree string_literal9_tree=null;
		Tree string_literal10_tree=null;
		Tree string_literal11_tree=null;
		Tree string_literal12_tree=null;
		Tree string_literal13_tree=null;
		Tree string_literal14_tree=null;
		Tree string_literal15_tree=null;
		Tree string_literal16_tree=null;
		Tree string_literal17_tree=null;
		Tree string_literal18_tree=null;
		Tree string_literal19_tree=null;
		Tree string_literal20_tree=null;
		Tree string_literal21_tree=null;
		Tree string_literal22_tree=null;
		Tree string_literal23_tree=null;
		Tree string_literal24_tree=null;
		Tree string_literal25_tree=null;
		Tree string_literal26_tree=null;
		Tree string_literal27_tree=null;
		Tree STRING28_tree=null;
		Tree string_literal29_tree=null;
		Tree STRING30_tree=null;
		Tree string_literal31_tree=null;
		Tree STRING32_tree=null;
		Tree string_literal33_tree=null;
		Tree INT34_tree=null;
		Tree string_literal35_tree=null;
		Tree CHAR36_tree=null;
		Tree string_literal37_tree=null;
		Tree FLOAT38_tree=null;
		Tree string_literal39_tree=null;
		Tree string_literal41_tree=null;
		Tree string_literal42_tree=null;
		Tree string_literal43_tree=null;
		Tree STRING44_tree=null;
		RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
		RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
		RewriteRuleTokenStream stream_CHAR=new RewriteRuleTokenStream(adaptor,"token CHAR");
		RewriteRuleTokenStream stream_FLOAT=new RewriteRuleTokenStream(adaptor,"token FLOAT");
		RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
		RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
		RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
		RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
		RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
		RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
		RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
		RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
		RewriteRuleSubtreeStream stream_valor=new RewriteRuleSubtreeStream(adaptor,"rule valor");
		RewriteRuleSubtreeStream stream_boolean_=new RewriteRuleSubtreeStream(adaptor,"rule boolean_");

		try {
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:19:2: ( 'ALabel' STRING -> ^( ALabel STRING ) | 'Call' STRING -> ^( Call STRING ) | 'Ret' -> ^( Ret ) | 'Add' -> ^( Add ) | 'Sub' -> ^( Sub ) | 'Div' -> ^( Div ) | 'Mul' -> ^( Mul ) | 'Mod' -> ^( Mod ) | 'Eq' -> ^( Eq ) | 'Neq' -> ^( Neq ) | 'Gt' -> ^( Gt ) | 'GoEq' -> ^( GoEq ) | 'Lt' -> ^( Lt ) | 'LoEq' -> ^( LoEq ) | 'Not' -> ^( Nott ) | 'Or' -> ^( Or ) | 'And' -> ^( And ) | 'Halt' -> ^( Halt ) | 'IIn' -> ^( IIn ) | 'IOut' -> ^( IOut ) | 'Jump' STRING -> ^( Jump STRING ) | 'Jumpf' STRING -> ^( Jumpf STRING ) | 'Pushv' STRING -> ^( Push ^( S STRING ) ) | 'Pushi' INT -> ^( Push ^( I INT ) ) | 'Pushc' CHAR -> ^( Push ^( S CHAR ) ) | 'Pushf' FLOAT -> ^( Push ^( F FLOAT ) ) | 'Pushb' boolean_ -> ^( Push boolean_ ) | 'Load' -> ^( Load ) | 'Store' -> ^( Store ) | 'Decl' STRING valor -> ^( Decl STRING valor ) )
			int alt2=30;
			switch ( input.LA(1) ) {
			case 55:
				{
				alt2=1;
				}
				break;
			case 58:
				{
				alt2=2;
				}
				break;
			case 82:
				{
				alt2=3;
				}
				break;
			case 56:
				{
				alt2=4;
				}
				break;
			case 84:
				{
				alt2=5;
				}
				break;
			case 60:
				{
				alt2=6;
				}
				break;
			case 73:
				{
				alt2=7;
				}
				break;
			case 72:
				{
				alt2=8;
				}
				break;
			case 61:
				{
				alt2=9;
				}
				break;
			case 74:
				{
				alt2=10;
				}
				break;
			case 63:
				{
				alt2=11;
				}
				break;
			case 62:
				{
				alt2=12;
				}
				break;
			case 71:
				{
				alt2=13;
				}
				break;
			case 69:
				{
				alt2=14;
				}
				break;
			case 75:
				{
				alt2=15;
				}
				break;
			case 76:
				{
				alt2=16;
				}
				break;
			case 57:
				{
				alt2=17;
				}
				break;
			case 64:
				{
				alt2=18;
				}
				break;
			case 65:
				{
				alt2=19;
				}
				break;
			case 66:
				{
				alt2=20;
				}
				break;
			case 67:
				{
				alt2=21;
				}
				break;
			case 68:
				{
				alt2=22;
				}
				break;
			case 81:
				{
				alt2=23;
				}
				break;
			case 80:
				{
				alt2=24;
				}
				break;
			case 78:
				{
				alt2=25;
				}
				break;
			case 79:
				{
				alt2=26;
				}
				break;
			case 77:
				{
				alt2=27;
				}
				break;
			case 70:
				{
				alt2=28;
				}
				break;
			case 83:
				{
				alt2=29;
				}
				break;
			case 59:
				{
				alt2=30;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:19:4: 'ALabel' STRING
					{
					string_literal5=(Token)match(input,55,FOLLOW_55_in_instrucao83);  
					stream_55.add(string_literal5);

					STRING6=(Token)match(input,STRING,FOLLOW_STRING_in_instrucao85);  
					stream_STRING.add(STRING6);

					// AST REWRITE
					// elements: STRING
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 19:20: -> ^( ALabel STRING )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:19:23: ^( ALabel STRING )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(ALabel, "ALabel")
						, root_1);

						adaptor.addChild(root_1, 
						stream_STRING.nextNode()
						);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:21:4: 'Call' STRING
					{
					string_literal7=(Token)match(input,58,FOLLOW_58_in_instrucao101);  
					stream_58.add(string_literal7);

					STRING8=(Token)match(input,STRING,FOLLOW_STRING_in_instrucao103);  
					stream_STRING.add(STRING8);

					// AST REWRITE
					// elements: STRING
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 21:18: -> ^( Call STRING )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:21:21: ^( Call STRING )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(Call, "Call")
						, root_1);

						adaptor.addChild(root_1, 
						stream_STRING.nextNode()
						);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:22:4: 'Ret'
					{
					string_literal9=(Token)match(input,82,FOLLOW_82_in_instrucao118);  
					stream_82.add(string_literal9);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 22:10: -> ^( Ret )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:22:13: ^( Ret )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(Ret, "Ret")
						, root_1);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:24:4: 'Add'
					{
					string_literal10=(Token)match(input,56,FOLLOW_56_in_instrucao134);  
					stream_56.add(string_literal10);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 24:10: -> ^( Add )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:24:13: ^( Add )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(Add, "Add")
						, root_1);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 5 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:25:5: 'Sub'
					{
					string_literal11=(Token)match(input,84,FOLLOW_84_in_instrucao149);  
					stream_84.add(string_literal11);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 25:11: -> ^( Sub )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:25:14: ^( Sub )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(Sub, "Sub")
						, root_1);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 6 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:26:4: 'Div'
					{
					string_literal12=(Token)match(input,60,FOLLOW_60_in_instrucao160);  
					stream_60.add(string_literal12);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 26:10: -> ^( Div )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:26:13: ^( Div )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(Div, "Div")
						, root_1);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 7 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:27:4: 'Mul'
					{
					string_literal13=(Token)match(input,73,FOLLOW_73_in_instrucao171);  
					stream_73.add(string_literal13);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 27:10: -> ^( Mul )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:27:13: ^( Mul )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(Mul, "Mul")
						, root_1);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 8 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:28:4: 'Mod'
					{
					string_literal14=(Token)match(input,72,FOLLOW_72_in_instrucao182);  
					stream_72.add(string_literal14);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 28:10: -> ^( Mod )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:28:13: ^( Mod )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(Mod, "Mod")
						, root_1);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 9 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:29:4: 'Eq'
					{
					string_literal15=(Token)match(input,61,FOLLOW_61_in_instrucao193);  
					stream_61.add(string_literal15);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 29:9: -> ^( Eq )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:29:12: ^( Eq )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(Eq, "Eq")
						, root_1);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 10 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:30:4: 'Neq'
					{
					string_literal16=(Token)match(input,74,FOLLOW_74_in_instrucao204);  
					stream_74.add(string_literal16);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 30:10: -> ^( Neq )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:30:13: ^( Neq )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(Neq, "Neq")
						, root_1);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 11 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:31:4: 'Gt'
					{
					string_literal17=(Token)match(input,63,FOLLOW_63_in_instrucao215);  
					stream_63.add(string_literal17);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 31:9: -> ^( Gt )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:31:12: ^( Gt )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(Gt, "Gt")
						, root_1);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 12 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:32:4: 'GoEq'
					{
					string_literal18=(Token)match(input,62,FOLLOW_62_in_instrucao226);  
					stream_62.add(string_literal18);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 32:11: -> ^( GoEq )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:32:14: ^( GoEq )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(GoEq, "GoEq")
						, root_1);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 13 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:33:4: 'Lt'
					{
					string_literal19=(Token)match(input,71,FOLLOW_71_in_instrucao237);  
					stream_71.add(string_literal19);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 33:9: -> ^( Lt )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:33:12: ^( Lt )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(Lt, "Lt")
						, root_1);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 14 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:34:4: 'LoEq'
					{
					string_literal20=(Token)match(input,69,FOLLOW_69_in_instrucao248);  
					stream_69.add(string_literal20);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 34:11: -> ^( LoEq )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:34:14: ^( LoEq )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(LoEq, "LoEq")
						, root_1);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 15 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:35:4: 'Not'
					{
					string_literal21=(Token)match(input,75,FOLLOW_75_in_instrucao259);  
					stream_75.add(string_literal21);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 35:10: -> ^( Nott )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:35:13: ^( Nott )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(Nott, "Nott")
						, root_1);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 16 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:36:4: 'Or'
					{
					string_literal22=(Token)match(input,76,FOLLOW_76_in_instrucao270);  
					stream_76.add(string_literal22);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 36:9: -> ^( Or )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:36:12: ^( Or )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(Or, "Or")
						, root_1);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 17 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:37:4: 'And'
					{
					string_literal23=(Token)match(input,57,FOLLOW_57_in_instrucao281);  
					stream_57.add(string_literal23);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 37:10: -> ^( And )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:37:13: ^( And )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(And, "And")
						, root_1);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 18 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:39:4: 'Halt'
					{
					string_literal24=(Token)match(input,64,FOLLOW_64_in_instrucao294);  
					stream_64.add(string_literal24);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 39:11: -> ^( Halt )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:39:14: ^( Halt )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(Halt, "Halt")
						, root_1);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 19 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:41:4: 'IIn'
					{
					string_literal25=(Token)match(input,65,FOLLOW_65_in_instrucao310);  
					stream_65.add(string_literal25);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 41:10: -> ^( IIn )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:41:13: ^( IIn )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(IIn, "IIn")
						, root_1);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 20 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:42:4: 'IOut'
					{
					string_literal26=(Token)match(input,66,FOLLOW_66_in_instrucao324);  
					stream_66.add(string_literal26);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 42:11: -> ^( IOut )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:42:14: ^( IOut )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(IOut, "IOut")
						, root_1);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 21 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:44:4: 'Jump' STRING
					{
					string_literal27=(Token)match(input,67,FOLLOW_67_in_instrucao337);  
					stream_67.add(string_literal27);

					STRING28=(Token)match(input,STRING,FOLLOW_STRING_in_instrucao339);  
					stream_STRING.add(STRING28);

					// AST REWRITE
					// elements: STRING
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 44:18: -> ^( Jump STRING )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:44:21: ^( Jump STRING )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(Jump, "Jump")
						, root_1);

						adaptor.addChild(root_1, 
						stream_STRING.nextNode()
						);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 22 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:45:4: 'Jumpf' STRING
					{
					string_literal29=(Token)match(input,68,FOLLOW_68_in_instrucao354);  
					stream_68.add(string_literal29);

					STRING30=(Token)match(input,STRING,FOLLOW_STRING_in_instrucao356);  
					stream_STRING.add(STRING30);

					// AST REWRITE
					// elements: STRING
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 45:19: -> ^( Jumpf STRING )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:45:22: ^( Jumpf STRING )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(Jumpf, "Jumpf")
						, root_1);

						adaptor.addChild(root_1, 
						stream_STRING.nextNode()
						);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 23 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:47:4: 'Pushv' STRING
					{
					string_literal31=(Token)match(input,81,FOLLOW_81_in_instrucao371);  
					stream_81.add(string_literal31);

					STRING32=(Token)match(input,STRING,FOLLOW_STRING_in_instrucao373);  
					stream_STRING.add(STRING32);

					// AST REWRITE
					// elements: STRING
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 47:19: -> ^( Push ^( S STRING ) )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:47:22: ^( Push ^( S STRING ) )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(Push, "Push")
						, root_1);

						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:47:29: ^( S STRING )
						{
						Tree root_2 = (Tree)adaptor.nil();
						root_2 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(S, "S")
						, root_2);

						adaptor.addChild(root_2, 
						stream_STRING.nextNode()
						);

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 24 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:48:4: 'Pushi' INT
					{
					string_literal33=(Token)match(input,80,FOLLOW_80_in_instrucao392);  
					stream_80.add(string_literal33);

					INT34=(Token)match(input,INT,FOLLOW_INT_in_instrucao394);  
					stream_INT.add(INT34);

					// AST REWRITE
					// elements: INT
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 48:16: -> ^( Push ^( I INT ) )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:48:19: ^( Push ^( I INT ) )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(Push, "Push")
						, root_1);

						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:48:26: ^( I INT )
						{
						Tree root_2 = (Tree)adaptor.nil();
						root_2 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(I, "I")
						, root_2);

						adaptor.addChild(root_2, 
						stream_INT.nextNode()
						);

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 25 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:49:4: 'Pushc' CHAR
					{
					string_literal35=(Token)match(input,78,FOLLOW_78_in_instrucao411);  
					stream_78.add(string_literal35);

					CHAR36=(Token)match(input,CHAR,FOLLOW_CHAR_in_instrucao413);  
					stream_CHAR.add(CHAR36);

					// AST REWRITE
					// elements: CHAR
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 49:17: -> ^( Push ^( S CHAR ) )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:49:20: ^( Push ^( S CHAR ) )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(Push, "Push")
						, root_1);

						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:49:27: ^( S CHAR )
						{
						Tree root_2 = (Tree)adaptor.nil();
						root_2 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(S, "S")
						, root_2);

						adaptor.addChild(root_2, 
						stream_CHAR.nextNode()
						);

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 26 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:50:4: 'Pushf' FLOAT
					{
					string_literal37=(Token)match(input,79,FOLLOW_79_in_instrucao430);  
					stream_79.add(string_literal37);

					FLOAT38=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_instrucao432);  
					stream_FLOAT.add(FLOAT38);

					// AST REWRITE
					// elements: FLOAT
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 50:18: -> ^( Push ^( F FLOAT ) )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:50:21: ^( Push ^( F FLOAT ) )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(Push, "Push")
						, root_1);

						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:50:28: ^( F FLOAT )
						{
						Tree root_2 = (Tree)adaptor.nil();
						root_2 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(F, "F")
						, root_2);

						adaptor.addChild(root_2, 
						stream_FLOAT.nextNode()
						);

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 27 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:51:4: 'Pushb' boolean_
					{
					string_literal39=(Token)match(input,77,FOLLOW_77_in_instrucao449);  
					stream_77.add(string_literal39);

					pushFollow(FOLLOW_boolean__in_instrucao451);
					boolean_40=boolean_();
					state._fsp--;

					stream_boolean_.add(boolean_40.getTree());
					// AST REWRITE
					// elements: boolean_
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 51:21: -> ^( Push boolean_ )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:51:24: ^( Push boolean_ )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(Push, "Push")
						, root_1);

						adaptor.addChild(root_1, stream_boolean_.nextTree());

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 28 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:52:4: 'Load'
					{
					string_literal41=(Token)match(input,70,FOLLOW_70_in_instrucao464);  
					stream_70.add(string_literal41);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 52:11: -> ^( Load )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:52:14: ^( Load )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(Load, "Load")
						, root_1);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 29 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:53:4: 'Store'
					{
					string_literal42=(Token)match(input,83,FOLLOW_83_in_instrucao475);  
					stream_83.add(string_literal42);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 53:12: -> ^( Store )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:53:15: ^( Store )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(Store, "Store")
						, root_1);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 30 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:54:4: 'Decl' STRING valor
					{
					string_literal43=(Token)match(input,59,FOLLOW_59_in_instrucao486);  
					stream_59.add(string_literal43);

					STRING44=(Token)match(input,STRING,FOLLOW_STRING_in_instrucao488);  
					stream_STRING.add(STRING44);

					pushFollow(FOLLOW_valor_in_instrucao490);
					valor45=valor();
					state._fsp--;

					stream_valor.add(valor45.getTree());
					// AST REWRITE
					// elements: STRING, valor
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 54:24: -> ^( Decl STRING valor )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:54:27: ^( Decl STRING valor )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(Decl, "Decl")
						, root_1);

						adaptor.addChild(root_1, 
						stream_STRING.nextNode()
						);

						adaptor.addChild(root_1, stream_valor.nextTree());

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Tree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Tree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "instrucao"


	public static class valor_return extends ParserRuleReturnScope {
		Tree tree;
		public Object getTree() { return tree; }
	};


	// $ANTLR start "valor"
	// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:57:1: valor : ( FLOAT -> ^( F FLOAT ) | INT -> ^( I INT ) | STRING -> ^( S STRING ) | boolean_ -> ^( B boolean_ ) | -> ^( Vazio ) );
	public final mspParser.valor_return valor() throws RecognitionException {
		mspParser.valor_return retval = new mspParser.valor_return();
		retval.start = input.LT(1);

		Tree root_0 = null;

		Token FLOAT46=null;
		Token INT47=null;
		Token STRING48=null;
		ParserRuleReturnScope boolean_49 =null;

		Tree FLOAT46_tree=null;
		Tree INT47_tree=null;
		Tree STRING48_tree=null;
		RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
		RewriteRuleTokenStream stream_FLOAT=new RewriteRuleTokenStream(adaptor,"token FLOAT");
		RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
		RewriteRuleSubtreeStream stream_boolean_=new RewriteRuleSubtreeStream(adaptor,"rule boolean_");

		try {
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:58:2: ( FLOAT -> ^( F FLOAT ) | INT -> ^( I INT ) | STRING -> ^( S STRING ) | boolean_ -> ^( B boolean_ ) | -> ^( Vazio ) )
			int alt3=5;
			switch ( input.LA(1) ) {
			case FLOAT:
				{
				alt3=1;
				}
				break;
			case INT:
				{
				alt3=2;
				}
				break;
			case STRING:
				{
				alt3=3;
				}
				break;
			case 85:
			case 86:
				{
				alt3=4;
				}
				break;
			case EOF:
			case 54:
				{
				alt3=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:58:4: FLOAT
					{
					FLOAT46=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_valor513);  
					stream_FLOAT.add(FLOAT46);

					// AST REWRITE
					// elements: FLOAT
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 58:10: -> ^( F FLOAT )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:58:13: ^( F FLOAT )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(F, "F")
						, root_1);

						adaptor.addChild(root_1, 
						stream_FLOAT.nextNode()
						);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:59:4: INT
					{
					INT47=(Token)match(input,INT,FOLLOW_INT_in_valor526);  
					stream_INT.add(INT47);

					// AST REWRITE
					// elements: INT
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 59:8: -> ^( I INT )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:59:11: ^( I INT )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(I, "I")
						, root_1);

						adaptor.addChild(root_1, 
						stream_INT.nextNode()
						);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:60:4: STRING
					{
					STRING48=(Token)match(input,STRING,FOLLOW_STRING_in_valor539);  
					stream_STRING.add(STRING48);

					// AST REWRITE
					// elements: STRING
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 60:11: -> ^( S STRING )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:60:14: ^( S STRING )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(S, "S")
						, root_1);

						adaptor.addChild(root_1, 
						stream_STRING.nextNode()
						);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:61:4: boolean_
					{
					pushFollow(FOLLOW_boolean__in_valor552);
					boolean_49=boolean_();
					state._fsp--;

					stream_boolean_.add(boolean_49.getTree());
					// AST REWRITE
					// elements: boolean_
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 61:13: -> ^( B boolean_ )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:61:16: ^( B boolean_ )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(B, "B")
						, root_1);

						adaptor.addChild(root_1, stream_boolean_.nextTree());

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 5 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:62:5: 
					{
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 62:5: -> ^( Vazio )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:62:8: ^( Vazio )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(Vazio, "Vazio")
						, root_1);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Tree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Tree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "valor"


	public static class boolean__return extends ParserRuleReturnScope {
		Tree tree;
		public Object getTree() { return tree; }
	};


	// $ANTLR start "boolean_"
	// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:65:1: boolean_ : ( 'true' -> ^( True ) | 'false' -> ^( False ) );
	public final mspParser.boolean__return boolean_() throws RecognitionException {
		mspParser.boolean__return retval = new mspParser.boolean__return();
		retval.start = input.LT(1);

		Tree root_0 = null;

		Token string_literal50=null;
		Token string_literal51=null;

		Tree string_literal50_tree=null;
		Tree string_literal51_tree=null;
		RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
		RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");

		try {
			// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:66:2: ( 'true' -> ^( True ) | 'false' -> ^( False ) )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==86) ) {
				alt4=1;
			}
			else if ( (LA4_0==85) ) {
				alt4=2;
			}
			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:66:4: 'true'
					{
					string_literal50=(Token)match(input,86,FOLLOW_86_in_boolean_582);  
					stream_86.add(string_literal50);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 66:11: -> ^( True )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:66:14: ^( True )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(True, "True")
						, root_1);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:67:4: 'false'
					{
					string_literal51=(Token)match(input,85,FOLLOW_85_in_boolean_593);  
					stream_85.add(string_literal51);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Tree)adaptor.nil();
					// 67:12: -> ^( False )
					{
						// /Users/tac/Dropbox/MEI/ACS/ATS/Fase 3/Entrega/maqv/msp.g:67:15: ^( False )
						{
						Tree root_1 = (Tree)adaptor.nil();
						root_1 = (Tree)adaptor.becomeRoot(
						(Tree)adaptor.create(False, "False")
						, root_1);

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Tree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Tree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "boolean_"

	// Delegated rules



	public static final BitSet FOLLOW_instrucao_in_programa54 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_54_in_programa57 = new BitSet(new long[]{0xFF80000000000000L,0x00000000001FFFFFL});
	public static final BitSet FOLLOW_instrucao_in_programa59 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_EOF_in_programa63 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_55_in_instrucao83 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_STRING_in_instrucao85 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_58_in_instrucao101 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_STRING_in_instrucao103 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_82_in_instrucao118 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_instrucao134 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_84_in_instrucao149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_60_in_instrucao160 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_73_in_instrucao171 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_instrucao182 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_61_in_instrucao193 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_74_in_instrucao204 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_63_in_instrucao215 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_instrucao226 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_71_in_instrucao237 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_instrucao248 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_75_in_instrucao259 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_76_in_instrucao270 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_instrucao281 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_instrucao294 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_instrucao310 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_66_in_instrucao324 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_67_in_instrucao337 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_STRING_in_instrucao339 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_68_in_instrucao354 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_STRING_in_instrucao356 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_81_in_instrucao371 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_STRING_in_instrucao373 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_80_in_instrucao392 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_INT_in_instrucao394 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_78_in_instrucao411 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_CHAR_in_instrucao413 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_79_in_instrucao430 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_FLOAT_in_instrucao432 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_77_in_instrucao449 = new BitSet(new long[]{0x0000000000000000L,0x0000000000600000L});
	public static final BitSet FOLLOW_boolean__in_instrucao451 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_70_in_instrucao464 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_83_in_instrucao475 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_instrucao486 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_STRING_in_instrucao488 = new BitSet(new long[]{0x000A800000000000L,0x0000000000600000L});
	public static final BitSet FOLLOW_valor_in_instrucao490 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_valor513 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_valor526 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_valor539 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_boolean__in_valor552 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_86_in_boolean_582 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_85_in_boolean_593 = new BitSet(new long[]{0x0000000000000002L});
}
