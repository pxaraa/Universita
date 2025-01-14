package it.uniroma2.lmp.jennifer;

public class StudenteFactory {
//	public Studente createStudente(TipoStudenti tipo, int codiceNumerico) throws StudenteCreationException {
//		Studente stud;
//		try {
//			switch (tipo) {
//			case INGEGNERIA:
//				stud = new StudenteIngegneria(codiceNumerico);
//				break;
//			case INFORMATICA:
//				stud = new StudenteInformatica(codiceNumerico);
//				break;
//			default:
//				throw new StudenteCreationException("Il tipo non è riconosciuto dalla factory");
//			}
//			return stud;
//		} catch (StudenteInitializationException e) {
//			throw new StudenteCreationException(e);
//		}
//	}
	
	public Studente createStudente(Class cls) throws StudenteCreationException{
		try {
			return (Studente)cls.newInstance();
		} catch (InstantiationException e) {
			throw new StudenteCreationException("Generic instantiation exception.");
		} catch (IllegalAccessException e) {
			throw new StudenteCreationException("Non posso accedere alla classe: " + cls);
		}
	}
	
	public Studente createStudente(String className) throws StudenteCreationException {
		try {
			Class c = Class.forName(className);
			return createStudente(c);
			
		} catch (ClassNotFoundException e) {
			throw new StudenteCreationException("La classe "+ className +" non è stata trovata");
		}
	}

}
