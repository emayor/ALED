package es.upm.dit.fprg.p3;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GimnasioTest {
	
	private Gimnasio g;
	private Deportista d1 = new Deportista(10,false,10,10);
	private Deportista d2 = new Deportista(20,false,10,10);
	private Deportista d3 = new Deportista(30,false,10,10);
	private Deportista d4;
	@Before
	public void setup() throws Exception{
		g  = new Gimnasio(2);
	}

	@Test
	public void testMatricular(){
		assertEquals(0,g.getNumeroDeportistas());
	
		try {
			g.matricular(d1);
		} catch (Exception e) {
			fail("No deberia dar error en matriculacion");
		}
		
		assertEquals(1,g.getNumeroDeportistas());
		
		try {
			g.matricular(d1);
			fail("Deberia dar error en matriculacion");
		} catch (Exception e) {System.out.println("La excepcion(matricular dos veces al mismo deportista) esta correctamente lanzada");}
		
		assertEquals(1,g.getNumeroDeportistas());
	
		try {
			g.matricular(d2);
		} catch (Exception e) {
			fail("No deberia dar error en matriculacion");
		}
		
		assertEquals(2,g.getNumeroDeportistas());		
	
	
	
		try {
			g.matricular(d3);
			fail("No deberia avanzar hasta esta linea de codigo");
		} catch (Exception e) {
			System.out.println("La excepcion(no puede matricularse a un deportista si el gimnasio esta lleno) esta correctamente lanzada");
		}
		assertEquals(2,g.getNumeroDeportistas());
	}
	
	@Test
	public void testDarBaja(){
		assertEquals(0,g.getNumeroDeportistas());
	
		try {
			g.matricular(d1);
		} catch (Exception e) {
			fail("No deberia dar error en matriculacion");
		}
		try {
			g.matricular(d2);
		} catch (Exception e) {
			fail("No deberia dar error en matriculacion");
		}
		
		assertEquals(2,g.getNumeroDeportistas());	
		
		try {
			g.darBaja(d4);
			fail("El codigo no de llegar hasta aqui");
		} catch (Exception e) {
			System.out.println("La excepcion(deportista null imposible de desmatricular) esta correctamente lanzada");
		}
		
		assertEquals(2,g.getNumeroDeportistas());
		
		try {
			g.darBaja(d1);
		} catch (Exception e) {
			fail("No deberia dar error al dar de baja a un deportista ya matriculado");
		}
		assertEquals(1,g.getNumeroDeportistas());
		
		try {
			g.darBaja(d3);
			fail("El codigo no debe leerse por aqui");
		} catch (Exception e) {
			System.out.println("La excepcion(no se puede desmatricular a un deportista que no esta matriculado) esta correctamente lanzada");
		}
	}
}


