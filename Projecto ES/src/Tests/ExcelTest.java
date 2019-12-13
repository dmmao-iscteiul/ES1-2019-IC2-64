package Tests;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Vector;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.junit.Test;

import es.Excel;

public class ExcelTest {

	@Test
	public void test() {
		try {
			Excel j = new Excel(new File("C:/Users/UX411/Downloads/Long-Method.xlsx"));
			XSSFSheet teste = j.getSheet();
			Vector<String> c0 = j.getColumnString(0);
			
			Vector<String> ex = new Vector<String>();
			for (double i = 1; i<=420; i++) {
				ex.add(String.valueOf(i));
			}
			
			for (String s : c0) {
				System.out.println(s);
			}
			assertEquals(ex, c0);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
