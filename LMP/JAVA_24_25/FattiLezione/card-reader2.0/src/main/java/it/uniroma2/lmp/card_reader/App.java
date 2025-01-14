package it.uniroma2.lmp.card_reader;

import it.uniroma2.lmp.card_reader.ext.RistoranteFactory;

public class App {
	public static void main(String[] args) {
		CardReader cd = new CardReader();
		cd.registerFactory("ristorante", new RistoranteFactory());
		Attività att = cd.createAttività("Ris.txt");
		System.out.println(att);
		
		/* NOTA: manca toString quindi otteniamo come output a schermo proprio l'oggetto */
	}
}
