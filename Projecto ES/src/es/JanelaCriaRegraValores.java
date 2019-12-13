package es;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 * 
 * @author Grupo de ES-64
 *
 */

public class JanelaCriaRegraValores {

	private JFrame janela;
	private static ArrayList<String> meth;
	private static ArrayList<Metrica> metricaArray = new ArrayList<Metrica>();
	private static JCheckBox maior1;
	private static JCheckBox maior2;
	private static JCheckBox menor1;
	private static JCheckBox menor2;
	private static JTextArea val1;
	private static JTextArea val2;
	private static String nome;
	private JPanel panelE;
	private JPanel panelC;
	private static JCheckBox opE;
	private static JCheckBox opOU;

	private JanelaRegra myJR;

	public JanelaCriaRegraValores(ArrayList<String> valid, String string, JanelaRegra myJR) {
		this.myJR = myJR;
		janela = new JFrame();
		janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		meth = valid;
		nome = string;
	}

	/**
	 * Inicializa a janela da classe e invoca o metodo "inicializar()" que fica
	 * responsavel por preencher o conteudo da janela
	 */

	public void open() {
		janela.setTitle(" Valores");
		if (meth.size() == 2) {
			janela.setLayout(new GridLayout(4, 5));
		} else {
			janela.setLayout(new GridLayout(2, 4));
		}
		inicializa();
		janela.setSize(400, 400);
		janela.setVisible(true);
		janela.pack();
	}

	/**
	 * O metodo inicializar() fica responsavel pelo preenchimento da janela com
	 * os seus respectivos elementos, e no actionListener do botão OK estão
	 * definidas as respectivas regras para o metodo ser valido e poder passar
	 * para a proxima janela!
	 */

