package it.uniroma2.lmp.jennifer;

public abstract class StudenteImpl implements Studente {
	
	String matricola;
	
	protected StudenteImpl (String code, int codiceNumerico) throws StudenteInitializationException  {
		if(codiceNumerico  < 0){
			throw new StudenteInitializationException("Il codice inserito è negativo");
		}
		this.matricola = code + "_" + codiceNumerico; 
		
	}

	
	public String getMatricola() {
		
		return matricola;
	}
	
	public String toString(){
		return matricola;
	}
}
