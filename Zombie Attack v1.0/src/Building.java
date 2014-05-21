import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

/**
 * Zombie Attack is a text-based zombie-apocalypse survival game. The goal is to
 * stockpile all 8 items before the zombies come to attack you.
 * 
 * The Room class holds all variables and methods relevant to a room
 * 
 * @author  Eric Thompson
 * @version 2008.03.30
 */

public class Building 
{
	private int floors;
	private String name;
	private String description;
	private HashMap<String, Building> neighboringBuildings;
	private ArrayList<Floor> floorsList;

	/**
	 * Create a room described "description". Initially, it has
	 * no exits. "description" is something like "a kitchen" or
	 * "an open court yard".
	 * @param description The room's description.
	 */
	public Building(String name, String description, int floors) 
	{
		this.setName(name);
		this.description = description;
		this.setFloors(floors);
		floorsList = new ArrayList<Floor>();
		neighboringBuildings = new HashMap<String, Building>();
	}

	/**
	 * Define an exit from this room.
	 * @param direction The direction of the exit.
	 * @param neighbor  The room to which the exit leads.
	 */
	public void setExit(String direction, Building neighbor) 
	{
		neighboringBuildings.put(direction, neighbor);
	}

	/**
	 * Return a string describing the room's exits, for example
	 * "Exits: north west".
	 * @return Details of the room's exits.
	 */
	private String getExitString()
	{
		String returnString = "You can travel to:\n";
		Set<String> keys = neighboringBuildings.keySet();
		for(String exit : keys) {
			returnString += (" " + neighboringBuildings.get(exit).getDescription() + "\n");
		}
		return returnString;
	}
	
	/**
	 * Gives the name and description of the building, as well
	 * as how many floors there are
	 */
	public String inspectBuilding() {
		String returnString = "This is " + name + " , " + description;
		returnString += ".\nThere are " + floors + "floors.";
		return returnString;
	}

	/**
	 * @param Sets the name of the building
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return The name of the building
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Adds a Floor object to the building
	 */
	public void addFloor(Floor newFloor) {
		floorsList.add(newFloor);
	}

	/**
	 * @param Sets the amount of floors in the building
	 */
	public void setFloors(int floors) {
		this.floors = floors;
	}

	/**
	 * @return Gets the number of floors in the building
	 */
	public int getFloors() {
		return floors;
	}
}