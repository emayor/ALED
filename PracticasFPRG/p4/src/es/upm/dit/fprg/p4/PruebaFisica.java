package es.upm.dit.fprg.p4;

import java.util.Date;

/**
 * Clase abstracta que representa una prueba física genérica.
 * @author jmdela
 *
 */
public class PruebaFisica {

	//Fecha cuando se ha realizado la prueba física
	private Date fecha;
	
	/**
	 * Constructor de la clase. 
	 * @param fechaRealizacion Fecha en la que se realizó la prueba
	 * @throws Exception Si algún argumento es nulo.
	 */
	public PruebaFisica(Date fechaRealizacion) throws Exception{
		if(fechaRealizacion==null)
			throw new Exception("Los argumentos no pueden ser nulos");
		
		fecha = fechaRealizacion;
	}
	
	/**
	 * Devuelve la fecha en la que se realizó la prueba.
	 * @return La fecha en la que se realizó la prueba.
	 */
	public Date getFechaRealizacion(){
		return fecha;
	}
	
	/**
	 * Comprueba si la prueba pasada como parámetro es del mismo tipo que esta.
	 * @param p La prueba que se quiere comprobar
	 * @return true si la prueba es del mismo tipo, false en otro caso.
	 */
	public boolean esMismoTipo(PruebaFisica p){
		boolean iguales = false;
		if(this.getClass().equals(p.getClass()))
			iguales = true;
		
		return iguales;
	}
}