import modelli.Macchina;
import servizi.AutonomiaModelloAuto;
import modelli.StatoAuto;

public class Main {
    public static void main(String[] args) {
        AutonomiaModelloAuto modello1 = new AutonomiaModelloAuto("Fiat", "500", 1000, 70, 15);
        Macchina auto1 = new Macchina(modello1, StatoAuto.IN_MAGAZZINO, null);
        System.out.println("Autonomia del modello: " + modello1.calcolaAutonomia() + " km");

        AutonomiaModelloAuto modello2 = new AutonomiaModelloAuto("Fiat", "Panda", 1000, 40, 20);
        Macchina auto2 = new Macchina(modello2, StatoAuto.IN_ORDINE, null);
        System.out.println("Autonomia del modello: " + modello2.calcolaAutonomia() + " km");

        AutonomiaModelloAuto modello3 = modello2.clonaConCilindrataDiversa(1200);
        System.out.println(modello3);

        }

}