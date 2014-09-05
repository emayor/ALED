package es.upm.dit.fprg.p3;

/**
 * Clase que representa la variación del peso de un paciente en tratamiento. 
 * @author Celia_Ordás_Díaz
 * @version 4_12_13
 */

public class Historico {

	private double historicoPesos[];

	public enum TENDENCIA {
		ENGORDA, ADELGAZA, MANTIENE, INDETERMINADO
	};

	/**
	 * Es el constructor de la clase.
	 * @param numeroRegistros Indica el número de registros que se almacenan en el
	 * histórico.
	 * @throws Exception Lanza excepciones cuando el valor que se pasa es menor que 3.
	 */
	public Historico(int numeroRegistros) throws ParametroErroneoException {

		if (numeroRegistros < 3) {
			throw new ParametroErroneoException(
					"El valor pasado es menor que 3");
		} else {
			historicoPesos = new double[numeroRegistros];
		}
	}

	/**
	 * En este método obtenemos el histórico.
	 * @return Devuelve el array que almacena el histórico.
	 */
	public double[] getHistorico() {
		return historicoPesos;
	}

	/**
	 * En este método modificamos el histórico.
	 * @param nuevoValor Sustituye el array historicoPesos por este parámetro.
	 * @throws Exception Lanza excepciones cuando el valor es null o no tiene la
	 * longitud mínima de 3 posiciones.
	 */
	public void setHistorico(double[] nuevoValor)
			throws ParametroErroneoException {
		if (nuevoValor == null || nuevoValor.length < 3) {
			throw new ParametroErroneoException(
					"El valor pasado es null o no tiene una longitud mínima de 3");
		} else {
			historicoPesos = nuevoValor;
		}
	}

	/**
	 * En este método se obtiene el peso perdido, al guardar otro.
	 * @param peso Es el valor que hay que añadir al histórico.
	 * @return Devuelve el peso que se pierde en el histórico al almacenar uno nuevo.
	 * @throws Exception  Lanza una excepción cuando el valor es menor que 0.
	 */
	public double guardarPeso(double peso) throws ParametroErroneoException {

		if (peso < 0.0) {
			throw new ParametroErroneoException("El valor es menor que cero.");
		}

		double ultimoPeso = historicoPesos[historicoPesos.length - 1];

		for (int i = (historicoPesos.length - 1); i >= 1; i--) {
			historicoPesos[i] = historicoPesos[i - 1];
		}

		historicoPesos[0] = peso;

		return ultimoPeso;
	}

	/**
	 * Este método borra el último peso almacenado volviendo el histórico al estado que
	 * tenía antes de introducir ese peso.
	 */

	public void borrarPeso() {

		for (int i = 0; i < historicoPesos.length - 2; i++) {
			historicoPesos[i] = historicoPesos[i + 1];
		}

		historicoPesos[historicoPesos.length - 1] = 0;
	}

	/**
	 * Este método analiza si el paciente ha engordado, adelgazada, se mantiene 
	 * o es indeterminado en relación a sus pesos.
	 * @param muestras Son las muestras a tener en cuenta para analizar la tendencia
	 * en el peso, empezando a contar desde el último peso introducido.
	 * @return Devuelve la tendecia del paciente según su peso.
	 * @throws ParametroErroneoException Se lanzan excepciones cuando el valor pasado 
	 * no esté en los intervalos aceptables para el análisis.
	 */

	public Historico.TENDENCIA analizarTendencia(int muestras)
			throws ParametroErroneoException {

		int nPesos = 0;
		boolean engorda = true;
		boolean adelgaza = true;
		boolean mantiene = true;

		for (int i = 0; i < historicoPesos.length; i++) {
			if (historicoPesos[i] != 0) {
				nPesos++;
			}
		}

		if (muestras < 2 || muestras > nPesos) {
			throw new ParametroErroneoException(
					"El valor no está en los intervalos aceptables para el análisis.");
		}

		for (int i = 0; i < historicoPesos.length - 2; i++) {
			if (historicoPesos[i] > historicoPesos[i + 1]) {
				if (historicoPesos[i + 1] != 0)
					adelgaza = false;
			}
			if (Math.abs(historicoPesos[i] - historicoPesos[i + 1]) >= 0.1) {
				if (historicoPesos[i + 1] != 0)
					mantiene = false;
			}
			if (historicoPesos[i] < historicoPesos[i + 1])
				engorda = false;
		}


		if (engorda)
			return Historico.TENDENCIA.ENGORDA;
		if (mantiene)
			return Historico.TENDENCIA.MANTIENE;
		if (adelgaza)
			return Historico.TENDENCIA.ADELGAZA;
		return Historico.TENDENCIA.INDETERMINADO;
	}


}