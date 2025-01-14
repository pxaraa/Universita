package it.uniroma2.lmp.lmp0.model;

public abstract class StudenteTV extends StudenteImpl implements Studente {

    protected StudenteTV(String nome, String cognome, String codiceFiscale, String CDS) {
        super(nome, cognome, codiceFiscale, CDS + numStudenti++);

    }

    protected StudenteTV(Persona persona, String CDS) {
        this(persona.getNome(), persona.getCognome(), persona.getCodiceFiscale(), CDS);
        //invoco il costruttore "principale"
    }


}
