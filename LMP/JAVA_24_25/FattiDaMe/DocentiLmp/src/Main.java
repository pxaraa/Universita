import modelli.Oop;
import servizi.GestioneEsami;


public class Main {
    public static void main(String[] args) {

        GestioneEsami gs = new GestioneEsami();
        gs.addEsameJava(3138,"Paolo","Mazzara","Classi,Interfacce,Variabili",18.00,21.50);
        gs.addEsameProlog(3138,"Paolo","Mazzara","Cut,BackTracking,Logica",25.00,20.00);
        gs.getEsito(3138);
        gs.getArgomentiRichiesti(3138);
        gs.setBonus(3138,2);

        gs.addEsameJava(3031,"Alessandro","Fettina","Classi,Interfacce,Variabili",16.00,21.50);
        gs.addEsameProlog(3031,"Alessandro","Fettina","Cut,BackTracking,Logica",25.00,20.00);
        gs.getEsito(3031);
        gs.getArgomentiRichiesti(3031);

        gs.getNumeroPromossi();


    }

}