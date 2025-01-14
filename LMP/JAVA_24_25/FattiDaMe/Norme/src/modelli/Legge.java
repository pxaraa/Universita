package modelli;
import java.time.LocalDate;
import java.util.ArrayList;

public class Legge {
    private TipoLegge tipoLegge;
    private LocalDate dataCreazione;
    private String id;
    private String intestazione;
    private String conclusioni;
    private ArrayList<Articolo> articoli;
    private ArrayList<Object> allegati;

    public Legge(TipoLegge tipoLegge, LocalDate dataCreazione, String intestazione, String conclusioni) {
        this.tipoLegge = tipoLegge;
        this.dataCreazione = dataCreazione;
        this.intestazione = intestazione;
        this.conclusioni = conclusioni;
        this.id = setIdentificatore();
        this.allegati = new ArrayList<>();
        this.articoli = new ArrayList<>();
    }

    //quando istanzio un oggetto legge  l'id verrà istanziato come "tipoleggeGG_MM_AA"
    public String setIdentificatore() {
        String id = this.tipoLegge.name() + this.dataCreazione.toString();
        return id;
    }

    //Questo metodo mi permettere di aggiungere articoli senza richiamare il costruttore della classe Articolo
    public void addArticolo(int numeroArticolo, String introduzione, String commi) {
        this.articoli.add(new Articolo(numeroArticolo, introduzione, commi));
    }

    //Stesso medoto però ti da la possibilità di escludere i commi
    public void addArticolo(int numeroArticolo, String introduzione) {
            this.articoli.add(new Articolo(numeroArticolo, introduzione));
    }

    public void addAllegato(Object allegato){
        this.allegati.add(allegato);
    }
    public String getId(){
        return id;

    }

    @Override
    public String toString() {
        return "Legge{" +
                "tipoLegge=" + tipoLegge +
                ", dataCreazione=" + dataCreazione +
                ", id='" + id + '\'' +
                ", intestazione='" + intestazione + '\'' +
                ", conclusioni='" + conclusioni + '\'' +
                ", articoli=" + articoli +
                ", allegati=" + allegati +
                '}';
    }
}
