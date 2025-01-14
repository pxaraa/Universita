package it.uniroma2.lmp.jennifer;

public class TestStudentiArray {
	public static void main(String[] args) {
		Studente[] studenti = new Studente[8];
		for (int i = 0; i < studenti.length; i++) {
			int app = i % 4;
			if (app == 0) 
				studenti[i] = new StudenteInformatica();
			else 
				studenti[i] = new StudenteIngegneria();
			studenti[i].setMatricola(i);
		}
		
		for (Studente stud : studenti)
			System.out.println(stud);
		
	}
}
