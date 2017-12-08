
public class U1 extends Rocket {
	

	public U1() {
		rocketCost = 100; //in millions
		rocketWeight = 10000; //in kg
		maxWeight = 18000;
		launchExplo = 0.05; //5% initial
		landCrash = 0.01;
		
		rocketStatus = "Loading";
		currentWeight = 10000;
		cargoWeight = this.currentWeight;
	}
	
	public boolean launch() {
		calcCargo();
		//System.out.println(cargoWeight * this.launchExplo / maxWeight);
		if(cargoWeight * this.launchExplo / maxWeight < Math.random())
			return true;
		else
			return false;
	}

	public boolean land() {
		calcCargo();
		//System.out.println(cargoWeight * this.landCrash / maxWeight);
		if(cargoWeight * this.landCrash / maxWeight < Math.random())
			return true;
		return false;
	}
	
	private void calcCargo() {
		cargoWeight = this.currentWeight - rocketWeight;
	}
}
