package es.upm.dit.fprg.p2;

public class Deportista {
	
	
	private float peso;
	public float getPeso(){return peso;}
	public void setPeso(float Peso){this.peso=Peso;}
	
	private boolean esMujer;
	public boolean getEsMujer(){return esMujer;}
	public void setEsMujer(boolean esMujer){
		this.esMujer=esMujer;}
	
	private int edad;
	public int getEdad(){return this.edad;}
	public void setEdad(int edad){this.edad=edad;}
	
	private int estatura;
	public int getEstatura(){return this.estatura;}
	public void setEstatura(int estatura){
		this.estatura=estatura;}
	
	

	/*caloriasDiarias, de tipo entero, que almacena el consumo
	 *  o gasto de Cal del día, a partir de las comidas y los 
	 *  ejercicios que el Deportista ha llevado a cabo. Las
	Cal diarias se inician a 0 cuando el Deportista duerme.*/

	private int caloriasDiarias;
	
	public Deportista(float peso, boolean esMujer, int edad, int estatura){
		this.peso = peso;
		this.esMujer =esMujer;
		this.edad = edad;
		this.estatura = estatura;}
		
	public int calcularMetabolismoBasal(){
		
		int metabolismoBasal;
		if(esMujer==true){
			metabolismoBasal = (int)(655.0955+(9.463*peso)+(1.8496*estatura)-(4.6756*edad));
			return metabolismoBasal;}
		
		else{metabolismoBasal = (int)(66.473+(13.752*peso)+(5.0033*estatura)-(6.755*edad));
		return metabolismoBasal;}
		
		}
	
	public void comer(int calorias){
		caloriasDiarias = caloriasDiarias + calorias;
	}
	
	public void comer(int[] calorias){
		for(int i=0; i < calorias.length; i++)
		{caloriasDiarias = caloriasDiarias + calorias[i];}}
	
	public void practicarCarrera(int minutos){
		CalculadorCaloriasQuemadas X = new CalculadorCaloriasQuemadas();
		int caloriasQuemadas = X.correr(minutos, this.peso);		
		caloriasDiarias = caloriasDiarias - caloriasQuemadas; 
	}
	public void practicarCiclismo(int minutos){
		CalculadorCaloriasQuemadas X = new CalculadorCaloriasQuemadas();
		int caloriasQuemadas = X.hacerBicicleta(minutos, this.peso);		
		caloriasDiarias = caloriasDiarias - caloriasQuemadas; 
	}
	public boolean dormir(){
		boolean adelgaza;		
		int cal=caloriasDiarias - this.calcularMetabolismoBasal();
		peso= peso + ((float)(cal)/9000f);
		if (cal<0)
		{caloriasDiarias=0;adelgaza=true; return adelgaza;}
		else
		{caloriasDiarias=0;adelgaza=false;return adelgaza;}
		
		}
	public void imprimirPeso(){
		System.out.println("El peso del deportista es " + peso);
	}

	
}

