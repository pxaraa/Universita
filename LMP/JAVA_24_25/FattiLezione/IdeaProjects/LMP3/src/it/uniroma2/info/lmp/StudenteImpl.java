package it.uniroma2.info.lmp;

public class StudenteImpl extends StudenteBaseImpl implements Studente {

	private static int counter = 0;

	public StudenteImpl(String nome, String cognome, CdS corsoStudi, int annoDiCorso) {
		super(nome,cognome,"");
		//System.out.println("avvio studente" + getCode());
		this.matricola = corsoStudi.getCodice() + ++counter;
		setAnnoDiCorso(annoDiCorso);
	}

	protected static int getCount(){
		return counter;
	}
	
	public void saluta(Professore prof) {
		System.out.println("Salve Professor " + prof);
		
	}

	public void saluta(Professore prof, String appellativo) {
		System.out.println("Salve Professor " + prof + ", Lei è proprio un " + appellativo);
		
	}
}
