
import servizi.GestioneLeggi;
import modelli.Legge;
import modelli.TipoLegge;
import modelli.Articolo;

import java.time.LocalDate;

public class Main {
    public static void main(String args[]) {
        GestioneLeggi gl = new GestioneLeggi();
        gl.addLegge(TipoLegge.CIRCOLARE, LocalDate.now(), "Salve", "Arrivederci");
        gl.addLegge(TipoLegge.CIRCOLARE, LocalDate.of(2024, 4, 12), "Salve", "Arrivederci");
        gl.addLegge(TipoLegge.CIRCOLARE, LocalDate.now(), "Salve", "Arrivederci");


        System.out.println(gl.getLegge("CIRCOLARE2024-04-12"));
    }

}