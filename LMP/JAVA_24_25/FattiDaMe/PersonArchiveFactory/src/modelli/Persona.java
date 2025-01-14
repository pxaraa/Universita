package modelli;
import java.time.LocalDate;

public class Persona {
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String codiceFiscale;

    public Persona(String nome, String cognome, LocalDate dataNascita, String codiceFiscale) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.codiceFiscale = codiceFiscale;
    }
}
