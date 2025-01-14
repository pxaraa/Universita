package it.uniroma2.art.lmp.categories;

/**
 * 
 * 
 * @author Armando Stellato &lt;stellato@info.uniroma2.it&gt;
 *
 */
public class BikeWithConstructors {
	
	/**
	 * 
	 */
	public static int num_gears = 4;
	
	int cadence;
	int speed;
	int gear;

	public BikeWithConstructors() {
		this(0);
	}

	public BikeWithConstructors(int startCadence) {
		this(startCadence, 0);
	}
	
	public BikeWithConstructors(int startCadence, int startSpeed) {
		this(startCadence, startSpeed, 1);
	}
	
	public BikeWithConstructors(int cadence, int speed, int gear) {
	    this.cadence = cadence;
	    this.speed = speed;
	    this.gear = gear;
	}
	
	
	/**
	 * @param newValue set a new cadence for the bike
	 */
	void changeCadence(int newValue) {
		cadence = newValue;
	}

	void changeGear(int newValue) {
		if (newValue > num_gears)
			System.out.println("you cannot select a gear greater than " + num_gears);
		else
			gear = newValue;
	}

	void speedUp(int increment) {
		speed = speed + increment;
	}

	void applyBrakes(int decrement) {
		speed = speed - decrement;
	}

	void printStates() {
		System.out.println("cadence:" + cadence + " speed:" + speed + " gear:" + gear);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BikeWithConstructors myBike = new BikeWithConstructors();
		myBike.changeGear(5);
//		System.out.println(Bike.applyBrakes(3));
		System.out.println("max number of gears for all bikes: " + BikeWithConstructors.num_gears);
	}

}
