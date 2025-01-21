package modelli;
import java.util.ArrayList;

public class Biglietto {
    private String partenza;
    private String destinazione;
    private ArrayList<Tratta> SequenzaTratte;
    private TipoTreno tipoTreno;
    private double prezzo;

    public Biglietto(String partenza, String destinazione, TipoTreno tipoTreno) {
        this.partenza = partenza;
        this.destinazione = destinazione;
        this.tipoTreno = tipoTreno;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "partenza='" + partenza + '\'' +
                ", destinazione='" + destinazione + '\'' +
                ", SequenzaTratte=" + SequenzaTratte +
                ", tipoTreno=" + tipoTreno +
                ", prezzo=" + prezzo +
                '}';
    }
}
