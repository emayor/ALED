package es.upm.dit.fprg.p4;

import java.util.Date;

/**
 * Clase que representa una prueba física cuya ejecución consiste en levantar el cuerpo, 
 * pendiendo de una barra horizontal suspendida en el aire. El agarre a ésta puede ser 
 * supinado (o sea que las palmas de tus manos miren hacia ti) o pronado (con las palmas 
 * hacia el exterior), o, incluso, mixto o simple (es decir, con una mano). Para realizar
 * las flexiones se parte de la posición de reposo en la que los brazos se encuentran 
 * totalmente estirados, y se eleva el cuerpo mediante la flexión de los brazos, hasta 
 * que la barbilla sobrepase a la barra sobre la cual se pende, sin elevar las piernas 
 * durante el proceso.
 * @author jmdela
 *
 */
public class Dominadas extends PruebaFisica {

	//Número de dominadas realizadas durante la prueba.
	private int numero;
	
	/**
	 * Crea un objeto que representa el resultado de la prueba 'Dominadas'.
	 * @param fecha Fecha en la que se realizó la prueba.
	 * @param n Número de dominadas conseguidas.
	 * @throws Exception Si n es negativo o fecha es nulo.
	 */
	public Dominadas(Date fecha, int n) throws Exception {
		super(fecha);

		if(n<0)
			throw new Exception("No se puede hacer un número negativo de dominadas");
		
		numero = n;
	}
	
	/**
	 * Devuelve el número de dominadas conseguidas en la prueba.
	 * @return El número de dominadas.
	 */
	public int getNumero(){
		return numero;
	}
}