package es.upm.dit.fprg.p2;

public class PruebaDeportista {public static void main(String[] args) {
	//Creo un deportista de 70 kilos, hombre, 34 años y 1.75 de altura
	Deportista deportista = new Deportista(70, false, 34, 175);
	//El Deportista desayuna una galleta de chocolate (150 Cal)
	deportista.comer(150);
	//Almuerza napolitana (325 Cal) y un chocolate calentito (200 Cal)
	int almuerzo [] = {325, 200};
	deportista.comer(almuerzo);
	//Come cocido (sopa (139 Cal), garbanzos (552 Cal), y helado (190 Cal))
	int comida [] = {139, 552, 190};
	deportista.comer(comida);
	//Merienda una naranja (36 Cal)
	deportista.comer(36);
	//Cena hamburguesa (350 Cal),refresco (200 Cal) y patatas fritas(400 Cal)
	int cena [] = {350, 200, 400};
	deportista.comer(cena);
	//Se va a la cama
	boolean adelgaza = deportista.dormir();
	//Me levanto y me peso
	System.out.println("Mi peso a la mañana siguiente es " + deportista.getPeso());
	System.out.println("¿He adelgazado? "+adelgaza);
}
}