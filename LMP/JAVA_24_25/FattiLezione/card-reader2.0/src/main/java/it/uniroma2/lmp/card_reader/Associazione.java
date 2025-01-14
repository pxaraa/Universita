package it.uniroma2.lmp.card_reader;

public class Associazione extends Attività {
	
	public enum Scopo {ricreativo,culturale,volontariato};
	public Scopo scopo;
	
	public Associazione(String sede, int in_attivita_dal, Scopo scopo) {
		super(sede, in_attivita_dal);
		this.scopo= scopo;
	}

	
}
