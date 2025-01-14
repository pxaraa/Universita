package modelli;

import java.time.LocalDate;
import java.util.HashMap;

public class Sportivo {
    private String nome;
    private String cognome;
    private HashMap <String,Integer> goalPerMesi;
    private LocalDate dataAssunzione;

    private String matricola;
    private int stipendio;
    private static int count = 0;
    private Tipologia tipologia;

    public Sportivo(String nome, String cognome, LocalDate dataAssunzione,Tipologia tipologia, int stipendio) {
        this.nome = nome;
        this.cognome = cognome;
        this.goalPerMesi = new HashMap<>();
        this.dataAssunzione = dataAssunzione;
        this.matricola = "TEAM_"+count++;
        setStipendio(stipendio);
        this.tipologia=tipologia;
    }

    public HashMap<String, Integer> getGoalPerMesi() {
        return new HashMap<String, Integer>(goalPerMesi);
    }

    public void setStipendio(int stipendio) {
        if(stipendio <1 || stipendio > 5){
            throw new IllegalArgumentException("Stipendio invalido");
        }
        this.stipendio = stipendio;

    }

    @Override
    public String toString() {
        return "Sportivo{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", goalPerMesi=" + goalPerMesi +
                ", dataAssunzione=" + dataAssunzione +
                ", matricola='" + matricola + '\'' +
                ", stipendio=" + stipendio +
                ", tipologia=" + tipologia +
                '}';
    }

    public int getStipendio() {
        return stipendio;
    }

    public void addGoal(String mese, int goal){
        if(goal<0){
            throw new IllegalArgumentException("Goal invalido");
        }
        goalPerMesi.put(mese,goal);
    }

    public String getMatricola() {
        return matricola;
    }
}


