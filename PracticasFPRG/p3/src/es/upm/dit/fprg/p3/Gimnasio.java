package es.upm.dit.fprg.p3;

/**
 * Clase para almacenar, los deportistas creados, en un gimnasio.
 * 
 * @author Jose R. Figueira
 */

public class Gimnasio {
	
	private Deportista[] gimnasio;
	
	
	/**
	 * El metodo Gimnasio es el constructor de la clase gimnasio, 
	 * que crea un nuevo array de deportistas cuya longitud es 
	 * aquella introducida mediante el parametro plazas. 
	 * @param plazas El numero de plazas que posee el gimnasio.
	 * @throws Exception Lanza una excepcions si el valor asignado a plazas es menor que 1.
	 */
	public Gimnasio(int plazas) throws Exception{
		if(plazas<=0){
			throw new Exception("Debe haber al menos una plaza");
		}
		gimnasio = new Deportista[plazas];
		
	}
	
	/**
	 * Matricula un deportista en el gimnasio.
	 * @param deportista El deportista a matricular en el gimnasio.
	 * @throws Exception Lanza una excepcion si el parametro deportista pasado vale null,
	 *  si el deportista ya esta matriculado o si el gimnasio esta lleno
	 */
	
	public void matricular (Deportista deportista) throws Exception{
		int cuenta=0;
		if(deportista == null){
			throw new Exception("Ese deportista no existe");
		}
		for(int i = 0; i<gimnasio.length;i++){
			if(gimnasio[i]!=null){
				cuenta++;
			}
			if(gimnasio[i]==deportista){
				throw new Exception("El deportista ya esta matriculado");
			}
		}
		if(cuenta==gimnasio.length){
			throw new Exception("El gimnasio esta lleno");
		}
		for(int i=0;i<gimnasio.length;i++){
			if(gimnasio[i]==null){
				gimnasio[i]=deportista;
				break;
			}
		}
	}
	
	/**
	 * Desmatricula al deportista pasado como parametro.
	 * @param deportista El deportista a desmatricular en el gimnasio.
	 * @throws Exception Lanza una excepcion si el parametro pasado vale null 
	 * o si el deportista pasado como parametro no esta matriculado en el gimnasio.
	 */
	
	
	public void darBaja (Deportista deportista) throws Exception{
		int cuenta=0;
				
		if(deportista == null){
			throw new Exception("Ese deportista no existe");
		}
		for(int i=0;i<gimnasio.length;i++){
			if(gimnasio[i]==deportista){
				gimnasio[i]=null;
				cuenta++;
			}
				
		}
		if(cuenta==0){
			throw new Exception("El deportista no esta matriculado");
		}
	}
	
	/**
	 * Devuelve el numero de deportistas matriculados en el gimnasio.
	 * @return El numero de deportistas matriculados.
	 */
	
	public int getNumeroDeportistas(){
		int cuenta = 0;
		for(int i=0;i<gimnasio.length;i++){
			if(gimnasio[i]!=null){
				cuenta++;
			}
		}
		return cuenta;
	}
	
	/**
	 * Devuelve, en forma de array, la situacion actual del gimnasio.
	 * @return Un array con la situacion actula del gimnasio.
	 */
	
	public Deportista[] getDeportistas(){
		return gimnasio;
	}
	
	/**
	 * Devuelve un array que contiene exclusivamente los deportistas
	 * apuntados al gimnasio que se encuentra entre un determinado peso (mayor que el
	 * peso mínimo y menor que el peso máximo).
	 * @param pesoMinimo El peso minimo requerido para que el deportista se considere apto
	 * @param pesoMaximo El peso maximo que no se puede superar para que el deportista se considere apto
	 * @return Un array en el que se almacenan solo los deportistas cuyo peso se encuentra entre los dos parametros
	 * @throws Exception Lanza una excepcion si cualquiera de los parametros es menor que cero o si el valor del 
	 * parametro pesoMaximo es menor que el valor del parametro pesoMinimo.
	 */
	
	public Deportista[] getDeportistas(int pesoMinimo, int pesoMaximo) throws Exception{
		int cuenta=0;
		if(pesoMinimo<0||
				pesoMaximo<0||
				pesoMaximo<pesoMinimo){
			throw new Exception("Los pesos introducidos no son correctos");
		}
		for(int i=0;i<gimnasio.length;i++){
			if(gimnasio[i]!=null && 
					gimnasio[i].getPeso()<pesoMaximo && 
					gimnasio[i].getPeso()>pesoMinimo){
				cuenta++;
			}
		}
		Deportista[] gim = new Deportista[cuenta];
		
		for(int i=0;i<gimnasio.length;i++){
			if(gimnasio[i]!=null &&
					gimnasio[i].getPeso()<pesoMaximo && 
					gimnasio[i].getPeso()>pesoMinimo){
				for(int j=0;j<gimnasio.length;j++){
					if(gim[j]==null){
						gim[j]=gimnasio[i];
						break;
					}
				}
			}
		}
		
		return gim;
	}
}