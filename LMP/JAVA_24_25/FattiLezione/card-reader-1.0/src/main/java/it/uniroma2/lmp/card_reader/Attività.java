package it.uniroma2.lmp.card_reader;

public abstract class Attività {
	String sede;
	int in_attivita_dal;

	public Attività(String sede, int in_attivita_dal) {
		this.sede = sede;
		this.in_attivita_dal = in_attivita_dal;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public int getIn_attivita_dal() {
		return in_attivita_dal;
	}

	public void setIn_attivita_dal(int in_attivita_dal) {
		this.in_attivita_dal = in_attivita_dal;
	}

}
