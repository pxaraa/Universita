package modelli;

public class Studente extends Persona{
    private int annoIscrizione;
    private boolean ripetente;
    private int anniRipetuti;

    public Studente(String nome, String cognome, String luogoNascita, String dataNascita,int annoIscrizione){
        super(nome,cognome,luogoNascita, dataNascita);
        this.annoIscrizione = annoIscrizione;
    }

    public int getAnnoIscrizione() {
        return annoIscrizione;
    }
}
