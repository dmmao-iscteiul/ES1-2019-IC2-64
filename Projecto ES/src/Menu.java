import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Menu {
	
	private JFrame frame;
	private Excel excel;

	public Menu() {
		frame = new JFrame("Software");
		// para que o botao de fechar a janela termine a aplicacao
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		addFrameContent();

		// para que a janela se redimensione de forma a ter todo o seu conteudo
		// visivel
//		frame.pack();
	}

	public void open() {
		 frame.setSize(300, 250);

		// para abrir a janela (torna-la visivel)
		frame.setVisible(true);
	}

	private void addFrameContent() {

		/*
		 * para organizar o conteudo em grelha (linhas x colunas) se um dos
		 * valores for zero, o numero de linhas ou colunas (respetivamente) fica
		 * indefinido, e estas sao acrescentadas automaticamente
		 */
		frame.setLayout(new GridLayout(5,0));

		JButton selecionar = new JButton("Selecionar ficheiro");
		
		selecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ir buscar a SubImagem
				JFileChooser jfc = new JFileChooser(".");

				FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel file", "xls", "xlsx");

				jfc.addChoosableFileFilter(filter);

				int returnValue = jfc.showOpenDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {

					
					File excelFile = jfc.getSelectedFile();
					try {
						excel = new Excel(excelFile);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}

		});


		frame.add(selecionar);

		
		JButton visualizar = new JButton("Visualizar Ficheiro");
		visualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if(excel.equals(null)) 
					//JOptionPane.showMessageDialog(null, "Ainda não importou o Excel");
				
				//else

					ExcelViewer viewer = new ExcelViewer(excel);
					viewer.open();
			}

		});
		frame.add(visualizar);
		
		JButton editar_criar = new JButton("Editar/Criar Regras");
		editar_criar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}

		});
		frame.add(editar_criar);
		
		JButton detetar = new JButton("Detetar defeitos");
		detetar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// açao
			}

		});
		frame.add(detetar);
		
		JButton analisar = new JButton("Analisar qualidade");
		analisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// açao
			}

		});
		frame.add(analisar);
	}


	public static void main(String[] args) {
		Menu window = new Menu();
		window.open();
	}
}
