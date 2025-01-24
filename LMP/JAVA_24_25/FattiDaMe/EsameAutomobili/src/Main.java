import servizi.GestioneConcessionario;
import modelli.Disponibilità;
import modelli.PersonaAzienda;

public class Main {
    public static void main(String[] args) {
        GestioneConcessionario gs= new GestioneConcessionario();
        gs.aggiungiMacchinaInMagazzino("500","fiat","sport",40,1000,15,Disponibilità.IN_MAGAZZINO);
        gs.aggiungiAllestimentoInMagazzino("500","fiat","sport","GT",1200);

        gs.recuperaDisponibiltà("500","fiat","sport","GT",1000);

        PersonaAzienda persona =  new PersonaAzienda("Giacomo","Giacomino");
        gs.vendiMacchina("500","fiat","sport","GT",1000, persona);
    }
}