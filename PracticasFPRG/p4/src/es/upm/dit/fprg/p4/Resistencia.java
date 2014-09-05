package es.upm.dit.fprg.p4;

import java.util.Date;

/**
 * Clase que representa una prueba física cuya ejecución consiste en recorrer un kilómetro 
 * en el menor tiempo posible. 
 * @author jmdela
 *
 */
public class Resistencia extends PruebaFisica {

	//Tiempo, en segundos, invertido en recorrer un kilómetro.
	private int tiempo;
	
	/**
	 * Crea un objeto que representa el resultado de la prueba 'Resistencia'.
	 * @param fecha Fecha en la que se realizó la prueba.
	 * @param s Tiempo invertido en realizar la prueba, en segundos.
	 * @throws Exception Si s es negativo o fecha es nulo.
	 */
	public Resistencia(Date fecha, int s) throws Exception {
		super(fecha);

		if(s<0)
			throw new Exception("No se puede hacer un tiempo negativo en la prueba");
		
		tiempo = s;
	}
	
	/**
	 * Devuelve el número de segundos invertidos en realizar un kilómetro.
	 * @return Los segundos transcurridos.
	 */
	public int getTiempo(){
		return tiempo;
	}
}				