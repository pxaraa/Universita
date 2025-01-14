package it.uniroma2.lmp.lmp0.model;

public class StudenteCDS extends StudenteImpl implements Studente {

    CorsoDiStudi CDS;
    int annoCorso;

    StudenteCDS(String nome, String cognome, String codiceFiscale, CorsoDiStudi CDS, int annoCorso) {
        super(nome, cognome, codiceFiscale, CDS.toString() + numStudenti);
        this.CDS = CDS;
        this.annoCorso = annoCorso;

    }

    StudenteCDS(Persona persona, CorsoDiStudi CDS, int annoCorso) {

        this(persona.getNome(), persona.getCognome(), persona.getCodiceFiscale(), CDS, annoCorso);
        //invoco il costruttore "principale"
    }


}
