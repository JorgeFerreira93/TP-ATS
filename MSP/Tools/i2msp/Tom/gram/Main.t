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

	public static void main(String[] args) {
		Main main = new Main();

		String path1 = "../exemplos/maiorDeDoisNumeros.i";
		String path2 = "../exemplos/fatorial.i";

		Programa p1 = new Programa(path1);
		Programa p2 = new Programa(path2);
	}

	public Main() {
		//counter = new ContaTudo();
	}
}

class Funcao{

	private String nome;
	private int nLinhas, nArgs, nIfs, nWhiles, nFors, nComentarios;	

	public Funcao(String nome, int nArgs){
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

class Programa{

	%include{sl.tom}
	%include{../genI/gram/i/i.tom}

	private int lines;
	private static int mcCabe;
	private static HashMap<String, Funcao> funcs;
	private static HashMap<String, Integer> operandos, operadores;
	 static Funcao auxFunc;

	public Programa(String path){
		this.mcCabe = 1;
		this.funcs = new HashMap<>();
		operandos = new HashMap<>();
		operadores = new HashMap<>();

		this.parser(path);
	}

	public int totLinhas(){
		int res = 0;

		for(Map.Entry<String, Funcao> entry : this.funcs.entrySet()){
			res += entry.getValue().getLines();
		}

		return res;
	}

	public static void adicionaOperando(String op){
		if(operandos.containsKey(op)){
			int n = operandos.get(op);
			operandos.put(op, n+1);
		}
		else{
			operandos.put(op, 1);
		}
	}

	public static void adicionaOperador(String op){
		if(operadores.containsKey(op)){
			int n = operadores.get(op);
			operadores.put(op, n+1);
		}
		else{
			operadores.put(op, 1);
		}
	}
	public int operadoresDist(){
		return this.operadores.keySet().size();
	}
	
	public int operandosDist(){
		return this.operandos.keySet().size();
	}
	
	public int operadoresTotais(){
		int sum=0;
		for(Integer i: this.operadores.values())
			sum+=i;
		return sum;
	}
	
	public int operandosTotais(){
		int sum=0;
		for(Integer i: this.operandos.values())
			sum+=i;
		return sum;
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
		return (float)((n1*Math.log(n1)/Math.log(2)) + (n2* Math.log(n2)/Math.log(2)));
	}
	public float volume(){
		return (float)(this.comprimento() * (Math.log(this.vocabulario())/Math.log(2)));
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

	public static void incMcCabe(){
		mcCabe++;
	}

	private void parser(String path){
		try {
			
			File f = new File(path);
			iLexer lexer = new iLexer(new ANTLRInputStream(new FileInputStream(f)));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			iParser parser = new iParser(tokens);

			Tree b = (Tree) parser.prog().getTree();
			Instrucao p = (Instrucao) iAdaptor.getTerm(b);

			start(p);

			System.out.println(this.toString());

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void start(Instrucao p){

		try {
			`TopDown(countFunct()).visit(p);
		} catch(Exception e) {
			System.out.println("the strategy failed");
		}
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();

		sb.append("Número total de linhas: " + this.totLinhas() + "\n");
		sb.append("Número total de funções: " + this.funcs.size() + "\n");

		for(Map.Entry<String, Funcao> entry : this.funcs.entrySet()){
			sb.append(entry.getValue().toString());
		}

		sb.append("-------Métricas Halstead-------\n");
		sb.append("Operadores distintos: ");
		sb.append(this.operadoresDist());
		sb.append("\nOperandos distintos: ");
		sb.append(this.operandosDist());
		sb.append("\nTotal de operadores: ");
		sb.append(this.operadoresTotais());
		sb.append("\nTotal de operandos: ");
		sb.append(this.operandosTotais());
		sb.append("\nVocabulário: ");
		sb.append(this.vocabulario());
		sb.append("\nComprimento: ");
		sb.append(this.comprimento());
		sb.append("\nVolume: ");
		sb.append(this.volume());
		sb.append("\nDificuldade: ");
		sb.append(this.dificuldade());
		sb.append("\nEsforço: ");
		sb.append(this.esforco());
		sb.append("\nTempo Necessário: ");
		sb.append(this.tempoNecessario());
		sb.append("s\nNº estimado de Bugs: ");
		sb.append(this.estimateBugs());

		sb.append("\n-------Complexidade Ciclomática-------\n");
		sb.append(this.mcCabe);
		return sb.toString();
	}

	%strategy countFunct() extends Identity(){
		visit Instrucao {
			Funcao(_,tipo,_,nome,_,_,argumentos,_,_,instr,_) -> {

				int nArgs = contaArgumentos(`argumentos);

				for(int i=0; i<nArgs-1; i++){
					adicionaOperador(",");
				}
				
				auxFunc = new Funcao(`nome, nArgs);

				adicionaOperador(`nome);
				adicionaOperador("(");
				adicionaOperador(")");
				adicionaOperador("{");
				adicionaOperador("}");

				funcs.put(auxFunc.getNome(), auxFunc);

				auxFunc.incLines(1);
			}

			Declaracao(_,_,_,decls,_,_) -> {

				resolveDecls(`decls);

				auxFunc.incLines(1);
				adicionaOperador(";");
			}

			Atribuicao(_,_,_,op,_,_,_) -> {

				if(`op == `Atrib()){
					adicionaOperador("=");
				}
				else if(`op == `Mult()){
					adicionaOperador("*=");
				}
				else if(`op == `Div()){
					adicionaOperador("/=");
				}
				else if(`op == `Soma()){
					adicionaOperador("+=");
				}
				else{
					adicionaOperador("-=");
				}

				auxFunc.incLines(1);
				adicionaOperador(";");
			}
			
			Return(_,_,_,_) -> {
				auxFunc.incLines(1);
				adicionaOperador(";");
				adicionaOperador("Return");
			}

			If(_,_,_,_,_,_,_,e) -> {
				auxFunc.incLines(3);
				auxFunc.incIfs();

				if(`e != `SeqInstrucao()){
					adicionaOperador("Else");
				}

				adicionaOperador("If");
				adicionaOperador(")");
				adicionaOperador("(");

				incMcCabe();
			}
			
			While(_,_,_,_,_,_,_,_) -> {
				auxFunc.incLines(1);
				auxFunc.incWhiles();
				adicionaOperador("While");
				adicionaOperador(")");
				adicionaOperador("(");

				incMcCabe();
			}
			
			For(_,_,_,_,_,_,_,_,_,_,_,_) -> {
				auxFunc.incLines(1);
				auxFunc.incFors();
				adicionaOperador("For");
				adicionaOperador(")");
				adicionaOperador("(");

				incMcCabe();
			}
		}

		visit Expressao{
			Id(id) -> {
				adicionaOperando(`id);
			}

			Call(_,id,_,_,_,_,_) -> {
				auxFunc.incLines(1);
				adicionaOperador(";");
				adicionaOperador(`id);
			}

			Input(_,_,_,_,_,_) -> {
				auxFunc.incLines(1);
				adicionaOperador(";");
			}

			Print(_,_,_,_,_,_) -> {
				auxFunc.incLines(1);
				adicionaOperador(";");
			}

			Int(i) -> {
				adicionaOperando(Integer.toString(`i));
			}

			Char(c) -> {
				adicionaOperando(`c);
			}

			True()  -> {
				adicionaOperando("True");
			}

			False() -> {
				adicionaOperando("False");
			}

			Float(f) -> {
				adicionaOperando(Float.toString(`f));
			}
		}

		visit LComentarios{
			Comentario(_) -> {
				auxFunc.incComentarios();
			}
		}

		visit DefTipo{

			DInt() -> {
				adicionaOperador("Int");
			}

			DChar() -> {
				adicionaOperador("Char");
			}

			DBoolean() -> {
				adicionaOperador("Boolean");
			}

			DFloat() -> {
				adicionaOperador("Float");
			}

			DVoid() -> {
				adicionaOperador("Void");
			}
		}
	}

	private static int contaArgumentos(Argumentos args){
		%match(args){
			ListaArgumentos(arg1, argsTail*) -> {
				return `contaArgumentos(arg1) + `contaArgumentos(argsTail*);
			}

			Argumento(_,_,_,id,_) -> {

				adicionaOperando(`id);

				return 1;
			}
		}
		return 0;
	}

	private static void resolveDecls(Declaracoes decls){
		%match(decls){
			Decl(id,_,_,exp,_) -> {
				adicionaOperando(`id);

				if(`exp != `Empty()){
					adicionaOperador("=");
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
				adicionaOperando(`id);
			}

			Input(_,_,_,_,_,_) -> {
				adicionaOperador("Input");
			}
			
			Print(_,_,_,Expressao:Expressao,_,_) -> {
				adicionaOperador("Print");
			}
		}
	}
}