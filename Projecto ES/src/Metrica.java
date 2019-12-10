
public class Metrica {
	


	private String nome;
	private int operadorLogic;
	private int valor;

	public Metrica(String nome,int operadorLogic,int valor) {
		this.nome=nome;
		this.operadorLogic=operadorLogic;
		this.valor=valor;
	}
	
	public Metrica(String nome) {
		this.nome=nome;
	}
	
	//Valores para operadorLogic
	// 0 - <
	// 1 - >
	
	
	//nome tem de ser LOC ou CYCLO ou LAA ou CD

	public String getNome() {
		return nome;
	}


	public void setOperadorLogic(int operadorLogic) {
		this.operadorLogic = operadorLogic;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public String getOperador(){
		if(this.operadorLogic==0){
			return "menor";
		}else
			return "maior";
	}
	
	
	
	
	
}
