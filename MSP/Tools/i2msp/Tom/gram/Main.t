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

	private static ArrayList<Programa> bonsProgramas = new ArrayList<>();
	private static Programa programa;

	public static void main(String[] args) {

		File folder = new File("../exemplos/");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {

			Programa p = new Programa(listOfFiles[i].getPath());
			
			bonsProgramas.add(p);
		}

		lerPrograma();

		String[] ops = {"Detalhes do programa",
						"Complexidade McCabe",
						"Complexidade Halstead"};

		Menu menuMain = new Menu(ops);

		do {
            menuMain.executa();
            switch (menuMain.getOpcao()) {
                case 1: detalhes();
                        break;
                case 2: complexidade(0);
                        break;
                case 3: complexidade(1);
                        break;
            }
        } while (menuMain.getOpcao()!=0);

	}

	private static void lerPrograma(){
		Scanner is = new Scanner(System.in);
        
        System.out.print("Nome Ficheiro: ");
        String op = is.nextLine();

        programa = new Programa(op);
	}

	private static void detalhes(){

		ArrayList<String> aux = programa.getArrayFuncs();

		String[] listaFunc = aux.toArray(new String[aux.size()]);

		Menu menuMain = new Menu(listaFunc);

		do {
            menuMain.executa();

            if(menuMain.getOpcao()-1 < aux.size() && menuMain.getOpcao()-1 >= 0){

            	Funcao auxFunc = programa.getFuncao(listaFunc[menuMain.getOpcao()-1]);

				if(auxFunc.getLines() > mediaLinhasProgramas()){
					System.out.println("Smell: Função com linhas a mais!");
				}

				if(auxFunc.getNArgs() > mediaArgsProgramas()){
					System.out.println("Smell: Função com argumentos a mais!");
				}

				if(auxFunc.isNao()){
					System.out.println("Smell: Negação da Condição!");
				}
            	
            	System.out.println(auxFunc.toString());
            }

        } while (menuMain.getOpcao()!=0);
	}

	private static void complexidade(int tipo){

		ArrayList<String> aux = programa.getArrayFuncs();

		String[] listaFunc = aux.toArray(new String[aux.size()]);

		Menu menuMain = new Menu(listaFunc);

		do {
            menuMain.executa();

            if(menuMain.getOpcao()-1 < aux.size() && menuMain.getOpcao()-1 >= 0){
            	if(tipo == 0){
            		System.out.println(programa.getFuncao(listaFunc[menuMain.getOpcao()-1]).complexidadeMcCabe());
            	}
            	else{
            		System.out.println(programa.getFuncao(listaFunc[menuMain.getOpcao()-1]).metricasHalstead());
            	}
            }

        } while (menuMain.getOpcao()!=0);
	}

	private static float mediaLinhasProgramas(){
		int soma = 0;
		int tot = 0;

		for(Programa p: bonsProgramas){
			for(Map.Entry<String, Funcao> entry: p.getFuncs().entrySet()){
				soma += entry.getValue().getLines();
				tot++;
			}
		}

		return soma/tot;
	}

	private static float mediaArgsProgramas(){
		int soma = 0;
		int tot = 0;

		for(Programa p: bonsProgramas){
			for(Map.Entry<String, Funcao> entry: p.getFuncs().entrySet()){
				soma += entry.getValue().getNArgs();
				tot++;
			}
		}

		return (float)soma/tot;
	}
}

class Funcao{

	private String nome;
	private int nLinhas, nArgs, nIfs, nWhiles, nFors, nComentarios;	
	private int mcCabe;
	private HashMap<String, Integer> operandos, operadores;
	private boolean naoSmell;

	public Funcao(String nome, int nArgs){
		this.nome = nome;
		this.nLinhas = 0;
		this.nArgs = nArgs;
		this.nIfs = 0;
		this.nWhiles = 0;
		this.nFors = 0;
		this.nComentarios = 0;
		this.mcCabe = 1;
		operandos = new HashMap<>();
		operadores = new HashMap<>();
		this.naoSmell = false;
	}

	public String getNome(){
		return this.nome;
	}

	public int getLines(){
		return this.nLinhas;
	}

