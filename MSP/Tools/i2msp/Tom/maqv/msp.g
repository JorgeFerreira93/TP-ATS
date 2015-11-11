grammar msp;


options {
  output=AST;
  ASTLabelType=Tree;
  tokenVocab=mspTokens;
}

@header { package maqv; }
@lexer::header { package maqv; }


programa : 
	instrucao (',' instrucao)* EOF -> ^(Instrucoes instrucao+)
	;

instrucao
	:	'ALabel' STRING	-> ^(ALabel STRING)	//label
	//
	|	'Call' STRING -> ^(Call STRING)		//call function
	|	'Ret' -> ^(Ret)			//return function
	//
	|	'Add' -> ^(Add)			//arithmetic and boolean instructions
	| 	'Sub' -> ^(Sub)
	|	'Div' -> ^(Div)
	|	'Mul' -> ^(Mul)
	|	'Mod' -> ^(Mod)
	|	'Inc' -> ^(Inc)
	|	'Dec' -> ^(Dec)
	|	'Eq' -> ^(Eq)
	|	'Neq' -> ^(Neq)
	|	'Gt' -> ^(Gt)
	|	'GoEq' -> ^(GoEq)
	|	'Lt' -> ^(Lt)
	|	'LoEq' -> ^(LoEq)
	|	'Not' -> ^(Nott)
	|	'Or' -> ^(Or)
	|	'And' -> ^(And)
	//
	|	'Halt' -> ^(Halt)			//Halt the machine
	//
	|	'IIn' idTipo -> ^(IIn idTipo)			//IO
	|	'IOut' -> ^(IOut)
	//				
	|	'Jump' STRING -> ^(Jump STRING)		//Jump Instructions
	|	'Jumpf' STRING -> ^(Jumpf STRING)
	//
	|	'Pusha' STRING -> ^(Pusha ^(S STRING))		//Stack Operations
	|	'Pushi' INT -> ^(Push ^(I INT))
	|	'Pushc' CHAR -> ^(Push ^(S CHAR))
	|	'Pushf' FLOAT -> ^(Push ^(F FLOAT))
	|	'Pushb' boolean_ -> ^(Push boolean_)
	|	'Load' -> ^(Load)
	|	'Store' -> ^(Store)
	|	'Decl' STRING INT INT -> ^(Decl STRING INT INT )
	;
	
/*
valor
	:	FLOAT -> ^(F FLOAT)
	|	INT -> ^(I INT)
	|	STRING ->	^(S STRING)
	|	boolean_ -> ^(B boolean_)
	|	 -> ^(Vazio)
	;
*/

boolean_
	:	'true' -> ^(True)
	|	'false' -> ^(False)
	;
	
idTipo	:	('char' -> ^(DChar) | 'int' -> ^(DInt) | 'boolean' -> ^(DBoolean) | 'float' -> ^(DFloat) )
		;

// Tokens lex

STRING
@after
{
    setText(getText().substring(1, getText().length()-1));
}
	:	'\"' ~('"')* '\"'
	;
	
CHAR
@after
{
    setText(getText().substring(1, getText().length()-1));
} 	
	:	'\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\''|'\\') ) '\''
	;

fragment DIGITO
 	:	('0'..'9')+
	;

FLOAT 	
	:	DIGITO+ '.' DIGITO* SufixoFloat?
	|	'.' DIGITO+ SufixoFloat?
	|	INT SufixoFloat
	;
	
SufixoFloat 
	:	'f'|'F'
	;
	
INT	
	:	('0' | '1'..'9' DIGITO*)
	;
	
ID 	:	LETRA ( LETRA | '0'..'9' )*
	;
	
fragment LETRA	
	:	'a'..'z' | 'A'..'Z' | '_'
	;
	
WS  :  (' '|'\r'|'\t'|'\u000C'|'\n') {$channel=HIDDEN;}
    ;
