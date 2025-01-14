package it.uniroma2.lmp.jennifer;

public class StudenteIngegneria extends StudenteImpl {

	StudenteIngegneria (int codiceNumerico) throws StudenteInitializationException{
		super("ING", codiceNumerico);
	}
}
