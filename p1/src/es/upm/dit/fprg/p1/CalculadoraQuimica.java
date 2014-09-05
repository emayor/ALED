package es.upm.dit.fprg.p1;

/**
 * Clase que ofrece las operaciones básicas de cálculo usadas en Química.
 * @author jmdela
 */
public class CalculadoraQuimica {

	/**
	 * Número de Avogadro. 
	 */
	public static final double NUMERO_AVOGADRO = 6.02214129E23;
	
	/**
	 * Calcula los moles de un elemento a partir de la información de la masa del elemento y su masa molecular.
	 * @param masa Los gramos de elemento de esta muestra
	 * @param masaMolecular La del elemento 
	 * @return El número de moles contenidos en la masa
	 */
	public double calcularMoles(double masa, double masaMolecular){
		double moles;
		
		moles = masa / masaMolecular;
		
		return moles;
	}
	
	/**
	 * Calcula el número de partículas de un elemento a partir del número de moles de ese elemento.
	 * @param moles El número de moles del elemento
	 * @return El número de partículas de ese elemento
	 */
	public long calcularParticulas(double moles){
		double particulas;
		
		particulas = moles * NUMERO_AVOGADRO;
		
		return (long)particulas;
	}
}
