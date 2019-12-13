package es;


public class Metrica {
	
	/**
	 * O atributo nome será o nome da metrica,
	 * o atributo operadorLogic será o operador logico,
	 * O atributo valor será o valor da metrica.
	 */	
	private String nome;
	private int operadorLogic;
	private int valor;
	
	/**
	 * @param nome é o nome da metrica
	 * @param operadorLogic é o operador logico
	 * @param valor é o valor da metrica
	 * O construtor da nossa métrica a inicializar os nossos atributos.
	 */
	public Metrica(String nome,int operadorLogic,int valor) {
		this.nome=nome;
		this.operadorLogic=operadorLogic;
		this.valor=valor;
	}
	
	/**
	 * @param nome é o parametro que representará o nome da metrica.
	 * O construtor so com o parametro nome
	 */
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
	
	/**
	 * @return Esta funçao retorna-nos a string a representar o maior ou menor, dependendo do valor
	 * do operador, cajo seja 1 retorna maior e caso contrario retorna menor.
	 */
	public String getOperador(){
		if(this.operadorLogic==0){
			return "menor";
		}else
			return "maior";
	}
	
	
	
	
	
}
