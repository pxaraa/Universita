package it.uniroma2.lmp.cardreader.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CardReader { //riutilizzabile

	public static Map<String, String> readCard(File card) throws CardReadingException{
		Map<String, String> map = new HashMap<>(); //diamond "<>"
		BufferedReader bf; //si possono incapsulare tutti insieme (con il FileReader)
		
		try {
			FileReader fr = new FileReader(card); //implementa un Reader
			bf = new BufferedReader(fr);
			
		} catch (FileNotFoundException e) {
			throw new CardReadingException(e, card);
		}
		
		try {
			String line;
			while((line = bf.readLine()) != null) {
				String[] splitLine = line.split(":"); //rischioso, perche' assumiamo array con soli 2 elementi
				if(splitLine.length != 2) {
					throw new CardReadingException("Eccezione nel formato della card sulla riga: " + line);
				}
				map.put(splitLine[0], splitLine[1]);
			}
			
		} catch (IOException e) {
			throw new CardReadingException(e, card);
			
		}

		finally {try {
			bf.close();
		} catch (IOException e) {
			throw new CardReadingException(e, card);
		}}
		
		return map;
	}

}
