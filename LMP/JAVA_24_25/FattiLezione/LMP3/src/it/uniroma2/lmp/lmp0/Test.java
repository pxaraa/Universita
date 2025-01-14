package it.uniroma2.lmp.lmp0;

import it.uniroma2.lmp.lmp0.model.*;

public class Test {

    public static void main(String[] args) {

        Persona franco = new PersonaImpl("Franco", "Bellucci", "xyz02");

        System.out.println("Abbiamo appena creato: " + franco);

        franco.saluta();


        Professore professore = new ProfessoreImpl("Armando", "Stellato", "1234", "Knowledge Engineering");


        Studente stud1 = new StudenteInformatica("Mario" , "Rossi", "mrrs");
        Studente stud2 = new StudenteInformatica("Luigi" , "Bianchi", "mr8e");
        Studente stud3 = new StudentePsicologia("Marco" , "Neri", "rts");
        System.out.println(stud1 + "\n" + stud2 + "\n" + stud3);
    }

}