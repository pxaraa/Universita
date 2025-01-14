package it.uniroma2.lmp.lmp0.model;

public class PersonaImpl implements Persona {
	String nome;
	String cognome;
	String codiceFiscale;
	/** <-- commento per doc (es. javadoc)
	 * @param nome nome <em>persona</em>
	 * @param cognome <-- i param sono dei tag
	 * @param codiceFiscale
	 */
	public PersonaImpl(String nome, String cognome, String codiceFiscale) {
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
	}
	
	//In questo caso e' piu' utile un getter invece del setter
	@Override
	public String getNome() {
		return nome;
	}
	@Override
	public String getCognome() {
		return cognome;
	}
	@Override
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	
	@Override
	public void saluta() {
		System.out.println("Salve a tutti!");
	}
	
	public String toString() {
		return nome + " " + cognome + ": " + codiceFiscale;
	}
}
