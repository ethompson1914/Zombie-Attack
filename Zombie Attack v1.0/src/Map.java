import java.util.ArrayList;


public class Map {

	private ArrayList<Building> listOfBuildings;
	
	/**
	 * Creates a map object
	 */
	public Map() {
		setUpMap();
	}
	
	private void setUpMap() {
		setUpBuildings();
		addFloorsToBuildings();
		addRoomsToFloors();
		addItemsToRooms();
	}
	
	/**
	 * Create all the rooms and link their exits together. Create the items and
	 * put them into rooms.
	 */
	private void setUpBuildings() {
		
		// Declare buildings
		Building vanZoren, vandeWerf, scienceCenter, library, vorhees, graves, cook,
		haworth, durfee, vanVleck, westernSem, wyckoff, scott, licty, kollen, lubbers,
		phelps, dewitt, marthaMiller, dow;

		// Create the buildings
		vanZoren = new Building("VanZoren", "The building that houses" +
				"the computer science, engineering, and math departments", 2);
		vandeWerf = new Building("VandeWerf", "The extension of VanZoren", 2);
		scienceCenter = new Building("Science Center", "Houses all of the" +
				" science equipment and science labs", 3);
		library = new Building("Library", "A library", 5);
		vorhees = new Building("Vorhees", "A dark dusky dorm", 2);
		graves = new Building("Graves", "A lecture hall", 3);
		cook = new Building("Cook Hall", "A dorm with a cafeteria and attached to" +
				" a hotel type building", 2);
		haworth = new Building("Haworth Inn", "A hotel attached to Cook Hall", 3);
		durfee = new Building("Durfee", "An old smokey dorm", 2);
		vanVleck = new Building("Van Vleck", "An extremely old and small dorm", 3);
		westernSem = new Building("Van Wylen", "A library", 5);
		wyckoff = new Building("Wyckoff", "A dorm", 3);
		scott = new Building("Scott", "A dorm", 3);
		licty = new Building("Licty", "A very small dorm", 3);
		kollen = new Building("Kollen", "A really long dorm", 3);
		lubbers = new Building("Lubbers", "A lecture hall", 2);
		phelps = new Building("Phelps", "A dorm with a built-in dining area", 2);
		dewitt = new Building("Dewitt", "The old student center, lots of places in here", 3);
		marthaMiller = new Building("Martha Miller", "Seems to be a fairly new lecture hall", 2);
		dow = new Building("Dow", "Athletic facility", 2);

		// Initialize room exits
		/**
		 * TODO not quite sure how i want to do these yet
		 * maybe link the buildings together
		 * or just type to travel between buildings
		 */
		
		// Adds all of the buildings to a big list
		listOfBuildings.add(vanZoren);
		listOfBuildings.add(vandeWerf);
		listOfBuildings.add(scienceCenter);
		listOfBuildings.add(library);
		listOfBuildings.add(vorhees);
		listOfBuildings.add(graves);
		listOfBuildings.add(cook);
		listOfBuildings.add(haworth);
		listOfBuildings.add(durfee);
		listOfBuildings.add(vanVleck);
		listOfBuildings.add(westernSem);
		listOfBuildings.add(wyckoff);
		listOfBuildings.add(scott);
		listOfBuildings.add(licty);
		listOfBuildings.add(kollen);
		listOfBuildings.add(lubbers);
		listOfBuildings.add(phelps);
		listOfBuildings.add(dewitt);
		listOfBuildings.add(marthaMiller);
		listOfBuildings.add(dow);
	}
	
