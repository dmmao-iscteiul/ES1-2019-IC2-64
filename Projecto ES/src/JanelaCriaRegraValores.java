import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class JanelaCriaRegraValores {
	
	private JFrame janela;

	
	public JanelaCriaRegraValores() {
		janela = new JFrame();
		janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		janela.setSize(300, 250);
	}
	
	public void open(){
		janela.setTitle(" Valores");
		janela.setLayout(new GridLayout(2, 4));
		janela.setVisible(true);

		
		JLabel loc = new JLabel(":");
		janela.add(loc);
		
		JButton maior1 = new JButton("maior");
		janela.add(maior1);
		
		JButton menor1 = new JButton("menor");
		janela.add(menor1);
		
		JTextArea val1 = new JTextArea();
		janela.add(val1);
		
		JLabel cyclo = new JLabel(":");
		janela.add(cyclo);
		
		JButton maior2 = new JButton("maior");
		janela.add(maior2);
		
		JButton menor2 = new JButton("menor");
		janela.add(menor2);
		
		JTextArea val2 = new JTextArea();
		janela.add(val2);
		
//		JPanel pn = new JPanel();
//		pn.add(titulo);
//		janela.add(pn);
//		
//		JPanel pn2 = new JPanel();
//		pn2.add(titulo2);
//		janela.add(pn2);
//		
		
	}
	
	
	public static void main(String[] args) {
		JanelaCriaRegraValores j = new JanelaCriaRegraValores();
		
	}

}
