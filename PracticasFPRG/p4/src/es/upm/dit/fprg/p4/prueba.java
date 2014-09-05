package es.upm.dit.fprg.p4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class prueba {

	ArrayList<PruebaFisica> Registro = null;
	
	public prueba(){
		Registro = new ArrayList<PruebaFisica>();
	}
	public void guardarPrueba(PruebaFisica unaPrueba) throws Exception{
		
		if(unaPrueba==null){
			throw new NullPointerException("El parametro pasado no puede ser null");
		}
		
		
		if(unaPrueba instanceof Resistencia){
			//if(Registro.)
			if(Registro.isEmpty()){
				Registro.add(unaPrueba);
			}
			else{
				if(Registro.get(0).getFechaRealizacion().compareTo(unaPrueba.getFechaRealizacion())>=0){
					throw new Exception("Existe una prueba del mismo tipo y mas reciente");
				}
				Registro.set(0, unaPrueba); 
			}
		}
		
		if(unaPrueba instanceof SaltoVertical){
			if(Registro.isEmpty()){
				Registro.add(unaPrueba);
			}
			
			if(Registro.get(1)== null||Registro.get(1).getFechaRealizacion().compareTo(unaPrueba.getFechaRealizacion())>=0){
				throw new Exception("Existe una prueba del mismo tipo y mas reciente");
			}
			Registro.set(2, unaPrueba); 
		}
		if(unaPrueba instanceof Dominadas){
			if(Registro.get(3).getFechaRealizacion().compareTo(unaPrueba.getFechaRealizacion())>=0){
				throw new Exception("Existe una prueba del mismo tipo y mas reciente");
			}
			Registro.set(3, unaPrueba); 
		}
		if(unaPrueba instanceof TreparCuerda){
			if(Registro.get(4).getFechaRealizacion().compareTo(unaPrueba.getFechaRealizacion())>=0){
				throw new Exception("Existe una prueba del mismo tipo y mas reciente");
			}
			Registro.set(4, unaPrueba); 
		}
		
	}
	
	public List<PruebaFisica> obtenerPruebas (Date desde, Date hasta) throws Exception{
		if(desde.compareTo(hasta)>0){
			throw new Exception("La fecha introducida en segundo lugar debe ser posterior a la primera");
		}
		if(desde==null||hasta ==null){
			throw new NullPointerException("Nada");
		}
		ArrayList<PruebaFisica> Lista1 = new ArrayList<PruebaFisica>();
		if(Registro.isEmpty()){
			return Lista1;
		}
		
		if((Registro.get(4).getFechaRealizacion()).compareTo(desde)>0||Registro.get(4).getFechaRealizacion().compareTo(hasta)<0){
			Lista1.add(4, Registro.get(4));
		}
		if((Registro.get(1).getFechaRealizacion()).compareTo(desde)>0||Registro.get(1).getFechaRealizacion().compareTo(hasta)<0){
			Lista1.add(1, Registro.get(1));
		}
		if((Registro.get(3).getFechaRealizacion()).compareTo(desde)>0||Registro.get(3).getFechaRealizacion().compareTo(hasta)<0){
			Lista1.add(3, Registro.get(3));
		}
		if((Registro.get(2).getFechaRealizacion()).compareTo(desde)>0||Registro.get(2).getFechaRealizacion().compareTo(hasta)<0){
			Lista1.add(2, Registro.get(2));
			
		}
			
		return Lista1;
		
	}
	public int eliminarPruebas (Date hasta) throws Exception{
		int cuenta = 0;
		if(hasta==null){
			throw new NullPointerException("Nada");
		}
		
		if(Registro.get(1).getFechaRealizacion().compareTo(hasta)<0){
			Registro.set(1, null);
			cuenta++;
		}
		if(Registro.get(2).getFechaRealizacion().compareTo(hasta)<0){
			Registro.set(2, null);
			cuenta++;
		}
		if(Registro.get(3).getFechaRealizacion().compareTo(hasta)<0){
			Registro.set(3, null);
			cuenta++;
		}
		if(Registro.get(4).getFechaRealizacion().compareTo(hasta)<0){
			Registro.set(4, null);
			cuenta++;
		}
		return cuenta;
	}

	public boolean tieneAntiguas (Date hasta) throws Exception{
		boolean antiguas;
		if(hasta==null){
			throw new NullPointerException("Nada");
		}
		if(Registro.get(1).getFechaRealizacion().compareTo(hasta)<0||Registro.get(2).getFechaRealizacion().compareTo(hasta)<0||Registro.get(3).getFechaRealizacion().compareTo(hasta)<0||Registro.get(4).getFechaRealizacion().compareTo(hasta)<0){
			antiguas=true;
		}
		else{
			antiguas=false;
		}
		return antiguas;
	}	
	public boolean fallaResistencia(){
		boolean tiempoApto = false;
		Resistencia x = null;
			for (PruebaFisica i: Registro){
			  if (i.esMismoTipo(Registro.get(1))){ 
				 x = (Resistencia) i;
			  }
			 }

				if(x.getTiempo()<200){
					tiempoApto = true;
				}
		return tiempoApto;
	}

	public boolean esApto(){
		boolean esApto = false;
		boolean pruebasPasadas[]=new boolean[4];
		int cuenta=0;
		
		for (PruebaFisica i: Registro){
			  if (i.esMismoTipo(Registro.get(1))){ 
				 Resistencia x = (Resistencia) i;
				 if(x.getTiempo()<200){
					pruebasPasadas[0] = true;
				 }
			  }
			  
			  if(i.esMismoTipo(Registro.get(2))){
				  SaltoVertical y = (SaltoVertical) i;
				  if(y.getCentimetros()>55){
					  pruebasPasadas[1]=true;
				  }
			  }
			  
			  if(i.esMismoTipo(Registro.get(4))){
				  TreparCuerda w = (TreparCuerda)i;
				  if(w.getTiempo()<30){
					  pruebasPasadas[2]=true;
				  }
			  }
			  
			  if(i.esMismoTipo(Registro.get(3))){
				  Dominadas z = (Dominadas)i;
				  if(z.getNumero()>=25){
					  pruebasPasadas[3]=true;
				  }
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
	public static void main(String[] args) throws Exception{
		Date dia1 = new Date(10);
		Date dia2 = new Date(15);
		Date dia3 = new Date(11);
		Deportista d1 = new Deportista();
		Dominadas D1 = new Dominadas(dia3, 200);
		d1.guardarPrueba(D1);
		Dominadas D2 = new Dominadas(dia2, 20);
		d1.guardarPrueba(D2);
		//Resistencia R2 = new Resistencia(dia2, 20);
		//d1.guardarPrueba(R2);
		//SaltoVertical s1 = new SaltoVertical(dia1, 200);
		//d1.guardarPrueba(s1);
		//TreparCuerda T1 = new TreparCuerda(dia1, 1);
		//d1.guardarPrueba(T1);
		
		//System.out.println((d1.obtenerPruebas(dia1, dia2)));
		/*System.out.println(d1.tieneAntiguas(dia3));
		System.out.println(d1.fallaResistencia());
		System.out.println(d1.esApto());
		*/
	}
}


