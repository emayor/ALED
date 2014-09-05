package es.upm.dit.fprg.p3;

import es.upm.dit.fprg.p3.CalculadorCaloriasQuemadas;

/**
 * Clase que representa los datos y actividad de un deportista
 * 
 * @author Jose M. del Alamo
 */
public class Deportista {

	private float peso;
	private int edad;
	private int estatura;
	private boolean esMujer;
	private int caloriasDiarias;
	
	/**
	 * Constructor de la clase. Crea un objeto Deportista en funci�n de los argumentos.
	 * @param peso El peso, en kg, del deportista.
	 * @param mujer Indica si el Deportista es mujer (true) u hombre (false). 
	 * @param edad Los a�os del Deportista.
	 * @param estatura La altura en cent�metros.
	 */
	public Deportista(float peso, boolean mujer, int edad, int estatura) {
		this.peso = peso;
		this.edad = edad;
		this.estatura = estatura;
		this.esMujer = false;
		caloriasDiarias = 0;
	}
	
	/** Devuelve la edad actual del deportista
	 * @return La edad del deportista.
	 */
	public int getEdad() {
		return edad;
	}

	/** Modifica la edad del Deportista
	 * @param edad Los a�os del Deportista
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/** Devuelve la estatura actual del deportista
	 * @return La altura en cent�metros.
	 */
	public int getEstatura() {
		return estatura;
	}

	/** Modifica la estatura del Deportista
	 * @param estatura La altura en cent�metros.
	 */
	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}

	/** Devuelve el sexo actual del deportista
	 * @return true si es mujer. false si es hombre.
	 */
	public boolean getEsMujer(){
		return esMujer;
	}
	
	/** Modifica el sexo del Deportista
	 * @param mujer true si es una mujer y false si es un hombre.
	 */
	public void setEsMujer(boolean mujer) {
		this.esMujer = mujer;
	}

	/** Devuelve el peso actual del deportista
	 * @return El peso del deportista
	 */
	public float getPeso(){
		return peso;
	}
	
	/**
	 * Modifica el peso actual del deportista
	 * @param nuevoPeso El peso actual del deportista
	 */
	public void setPeso(float nuevoPeso){
		peso = nuevoPeso;
	}
	
	/**
	 * Devuelve el numero de calorias quemadas por este 
	 * deportista al correr
	 * @param minutos Duracion del ejercicio
	 * @return Cantidad de calorias quemadas
	 */
	public void practicarCarrera(int minutos){
		CalculadorCaloriasQuemadas ccq = new CalculadorCaloriasQuemadas();
		caloriasDiarias -= ccq.correr(minutos, peso);
	}
	
	/**
	 * Devuelve el numero de calorias quemadas por este deportista al 
	 * practicar ciclismo
	 * @param minutos Duracion del ejercicio
	 * @return Cantidad de calorias quemadas
	 */
	public void practicarCiclismo(int minutos){
		CalculadorCaloriasQuemadas ccq = new CalculadorCaloriasQuemadas();
		caloriasDiarias -= ccq.hacerBicicleta(minutos, peso);
	}
	
	/**
	 * Calcula las calor�as que el Deportista necesita para sobrevivir.
	 * @return Las calor�as necesarias para mantener el metabolismo basal del Deportista.
	 */
	public int calcularMetabolismoBasal(){
		double cal = 0;
		if(esMujer)
			cal = 655.0955 + (9.463*peso) + (1.8496*estatura) - (4.6756*edad);
		//Si es mujer
		else
			cal = 66.473 + (13.752*peso) + (5.0033*estatura) - (6.755*edad);	
		return (int) cal;
	}
	
	/**
	 * Ingiere calor�as de un alimento.
	 * @param calorias Las calor�as ingeridas por el Deportista.
	 */
	public void comer(int calorias){
		caloriasDiarias += calorias;
	}
	
	/**
	 * Ingiere calor�as de varios alimentos
	 * @param calorias Array de n posiciones con las calor�as de cada alimento consumido en una comida. Por ejemplo,
	 * en una comida con tres platos, el array tendr�a 3 posiciones [primer_plato, segundo_plato, postre].
	 */
	public void comer(int[] calorias){
		for(int i : calorias)
			caloriasDiarias += i;
	}
	
	/**
	 * Modifica el peso del Deportista en funci�n de las calor�as quemadas y consumidas durante el d�a.
	 * @param true si el Deportista ha adelgazado, false en caso contrario.
	 */
	public boolean dormir(){
		float resumenDiario = caloriasDiarias - calcularMetabolismoBasal();
		//El peso se modifica con las calor�as que han sobrado/faltado al final del dia (1 gramos por 9 calorias)
		peso += resumenDiario/9000;
		
		boolean adelgaza = true;
		if(resumenDiario >= 0)
			adelgaza = false;
		
		caloriasDiarias = 0;	//Iniciamos el contador de calorias del dia
		
		return adelgaza;
	}
	
	/**
	 * Este metodo imprime en pantalla el peso del deportista
	 */
	void imprimirPeso(){
		System.out.println("Peso "+peso+" kg.");
	}
	
	
}


