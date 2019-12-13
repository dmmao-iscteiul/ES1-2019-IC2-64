package es;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class JanelaCriaRegra {

	private JFrame janela;

	private ArrayList<JCheckBox> listacheckbox = new ArrayList<JCheckBox>();
	private JanelaRegra myJR;

	public JanelaCriaRegra(JanelaRegra myJR) {
		this.myJR = myJR;
		janela = new JFrame();
		janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		janela.setSize(300, 250);

	}

	/**
	 * Inicializa a janela da classe e invoca o metodo "inicializar()" que fica responsavel
	 * por preencher o conteudo da janela
	 */

	public void open() {
		janela.setTitle(" Criar Regras");
		janela.setLayout(new GridLayout(3, 3));
		janela.setSize(300, 200);
		inicializar();
		janela.pack();
	}

	/**
	 * Este metodo esta responsavel pela criação dos elementos que observamos na janela.
	 * Cria actionListeners para cada JBox de forma a definir algumas regras de funcionalidades
	 * como a de se selecionar uma, outras 2 iram ficar bloqueadas.
	 * 
	 * O lançamento das janelas seguintes é realizado ao pressionar o botão "OK", podemos observar
	 * essas funcionalidades no actionListener do botão OK como tambem os respectivos try..catch ao longo do metodo
	 * 
	 */
	
	private void inicializar() {
		final JTextArea nome = new JTextArea("");

		try {
			JLabel titulo = new JLabel("Nome da regra: ");
			janela.add(titulo);

			// final JTextArea nome = new JTextArea("");
			janela.add(nome);

			JPanel painel = new JPanel();
			janela.add(painel);

			final JCheckBox loc = new JCheckBox("LOC");
			janela.add(loc);
			listacheckbox.add(loc);
			final JCheckBox cyclo = new JCheckBox("CYCLO");
			janela.add(cyclo);
			listacheckbox.add(cyclo);
			final JCheckBox laa = new JCheckBox("LAA");
			janela.add(laa);
			listacheckbox.add(laa);
			final JCheckBox atfd = new JCheckBox("ATFD");
			janela.add(atfd);
			listacheckbox.add(atfd);
			// System.out.println(listacheckbox.size());

			ActionListener a1 = new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == loc || e.getSource() == cyclo) {
						if ((laa.isEnabled() || atfd.isEnabled())) {
							laa.setEnabled(false);
							atfd.setEnabled(false);
						} else if (!loc.isSelected() && !cyclo.isSelected()) {
							laa.setEnabled(true);
							atfd.setEnabled(true);
						}

					}
				}
			};

			ActionListener a2 = new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == laa || e.getSource() == atfd) {
						if (loc.isEnabled() || cyclo.isEnabled()) {
							loc.setEnabled(false);
							cyclo.setEnabled(false);
						} else if (!laa.isSelected() && !atfd.isSelected()) {
							loc.setEnabled(true);
							cyclo.setEnabled(true);
						}

					}
				}
			};

			loc.addActionListener(a1);
			cyclo.addActionListener(a1);
			laa.addActionListener(a2);
			atfd.addActionListener(a2);
			JPanel panel = new JPanel();
			janela.add(panel);
			JButton ok = new JButton("OK");
			janela.add(ok);
			janela.setVisible(true);

			ok.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if (nome.getText().isEmpty() || (!loc.isSelected() && !cyclo.isSelected() && !laa.isSelected()
								&& !atfd.isSelected())) {
							throw new Exception();
						}

						ArrayList<String> valid = new ArrayList<String>();
						// System.out.println("tamanho: " +
						// listacheckbox.size());
						for (int i = 0; i < listacheckbox.size(); i++) {
							if (listacheckbox.get(i).isSelected()) {
								valid.add(listacheckbox.get(i).getText());
							}
						}
						// System.out.println("Tamanho lista:" +
						// listacheckbox.size() + " Tamanho valid:" +
						// valid.size());
						janela.dispose();
						JanelaCriaRegraValores jcrv = new JanelaCriaRegraValores(valid, nome.getText(), myJR);
						jcrv.open();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Falta preencher dados!");
					}

				}

			});
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Falta preencher dados!");
		}
	}
}