	/**
	 * Creates Floors and then adds them to each Building
	 */
	private void addFloorsToBuildings() {
		
		// Declare the Floors
		Floor firstFloorVZN, secondFloorVZN; // VanZoren
		Floor firstFloorVWF, secondFloorVWF; // VandeWerf
		Floor firstFloorSC, secondFloorSC, thirdFloorSC; // Science Center
		Floor firstFloorLib, secondFloorLib, thirdFloorLib, fourthFloorLib, fifthFloorLib; // Library
		Floor firstFloorVor, secondFloorVor; // Vorhees
		Floor firstFloorGraves, secondFloorGraves; // Graves
		Floor firstFloorCook, secondFloorCook; // Cook
		Floor firstFloorHaworth, secondFloorHaworth, thirdFloorHaworth; // Haworth Inn
		Floor firstFloorDurfee, secondFloorDurfee; // Durfee
		Floor firstFloorVV, secondFloorVV; // Van Vleck
		Floor firstFloorWS, secondfloorWS, thirdFloorWS, fourthFloorWS, fifthFloorWS; // Western Sem Library
		Floor firstFloorWy, secondFloorWy, thirdFloorWy; // Wyckoff
		Floor firstFloorScott, secondFloorScott, thirdFloorScott; // Scott
		Floor firstFloorLicty, secondFloorLicty, thirdFloorLicty; // Licty
		Floor firstFloorKN, secondFloorKN, thirdFloorKN; // Kollen
		Floor firstFloorLub, secondFloorLub; // Lubbers
		Floor firstFloorPL, secondFloorPL; // Phelps
		Floor firstFloorDWT, secondFloorDWT, thirdFloorDWT; // DeWitt
		Floor firstFloorMM, secondFloorMM; // Martha Miller
		Floor firstFloorDow, secondFloorDow; // Dow
		
		// Creates the Floors
		firstFloorVZN = new Floor(1, ""); secondFloorVZN = new Floor(2, ""); // VanZoren
		firstFloorVWF = new Floor(1, ""); secondFloorVWF = new Floor(2, ""); // VandeWerf
		firstFloorSC = new Floor(1, ""); secondFloorSC = new Floor(2, ""); 
			thirdFloorSC = new Floor(3, ""); // Science Center
		firstFloorLib = new Floor(1, ""); secondFloorLib = new Floor(2, ""); 
			thirdFloorLib = new Floor(3, ""); fourthFloorLib = new Floor(4, ""); 
			fifthFloorLib = new Floor(5, ""); // Library
		firstFloorVor = new Floor(1, ""); secondFloorVor = new Floor(2, ""); // Vorhees
		firstFloorGraves = new Floor(1, ""); secondFloorGraves = new Floor(2, ""); // Graves
		firstFloorCook = new Floor(1, ""); secondFloorCook = new Floor(2, ""); // Cook
		firstFloorHaworth = new Floor(1, ""); secondFloorHaworth = new Floor(2, ""); 
			thirdFloorHaworth = new Floor(3, ""); // Haworth Inn
		firstFloorDurfee = new Floor(1, ""); secondFloorDurfee = new Floor(2, ""); // Durfee
		firstFloorVV = new Floor(1, ""); secondFloorVV = new Floor(2, ""); // Van Vleck
		firstFloorWS = new Floor(1, ""); secondfloorWS = new Floor(2, ""); thirdFloorWS = new Floor(3, ""); 
			fourthFloorWS = new Floor(4, ""); fifthFloorWS = new Floor(5, ""); // Western Sem Library
		firstFloorWy = new Floor(1, ""); secondFloorWy = new Floor(2, ""); thirdFloorWy = new Floor(3, ""); // Wyckoff
		firstFloorScott = new Floor(1, ""); secondFloorScott = new Floor(2, ""); 
			thirdFloorScott = new Floor(3, ""); // Scott
		firstFloorLicty = new Floor(1, ""); secondFloorLicty = new Floor(2, "");
			thirdFloorLicty = new Floor(3, ""); // Licty
		firstFloorKN = new Floor(1, ""); secondFloorKN = new Floor(2, "");
			thirdFloorKN = new Floor(3, ""); // Kollen
		firstFloorLub = new Floor(1, ""); secondFloorLub = new Floor(2, ""); // Lubbers
		firstFloorPL = new Floor(1, ""); secondFloorPL = new Floor(2, ""); // Phelps
		firstFloorDWT = new Floor(1, ""); secondFloorDWT = new Floor(2, ""); 
			thirdFloorDWT = new Floor(3, ""); // DeWitt
		firstFloorMM = new Floor(1, ""); secondFloorMM = new Floor(2, ""); // Martha Miller
		firstFloorDow = new Floor(1, ""); secondFloorDow = new Floor(2, ""); // Dow
		
		// Adds the Floors to the Buildings
		vanZoren.addFloor();
		
		vandeWerf
		
		scienceCenter
		
		library
		
		vorhees
		
		graves
		
		cook
		
		haworth
		
		durfee
		
		vanVleck
		
		vanWylen
		
		wyckoff
		
		scott
		
		licty
		
		kollen
		
		lubbers
		
		phelps
		
		dewitt
		
		marthaMiller
		
		dow
	}
	
	/**
	 * 
	 */
	private void addRoomsToFloors() {
		
	}
	
	/**
	 * 
	 */
	private void addItemsToRooms() {
		
	}
}
