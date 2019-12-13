package es;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class JanelaEdita {

	private JFrame janela;

	private ArrayList<JCheckBox> listacheckbox = new ArrayList<JCheckBox>();
	private Regra myRegra;
	private JTextArea val1;
	private JTextArea val2;

	public JanelaEdita(Regra r) {
		janela = new JFrame();
		janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		janela.setSize(300, 250);
		myRegra = r;
	}
	
	/**
	 * Inicializa a janela da classe e invoca o metodo "inicializar()" que fica responsavel
	 * por preencher o conteudo da janela
	 */

	public void open() {
		janela.setTitle(" Valores");
		janela.setLayout(new GridLayout(3, 3));
		inicializa();
		janela.setVisible(true);
		janela.pack();
	}
	
	/**
	 * Preenche a janela com os seus elementos e as respectivas regras de funcionalidade, conforme as classes passadas de regras
	 */
	

	private void inicializa() {
		JLabel jb = new JLabel("Regra: " + myRegra.toString());
		janela.add(jb);

		JPanel jp1 = new JPanel();
		janela.add(jp1);

		JPanel jp2 = new JPanel();
		janela.add(jp2);

		Metrica met1 = myRegra.getMetricas(0);
		JLabel metrica1 = new JLabel(met1.getNome());
		janela.add(metrica1);

		JLabel operador1 = new JLabel(met1.getOperador());
		janela.add(operador1);

		val1 = new JTextArea();
		janela.add(val1);

		if (myRegra.numeroDeMetricas() == 2) {
			Metrica met2 = myRegra.getMetricas(1);
			JLabel metrica2 = new JLabel(met2.getNome());
			janela.add(metrica2);
			JLabel operador2 = new JLabel(met2.getOperador());
			janela.add(operador2);
			val2 = new JTextArea();
			janela.add(val2);
		}
		JButton ok = new JButton("OK");
		janela.add(ok);
		janela.setVisible(true);
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				if(myRegra.numeroDeMetricas()==2 && (val1.getText().isEmpty()||val2.getText().isEmpty())){
					throw new Exception();
				}
				if(myRegra.numeroDeMetricas()==1 && val1.getText().isEmpty()){
					throw new Exception();
				}
				if (myRegra.numeroDeMetricas() == 2) {
					myRegra.getMetricas(0).setValor(Integer.parseInt(val1.getText()));
					myRegra.getMetricas(0).setValor(Integer.parseInt(val2.getText()));
				} else {
					myRegra.getMetricas(0).setValor(Integer.parseInt(val1.getText()));
				}
				janela.dispose();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Falta preencher dados!");
				}
			}
		});
	}
}