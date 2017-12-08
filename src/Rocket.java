
public class Rocket implements Spaceship {
	//String givenName;
	int rocketCost;
	int rocketWeight;
	int maxWeight;
	double launchExplo;
	double landCrash;
	
	String rocketStatus;
	int currentWeight;
	int cargoWeight;
	double random;
	
	
	public Rocket() {
		random = Math.random();
	}
	
	public boolean launch() {
		return true;
	}

	public boolean land() {		
		return true;
	}

	public boolean canCarry(Item cargo) {
		if(this.currentWeight + cargo.weight > this.maxWeight) {
			return false;
		}
		return true;
	}

	public void carry(Item cargo) {
		this.currentWeight += cargo.weight;
	} 
}
