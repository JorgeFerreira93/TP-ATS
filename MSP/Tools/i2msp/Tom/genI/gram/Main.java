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

		File folder = new File("../exemplos/");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
System.out.println(listOfFiles[i].getPath());
			Programa p = new Programa(listOfFiles[i].getPath());


			
			bonsProgramas.add(p);
		}

		lerPrograma();
        
        new WindowGUI(bonsProgramas,Programa).setVisible(true);
	}

	private static void lerPrograma(){
		Scanner is = new Scanner(System.in);
        
        System.out.print("Nome Ficheiro: ");
        String op = is.nextLine();

        Programa = new Programa(op);
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

	private static boolean tom_equal_term_Strategy(Object t1, Object t2) {return  (t1.equals(t2)) ;}private static boolean tom_is_sort_Strategy(Object t) {return  (t instanceof tom.library.sl.Strategy) ;} private static boolean tom_equal_term_Position(Object t1, Object t2) {return  (t1.equals(t2)) ;}private static boolean tom_is_sort_Position(Object t) {return  (t instanceof tom.library.sl.Position) ;} private static boolean tom_equal_term_int(int t1, int t2) {return  t1==t2 ;}private static boolean tom_is_sort_int(int t) {return  true ;} private static boolean tom_equal_term_char(char t1, char t2) {return  t1==t2 ;}private static boolean tom_is_sort_char(char t) {return  true ;} private static boolean tom_equal_term_String(String t1, String t2) {return  t1.equals(t2) ;}private static boolean tom_is_sort_String(String t) {return  t instanceof String ;} private static  tom.library.sl.Strategy  tom_make_mu( tom.library.sl.Strategy  var,  tom.library.sl.Strategy  v) { return ( new tom.library.sl.Mu(var,v) );}private static  tom.library.sl.Strategy  tom_make_MuVar( String  name) { return ( new tom.library.sl.MuVar(name) );}private static  tom.library.sl.Strategy  tom_make_Identity() { return ( new tom.library.sl.Identity() );}private static  tom.library.sl.Strategy  tom_make_One( tom.library.sl.Strategy  v) { return ( new tom.library.sl.One(v) );}private static  tom.library.sl.Strategy  tom_make_All( tom.library.sl.Strategy  v) { return ( new tom.library.sl.All(v) );}private static  tom.library.sl.Strategy  tom_make_Fail() { return ( new tom.library.sl.Fail() );}private static boolean tom_is_fun_sym_Sequence( tom.library.sl.Strategy  t) {return ( t instanceof tom.library.sl.Sequence );}private static  tom.library.sl.Strategy  tom_empty_list_Sequence() { return  null ;}private static  tom.library.sl.Strategy  tom_cons_list_Sequence( tom.library.sl.Strategy  head,  tom.library.sl.Strategy  tail) { return  tom.library.sl.Sequence.make(head,tail) ;}private static  tom.library.sl.Strategy  tom_get_head_Sequence_Strategy( tom.library.sl.Strategy  t) {return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.Sequence.FIRST) );}private static  tom.library.sl.Strategy  tom_get_tail_Sequence_Strategy( tom.library.sl.Strategy  t) {return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.Sequence.THEN) );}private static boolean tom_is_empty_Sequence_Strategy( tom.library.sl.Strategy  t) {return ( t == null );}   private static   tom.library.sl.Strategy  tom_append_list_Sequence( tom.library.sl.Strategy  l1,  tom.library.sl.Strategy  l2) {     if(( l1 == null )) {       return l2;     } else if(( l2 == null )) {       return l1;     } else if(( l1 instanceof tom.library.sl.Sequence )) {       if(( ( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Sequence.THEN) ) == null )) {         return  tom.library.sl.Sequence.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Sequence.FIRST) ),l2) ;       } else {         return  tom.library.sl.Sequence.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Sequence.FIRST) ),tom_append_list_Sequence(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Sequence.THEN) ),l2)) ;       }     } else {       return  tom.library.sl.Sequence.make(l1,l2) ;     }   }   private static   tom.library.sl.Strategy  tom_get_slice_Sequence( tom.library.sl.Strategy  begin,  tom.library.sl.Strategy  end, tom.library.sl.Strategy  tail) {     if( (begin.equals(end)) ) {       return tail;     } else if( (end.equals(tail))  && (( end == null ) ||  (end.equals(tom_empty_list_Sequence())) )) {       /* code to avoid a call to make, and thus to avoid looping during list-matching */       return begin;     }     return  tom.library.sl.Sequence.make(((( begin instanceof tom.library.sl.Sequence ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.Sequence.FIRST) ):begin),( tom.library.sl.Strategy )tom_get_slice_Sequence(((( begin instanceof tom.library.sl.Sequence ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.Sequence.THEN) ):tom_empty_list_Sequence()),end,tail)) ;   }   private static boolean tom_is_fun_sym_Choice( tom.library.sl.Strategy  t) {return ( t instanceof tom.library.sl.Choice );}private static  tom.library.sl.Strategy  tom_empty_list_Choice() { return  null ;}private static  tom.library.sl.Strategy  tom_cons_list_Choice( tom.library.sl.Strategy  head,  tom.library.sl.Strategy  tail) { return  tom.library.sl.Choice.make(head,tail) ;}private static  tom.library.sl.Strategy  tom_get_head_Choice_Strategy( tom.library.sl.Strategy  t) {return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.Choice.FIRST) );}private static  tom.library.sl.Strategy  tom_get_tail_Choice_Strategy( tom.library.sl.Strategy  t) {return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.Choice.THEN) );}private static boolean tom_is_empty_Choice_Strategy( tom.library.sl.Strategy  t) {return ( t ==null );}   private static   tom.library.sl.Strategy  tom_append_list_Choice( tom.library.sl.Strategy  l1,  tom.library.sl.Strategy  l2) {     if(( l1 ==null )) {       return l2;     } else if(( l2 ==null )) {       return l1;     } else if(( l1 instanceof tom.library.sl.Choice )) {       if(( ( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Choice.THEN) ) ==null )) {         return  tom.library.sl.Choice.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Choice.FIRST) ),l2) ;       } else {         return  tom.library.sl.Choice.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Choice.FIRST) ),tom_append_list_Choice(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Choice.THEN) ),l2)) ;       }     } else {       return  tom.library.sl.Choice.make(l1,l2) ;     }   }   private static   tom.library.sl.Strategy  tom_get_slice_Choice( tom.library.sl.Strategy  begin,  tom.library.sl.Strategy  end, tom.library.sl.Strategy  tail) {     if( (begin.equals(end)) ) {       return tail;     } else if( (end.equals(tail))  && (( end ==null ) ||  (end.equals(tom_empty_list_Choice())) )) {       /* code to avoid a call to make, and thus to avoid looping during list-matching */       return begin;     }     return  tom.library.sl.Choice.make(((( begin instanceof tom.library.sl.Choice ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.Choice.FIRST) ):begin),( tom.library.sl.Strategy )tom_get_slice_Choice(((( begin instanceof tom.library.sl.Choice ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.Choice.THEN) ):tom_empty_list_Choice()),end,tail)) ;   }   private static boolean tom_is_fun_sym_SequenceId( tom.library.sl.Strategy  t) {return ( t instanceof tom.library.sl.SequenceId );}private static  tom.library.sl.Strategy  tom_empty_list_SequenceId() { return  null ;}private static  tom.library.sl.Strategy  tom_cons_list_SequenceId( tom.library.sl.Strategy  head,  tom.library.sl.Strategy  tail) { return  tom.library.sl.SequenceId.make(head,tail) ;}private static  tom.library.sl.Strategy  tom_get_head_SequenceId_Strategy( tom.library.sl.Strategy  t) {return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.SequenceId.FIRST) );}private static  tom.library.sl.Strategy  tom_get_tail_SequenceId_Strategy( tom.library.sl.Strategy  t) {return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.SequenceId.THEN) );}private static boolean tom_is_empty_SequenceId_Strategy( tom.library.sl.Strategy  t) {return ( t == null );}   private static   tom.library.sl.Strategy  tom_append_list_SequenceId( tom.library.sl.Strategy  l1,  tom.library.sl.Strategy  l2) {     if(( l1 == null )) {       return l2;     } else if(( l2 == null )) {       return l1;     } else if(( l1 instanceof tom.library.sl.SequenceId )) {       if(( ( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.SequenceId.THEN) ) == null )) {         return  tom.library.sl.SequenceId.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.SequenceId.FIRST) ),l2) ;       } else {         return  tom.library.sl.SequenceId.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.SequenceId.FIRST) ),tom_append_list_SequenceId(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.SequenceId.THEN) ),l2)) ;       }     } else {       return  tom.library.sl.SequenceId.make(l1,l2) ;     }   }   private static   tom.library.sl.Strategy  tom_get_slice_SequenceId( tom.library.sl.Strategy  begin,  tom.library.sl.Strategy  end, tom.library.sl.Strategy  tail) {     if( (begin.equals(end)) ) {       return tail;     } else if( (end.equals(tail))  && (( end == null ) ||  (end.equals(tom_empty_list_SequenceId())) )) {       /* code to avoid a call to make, and thus to avoid looping during list-matching */       return begin;     }     return  tom.library.sl.SequenceId.make(((( begin instanceof tom.library.sl.SequenceId ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.SequenceId.FIRST) ):begin),( tom.library.sl.Strategy )tom_get_slice_SequenceId(((( begin instanceof tom.library.sl.SequenceId ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.SequenceId.THEN) ):tom_empty_list_SequenceId()),end,tail)) ;   }   private static boolean tom_is_fun_sym_ChoiceId( tom.library.sl.Strategy  t) {return ( t instanceof tom.library.sl.ChoiceId );}private static  tom.library.sl.Strategy  tom_empty_list_ChoiceId() { return  null ;}private static  tom.library.sl.Strategy  tom_cons_list_ChoiceId( tom.library.sl.Strategy  head,  tom.library.sl.Strategy  tail) { return  tom.library.sl.ChoiceId.make(head,tail) ;}private static  tom.library.sl.Strategy  tom_get_head_ChoiceId_Strategy( tom.library.sl.Strategy  t) {return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.ChoiceId.FIRST) );}private static  tom.library.sl.Strategy  tom_get_tail_ChoiceId_Strategy( tom.library.sl.Strategy  t) {return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.ChoiceId.THEN) );}private static boolean tom_is_empty_ChoiceId_Strategy( tom.library.sl.Strategy  t) {return ( t ==null );}   private static   tom.library.sl.Strategy  tom_append_list_ChoiceId( tom.library.sl.Strategy  l1,  tom.library.sl.Strategy  l2) {     if(( l1 ==null )) {       return l2;     } else if(( l2 ==null )) {       return l1;     } else if(( l1 instanceof tom.library.sl.ChoiceId )) {       if(( ( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.ChoiceId.THEN) ) ==null )) {         return  tom.library.sl.ChoiceId.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.ChoiceId.FIRST) ),l2) ;       } else {         return  tom.library.sl.ChoiceId.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.ChoiceId.FIRST) ),tom_append_list_ChoiceId(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.ChoiceId.THEN) ),l2)) ;       }     } else {       return  tom.library.sl.ChoiceId.make(l1,l2) ;     }   }   private static   tom.library.sl.Strategy  tom_get_slice_ChoiceId( tom.library.sl.Strategy  begin,  tom.library.sl.Strategy  end, tom.library.sl.Strategy  tail) {     if( (begin.equals(end)) ) {       return tail;     } else if( (end.equals(tail))  && (( end ==null ) ||  (end.equals(tom_empty_list_ChoiceId())) )) {       /* code to avoid a call to make, and thus to avoid looping during list-matching */       return begin;     }     return  tom.library.sl.ChoiceId.make(((( begin instanceof tom.library.sl.ChoiceId ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.ChoiceId.FIRST) ):begin),( tom.library.sl.Strategy )tom_get_slice_ChoiceId(((( begin instanceof tom.library.sl.ChoiceId ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.ChoiceId.THEN) ):tom_empty_list_ChoiceId()),end,tail)) ;   }   private static  tom.library.sl.Strategy  tom_make_OneId( tom.library.sl.Strategy  v) { return ( new tom.library.sl.OneId(v) );}   private static  tom.library.sl.Strategy  tom_make_AllSeq( tom.library.sl.Strategy  s) { return ( new tom.library.sl.AllSeq(s) );}private static  tom.library.sl.Strategy  tom_make_AUCtl( tom.library.sl.Strategy  s1,  tom.library.sl.Strategy  s2) { return ( tom_make_mu(tom_make_MuVar("x"),tom_cons_list_Choice(s2,tom_cons_list_Choice(tom_cons_list_Sequence(tom_cons_list_Sequence(s1,tom_cons_list_Sequence(tom_make_All(tom_make_MuVar("x")),tom_empty_list_Sequence())),tom_cons_list_Sequence(tom_make_One(tom_make_Identity()),tom_empty_list_Sequence())),tom_empty_list_Choice()))) );}private static  tom.library.sl.Strategy  tom_make_EUCtl( tom.library.sl.Strategy  s1,  tom.library.sl.Strategy  s2) { return ( tom_make_mu(tom_make_MuVar("x"),tom_cons_list_Choice(s2,tom_cons_list_Choice(tom_cons_list_Sequence(s1,tom_cons_list_Sequence(tom_make_One(tom_make_MuVar("x")),tom_empty_list_Sequence())),tom_empty_list_Choice()))));} private static  tom.library.sl.Strategy  tom_make_Try( tom.library.sl.Strategy  s) { return ( tom_cons_list_Choice(s,tom_cons_list_Choice(tom_make_Identity(),tom_empty_list_Choice())) );}private static  tom.library.sl.Strategy  tom_make_Repeat( tom.library.sl.Strategy  s) { return ( tom_make_mu(tom_make_MuVar("_x"),tom_cons_list_Choice(tom_cons_list_Sequence(s,tom_cons_list_Sequence(tom_make_MuVar("_x"),tom_empty_list_Sequence())),tom_cons_list_Choice(tom_make_Identity(),tom_empty_list_Choice()))) );}private static  tom.library.sl.Strategy  tom_make_TopDown( tom.library.sl.Strategy  v) { return ( tom_make_mu(tom_make_MuVar("_x"),tom_cons_list_Sequence(v,tom_cons_list_Sequence(tom_make_All(tom_make_MuVar("_x")),tom_empty_list_Sequence()))) );}private static  tom.library.sl.Strategy  tom_make_OnceTopDown( tom.library.sl.Strategy  v) { return ( tom_make_mu(tom_make_MuVar("_x"),tom_cons_list_Choice(v,tom_cons_list_Choice(tom_make_One(tom_make_MuVar("_x")),tom_empty_list_Choice()))) );}private static  tom.library.sl.Strategy  tom_make_RepeatId( tom.library.sl.Strategy  v) { return ( tom_make_mu(tom_make_MuVar("_x"),tom_cons_list_SequenceId(v,tom_cons_list_SequenceId(tom_make_MuVar("_x"),tom_empty_list_SequenceId()))) );}private static  tom.library.sl.Strategy  tom_make_OnceTopDownId( tom.library.sl.Strategy  v) { return ( tom_make_mu(tom_make_MuVar("_x"),tom_cons_list_ChoiceId(v,tom_cons_list_ChoiceId(tom_make_OneId(tom_make_MuVar("_x")),tom_empty_list_ChoiceId()))) );}   private static boolean tom_equal_term_DefTipo(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_DefTipo(Object t) {return  (t instanceof gram.i.types.DefTipo) ;}private static boolean tom_equal_term_OpNum(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_OpNum(Object t) {return  (t instanceof gram.i.types.OpNum) ;}private static boolean tom_equal_term_LComentarios(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_LComentarios(Object t) {return  (t instanceof gram.i.types.LComentarios) ;}private static boolean tom_equal_term_OpComp(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_OpComp(Object t) {return  (t instanceof gram.i.types.OpComp) ;}private static boolean tom_equal_term_Expressao(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_Expressao(Object t) {return  (t instanceof gram.i.types.Expressao) ;}private static boolean tom_equal_term_OpAtribuicao(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_OpAtribuicao(Object t) {return  (t instanceof gram.i.types.OpAtribuicao) ;}private static boolean tom_equal_term_OpInc(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_OpInc(Object t) {return  (t instanceof gram.i.types.OpInc) ;}private static boolean tom_equal_term_Parametros(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_Parametros(Object t) {return  (t instanceof gram.i.types.Parametros) ;}private static boolean tom_equal_term_Argumentos(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_Argumentos(Object t) {return  (t instanceof gram.i.types.Argumentos) ;}private static boolean tom_equal_term_Declaracoes(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_Declaracoes(Object t) {return  (t instanceof gram.i.types.Declaracoes) ;}private static boolean tom_equal_term_Instrucao(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_Instrucao(Object t) {return  (t instanceof gram.i.types.Instrucao) ;}private static boolean tom_equal_term_IntWrapper(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_IntWrapper(Object t) {return  (t instanceof gram.i.types.IntWrapper) ;}private static boolean tom_is_fun_sym_DInt( gram.i.types.DefTipo  t) {return  (t instanceof gram.i.types.deftipo.DInt) ;}private static boolean tom_is_fun_sym_DChar( gram.i.types.DefTipo  t) {return  (t instanceof gram.i.types.deftipo.DChar) ;}private static boolean tom_is_fun_sym_DBoolean( gram.i.types.DefTipo  t) {return  (t instanceof gram.i.types.deftipo.DBoolean) ;}private static boolean tom_is_fun_sym_DFloat( gram.i.types.DefTipo  t) {return  (t instanceof gram.i.types.deftipo.DFloat) ;}private static boolean tom_is_fun_sym_DVoid( gram.i.types.DefTipo  t) {return  (t instanceof gram.i.types.deftipo.DVoid) ;}private static boolean tom_is_fun_sym_Comentario( gram.i.types.LComentarios  t) {return  (t instanceof gram.i.types.lcomentarios.Comentario) ;}private static  String  tom_get_slot_Comentario_comentario( gram.i.types.LComentarios  t) {return  t.getcomentario() ;}private static boolean tom_is_fun_sym_Id( gram.i.types.Expressao  t) {return  (t instanceof gram.i.types.expressao.Id) ;}private static  String  tom_get_slot_Id_Id( gram.i.types.Expressao  t) {return  t.getId() ;}private static boolean tom_is_fun_sym_Nao( gram.i.types.Expressao  t) {return  (t instanceof gram.i.types.expressao.Nao) ;}private static  gram.i.types.Expressao  tom_get_slot_Nao_Expressao( gram.i.types.Expressao  t) {return  t.getExpressao() ;}private static boolean tom_is_fun_sym_Call( gram.i.types.Expressao  t) {return  (t instanceof gram.i.types.expressao.Call) ;}private static  gram.i.types.LComentarios  tom_get_slot_Call_c1( gram.i.types.Expressao  t) {return  t.getc1() ;}private static  String  tom_get_slot_Call_Id( gram.i.types.Expressao  t) {return  t.getId() ;}private static  gram.i.types.LComentarios  tom_get_slot_Call_c2( gram.i.types.Expressao  t) {return  t.getc2() ;}private static  gram.i.types.LComentarios  tom_get_slot_Call_c3( gram.i.types.Expressao  t) {return  t.getc3() ;}private static  gram.i.types.Parametros  tom_get_slot_Call_Parametros( gram.i.types.Expressao  t) {return  t.getParametros() ;}private static  gram.i.types.LComentarios  tom_get_slot_Call_c4( gram.i.types.Expressao  t) {return  t.getc4() ;}private static  gram.i.types.LComentarios  tom_get_slot_Call_c5( gram.i.types.Expressao  t) {return  t.getc5() ;}private static boolean tom_is_fun_sym_Int( gram.i.types.Expressao  t) {return  (t instanceof gram.i.types.expressao.Int) ;}private static  int  tom_get_slot_Int_Int( gram.i.types.Expressao  t) {return  t.getInt() ;}private static boolean tom_is_fun_sym_Char( gram.i.types.Expressao  t) {return  (t instanceof gram.i.types.expressao.Char) ;}private static  String  tom_get_slot_Char_Char( gram.i.types.Expressao  t) {return  t.getChar() ;}private static boolean tom_is_fun_sym_True( gram.i.types.Expressao  t) {return  (t instanceof gram.i.types.expressao.True) ;}private static boolean tom_is_fun_sym_False( gram.i.types.Expressao  t) {return  (t instanceof gram.i.types.expressao.False) ;}private static boolean tom_is_fun_sym_Float( gram.i.types.Expressao  t) {return  (t instanceof gram.i.types.expressao.Float) ;}private static  int  tom_get_slot_Float_num( gram.i.types.Expressao  t) {return  t.getnum() ;}private static boolean tom_is_fun_sym_Ou( gram.i.types.Expressao  t) {return  (t instanceof gram.i.types.expressao.Ou) ;}private static  gram.i.types.Expressao  tom_get_slot_Ou_Cond1( gram.i.types.Expressao  t) {return  t.getCond1() ;}private static  gram.i.types.LComentarios  tom_get_slot_Ou_c1( gram.i.types.Expressao  t) {return  t.getc1() ;}private static  gram.i.types.LComentarios  tom_get_slot_Ou_c2( gram.i.types.Expressao  t) {return  t.getc2() ;}private static  gram.i.types.Expressao  tom_get_slot_Ou_Cond2( gram.i.types.Expressao  t) {return  t.getCond2() ;}private static boolean tom_is_fun_sym_E( gram.i.types.Expressao  t) {return  (t instanceof gram.i.types.expressao.E) ;}private static  gram.i.types.Expressao  tom_get_slot_E_Cond1( gram.i.types.Expressao  t) {return  t.getCond1() ;}private static  gram.i.types.LComentarios  tom_get_slot_E_c1( gram.i.types.Expressao  t) {return  t.getc1() ;}private static  gram.i.types.LComentarios  tom_get_slot_E_c2( gram.i.types.Expressao  t) {return  t.getc2() ;}private static  gram.i.types.Expressao  tom_get_slot_E_Cond2( gram.i.types.Expressao  t) {return  t.getCond2() ;}private static boolean tom_is_fun_sym_Input( gram.i.types.Expressao  t) {return  (t instanceof gram.i.types.expressao.Input) ;}private static  gram.i.types.LComentarios  tom_get_slot_Input_c1( gram.i.types.Expressao  t) {return  t.getc1() ;}private static  gram.i.types.LComentarios  tom_get_slot_Input_c2( gram.i.types.Expressao  t) {return  t.getc2() ;}private static  gram.i.types.LComentarios  tom_get_slot_Input_c3( gram.i.types.Expressao  t) {return  t.getc3() ;}private static  gram.i.types.DefTipo  tom_get_slot_Input_Tipo( gram.i.types.Expressao  t) {return  t.getTipo() ;}private static  gram.i.types.LComentarios  tom_get_slot_Input_c4( gram.i.types.Expressao  t) {return  t.getc4() ;}private static  gram.i.types.LComentarios  tom_get_slot_Input_c5( gram.i.types.Expressao  t) {return  t.getc5() ;}private static boolean tom_is_fun_sym_Print( gram.i.types.Expressao  t) {return  (t instanceof gram.i.types.expressao.Print) ;}private static  gram.i.types.LComentarios  tom_get_slot_Print_c1( gram.i.types.Expressao  t) {return  t.getc1() ;}private static  gram.i.types.LComentarios  tom_get_slot_Print_c2( gram.i.types.Expressao  t) {return  t.getc2() ;}private static  gram.i.types.LComentarios  tom_get_slot_Print_c3( gram.i.types.Expressao  t) {return  t.getc3() ;}private static  gram.i.types.Expressao  tom_get_slot_Print_Expressao( gram.i.types.Expressao  t) {return  t.getExpressao() ;}private static  gram.i.types.LComentarios  tom_get_slot_Print_c4( gram.i.types.Expressao  t) {return  t.getc4() ;}private static  gram.i.types.LComentarios  tom_get_slot_Print_c5( gram.i.types.Expressao  t) {return  t.getc5() ;}private static  gram.i.types.Expressao  tom_make_Empty() { return  gram.i.types.expressao.Empty.make() ;}private static  gram.i.types.OpAtribuicao  tom_make_Atrib() { return  gram.i.types.opatribuicao.Atrib.make() ;}private static  gram.i.types.OpAtribuicao  tom_make_Mult() { return  gram.i.types.opatribuicao.Mult.make() ;}private static  gram.i.types.OpAtribuicao  tom_make_Div() { return  gram.i.types.opatribuicao.Div.make() ;}private static  gram.i.types.OpAtribuicao  tom_make_Soma() { return  gram.i.types.opatribuicao.Soma.make() ;}private static boolean tom_is_fun_sym_Argumento( gram.i.types.Argumentos  t) {return  (t instanceof gram.i.types.argumentos.Argumento) ;}private static  gram.i.types.LComentarios  tom_get_slot_Argumento_c1( gram.i.types.Argumentos  t) {return  t.getc1() ;}private static  gram.i.types.DefTipo  tom_get_slot_Argumento_DefTipo( gram.i.types.Argumentos  t) {return  t.getDefTipo() ;}private static  gram.i.types.LComentarios  tom_get_slot_Argumento_c2( gram.i.types.Argumentos  t) {return  t.getc2() ;}private static  String  tom_get_slot_Argumento_Id( gram.i.types.Argumentos  t) {return  t.getId() ;}private static  gram.i.types.LComentarios  tom_get_slot_Argumento_c3( gram.i.types.Argumentos  t) {return  t.getc3() ;}private static boolean tom_is_fun_sym_Decl( gram.i.types.Declaracoes  t) {return  (t instanceof gram.i.types.declaracoes.Decl) ;}private static  String  tom_get_slot_Decl_Id( gram.i.types.Declaracoes  t) {return  t.getId() ;}private static  gram.i.types.LComentarios  tom_get_slot_Decl_c1( gram.i.types.Declaracoes  t) {return  t.getc1() ;}private static  gram.i.types.LComentarios  tom_get_slot_Decl_c2( gram.i.types.Declaracoes  t) {return  t.getc2() ;}private static  gram.i.types.Expressao  tom_get_slot_Decl_Expressao( gram.i.types.Declaracoes  t) {return  t.getExpressao() ;}private static  gram.i.types.LComentarios  tom_get_slot_Decl_c3( gram.i.types.Declaracoes  t) {return  t.getc3() ;}private static boolean tom_is_fun_sym_Atribuicao( gram.i.types.Instrucao  t) {return  (t instanceof gram.i.types.instrucao.Atribuicao) ;}private static  gram.i.types.LComentarios  tom_get_slot_Atribuicao_c1( gram.i.types.Instrucao  t) {return  t.getc1() ;}private static  String  tom_get_slot_Atribuicao_Id( gram.i.types.Instrucao  t) {return  t.getId() ;}private static  gram.i.types.LComentarios  tom_get_slot_Atribuicao_c2( gram.i.types.Instrucao  t) {return  t.getc2() ;}private static  gram.i.types.OpAtribuicao  tom_get_slot_Atribuicao_op( gram.i.types.Instrucao  t) {return  t.getop() ;}private static  gram.i.types.LComentarios  tom_get_slot_Atribuicao_c3( gram.i.types.Instrucao  t) {return  t.getc3() ;}private static  gram.i.types.Expressao  tom_get_slot_Atribuicao_Expressao( gram.i.types.Instrucao  t) {return  t.getExpressao() ;}private static  gram.i.types.LComentarios  tom_get_slot_Atribuicao_c4( gram.i.types.Instrucao  t) {return  t.getc4() ;}private static boolean tom_is_fun_sym_Declaracao( gram.i.types.Instrucao  t) {return  (t instanceof gram.i.types.instrucao.Declaracao) ;}private static  gram.i.types.LComentarios  tom_get_slot_Declaracao_c1( gram.i.types.Instrucao  t) {return  t.getc1() ;}private static  gram.i.types.DefTipo  tom_get_slot_Declaracao_DefTipo( gram.i.types.Instrucao  t) {return  t.getDefTipo() ;}private static  gram.i.types.LComentarios  tom_get_slot_Declaracao_c2( gram.i.types.Instrucao  t) {return  t.getc2() ;}private static  gram.i.types.Declaracoes  tom_get_slot_Declaracao_Declaracoes( gram.i.types.Instrucao  t) {return  t.getDeclaracoes() ;}private static  gram.i.types.LComentarios  tom_get_slot_Declaracao_c3( gram.i.types.Instrucao  t) {return  t.getc3() ;}private static  gram.i.types.LComentarios  tom_get_slot_Declaracao_c4( gram.i.types.Instrucao  t) {return  t.getc4() ;}private static boolean tom_is_fun_sym_If( gram.i.types.Instrucao  t) {return  (t instanceof gram.i.types.instrucao.If) ;}private static  gram.i.types.Instrucao  tom_make_If( gram.i.types.LComentarios  t0,  gram.i.types.LComentarios  t1,  gram.i.types.LComentarios  t2,  gram.i.types.Expressao  t3,  gram.i.types.LComentarios  t4,  gram.i.types.LComentarios  t5,  gram.i.types.Instrucao  t6,  gram.i.types.Instrucao  t7) { return  gram.i.types.instrucao.If.make(t0, t1, t2, t3, t4, t5, t6, t7) ;}private static  gram.i.types.LComentarios  tom_get_slot_If_c1( gram.i.types.Instrucao  t) {return  t.getc1() ;}private static  gram.i.types.LComentarios  tom_get_slot_If_c2( gram.i.types.Instrucao  t) {return  t.getc2() ;}private static  gram.i.types.LComentarios  tom_get_slot_If_c3( gram.i.types.Instrucao  t) {return  t.getc3() ;}private static  gram.i.types.Expressao  tom_get_slot_If_Condicao( gram.i.types.Instrucao  t) {return  t.getCondicao() ;}private static  gram.i.types.LComentarios  tom_get_slot_If_c4( gram.i.types.Instrucao  t) {return  t.getc4() ;}private static  gram.i.types.LComentarios  tom_get_slot_If_c5( gram.i.types.Instrucao  t) {return  t.getc5() ;}private static  gram.i.types.Instrucao  tom_get_slot_If_Instrucao1( gram.i.types.Instrucao  t) {return  t.getInstrucao1() ;}private static  gram.i.types.Instrucao  tom_get_slot_If_Instrucao2( gram.i.types.Instrucao  t) {return  t.getInstrucao2() ;}private static boolean tom_is_fun_sym_While( gram.i.types.Instrucao  t) {return  (t instanceof gram.i.types.instrucao.While) ;}private static  gram.i.types.LComentarios  tom_get_slot_While_c1( gram.i.types.Instrucao  t) {return  t.getc1() ;}private static  gram.i.types.LComentarios  tom_get_slot_While_c2( gram.i.types.Instrucao  t) {return  t.getc2() ;}private static  gram.i.types.LComentarios  tom_get_slot_While_c3( gram.i.types.Instrucao  t) {return  t.getc3() ;}private static  gram.i.types.Expressao  tom_get_slot_While_Condicao( gram.i.types.Instrucao  t) {return  t.getCondicao() ;}private static  gram.i.types.LComentarios  tom_get_slot_While_c4( gram.i.types.Instrucao  t) {return  t.getc4() ;}private static  gram.i.types.LComentarios  tom_get_slot_While_c5( gram.i.types.Instrucao  t) {return  t.getc5() ;}private static  gram.i.types.Instrucao  tom_get_slot_While_Instrucao( gram.i.types.Instrucao  t) {return  t.getInstrucao() ;}private static  gram.i.types.LComentarios  tom_get_slot_While_c6( gram.i.types.Instrucao  t) {return  t.getc6() ;}private static boolean tom_is_fun_sym_For( gram.i.types.Instrucao  t) {return  (t instanceof gram.i.types.instrucao.For) ;}private static  gram.i.types.LComentarios  tom_get_slot_For_c1( gram.i.types.Instrucao  t) {return  t.getc1() ;}private static  gram.i.types.LComentarios  tom_get_slot_For_c2( gram.i.types.Instrucao  t) {return  t.getc2() ;}private static  gram.i.types.Instrucao  tom_get_slot_For_Declaracao( gram.i.types.Instrucao  t) {return  t.getDeclaracao() ;}private static  gram.i.types.LComentarios  tom_get_slot_For_c3( gram.i.types.Instrucao  t) {return  t.getc3() ;}private static  gram.i.types.Expressao  tom_get_slot_For_Condicao( gram.i.types.Instrucao  t) {return  t.getCondicao() ;}private static  gram.i.types.LComentarios  tom_get_slot_For_c4( gram.i.types.Instrucao  t) {return  t.getc4() ;}private static  gram.i.types.LComentarios  tom_get_slot_For_c5( gram.i.types.Instrucao  t) {return  t.getc5() ;}private static  gram.i.types.Expressao  tom_get_slot_For_Expressao( gram.i.types.Instrucao  t) {return  t.getExpressao() ;}private static  gram.i.types.LComentarios  tom_get_slot_For_c6( gram.i.types.Instrucao  t) {return  t.getc6() ;}private static  gram.i.types.LComentarios  tom_get_slot_For_c7( gram.i.types.Instrucao  t) {return  t.getc7() ;}private static  gram.i.types.Instrucao  tom_get_slot_For_Instrucao( gram.i.types.Instrucao  t) {return  t.getInstrucao() ;}private static  gram.i.types.LComentarios  tom_get_slot_For_c8( gram.i.types.Instrucao  t) {return  t.getc8() ;}private static boolean tom_is_fun_sym_Return( gram.i.types.Instrucao  t) {return  (t instanceof gram.i.types.instrucao.Return) ;}private static  gram.i.types.LComentarios  tom_get_slot_Return_c1( gram.i.types.Instrucao  t) {return  t.getc1() ;}private static  gram.i.types.LComentarios  tom_get_slot_Return_c2( gram.i.types.Instrucao  t) {return  t.getc2() ;}private static  gram.i.types.Expressao  tom_get_slot_Return_Expressao( gram.i.types.Instrucao  t) {return  t.getExpressao() ;}private static  gram.i.types.LComentarios  tom_get_slot_Return_c3( gram.i.types.Instrucao  t) {return  t.getc3() ;}private static boolean tom_is_fun_sym_Funcao( gram.i.types.Instrucao  t) {return  (t instanceof gram.i.types.instrucao.Funcao) ;}private static  gram.i.types.LComentarios  tom_get_slot_Funcao_c1( gram.i.types.Instrucao  t) {return  t.getc1() ;}private static  gram.i.types.DefTipo  tom_get_slot_Funcao_DefTipo( gram.i.types.Instrucao  t) {return  t.getDefTipo() ;}private static  gram.i.types.LComentarios  tom_get_slot_Funcao_c2( gram.i.types.Instrucao  t) {return  t.getc2() ;}private static  String  tom_get_slot_Funcao_Nome( gram.i.types.Instrucao  t) {return  t.getNome() ;}private static  gram.i.types.LComentarios  tom_get_slot_Funcao_c3( gram.i.types.Instrucao  t) {return  t.getc3() ;}private static  gram.i.types.LComentarios  tom_get_slot_Funcao_c4( gram.i.types.Instrucao  t) {return  t.getc4() ;}private static  gram.i.types.Argumentos  tom_get_slot_Funcao_Argumentos( gram.i.types.Instrucao  t) {return  t.getArgumentos() ;}private static  gram.i.types.LComentarios  tom_get_slot_Funcao_c5( gram.i.types.Instrucao  t) {return  t.getc5() ;}private static  gram.i.types.LComentarios  tom_get_slot_Funcao_c6( gram.i.types.Instrucao  t) {return  t.getc6() ;}private static  gram.i.types.Instrucao  tom_get_slot_Funcao_Instrucao( gram.i.types.Instrucao  t) {return  t.getInstrucao() ;}private static  gram.i.types.LComentarios  tom_get_slot_Funcao_c7( gram.i.types.Instrucao  t) {return  t.getc7() ;}private static boolean tom_is_fun_sym_ListaArgumentos( gram.i.types.Argumentos  t) {return  ((t instanceof gram.i.types.argumentos.ConsListaArgumentos) || (t instanceof gram.i.types.argumentos.EmptyListaArgumentos)) ;}private static  gram.i.types.Argumentos  tom_empty_list_ListaArgumentos() { return  gram.i.types.argumentos.EmptyListaArgumentos.make() ;}private static  gram.i.types.Argumentos  tom_cons_list_ListaArgumentos( gram.i.types.Argumentos  e,  gram.i.types.Argumentos  l) { return  gram.i.types.argumentos.ConsListaArgumentos.make(e,l) ;}private static  gram.i.types.Argumentos  tom_get_head_ListaArgumentos_Argumentos( gram.i.types.Argumentos  l) {return  l.getHeadListaArgumentos() ;}private static  gram.i.types.Argumentos  tom_get_tail_ListaArgumentos_Argumentos( gram.i.types.Argumentos  l) {return  l.getTailListaArgumentos() ;}private static boolean tom_is_empty_ListaArgumentos_Argumentos( gram.i.types.Argumentos  l) {return  l.isEmptyListaArgumentos() ;}   private static   gram.i.types.Argumentos  tom_append_list_ListaArgumentos( gram.i.types.Argumentos  l1,  gram.i.types.Argumentos  l2) {     if( l1.isEmptyListaArgumentos() ) {       return l2;     } else if( l2.isEmptyListaArgumentos() ) {       return l1;     } else if( ((l1 instanceof gram.i.types.argumentos.ConsListaArgumentos) || (l1 instanceof gram.i.types.argumentos.EmptyListaArgumentos)) ) {       if(  l1.getTailListaArgumentos() .isEmptyListaArgumentos() ) {         return  gram.i.types.argumentos.ConsListaArgumentos.make( l1.getHeadListaArgumentos() ,l2) ;       } else {         return  gram.i.types.argumentos.ConsListaArgumentos.make( l1.getHeadListaArgumentos() ,tom_append_list_ListaArgumentos( l1.getTailListaArgumentos() ,l2)) ;       }     } else {       return  gram.i.types.argumentos.ConsListaArgumentos.make(l1,l2) ;     }   }   private static   gram.i.types.Argumentos  tom_get_slice_ListaArgumentos( gram.i.types.Argumentos  begin,  gram.i.types.Argumentos  end, gram.i.types.Argumentos  tail) {     if( (begin==end) ) {       return tail;     } else if( (end==tail)  && ( end.isEmptyListaArgumentos()  ||  (end==tom_empty_list_ListaArgumentos()) )) {       /* code to avoid a call to make, and thus to avoid looping during list-matching */       return begin;     }     return  gram.i.types.argumentos.ConsListaArgumentos.make((( ((begin instanceof gram.i.types.argumentos.ConsListaArgumentos) || (begin instanceof gram.i.types.argumentos.EmptyListaArgumentos)) )? begin.getHeadListaArgumentos() :begin),( gram.i.types.Argumentos )tom_get_slice_ListaArgumentos((( ((begin instanceof gram.i.types.argumentos.ConsListaArgumentos) || (begin instanceof gram.i.types.argumentos.EmptyListaArgumentos)) )? begin.getTailListaArgumentos() :tom_empty_list_ListaArgumentos()),end,tail)) ;   }   private static boolean tom_is_fun_sym_ListaDecl( gram.i.types.Declaracoes  t) {return  ((t instanceof gram.i.types.declaracoes.ConsListaDecl) || (t instanceof gram.i.types.declaracoes.EmptyListaDecl)) ;}private static  gram.i.types.Declaracoes  tom_empty_list_ListaDecl() { return  gram.i.types.declaracoes.EmptyListaDecl.make() ;}private static  gram.i.types.Declaracoes  tom_cons_list_ListaDecl( gram.i.types.Declaracoes  e,  gram.i.types.Declaracoes  l) { return  gram.i.types.declaracoes.ConsListaDecl.make(e,l) ;}private static  gram.i.types.Declaracoes  tom_get_head_ListaDecl_Declaracoes( gram.i.types.Declaracoes  l) {return  l.getHeadListaDecl() ;}private static  gram.i.types.Declaracoes  tom_get_tail_ListaDecl_Declaracoes( gram.i.types.Declaracoes  l) {return  l.getTailListaDecl() ;}private static boolean tom_is_empty_ListaDecl_Declaracoes( gram.i.types.Declaracoes  l) {return  l.isEmptyListaDecl() ;}   private static   gram.i.types.Declaracoes  tom_append_list_ListaDecl( gram.i.types.Declaracoes  l1,  gram.i.types.Declaracoes  l2) {     if( l1.isEmptyListaDecl() ) {       return l2;     } else if( l2.isEmptyListaDecl() ) {       return l1;     } else if( ((l1 instanceof gram.i.types.declaracoes.ConsListaDecl) || (l1 instanceof gram.i.types.declaracoes.EmptyListaDecl)) ) {       if(  l1.getTailListaDecl() .isEmptyListaDecl() ) {         return  gram.i.types.declaracoes.ConsListaDecl.make( l1.getHeadListaDecl() ,l2) ;       } else {         return  gram.i.types.declaracoes.ConsListaDecl.make( l1.getHeadListaDecl() ,tom_append_list_ListaDecl( l1.getTailListaDecl() ,l2)) ;       }     } else {       return  gram.i.types.declaracoes.ConsListaDecl.make(l1,l2) ;     }   }   private static   gram.i.types.Declaracoes  tom_get_slice_ListaDecl( gram.i.types.Declaracoes  begin,  gram.i.types.Declaracoes  end, gram.i.types.Declaracoes  tail) {     if( (begin==end) ) {       return tail;     } else if( (end==tail)  && ( end.isEmptyListaDecl()  ||  (end==tom_empty_list_ListaDecl()) )) {       /* code to avoid a call to make, and thus to avoid looping during list-matching */       return begin;     }     return  gram.i.types.declaracoes.ConsListaDecl.make((( ((begin instanceof gram.i.types.declaracoes.ConsListaDecl) || (begin instanceof gram.i.types.declaracoes.EmptyListaDecl)) )? begin.getHeadListaDecl() :begin),( gram.i.types.Declaracoes )tom_get_slice_ListaDecl((( ((begin instanceof gram.i.types.declaracoes.ConsListaDecl) || (begin instanceof gram.i.types.declaracoes.EmptyListaDecl)) )? begin.getTailListaDecl() :tom_empty_list_ListaDecl()),end,tail)) ;   }   private static boolean tom_is_fun_sym_SeqInstrucao( gram.i.types.Instrucao  t) {return  ((t instanceof gram.i.types.instrucao.ConsSeqInstrucao) || (t instanceof gram.i.types.instrucao.EmptySeqInstrucao)) ;}private static  gram.i.types.Instrucao  tom_empty_list_SeqInstrucao() { return  gram.i.types.instrucao.EmptySeqInstrucao.make() ;}private static  gram.i.types.Instrucao  tom_cons_list_SeqInstrucao( gram.i.types.Instrucao  e,  gram.i.types.Instrucao  l) { return  gram.i.types.instrucao.ConsSeqInstrucao.make(e,l) ;}private static  gram.i.types.Instrucao  tom_get_head_SeqInstrucao_Instrucao( gram.i.types.Instrucao  l) {return  l.getHeadSeqInstrucao() ;}private static  gram.i.types.Instrucao  tom_get_tail_SeqInstrucao_Instrucao( gram.i.types.Instrucao  l) {return  l.getTailSeqInstrucao() ;}private static boolean tom_is_empty_SeqInstrucao_Instrucao( gram.i.types.Instrucao  l) {return  l.isEmptySeqInstrucao() ;}   private static   gram.i.types.Instrucao  tom_append_list_SeqInstrucao( gram.i.types.Instrucao  l1,  gram.i.types.Instrucao  l2) {     if( l1.isEmptySeqInstrucao() ) {       return l2;     } else if( l2.isEmptySeqInstrucao() ) {       return l1;     } else if( ((l1 instanceof gram.i.types.instrucao.ConsSeqInstrucao) || (l1 instanceof gram.i.types.instrucao.EmptySeqInstrucao)) ) {       if(  l1.getTailSeqInstrucao() .isEmptySeqInstrucao() ) {         return  gram.i.types.instrucao.ConsSeqInstrucao.make( l1.getHeadSeqInstrucao() ,l2) ;       } else {         return  gram.i.types.instrucao.ConsSeqInstrucao.make( l1.getHeadSeqInstrucao() ,tom_append_list_SeqInstrucao( l1.getTailSeqInstrucao() ,l2)) ;       }     } else {       return  gram.i.types.instrucao.ConsSeqInstrucao.make(l1,l2) ;     }   }   private static   gram.i.types.Instrucao  tom_get_slice_SeqInstrucao( gram.i.types.Instrucao  begin,  gram.i.types.Instrucao  end, gram.i.types.Instrucao  tail) {     if( (begin==end) ) {       return tail;     } else if( (end==tail)  && ( end.isEmptySeqInstrucao()  ||  (end==tom_empty_list_SeqInstrucao()) )) {       /* code to avoid a call to make, and thus to avoid looping during list-matching */       return begin;     }     return  gram.i.types.instrucao.ConsSeqInstrucao.make((( ((begin instanceof gram.i.types.instrucao.ConsSeqInstrucao) || (begin instanceof gram.i.types.instrucao.EmptySeqInstrucao)) )? begin.getHeadSeqInstrucao() :begin),( gram.i.types.Instrucao )tom_get_slice_SeqInstrucao((( ((begin instanceof gram.i.types.instrucao.ConsSeqInstrucao) || (begin instanceof gram.i.types.instrucao.EmptySeqInstrucao)) )? begin.getTailSeqInstrucao() :tom_empty_list_SeqInstrucao()),end,tail)) ;   }    

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
			tom_make_TopDown(tom_make_countFunct()).visit(p);
		} catch(Exception e) {
			System.out.println("the strategy failed");
		}
	}
        private void startRefactCondNegat(Instrucao p){
            try {
			tom_make_TopDown(tom_make_refactCondNeg()).visit(p);
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
        public static class refactCondNeg extends tom.library.sl.AbstractStrategyBasic {public refactCondNeg() {super(tom_make_Identity());}public tom.library.sl.Visitable[] getChildren() {tom.library.sl.Visitable[] stratChildren = new tom.library.sl.Visitable[getChildCount()];stratChildren[0] = super.getChildAt(0);return stratChildren;}public tom.library.sl.Visitable setChildren(tom.library.sl.Visitable[] children) {super.setChildAt(0, children[0]);return this;}public int getChildCount() {return 1;}public tom.library.sl.Visitable getChildAt(int index) {switch (index) {case 0: return super.getChildAt(0);default: throw new IndexOutOfBoundsException();}}public tom.library.sl.Visitable setChildAt(int index, tom.library.sl.Visitable child) {switch (index) {case 0: return super.setChildAt(0, child);default: throw new IndexOutOfBoundsException();}}@SuppressWarnings("unchecked")public <T> T visitLight(T v, tom.library.sl.Introspector introspector) throws tom.library.sl.VisitFailure {if (tom_is_sort_Instrucao(v)) {return ((T)visit_Instrucao((( gram.i.types.Instrucao )v),introspector));}if (!(( null  == environment))) {return ((T)any.visit(environment,introspector));} else {return any.visitLight(v,introspector);}}@SuppressWarnings("unchecked")public  gram.i.types.Instrucao  _visit_Instrucao( gram.i.types.Instrucao  arg, tom.library.sl.Introspector introspector) throws tom.library.sl.VisitFailure {if (!(( null  == environment))) {return (( gram.i.types.Instrucao )any.visit(environment,introspector));} else {return any.visitLight(arg,introspector);}}@SuppressWarnings("unchecked")public  gram.i.types.Instrucao  visit_Instrucao( gram.i.types.Instrucao  tom__arg, tom.library.sl.Introspector introspector) throws tom.library.sl.VisitFailure {{{if (tom_is_sort_Instrucao(tom__arg)) {if (tom_is_sort_Instrucao((( gram.i.types.Instrucao )tom__arg))) {if (tom_is_fun_sym_If((( gram.i.types.Instrucao )(( gram.i.types.Instrucao )tom__arg)))) { gram.i.types.Expressao  tomMatch1_4=tom_get_slot_If_Condicao((( gram.i.types.Instrucao )tom__arg));if (tom_is_sort_Expressao(tomMatch1_4)) {if (tom_is_fun_sym_Nao((( gram.i.types.Expressao )tomMatch1_4))) {


                    return tom_make_If(tom_get_slot_If_c1((( gram.i.types.Instrucao )tom__arg)),tom_get_slot_If_c2((( gram.i.types.Instrucao )tom__arg)),tom_get_slot_If_c3((( gram.i.types.Instrucao )tom__arg)),tom_get_slot_Nao_Expressao(tomMatch1_4),tom_get_slot_If_c4((( gram.i.types.Instrucao )tom__arg)),tom_get_slot_If_c5((( gram.i.types.Instrucao )tom__arg)),tom_get_slot_If_Instrucao1((( gram.i.types.Instrucao )tom__arg)),tom_get_slot_If_Instrucao2((( gram.i.types.Instrucao )tom__arg)));
           	 	}}}}}}}return _visit_Instrucao(tom__arg,introspector);}}private static  tom.library.sl.Strategy  tom_make_refactCondNeg() { return new refactCondNeg();}public static class countFunct extends tom.library.sl.AbstractStrategyBasic {public countFunct() {super(tom_make_Identity());}public tom.library.sl.Visitable[] getChildren() {tom.library.sl.Visitable[] stratChildren = new tom.library.sl.Visitable[getChildCount()];stratChildren[0] = super.getChildAt(0);return stratChildren;}public tom.library.sl.Visitable setChildren(tom.library.sl.Visitable[] children) {super.setChildAt(0, children[0]);return this;}public int getChildCount() {return 1;}public tom.library.sl.Visitable getChildAt(int index) {switch (index) {case 0: return super.getChildAt(0);default: throw new IndexOutOfBoundsException();}}public tom.library.sl.Visitable setChildAt(int index, tom.library.sl.Visitable child) {switch (index) {case 0: return super.setChildAt(0, child);default: throw new IndexOutOfBoundsException();}}@SuppressWarnings("unchecked")public <T> T visitLight(T v, tom.library.sl.Introspector introspector) throws tom.library.sl.VisitFailure {if (tom_is_sort_LComentarios(v)) {return ((T)visit_LComentarios((( gram.i.types.LComentarios )v),introspector));}if (tom_is_sort_Expressao(v)) {return ((T)visit_Expressao((( gram.i.types.Expressao )v),introspector));}if (tom_is_sort_Instrucao(v)) {return ((T)visit_Instrucao((( gram.i.types.Instrucao )v),introspector));}if (tom_is_sort_DefTipo(v)) {return ((T)visit_DefTipo((( gram.i.types.DefTipo )v),introspector));}if (!(( null  == environment))) {return ((T)any.visit(environment,introspector));} else {return any.visitLight(v,introspector);}}@SuppressWarnings("unchecked")public  gram.i.types.DefTipo  _visit_DefTipo( gram.i.types.DefTipo  arg, tom.library.sl.Introspector introspector) throws tom.library.sl.VisitFailure {if (!(( null  == environment))) {return (( gram.i.types.DefTipo )any.visit(environment,introspector));} else {return any.visitLight(arg,introspector);}}@SuppressWarnings("unchecked")public  gram.i.types.Instrucao  _visit_Instrucao( gram.i.types.Instrucao  arg, tom.library.sl.Introspector introspector) throws tom.library.sl.VisitFailure {if (!(( null  == environment))) {return (( gram.i.types.Instrucao )any.visit(environment,introspector));} else {return any.visitLight(arg,introspector);}}@SuppressWarnings("unchecked")public  gram.i.types.Expressao  _visit_Expressao( gram.i.types.Expressao  arg, tom.library.sl.Introspector introspector) throws tom.library.sl.VisitFailure {if (!(( null  == environment))) {return (( gram.i.types.Expressao )any.visit(environment,introspector));} else {return any.visitLight(arg,introspector);}}@SuppressWarnings("unchecked")public  gram.i.types.LComentarios  _visit_LComentarios( gram.i.types.LComentarios  arg, tom.library.sl.Introspector introspector) throws tom.library.sl.VisitFailure {if (!(( null  == environment))) {return (( gram.i.types.LComentarios )any.visit(environment,introspector));} else {return any.visitLight(arg,introspector);}}@SuppressWarnings("unchecked")public  gram.i.types.DefTipo  visit_DefTipo( gram.i.types.DefTipo  tom__arg, tom.library.sl.Introspector introspector) throws tom.library.sl.VisitFailure {{{if (tom_is_sort_DefTipo(tom__arg)) {if (tom_is_sort_DefTipo((( gram.i.types.DefTipo )tom__arg))) {if (tom_is_fun_sym_DInt((( gram.i.types.DefTipo )(( gram.i.types.DefTipo )tom__arg)))) {




































































































































































				auxFunc.adicionaOperador("Int");
			}}}}{if (tom_is_sort_DefTipo(tom__arg)) {if (tom_is_sort_DefTipo((( gram.i.types.DefTipo )tom__arg))) {if (tom_is_fun_sym_DChar((( gram.i.types.DefTipo )(( gram.i.types.DefTipo )tom__arg)))) {


				auxFunc.adicionaOperador("Char");
			}}}}{if (tom_is_sort_DefTipo(tom__arg)) {if (tom_is_sort_DefTipo((( gram.i.types.DefTipo )tom__arg))) {if (tom_is_fun_sym_DBoolean((( gram.i.types.DefTipo )(( gram.i.types.DefTipo )tom__arg)))) {


				auxFunc.adicionaOperador("Boolean");
			}}}}{if (tom_is_sort_DefTipo(tom__arg)) {if (tom_is_sort_DefTipo((( gram.i.types.DefTipo )tom__arg))) {if (tom_is_fun_sym_DFloat((( gram.i.types.DefTipo )(( gram.i.types.DefTipo )tom__arg)))) {


				auxFunc.adicionaOperador("Float");
			}}}}{if (tom_is_sort_DefTipo(tom__arg)) {if (tom_is_sort_DefTipo((( gram.i.types.DefTipo )tom__arg))) {if (tom_is_fun_sym_DVoid((( gram.i.types.DefTipo )(( gram.i.types.DefTipo )tom__arg)))) {


				auxFunc.adicionaOperador("Void");
			}}}}}return _visit_DefTipo(tom__arg,introspector);}@SuppressWarnings("unchecked")public  gram.i.types.LComentarios  visit_LComentarios( gram.i.types.LComentarios  tom__arg, tom.library.sl.Introspector introspector) throws tom.library.sl.VisitFailure {{{if (tom_is_sort_LComentarios(tom__arg)) {if (tom_is_sort_LComentarios((( gram.i.types.LComentarios )tom__arg))) {if (tom_is_fun_sym_Comentario((( gram.i.types.LComentarios )(( gram.i.types.LComentarios )tom__arg)))) {     auxFunc.incComentarios();    }}}}}return _visit_LComentarios(tom__arg,introspector);}@SuppressWarnings("unchecked")public  gram.i.types.Expressao  visit_Expressao( gram.i.types.Expressao  tom__arg, tom.library.sl.Introspector introspector) throws tom.library.sl.VisitFailure {{{if (tom_is_sort_Expressao(tom__arg)) {if (tom_is_sort_Expressao((( gram.i.types.Expressao )tom__arg))) {if (tom_is_fun_sym_Id((( gram.i.types.Expressao )(( gram.i.types.Expressao )tom__arg)))) {     auxFunc.adicionaOperando(tom_get_slot_Id_Id((( gram.i.types.Expressao )tom__arg)));                 auxFunc.incLocalVars(auxFunc.getNome());    }}}}{if (tom_is_sort_Expressao(tom__arg)) {if (tom_is_sort_Expressao((( gram.i.types.Expressao )tom__arg))) {if (tom_is_fun_sym_Call((( gram.i.types.Expressao )(( gram.i.types.Expressao )tom__arg)))) {     auxFunc.incLines(1);     auxFunc.adicionaOperador(";");     auxFunc.adicionaOperador(tom_get_slot_Call_Id((( gram.i.types.Expressao )tom__arg)));    }}}}{if (tom_is_sort_Expressao(tom__arg)) {if (tom_is_sort_Expressao((( gram.i.types.Expressao )tom__arg))) {if (tom_is_fun_sym_Input((( gram.i.types.Expressao )(( gram.i.types.Expressao )tom__arg)))) {     auxFunc.incLines(1);     auxFunc.adicionaOperador(";");    }}}}{if (tom_is_sort_Expressao(tom__arg)) {if (tom_is_sort_Expressao((( gram.i.types.Expressao )tom__arg))) {if (tom_is_fun_sym_Print((( gram.i.types.Expressao )(( gram.i.types.Expressao )tom__arg)))) {     auxFunc.incLines(1);     auxFunc.adicionaOperador(";");    }}}}{if (tom_is_sort_Expressao(tom__arg)) {if (tom_is_sort_Expressao((( gram.i.types.Expressao )tom__arg))) {if (tom_is_fun_sym_Int((( gram.i.types.Expressao )(( gram.i.types.Expressao )tom__arg)))) {     auxFunc.adicionaOperando(Integer.toString(tom_get_slot_Int_Int((( gram.i.types.Expressao )tom__arg))));    }}}}{if (tom_is_sort_Expressao(tom__arg)) {if (tom_is_sort_Expressao((( gram.i.types.Expressao )tom__arg))) {if (tom_is_fun_sym_Char((( gram.i.types.Expressao )(( gram.i.types.Expressao )tom__arg)))) {     auxFunc.adicionaOperando(tom_get_slot_Char_Char((( gram.i.types.Expressao )tom__arg)));    }}}}{if (tom_is_sort_Expressao(tom__arg)) {if (tom_is_sort_Expressao((( gram.i.types.Expressao )tom__arg))) {if (tom_is_fun_sym_True((( gram.i.types.Expressao )(( gram.i.types.Expressao )tom__arg)))) {     auxFunc.adicionaOperando("True");    }}}}{if (tom_is_sort_Expressao(tom__arg)) {if (tom_is_sort_Expressao((( gram.i.types.Expressao )tom__arg))) {if (tom_is_fun_sym_False((( gram.i.types.Expressao )(( gram.i.types.Expressao )tom__arg)))) {     auxFunc.adicionaOperando("False");    }}}}{if (tom_is_sort_Expressao(tom__arg)) {if (tom_is_sort_Expressao((( gram.i.types.Expressao )tom__arg))) {if (tom_is_fun_sym_Float((( gram.i.types.Expressao )(( gram.i.types.Expressao )tom__arg)))) {     auxFunc.adicionaOperando(Integer.toString(tom_get_slot_Float_num((( gram.i.types.Expressao )tom__arg))));    }}}}{if (tom_is_sort_Expressao(tom__arg)) {if (tom_is_sort_Expressao((( gram.i.types.Expressao )tom__arg))) {if (tom_is_fun_sym_Nao((( gram.i.types.Expressao )(( gram.i.types.Expressao )tom__arg)))) {     auxFunc.adicionaOperador("!");     auxFunc.addNao();    }}}}{if (tom_is_sort_Expressao(tom__arg)) {if (tom_is_sort_Expressao((( gram.i.types.Expressao )tom__arg))) {if (tom_is_fun_sym_Ou((( gram.i.types.Expressao )(( gram.i.types.Expressao )tom__arg)))) {     auxFunc.adicionaOperador("||");     auxFunc.incMcCabe();    }}}}{if (tom_is_sort_Expressao(tom__arg)) {if (tom_is_sort_Expressao((( gram.i.types.Expressao )tom__arg))) {if (tom_is_fun_sym_E((( gram.i.types.Expressao )(( gram.i.types.Expressao )tom__arg)))) {     auxFunc.adicionaOperador("&&");     auxFunc.incMcCabe();    }}}}}return _visit_Expressao(tom__arg,introspector);}@SuppressWarnings("unchecked")public  gram.i.types.Instrucao  visit_Instrucao( gram.i.types.Instrucao  tom__arg, tom.library.sl.Introspector introspector) throws tom.library.sl.VisitFailure {{{if (tom_is_sort_Instrucao(tom__arg)) {if (tom_is_sort_Instrucao((( gram.i.types.Instrucao )tom__arg))) {if (tom_is_fun_sym_Funcao((( gram.i.types.Instrucao )(( gram.i.types.Instrucao )tom__arg)))) { String  tom_nome=tom_get_slot_Funcao_Nome((( gram.i.types.Instrucao )tom__arg));      int nArgs = contaArgumentos(tom_get_slot_Funcao_Argumentos((( gram.i.types.Instrucao )tom__arg)));          auxFunc = new Funcao(tom_nome, nArgs);      for(int i=0; i<nArgs-1; i++){      auxFunc.adicionaOperador(",");     }      auxFunc.adicionaOperador(tom_nome);     auxFunc.adicionaOperador("(");     auxFunc.adicionaOperador(")");     auxFunc.adicionaOperador("{");     auxFunc.adicionaOperador("}");      funcs.put(auxFunc.getNome(), auxFunc);      auxFunc.incLines(1);    }}}}{if (tom_is_sort_Instrucao(tom__arg)) {if (tom_is_sort_Instrucao((( gram.i.types.Instrucao )tom__arg))) {if (tom_is_fun_sym_Declaracao((( gram.i.types.Instrucao )(( gram.i.types.Instrucao )tom__arg)))) {      resolveDecls(tom_get_slot_Declaracao_Declaracoes((( gram.i.types.Instrucao )tom__arg)));      auxFunc.incLines(1);     auxFunc.adicionaOperador(";");    }}}}{if (tom_is_sort_Instrucao(tom__arg)) {if (tom_is_sort_Instrucao((( gram.i.types.Instrucao )tom__arg))) {if (tom_is_fun_sym_Atribuicao((( gram.i.types.Instrucao )(( gram.i.types.Instrucao )tom__arg)))) { gram.i.types.OpAtribuicao  tom_op=tom_get_slot_Atribuicao_op((( gram.i.types.Instrucao )tom__arg));      if(tom_op== tom_make_Atrib()){      auxFunc.adicionaOperador("=");     }     else if(tom_op== tom_make_Mult()){      auxFunc.adicionaOperador("*=");     }     else if(tom_op== tom_make_Div()){      auxFunc.adicionaOperador("/=");     }     else if(tom_op== tom_make_Soma()){      auxFunc.adicionaOperador("+=");     }     else{      auxFunc.adicionaOperador("-=");     }      auxFunc.incLines(1);     auxFunc.adicionaOperador(";");    }}}}{if (tom_is_sort_Instrucao(tom__arg)) {if (tom_is_sort_Instrucao((( gram.i.types.Instrucao )tom__arg))) {if (tom_is_fun_sym_Return((( gram.i.types.Instrucao )(( gram.i.types.Instrucao )tom__arg)))) {     auxFunc.incLines(1);     auxFunc.adicionaOperador(";");     auxFunc.adicionaOperador("Return");    }}}}{if (tom_is_sort_Instrucao(tom__arg)) {if (tom_is_sort_Instrucao((( gram.i.types.Instrucao )tom__arg))) {if (tom_is_fun_sym_If((( gram.i.types.Instrucao )(( gram.i.types.Instrucao )tom__arg)))) {     auxFunc.incLines(1);     auxFunc.incIfs();      if(tom_get_slot_If_Instrucao2((( gram.i.types.Instrucao )tom__arg))!= tom_empty_list_SeqInstrucao()){      auxFunc.adicionaOperador("Else");     }      auxFunc.adicionaOperador("If");     auxFunc.adicionaOperador(")");     auxFunc.adicionaOperador("(");      auxFunc.incMcCabe();    }}}}{if (tom_is_sort_Instrucao(tom__arg)) {if (tom_is_sort_Instrucao((( gram.i.types.Instrucao )tom__arg))) {if (tom_is_fun_sym_While((( gram.i.types.Instrucao )(( gram.i.types.Instrucao )tom__arg)))) {     auxFunc.incLines(1);     auxFunc.incWhiles();     auxFunc.adicionaOperador("While");     auxFunc.adicionaOperador(")");     auxFunc.adicionaOperador("(");      }}}}{if (tom_is_sort_Instrucao(tom__arg)) {if (tom_is_sort_Instrucao((( gram.i.types.Instrucao )tom__arg))) {if (tom_is_fun_sym_For((( gram.i.types.Instrucao )(( gram.i.types.Instrucao )tom__arg)))) {     auxFunc.incLines(1);     auxFunc.incFors();     auxFunc.adicionaOperador("For");     auxFunc.adicionaOperador(")");     auxFunc.adicionaOperador("(");      }}}}}return _visit_Instrucao(tom__arg,introspector);}}private static  tom.library.sl.Strategy  tom_make_countFunct() { return new countFunct();}



	private static int contaArgumentos(Argumentos args){
		{{if (tom_is_sort_Argumentos(args)) {if (tom_is_fun_sym_ListaArgumentos((( gram.i.types.Argumentos )(( gram.i.types.Argumentos )args)))) {if (!( ( tom_is_empty_ListaArgumentos_Argumentos((( gram.i.types.Argumentos )args)) || tom_equal_term_Argumentos((( gram.i.types.Argumentos )args), tom_empty_list_ListaArgumentos()) ) )) {

				return contaArgumentos(((tom_is_fun_sym_ListaArgumentos((( gram.i.types.Argumentos )args)))?(tom_get_head_ListaArgumentos_Argumentos((( gram.i.types.Argumentos )args))):((( gram.i.types.Argumentos )args)))) + contaArgumentos(((tom_is_fun_sym_ListaArgumentos((( gram.i.types.Argumentos )args)))?(tom_get_tail_ListaArgumentos_Argumentos((( gram.i.types.Argumentos )args))):(tom_empty_list_ListaArgumentos())));
			}}}}{if (tom_is_sort_Argumentos(args)) {if (tom_is_sort_Argumentos((( gram.i.types.Argumentos )args))) {if (tom_is_fun_sym_Argumento((( gram.i.types.Argumentos )(( gram.i.types.Argumentos )args)))) {



				auxFunc.adicionaOperando(tom_get_slot_Argumento_Id((( gram.i.types.Argumentos )args)));

				return 1;
			}}}}}

		return 0;
	}

	private static void resolveDecls(Declaracoes decls){
		{{if (tom_is_sort_Declaracoes(decls)) {if (tom_is_sort_Declaracoes((( gram.i.types.Declaracoes )decls))) {if (tom_is_fun_sym_Decl((( gram.i.types.Declaracoes )(( gram.i.types.Declaracoes )decls)))) { gram.i.types.Expressao  tom_exp=tom_get_slot_Decl_Expressao((( gram.i.types.Declaracoes )decls));

				auxFunc.adicionaOperando(tom_get_slot_Decl_Id((( gram.i.types.Declaracoes )decls)));

				if(tom_exp!= tom_make_Empty()){
					auxFunc.adicionaOperador("=");
				}

				resolveExpr(tom_exp);
			}}}}{if (tom_is_sort_Declaracoes(decls)) {if (tom_is_fun_sym_ListaDecl((( gram.i.types.Declaracoes )(( gram.i.types.Declaracoes )decls)))) {if (!( ( tom_is_empty_ListaDecl_Declaracoes((( gram.i.types.Declaracoes )decls)) || tom_equal_term_Declaracoes((( gram.i.types.Declaracoes )decls), tom_empty_list_ListaDecl()) ) )) {

				resolveDecls(((tom_is_fun_sym_ListaDecl((( gram.i.types.Declaracoes )decls)))?(tom_get_head_ListaDecl_Declaracoes((( gram.i.types.Declaracoes )decls))):((( gram.i.types.Declaracoes )decls))));
				resolveDecls(((tom_is_fun_sym_ListaDecl((( gram.i.types.Declaracoes )decls)))?(tom_get_tail_ListaDecl_Declaracoes((( gram.i.types.Declaracoes )decls))):(tom_empty_list_ListaDecl())));
			}}}}}

	}

	private static void resolveExpr(Expressao exp){
		{{if (tom_is_sort_Expressao(exp)) {if (tom_is_sort_Expressao((( gram.i.types.Expressao )exp))) {if (tom_is_fun_sym_Id((( gram.i.types.Expressao )(( gram.i.types.Expressao )exp)))) {

				auxFunc.adicionaOperando(tom_get_slot_Id_Id((( gram.i.types.Expressao )exp)));
			}}}}{if (tom_is_sort_Expressao(exp)) {if (tom_is_sort_Expressao((( gram.i.types.Expressao )exp))) {if (tom_is_fun_sym_Input((( gram.i.types.Expressao )(( gram.i.types.Expressao )exp)))) {


				auxFunc.adicionaOperador("Input");
			}}}}{if (tom_is_sort_Expressao(exp)) {if (tom_is_sort_Expressao((( gram.i.types.Expressao )exp))) {if (tom_is_fun_sym_Print((( gram.i.types.Expressao )(( gram.i.types.Expressao )exp)))) {


				auxFunc.adicionaOperador("Print");
			}}}}}

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


