package es.upm.dit.fprg.p4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author Jose Ramon Figueira Alvarez
 * 
 */
public class Deportista {

	PruebaFisica[] Registro = null;
	
	/**
	 * Crea un deportista que consta de un array en el que se guardan las pruebas pasadas por este.
	 */
	public Deportista(){
		Registro = new PruebaFisica[4];
	}
	/**
	 * Guarda las pruebas pasadas por el deportista sobreescribiendo las antiguas.
	 * @param unaPrueba La prueba a guardar del deportista.
	 * @throws Exception Lanza excepcion si la prueba pasada tiene valor null.
	 */
	public void guardarPrueba(PruebaFisica unaPrueba) throws Exception{
		
		if(unaPrueba==null){
			throw new NullPointerException("NullPointerException");
		}
		
		if(unaPrueba instanceof Resistencia){
			if(Registro[0]==null||!(Registro[0] instanceof PruebaFisica)){
				Registro[0]=unaPrueba;
			}
			else{
				if(Registro[0].getFechaRealizacion().compareTo(unaPrueba.getFechaRealizacion())>=0){
					throw new Exception("Existe una prueba del mismo tipo y mas reciente");
				}
				Registro[0]=unaPrueba;
			}
			
		}
		if(unaPrueba instanceof SaltoVertical){
			if(Registro[1]==null||!(Registro[1] instanceof PruebaFisica)){
				Registro[1]=unaPrueba;
			}
			else{
				if(Registro[1].getFechaRealizacion().compareTo(unaPrueba.getFechaRealizacion())>=0){
					throw new Exception("Existe una prueba del mismo tipo y mas reciente");
				}
				Registro[1]=unaPrueba; 
			}
		}
		if(unaPrueba instanceof Dominadas){
			
			if(Registro[2]==null||!(Registro[2] instanceof PruebaFisica)){
				Registro[2]=unaPrueba;
			}
			else{
				if(Registro[2].getFechaRealizacion().compareTo(unaPrueba.getFechaRealizacion())>=0){
					throw new Exception("Existe una prueba del mismo tipo y mas reciente");
				}
				Registro[2]=unaPrueba; 
			}
		}
		if(unaPrueba instanceof TreparCuerda){
			if(Registro[3]==null||!(Registro[3] instanceof PruebaFisica)){
				Registro[3]=unaPrueba;
			}
			else{
				if(Registro[3].getFechaRealizacion().compareTo(unaPrueba.getFechaRealizacion())>=0){
					throw new Exception("Existe una prueba del mismo tipo y mas reciente");
				}
				Registro[3]=unaPrueba; 
			}
		}
		
	}
	
