import servizi.GestioneServizi;
import modelli.TipoTreno;
import modelli.TipoTratta;
import modelli.Tratta;

public class Main {
    public static void main(String[] args) {
        GestioneServizi gs = new GestioneServizi();
        gs.addTratta("Roma", "Firenze", 200, TipoTreno.ENTRAMBI, TipoTratta.REG_BLU);
        gs.addTratta("Firenze", "Bologna", 60, TipoTreno.ENTRAMBI, TipoTratta.REG_BLU);
        gs.addTratta("Roma", "Ancona", 200, TipoTreno.NORMALE, TipoTratta.REG_BLU);
        gs.addTratta("Roma", "Pescara", 150, TipoTreno.NORMALE, TipoTratta.REG_BLU);
        gs.addTratta("Roma", "Napoli", 170, TipoTreno.ENTRAMBI, TipoTratta.NAZ_BLU);
        gs.addTratta("Napoli", "Foggia", 80, TipoTreno.ENTRAMBI, TipoTratta.REG_BLU);
        gs.addTratta("Foggia", "Pescara", 100, TipoTreno.NORMALE, TipoTratta.REG_BLU);


        gs.stampaBiglietto("Roma","Bologna",TipoTratta.REG_BLU,TipoTreno.NORMALE);


    }
}