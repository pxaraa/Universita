package it.uniroma2.lmp.card_reader;

import java.io.File;

import it.uniroma2.lmp.card_reader.Ristorante.Categoria;
import it.uniroma2.lmp.card_reader.Associazione.Scopo;

public class CardReader {

	public static final String negozio = "negozio";
	public static final String ristorante = "ristorante";
	public static final String associazione = "associazione";
	public static final String sede = "sede";
	public static final String in_attivita_dal = "in_attivita_dal";
	public static final String partita_IVA = "partita_IVA";
	public static final String merce_venduta = "merce_venduta";

	public Attività createAttività(String file) {
		return createAttività(new File(file));
	}

	public Attività createAttività(File file) {
		LettoreProperty lProp;
		lProp = new LettoreFile(file);
		String fl = lProp.get("filetype");
		if (fl.equals(negozio)) {
			return new Negozio(lProp.get(sede), Integer.parseInt(lProp.get(in_attivita_dal)), lProp.get(partita_IVA),
					lProp.get(merce_venduta));
		}
		if (fl.equals(ristorante)){
			return new Ristorante(lProp.get(sede), Integer.parseInt(lProp.get(in_attivita_dal)), lProp.get(partita_IVA), Categoria.valueOf(lProp.get("categoria")));
		}
		if (fl.equals(associazione)){
			return new Associazione(lProp.get(sede), Integer.parseInt(lProp.get(in_attivita_dal)), Scopo.valueOf(lProp.get("scopo")));
		}
			return null;
	}
}
