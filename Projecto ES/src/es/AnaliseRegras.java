package es;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import org.apache.poi.xssf.usermodel.XSSFSheet;

public class AnaliseRegras {

	private JFrame frame;
	private DefaultListModel<Regra> regras;
	private Excel excel;

	public AnaliseRegras(Excel excel, DefaultListModel<Regra> regras) {
		this.excel = excel;
		this.regras = regras;
		this.frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		addFrameContent();
		frame.pack();
	}

	public void open() {
		frame.setVisible(true);
	}
	
	/**
	 * 
	 * dispõe o layout, percorre as regras todas,
	 *  e ao pressionar na regra, 
	 * comparamos a coluna dos trues e dos false da regra 
	 * ao is_long_method ou ao feature_envy
	 *  
	 */

	public void addFrameContent() {
		frame.setLayout(new GridLayout(regras.size()+1, 1));
		
		JLabel labelRegras = new JLabel();
		labelRegras.setText("Escolha a Qualidade/Regra a analisar a Qualidade");
		frame.add(labelRegras);

		for(int i = 0; i<regras.size(); i++) {
			final Regra regra = regras.getElementAt(i);
			JButton b = new JButton(regra.getNome());
			frame.add(b);
			
			b.addActionListener(new ActionListener() {				
				public void actionPerformed(ActionEvent e) {
			
					if(regra.getValorReferencia().equals("is_long_method")) {
						Grafico g = new Grafico(regra.getVectorResultado(excel), excel.getColumnString(8));
						g.open();
					}
					else if(regra.getValorReferencia().equals("is_feature_envy")) {
						Grafico g = new Grafico(regra.getVectorResultado(excel), excel.getColumnString(11));
						g.open();
					}		
				}
			});
			
		}

	}
}


