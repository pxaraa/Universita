package modelli;
import java.util.HashMap;

public class Tratta {
    private TipoTratta tipoTratta;
    private TipoTreno tipoTreno;
    private String partenza;
    private String arrivo;
    private Integer distanza;


    public Tratta(String partenza, String arrivo, Integer distanza,TipoTreno tipoTreno,TipoTratta tipoTratta) {
        this.partenza = partenza;
        this.arrivo = arrivo;
        this.distanza = distanza;
        this.tipoTreno = tipoTreno;
        this.tipoTratta = tipoTratta;

    }

    public String getPartenza() {
        return partenza;
    }

    public String getArrivo() {
        return arrivo;
    }

    public Integer getDistanza() {
        return distanza;
    }

    public TipoTratta getTipoTratta() {
        return tipoTratta;
    }

    public TipoTreno getTipoTreno() {
        return tipoTreno;
    }
}
