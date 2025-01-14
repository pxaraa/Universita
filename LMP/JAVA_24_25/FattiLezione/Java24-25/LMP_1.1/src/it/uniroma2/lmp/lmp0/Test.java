package it.uniroma2.lmp.lmp0;

import it.uniroma2.lmp.lmp0.model.Persona;
import it.uniroma2.lmp.lmp0.model.PersonaImpl;
import it.uniroma2.lmp.lmp0.model.ProfessoreImpl;
import it.uniroma2.lmp.lmp0.model.StudenteImpl;
import it.uniroma2.lmp.lmp0.model.Studente;
import it.uniroma2.lmp.lmp0.model.StudenteImbruttito;
import it.uniroma2.lmp.lmp0.model.Professore;

public class Test {

	public static void main(String[] args) {
		
		Persona franco = new PersonaImpl("Franco", "Bellucci", "xyz02");
		
		System.out.println("Abbiamo appena creato: " + franco);
		
		franco.saluta();
		
		Studente studenteFranco = new StudenteImpl(franco, "h725");
		
		System.out.println("Abbiamo appena creato: " + studenteFranco);
		
		Professore professore = new ProfessoreImpl("Armando", "Stellato", "1234", "Knowledge Engineering");
		
		studenteFranco.saluta(professore);
		
		Studente bruto = new StudenteImbruttito("Bruto", "Cesare", "2342", "78cj");
		
		bruto.saluta(professore);
	}

}