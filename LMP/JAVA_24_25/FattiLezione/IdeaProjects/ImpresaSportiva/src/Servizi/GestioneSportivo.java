package Servizi;

import modelli.Sportivo;
import modelli.Tipologia;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;


public class GestioneSportivo {

    private int retiMinime;
    ArrayList<Sportivo> dataBase= new ArrayList<>();

    public void setRetiMinime(int retiMinime) {
        if(retiMinime < 0) {
            throw new IllegalArgumentException("valore non valido");
        }
        this.retiMinime = retiMinime;
    }

    public void addSportivo(String nome, String cognome, LocalDate dataAssunzione, Tipologia tipologia, int stipendio) {
        dataBase.add(new Sportivo(nome, cognome, dataAssunzione, tipologia, stipendio));

    }

    public ArrayList<Sportivo> addBonus(){
        int c;
        ArrayList<Sportivo> premiatiBonus =new ArrayList<>();
        for(Sportivo ogniSportivo : dataBase ){
            if(ogniSportivo.getStipendio()>=3) {
                c=0;
                for(int goalpermese: ogniSportivo.getGoalPerMesi().values()){
                    if(goalpermese>=retiMinime) {
                        c++;
                    }
                }
                if(c>0) {
                    premiatiBonus.add(ogniSportivo);
                }

            }

        }
        return premiatiBonus;
    }
    public Sportivo getSportivo(String matricola ) {
        Sportivo sp = null;
        for(Sportivo sportivo : dataBase){
            if(sportivo.getMatricola().equals(matricola)) {
                sp= sportivo;
                break;
            }
        }
        if(sp==null) {
            throw new NoSuchElementException("NON TROVATO");
        }
        return sp;

    }
}
