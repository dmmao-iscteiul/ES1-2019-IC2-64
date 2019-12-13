package es;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.sun.media.jfxmedia.events.NewFrameEvent;
import com.sun.scenario.effect.DelegateEffect;

public class Detetar_erro {

	private JFrame janela;
	private JList<Regra> listaIG;
	private DefaultListModel<Regra> regras;
	private JanelaRegra janelaregra;
	private JPanel painel;
	private JButton ok;
	private JLabel etiqueta;
	private Vector<String> stringBooleans;
	private int contadordefeitos;
	private Excel excel;

	public Detetar_erro(DefaultListModel<Regra> regras, Excel excel) {
		this.excel = excel;
		this.regras = regras;
		listaIG = new JList<Regra>(regras);
		stringBooleans = new Vector<String>();
		contadordefeitos = 0;

		janela = new JFrame("Detetar");
		janela.setSize(300, 250);
		janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		inicializar();
		janela.pack();
	}

	public void open() {
		janela.setSize(300, 250);
		janela.setVisible(true);
		centerFrame(3, 3, 3, 3);
	}

	private void centerFrame(int a, int b, int c, int d) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		janela.setLocation(dimension.width / a - janela.getWidth() / b, dimension.height / c - janela.getHeight() / d);
	}
	
	/**
	 * abre a janela, quando clicamos no botao abre uma nova janela, escolhemos a regra pretendida
	 * eliminamos todos os falses, e pomos todos os trues numa nova tabela 
	 * 
	 */

	public void inicializar() {
		painel = new JPanel();
		ok = new JButton("detetar");

		etiqueta = new JLabel("selecionar uma regra");
		painel.add(ok);
		janela.setLayout(new BorderLayout());
		janela.add(listaIG, BorderLayout.CENTER);
		janela.add(painel, BorderLayout.EAST);
		janela.add(etiqueta, BorderLayout.BEFORE_FIRST_LINE);

		ok.addActionListener(new ActionListener() {
			private JFrame frame;
			private Vector<String> vetorResultado;
			private Regra selecionada;

			private void inicializaTable() {
				this.frame = new JFrame();
				janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				this.vetorResultado = new Vector<String>();
			
			}

			private void openTable() {
				frame.pack();
				frame.setSize(600, 700);
				frame.setVisible(true);
				centerFrame(2, 2, 9, 9);

			}

			public void actionPerformed(ActionEvent e) {
				inicializaTable();
				if (!listaIG.isSelectionEmpty()) {
					this.selecionada = listaIG.getSelectedValue();
					this.vetorResultado = selecionada.getVectorResultado(excel);
					contarDefeitos(this.vetorResultado);
					DefaultTableModel tableModel = displayTable(selecionada, this.vetorResultado);

					JTable table = new JTable(tableModel);
					frame.add(new JScrollPane(table));

					openTable();
					JOptionPane.showMessageDialog(null,
							"Utilizando esta regra encontramos " + contadordefeitos + " defeitos");

				}
			}
		});
	}

	

	private DefaultTableModel displayTable(Regra r, Vector<String> vetorResultado) {
		DefaultTableModel modelTable = new DefaultTableModel();
		modelTable.addColumn("Metodo ID", excel.getColumnString(0));
		modelTable.addColumn("Métodos", excel.getColumnString(3));
		modelTable.addColumn(r.getNome(), vetorResultado);
		modelTable = limparFalsos(r, modelTable);
		return modelTable;
	}

	private DefaultTableModel limparFalsos(Regra r, DefaultTableModel table) {
		DefaultTableModel tableAux = new DefaultTableModel();
		String [] identificadores = {"Metodo ID", "Metodo", r.getNome()};
		tableAux.setColumnIdentifiers(identificadores);
		for (int i = 0; i < table.getRowCount(); i++) {
			if (table.getValueAt(i, 2).equals("TRUE")) {	
				String[] auxRow = new String[3];
				auxRow[0] = (String) table.getValueAt(i, 0);
				auxRow[1] = (String) table.getValueAt(i, 1);
				auxRow[2] = (String) table.getValueAt(i, 2);
				tableAux.addRow(auxRow);
				
			}
		}
		return tableAux;
	}
	

	/**
	 * percorremos de resultados e se for igual a true incrementamos um contadorde defeitos
	 * @param vetorB
	 */

	public void contarDefeitos(Vector<String> vetorB) {
		for (String s : vetorB) {
			if (s.equals("TRUE")) {
				contadordefeitos++;

			}
		}
		System.out.println("contador: " + contadordefeitos);
	}

}
