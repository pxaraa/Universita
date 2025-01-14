package it.uniroma2.lmp.jennifer;

public class StudenteFactory {
	public Studente createStudente(TipoStudenti tipo, int codiceNumerico) throws StudenteCreationException {
		Studente stud;
		try {
			switch (tipo) {
			case INGEGNERIA:
				stud = new StudenteIngegneria(codiceNumerico);
				break;
			case INFORMATICA:
				stud = new StudenteInformatica(codiceNumerico);
				break;
			default:
				throw new StudenteCreationException("Il tipo non è riconosciuto dalla factory");
			}
			return stud;
		} catch (StudenteInitializationException e) {
			throw new StudenteCreationException(e);
		}
	}

}
