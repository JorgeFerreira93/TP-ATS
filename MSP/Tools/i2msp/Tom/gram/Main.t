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
	%include{util/HashMap.tom}
	%include{util/ArrayList.tom}
	%include{util/types/Collection.tom}
	%include{util/types/Set.tom}
	%include{../genI/gram/i/i.tom}

	private String actualFunctionName;
	HashMap<String, Argumentos> functionSignatures;
	private boolean callReturnNeeded;
	private int memAdress;
	StringBuilder functionsDeclarations;
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
				//System.out.println("Funcs: " + counterMap.get("Func") + "\nVars: " + counterMap.get("Var"));

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Main() {
		actualFunctionName = "";
		functionSignatures = new HashMap<String, Argumentos>();
		callReturnNeeded = true;
		functionsDeclarations = new StringBuilder();
		memAdress = 0;
		counter = new ContaTudo();
	}

	private void start(Instrucao p){

		try {
				`TopDown(countFunct()).visit(p);
				//System.out.println("Funcs: " + counterMap.get("Func") + "\nVars: " + counterMap.get("Var"));

			} catch(Exception e) {
				System.out.println("the strategy failed");
			}
	}

    %strategy countFunct()extends Identity(){
		visit Instrucao {
			Funcao(_,tipo,_,nome,_,_,argumentos,_,_,instr,_) -> {

				if(funcao != null){
					counter.addFunc(funcao);
				}

				int nArgs = contaArgumentos(`argumentos);
				
				funcao = new ContaFunc(`nome, nArgs);
				funcao.incLines(1);
			}

			Declaracao(_,_,_,_,_,_) -> {
				funcao.incLines(1);
			}

			Atribuicao(_,_,_,_,_,_,_) -> {
				funcao.incLines(1);
			}
			
			Return(_,_,_,_) -> {
				funcao.incLines(1);
			}

			If(_,_,_,_,_,_,_,_) -> {
				funcao.incLines(3);
			}
			
			While(_,_,_,_,_,_,_,_) -> {
				funcao.incLines(1);
			}
			
			For(_,_,_,_,_,_,_,_,_,_,_,_) -> {
				funcao.incLines(1);
			}

			SeqInstrucao() -> {
				counter.addFunc(funcao);
			}
		}
	}

	private static int contaArgumentos(Argumentos args){
		%match(args){
			ListaArgumentos(arg1, argsTail*) -> {
				return 1 + `contaArgumentos(argsTail*);
			}

			Argumento(_,_,_,_,_) -> {
				return 1;
			}
		}
		return 0;
	}

}

class ContaFunc{

	private String nome;
	private int nLinhas;
	private int nArgs;

	public ContaFunc(String nome, int nArgs){
		this.nome = nome;
		this.nLinhas = 0;
		this.nArgs = nArgs;
	}

	public String getNome(){
		return this.nome;
	}

	public int getLines(){
		return this.nLinhas;
	}

	public int getArgs(){
		return this.nArgs;
	}

	public void incLines(int n){
		this.nLinhas += n;
	}
}

class ContaTudo{

	private int lines;
	private HashMap<String, ContaFunc> funcs;

	public ContaTudo(){
		this.funcs = new HashMap<>();
	}

	public void addFunc(ContaFunc func){
		this.funcs.put(func.getNome(), func);
		this.lines += func.getLines();
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();

		sb.append("Número total de linhas: " + this.lines + "\n");
		sb.append("Número total de funções: " + this.funcs.size() + "\n");

		for(Map.Entry<String, ContaFunc> entry : this.funcs.entrySet()){
			sb.append("----------------------------------------\n");
			sb.append(entry.getKey() + "\n\tNúmero de argumentos: " + entry.getValue().getArgs() + "\n");
			sb.append("\tNúmero de linhas: " + entry.getValue().getLines() + "\n");
		}

		return sb.toString();
	}
}