package modelli;

public class PersonaAzienda {
    private String nome;
    private String cognome;

    public PersonaAzienda(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }
}
