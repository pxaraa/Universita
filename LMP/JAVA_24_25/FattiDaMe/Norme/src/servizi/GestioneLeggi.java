package servizi;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.ArrayList;

import modelli.TipoLegge;
import modelli.Legge;

public class GestioneLeggi {
    //Creiamo un dizionario con chiave l' id e valore la legge
    HashMap<String, Legge> archivioLeggi = new HashMap<>();
    //Metodo per aggiungere nel dict le leggi
    public void addLegge(TipoLegge tipoLegge,LocalDate dataCreazione, String intestazione, String conclusioni){
    Legge legge = new Legge(tipoLegge, dataCreazione, intestazione, conclusioni);
    archivioLeggi.put(legge.getId(),legge);
    }

    //Adesso come da traccia abbiamo bisogno di recuperare le leggi dal dict con chiave id

    public String getLegge(String id){
        Legge legge = archivioLeggi.get(id);
        if (legge == null){
            System.out.println("La legge non è prente nell' archivio");

        }
        return legge.toString();
    }

}