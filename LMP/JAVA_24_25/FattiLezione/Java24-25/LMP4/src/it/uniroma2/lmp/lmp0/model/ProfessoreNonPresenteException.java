package it.uniroma2.lmp.lmp0.model;

public class ProfessoreNonPresenteException extends RuntimeException {
    public ProfessoreNonPresenteException() {
        super("Il professore è assente (null) e non può essere salutato");
    }
}
