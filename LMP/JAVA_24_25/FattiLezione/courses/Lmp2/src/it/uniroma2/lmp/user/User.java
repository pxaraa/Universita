package it.uniroma2.lmp.user;

import it.uniroma2.lmp.jennifer.Studente;
import it.uniroma2.lmp.jennifer.StudenteFactory;
import it.uniroma2.lmp.jennifer.TipoStudenti;

public class User {
	public static void main(String[] args){
		StudenteFactory factory = new StudenteFactory();
		Studente stud = factory.createStudente(TipoStudenti.INFORMATICA, 523);
		System.out.println(stud);
		}
}
