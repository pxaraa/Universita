package modelli;

import java.util.ArrayList;
import java.util.List;

public class Scuola {
    private String nome;
    private List<Classe> classi;

    public Scuola(String nome) {
        this.nome = nome;
        this.classi = new ArrayList<>();
    }

    public void aggiungiClasse(Classe classe) {
        classi.add(classe);
    }

    public List<Classe> getClassi() {
        return classi;
    }
}

