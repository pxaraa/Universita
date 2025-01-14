package it.uniroma2.lmp.card_reader.ext;

import it.uniroma2.lmp.card_reader.Società;

public class Ristorante extends Società {
	
	public enum Categoria {pizzeria,italiano,etnico};
	public Categoria categoria;
	
	public Ristorante(String sede, int in_attivita_dal, String partita_IVA,Categoria categoria) {
		super(sede, in_attivita_dal, partita_IVA);
		this.categoria = categoria;
	}
	
}
