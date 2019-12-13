package es;

import java.awt.FlowLayout;
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
	private JList<Regra> lista;
	private JScrollPane scroll;
	private DefaultListModel<Regra> aux;

	private JanelaRegra me = this;

	public JanelaRegra(Menu myMenu) {
		this.myMenu = myMenu;
		removeFerramentas();
		this.lista = new JList<Regra>(this.aux);
		this.scroll = new JScrollPane(lista);
		janela = new JFrame();
		janela.setLayout(new FlowLayout());
		janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	/**
	 * este metodo vai buscar á Classe Menu a lista model e retira as 2 regras que vêm nessa 
	 * lista, que advêm da funcionalidade detetar erro. Assim é criada uma segunda lista com toda 
	 * a informação da Model do menu, sem esses 2 elementos.
	 */
	
	private void removeFerramentas() {
		this.aux = new DefaultListModel<Regra>();
		// DefaultListModel<Regra> resultado = new DefaultListModel<Regra>();
		for (int i = 0; i < myMenu.getLista().size(); i++) {
			aux.addElement(myMenu.getLista().get(i));
		}

		for (int i = 0; i < myMenu.getLista().size(); i++) {
			if ((myMenu.getLista().get(i).getNome().equals("PMD")
					|| myMenu.getLista().get(i).getNome().equals("IPlasma"))) {
				aux.removeElement(myMenu.getLista().get(i));
			}

		}

	}

	public DefaultListModel<Regra> getModel() {
		return myMenu.getLista();
	}

	/**
	 * Inicializa a janela da classe e invoca o metodo "inicializar()" que fica responsavel
	 * por preencher o conteudo da janela
	 */
	
	public void open() {
		janela.setTitle("Regras");
		janela.setLayout(new GridLayout(3, 1));
		janela.add(scroll);
		editarRegra = new JButton("Editar regra");
		janela.getContentPane().add(editarRegra);
		inicializar();
		janela.pack();
		janela.setVisible(true);
	}
	
	/**
	 * O metodo inicializar, cria os botoes editarRegra e CriarRegra como tambem os seus
	 * actionListeners 
	 */

	public void inicializar() {
		editarRegra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lista.getSelectedValue() != null) {
					// System.out.println("Regra selecionada: " +
					// lista.getSelectedValue().toString());
					// System.out.println("Valor regra Selecionada: " +
					// lista.getSelectedValue().getValoresMetricas());
					JanelaEdita j = new JanelaEdita(lista.getSelectedValue());
					j.open();
				}
			}
		});
		criarRegra = new JButton("Criar regra");
		janela.add(criarRegra);
		criarRegra.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JanelaCriaRegra j = new JanelaCriaRegra(me);
				j.open();
			}
		});
	}

	public void addElementToLists(Regra regra, String nomeLista) {
		if (nomeLista.equals("model")) {
			myMenu.getLista().addElement(regra);
		} else {
			aux.addElement(regra);
			lista.setModel(aux);
		}
	}

	public DefaultListModel<Regra> listaAtualizarAux() {
		return this.aux;
	}

	public void removeElementModelList(Regra r) {
		for (int i = 0; i < myMenu.getLista().getSize(); i++) {
			if (myMenu.getLista().get(i).equals(r)) {
				myMenu.getLista().removeElement(myMenu.getLista().get(i));
			}
		}
	}
	
	public void funcoes() throws InterruptedException {
		criarRegra.doClick();
		Thread.sleep(10000);
		this.lista.setSelectedIndex(0);
		Thread.sleep(1000);
		editarRegra.doClick();
		Thread.sleep(10000);
	}
	
	public static void main(String[] args) throws InterruptedException {
		JanelaRegra jr = new JanelaRegra(new Menu());
		jr.open();
		Thread.sleep(4000);
		jr.funcoes();
		
	}

}
