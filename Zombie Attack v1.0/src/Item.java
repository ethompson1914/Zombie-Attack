/**
 *  Zombie Attack is a text-based zombie-apocalypse survival game. The goal is to
 *  stockpile all 8 items before the zombies come to attack you.
 *  
 *  The Item class holds all variables and methods relevant to an item
 * 
 * @author  Eric Thompson
 * @version 2008.03.30
 */

public class Item {

	private String name;
	private String description;
	private int weight;
	private boolean canBeSeen;
	
	/**
	 * Constructor for objects of type Item
	 * @param itemWeight
	 * @param itemName
	 * @param itemDescription
	 * @param canBeSeen
	 */
	public Item(int itemWeight, String itemName, String itemDescription) {
		weight = itemWeight;
		name = itemName;
		description = itemDescription;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}
}
