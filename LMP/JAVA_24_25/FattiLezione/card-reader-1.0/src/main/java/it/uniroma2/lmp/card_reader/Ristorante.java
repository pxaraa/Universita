package it.uniroma2.lmp.card_reader;

import it.uniroma2.lmp.card_reader.Società;

public class Ristorante extends Società {

	public enum Categoria {
		pizzeria, italiano, etnico
	};

	public Categoria categoria;

	public Ristorante(String sede, int in_attivita_dal, String partita_IVA, Categoria categoria) {
		super(sede, in_attivita_dal, partita_IVA);
		this.categoria = categoria;
	}

	public String toString() {
		return ("Ristorante:\nsede: " + sede + "\nin_attività_dal " + in_attivita_dal + "\npartita_IVA " + partita_IVA
				+ "\ncategoria " + categoria);
	}

}
