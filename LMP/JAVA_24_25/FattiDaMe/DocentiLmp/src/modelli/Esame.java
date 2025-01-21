package modelli;

import java.util.ArrayList;

public class Esame {
    private boolean esito;
    private int votoFinale;
    private int matricola;
    private String nome;
    private String cognome;

    public Esame(int matricola, String nome, String cognome) {
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
    }

    public int getMatricola() {
        return matricola;
    }
    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public int getVotoFinale(){
        return votoFinale;
    }

    public void setVotoFinale(int votoFinale) {
        this.votoFinale = votoFinale;
    }

    public void setEsito(boolean esito) {
        this.esito = esito;
    }
}
