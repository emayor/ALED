package es.upm.dit.fprg.p4;

import java.util.Date;

/**
 * Clase que representa una prueba física cuya ejecución consiste en elevar el cuerpo, 
 * mediante impulso de las piernas, la mayor altura posible. 
 * @author jmdela
 *
 */
public class SaltoVertical extends PruebaFisica {

	//Distancia conseguida con el salto
	private int centimetros;
	
	/**
	 * Crea un objeto que representa el resultado de la prueba 'SaltoVertical'.
	 * @param fecha Fecha en la que se realizó la prueba.
	 * @param cm Altura conseguida, en centímetros.
	 * @throws Exception Si cm es negativo o fecha es nulo.
	 */
	public SaltoVertical(Date fecha, int cm) throws Exception {
		super(fecha);

		if(cm<0)
			throw new Exception("No se puede hacer un número negativo de centímetros");
		
		centimetros = cm;
	}
	
	/**
	 * Devuelve el número de centímetros conseguidos con el salto.
	 * @return El número de centímetros.
	 */
	public int getCentimetros(){
		return centimetros;
	}
}