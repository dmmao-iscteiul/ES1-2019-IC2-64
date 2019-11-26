import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Excel {
	
	private File selectedExcel;

	public Excel(File selectedFile) {
		this.selectedExcel = selectedFile;
	}

	public void visualizar() {
		
	}
	
	public void importar(File f) {
		this.selectedExcel=f;
	}
	

}


