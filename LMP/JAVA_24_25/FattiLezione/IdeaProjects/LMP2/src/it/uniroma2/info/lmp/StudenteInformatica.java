package it.uniroma2.info.lmp;

public class StudenteInformatica extends StudenteImpl implements Studente {

	private static final String code = "INF";
	public StudenteInformatica(String nome, String cognome) {
		super(nome, cognome);
		
	}

	@Override
	public String getCode() {
		return code;
	}

}
