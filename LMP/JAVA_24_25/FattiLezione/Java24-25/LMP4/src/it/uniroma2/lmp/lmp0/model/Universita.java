package it.uniroma2.lmp.lmp0.model;

public class Universita {

    public Studente iscriviStudente(String nome, String cognome, String codiceFiscale, CorsoDiStudi CDS, int annoCorso) throws AnnoCorsoException{
        if (annoCorso > 5){
            throw new AnnoCorsoException(annoCorso);
        }
        return new StudenteCDS(nome, cognome, codiceFiscale, CDS, annoCorso);
    }
}
