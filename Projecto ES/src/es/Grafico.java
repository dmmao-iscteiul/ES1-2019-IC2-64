package es;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.BorderFactory;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.Color;
import java.awt.EventQueue;

public class Grafico {

	private int DCI = 0;
	private int DII = 0;
	private int ADCI = 0;
	private int ADII = 0;
	private Vector<String> colunaRegra;
	private Vector<String> colunaReferencia;
	private JFrame frame;

	public Grafico(Vector<String> colunaRegra, Vector<String> colunaReferencia) {
		this.colunaReferencia = colunaReferencia;
		this.colunaRegra = colunaRegra;
		addDefeitos();

		this.frame = new JFrame();
		this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addFrameContent();
		this.frame.pack();

	}

	public void addFrameContent() {
		CategoryDataset dados = criarDados();

		JFreeChart chart=ChartFactory.createBarChart(
				"Analise da Qualidade de Deteção de Defeitos", //Chart Title
				"Defeitos", // Category axis
				"Metodos", // Value axis
				dados,
				PlotOrientation.VERTICAL,
				true,true,false
				);

		ChartPanel panel=new ChartPanel(chart);
		frame.add(panel);

		frame.setSize(800, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

	public CategoryDataset criarDados() {
		DefaultCategoryDataset dados = new DefaultCategoryDataset();
		dados.setValue(DCI, "Número de Métodos", "DCI");
		dados.setValue(DII, "Número de Métodos", "DII");
		dados.setValue(ADCI, "Número de Métodos", "ADCI");
		dados.setValue(ADII, "Número de Métodos", "ADII");

		return dados;
	}

	public void open() {
		this.frame.setVisible(true);
	}

	/**
	 * 
	 * Percorremos o resultado da ferramenta IPlasma e PMD ou de uma regra criada pelo utilizador do software. 
	 * Consoante as métricas da Regra/Ferramenta comparamos com a coluna do ficheiro Excel do "is_long_method"
	 * ou "is_feature_envy", conforme o resultado incrementa, o contador do defeito. 
	 */
	
	private void addDefeitos() {
		
		for(int i = 0; i<colunaRegra.size(); i++) {
			if(colunaRegra.get(i).equals("TRUE")) {

				if(colunaReferencia.get(i).equals("TRUE")){
					DCI++;
				}
				else if(colunaReferencia.get(i).equals("FALSE")){
					DII++;
				}
			}
			else if(colunaRegra.get(i).equals("FALSE")) {
				if(colunaReferencia.get(i).equals("FALSE")) 
					ADCI++;
				else if (colunaReferencia.get(i).equals("FALSE")) 
					ADII++;		
			}
		}
	}






}