package it.uniroma2.info.lmp;

public class AngryStudent extends StudenteImpl implements Studente {

	public AngryStudent(String nome, String cognome, String matricola) {
		super(nome, cognome, matricola);
		
	}

	public void saluta(Professore prof) {
		saluta(prof, "cretino");
	}
}
