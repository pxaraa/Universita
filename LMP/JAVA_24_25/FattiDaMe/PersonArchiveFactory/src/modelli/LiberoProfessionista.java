package modelli;

import java.time.LocalDate;

public class LiberoProfessionista extends Persona{
    private String professione;
    private String partitaIva;

    public LiberoProfessionista(String nome, String cognome, LocalDate dataNascita, String codiceFiscale, String professione, String partitaIva) {
        super(nome, cognome, dataNascita, codiceFiscale);
        this.professione = professione;
        this.partitaIva = partitaIva;
    }
}
