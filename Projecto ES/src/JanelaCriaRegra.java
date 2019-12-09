import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class JanelaCriaRegra {
	
	private JFrame janela;
	private JList lista=new JList();
	private JButton criarRegra;
	private JButton editarRegra;
	
	public JanelaCriaRegra() {
		janela = new JFrame();
		janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		janela.setSize(300, 250);
	}
	
	// Tem de se dar um arraylist com as regras para poder selecionar ou adicionar regras 
	
	
	//temos que adicionar as regras a lista de regras
	
	public void open() {
		janela.setTitle("Regras");
		
		janela.setLayout(new GridLayout(3, 3));
		
		janela.add(lista);
		
		JLabel titulo = new JLabel("titulo:");
		janela.add(titulo);
		
		JTextArea nome = new JTextArea("nome da regra");
		janela.add(nome);
		
		JPanel painel = new JPanel();
		janela.add(painel);
		
		JCheckBox loc = new JCheckBox("LOC");
		janela.add(loc);
		
		
		JCheckBox cyclo = new JCheckBox("CYCLO");
		janela.add(cyclo);
		
		JCheckBox laa = new JCheckBox("LAA");
		janela.add(laa);
		
		JCheckBox cd = new JCheckBox("CD");
		janela.add(cd);
		
		JPanel panel = new JPanel();
		janela.add(panel);
		
		
		editarRegra = new JButton("the thing goes:");
		janela.add(editarRegra);
		
		criarRegra = new JButton("Skrrraaaaaa papapapa");
		janela.add(criarRegra);
		
		JButton ok = new JButton("OK");
		janela.add(ok);
		
		janela.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		Janela j = new Janela();
		j.open();
	}
	
	
	

}
