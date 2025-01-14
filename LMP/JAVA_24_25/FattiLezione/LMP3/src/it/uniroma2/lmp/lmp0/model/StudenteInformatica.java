package it.uniroma2.lmp.lmp0.model;

public class StudenteInformatica extends StudenteTV implements Studente{

    public StudenteInformatica(String nome, String cognome, String codiceFiscale) {
        super(nome, cognome, codiceFiscale, "inf");
    }

    public StudenteInformatica(Persona persona) {
        this(persona.getNome(), persona.getCognome(), persona.getCodiceFiscale());

    }


}
