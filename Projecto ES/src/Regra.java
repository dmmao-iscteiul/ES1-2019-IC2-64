import java.util.ArrayList;

public class Regra {
	
	private ArrayList<Metrica> listaMetricas;

	public Regra() {
		this.listaMetricas = new ArrayList<>();
	}

	public Regra(Metrica met1,Metrica met2) {
		this.listaMetricas = new ArrayList<>();
		this.listaMetricas.add(met1);
		this.listaMetricas.add(met2);
	}
	
	public void addMetricas(Metrica m) {
		for (int i= 0; i <= listaMetricas.size(); i++) {
			listaMetricas.add(m);
		}
	}
	
	
	
}
