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
		janela.setLayout(new GridLayout(2, 4));
		janela.setVisible(true);
		
		
		
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		JanelaRegra j = new JanelaRegra();
		j.open();
	}
	
	
	
}
