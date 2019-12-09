import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
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
		janela.setLayout(new GridLayout(3, 3));
		janela.setVisible(true);

		JLabel titulo = new JLabel("cenas");
		//janela.add(titulo);
		
		JLabel titulo2 = new JLabel("titulo:");
		//janela.add(titulo2);
		
		JPanel pn = new JPanel();
		pn.add(titulo);
		janela.add(pn);
		
		JPanel pn2 = new JPanel();
		pn2.add(titulo2);
		janela.add(pn2);
		
		
	}
	
	
	public static void main(String[] args) {
		JanelaCriaRegraValores j = new JanelaCriaRegraValores();
		j.open();
	}

}
