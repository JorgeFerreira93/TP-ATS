grammar i;

options {
  output=AST;
  ASTLabelType=Tree;
  tokenVocab=iTokens;
}

@header { package gram; }
@lexer::header { package gram; }


// definicao de tipos
		
idTipo	:	('char' -> ^(DChar) | 'int' -> ^(DInt) | 'boolean' -> ^(DBoolean) | 'float' -> ^(DFloat) | 'void' -> ^(DVoid) )
		;
	
tipo	:	(INT -> ^(Int INT) | FLOAT -> ^(Float FLOAT) | CHAR -> ^(Char CHAR) | boolean_ -> boolean_)
		;
	
// programa

prog : 
	programa* EOF -> ^(SeqInstrucao programa*)
	;
	
programa :	
	( declaracao ';' -> declaracao
	| funcao -> funcao
	)
	;

declaracao :
	c1=comentarios idTipo c2=comentarios dec_nodo ( c3=comentarios ',' c4=comentarios dec_nodo )* -> ^(Declaracao ^(Comentarios $c1?) idTipo ^(Comentarios $c2?) ^(ListaDecl dec_nodo*) ^(Comentarios $c3?) ^(Comentarios $c4?))
	;

dec_nodo :
	( ID c1=comentarios -> ^(Decl ID ^(Comentarios $c1?) ^(Comentarios) Empty ^(Comentarios) )
	| ID c1=comentarios '=' c2=comentarios condicao c3=comentarios -> ^(Decl ID ^(Comentarios $c1?) ^(Comentarios $c2?) condicao ^(Comentarios $c3?)) 
	)
	;
	
funcao :	
	c1=comentarios idTipo c2=comentarios ID c3=comentarios '(' c4=comentarios argumentos? c5=comentarios ')' c6=comentarios blocoCodigo c7=comentarios -> ^(Funcao ^(Comentarios $c1?) idTipo ^(Comentarios $c2?) ID ^(Comentarios $c3?) ^(Comentarios $c4?) ^(ListaArgumentos argumentos?) ^(Comentarios $c5?) ^(Comentarios $c6?) blocoCodigo ^(Comentarios $c7?))
	;
	
argumentos :
	argumento ( ',' argumento )* -> argumento+
	;

argumento : 
	c1=comentarios idTipo c2=comentarios ID c3=comentarios -> ^(Argumento ^(Comentarios $c1?) idTipo ^(Comentarios $c2?) ID ^(Comentarios $c3?))
	;

// instrucoes
	
instrucao :	
	(if_ -> if_ | for_ -> for_ | while_ -> while_ | return_ ';' -> return_ | call ';' -> ^(Exp call) | print_ ';' -> print_)
	;

if_ 	:
	c1=comentarios 'if' c2=comentarios '(' c3=comentarios condicao c4=comentarios ')' c5=comentarios blocoCodigo ( else_ -> ^(If ^(Comentarios $c1?) ^(Comentarios $c2?) ^(Comentarios $c3?) condicao ^(Comentarios $c4?) ^(Comentarios $c5?) blocoCodigo else_)
																						| -> ^(If ^(Comentarios $c1?) ^(Comentarios $c2?) ^(Comentarios $c3?) condicao ^(Comentarios $c4?) ^(Comentarios $c5?) blocoCodigo ^(SeqInstrucao) )
																						)
	;

else_	:
	'else' ( blocoCodigo -> blocoCodigo | if_ -> if_ )
	;
	
for_	:
	c1=comentarios 'for' c2=comentarios '(' for_declaracao ';' c3=comentarios condicao c4=comentarios ';' c5=comentarios expressao c6=comentarios ')' c7=comentarios blocoCodigo c8=comentarios -> ^(For ^(Comentarios $c1?) ^(Comentarios $c2?) for_declaracao ^(Comentarios $c3?) condicao ^(Comentarios $c4?) ^(Comentarios $c5?) expressao ^(Comentarios $c6?) ^(Comentarios $c7?) blocoCodigo ^(Comentarios $c8?)) 
	;

