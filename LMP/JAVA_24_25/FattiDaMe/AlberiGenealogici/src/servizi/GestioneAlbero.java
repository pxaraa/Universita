package servizi;
import modelli.Persona;
import java.util.ArrayList;
import java.util.List;

public class GestioneAlbero {

    public void calcolaDimensione(Persona p) {
        List<Persona> visitati = new ArrayList<>();
        visitaAntenati(p, visitati);
        System.out.println("La dimensione dell' albero di " + p.getNome() + " è: " + visitati.size());
    }

    public void visitaAntenati(Persona p, List<Persona> visitati) {
        if (p.getPadre() != null && !visitati.contains(p.getPadre())) {
            visitati.add(p.getPadre());
            visitaAntenati(p.getPadre(), visitati);
        }
        if (p.getMadre() != null && !visitati.contains(p.getMadre())) {
            visitati.add(p.getMadre());
            visitaAntenati(p.getMadre(), visitati);
        }
    }

    public void profonditàAlbero(Persona p){
       int c = calcolaProfondita(p);
       System.out.println("La profondita dell' albero di "+ p.getNome() + " è: " + c );
    }

    public int calcolaProfondita(Persona p) {
        if (p == null || (p.getPadre() == null && p.getMadre() == null)) {
            return 0;
        }
        int profonditaPadre = calcolaProfondita(p.getPadre());
        int profonditaMadre = calcolaProfondita(p.getMadre());
        return 1 + Math.max(profonditaPadre, profonditaMadre);
    }

    public void getTuttiAntenati(Persona p) {
        List<Persona> antenati = new ArrayList<>();
        raccogliAntenati(p, antenati);
        System.out.println("Tutti gli antenati di Marco: ");
        for (Persona a : antenati) {
            System.out.println(" - " + a);
        }
    }

    public void raccogliAntenati(Persona p, List<Persona> antenati) {
        if (p == null) return;
        if (p.getPadre() != null && !antenati.contains(p.getPadre())) {
            antenati.add(p.getPadre());
            raccogliAntenati(p.getPadre(), antenati);
        }
        if (p.getMadre() != null && !antenati.contains(p.getMadre())) {
            antenati.add(p.getMadre());
            raccogliAntenati(p.getMadre(), antenati);
        }
    }

}
