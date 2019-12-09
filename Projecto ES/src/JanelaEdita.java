import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class JanelaEdita {

	
	
	
	private JFrame janela;
	private JList lista=new JList();
	
	private ArrayList<JCheckBox> listacheckbox = new ArrayList<JCheckBox>();
	
	
	public JanelaEdita() {
		janela = new JFrame();
		janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		janela.setSize(300, 250);
	}
	
	// Tem de se dar um arraylist com as regras para poder selecionar ou adicionar regras 
	
	
	//temos que adicionar as regras a lista de regras
	
	public void open() {
		janela.setTitle(" Valores");
		janela.setLayout(new GridLayout(3, 3));
		janela.setVisible(true);
		
		JLabel jb = new JLabel("Regra");
		janela.add(jb);
		
		JPanel jp1 = new JPanel();
		janela.add(jp1);
		
		JPanel jp2 = new JPanel();
		janela.add(jp2);
		
		JLabel metrica1 = new JLabel("metrica1");
		janela.add(metrica1);
		
		JLabel operador1 = new JLabel("operador1");
		janela.add(operador1);
		
		JTextArea val1 = new JTextArea();
		janela.add(val1);
		
		JLabel metrica2 = new JLabel("metrica2");
		janela.add(metrica2);
		
		JLabel operador2 = new JLabel("operador2");
		janela.add(operador2);
		
		JTextArea val2 = new JTextArea();
		janela.add(val2);
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		JanelaRegra j = new JanelaRegra();
		j.open();
	}
	
	
	
}