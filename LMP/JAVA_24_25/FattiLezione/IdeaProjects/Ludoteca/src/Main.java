import servizi.GestioneProdotti;
import  java.time.LocalTime;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        GestioneProdotti gP = new GestioneProdotti();
        gP.addGioco("outlast", "activison", "vision", LocalDate.of(2002, 10,9), LocalTime.of(2,30));

    }
}