	/**
	 * Devuelve una lista con las pruebas pasadas por el deportista entre las fechas pasadas como parametro.
	 * @param desde Fecha desde la que se empezaran a tomar las pruebas para la lista. 
	 * @param hasta Fechas hasta la que se tomaran las pruenbas para la lista.
	 * @return Lista formada por las pruebas fisicas que estan entre las fechas indicadas.
	 * @throws Exception Lanza excepcion si la fecha desde es posterior a la hasta o si cualquieras de las dos fechas toman el valor null.
	 */
	public List<PruebaFisica> obtenerPruebas (Date desde, Date hasta) throws Exception{
		int cuenta=0;
		
		if(desde.compareTo(hasta)>0){
			throw new Exception("La fecha introducida en segundo lugar debe ser posterior a la primera");
		}
		if(desde==null||hasta ==null){
			throw new NullPointerException("NullPointerException");
		}
		ArrayList<PruebaFisica> Lista1 = new ArrayList<PruebaFisica>();
		
		for(int i=0; i<Registro.length;i++){
			if(Registro[i] == null){
				cuenta++;
			}
		}
		
		if(cuenta==Registro.length){
			
		}
		
		else{
			
			if(Registro[0]!=null && ((Registro[0].getFechaRealizacion()).compareTo(desde)>0||Registro[0].getFechaRealizacion().compareTo(hasta)<0)){
				Lista1.add(Registro[0]);
			}
			else{
				
			}	
			
			if(Registro[1]!=null && ((Registro[1].getFechaRealizacion()).compareTo(desde)>0||Registro[1].getFechaRealizacion().compareTo(hasta)<0)){
				Lista1.add(Registro[1]);
			}
			else{
				
			}
			if(Registro[2]!=null && ((Registro[2].getFechaRealizacion()).compareTo(desde)>0||Registro[2].getFechaRealizacion().compareTo(hasta)<0)){
				Lista1.add(Registro[2]);
			}
			else{
				
			}
			if(Registro[3]!=null && ((Registro[3].getFechaRealizacion()).compareTo(desde)>0||Registro[3].getFechaRealizacion().compareTo(hasta)<0)){
				Lista1.add(Registro[3]);
			}
			else{
				
			}
		}
		return Lista1;
		
	}
	/**
	 * Elimina las pruebas hasta la fecha pasada como parametro.
	 * @param hasta Fecha hasta la que se eliminaran las pruebas.
	 * @return El numero de pruebas eliminadas.
	 * @throws Exception Lanza excepcion si la fecha hasta toma el valor null.
	 */
	public int eliminarPruebas (Date hasta) throws Exception{
		int cuenta = 0;
		if(hasta==null){
			throw new NullPointerException("NullPointerException");
		}
		
		if(Registro[0]!=null && Registro[0].getFechaRealizacion().compareTo(hasta)<0){
			Registro[0]=null;
			cuenta++;
		}
		if(Registro[1]!=null && Registro[1].getFechaRealizacion().compareTo(hasta)<0){
			Registro[1]=null;
			cuenta++;
		}
		if(Registro[2]!=null && Registro[2].getFechaRealizacion().compareTo(hasta)<0){
			Registro[2]=null;
			cuenta++;
		}
		if(Registro[3]!=null && Registro[3].getFechaRealizacion().compareTo(hasta)<0){
			Registro[0]=null;
			cuenta++;
		}
		return cuenta;
	}
	/**
	 * Muestra si el deportista tienes pruebas almacenadas anteriores a la fecha pasada como parametro.
	 * @param hasta Fecha hasta la que se consideraran las pruebas antiguas.
	 * @return Devuelve true en el caso de que haya pruebas antiguas y false en le caso contrario.
	 * @throws Exception Lanza excepcion si el parametro pasado toma el valor null.
	 */
	public boolean tieneAntiguas (Date hasta) throws Exception{
		boolean antiguas;
		if(hasta==null){
			throw new NullPointerException("NullPointerException");
		}
		if((Registro[0]!=null && Registro[0].getFechaRealizacion().compareTo(hasta)<0)||(Registro[1]!=null && Registro[1].getFechaRealizacion().compareTo(hasta)<0)||(Registro[2]!=null && Registro[2].getFechaRealizacion().compareTo(hasta)<0)||(Registro[3]!=null && Registro[3].getFechaRealizacion().compareTo(hasta)<0)){
			antiguas=true;
		}
		else{
			antiguas=false;
		}
		return antiguas;
	}	
	/**
	 * Muestra si el deportista alcanza una determinada marca en la prueba de resistencia.
	 * @return Devuelve true si alcanza la marca y false en caso contrario.
	 */
	public boolean fallaResistencia(){
		boolean tiempoApto = false;
			  if (Registro[0] instanceof Resistencia){			 
				  if(((Resistencia)Registro[0]).getTiempo()<200){
					  tiempoApto = true;
				  }
			  }
		return tiempoApto;
	}
	/**
	 * Muestra si el deportista supera los requisitos para ser bombero.
	 * @return Devuelve true si cumple los requisitos y false en caso contrario.
	 */
	public boolean esApto(){
		boolean esApto = false;
		boolean pruebasPasadas[]=new boolean[4];
		int cuenta=0;
		
			if (Registro[0] != null && Registro[0] instanceof Resistencia){			 
			  if(((Resistencia)Registro[0]).getTiempo()<200){
				  pruebasPasadas[0] = true;
			  }
			}
			
			if(Registro[1] != null && Registro[1] instanceof SaltoVertical){
				if(((SaltoVertical)Registro[1]).getCentimetros()>55){
					pruebasPasadas[1]=true;
				}
			}
			
			if(Registro[2] != null && Registro[2] instanceof Dominadas){
				if(((Dominadas)Registro[2]).getNumero()>=25){
					pruebasPasadas[2]=true;
				}
			}
			
			if(Registro[3] != null &&Registro[3] instanceof TreparCuerda){
				if(((TreparCuerda)Registro[3]).getTiempo()<30){
					  pruebasPasadas[3]=true;
				}
			}
			
			  for(int i=0;i<pruebasPasadas.length;i++){
				  if(pruebasPasadas[i]==true){
					  cuenta++;
				  }
			  }
			  if(cuenta==pruebasPasadas.length){
				  esApto=true;
			  }
		
		
		return esApto;
	}
}

