import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Studente studente1 = new Studente("12345", "Mario", "Rossi");
        Prova prova1 = new Prova("Java", 28, studente1);
        Prova prova2 = new Prova("Prolog", 25, studente1);
        Prova prova3 = new Prova("Python", 30, studente1);

        Esame esame = new Esame(new Date());
        esame.aggiungiProva(prova1);
        esame.aggiungiProva(prova2);
        esame.aggiungiProva(prova3);

        GestioneEsami gestioneEsami = new GestioneEsami(0.5, 0.5, 2);
        double votoFinale = gestioneEsami.calcolaVotoFinale(28, 25, 30, 27, 26, 0);

        System.out.println("Voto finale: " + votoFinale);
        System.out.println("Numero partecipanti: " + esame.getNumeroPartecipanti());
        System.out.println("Numero promossi: " + esame.getNumeroPromossi());
        System.out.println("Percentuale promossi: " + esame.getPercentualePromossi() + "%");
    }
}