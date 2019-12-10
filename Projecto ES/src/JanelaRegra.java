import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class JanelaRegra {

	private static JFrame janela;
	private JButton criarRegra;
	private JButton editarRegra;
	private Menu myMenu;
	private static DefaultListModel<Regra> model = new DefaultListModel<>();
	private JList<Regra> lista = new JList<Regra>(model);
	private JScrollPane scroll = new JScrollPane(lista);

	// Na Jlist adicionar objectos Regras

	public JanelaRegra() {
		janela = new JFrame();
		janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		janela.setSize(300, 250);
	}

	// Tem de se dar um arraylist com as regras para poder selecionar ou
	// adicionar regras

	public void open() {
		janela.setTitle("Regras");

		janela.setLayout(new GridLayout(3, 1));

		// janela.add(lista);
		// DefaultListModel r = Menu.getModelList();
		// System.out.println(r);
		// lista= new JList<Regra>();
		// lista.setModel(r);
		// janela.getContentPane().add(new JScrollPane(lista));
		janela.add(scroll);

		editarRegra = new JButton("Editar regra");
		janela.getContentPane().add(editarRegra);

		editarRegra.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (lista.getSelectedValue() != null) {
					System.out.println("Regra selecionada: " + lista.getSelectedValue().toString());
					System.out.println("Valor regra Selecionada: "+ lista.getSelectedValue().getValoresMetricas());
					JanelaEdita j = new JanelaEdita(lista.getSelectedValue());
					j.open();
				}
			}
		});

		criarRegra = new JButton("Criar regra");
		janela.add(criarRegra);
		criarRegra.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JanelaCriaRegra j = new JanelaCriaRegra();
				j.open();
			}
		});

		janela.setVisible(true);
	}

	public void addElementList(Regra regra) {
		// model.addElement(regra);
		// DefaultListModel r = Menu.getModelList();
		// r.addElement(regra);
		// Menu.setModelList(r);
		// for(int i=0;i<r.getSize();i++){
		// System.out.println("ModelList "+r.get(i));
		// }
		// lista.setModel(r);
		// System.out.println("Lista: "+lista);
		this.model.addElement(regra);
		for (int i = 0; i < this.model.getSize(); i++) {
			System.out.println("ModelList " + this.model.get(i));
		}

	}
	
	public void removeElementModelList(Regra r){
		for(int i=0;i<this.model.getSize();i++){
			if(this.model.get(i).equals(r)){
				this.model.removeElement(this.model.get(i));
			}
		}
	}

	public static void main(String[] args) {
		// JanelaRegra j = new JanelaRegra();
		// DefaultListModel<Regra> n = new DefaultListModel<Regra>();
		// n.addElement(new Regra(1));
		// n.addElement(new Regra(2));
		// j.janelaRegras(n);
	}

}
