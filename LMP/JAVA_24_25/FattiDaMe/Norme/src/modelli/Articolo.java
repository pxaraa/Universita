package modelli;

public class Articolo {
    private int numArticolo;
    private String intro;
    private String commi = "";

    public Articolo(int numArticolo, String intro, String commi) {
        this.numArticolo = numArticolo;
        this.intro = intro;
        this.commi = commi;
    }

    //Secondo costruttore poichè i commi sono opzionali, basta togliere un argomento
    public Articolo(int numArticolo, String intro) {
        this.numArticolo = numArticolo;
        this.intro = intro;
    }

}

