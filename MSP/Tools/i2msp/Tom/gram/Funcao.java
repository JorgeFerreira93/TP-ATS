
import java.util.HashMap;

public class Funcao{

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
}