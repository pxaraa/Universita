package it.uniroma2.lmp.jennifer;

public class StudenteInformatica extends StudenteImpl {
	
	static private int codice = 1;
	
	private StudenteInformatica (int codiceNumerico) throws StudenteInitializationException{
		super("INF", codiceNumerico);
	}

	StudenteInformatica()throws StudenteInitializationException{
		this(codice++);
	}
}
