import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Excel {
	
	private File selectedExcel;
	
	public Excel() {
		selectedExcel=null;
	}
	public void visualizar() {
		// Visualizar ficheiro
	}
	
	public void importar(File f) {
		this.selectedExcel=f;
	}
	
	public void setSelectedExcel(File selectedExcel) {
		this.selectedExcel = selectedExcel;
	}
}


