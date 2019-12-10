import java.util.ArrayList;

public class Regra {
	
	private ArrayList<Metrica> listaMetricas;
	private static String nome;

	public Regra(String nome,Metrica met1,Metrica met2) {
		this.nome=nome;
		this.listaMetricas = new ArrayList<>();
		this.listaMetricas.add(met1);
		this.listaMetricas.add(met2);
	}
	
	public Regra(String nome,Metrica met1) {
		this.nome=nome;
		this.listaMetricas = new ArrayList<>();
		this.listaMetricas.add(met1);
	}
	
	public Regra(String nome) {
		this.nome=nome;
	}
	
	public void addMetricas(Metrica m) {
		for (int i= 0; i <= listaMetricas.size(); i++) {
			listaMetricas.add(m);
		}
	}
	
	public int numeroDeMetricas(){
		return listaMetricas.size();
	}
	
	public Metrica getMetricas(int indice){
		return this.listaMetricas.get(indice);
	}
	
	@Override
	public String toString() {
		return nome;
	}
	
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
	
	
	
}
