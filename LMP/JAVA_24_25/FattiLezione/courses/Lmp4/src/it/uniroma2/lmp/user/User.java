package it.uniroma2.lmp.user;

import it.uniroma2.lmp.jennifer.Studente;
import it.uniroma2.lmp.jennifer.StudenteCreationException;
import it.uniroma2.lmp.jennifer.StudenteFactory;
import it.uniroma2.lmp.jennifer.StudenteInformatica;
import it.uniroma2.lmp.jennifer.TipoStudenti;

public class User {
	public static void main(String[] args){
		StudenteFactory factory = new StudenteFactory();
		Studente stud;
		try {
//			stud = factory.createStudente(TipoStudenti.LETTERE, -1);
			stud = factory.createStudente(StudenteInformatica.class);
			System.out.println(stud);
			stud = factory.createStudente("it.uniroma2.lmp.jennifer.StudenteInformatica");
			System.out.println(stud);
		} catch (StudenteCreationException e) {
			System.err.println("La factory ha avuto un problema a creare uno studente: " + e.getMessage());
		}
		}
}
