package servizi;
import modelli.Oop;
import modelli.Prolog;
import java.util.HashMap;
import modelli.Esame;

public class GestioneEsami {
    private double bonus;
    private HashMap<Integer,Oop> archivioEsamiJava = new HashMap<>();
    private HashMap<Integer,Prolog> archivioEsamiProlog = new HashMap<>();
    private HashMap<Integer,Esame> archivioEsami = new HashMap<>();

    public void addEsameJava(int matricola, String nome, String cognome, String argomentiRichiestiOop, double votoOrale,double votoScritto){
        archivioEsamiJava.put(matricola,new Oop (matricola,nome,cognome,argomentiRichiestiOop,votoOrale,votoScritto));
    }

    public void addEsameProlog(int matricola, String nome, String cognome, String argomentiRichiestiProlog, double votoOrale,double votoScritto){
        archivioEsamiProlog.put(matricola,new Prolog (matricola,nome,cognome,argomentiRichiestiProlog,votoOrale,votoScritto));
    }

    public void getEsito(int matricola) {
        Oop esameJava = archivioEsamiJava.get(matricola);
        if (esameJava.getVotoScritto() >= 18 && esameJava.getVotoOrale() >= 18) {
            double media1 = ((esameJava.getVotoScritto() + esameJava.getVotoOrale()) / 2);
            System.out.println("La media in java è:" + " " + media1);
            Prolog esameProlog = archivioEsamiProlog.get(matricola);
            if (esameJava.getVotoScritto() >= 18 && esameJava.getVotoOrale() >= 18) {
                double media2 = ((esameProlog.getVotoScritto() + esameProlog.getVotoOrale()) / 2);
                System.out.println("La media in Prolog è:" + " " + media2 );
                int mediaFinale = (int)(media1 + media2) / 2;
                System.out.println("Il voto finale è:" + " " + mediaFinale);

                //se entramo in questo if allora l' alunno ha passato l'esame e deve essere creato l'oggetto esame
                String nome = esameJava.getNome();
                String cognome = esameJava.getCognome();
                creaEsame(matricola, nome, cognome, mediaFinale);
            }else{
                System.out.println("L' alunno " + matricola + " non ha superato l'esame" );
            }
        }else{
            System.out.println("L' alunno " + matricola + " non ha superato l'esame" );
        }
    }

    public void creaEsame(int matricola, String nome, String cognome, int mediaFinale){

        if (mediaFinale >= 18){
            Esame esame = new Esame(matricola, nome, cognome);
            archivioEsami.put(matricola, esame);
            esame.setVotoFinale(mediaFinale);
            esame.setEsito(true);
        }
        else{
            System.out.println("La media di" + " " + mediaFinale  + " " + "non è sufficente");
        }
    }

    public void getEsameMatricola(int matricola){
        archivioEsami.get(matricola);
    }

    public void getArgomentiRichiesti(int matricola){
        Oop esame1 = archivioEsamiJava.get(matricola);
        Prolog esame2 = archivioEsamiProlog.get(matricola);
        System.out.println("Gli argomenti chiesti alla matricola " + matricola + " sono:"+
                " " + esame1.getArgomentiRichiesti() + esame2.getArgomentiRichiesti());
    }

    public void getNumeroPromossi() {
        int promossi = 0;
        int sostenitori = 0;
        for (Esame esame : archivioEsami.values()) {
            promossi++;
        }
        for (Esame esame : archivioEsamiProlog.values()) {
            sostenitori++;
        }
        if (sostenitori > 0) {
            double percentuale = ((double) promossi / sostenitori) * 100;
            System.out.println("Percentuale promossi: " + percentuale + "%");
        } else {
            System.out.println("Nessun sostenitore trovato.");
        }
    }

    public void setBonus(int matricola,double bonus) {
        Esame esame = archivioEsami.get(matricola);
        double voto = esame.getVotoFinale();
        if (voto <= 28 && archivioEsami.containsKey(matricola)) {
            this.bonus = bonus;
            int votoFinale = (int) (voto + bonus);
            esame.setVotoFinale(votoFinale);
            System.out.println("Il voto è stato aggiornato a: " + votoFinale + "\n");
        } else if(voto > 28){
            System.out.println("Lo studente ha già preso il massimo");
        }else{
            System.out.println("Lo studente non ha passato l' esame");
        }
    }
}
