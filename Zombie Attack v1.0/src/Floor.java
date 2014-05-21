import java.util.ArrayList;

public class Floor {

	private int level;
	private String description;
	private ArrayList<Room> roomsList;
	private Building whichBuilding;

	// Constructor
	public Floor(int level, String description) {
		this.setLevel(level);
		roomsList = new ArrayList<Room>();
		this.description = description;
	}
	
	/**
	 * Adds a room to the floor
	 */
	public void addRoom(Room newRoom) {
		roomsList.add(newRoom);
	}
	
	/**
	 * Returns an ArrayList holding all of the rooms
	 */
	public ArrayList<Room> getRooms() {
		return roomsList;
	}

	/**
	 * Sets the level of the floor
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * Gets the level of the floor
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Gets the description of the floor
	 */
	public String getDescription() {
		return description;
	}
}
