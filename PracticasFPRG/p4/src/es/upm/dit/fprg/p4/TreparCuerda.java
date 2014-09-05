package es.upm.dit.fprg.p4;

import java.util.Date;

/**
 * Clase que representa una prueba física cuya ejecución consiste en elevar el cuerpo, 
 * mediante impulso de los brazos, hasta el final de una cuerda de 5 metros colgada del techo. 
 * @author jmdela
 *
 */
public class TreparCuerda extends PruebaFisica {

	//Tiempo invertido en la prueba, en segundos
	private int tiempo;
	
	/**
	 * Crea un objeto que representa el resultado de la prueba 'TreparCuerda'.
	 * @param fecha Fecha en la que se realizó la prueba.
	 * @param s Tiempo invertido, en segundos.
	 * @throws Exception Si s es negativo o fecha es nulo.
	 */
	public TreparCuerda(Date fecha, int s) throws Exception {
		super(fecha);

		if(s<0)
			throw new Exception("No se puede tardar un número negativo de segundos");
		
		tiempo = s;
	}
	
	/**
	 * Devuelve el número de segundos invertidos en la prueba.
	 * @return El número de segundos.
	 */
	public int getTiempo(){
		return tiempo;
	}
}