	public int getNArgs(){
		return this.nArgs;
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
	public void adicionaOperando(String op){
		if(operandos.containsKey(op)){
			int n = operandos.get(op);
			operandos.put(op, n+1);
		}
		else{
			operandos.put(op, 1);
		}
	}

	public void adicionaOperador(String op){
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

	public void addNao(){
		this.naoSmell = true;
	}

	public boolean isNao(){
		return this.naoSmell;
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

	public void incMcCabe(){
		mcCabe++;
	}

	public String metricasHalstead(){
		StringBuilder sb = new StringBuilder();

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

		return sb.toString();
	}

	public String complexidadeMcCabe(){
		StringBuilder sb = new StringBuilder();

		sb.append("\n-------Complexidade Ciclomática-------\n");
		sb.append(this.mcCabe);
		return sb.toString();
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
	private static HashMap<String, Funcao> funcs;
	private static Funcao auxFunc;

	public Programa(String path){
		this.funcs = new HashMap<>();

		this.parser(path);
	}

	public int totLinhas(){
		int res = 0;

		for(Map.Entry<String, Funcao> entry : this.funcs.entrySet()){
			res += entry.getValue().getLines();
		}

		return res;
	}

	public HashMap<String, Funcao> getFuncs(){
		return this.funcs;
	}

	public ArrayList<String> getArrayFuncs(){
		ArrayList<String> res = new ArrayList<>();

		for(Map.Entry<String, Funcao> e: funcs.entrySet()){
			res.add(e.getKey());
		}

		return res;
	}

	public Funcao getFuncao(String nome){
		return funcs.get(nome);
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

		return sb.toString();
	}

	%strategy countFunct() extends Identity(){
		visit Instrucao {
			Funcao(_,tipo,_,nome,_,_,argumentos,_,_,instr,_) -> {

				int nArgs = contaArgumentos(`argumentos);
				
				auxFunc = new Funcao(`nome, nArgs);

				for(int i=0; i<nArgs-1; i++){
					auxFunc.adicionaOperador(",");
				}

				auxFunc.adicionaOperador(`nome);
				auxFunc.adicionaOperador("(");
				auxFunc.adicionaOperador(")");
				auxFunc.adicionaOperador("{");
				auxFunc.adicionaOperador("}");

				funcs.put(auxFunc.getNome(), auxFunc);

				auxFunc.incLines(1);
			}

			Declaracao(_,_,_,decls,_,_) -> {

				resolveDecls(`decls);

				auxFunc.incLines(1);
				auxFunc.adicionaOperador(";");
			}

			Atribuicao(_,_,_,op,_,_,_) -> {

				if(`op == `Atrib()){
					auxFunc.adicionaOperador("=");
				}
				else if(`op == `Mult()){
					auxFunc.adicionaOperador("*=");
				}
				else if(`op == `Div()){
					auxFunc.adicionaOperador("/=");
				}
				else if(`op == `Soma()){
					auxFunc.adicionaOperador("+=");
				}
				else{
					auxFunc.adicionaOperador("-=");
				}

				auxFunc.incLines(1);
				auxFunc.adicionaOperador(";");
			}
			
			Return(_,_,_,_) -> {
				auxFunc.incLines(1);
				auxFunc.adicionaOperador(";");
				auxFunc.adicionaOperador("Return");
			}

			If(_,_,_,_,_,_,_,e) -> {
				auxFunc.incLines(3);
				auxFunc.incIfs();

				if(`e != `SeqInstrucao()){
					auxFunc.adicionaOperador("Else");
				}

				auxFunc.adicionaOperador("If");
				auxFunc.adicionaOperador(")");
				auxFunc.adicionaOperador("(");

				auxFunc.incMcCabe();
			}
			
			While(_,_,_,_,_,_,_,_) -> {
				auxFunc.incLines(1);
				auxFunc.incWhiles();
				auxFunc.adicionaOperador("While");
				auxFunc.adicionaOperador(")");
				auxFunc.adicionaOperador("(");

				auxFunc.incMcCabe();
			}
			
			For(_,_,_,_,_,_,_,_,_,_,_,_) -> {
				auxFunc.incLines(1);
				auxFunc.incFors();
				auxFunc.adicionaOperador("For");
				auxFunc.adicionaOperador(")");
				auxFunc.adicionaOperador("(");

				auxFunc.incMcCabe();
			}
		}

		visit Expressao{
			Id(id) -> {
				auxFunc.adicionaOperando(`id);
			}

			Call(_,id,_,_,_,_,_) -> {
				auxFunc.incLines(1);
				auxFunc.adicionaOperador(";");
				auxFunc.adicionaOperador(`id);
			}

			Input(_,_,_,_,_,_) -> {
				auxFunc.incLines(1);
				auxFunc.adicionaOperador(";");
			}

			Print(_,_,_,_,_,_) -> {
				auxFunc.incLines(1);
				auxFunc.adicionaOperador(";");
			}

			Int(i) -> {
				auxFunc.adicionaOperando(Integer.toString(`i));
			}

			Char(c) -> {
				auxFunc.adicionaOperando(`c);
			}

			True()  -> {
				auxFunc.adicionaOperando("True");
			}

			False() -> {
				auxFunc.adicionaOperando("False");
			}

			Float(f) -> {
				auxFunc.adicionaOperando(Float.toString(`f));
			}

			Nao(_) -> {
				auxFunc.adicionaOperador("!");
				auxFunc.addNao();
			}

			Ou(_,_,_,_) -> {
				auxFunc.adicionaOperador("||");
				auxFunc.incMcCabe();
			}

			E(_,_,_,_) -> {
				auxFunc.adicionaOperador("&&");
				auxFunc.incMcCabe();
			}
		}

		visit LComentarios{
			Comentario(_) -> {
				auxFunc.incComentarios();
			}
		}

		visit DefTipo{

			DInt() -> {
				auxFunc.adicionaOperador("Int");
			}

			DChar() -> {
				auxFunc.adicionaOperador("Char");
			}

			DBoolean() -> {
				auxFunc.adicionaOperador("Boolean");
			}

			DFloat() -> {
				auxFunc.adicionaOperador("Float");
			}

			DVoid() -> {
				auxFunc.adicionaOperador("Void");
			}
		}
	}

	private static int contaArgumentos(Argumentos args){
		%match(args){
			ListaArgumentos(arg1, argsTail*) -> {
				return `contaArgumentos(arg1) + `contaArgumentos(argsTail*);
			}

			Argumento(_,_,_,id,_) -> {

				auxFunc.adicionaOperando(`id);

				return 1;
			}
		}
		return 0;
	}

	private static void resolveDecls(Declaracoes decls){
		%match(decls){
			Decl(id,_,_,exp,_) -> {
				auxFunc.adicionaOperando(`id);

				if(`exp != `Empty()){
					auxFunc.adicionaOperador("=");
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
				auxFunc.adicionaOperando(`id);
			}

			Input(_,_,_,_,_,_) -> {
				auxFunc.adicionaOperador("Input");
			}
			
			Print(_,_,_,Expressao:Expressao,_,_) -> {
				auxFunc.adicionaOperador("Print");
			}
		}
	}
}


/**
 * Esta classe implementa um menu em modo texto.
 * 
 * @author José Creissac Campos 
 * @version v1.0
 */
class Menu {
    // variáveis de instância
    private List<String> opcoes;
    private int op;
    
    /**
     * Constructor for objects of class Menu
     */
    public Menu(String[] opcoes) {
        this.opcoes = new ArrayList<String>();
        for (String op : opcoes) //(int i=0; i<opcoes.length; i++)
            this.opcoes.add(op);
        this.op = 0;
    }

    /**
     * M�todo para apresentar o menu e ler uma op��o.
     * 
     */
    public void executa() {
        do {
            showMenu();
            this.op = lerOpcao();
        } while (this.op == -1);
    }
    
    /** Apresentar o menu */
    private void showMenu() {
        System.out.println("\n *** Menu *** ");
        for (int i=0; i<this.opcoes.size(); i++) {
            System.out.print(i+1);
            System.out.print(" - ");
            System.out.println(this.opcoes.get(i));
        }
        System.out.println("0 - Sair");
    }
    
    /** Ler uma op��o v�lida */
    private int lerOpcao() {
        int op; 
        Scanner is = new Scanner(System.in);
        
        System.out.print("Opção: ");
        op = is.nextInt();
        if (op<0 || op>this.opcoes.size()) {
            System.out.println("Opção Inválida!!!");
            op = -1;
        }
        return op;
    }
    
    /**
     * M�todo para obter a op��o lida
     */
    public int getOpcao() {
        return this.op;
    }
}
