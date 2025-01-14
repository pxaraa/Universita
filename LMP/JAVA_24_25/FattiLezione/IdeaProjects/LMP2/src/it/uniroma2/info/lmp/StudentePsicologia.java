package it.uniroma2.info.lmp;

public class StudentePsicologia extends StudenteImpl implements Studente {

	private static final String code = "PSY";
	public StudentePsicologia(String nome, String cognome) {
		super(nome, cognome);
		
	}

	@Override
	public String getCode() {
		return code;
	}


}
