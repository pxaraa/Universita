package it.uniroma2.info.lmp;

public interface Studente extends Person {
	String getMatricola();

	void saluta(Professore prof);
	
	void saluta(Professore prof, String appellativo);
}
