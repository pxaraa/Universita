package modelli;

import java.time.LocalDate;

public class Disoccupato extends Persona{
    String IscrizioneRegDisoccupazione;

    public Disoccupato(String nome, String cognome, LocalDate dataNascita, String codiceFiscale, String iscrizioneRegDisoccupazione) {
        super(nome, cognome, dataNascita, codiceFiscale);
        IscrizioneRegDisoccupazione = iscrizioneRegDisoccupazione;
    }
}
