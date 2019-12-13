package Tests;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Vector;

import org.junit.Test;

import es.Excel;
import es.Metrica;
import es.Regra;

public class RegraTest {

	@Test
	public void test() throws FileNotFoundException {
		Metrica m1 = new Metrica("LOC",1,1);
		Metrica m2 = new Metrica("CYCLO");
		Metrica m3 = new Metrica("LAA", 1, 0);
		
		Regra r1 = new Regra("R1",m3);
		
		Regra r2 = new Regra("R2", m1, m2,0);
		
		Regra r3 = new Regra("R3");
		
		Regra r4 = new Regra("IPlasma");
		
		ArrayList<Metrica> metricas = new ArrayList<Metrica>();
		metricas.add(m1);
		metricas.add(m2);
		
		ArrayList<Integer> valorR2 = new ArrayList<Integer>();
		valorR2.add(1);
		valorR2.add(0);
		
		ArrayList<Integer> valorR3 = new ArrayList<Integer>();
		valorR3.add(1);
		
		assertEquals(2,r2.numeroDeMetricas());
		assertEquals(metricas.get(1),r2.getMetricas(1));
		assertEquals("is_long_method",r2.getValorReferencia());
		assertEquals("is_feature_envy",r1.getValorReferencia());
		assertEquals("R2", r2.toString());
		assertEquals(valorR2, r2.getValoresMetricas());
		assertEquals("is_long_method", r4.getValorReferencia());
		
		Excel j = new Excel(new File("C:/Users/UX411/Downloads/Long-Method.xlsx"));
		
		Regra r5 = new Regra("R5", new Metrica("LOC", 1, 0));
		Regra r6 = new Regra("R6", new Metrica("LOC", 0, 2000));

		Regra r7 = new Regra("R7", new Metrica("LOC", 1, 0), new Metrica("CYCLO", 0, 2000), 1);
		
		Vector<String> ve = new Vector<String>();
		Vector<String> veaux = new Vector<String>();
		
		for (int i = 1; i<=420; i++) {
			ve.add("TRUE");
		}
		
		for (int i = 1; i<=840; i++) {
			veaux.add("TRUE");
		}
		
		Vector<String> comp = r5.getVectorResultado(j);
		Vector<String> comp2 = r6.getVectorResultado(j);
		Vector<String> comp3 = r7.getVectorResultado(j);


		for (String s : comp3) {
			System.out.println(s);
		}
		
		assertEquals(ve, comp);
		assertEquals(ve, comp2);
		assertEquals(veaux, comp3);


		
	}

}