for_declaracao :
	( declaracao -> declaracao
	| atribuicao -> atribuicao 
	)
	;
	
while_ :	
	c1=comentarios 'while' c2=comentarios '(' c3=comentarios condicao c4=comentarios ')' c5=comentarios blocoCodigo c6=comentarios -> ^(While ^(Comentarios $c1?) ^(Comentarios $c2?) ^(Comentarios $c3?) condicao ^(Comentarios $c4?) ^(Comentarios $c5?) blocoCodigo ^(Comentarios $c6?))
	;
	
return_ 	:	
	c1=comentarios 'return' c2=comentarios expressao c3=comentarios -> ^(Return ^(Comentarios $c1?) ^(Comentarios $c2?) expressao ^(Comentarios $c3?))
	;	
		
call	:
	c1=comentarios ID  c2=comentarios '(' c3=comentarios parametros? c4=comentarios ')' c5=comentarios -> ^(Call ^(Comentarios $c1?) ID ^(Comentarios $c2?) ^(Comentarios $c3?) ^(ListaParametros parametros?) ^(Comentarios $c4?) ^(Comentarios $c5?))
	;

print_	:
	c1=comentarios 'print' c2=comentarios '(' c3=comentarios expressao c4=comentarios ')' c5=comentarios -> ^(Exp ^(Print ^(Comentarios $c1?) ^(Comentarios $c2?) ^(Comentarios $c3?) expressao ^(Comentarios $c4?) ^(Comentarios $c5?)))
	;
	
input_	:
	c1=comentarios 'input' c2=comentarios '(' c3=comentarios idTipo c4=comentarios ')' c5=comentarios -> ^(Input ^(Comentarios $c1?) ^(Comentarios $c2?) ^(Comentarios $c3?) idTipo ^(Comentarios $c4?) ^(Comentarios $c5?))
	;
	
parametros :
	parametro ( ',' parametro)* ->  parametro+
	;

parametro :
	c1=comentarios expressao c2=comentarios -> ^(Parametro ^(Comentarios $c1?) expressao ^(Comentarios $c2?))
	;
	
blocoCodigo :
	'{' codigo* '}' -> ^(SeqInstrucao codigo*)
	;

codigo :
	(	atribuicao ';' -> atribuicao
	|	declaracao ';' -> declaracao
	|	instrucao -> instrucao
	)
	;


// expressao de condicao
	
condicao  :
	condicao_ou ( c1=comentarios '?' c2=comentarios expressao c3=comentarios ':' c4=comentarios condicao -> ^(Condicional condicao_ou ^(Comentarios $c1?) ^(Comentarios $c2?) expressao ^(Comentarios $c3?) ^(Comentarios $c4?) condicao)
				| -> condicao_ou
				)
	;
	
condicao_ou : 
	(condicao_e -> condicao_e) ( c1=comentarios '||' c2=comentarios c=condicao_e -> ^(Ou $condicao_ou ^(Comentarios $c1?) ^(Comentarios $c2?) $c ) )*
	;
	
condicao_e :
	(condicao_comparacao -> condicao_comparacao) ( c1=comentarios '&&' c2=comentarios c=condicao_comparacao -> ^(E $condicao_e ^(Comentarios $c1?) ^(Comentarios $c2?) $c ) )*
	;
	
condicao_comparacao :
	(condicao_igualdade -> condicao_igualdade) 	( c1=comentarios	( '>' c2=comentarios c=condicao_igualdade -> ^(Comp $condicao_comparacao ^(Comentarios $c1?) ^(Maior) ^(Comentarios $c2?) $c )
																	| '<' c2=comentarios c=condicao_igualdade -> ^(Comp $condicao_comparacao ^(Comentarios $c1?) ^(Menor) ^(Comentarios $c2?) $c )
																	| '>=' c2=comentarios c=condicao_igualdade -> ^(Comp $condicao_comparacao ^(Comentarios $c1?) ^(MaiorQ) ^(Comentarios $c2?) $c )
																	| '<=' c2=comentarios c=condicao_igualdade -> ^(Comp $condicao_comparacao ^(Comentarios $c1?) ^(MenorQ) ^(Comentarios $c2?) $c )
																	) 
												)*
	;

