package it.uniroma2.lmp.card_reader.ext;

import it.uniroma2.lmp.card_reader.AttivitàFactory;
import it.uniroma2.lmp.card_reader.LettoreProperty;
import it.uniroma2.lmp.card_reader.ext.Ristorante.Categoria;

public class RistoranteFactory implements AttivitàFactory {

	public static final String sede = "sede";
	public static final String in_attivita_dal = "in_attivita_dal";
	public static final String partita_IVA = "partita_IVA";

	public Ristorante createAttività(LettoreProperty props) {
		return new Ristorante(props.get(sede), Integer.parseInt(props.get(in_attivita_dal)), props.get(partita_IVA),
				Categoria.valueOf(props.get("categoria")));
	}

}
