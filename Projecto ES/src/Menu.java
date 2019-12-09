import java.awt.Dimension;	
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Menu {
	
	private JFrame frame;
	private Excel excel;
	private JFileChooser jfc;

	public Menu() {
		 frame = new JFrame("Software");
		// para que o botao de fechar a janela termine a aplicacao
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		addFrameContent();

		// para que a janela se redimensione de forma a ter todo o seu conteudo
		// visivel
		frame.pack();
	}

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
		frame.setLayout(new GridLayout(5,0));

		JButton selecionar = new JButton("Selecionar ficheiro");
		
		selecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				jfc = new JFileChooser();
				
				//jfc.setFileFilter(new FileNameExtensionFilter("xlsx"));
				//jfc.addChoosableFileFilter(new FileNameExtensionFilter("*.xlsx"));

		        int returnVal = jfc.showOpenDialog(null);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					excel.importar(jfc.getSelectedFile());
				}
				
			}

		});
		frame.add(selecionar);

		
		

		JButton visualizar = new JButton("Visualizar Ficheiro");
		visualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// açao -- carolina
			}

		});
		frame.add(visualizar);
		
		JButton editar_criar = new JButton("Editar/Criar Regras");
		editar_criar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// açao-- 
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


	private void centerFrame() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

		frame.setLocation(dimension.width / 2 - frame.getWidth() / 2, dimension.height / 2 - frame.getHeight() / 2);

	}



	public static void main(String[] args) {
		Menu window = new Menu();
		window.open();
	}
}
