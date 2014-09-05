package es.upm.dit.fprg.p3;

/**
 * Clase para calcular las calorias quemadas 
 * durante la realizacion de un ejercicio
 * 
 * @author Jose M. del Alamo
 */
public class CalculadorCaloriasQuemadas {

	private static final double FACTOR_CARRERA = 0.240;
	private static final double FACTOR_CICLISMO = 0.132;
		
	/**
	 * Este metodo calcula la cantidad de calorias quemadas
	 * durante una carrera de una duracion dada.
	 * @param minutos Duracion del ejercicio, en minutos
	 * @param peso Peso del deportista, en kilos
	 * @return Cantidad de calorias quemadas
	 */
	public int correr(int minutos, float peso){
		int caloriasQuemadas;
		caloriasQuemadas = (int) (FACTOR_CARRERA * peso * minutos);

		return caloriasQuemadas;
	}
	
	/**
	 * Este metodo calcula la cantidad de calorias quemadas
	 * durante un recorrido en bicicleta de una duracion dada.
	 * @param minutos Duracion del ejercicio, en minutos
	 * @param peso Peso del deportista, en kilos
	 * @return Cantidad de calorias quemadas
	 */


	public int hacerBicicleta(int minutos, float peso) {
		int caloriasQuemadas;
		caloriasQuemadas = (int) (FACTOR_CICLISMO * peso * minutos);

		return caloriasQuemadas;
	}
}

