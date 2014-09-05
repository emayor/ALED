package es.upm.dit.fprg.p2;

	public class Tratamiento {
		
		private double[] pruebas;
		
		public Tratamiento (int sesion){
			pruebas = new double [sesion];
		}
		
		public double buscarDosisMaxima(){
			double maxima = 0.0;
			for(int i=0;i<pruebas.length;i++){
				if(maxima<pruebas[i]){
					maxima = pruebas[i];
				}
			}
			return maxima;
		}

		public double buscarDosisMinima(){
			double minima = 0.0;
			for(int i=0;i<pruebas.length;i++){
				if(pruebas[i] > 0.0){
					if(minima>pruebas[i]){
					minima = pruebas[i];
					}	
				}
				
			}
			return minima;
		}
		
		public double calcularDosisMedia(){
			int contador = 0;
			double numeroDosis = 0.0;
			for(int i=0;i<pruebas.length;i++){
				if(pruebas[i] > 0.0){
				numeroDosis += pruebas[i];
				contador++;
				}
			}
			return numeroDosis/contador;
		}
		
		public double getDosis(int sesion){
			
			if(sesion < 0 || sesion >= pruebas.length){
			return 0;
			}else{
			return pruebas[sesion];
			}
		}
		
		public double getDosisTotal(){ 
			
			double total = 0;
			for(int i=0;i<pruebas.length;i++){
				total += pruebas[i];
			}
			return total;
		}
		
		public int getSesionesPendientes(){  
			int pendientes = 0;
			for(int i = 0;i<pruebas.length;i++){
				if(pruebas[i] == 0.0){
					pendientes++; 
				}
			}
			return pendientes;
		}
		
		public double[] getTratamiento(){
			return pruebas;
		}
		
		public void guardarDosis(double cantidad){ 
	
			boolean interruptor = false;
			if(cantidad > 0.0){
				for(int i=0;i<pruebas.length;i++){
					if(pruebas[i] == 0.0 && interruptor == false){
						pruebas[i] = cantidad;
						interruptor = true;
					}
				}
			}
		}
		
		public void setDosis(double dosis, int sesion){
			
			if(dosis > 0.0 && sesion < pruebas.length && sesion >= 0)
			pruebas[sesion] = dosis;
		}
		
		public void setTratamiento(double[] t){
			pruebas = t;
		}
	}