import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Menu {
	private JFrame frame;

	public Menu(String title) {
		frame = new JFrame(title);
		
		// para que o botao de fechar a janela termine a aplicacao
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		addFrameContent();
		
		// para que a janela se redimensione de forma a ter todo o seu conteudo visivel
		frame.pack();
	}

	public void open(int width, int height) {
		frame.setSize(width, height);
		
		// para abrir a janela (torna-la visivel)
		frame.setVisible(true);
	}

	private void addFrameContent() {
		
		
		/* para organizar o conteudo em grelha (linhas x colunas)
		se um dos valores for zero, o numero de linhas ou colunas (respetivamente) fica indefinido,
		e estas sao acrescentadas automaticamente */
		frame.setLayout(new GridLayout(4,0));

		JLabel label = new JLabel("Title");
		frame.add(label);

		JTextField text = new JTextField("Hello");
		frame.add(text);
		
		JLabel widthLabel = new JLabel("width");
		frame.add(widthLabel);

		JTextField widthText = new JTextField("300");
		frame.add(widthText);
		
		JLabel heightLabel = new JLabel("height");
		frame.add(heightLabel);

		JTextField heightText = new JTextField("150");
		frame.add(heightText);
		
		JCheckBox center = new JCheckBox("center");
		
		JButton update = new JButton("update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Alterar titulo
				frame.setTitle(text.getText());
				
				//Alterar tamanho
				frame.setSize(Integer.parseInt(widthText.getText()), Integer.parseInt(heightText.getText()));
				if(center.isSelected()) {
					centerFrame();
				}
			}
		});
		frame.add(update);	
		frame.add(center);
		
	}

	private void centerFrame() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		
		frame.setLocation(dimension.width / 2 - frame.getWidth() / 2, dimension.height / 2 - frame.getHeight() / 2);
		
	}
	public static void main(String[] args) {
		Menu window = new Menu("Hello");
		window.open(300,150);
	}
}
