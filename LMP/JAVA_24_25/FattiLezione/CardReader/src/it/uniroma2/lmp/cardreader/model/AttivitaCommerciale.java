package it.uniroma2.lmp.cardreader.model;

public class AttivitaCommerciale extends Attivita {

	String partitaIVA;
	
	public AttivitaCommerciale(int inizioAttivita, String sede, String partitaIVA) {
		super(inizioAttivita, sede);
		this.partitaIVA = partitaIVA;
	}

	public String getPartitaIVA() {
		return partitaIVA;
	}

}
