import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.WindowConstants;

public class Janela {
	
	private JFrame janela;
	private JList lista=new JList();
	private JButton criarRegra;
	private JButton editarRegra;
	
	
	public Janela() {
		janela = new JFrame();
		janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		janela.setSize(300, 250);
	}
	
	// Tem de se dar um arraylist com as regras para poder selecionar ou adicionar regras 
	
	public void open() {
		janela.setTitle("Regras");
		
		janela.setLayout(new GridLayout(3, 1));
		
		janela.add(lista);
		
		editarRegra = new JButton("Editar regra");
		janela.add(editarRegra);
		
		criarRegra = new JButton("Criar regra");
		janela.add(criarRegra);
		criarRegra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JanelaCriaRegra j= new JanelaCriaRegra();
				j.open();
			}
		});
		
		janela.setVisible(true);
	}
	
	public void addElementlist(Component regras) {
		lista.add(regras);
				
	}
	
	
	
	
	public static void main(String[] args) {
		Janela j = new Janela();
		DefaultListModel<Regra> n = new DefaultListModel<Regra>();
		//n.addElement(new Regra(1));
		//n.addElement(new Regra(2));
		//j.janelaRegras(n);
	}

}
