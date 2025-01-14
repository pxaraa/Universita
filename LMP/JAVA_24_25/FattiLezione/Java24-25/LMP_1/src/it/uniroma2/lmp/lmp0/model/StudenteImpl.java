package it.uniroma2.lmp.lmp0.model;

public class StudenteImpl extends PersonaImpl implements Studente {

	String matricola;
	
	public StudenteImpl(String nome, String cognome, String codiceFiscale, String matricola) {
		super(nome, cognome, codiceFiscale);
		this.matricola = matricola;
	}
	
	public StudenteImpl(Persona persona, String matricola) {
		this(persona.getNome(), persona.getCognome(), persona.getCodiceFiscale(), matricola);
		//invoco il costruttore "principale"
	}

	@Override
	public String getMatricola() {
		return this.matricola;
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + matricola;
	}
}
