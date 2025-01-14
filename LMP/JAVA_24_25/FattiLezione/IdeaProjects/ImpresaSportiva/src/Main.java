import Servizi.GestioneSportivo;
import modelli.Sportivo;
import modelli.Tipologia;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        GestioneSportivo GS = new GestioneSportivo();
        GS.setRetiMinime(3);
        GS.addSportivo("PAOLO", "mazzara", LocalDate.now(), Tipologia.PREPARATORE_ATLETICO, 3);
        GS.addSportivo("giacomo", "mazzara", LocalDate.now(), Tipologia.GIOCATORE,4);
        GS.addSportivo("marco", "mazzara", LocalDate.now(), Tipologia.MEDICO,2);

        Sportivo paolo= GS.getSportivo("TEAM_0");
        Sportivo giacomo= GS.getSportivo("TEAM_1");
        Sportivo marco= GS.getSportivo("TEAM_2");

        paolo.addGoal("gennaio",3);
        giacomo.addGoal("marzo",5);
        marco.addGoal("agosto",4);

        ArrayList<Sportivo> bonus= GS.addBonus();
        System.out.println(bonus);


        }

}