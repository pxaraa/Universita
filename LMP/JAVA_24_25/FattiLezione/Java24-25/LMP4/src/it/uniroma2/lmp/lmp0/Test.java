package it.uniroma2.lmp.lmp0;

import it.uniroma2.lmp.lmp0.model.*;

public class Test {

    public static void main(String[] args) {

        Persona franco = new PersonaImpl("Franco", "Bellucci", "xyz02");

        System.out.println("Abbiamo appena creato: " + franco);

        franco.saluta();


        Professore professore = new ProfessoreImpl("Armando", "Stellato", "1234", "Knowledge Engineering");

        Universita torVergata = new Universita();


        Studente stud1 = null;
        Studente stud2 = null;
        Studente stud3 = null;
        try {
            stud1 = torVergata.iscriviStudente("Mario" , "Rossi", "mrrs", CorsoDiStudi.INFORMATICA, 3);
            stud2 = torVergata.iscriviStudente("Luigi" , "Bianchi", "mr8e", CorsoDiStudi.INFORMATICA, 1);
            stud3 = torVergata.iscriviStudente("Marco" , "Neri", "rts", CorsoDiStudi.PSICOLOGIA, 7);
        } catch (Exception e) {
            System.err.println("C'è stato un problema di iscrizione: " + e.getMessage());
        }
        System.out.println(stud1 + "\n" + stud2 + "\n" + stud3);
        Professore x = null;
        stud1.saluta(x);
    }

}