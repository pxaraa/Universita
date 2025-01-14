package it.uniroma2.lmp.card_reader;

public class App {
	public static void main(String[] args) {
		CardReader cd = new CardReader();
		Attività att = cd.createAttività("Neg.txt");
		System.out.println(att);
	}
}
