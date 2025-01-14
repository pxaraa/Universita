package it.uniroma2.lmp.lmp0.model;

public class AnnoCorsoException extends Exception {
    public AnnoCorsoException(int annoCorso) {
        super("L'anno " + annoCorso + " è fuori dai limiti ammessi da questa università");
    }
}
