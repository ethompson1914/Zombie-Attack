import java.util.*;

/**
 * Zombie Attack is a text-based zombie-apocalypse survival game. The goal is to
 * stockpile all 8 items before the zombies come to attack you.
 * 
 * The Room class holds all variables and methods relevant to a room
 * 
 * @author  Eric Thompson
 * @version 2008.03.30
 */

public class Room 
{
	private String description;
	private String name;
	private HashMap<String, Item> itemsInRoom;

	/**
	 * Create a room described "description". Initially, it has
	 * no exits. "description" is something like "a kitchen" or
	 * "an open court yard".
	 * @param description The room's description.
	 */
	public Room(String name, String description) 
	{
		itemsInRoom = new HashMap<String, Item>();
		this.setName(name);
		this.description = description;
	}

	/**
	 * @return The short description of the room
	 * (the one that was defined in the constructor).
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * Returns a HashMap of the items in the room
	 * @return itemsInRoom The items in the room
	 */
	public HashMap<String, Item> getItemsInRoom() {
		return itemsInRoom;
	}

	/**
	 * Adds an item to the room
	 * @param newItem The item to be added to the room
	 */
	public void addItemToRoom(Item newItem) {
		itemsInRoom.put(newItem.getName(), newItem);
	}

	/**
	 * Removes an item from the room
	 * @param newItem The item to be removed from the room
	 */
	public void removeItem(Item newItem) {
		itemsInRoom.remove(newItem.getName());
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
}