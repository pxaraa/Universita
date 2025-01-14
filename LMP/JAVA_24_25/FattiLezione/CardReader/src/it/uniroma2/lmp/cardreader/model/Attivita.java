package it.uniroma2.lmp.cardreader.model;

public class Attivita {

	int inizioAttivita;
	String sede;
	
	public Attivita(int inizioAttivita, String sede) {
		this.inizioAttivita = inizioAttivita;
		this.sede = sede;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public int getInizioAttivita() {
		return inizioAttivita;
	}

}