condicao_igualdade :
	(expressao -> expressao)	( c1=comentarios	( '!=' c2=comentarios e=expressao -> ^(Comp $condicao_igualdade ^(Comentarios $c1?) ^(Dif) ^(Comentarios $c2?) $e )
													| '==' c2=comentarios e=expressao -> ^(Comp $condicao_igualdade ^(Comentarios $c2?) ^(Igual) ^(Comentarios $c2?) $e )
													) 
								)*
	;
	
// expressao de atribuicao
	
atribuicao :
	c1=comentarios ID c2=comentarios opAtribuicao c3=comentarios condicao c4=comentarios -> ^(Atribuicao ^(Comentarios $c1?) ID ^(Comentarios $c2?) opAtribuicao ^(Comentarios $c3?) condicao ^(Comentarios $c4?))
	;
	
opAtribuicao : 
	( '=' -> ^(Atrib)
	| '*=' -> ^(Mult)
	| '/=' -> ^(Div)
	| '+=' -> ^(Soma)
	| '-=' -> ^(Sub)
	)
	;	
	
// expressao numerica
	
expressao :
	(expressaoNum -> expressaoNum)	( c1=comentarios	( '+' c2=comentarios e=expressaoNum -> ^(ExpNum $expressao ^(Comentarios $c1?) ^(Mais) ^(Comentarios $c2?) $e )
														| '-' c2=comentarios e=expressaoNum -> ^(ExpNum $expressao ^(Comentarios $c1?) ^(Menos) ^(Comentarios $c2?) $e )
														)
									)*
	;

expressaoNum :
	(oper -> oper) ( c1=comentarios	( '*' c2=comentarios o=oper -> ^(ExpNum $expressaoNum ^(Comentarios $c1?) ^(Vezes) ^(Comentarios $c2?) $o )
									| '/' c2=comentarios o=oper -> ^(ExpNum $expressaoNum ^(Comentarios $c1?) ^(Divide) ^(Comentarios $c2?) $o )
									| '%' c2=comentarios o=oper -> ^(ExpNum $expressaoNum ^(Comentarios $c1?) ^(Mod) ^(Comentarios $c2?) $o )
									) 
					)*
	;
	
oper :
	( opUnario ID -> ^(opUnario ^(Id ID))
	| opUnario tipo -> ^(opUnario tipo)
	| tipo -> tipo 
	| ID -> ^(Id ID)
	| incOp ID -> ^(IncAntes incOp ID)
	| ID incOp -> ^(IncDepois incOp ID)
	| call -> call
	| input_ -> input_
	)
	;
	
incOp : 
	( '++' -> ^(Inc) | '--' -> ^(Dec))
	;
	
opUnario :
	( '+' -> ^(Pos)
	| '-' -> ^(Neg)
	| '!' -> ^(Nao)
	)
	;
	
boolean_	:	('true' -> ^(True) | 'false' -> ^(False))
		;
// comentario

comentarios :	
	( comentario* -> comentario*
//	| -> ^(Vazio) 
	)
	;

comentario :
	( COMENTARIO_LINHA -> ^(Comentario COMENTARIO_LINHA)
	| COMENTARIO_LINHAS -> ^(Comentario COMENTARIO_LINHAS)
	)
	;
	    
COMENTARIO_LINHA
	:	'//' ~('\r' | '\n')*
	;
	    
COMENTARIO_LINHAS
	:	'/*' ( options {greedy=false;} : . )* '*/'
	;


// Tokens lex


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
	:	':f'|':F'
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
