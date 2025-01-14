package it.uniroma2.art.lmp;

public class LMPGreeter implements Greeter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Greeter myGreeter = new LMPGreeter();
		myGreeter.hi();
		
		LMPGreeter newGreeter = (LMPGreeter)myGreeter;
		
//		myGreeter.killStellato();
		newGreeter.killStellato("bazooka");
		
		LMPGreeter helloLMPGreeter = new HelloLMPGreeter();
		
		helloLMPGreeter.killStellato("bazooka");
	}

	public void hi() {
		System.out.println(" Hi! LMP Students! ");		
	}
	
	public void killStellato() {
		// System.out.println("you killed Stellato");
		killStellato("bazooka");
	}

	public void killStellato(String weapon) {
		System.out.println("you killed Stellato with a " + weapon);
	}
}
