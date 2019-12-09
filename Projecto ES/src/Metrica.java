
public class Metrica {
	


	private String nome;
	private int operadorLogic;
	private int valor;

	public Metrica(String nome,int operadorLogic,int valor) {
		this.nome=nome;
		this.operadorLogic=operadorLogic;
		this.valor=valor;
	}

	public String getNome() {
		return nome;
	}


	public int getOperadorLogic() {
		return operadorLogic;
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
	
	
	
	
	
}
