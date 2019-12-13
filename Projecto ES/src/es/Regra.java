package es;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.Icon;

/**
 * @author Grupo64 ES
 */

public class Regra {

	private ArrayList<Metrica> listaMetricas;
	private String nome;
	private Vector<String> resultadoRegra; //literalmente o true e false como no PMD e IPLASMA
	private int operadorEntreMetricas;
	
	/**
	 * @param nome sera o nome da nosssa regra
	 * @param met1 sera a metrica recebida pelo construtor
	 * @param met2 sera a metrica recebida pelo construtor
	 * @param operadorEntreMetricas sera um inteiro entre 0 e 1 que representa o && ou ||
	 */
	
	public Regra(String nome,Metrica met1,Metrica met2, int operadorEntreMetricas) {
		this.nome=nome;
		this.listaMetricas = new ArrayList<Metrica>();
		this.listaMetricas.add(met1);
		this.listaMetricas.add(met2);
		this.operadorEntreMetricas = operadorEntreMetricas;
	}
	
	/**
	 * @param nome vai ser o nome da nossa regra
	 * @param met1 sera a metrica recebida pela regra
	 */
	public Regra(String nome,Metrica met1) {
		this.nome=nome;
		this.listaMetricas = new ArrayList<Metrica>();
		this.listaMetricas.add(met1);
	}
	/** 
	 * @param nome é o nome da nossa regra
	 */
	public Regra(String nome) {
		this.nome=nome;
	}
	 
	/**
	 * @param excel é o ficheiro nosso ficheiro excel que vamos analisar
	 * 
	 * @return Este metodo prenncherVetor começa por verficar se a nossa lista das metricas
	 * é compostos por 1 ou 2 elementos, se for com um unico elemento, essa funçao chama a funçao
	 * verificarMetricas() que verifica se é esta metrica é LOC, CYCLO, LAA, ATFD, depois disto é
	 * chamada a funçao VerificarOperador que irá fazer a deteçao de defeitos, comparando a respetiva
	 * coluna do ficheiro com os valores colocados pelo utilizador e esta mesma função vai
	 * adicionando a nosssa lista de String o true e false e por fim coloca-nos o resultado na
	 * lista resultadoRegra.
	 */
	
	//Acrescentei: Descobre se tem uma ou duas metricas para ir preencher o seu vetorResultado com true ou false
		public Vector<String> preencherVetor(Excel excel) {
			Vector<String> temp = new Vector<String>();
			if(listaMetricas.size()==1) {
				temp = verificarMetricas(excel, listaMetricas.get(0), 0);
				System.out.println("Tamanho da Lista com 1 Metrica " + temp.size());
				setVetorResultado(temp);
			}
			
			else if(listaMetricas.size()==2) {
				Vector<String> temp1 = verificarMetricas(excel, listaMetricas.get(0),0);
				System.out.println("Tamanho da lista da primeira metrica " + temp1.size());
				Vector<String> temp2 = verificarMetricas(excel, listaMetricas.get(1),1);
				temp = operadorEntreMetricas(temp1, temp2, operadorEntreMetricas);
				System.out.println("Tamanho da lista da segunda metrica " + temp2.size());
			}
			return temp;
		}
		/**
		 * @param temp1 é vetor de String com TRUE e FALSE de uma das metricas
		 * @param temp2 é vetor de String com TRUE e FALSE de outra metrica
		 * @param operadorEntreMetricas sera um inteiro entre 0 e 1 que representa o && ou ||
		 * @return está funcao verifica se o operadorEntreMetricas é um && ou || , depois caso seja um &&,
		 * a funçao percorre e vai ver as posiçoes em que é diferente e altera para FALSE, 
		 * Caso seja um || verifica se for diferente adiciona TRUE,
		 * o temp1 será o vetor com os TRUE, FALSE das duas métricas com o operador.
		 */
		private Vector<String> operadorEntreMetricas(Vector<String> temp1, Vector<String> temp2, int operadorEntreMetricas){
			if(operadorEntreMetricas == 1){
				for(int i = 0; i<temp1.size(); i++){
					if(!temp1.get(i).equals(temp2.get(i))){
						temp1.set(i, "FALSE");
					}	
				}
			}
			else if(operadorEntreMetricas == 0){
				for(int i = 0; i<temp2.size(); i++){
					if(!temp1.get(i).equals(temp2.get(i))){
						temp1.set(i, "TRUE");
					}
				}
			}
			return temp1;
		}
		
