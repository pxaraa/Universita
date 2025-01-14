package it.uniroma2.lmp.card_reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class LettoreFile implements LettoreProperty{
	
	HashMap<String,String> mappa;
	
	public LettoreFile(String filename){
		this(new File(filename));
	}
	
	public LettoreFile(File file) {
		mappa = new HashMap<String, String>();
		BufferedReader bReader = null;
		try {
			bReader = new BufferedReader(new FileReader(file));
			String line;
			while ((line=bReader.readLine()) != null){
				String[] splitline = line.split(":");
				mappa.put(splitline[0], splitline[1]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bReader!=null)
				try {
					bReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	public String get(String attributo) {
		return mappa.get(attributo);
	}
	

}
