package it.uniroma2.info.lmp;

public class LMP {

	public static void main(String[] args) {
		
		//Studente p1 = new StudenteImpl("Ivan","Collevecchio"," 0348569");
		
		//System.out.println(p1);
		//p1.saluta();
		//p1.getMatricola();
		
		Professore stellato = new ProfessoreImpl("Armando","Stellato","LMP"); 
		
		Studente inf = new StudenteInformatica("Mario", "Rossi");
		Studente psy = new StudentePsicologia("Luigi", "Bianchi");
		
		System.out.println(inf);
		System.out.println(psy);	
	}

}
