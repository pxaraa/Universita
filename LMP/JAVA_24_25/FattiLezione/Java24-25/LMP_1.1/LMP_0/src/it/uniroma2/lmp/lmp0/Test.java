package it.uniroma2.lmp.lmp0;

import it.uniroma2.lmp.lmp0.model.Persona;
import it.uniroma2.lmp.lmp0.model.PersonaImpl;

public class Test {

	public static void main(String[] args) {
		
		Persona franco = new PersonaImpl("Franco", "Bellucci", "xyz02");
		
		System.out.println("Abbiamo appena creato: " + franco);
		
		franco.saluta();

	}

}
