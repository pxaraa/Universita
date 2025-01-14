public class Prova {
    private String argomenti;
    private int voto;
    private Studente studente;

    public Prova(String argomenti, int voto, Studente studente) {
        this.argomenti = argomenti;
        this.voto = voto;
        this.studente = studente;
    }

    public String getArgomenti() {
        return argomenti;
    }

    public int getVoto() {
        return voto;
    }

    public Studente getStudente() {
        return studente;
    }
}