package gram;
 
import gram.i.iAdaptor;
import gram.i.types.*;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.tree.Tree;
import tom.library.utils.Viewer;
import tom.library.sl.*;
import java.util.*;
import java.lang.*;
import java.io.*;


public class Main {
	%include{sl.tom}
	%include{../genI/gram/i/i.tom}

	static ContaTudo counter;
	static ContaFunc funcao;

	public static void main(String[] args) {
		try {
			iLexer lexer = new iLexer(new ANTLRInputStream(System.in));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			iParser parser = new iParser(tokens);

			Tree b = (Tree) parser.prog().getTree();
			Instrucao p = (Instrucao) iAdaptor.getTerm(b);

			Main main = new Main();

			main.start(p);

			System.out.println(counter.toString());

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Main() {
		counter = new ContaTudo();
	}

	private void start(Instrucao p){

		try {
			`TopDown(countFunct()).visit(p);
		} catch(Exception e) {
			System.out.println("the strategy failed");
		}
	}

    %strategy countFunct()extends Identity(){
		visit Instrucao {
			Funcao(_,tipo,_,nome,_,_,argumentos,_,_,instr,_) -> {

				int nArgs = contaArgumentos(`argumentos);

				for(int i=0; i<nArgs-1; i++){
					counter.adicionaOperador(",");
				}
				
				funcao = new ContaFunc(`nome, nArgs);

				counter.adicionaOperador(`nome);
				counter.adicionaOperador("(");
				counter.adicionaOperador(")");
				counter.adicionaOperador("{");
				counter.adicionaOperador("}");
				counter.addFunc(funcao);

				funcao.incLines(1);
			}

			Declaracao(_,_,_,decls,_,_) -> {

				resolveDecls(`decls);

				funcao.incLines(1);
				counter.adicionaOperador(";");
			}

			Atribuicao(_,_,_,op,_,_,_) -> {

				if(`op == `Atrib()){
					counter.adicionaOperador("=");
				}
				else if(`op == `Mult()){
					counter.adicionaOperador("*=");
				}
				else if(`op == `Div()){
					counter.adicionaOperador("/=");
				}
				else if(`op == `Soma()){
					counter.adicionaOperador("+=");
				}
				else{
					counter.adicionaOperador("-=");
				}

				funcao.incLines(1);
				counter.adicionaOperador(";");
			}
			
			Return(_,_,_,_) -> {
				funcao.incLines(1);
				counter.adicionaOperador(";");
				counter.adicionaOperador("Return");
			}

			If(_,_,_,_,_,_,_,e) -> {
				funcao.incLines(3);
				funcao.incIfs();

				if(`e != `SeqInstrucao()){
					counter.adicionaOperador("Else");
				}

				counter.adicionaOperador("If");
				counter.adicionaOperador(")");
				counter.adicionaOperador("(");
			}
			
			While(_,_,_,_,_,_,_,_) -> {
				funcao.incLines(1);
				funcao.incWhiles();
				counter.adicionaOperador("While");
				counter.adicionaOperador(")");
				counter.adicionaOperador("(");
			}
			
			For(_,_,_,_,_,_,_,_,_,_,_,_) -> {
				funcao.incLines(1);
				funcao.incFors();
				counter.adicionaOperador("For");
				counter.adicionaOperador(")");
				counter.adicionaOperador("(");
			}
		}

		visit Expressao{
			Id(id) -> {
				counter.adicionaOperando(`id);
			}

			Call(_,id,_,_,_,_,_) -> {
				funcao.incLines(1);
				counter.adicionaOperador(";");
				counter.adicionaOperador(`id);
			}

			Input(_,_,_,_,_,_) -> {
				funcao.incLines(1);
				counter.adicionaOperador(";");
			}

			Print(_,_,_,_,_,_) -> {
				funcao.incLines(1);
				counter.adicionaOperador(";");
			}

			Int(i) -> {
				counter.adicionaOperando(Integer.toString(`i));
			}

			Char(c) -> {
				counter.adicionaOperando(`c);
			}

			True()  -> {
				counter.adicionaOperando("True");
			}

			False() -> {
				counter.adicionaOperando("False");
			}

			Float(f) -> {
				counter.adicionaOperando(Float.toString(`f));
			}
		}

		visit LComentarios{
			Comentario(_) -> {
				funcao.incComentarios();
			}
		}

		visit DefTipo{

			DInt() -> {

				counter.adicionaOperador("Int");
			}

			DChar() -> {
				counter.adicionaOperador("Char");
			}

			DBoolean() -> {
				counter.adicionaOperador("Boolean");
			}

			DFloat() -> {
				counter.adicionaOperador("Float");
			}

			DVoid() -> {
				counter.adicionaOperador("Void");
			}
		}
	}

	private static int contaArgumentos(Argumentos args){
		%match(args){
			ListaArgumentos(arg1, argsTail*) -> {
				return `contaArgumentos(arg1) + `contaArgumentos(argsTail*);
			}

			Argumento(_,_,_,id,_) -> {

				counter.adicionaOperando(`id);

				return 1;
			}
		}
		return 0;
	}

	private static void resolveDecls(Declaracoes decls){
		%match(decls){
			Decl(id,_,_,exp,_) -> {
				counter.adicionaOperando(`id);

				if(`exp != `Empty()){
					counter.adicionaOperador("=");
				}

				`resolveExpr(exp);
			}
			ListaDecl(decl1, decl*) -> {
				resolveDecls(`decl1);
				resolveDecls(`decl);
			}
		}
	}

	private static void resolveExpr(Expressao exp){
		%match(exp){
			Id(id) -> {
				counter.adicionaOperando(`id);
			}

			Input(_,_,_,_,_,_) -> {
				counter.adicionaOperador("Input");
			}
			
			Print(_,_,_,Expressao:Expressao,_,_) -> {
				counter.adicionaOperador("Print");
			}
		}
	}

}

