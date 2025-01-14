package it.uniroma2.lmp.card_reader;

public abstract class Società extends Attività {
	String partita_IVA;

	public Società(String sede, int in_attivita_dal, String partita_IVA) {
		super(sede, in_attivita_dal);
		this.partita_IVA = partita_IVA;
	}

	public String getPartita_IVA() {
		return partita_IVA;
	}

	public void setPartita_IVA(String partita_IVA) {
		this.partita_IVA = partita_IVA;
	}

}
