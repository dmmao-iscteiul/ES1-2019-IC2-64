package Tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

public class AllTests {

	@Test
	public void test() throws FileNotFoundException, InterruptedException {
		
		ExcelTest et = new ExcelTest();
		et.test();
	
		RegraTest rt = new RegraTest();
		rt.test();
		
		MenuTest mt = new MenuTest();
		mt.test();
		
		JanelaRegraTest jrt = new JanelaRegraTest();
		jrt.test();
		
	}

}
