package it.uniroma2.lmp.lmp0.model;

public interface Persona {
	//Normalm. si pensa prima all'interf. e poi alla classe

	//In questo caso e' piu' utile un getter invece del setter
	String getNome();

	String getCognome();

	String getCodiceFiscale();

	void saluta();

}