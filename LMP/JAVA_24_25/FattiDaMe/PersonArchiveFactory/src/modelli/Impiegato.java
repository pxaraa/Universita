package modelli;

import java.time.LocalDate;

public class Impiegato extends Persona{
    private String matricola;
    private int livello;
    private String mansione;

    public Impiegato(String nome, String cognome, LocalDate dataNascita, String codiceFiscale, String matricola, int livello, String mansione) {
        super(nome, cognome, dataNascita, codiceFiscale);
        this.matricola = matricola;
        this.livello = livello;
        this.mansione = mansione;
    }

    @Override
    public String toString() {
        return "Impiegato{" +
                "matricola='" + matricola + '\'' +
                ", livello=" + livello +
                ", mansione='" + mansione + '\'' +
                '}';
    }
}
