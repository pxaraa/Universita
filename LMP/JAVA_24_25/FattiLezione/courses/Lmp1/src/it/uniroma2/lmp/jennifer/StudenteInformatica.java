package it.uniroma2.lmp.jennifer;

public class StudenteInformatica extends StudenteImpl {

	@Override
	public void setMatricola(int codiceNumerico) {
	
		matricola = "INF_" + codiceNumerico;
		
	}

}
