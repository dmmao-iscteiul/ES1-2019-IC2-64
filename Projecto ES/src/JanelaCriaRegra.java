import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

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
	
	private ArrayList<JCheckBox> listacheckbox = new ArrayList<JCheckBox>();
	
	
	public JanelaCriaRegra() {
		janela = new JFrame();
		janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		janela.setSize(300, 250);
	}
	
	// Tem de se dar um arraylist com as regras para poder selecionar ou adicionar regras 
	
	
	//temos que adicionar as regras a lista de regras
	
	public void open() {
		JCheckBox[] checkboxesreg = new JCheckBox[4];
		janela.setTitle(" Criar Regras");
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
		listacheckbox.add(loc);
		JCheckBox cyclo = new JCheckBox("CYCLO");
		janela.add(cyclo);
		listacheckbox.add(cyclo);
		JCheckBox laa = new JCheckBox("LAA");
		janela.add(laa);
		listacheckbox.add(laa);
		JCheckBox cd = new JCheckBox("CD");
		janela.add(cd);
		listacheckbox.add(cd);
		
		
		ActionListener a1 = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== loc || e.getSource()==cyclo){
					if((laa.isEnabled() || cd.isEnabled())){
						laa.setEnabled(false);
						cd.setEnabled(false);
					}else if(!loc.isSelected() && !cyclo.isSelected()){
						laa.setEnabled(true);
						cd.setEnabled(true);
					}
						
				}						
			}
		};
		
		ActionListener a2 = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== laa || e.getSource()==cd){
					if(loc.isEnabled() || cyclo.isEnabled()){
						loc.setEnabled(false);
						cyclo.setEnabled(false);
					}else if(!laa.isSelected() && !cd.isSelected()){
						loc.setEnabled(true);
						cyclo.setEnabled(true);
					}
						
				}						
			}
		};
	
		loc.addActionListener(a1);
		cyclo.addActionListener(a1);
		laa.addActionListener(a2);
		cd.addActionListener(a2);
	

		
		
		
		JPanel panel = new JPanel();
		janela.add(panel);
		JButton ok = new JButton("OK");
		janela.add(ok);	
		janela.setVisible(true);
		
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaCriaRegraValores jcrv = new JanelaCriaRegraValores();
				
				jcrv.open();
			}

		});
		
		
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		JanelaRegra j = new JanelaRegra();
		j.open();
	}
	
	
	

}
