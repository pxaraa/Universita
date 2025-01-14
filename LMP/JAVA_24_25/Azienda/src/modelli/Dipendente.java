package modelli;
import modelli.Dipartimento;

public class Dipendente {
    private String nome;
    private String cognome;
    private int dataNascita;
    private int dataAssunzione;
    private int numIscrizione;
    Dipartimento dipartimento;

    public Dipendente(String nome, String cognome, int dataNascita, int dataAssunzione,int numIscrizione, Dipartimento dipartimento) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.dataAssunzione = dataAssunzione;
        this.numIscrizione = numIscrizione;
        this.dipartimento = dipartimento;
    }

    public String createMatricola(int num){
        return "CTL_<"+ num + ">";
    }
}