	private void inicializa() {
		try {

			if (meth.size() == 2) {
				JLabel representa1 = new JLabel(meth.get(0));
				janela.add(representa1);
				maior1 = new JCheckBox("maior");
				janela.add(maior1);
				menor1 = new JCheckBox("menor");
				janela.add(menor1);
				ActionListener a1 = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (e.getSource() == maior1) {
							if ((menor1.isEnabled())) {
								menor1.setEnabled(false);
							} else {
								menor1.setEnabled(true);
							}
						} else {
							if ((maior1.isEnabled())) {
								maior1.setEnabled(false);
							} else {
								maior1.setEnabled(true);
							}
						}
					}
				};
				maior1.addActionListener(a1);
				menor1.addActionListener(a1);
				val1 = new JTextArea();
				janela.add(val1);
				janela.add(new JLabel());
				opE = new JCheckBox("E");
				janela.add(opE);
				opOU = new JCheckBox("OU");
				janela.add(opOU);
				ActionListener opAc = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (e.getSource() == opE) {
							if ((opOU.isEnabled())) {
								opOU.setEnabled(false);
							} else {
								opOU.setEnabled(true);
							}
						} else {
							if ((opE.isEnabled())) {
								opE.setEnabled(false);
							} else {
								opE.setEnabled(true);
							}
						}
					}
				};
				opE.addActionListener(opAc);
				opOU.addActionListener(opAc);
				janela.add(new JLabel());
				JLabel representa2 = new JLabel(meth.get(1));
				janela.add(representa2);
				maior2 = new JCheckBox("maior");
				janela.add(maior2);
				menor2 = new JCheckBox("menor");
				janela.add(menor2);

				ActionListener a2 = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (e.getSource() == maior2) {
							if ((menor2.isEnabled())) {
								menor2.setEnabled(false);
							} else {
								menor2.setEnabled(true);
							}
						} else {
							if ((maior2.isEnabled())) {
								maior2.setEnabled(false);
							} else {
								maior2.setEnabled(true);
							}
						}
					}
				};
				maior2.addActionListener(a2);
				menor2.addActionListener(a2);
				val2 = new JTextArea();
				janela.add(val2);
			} else {
				JLabel loc = new JLabel(meth.get(0));
				janela.add(loc);
				maior1 = new JCheckBox("maior");
				janela.add(maior1);
				menor1 = new JCheckBox("menor");
				janela.add(menor1);
				val1 = new JTextArea();
				janela.add(val1);

				ActionListener a1 = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (e.getSource() == maior1) {
							if ((menor1.isEnabled())) {
								menor1.setEnabled(false);
							} else {
								menor1.setEnabled(true);
							}
						} else {
							if ((maior1.isEnabled())) {
								maior1.setEnabled(false);
							} else {
								maior1.setEnabled(true);
							}
						}
					}
				};
				maior1.addActionListener(a1);
				menor1.addActionListener(a1);
			}
			JButton ok = new JButton("ok");
			janela.add(ok);
			ok.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if(meth.size()==1){
							if(!maior1.isSelected() && !menor1.isSelected()){
								throw new Exception("ola");
							}
						}else{
							if(!maior1.isSelected() && !menor1.isSelected() && !maior2.isSelected() && !menor2.isSelected()){
								throw new Exception("ola");
							}
						}						
						if (meth.size() == 1) {
							if (maior1.isSelected()) {
								System.out.println("Ola");
								metricaArray.add(new Metrica(meth.get(0), 1, Integer.parseInt(val1.getText())));
							}{
								System.out.println("Ola1");
								metricaArray.add(new Metrica(meth.get(0), 0, Integer.parseInt(val1.getText())));
							}
						} else {
							if (maior1.isSelected()) {
								System.out.println("Ola2");
								metricaArray.add(new Metrica(meth.get(0), 1, Integer.parseInt(val1.getText())));
							} else {
								System.out.println("Ola3");
								metricaArray.add(new Metrica(meth.get(0), 0, Integer.parseInt(val1.getText())));
							}
							if (maior2.isSelected()) {
								System.out.println("Ola4");
								metricaArray.add(new Metrica(meth.get(1), 1, Integer.parseInt(val2.getText())));
							} else {
								System.out.println("Ola5");
								metricaArray.add(new Metrica(meth.get(1), 0, Integer.parseInt(val2.getText())));
							}
						}
						sendRegra();
						janela.dispose();
					} catch (Exception e1) {
						
						JOptionPane.showMessageDialog(null, "Falta preencher dados!");
					}
				}
			});
			JLabel enchimento1 = new JLabel();
			janela.add(enchimento1);

			JLabel enchimento2 = new JLabel();
			janela.add(enchimento2);

			JLabel enchimento3 = new JLabel();
			janela.add(enchimento3);

		} catch (Exception e) {
			System.out.println("ola1");
			JOptionPane.showMessageDialog(null, "Falta preencher dados!");
		}
	}

	/**
	 * O metodo sendRegra() envia para a Classe JanelaRegra os novos elementos a
	 * adicionar á lista model e á lista Auxiliar. Por fim renicia o
	 * metricaArray de forma a ficar vazia para futuras criaçoes de regras
	 */

	public void sendRegra() {
		// System.out.println("Antes de sendRegra");
		if (metricaArray.size() == 2) {
			if (opE.isSelected()) {
				this.myJR.addElementToLists(new Regra(nome, metricaArray.get(0), metricaArray.get(1), 1), "model");
				this.myJR.addElementToLists(new Regra(nome, metricaArray.get(0), metricaArray.get(1), 1), "aux");
			} else {
				this.myJR.addElementToLists(new Regra(nome, metricaArray.get(0), metricaArray.get(1), 0), "model");
				this.myJR.addElementToLists(new Regra(nome, metricaArray.get(0), metricaArray.get(1), 0), "aux");
			}
		} else {
			this.myJR.addElementToLists(new Regra(nome, metricaArray.get(0)), "model");
			this.myJR.addElementToLists(new Regra(nome, metricaArray.get(0)), "aux");

		}
		metricaArray.clear();
	}

}
