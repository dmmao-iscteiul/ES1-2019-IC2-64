import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;



public class JanelaCriaRegra extends JanelaRegra {
	
	private JFrame janela;
	
	
	private ArrayList<JCheckBox> listacheckbox = new ArrayList<JCheckBox>();
	//private static String nome;
	
	
	public JanelaCriaRegra() {
		janela = new JFrame();
		janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		janela.setSize(300, 250);
	}
	
	// Tem de se dar um arraylist com as regras para poder selecionar ou adicionar regras 
	
	
	//temos que adicionar as regras a lista de regras
	
	public void open() {
		janela.setTitle(" Criar Regras");
		janela.setLayout(new GridLayout(3, 3));
		
	
		
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
		System.out.println(listacheckbox.size());
		
		
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
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> valid = new ArrayList<String>();
				System.out.println("tamanho: "+ listacheckbox.size());
				for(int i=0;i<listacheckbox.size();i++){
					if(listacheckbox.get(i).isSelected()){	
						valid.add(listacheckbox.get(i).getText());
					}
				}
				System.out.println("Tamanho lista:"+ listacheckbox.size() + " Tamanho valid:" + valid.size());
				janela.dispose();
				JanelaCriaRegraValores jcrv = new JanelaCriaRegraValores(valid,nome.getText());			
				jcrv.open();
				
			}

		});
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		JanelaRegra j = new JanelaRegra();
		j.open();
	}
	
	
	
	

}
