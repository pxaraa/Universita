package it.uniroma2.lmp.jennifer;

public class StudenteIngegneria extends StudenteImpl {

	@Override
	public void setMatricola(int codiceNumerico) {
	
		matricola = "ING_" + codiceNumerico;
		
	}

}
