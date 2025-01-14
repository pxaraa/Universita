package it.uniroma2.lmp.lmp0.model;

public class StudenteImbruttito extends StudenteImpl implements Studente {

	public StudenteImbruttito(String nome, String cognome, String codiceFiscale, String matricola) {
		super(nome, cognome, codiceFiscale, matricola);
		
	}
	
	//questo e' un overload del metodo precedente
	public StudenteImbruttito(Persona persona, String matricola) {
		super(persona, matricola);
		
	}
	
	@Override
	public void saluta(Professore professore) {
		System.out.println("Salve prof. " + professore.getCognome() + " lei mi sta proprio antipatico!");
		
	}

}
