import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MarsSim {

	public static void main(String[] args) throws FileNotFoundException {
		Simulation sims = new Simulation();
		
		System.out.println("Loading items for phase 1 and phase 2");
		ArrayList<Item> cargoListP1 = sims.loadItem(1); //phase-1 getting cargo
		ArrayList<Item> cargoListP2 = sims.loadItem(2); //phase-2 getting cargo
		
		System.out.println("\nLoading U1-phase 1");
		ArrayList<Rocket> oneUp1 = sims.loadU1(cargoListP1);						//phase-1 loading cargo in U1
		
		System.out.println("\nLoading U1-phase 2");
		ArrayList<Rocket> oneUp2 = sims.loadU1(cargoListP2);	
		
		System.out.println("\nRunning U1-phase 1");
		sims.runSimulation(oneUp1);						////loading phase 1
		
		System.out.println("\nRunning U1-phase 2");
		sims.runSimulation(oneUp2);						//phase-2 loading cargo in U1
		
		
		//for U2
		System.out.println("\nLoading U2-phase 1");
		ArrayList<Rocket> twoUp1 = sims.loadU2(cargoListP1);						//phase-1 loading cargo in U1
		
		System.out.println("\nLoading U2-phase 2");
		ArrayList<Rocket> twoUp2 = sims.loadU2(cargoListP2);	
		
		System.out.println("\nRunning U2-phase 1");
		sims.runSimulation(twoUp1);						////loading phase 1
		
		System.out.println("\nRunning U2-phase 2");
		sims.runSimulation(twoUp2);						//phase-2 loading cargo in U1
		
		
	}

}
