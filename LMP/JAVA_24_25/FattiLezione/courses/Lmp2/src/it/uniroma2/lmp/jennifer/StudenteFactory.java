package it.uniroma2.lmp.jennifer;

public class StudenteFactory {
	public Studente createStudente(TipoStudenti tipo, int codiceNumerico) {
		Studente stud;
		switch (tipo) {
		case INGEGNERIA:
			stud = new StudenteIngegneria(codiceNumerico);
			break;
		case INFORMATICA:
			stud = new StudenteInformatica(codiceNumerico);
			break;
		default:
			stud = null;
		}
		return stud;
	}

}
