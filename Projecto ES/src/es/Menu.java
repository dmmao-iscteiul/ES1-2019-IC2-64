package es;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Menu {
	
	private Menu me;
	private JFrame frame;
	private Excel excel;
	private JFileChooser jfc;
	private DefaultListModel<Regra> model;
	private JButton selecionar;
	private JButton visualizar;
	private JButton editar_criar;
	private JButton detetar;
	private JButton analisar;

	public Menu() {
		
		me = this;
		model = new DefaultListModel<Regra>();
		// model.addElement(new Regra ("PMD"));
		// model.addElement(new Regra("Iplasma"));

		frame = new JFrame("Software");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		addFrameContent();

		frame.pack();
		open();
	}

	// public static DefaultListModel getModelList() {
	// return model;
	// }
	//
	// public static void setModelList(DefaultListModel model) {
	// Menu.model = model;
	// }

	public void open() {
		frame.setSize(300, 250);
		// para abrir a janela (torna-la visivel)
		frame.setVisible(true);
		centerFrame();
	}

	private void addFrameContent() {

		/*
		 * para organizar o conteudo em grelha (linhas x colunas) se um dos
		 * valores for zero, o numero de linhas ou colunas (respetivamente) fica
		 * indefinido, e estas sao acrescentadas automaticamente
		 */
		frame.setLayout(new GridLayout(5, 0));

		selecionar = new JButton("Selecionar ficheiro");

		selecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jfc = new JFileChooser();

				int returnVal = jfc.showOpenDialog(null);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					try {
						excel = new Excel(jfc.getSelectedFile());
						addFerramentas();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}

			}

		});
		frame.add(selecionar);

		visualizar = new JButton("Visualizar Ficheiro");
		visualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (excel.equals(null)) 
					{
						JOptionPane.showMessageDialog(null, "Necessita de Carregar Excel");
					} else {
						ExcelViewer ex = new ExcelViewer(excel);
				ex.open();
					}
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "Necessita de Carregar Excel");
				}
				
			}

		});
		frame.add(visualizar);

		editar_criar = new JButton("Editar/Criar Regras");
		editar_criar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JanelaRegra j = new JanelaRegra(me);
				j.open();
			}

		});
		frame.add(editar_criar);

		detetar = new JButton("Detetar defeitos");
		detetar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (excel.equals(null)) 
					{
						JOptionPane.showMessageDialog(null, "Necessita de Carregar Excel");
					} else {
						Detetar_erro d = new Detetar_erro(model, excel);
				System.out.println("listas " + model);
				d.open();
					}
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "Necessita de Carregar Excel");
				}

				
			}

		});
		frame.add(detetar);

		analisar = new JButton("Analisar qualidade");
		analisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (excel.equals(null)) // adicionar exceção caso nao tenha
											// excel importado
					{
						JOptionPane.showMessageDialog(null, "Necessita de Carregar Excel");
					} else {
						AnaliseRegras a = new AnaliseRegras(excel, model);
						a.open();
					}
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "Necessita de Carregar Excel");
				}

			}

		});
		frame.add(analisar);
	}

	//
	private void addFerramentas() {
		Regra iplasma = new Regra("IPlasma");
		iplasma.setVetorResultado(excel.getColumnString(9));
		model.addElement(iplasma);

		Regra pmd = new Regra("PMD");
		pmd.setVetorResultado(excel.getColumnString(10));
		model.addElement(pmd);

	}

	private void centerFrame() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dimension.width / 2 - frame.getWidth() / 2, dimension.height / 2 - frame.getHeight() / 2);
	}

	public void addRegrasToModel(Regra regra) {
		this.model.addElement(regra);
	}

	public DefaultListModel<Regra> getLista() {
		return this.model;
	}

	public Menu getMenu() {
		return this;
	}
	
	public void funcoes() throws InterruptedException {
		
		selecionar.doClick();
		Thread.sleep(10000);
		visualizar.doClick();
		Thread.sleep(3000);
		detetar.doClick();
		Thread.sleep(10000);
		analisar.doClick();
		Thread.sleep(10000);
	}


	public static void main(String[] args) throws InterruptedException {
		Menu window = new Menu();
		window.open();
	}
	
	public static void mainTeste(String[] args) throws InterruptedException {
		Menu window = new Menu();
		window.open();
		
		Metrica m1 = new Metrica("LOC",1,1);
		Metrica m3 = new Metrica("LAA", 1, 0);
				
		Regra r2 = new Regra("R2", m1, m3 ,0);
		
		window.addRegrasToModel(r2);
		
		window.funcoes();
		
	}

}
