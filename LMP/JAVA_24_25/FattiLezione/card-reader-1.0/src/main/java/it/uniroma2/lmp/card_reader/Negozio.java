package it.uniroma2.lmp.card_reader;

public class Negozio extends Società {
	String merce_venduta;

	public Negozio(String sede, int in_attivita_dal, String partita_IVA, String merce_venduta) {
		super(sede, in_attivita_dal, partita_IVA);
		this.merce_venduta = merce_venduta;
	}

	public String getMerce_venduta() {
		return merce_venduta;
	}

	public void setMerce_venduta(String merce_venduta) {
		this.merce_venduta = merce_venduta;
	}

	public String toString() {
		return ("Negozio:\nsede: " + sede + "\nin_attività_dal " + in_attivita_dal + "\npartita_IVA " + partita_IVA
				+ "\nmerce_venduta " + merce_venduta);
	}
}
