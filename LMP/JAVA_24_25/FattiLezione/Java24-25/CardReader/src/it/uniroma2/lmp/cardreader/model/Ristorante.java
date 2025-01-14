package it.uniroma2.lmp.cardreader.model;

public class Ristorante extends AttivitaCommerciale {

	Categoria categoria;
	
	/**
	 * @param inizioAttivita
	 * @param sede
	 * @param partitaIVA
	 */
	public Ristorante(int inizioAttivita, String sede, String partitaIVA, Categoria categoria) {
		super(inizioAttivita, sede, partitaIVA);
		this.categoria = categoria;
	}

	public static enum Categoria{
		pizzeria, italiano, etnico
	}

}
