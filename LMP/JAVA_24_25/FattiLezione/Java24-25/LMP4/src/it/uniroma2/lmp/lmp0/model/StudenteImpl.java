package it.uniroma2.lmp.lmp0.model;

public class StudenteImpl extends PersonaImpl implements Studente {
    static int numStudenti;
    String matricola;

    protected StudenteImpl(String nome, String cognome, String codiceFiscale, String matricola) {
        super(nome, cognome, codiceFiscale);
        numStudenti++;
        this.matricola = matricola;

    }

    protected StudenteImpl(Persona persona, String matricola) {
        this(persona.getNome(), persona.getCognome(), persona.getCodiceFiscale(), matricola);
        //invoco il costruttore "principale"
    }

    @Override
    public String getMatricola() {
        return this.matricola;
    }


    @Override
    public void saluta(Professore professore) {
        if( professore == null) throw new ProfessoreNonPresenteException();
        System.out.println("Salve prof. " + professore.getCognome());

    }

    @Override
    public String toString() {
        return super.toString() + " " + matricola;
    }
}
