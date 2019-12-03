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

	public DefaultTableModel getMetricaTable(Metrica metrica) throws Exception {		
		DefaultTableModel result = new DefaultTableModel();
		result.addColumn("Metodo", getColumn(3));

		switch(metrica) {

		default:
			throw new Exception("Erro a identificar a métrica");

		case LOC:
			result.addColumn("LOC", getColumn(4));
			return result;

		case LAA:
			result.addColumn("LAA", getColumn(5));
			return result;

		case CYCLO:
			result.addColumn("CYCLO", getColumn(6));
			return result;

		case ATFD:
			result.addColumn("ATFD", getColumn(7));
			return result;
		
		case PMD:
			result.addColumn("PMD", getColumn(8));
			return result;
		
		case is_long_method:
			result.addColumn("is_long_method", getColumn(9));
			return result;
			
		case is_feature_envy:
			result.addColumn("is_feature_envy", getColumn(10));
			return result;
		}
	}

	public void importar() {
		int numColumns = this.excelSheet.getRow(0).getLastCellNum()-1;
		String temp;
		
		for(int indexColumn = 0; indexColumn < numColumns; indexColumn ++ ) {
			temp = this.excelSheet.getRow(0).getCell(indexColumn).toString();
			this.modelTable.addColumn(temp, getColumn(indexColumn));
		}
		
		JOptionPane.showMessageDialog(null, "Imported Successfully !!.....");

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

	public Vector<String> getColumn(int column) {
		Vector<String> v = new Vector<String>();
		for (int rowIndex = 1; rowIndex<excelSheet.getLastRowNum()+1; rowIndex++){
			XSSFCell cell = excelSheet.getRow(rowIndex).getCell(column);
			v.add(cell.toString());
			
		}
		return v;
		
	}

}	







