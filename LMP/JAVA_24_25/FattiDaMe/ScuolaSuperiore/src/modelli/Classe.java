package modelli;

import java.util.ArrayList;
import java.util.List;

public class Classe {
    private String nome;
    private int annoTipicoClasse;
    private int corso;
    private String sezione;
    private List<Studente> studenti;

    public Classe(String nome, int annoTipicoClasse, int corso, String sezione) {
        this.nome = nome;
        this.annoTipicoClasse = annoTipicoClasse;
        this.corso = corso;
        this.sezione = sezione;
        this.studenti = new ArrayList<>();
    }

    //una volta istanziata la classe, con questo metodo aggiungiamo studendi all' array "studenti"



    //getter
    public List<Studente> getStudenti() {
        return studenti;
    }

    public String getNome() {
        return nome;
    }

    public int getAnnoTipicoClasse() {
        return annoTipicoClasse;
    }

    public String getSezione() {
        return sezione;
    }

    public int getCorso() {return corso; }
}
