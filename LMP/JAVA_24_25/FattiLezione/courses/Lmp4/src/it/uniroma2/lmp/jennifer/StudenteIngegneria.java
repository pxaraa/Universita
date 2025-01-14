package it.uniroma2.lmp.jennifer;

public class StudenteIngegneria extends StudenteImpl {

	static private int codice = 1;
	
	private StudenteIngegneria (int codiceNumerico) throws StudenteInitializationException{
		super("ING", codiceNumerico);
	}
	
	StudenteIngegneria()throws StudenteInitializationException{
		this(codice++);
	}
}
