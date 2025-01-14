package it.uniroma2.lmp.cardreader.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@SuppressWarnings("serial")
public class CardReadingException extends Exception {


	public CardReadingException(File f) {
		super("Card: " + f + " non trovata");
		
	}
	
	public CardReadingException(FileNotFoundException e, File f) {
		super("Card: " + f + " non trovata", e);
		
	}
	
	public CardReadingException(IOException e, File f) {
		super("Problema nella lettura della card: " + f + ", " + e.getMessage(), e);
		
	}
	
	public CardReadingException(String message) {
		super(message);
	}
		
}
