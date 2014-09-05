package es.upm.dit.fprg.p1;

/**
 * Clase que representa al compuesto químico Coruro de Rubidio.
 * @author jmartin
 */
public class CloruroRubidio {

	private double masaMolecular;
	//masa de la muestra, en gramos.
	private int masa;

	/**
	 * Constructor de la clase. Inicializa el estado del objeto.
	 * @param nuevaMasa masa de la muestra, en gramos.
	 */
	public CloruroRubidio(int nuevaMasa){
		
		masaMolecular = 120.92;
		masa =	nuevaMasa;	
	}
	
	/**
	 * Modifica la masa de la muestra.
	 * @param masa nueva masa de la muestra, en gramos.
	 */
	public void setMasa(int masa){
		
		masa = this.masa;
	}
	
	/**
	 * Devuelve la masa de la muestra.
	 * @return La masa de la muestra, en gramos.
	 */
	public int getMasa(){
		
		return masa;
	}
	
	/**
	 * Añade masa a la muestra y devuelve la nueva masa.
	 * @param masaAdicional Masa añadida a la muestra.
	 * @return La nueva masa de la muestra.
	 */
	public int incorporarMasa(int masaAdicional){
		
		masa = masa + masaAdicional;
		return masa;
	}
	
	/**
	 * Elimina masa a la muestra y devuelve la nueva masa.
	 * @param masaSustraida Masa eliminada de la muestra
	 * @return La nueva masa de la muestra.
	 */
	public int retirarMasa(int masaSustraida){
		
		masa = masa - masaSustraida;
		return masa;
	}

	/**
	 * Calcula el número de moles de la muestra
	 * @return Número de moles de la muestra.
	 */
	public double calcularMoles(){
		
		CalculadoraQuimica cQ = new CalculadoraQuimica();
		double moles = cQ.calcularMoles(masa, masaMolecular);
		return moles;
	}
	
	/**
	 * Calcula el número de partículas de la muestra.
	 * @return Número de partículas de la muestra.
	 */
	public long calcularParticulas(){
		
		CalculadoraQuimica cQ = new CalculadoraQuimica();
		long particulas = cQ.calcularParticulas(calcularMoles());
		return particulas;
		
	}
	
}
