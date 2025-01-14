package it.uniroma2.lmp.card_reader;

import java.io.File;
import java.util.HashMap;

public class CardReader {

	public static final String negozio = "negozio";
	public static final String sede = "sede";
	public static final String in_attivita_dal = "in_attivita_dal";
	public static final String partita_IVA = "partita_IVA";
	public static final String merce_venduta = "merce_venduta";

	private HashMap<String, AttivitàFactory> facts = new HashMap<String, AttivitàFactory>();

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
		} else
			return facts.get(fl).createAttività(lProp);
	}

	public void registerFactory(String type, AttivitàFactory fact) {
		facts.put(type, fact);
	}

}