class ContaFunc{

	private String nome;
	private int nLinhas, nArgs, nIfs, nWhiles, nFors, nComentarios;	

	public ContaFunc(String nome, int nArgs){
		this.nome = nome;
		this.nLinhas = 0;
		this.nArgs = nArgs;
		this.nIfs = 0;
		this.nWhiles = 0;
		this.nFors = 0;
		this.nComentarios = 0;
	}

	public String getNome(){
		return this.nome;
	}

	public int getLines(){
		return this.nLinhas;
	}

	public void incLines(int n){
		this.nLinhas += n;
	}

	public void incIfs(){
		this.nIfs++;
	}

	public void incWhiles(){
		this.nWhiles++;
	}

	public void incFors(){
		this.nFors++;
	}

	public void incComentarios(){
		this.nComentarios++;
	}

	public String toString(){

		StringBuilder sb = new StringBuilder();

		sb.append("----------------------------------------\n");
		sb.append(this.nome + "\n\tNúmero de argumentos: " + this.nArgs + "\n");
		sb.append("\tNúmero de linhas: " + this.nLinhas + "\n");
		sb.append("\tNúmero de ifs: " + this.nIfs + "\n");
		sb.append("\tNúmero de whiles: " + this.nWhiles + "\n");
		sb.append("\tNúmero de fors: " + this.nFors + "\n");
		sb.append("\tNúmero de comentários: " + this.nComentarios + "\n");

		return sb.toString();
	}
}

class ContaTudo{

	private int lines;
	private HashMap<String, ContaFunc> funcs;
	private HashMap<String, Integer> operandos, operadores;

	public ContaTudo(){
		this.funcs = new HashMap<>();
		operandos = new HashMap<>();
		operadores = new HashMap<>();
	}

	public void addFunc(ContaFunc func){
		this.funcs.put(func.getNome(), func);
	}

	public int totLinhas(){
		int res = 0;

		for(Map.Entry<String, ContaFunc> entry : this.funcs.entrySet()){
			res += entry.getValue().getLines();
		}

		return res;
	}

	public void adicionaOperando(String op){
		if(this.operandos.containsKey(op)){
			int n = this.operandos.get(op);
			this.operandos.put(op, n+1);
		}
		else{
			this.operandos.put(op, 1);
		}
	}

	public void adicionaOperador(String op){
		if(this.operadores.containsKey(op)){
			int n = this.operadores.get(op);
			this.operadores.put(op, n+1);
		}
		else{
			this.operadores.put(op, 1);
		}
	}
	public int operadoresDist(){
		return this.operadores.keyset().size();
	}
	
	public int operandosDist(){
		return this.operandos.keyset().size();
	}
	
	public int operadoresTotais(){
		int sum=0;
		for(Integer i:this.operadores.values())
			sum+=i;
		return i;
	}
	
	public int operandosTotais(){
		int sum=0;
		for(Integer i:this.operandos.values())
			sum+=i;
		return i;
	}
	public int vocabulario(){
		return this.operandosDist()+this.operadoresDist();
	}
	public int comprimento(){
		return this.operadoresTotais()+this.operandosTotais();
	}
	public float comprimentoCalculado(){
		int n1=this.operadoresDist();
		int n2=this.operandosDist();
		return (n1*Math.log(n1)/Math.log(2)) + (n2* Math.log(n2)/Math.log(2));
	}
	public float volume(){
		return this.comprimento() * (Math.log(this.vocabulario())/Math.log(2));
	}
	public float dificuldade(){
		int n1=this.operadoresDist();
		int N2=this.operandosTotais();
		int n2=this.operandosDist();
		return (n1/2) * (N2/n2);
	}
	public float esforco(){
		return this.volume()*this.dificuldade();
	}
	public float tempoNecessario(){
		return this.esforco()/18;
	}
	public float estimateBugs(){
		return this.volume()/3000;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();

		sb.append("Número total de linhas: " + this.totLinhas() + "\n");
		sb.append("Número total de funções: " + this.funcs.size() + "\n");

		for(Map.Entry<String, ContaFunc> entry : this.funcs.entrySet()){
			sb.append(entry.getValue().toString());
		}

		sb.append("----OPERADORES-----\n");
		sb.append(this.operadores.toString());
		sb.append("\n----OPERANDOS-----\n");
		sb.append(this.operandos.toString());

		return sb.toString();
	}
}
