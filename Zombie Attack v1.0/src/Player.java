 import java.util.*;

 /**
  * Zombie Attack is a text-based zombie-apocalypse survival game. The goal is to
  * stockpile all 8 items before the zombies come to attack you.
  * 
  * The Player class holds all variables and methods relevant to a player
  * 
  * @author  Eric Thompson
  * @version 2008.03.30
  */

public class Player {

	private final String name;
	private HashMap<String, Item> inventory;
	private Building currentBuilding;
	private Floor currentFloor;
	private Room currentRoom;
	private int weightCanCarry;
	private Building startBuilding;

	/**
	 * Constructor for objects of type Player
	 * @param playerName
	 */
	public Player(String playerName) {
		name = playerName;
		weightCanCarry = 20; 
		currentBuilding = startBuilding;
		inventory = new HashMap<String, Item>();
	}
	
	/**
	 * Get's the player's name
	 * @return name The player's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Simulates the player picking up an item
	 * @param newItem The new item to be picked up
	 */
	public void pickUpItem(Item newItem) {
		if (newItem.getName().equals("wagon")) {
			weightCanCarry += 10;
		}
		if (newItem.getWeight() <= weightCanCarry) {
			inventory.put(newItem.getName(), newItem);
			currentBuilding.removeItem(newItem);
			weightCanCarry -= newItem.getWeight();
		}
		else {
			System.out.println("That item is too heavy! Drop another item before you pick this one up!");
		}
	}
	
	/**
	 * Shows the player's inventory
	 * @return items The player's inventory
	 */
	public ArrayList<String> showInventory() {
		ArrayList<String> items = new ArrayList<String>();
		for (Item item : inventory.values()) {
    		items.add("Item: "+item.getName()+" - Description: "+item.getDescription()+" - Weight: "+item.getWeight()+" pound(s).");
		}
		return items;
	}

	/**
	 * Simulates the player dropping an item
	 * @param newItem The item to be dropped
	 */
	public void dropItem(Item newItem) {
		currentBuilding.addItemToRoom(newItem);
	}
	
	/**
	 * Returns the player's inventory
	 * @return inventory The player's inventory
	 */
	public HashMap<String, Item> getInventory() {
		return inventory;
	}

	/**
	 * @param currentRoom the currentRoom to set
	 */
	public void setCurrentBuilding(Building currentBuilding) {
		this.currentBuilding = currentBuilding;
	}

	/**
	 * @return the currentRoom
	 */
	public Building getCurrentBuilding() {
		return currentBuilding;
	}
	
	/**
	 * Returns the weight that the player can still carry
	 * @return weightCanCarry The weight the player can still carry
	 */
	public int getWeightCanCarry() {
		return weightCanCarry;
	}
	
	/**
	 * Changes the weight that the player can carry
	 * @param weightCanCarry The new weight that the player can carry 
	 */
	public void setWeightCanCarry(int weightCanCarry) {
		this.weightCanCarry = weightCanCarry;
	}
}
