package es.upm.dit.fprg.p3;

/**
 * Clase que caracteriza las excepciones debidas a un paso de valores de parámetros incorrectos.
 * @author jmdela
 *
 */
public class ParametroErroneoException extends Exception {

	/**
	 * Constructor de la clase. Crea la excepción con el mensaje asociado.
	 * @param msg El mensaje que se quiere transmitir.
	 */
	public ParametroErroneoException(String msg){
		super(msg);
	}
}