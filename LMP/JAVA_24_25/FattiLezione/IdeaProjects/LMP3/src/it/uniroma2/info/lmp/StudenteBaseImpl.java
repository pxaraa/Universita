package it.uniroma2.info.lmp;

public abstract class StudenteBaseImpl extends PersonImpl implements Studente {

	protected String matricola;
	protected int annoDiCorso;
	
	public StudenteBaseImpl(String nome, String cognome, String matricola) {
		super(nome,cognome);
		this.matricola = matricola;
	}
	
	public String getMatricola() {
		return matricola;
	}
	
	public String toString() {
		return super.toString() + " " + matricola;
	}

	@Override
	public int getAnnoDiCorso() {
		return annoDiCorso;
	}

	public void setAnnoDiCorso(int annoDiCorso) {
		if(annoDiCorso>3){
			this.annoDiCorso = 3;
			System.err.println("Tentativo di impostare l'anno di corso oltre il terzo al numero: "+annoDiCorso);
		}
		else{
			this.annoDiCorso = annoDiCorso;
		}
	}
}
