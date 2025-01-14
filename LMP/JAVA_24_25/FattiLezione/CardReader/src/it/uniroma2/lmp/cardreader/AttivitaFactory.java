package it.uniroma2.lmp.cardreader;

import java.io.File;
import java.util.Map;

import it.uniroma2.lmp.cardreader.io.CardReader;
import it.uniroma2.lmp.cardreader.io.CardReadingException;
import it.uniroma2.lmp.cardreader.model.Attivita;

public class AttivitaFactory {

	public Attivita creaAttivita(File card) throws CardReadingException {
		//Nota: facciamo gestire l'eccezione a CardReadingException
		
		Map<String, String> map = CardReader.readCard(card);
	}
 
}
