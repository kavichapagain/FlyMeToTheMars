
public class U2 extends Rocket {
	

	public U2() {
		rocketCost = 120; //in millions
		rocketWeight = 18000; //in kg
		maxWeight = 29000;
		launchExplo = 0.04; //5% initial
		landCrash = 0.08;
		
		rocketStatus = "Loading";
		currentWeight = 18000;
		cargoWeight = 0;
	}
	
	public boolean launch() {
		calcCargo();
		if(cargoWeight * this.launchExplo / maxWeight > this.random)
			return true;
		else
			return false;
	}

	public boolean land() {
		if(cargoWeight * this.landCrash / maxWeight > this.random)
			return true;
		else
			return false;
	}
	
	private void calcCargo() {
		cargoWeight = this.currentWeight - rocketWeight;
	}
}
