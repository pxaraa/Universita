package it.uniroma2.info.lmp;

public abstract class StudenteBaseImpl extends PersonImpl implements Studente {

	protected String matricola;
	
	public StudenteBaseImpl(String nome, String cognome, String matricola) {
		super(nome,cognome);
		this.matricola = matricola;
	}
	
	public String getMatricola() {
		return matricola;
	}
	
	public String toString() {
		return super.toString() + " " + matricola;
	}

	
}
