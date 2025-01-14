package modelli;
import java.time.LocalDate;


public class Dipendenti {

    public enum Dipartimento{
        MARKETING, RISORSE_UMANE, SVILUPPO

    }
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    public LocalDate dataAssunzione;
    public Dipartimento dipartimento;
    public String matricola;

    public Dipendenti(String nome, String cognome, LocalDate dataNascita, Dipartimento dipartimento) {
        this.nome= nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.dataAssunzione = LocalDate.now();
        this.dipartimento = dipartimento;
        int numeroProgressivo = 0;
        this.matricola = "CTL_" + String.valueOf(numeroProgressivo);
        numeroProgressivo++;

    }
}


