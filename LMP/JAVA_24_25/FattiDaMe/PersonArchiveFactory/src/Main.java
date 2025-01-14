import java.time.LocalDate;
import servizi.GestionePersone;


public class Main {
    public static void main(String[] args) {
        GestionePersone gP = new GestionePersone();
        gP.creaImpiegato("Paolo", "Mazzara", LocalDate.of(2002,1,26), "MZZPLA", "0313844", 2, "Segretario");
        gP.creaLiberoProfessionista("Luca", "Paguro", LocalDate.of(2002,1,26), "LXVVS", "Avvocato","00123444");

        gP.cercaPersona("MZZPLA");


    }
}