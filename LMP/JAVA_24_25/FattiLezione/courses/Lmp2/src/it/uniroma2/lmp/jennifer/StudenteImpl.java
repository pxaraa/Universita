package it.uniroma2.lmp.jennifer;

public abstract class StudenteImpl implements Studente {
	
	String matricola;
	
	protected StudenteImpl (String code, int codiceNumerico){
		this.matricola = code + "_" + codiceNumerico; 
	}

	
	public String getMatricola() {
		
		return matricola;
	}
	
	public String toString(){
		return matricola;
	}
}
