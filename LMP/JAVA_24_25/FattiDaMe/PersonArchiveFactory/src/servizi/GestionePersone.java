package servizi;
import java.time.LocalDate;
import java.util.HashMap;

import modelli.Persona;
import modelli.Disoccupato;
import modelli.Impiegato;
import modelli.LiberoProfessionista;


public class GestionePersone {

    static private HashMap<String, Persona> archivioPersone = new HashMap<>();

    public void creaImpiegato(String nome, String cognome, LocalDate dataNascita, String codiceFiscale, String matricola, int livello, String mansione){
        archivioPersone.put(codiceFiscale, new Impiegato(nome, cognome, dataNascita, codiceFiscale, matricola, livello, mansione));
    }
    public void creaLiberoProfessionista(String nome, String cognome, LocalDate dataNascita, String codiceFiscale, String professione, String partitaIva){
        archivioPersone.put(codiceFiscale, new LiberoProfessionista(nome, cognome, dataNascita, codiceFiscale, professione, partitaIva));
    }
    public void creaDisoccupato(String nome, String cognome, LocalDate dataNascita, String codiceFiscale, String iscrizioneRegDisoccupazione){
        archivioPersone.put(codiceFiscale, new Disoccupato(nome, cognome, dataNascita, codiceFiscale, iscrizioneRegDisoccupazione));
    }

    public String cercaPersona(String codiceFiscale){
        Persona p = archivioPersone.get(codiceFiscale);
        System.out.println(p.toString());
        return p.toString();
    }




}
