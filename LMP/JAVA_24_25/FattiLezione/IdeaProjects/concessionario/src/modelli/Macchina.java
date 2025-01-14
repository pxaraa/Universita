package modelli;


import servizi.AutonomiaModelloAuto;

import java.util.ArrayList;

public class Macchina {
    private AutonomiaModelloAuto modello;
    private StatoAuto stato;
    private String informazioniAggiuntive;

    public Macchina(AutonomiaModelloAuto modello, StatoAuto stato, String informazioniAggiuntive) {
        this.modello = modello;
        this.stato = stato;
        this.informazioniAggiuntive = informazioniAggiuntive;
    }

    public AutonomiaModelloAuto getModello() {

        return modello;
    }

    public void setModello(AutonomiaModelloAuto modello) {
        this.modello = modello;
    }

    public StatoAuto getStato() {
        return stato;
    }

    public void setStato(StatoAuto stato) {
        this.stato = stato;
    }

    public String getInformazioniAggiuntive() {
        return informazioniAggiuntive;
    }

    public void setInformazioniAggiuntive(String informazioniAggiuntive) {
        this.informazioniAggiuntive = informazioniAggiuntive;
    }

}