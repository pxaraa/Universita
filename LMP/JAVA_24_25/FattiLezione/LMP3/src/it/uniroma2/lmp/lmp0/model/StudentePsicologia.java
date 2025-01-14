package it.uniroma2.lmp.lmp0.model;

public class StudentePsicologia extends StudenteTV implements Studente{

    public StudentePsicologia(String nome, String cognome, String codiceFiscale) {
        super(nome, cognome, codiceFiscale, "psi");
    }
    public StudentePsicologia(Persona persona) {
            this(persona.getNome(), persona.getCognome(), persona.getCodiceFiscale());

        }

}
