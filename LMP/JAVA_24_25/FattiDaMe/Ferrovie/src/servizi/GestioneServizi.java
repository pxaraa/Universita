package servizi;
import modelli.Biglietto;
import modelli.TipoTreno;
import modelli.Tratta;
import modelli.TipoTratta;
import java.util.HashMap;

public class GestioneServizi {
    private HashMap<String, Tratta> dataBase = new HashMap<>();

    public void addTratta(String partenza, String arrivo, Integer distanza,TipoTreno tipoTreno,TipoTratta tipoTratta) {
        dataBase.put((partenza + arrivo),new Tratta(partenza, arrivo, distanza, tipoTreno, tipoTratta));
    }
    //metodo che calcola il prezzo
    public double prezzoBiglietto(Tratta tratta) {
        double prezzo = 0;

        if (tratta.getTipoTratta() == TipoTratta.NAZ_BLU) {
            prezzo = tratta.getDistanza() * 0.10;
        } else if (tratta.getTipoTratta() == TipoTratta.NAZ_GRIGIO) {
            prezzo = tratta.getDistanza() * 0.15;
        } else if (tratta.getTipoTratta() == TipoTratta.REG_BLU) {
            prezzo = tratta.getDistanza() * 0.8;
        } else if (tratta.getTipoTratta() == TipoTratta.REG_GRIGIO) {
            prezzo = tratta.getDistanza() * 0.10;
        }
        if (tratta.getTipoTreno() == TipoTreno.ALTA_VELOCITA) {
            return prezzo * 1.5;
        } else {
            return prezzo;
        }
    }



    public void stampaBiglietto(String partenza, String arrivo, TipoTratta tipoTratta, TipoTreno tipoTreno){
        double prezzo = 0;
        creaBiglietto(partenza,arrivo,tipoTratta,tipoTreno,prezzo);

    }

    public void creaBiglietto(String partenza, String arrivo, TipoTratta tipoTratta, TipoTreno tipoTreno, double prezzo) {
        Biglietto biglietto = new Biglietto(partenza, arrivo, tipoTreno);

        if (dataBase.containsKey(partenza + arrivo)) { // Controlla se la tratta esiste direttamente
            Tratta tratta = dataBase.get(partenza + arrivo);
            double prezzo1=prezzoBiglietto(tratta);
            System.out.println("Prezzo del biglietto 1 è " + prezzo + prezzo1);
            prezzo = prezzo + prezzo1;
            biglietto.setPrezzo(prezzo);

            System.out.println("Prezzo del bigliettosenza: " + biglietto);
        }
        else{
            boolean trovato = false;
            for (Tratta tratta1 : dataBase.values()) {
                if (tratta1.getArrivo().equals(arrivo)) {
                    String partenzaIntermedia = tratta1.getPartenza();
                    trovato = true;
                    double prezzo1 = prezzoBiglietto(tratta1);
                    System.out.println("Prezzo del biglietto: " + partenza + partenzaIntermedia + prezzo1 + " euro");
                    biglietto.setPrezzo(prezzo1);
                    creaBiglietto(partenzaIntermedia, arrivo, tipoTratta, tipoTreno,prezzo1);


                }
                break; // Esci dal ciclo per evitare loop inutili
            }
            if (!trovato) {
                System.out.println("Nessuna tratta disponibile per raggiungere la destinazione.");
            }
        }
    }





















}
