package es;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	private FileInputStream excelFIS = null;
	private BufferedInputStream excelBIS = null;
	private XSSFWorkbook excelImportToJTable = null;
	private XSSFSheet excelSheet;
	private DefaultTableModel modelTable;


	public Excel(File excelFile) throws FileNotFoundException {
		modelTable = new DefaultTableModel();
		try {
			excelFIS = new FileInputStream(excelFile);
			excelBIS = new BufferedInputStream(excelFIS);
			excelImportToJTable = new XSSFWorkbook(excelBIS);

		} catch (IOException e) {
			e.printStackTrace();
		}
		excelSheet = excelImportToJTable.getSheetAt(0);
		importar();	
	}

	public String getName() {
		return excelSheet.getSheetName();
	}


	public DefaultTableModel getModelTable() {
		return this.modelTable;
	}
	
	public XSSFSheet getSheet() {
		return this.excelSheet;
	}

	

	public void importar() {
		int numColumns = this.excelSheet.getRow(0).getLastCellNum()-1;
		String temp;
		
		for(int indexColumn = 0; indexColumn < numColumns; indexColumn ++ ) {
			temp = this.excelSheet.getRow(0).getCell(indexColumn).toString();
			this.modelTable.addColumn(temp, getColumnString(indexColumn));
		}
		
		JOptionPane.showMessageDialog(null, "Importado com sucesso!");

		try {
			if (excelFIS != null) {
				excelFIS.close();
			}
			if (excelBIS != null) {
				excelBIS.close();
			}
			if (excelImportToJTable != null) {
				excelImportToJTable.close();
			}
		} catch (IOException iOException) {
			JOptionPane.showMessageDialog(null, iOException.getMessage());
		}
	}

	public Vector<String> getColumnString(int column) {
		Vector<String> v = new Vector<String>();
		for (int rowIndex = 1; rowIndex<excelSheet.getLastRowNum()+1; rowIndex++){
			XSSFCell cell = excelSheet.getRow(rowIndex).getCell(column);
			v.add(cell.toString());			
		}
		return v;		
	}
	
}	

