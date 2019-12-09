import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class JanelaCriaRegraValores extends JanelaRegra {

	private JFrame janela;
	private static ArrayList<String> meth;
	private static ArrayList<Metrica> metricaArray = new ArrayList<>();
	private static JCheckBox maior1;
	private static JCheckBox maior2;
	private static JCheckBox menor1;
	private static JCheckBox menor2;
	private static JTextArea val1;
	private static JTextArea val2;


	public JanelaCriaRegraValores(ArrayList<String> valid) {
		janela = new JFrame();
		janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		janela.setSize(300, 250);
		meth = valid;
	}

	public void open() {
		janela.setTitle(" Valores");
		janela.setLayout(new GridLayout(3, 4));
		janela.setVisible(true);

		System.out.println("antes do if");
		if (meth.size() == 2) {
			JLabel representa1 = new JLabel(meth.get(0));
			janela.add(representa1);
			maior1 = new JCheckBox("maior");
			janela.add(maior1);
			menor1 = new JCheckBox("menor");
			janela.add(menor1);
			// cba.add(maior1);
			// cba.add(menor1);
			ActionListener a1 = new ActionListener() {
				@Override
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

			JLabel representa2 = new JLabel(meth.get(1));
			janela.add(representa2);
			maior2 = new JCheckBox("maior");
			janela.add(maior2);
			menor2 = new JCheckBox("menor");
			janela.add(menor2);

			ActionListener a2 = new ActionListener() {
				@Override
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
			System.out.println(meth.get(0));
			JLabel loc = new JLabel(meth.get(0));
			janela.add(loc);
			JCheckBox maior1 = new JCheckBox("maior");
			janela.add(maior1);
			JCheckBox menor1 = new JCheckBox("menor");
			janela.add(menor1);
			val1 = new JTextArea();
			janela.add(val1);
		}

		JButton ok = new JButton("ok");
		janela.add(ok);

		ok.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if (meth.size() ==1) {

					if (maior1.isSelected()) {
						metricaArray.add(new Metrica(meth.get(0), 1, Integer.parseInt(val1.getText())));
					} else {
						metricaArray.add(new Metrica(meth.get(0), 0, Integer.parseInt(val1.getText())));
					}
				} else {
					if (maior1.isSelected()) {
						metricaArray.add(new Metrica(meth.get(0), 1, Integer.parseInt(val1.getText())));
					} else {
						metricaArray.add(new Metrica(meth.get(0), 0, Integer.parseInt(val1.getText())));
					}

					if (maior2.isSelected()) {
						metricaArray.add(new Metrica(meth.get(1), 1, Integer.parseInt(val2.getText())));
					} else {
						metricaArray.add(new Metrica(meth.get(1), 0, Integer.parseInt(val2.getText())));
					}
				}
				System.out.println(metricaArray);
				sendRegra();
				
				
				
			}
		});

		JLabel enchimento1 = new JLabel();
		janela.add(enchimento1);

		JLabel enchimento2 = new JLabel();
		janela.add(enchimento2);

		JLabel enchimento3 = new JLabel();
		janela.add(enchimento3);

	}
	
	public void sendRegra(){
		super.addElementlist(new Regra(metricaArray.get(0),metricaArray.get(1)));
	}

	public static void main(String[] args) {
		// /JanelaCriaRegraValores j = new JanelaCriaRegraValores();
		// j.open();
		// System.out.println(meth);

	}

}
