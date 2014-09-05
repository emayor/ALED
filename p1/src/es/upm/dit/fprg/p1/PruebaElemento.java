package es.upm.dit.fprg.p1;

public class PruebaElemento {

	public static void main(String arg[]){
		//Creamos una muestra de RbCl de 100 gramos
		CloruroRubidio unaMuestra;
		unaMuestra = new CloruroRubidio(100);
		//Comprobamos que la muestra tiene 100 gramos
		System.out.println("La muestra pesa "+unaMuestra.getMasa()+" gramos");
		//Quitamos un trozo de 50 gramos y deberían quedar otros 50
		int quedan = unaMuestra.retirarMasa(50);
		System.out.println("Quedan "+quedan+" gramos");
		System.out.println("La muestra pesa "+unaMuestra.getMasa()+" gramos");
		//Recuperamos el número de moles, que debería ser 0.4134965266291763 moles
		double moles = unaMuestra.calcularMoles();
		System.out.println("En "+unaMuestra.getMasa()+" gramos hay "+moles+" moles.");
		//Recuperamos el número de particulas, que debería ser 9.223372036854776E18 partículas
		double particulas = unaMuestra.calcularParticulas();
		System.out.println("En "+unaMuestra.getMasa()+" gramos hay "+particulas+" partículas.");
	
	}
	
}
