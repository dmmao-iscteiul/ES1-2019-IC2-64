import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.WindowConstants;

public class JanelaRegra {

	private JFrame janela;
	private JList<Regra> lista = new JList<>();
	private JButton criarRegra;
	private JButton editarRegra;
	

	
	// Na Jlist adicionar objectos Regras
	
	
	public JanelaRegra() {
		janela = new JFrame();
		janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		janela.setSize(300, 250);
	}

	// Tem de se dar um arraylist com as regras para poder selecionar ou
	// adicionar regras

	public void open() {
		janela.setTitle("Regras");

		janela.setLayout(new GridLayout(3, 1));

		janela.add(lista);

		editarRegra = new JButton("Editar regra");
		janela.add(editarRegra);

		editarRegra.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JanelaEdita j = new JanelaEdita();
				j.open();
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

	public void addElementlist(Regra regra) {
		lista.add((Component)regra);

	}


	public static void main(String[] args) {
		JanelaRegra j = new JanelaRegra();
		DefaultListModel<Regra> n = new DefaultListModel<Regra>();
		// n.addElement(new Regra(1));
		// n.addElement(new Regra(2));
		// j.janelaRegras(n);
	}

}
