import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation extends Item {
	//private ArrayList<Item> cargoList = new ArrayList<Item>();
	private Scanner scanner;

/*
 * loads items according to the phase
 */
	public ArrayList<Item> loadItem(int phaseNum) throws FileNotFoundException{ 
		ArrayList<Item> cargoList = new ArrayList<Item>();
		String filename ="";
		
		switch(phaseNum) {
		case 1:
			System.out.println("Loading Items for Phase One.");
			filename = "phase-1.txt";
			break;
		case 2:
			System.out.println("Loading Items for Phase Two.");
			filename = "phase-2.txt";
			break;
		default:
			System.out.println("Items can be loaded for phase-1 or phase-2 only.");
			System.exit(1);
		}
		
		File phase  = new File(filename);
		scanner = new Scanner(phase);
		
		while(scanner.hasNextLine()) {
			Item item = new Item();
			String line = scanner.nextLine();
			String[] details = line.split("=");
			item.name = details[0];
			item.weight =  Integer.parseInt(details[1]);
			cargoList.add(item);
			//System.out.println(cargo);
		}
		return cargoList;
	}
	

	public ArrayList<Rocket> loadU1(ArrayList<Item> cargoList) {
		ArrayList<Rocket> oneSquad = new ArrayList<Rocket>();
		
		U1 f9 = new U1();
		
		for(Item cargo: cargoList) {
			
			int calcWeight = f9.currentWeight + cargo.weight;
			if (calcWeight < f9.maxWeight) {				
				f9.currentWeight = calcWeight;			//update the new weight
				System.out.println(cargo.name + ": " + cargo.weight + " Added to f9(U1)");
			}
			else { 
				//System.out.println("Adding remaining items to another rockets");
				oneSquad.add(f9);					//adding to the list once maxWeight is crossed.
				f9 = new U1();						// reset f9 to fill another rocket
				f9.currentWeight += cargo.weight;   //add current rocketWeight to f9
				System.out.println(cargo.name + ": " + cargo.weight + " Added to f9(U1)");
				
			}
			
		}
		oneSquad.add(f9); //adding last rocket to the list
		return oneSquad;
	}
	
	public ArrayList<Rocket> loadU2(ArrayList<Item> cargoList) {
		ArrayList<Rocket> twoSquad = new ArrayList<Rocket>();
		
		U2 f9b = new U2();
		//int totWe = 0;
		
		for(Item cargo: cargoList) {
			//System.out.println(f9b.currentWeight + "currentweight ---- cargo.wei"+ cargo.weight);
			int calcWeight = f9b.currentWeight + cargo.weight;
			if (calcWeight < f9b.maxWeight) {				
				f9b.currentWeight = calcWeight;			//update the new weight
				System.out.println(cargo.name + ": " + cargo.weight + "Added to f9b(U2)");
			}
			else 
				//System.out.println("Adding remaining items to another rockets");
				twoSquad.add(f9b);	//adding to the list once maxWeight is crossed.
				f9b = new U2();		// reset f9b to fill another rocket
				f9b.currentWeight += cargo.weight;   //add current rocketWeight to f9
				System.out.println(cargo.name + ": " + cargo.weight + " Added to f9b(U1)");
		}
		return twoSquad;
	}
	
	public int runSimulation(ArrayList<Rocket> rockets) {
		//int count = 0;
		int totalCost = 0;
		for(Rocket rocket: rockets) {
			//System.out.println("Loading rocket: " + rocket.toString() + "The total cost is: " + totalCost);
			if(rocket.launch()) {
				if (rocket.land()) {
					System.out.println("Launched and landed successfully.");
					totalCost += rocket.rocketCost;
				}
				else {
					totalCost += rocket.rocketCost * 2;
					System.out.println("Crashed in landing.");
				}	
			} 
			else{
				System.out.println("Exlpoded on launch. have to send another one.");
				totalCost += rocket.rocketCost * 2; // add another cost of the rocket
			}
		}
		System.out.println("The total budget required is " + totalCost);
		return totalCost;
	}

}
