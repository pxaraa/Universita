package it.uniroma2.lmp.cardreader.model;

public class Associazione extends Attivita {

	Scopo scopo;
	
	/**
	 * @param inizioAttivita
	 * @param sede
	 */
	public Associazione(int inizioAttivita, String sede, Scopo scopo) {
		super(inizioAttivita, sede);
		this.scopo = scopo;
	}

	public static enum Scopo{
		ricreativo, culturale, volontariato
	}

}
