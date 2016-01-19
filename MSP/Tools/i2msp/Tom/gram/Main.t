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
import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;


public class Main {

	private static ArrayList<Programa> bonsProgramas = new ArrayList<>();
	private static Programa Programa;

	public static void main(String[] args) {

		File folder = new File("../exemplos2/");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {

			Programa p = new Programa(listOfFiles[i].getPath());
			
			bonsProgramas.add(p);
		}

		lerPrograma();
                new WindowGUI(bonsProgramas,Programa).setVisible(true);
		String[] ops = {"Detalhes do Programa",
						"Complexidade McCabe",
						"Complexidade Halstead",
						"Valores de referência"};

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
                case 4: referencia();
                        break;
            }
        } while (menuMain.getOpcao()!=0);

	}

	private static void lerPrograma(){
		Scanner is = new Scanner(System.in);
        
        System.out.print("Nome Ficheiro: ");
        String op = is.nextLine();

        Programa = new Programa(op);
	}

	private static void detalhes(){

		ArrayList<String> aux = Programa.getArrayFuncs();

		String[] listaFunc = aux.toArray(new String[aux.size()]);

		Menu menuMain = new Menu(listaFunc);

		do {
            menuMain.executa();

            if(menuMain.getOpcao()-1 < aux.size() && menuMain.getOpcao()-1 >= 0){

            	Funcao auxFunc = Programa.getFuncao(listaFunc[menuMain.getOpcao()-1]);

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

		ArrayList<String> aux = Programa.getArrayFuncs();

		String[] listaFunc = aux.toArray(new String[aux.size()]);

		Menu menuMain = new Menu(listaFunc);

		do {
            menuMain.executa();

            if(menuMain.getOpcao()-1 < aux.size() && menuMain.getOpcao()-1 >= 0){
            	if(tipo == 0){
            		System.out.println(Programa.getFuncao(listaFunc[menuMain.getOpcao()-1]).complexidadeMcCabe());
            	}
            	else{
            		System.out.println(Programa.getFuncao(listaFunc[menuMain.getOpcao()-1]).metricasHalstead());
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

	private static void referencia(){
		System.out.println("Média de argumentos por função: " + mediaArgsProgramas());
		System.out.println("Média de linhas por função: " + mediaLinhasProgramas());
	}
}

class Funcao{

	private String nome;
	private int nLinhas, nArgs, nIfs, nWhiles, nFors, nComentarios;	
	private int mcCabe;
        private HashMap<String, Integer> localVars;
	private HashMap<String, Integer> operandos, operadores;
	private boolean naoSmell;

	public Funcao(String nome, int nArgs){
		this.nome = nome;
		this.nLinhas = 0;
		this.nArgs = nArgs;
		this.nIfs = 0;
		this.localVars=new HashMap<>();
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
	
    public int getnComentarios() {
        return nComentarios;
    }
	
	public int getMcCabe(){
            return this.mcCabe;
        }
        
	public int getLines(){
		return this.nLinhas;
	}

	public int getNArgs(){
		return this.nArgs;
	}
	
	    public HashMap<String,Integer> getLocalVars() {
        return localVars;
    }

    public void incLocalVars(String id) {
        if(this.localVars.containsKey(id)){
            int val=this.localVars.get(id)+1;
            this.localVars.put(id,val );
        }
        else {
            this.localVars.put(id, 0);
        }
            
    }
	
	public void incLines(int n){
		this.nLinhas += n;
	}

	public void incIfs(){
		this.nIfs++;
	}
	
    public int getnFors() {
        return nFors;
    }

    public int getnArgs() {
        return nArgs;
    }

    public int getnIfs() {
        return nIfs;
    }

    public int getnWhiles() {
        return nWhiles;
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
	public boolean hasUnusedLocalVars(){
            boolean flag=false;
            for(String id:this.localVars.keySet())
                if(this.localVars.get(id)==0) flag=true;
                
            return flag;
        }
        
        public ArrayList<String> unusedVars(){
            ArrayList<String> res=new ArrayList<>();
            for(String key: this.localVars.keySet())
                if(this.localVars.get(key)==0) res.add(key);
            return res;
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

class Programa {

	%include{sl.tom}
	%include{../genI/gram/i/i.tom}
        private String path;
	private int lines;
	private static HashMap<String, Funcao> funcs;
	private static Funcao auxFunc;

	public Programa(String path){
		this.funcs = new HashMap<>();
                this.path=path;
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

	public void parser(String path){
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
        public void refactConditionNegation(){
            try{
            File f = new File(path);
            iLexer lexer = new iLexer(new ANTLRInputStream(new FileInputStream(f)));
            CommonTokenStream tokens=new CommonTokenStream(lexer);
            iParser parser = new iParser(tokens);
            
            Tree b=(Tree) parser.prog().getTree();
            Instrucao p=(Instrucao) iAdaptor.getTerm(b);
            startRefactCondNegat(p);
            
            this.start(p);
            }
            catch(Exception e){
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
        private void startRefactCondNegat(Instrucao p){
            try {
			`TopDown(refactCondNeg()).visit(p);
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
        %strategy refactCondNeg() extends Identity(){
            visit Instrucao {
                If(_,_,_,Nao(Expressao),_,_,then,els) -> {
                    if(`els!=`Empty()){
						return `If(_,_,_,`Expressao,_,_,`els,`then);}
					else 
						return `If(_,_,_,Nao(Expressao),_,_,then,els);
            }
            }
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
				auxFunc.incLines(1);
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


			}
			
			For(_,_,_,_,_,_,_,_,_,_,_,_) -> {
				auxFunc.incLines(1);
				auxFunc.incFors();
				auxFunc.adicionaOperador("For");
				auxFunc.adicionaOperador(")");
				auxFunc.adicionaOperador("(");


			}
		}

		visit Expressao{
			Id(id) -> {
				auxFunc.adicionaOperando(`id);
                                auxFunc.incLocalVars(auxFunc.getNome());
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

class WindowGUI extends javax.swing.JFrame {

    JFileChooser chooser;
    RefValues referenceValues;
    Programa programa;
    ArrayList<Programa> bonsProgramas;

    /**
     * Creates new form Window
     */
    public WindowGUI(ArrayList<Programa> bonsProgramas, Programa programa) {
        initComponents();

        this.programa = programa;
        this.bonsProgramas = bonsProgramas;
        this.referenceValues = new RefValues(this.mediaLinhasProgramas(), this.mediaArgsProgramas(), this.mediaLocalVars(), 100, 10, 15);
        fillProgramDetailLabels();
        fillComplexityLabels();
        fillReferenceValues();
        fillRefactoringDetails();
    }

    private float mediaLocalVars(){
        int soma=0;
        int tot=0;
        for(Programa p:bonsProgramas){
            for (Map.Entry<String, Funcao> entry : p.getFuncs().entrySet()) {
                soma += entry.getValue().getLocalVars().size();
                tot++;
            }
        }
        return (float) soma/tot;
    }
    
    private float mediaLinhasProgramas() {
        int soma = 0;
        int tot = 0;

        for (Programa p : bonsProgramas) {
            for (Map.Entry<String, Funcao> entry : p.getFuncs().entrySet()) {
                soma += entry.getValue().getLines();
                tot++;
            }
        }

        return (float) soma / tot;
    }

    private float mediaArgsProgramas() {
        int soma = 0;
        int tot = 0;

        for (Programa p : bonsProgramas) {
            for (Map.Entry<String, Funcao> entry : p.getFuncs().entrySet()) {
                soma += entry.getValue().getNArgs();
                tot++;
            }
        }

        return (float) soma / tot;
    }

    /**
     * Falta MÃ©dia de VL
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel19 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jButton1 = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel61 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Metrics--");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel1.setText("Funcoes");

        jLabel2.setText("Argumentos na funcao: ");

        jLabel3.setText("jLabel3");

        jLabel4.setText("Linhas na funcao:");

        jLabel5.setText("jLabel5");

        jLabel6.setText("N de If:");

        jLabel7.setText("jLabel7");

        jLabel8.setText("N de While:");

        jLabel9.setText("jLabel9");

        jLabel10.setText("N de For:");

        jLabel11.setText("jLabel11");

        jLabel12.setText("N de Comentarios:");

        jLabel13.setText("jLabel13");

        jLabel14.setText("Linhas no programa:");

        jLabel15.setText("jLabel15");

        jLabel16.setText("N de Funcoes:");

        jLabel17.setText("jLabel17");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("Negacao numa condicao!");

        jLabel62.setText("N de Variaveis Locais");

        jLabel63.setText("jLabel63");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel15))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17))
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(0, 260, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel62)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel63)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel63)
                            .addComponent(jLabel62))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel18.setVisible(false);

        jTabbedPane1.addTab("Detalhes do Programa", jPanel1);

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList2ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);

        jLabel19.setText("Funcoes");

        jLabel20.setText("Complexidade Ciclomatica da Funcao");

        jLabel21.setText("jLabel21");

        jLabel22.setText("Vocabulario: ");

        jLabel23.setText("Comprimento:");

        jLabel24.setText("Comprimento Calculado:");

        jLabel25.setText("Volume:");

        jLabel26.setText("Dificuldade:");

        jLabel27.setText("Esforco:");

        jLabel28.setText("Tempo Necessario Estimado:");

        jLabel29.setText("Estimativa de Bugs Existentes: ");

        jLabel30.setText("jLabel30");

        jLabel31.setText("jLabel31");

        jLabel32.setText("jLabel32");

        jLabel33.setText("jLabel33");

        jLabel34.setText("jLabel34");

        jLabel35.setText("jLabel35");

        jLabel36.setText("jLabel36");

        jLabel37.setText("jLabel37");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4)
                            .addComponent(jSeparator5)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel21))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel37))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel30))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel31))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 294, Short.MAX_VALUE)
                                .addComponent(jLabel32))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel33))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel34))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel35))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel36))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel19)
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel32))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel33))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jLabel35))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(jLabel36))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(jLabel37))
                        .addGap(0, 155, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Metricas de Complexidade do Programa", jPanel2);

        jList3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList3.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList3ValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(jList3);

        jButton5.setText("Eliminar Smell: Negacao em Condicao");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Eliminar Smell: Variaveis Locais Inutilizadas");
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 195, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Refactoring", jPanel4);

        jLabel38.setText("N de Argumentos por Funcao:");

        jLabel39.setText("N de Linhas por Funcao:");

        jLabel40.setText("jLabel40");

        jLabel41.setText("jLabel41");

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel43.setText("Repositorio");

        jLabel44.setText("N de Variáveis Locais por Funcao:");

        jLabel45.setText("jLabel45");

        jLabel46.setText("Comunidade de Programadores");

        jButton1.setText("Recalcular Valores de Referencia");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel47.setText("N de Argumentos por Funcao:");

        jLabel48.setText("N de Linhas por Funcao:");

        jLabel49.setText("jLabel49");

        jLabel50.setText("jLabel50");

        jLabel51.setText("N de Variáveis Locais por Funcao:");

        jLabel52.setText("jLabel52");

        jLabel53.setText("+ Repo");

        jLabel54.setText("+Comunidade");

        jLabel55.setText("NAF");

        jLabel56.setText("NLF");

        jLabel57.setText("NVLF");

        jLabel58.setText("jLabel58");

        jLabel59.setText("jLabel59");

        jLabel60.setText("jLabel60");

        jLabel61.setText("Atualizar Valores de Comunidade");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton2.setText("Atualizar NAF");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton3.setText("Atualizar NLF");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButton4.setText("Atualizar NVLF");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49)
                            .addComponent(jLabel46)
                            .addComponent(jLabel50)
                            .addComponent(jLabel52))
                        .addGap(2, 2, 2))
                    .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel61, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel44)
                                        .addGap(122, 122, 122)
                                        .addComponent(jLabel45))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel38)
                                            .addGap(139, 139, 139)
                                            .addComponent(jLabel40))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel39)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel41))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel43))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel47)
                                    .addComponent(jLabel48)
                                    .addComponent(jLabel51)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton1)
                                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel54))
                            .addComponent(jLabel53)
                            .addComponent(jLabel56)
                            .addComponent(jLabel57))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel60)
                            .addComponent(jLabel59)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel55)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel58)))
                        .addGap(56, 56, 56))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel40)))
                            .addComponent(jLabel43))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel53)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45)
                            .addComponent(jLabel44))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel46)
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(jLabel49))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(jLabel50))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(jLabel52))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel61)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4))
                        .addGap(61, 61, 61))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel54)
                        .addGap(111, 111, 111)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel55)
                            .addComponent(jLabel58))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel56)
                            .addComponent(jLabel59))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57)
                            .addComponent(jLabel60))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPane1.addTab("Valores de Referencia", jPanel3);

        jMenu1.setText("Analise");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Guardar dados de Analise");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Analisar outro Programa");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setText("Sair");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Sobre");

        jMenuItem3.setText("Acerca de...");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>                        

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        //Novo JFileChooser.
        this.chooser = new JFileChooser();
        this.chooser = new JFileChooser();
        int retrival = this.chooser.showSaveDialog(null);
        if (retrival == JFileChooser.APPROVE_OPTION) {
            try {
                //filename
                FileWriter destFile = new FileWriter(this.chooser.getSelectedFile() + ".csv");
                //guardar para csv
            } catch (IOException ex) {
                Logger.getLogger(WindowGUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }                                          

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        this.dispose();
    }                                          

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        new About().setVisible(true);
    }                                          

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        if (!(jTextField1.getText().matches("[0-9]+"))) {
            jTextField1.setText("");
        }

    }                                           

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        if (!(jTextField2.getText().matches("[0-9]+"))) {
            jTextField2.setText("");
        }
    }                                           

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        if (!(jTextField3.getText().matches("[0-9]+"))) {
            jTextField3.setText("");
        }
    }                                           

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        referenceValues.updateReferenceValues(jSlider1.getValue());
        this.fillReferenceValues();
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        if (!(jTextField1.getText().isEmpty())) {
            referenceValues.setComFunctArgs(Integer.parseInt(jTextField1.getText()));
            referenceValues.updateReferenceValues(jSlider1.getValue());
            this.fillReferenceValues();
        }
    }                                        
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt){
        // Aqui chama-se estrategia de eliminar inexistentes;
    }
    public void writeToCSV(FileWriter dest) {
        try {
            dest.write("----------Analise-----------" + "\n");
            for (Funcao f : programa.getFuncs().values()) {
                dest.write(f.getNome() + "\n");
                //dest.write(f.);
            }
        } catch (Exception e) {
        }
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        if (!(jTextField2.getText().isEmpty())) {
            referenceValues.setComFunctLines(Integer.parseInt(jTextField2.getText()));
            referenceValues.updateReferenceValues(jSlider1.getValue());
            this.fillReferenceValues();
        }
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        if (!(jTextField3.getText().isEmpty())) {
            referenceValues.setComFunctLocalVars(Integer.parseInt(jTextField3.getText()));
            referenceValues.updateReferenceValues(jSlider1.getValue());
            this.fillReferenceValues();
        }
    }                                        

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        chooser = new JFileChooser();
        int returnValue = chooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            programa.parser(selectedFile.getName());
            this.fillComplexityLabels();
            this.fillProgramDetailLabels();
            this.fillReferenceValues();
            jLabel18.setVisible(false);
        }

    }                                          

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {                                    
        // TODO add your handling code here:
        fillFunctionDetailLabels(jList1.getSelectedValue());
        
    }                                   

    private void jList2ValueChanged(javax.swing.event.ListSelectionEvent evt) {                                    
        // TODO add your handling code here:
        fillComplexityFunction(jList2.getSelectedValue());
    }                                   

    private void jList3ValueChanged(javax.swing.event.ListSelectionEvent evt) {                                    
        // TODO add your handling code here:
        enableButtonsOnSmell(jList3.getSelectedValue());
    }                                   

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        this.programa.refactConditionNegation();
        this.fillComplexityLabels();
        this.fillProgramDetailLabels();
        this.fillReferenceValues();
        this.fillRefactoringDetails();
    }                                        
    private void enableButtonsOnSmell(String function){
        Funcao f=programa.getFuncao(function);
        if(f.isNao()){
            jButton5.setEnabled(true);
        }
        else{
            jButton5.setEnabled(false);
        }
        
        if(f.hasUnusedLocalVars()){
            jButton6.setEnabled(true);
        }
        else{
            jButton6.setEnabled(false);
        }
        
    }
    public void fillProgramDetailLabels() {
        //Preencher As Labels relacionadas com o programa; 
        DefaultListModel<String> dlm = new DefaultListModel<>();
        for (String str : this.programa.getArrayFuncs()) {
            dlm.addElement(str);
        }
        jList1.setModel(dlm);
        turnFunctionDetailsVisib(false);
        jLabel15.setText(programa.totLinhas() + "");
        jLabel17.setText(programa.getFuncs().size() + "");

    }

    public void fillComplexityLabels() {
        DefaultListModel<String> dlm = new DefaultListModel<>();
        for (String str : this.programa.getArrayFuncs()) {
            dlm.addElement(str);
        }
        jList2.setModel(dlm);
        turnComplexityVisib(false);
    }

    public void fillReferenceValues() {
        jLabel40.setText(referenceValues.getRepoFunctArgs() + "");
        jLabel41.setText(referenceValues.getRepoFunctLines() + "");
        jLabel45.setText(referenceValues.getRepoFunctLocalVars() + "");
        jLabel49.setText(referenceValues.getComFunctArgs() + "");
        jLabel50.setText(referenceValues.getComFunctLines() + "");
        jLabel52.setText(referenceValues.getComFunctLocalVars() + "");
        jLabel58.setText(referenceValues.getRvFunctionArgs() + "");
        jLabel59.setText(referenceValues.getRvFunctionLines() + "");
        jLabel60.setText(referenceValues.getRvFunctionLocalVars() + "");
    }

    private void turnComplexityVisib(boolean visibility) {
        jLabel21.setVisible(visibility);
        jLabel30.setVisible(visibility);
        jLabel31.setVisible(visibility);
        jLabel32.setVisible(visibility);
        jLabel33.setVisible(visibility);
        jLabel34.setVisible(visibility);
        jLabel35.setVisible(visibility);
        jLabel36.setVisible(visibility);
        jLabel37.setVisible(visibility);
    }

    private void turnFunctionDetailsVisib(boolean visibility) {
        jLabel3.setVisible(visibility);
        jLabel5.setVisible(visibility);
        jLabel7.setVisible(visibility);
        jLabel9.setVisible(visibility);
        jLabel11.setVisible(visibility);
        jLabel13.setVisible(visibility);
        jLabel63.setVisible(visibility);

    }

    public void fillFunctionDetailLabels(String funName) {
        Funcao f = this.programa.getFuncao(funName);
        fillNArgs(f.getNArgs());
        fillFunctionLines(f.getLines());
        jLabel7.setText(f.getnIfs()+"");
        jLabel9.setText(f.getnWhiles()+"");
        jLabel11.setText(f.getnFors()+"");
        jLabel13.setText(f.getnComentarios()+"");
        fillFunctionLocalVars(f.getLocalVars().size());
        turnFunctionDetailsVisib(true);
        if(f.isNao()){
            jLabel18.setVisible(true);
        }
        else{
            jLabel18.setVisible(false);
        }
    }

    private void fillFunctionLines(int lines) {
        jLabel5.setText(lines + "");
        if (lines > referenceValues.getRvFunctionLines()) {
            jLabel5.setForeground(Color.red);
            jLabel5.setFont(new Font("Tahoma", Font.BOLD, 14));
        } else if (lines == referenceValues.getRvFunctionLines()) {
            jLabel5.setForeground(Color.yellow);
            jLabel5.setFont(new Font("Tahoma", Font.BOLD, 14));
        } else {
            jLabel5.setForeground(Color.green);
            jLabel5.setFont(new Font("Tahoma", Font.BOLD, 14));
        }
    }
    private void fillFunctionLocalVars(int localVars){
        jLabel63.setText(localVars+ "");
        if (localVars > referenceValues.getRvFunctionLocalVars()) {
            jLabel63.setForeground(Color.red);
            jLabel63.setFont(new Font("Tahoma", Font.BOLD, 14));
        } else if (localVars == referenceValues.getRvFunctionLocalVars()) {
            jLabel63.setForeground(Color.yellow);
            jLabel63.setFont(new Font("Tahoma", Font.BOLD, 14));
        } else {
            jLabel63.setForeground(Color.green);
            jLabel63.setFont(new Font("Tahoma", Font.BOLD, 14));
        }
    }
    private void fillNArgs(int nArgs) {
        jLabel3.setText(nArgs + "");
        if (nArgs > referenceValues.getRvFunctionArgs()) {
            jLabel3.setForeground(Color.red);
            jLabel3.setFont(new Font("Tahoma", Font.BOLD, 14));
        } else if (nArgs == referenceValues.getRvFunctionArgs()) {
            jLabel3.setForeground(Color.yellow);
            jLabel3.setFont(new Font("Tahoma", Font.BOLD, 14));
        } else {
            jLabel3.setForeground(Color.green);
            jLabel3.setFont(new Font("Tahoma", Font.BOLD, 14));
        }
    }
    public void fillComplexityFunction(String funName){
        Funcao f=programa.getFuncao(funName);
        fillMcCabeWithColor(f.getMcCabe());
        jLabel30.setText(f.vocabulario()+"");
        jLabel31.setText(f.comprimento()+"");
        jLabel32.setText(f.comprimentoCalculado()+"");
        jLabel33.setText(""+f.volume());
        jLabel34.setText(""+f.dificuldade());
        jLabel35.setText(""+f.esforco());
        jLabel36.setText(f.tempoNecessario()+" segundos");
        jLabel37.setText(""+f.estimateBugs());
        turnComplexityVisib(true);
    }
    
    private void fillRefactoringDetails(){
        DefaultListModel<String> dlm=new DefaultListModel<>();
        for(String str:this.programa.getArrayFuncs())
            dlm.addElement(str);
        jList3.setModel(dlm);
        
    }
    
    private void fillMcCabeWithColor(int mcCabe){
        jLabel21.setText(mcCabe+"");
        if(mcCabe>=1 && mcCabe<=4) jLabel21.setForeground(Color.green);
        else if(mcCabe>4 && mcCabe<=7) jLabel21.setForeground(new Color(64, 191, 0));
        else if(mcCabe>7 && mcCabe<=10) jLabel21.setForeground(new Color(127,127,0));
        else jLabel21.setForeground(Color.red);
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration                   
}


class About extends javax.swing.JFrame {

    /**
     * Creates new form About
     */
    public About() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Acerca de...");

        jLabel1.setFont(new java.awt.Font("Arial", 2, 24)); // NOI18N
        jLabel1.setText("METRICS--");

        jLabel2.setText("Mestrado Integrado em Engenharia Informática - 4º Ano");

        jLabel3.setText("Métodos Formais em Engenharia de Software");

        jLabel4.setText("Jorge Miguel Sol Ferreira, a64293");

        jLabel5.setText("Pedro José Freitas da Cunha, a67677");

        jLabel6.setText("Grupo 1");

        jLabel7.setText("2015/16");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(0, 120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}

class RefValues {
    private float repoFunctLines,repoFunctArgs,repoFunctLocalVars;
    private int comFunctLines,comFunctArgs,comFunctLocalVars;
    private float rvFL,rvFA,rvFLV;

    public RefValues() {
    this.comFunctArgs=0;
    this.comFunctLines=0;
    this.comFunctLocalVars=0;
    this.repoFunctArgs=0;
    this.repoFunctLines=0;
    this.repoFunctLocalVars=0;
    this.rvFA=0;
    this.rvFL=0;
    this.rvFLV=0;
    }
    
    public RefValues(float repoFunctLines, float repoFunctArgs, float repoFunctLocalVars, int comFunctLines, int comFunctArgs, int comFunctLocalVars){
        this.repoFunctLines = repoFunctLines;
        this.repoFunctArgs = repoFunctArgs;
        this.repoFunctLocalVars = repoFunctLocalVars;
        this.comFunctLines = comFunctLines;
        this.comFunctArgs = comFunctArgs;
        this.comFunctLocalVars = comFunctLocalVars;
        this.rvFA=(repoFunctArgs+comFunctArgs)/2;
        this.rvFL=(repoFunctLines+comFunctLines)/2;
        this.rvFLV=(repoFunctLocalVars+comFunctLocalVars)/2;
    }

    public RefValues(float repoFunctLines, float repoFunctArgs, float repoFunctLocalVars, int comFunctLines, int comFunctArgs, int comFunctLocalVars, float rvFL, float rvFA, float rvFLV) {
        this.repoFunctLines = repoFunctLines;
        this.repoFunctArgs = repoFunctArgs;
        this.repoFunctLocalVars = repoFunctLocalVars;
        this.comFunctLines = comFunctLines;
        this.comFunctArgs = comFunctArgs;
        this.comFunctLocalVars = comFunctLocalVars;
        this.rvFL = rvFL;
        this.rvFA = rvFA;
        this.rvFLV = rvFLV;
    }

    public int getComFunctArgs() {
        return comFunctArgs;
    }

    public int getComFunctLines() {
        return comFunctLines;
    }

    public int getComFunctLocalVars() {
        return comFunctLocalVars;
    }

    public float getRepoFunctArgs() {
        return repoFunctArgs;
    }

    public float getRepoFunctLines() {
        return repoFunctLines;
    }

    public float getRepoFunctLocalVars() {
        return repoFunctLocalVars;
    }

    public float getRvFunctionArgs() {
        return rvFA;
    }

    public float getRvFunctionLines() {
        return rvFL;
    }

    public float getRvFunctionLocalVars() {
        return rvFLV;
    }

    public void setComFunctArgs(int comFunctArgs) {
        this.comFunctArgs = comFunctArgs;
    }

    public void setComFunctLines(int comFunctLines) {
        this.comFunctLines = comFunctLines;
    }

    public void setComFunctLocalVars(int comFunctLocalVars) {
        this.comFunctLocalVars = comFunctLocalVars;
    }

    public void setRepoFunctArgs(float repoFunctArgs) {
        this.repoFunctArgs = repoFunctArgs;
    }

    public void setRepoFunctLines(float repoFunctLines) {
        this.repoFunctLines = repoFunctLines;
    }

    public void setRepoFunctLocalVars(float repoFunctLocalVars) {
        this.repoFunctLocalVars = repoFunctLocalVars;
    }

    public void setRvFA(float rvFA) {
        this.rvFA = rvFA;
    }

    public void setRvFL(float rvFL) {
        this.rvFL = rvFL;
    }

    public void setRvFLV(float rvFLV) {
        this.rvFLV = rvFLV;
    }
    
    
    public void updateReferenceValues(int perc){
        float repoPerc=(100-perc)/100;
        float comPerc=perc/100;
        this.rvFA=repoPerc*repoFunctArgs+comPerc*comFunctArgs;
        this.rvFL=repoPerc*repoFunctLines+comPerc*comFunctLines;
        this.rvFLV=repoPerc*repoFunctLocalVars+comPerc*comFunctLocalVars;
    }
}


