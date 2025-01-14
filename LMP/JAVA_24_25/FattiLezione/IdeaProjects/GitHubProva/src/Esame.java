import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Esame {
    private Date data;
    private List<Prova> prove;
    private int numeroPromossi;

    public Esame(Date data) {
        this.data = data;
        this.prove = new ArrayList<>();
        this.numeroPromossi = 0;
    }

    public void aggiungiProva(Prova prova) {
        prove.add(prova);
        if (prova.getVoto() >= 18) {
            numeroPromossi++;
        }
    }

    public Date getData() {
        return data;
    }

    public int getNumeroPartecipanti() {
        return prove.size();
    }

    public int getNumeroPromossi() {
        return numeroPromossi;
    }

    public double getPercentualePromossi() {
        return (double) numeroPromossi / prove.size() * 100;
    }

    public Prova getProvaByMatricola(String matricola) {
        for (Prova prova : prove) {
            if (prova.getStudente().getMatricola().equals(matricola)) {
                return prova;
            }
        }
        return null;
    }
}