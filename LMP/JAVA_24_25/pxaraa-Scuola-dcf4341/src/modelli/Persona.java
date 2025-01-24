package modelli;

public class Persona {
    private String nome;
    private String cognome;
    private String luogoNascita;
    private String dataNascita;

    public Persona(String nome, String cognome, String luogoNascita, String dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.luogoNascita = luogoNascita;
        this.dataNascita = dataNascita;
    }
    //getter
    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public String getLuogoNascita() {
        return luogoNascita;
    }
}