		  /*Está função ja foi referenciada no javadoc*/
		private Vector<String> verificarMetricas(Excel excel, Metrica metrica, int indiceMetrica) {
			Vector<String> passo2 = new Vector<String>();
			int numero = listaMetricas.get(0).getValor();
			if(metrica.getNome().equals("LOC")){
				passo2 = verificarOperador(excel.getColumnString(4), numero, indiceMetrica);
			}

			else if(metrica.getNome().equals("CYCLO")){
				passo2 = verificarOperador(excel.getColumnString(5), numero, indiceMetrica);
			}

			else if(metrica.getNome().equals("ATFD")){
				passo2 = verificarOperador(excel.getColumnString(5), numero, indiceMetrica);
			}

			else if(metrica.getNome().equals("LAA")){
				 passo2 = verificarOperador(excel.getColumnString(6), numero, indiceMetrica);
			}
			return(passo2);
		}
		
		
		/*Está função ja foi referenciada no javadoc*/
		private Vector<String> verificarOperador(Vector<String> aux, int numero, int indiceMetrica) {
			System.out.println(listaMetricas.get(indiceMetrica) + listaMetricas.get(indiceMetrica).getOperador());
			Vector<String> passo3 = new Vector<String>();
			if(this.listaMetricas.get(indiceMetrica).getOperador().equals("menor")) {
				for(String s : aux) {
					if(Double.parseDouble(s) < numero) {
						String true1= "TRUE";
						passo3.add(true1);
					}
					else if(Double.parseDouble(s) >= numero){
						passo3.add("FALSE");
					}
				}
			}

			else if(this.listaMetricas.get(indiceMetrica).getOperador().equals("maior")) {
				for(String s : aux) {
					if(Double.parseDouble(s) > numero) {
						passo3.add("TRUE");
					}
					else if(Double.parseDouble(s) <= numero) {
						passo3.add("FALSE");
					}
				}
			}
			return passo3;
		}

	/**
	 * @param m é a metrica que vamos adicionar a nossa lista
	 */
	public void addMetricas(Metrica m) {
			listaMetricas.add(m);
	}
	/**
	 * @return está função retorna-nos a lista das metricas
	 */
	public int numeroDeMetricas(){
		return listaMetricas.size();
	}
	
	/**
	 *  @return está função retorna-nos a metrica num determinado indice
	 */
	
	public Metrica getMetricas(int indice){
		return this.listaMetricas.get(indice);
	}
	

	public String toString() {
		return nome;
	}
	
	 /**
	  * @return esta função retorna-nos a lista de Integer com o valor das metricas
	  */
	public ArrayList<Integer> getValoresMetricas(){
		ArrayList<Integer> ola = new ArrayList<Integer>();
		if(listaMetricas.size()==2){
			ola.add(this.listaMetricas.get(0).getValor());
			ola.add(this.listaMetricas.get(1).getValor());
			
		}else{
			ola.add(this.listaMetricas.get(0).getValor());
		}
		return ola;
	}

	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setVetorResultado(Vector<String> resultado) {
		this.resultadoRegra = resultado;
	}
	
	/**
	 * @param excel é o ficheiro excel que iremos analisar
	 * @return Caso seja IPlasma ou PMD a funcao busca apenas a lista resultadoRegra,
	 * caso seja uma regra criada pelo utilizador então vai chamar a funçao preencherVetor().
	 */
	public Vector<String> getVectorResultado(Excel excel){
		if(this.nome.equals("IPlasma") || this.nome.equals("PMD")) {
			return this.resultadoRegra;
		}
		else {
			return preencherVetor(excel);
		
		}
	}
	
	/**
	 * @return esta funçao caso seja o IPlasma ou PMD, obtem como referencia de comparaçao 
	 * is_long_method,
	 * caso seja qualquer das regras criadas pelo user então a referencia será is_feature_envy.
	 */
	public String getValorReferencia() {
		String result = null;
		if(nome.equals("IPlasma") || nome.equals("PMD")) {
			result = "is_long_method";
			return result;
		}
	
		for(Metrica m : listaMetricas) {
			if(m.getNome().equals("LOC") || m.getNome().equals("CYCLO")) {
				result = "is_long_method";
			}
			else if(m.getNome().equals("ATFD") || m.getNome().equals("LAA")) {
				result = "is_feature_envy";
			}
		}
		return result;
	}

}
