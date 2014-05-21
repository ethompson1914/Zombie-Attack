import java.util.*;

/**
 * Zombie Attack is a text-based zombie-apocalypse survival game. The goal is to
 * stockpile all 8 items before the zombies come to attack you.
 * 
 * @author Eric Thompson
 * @version 1.0
 */

public class Game {
	private Parser parser;
	private int countUntilZombiesAttack;
	private Player playa;
	private ArrayList<Room> previousRooms;
	private ArrayList<Building> listOfBuildings;

	/**
	 * Create the game and initialize its internal map.
	 */
	public Game() {
		playa = new Player("Bob");
		listOfBuildings = new ArrayList<Building>();
		setUpGame();
		parser = new Parser();
		countUntilZombiesAttack = 0;
		previousRooms = new ArrayList<Room>();
	}

	
		

		// create the items
		sword = new Item(5, "sword", "To cut zombies up", true);
		shield = new Item(5, "shield", "To block zombie attacks", true);
		shotgun = new Item(6, "shotgun", "To blow zombies away", true);
		knife = new Item(1, "knife", "To cut zombies up", true);
		armor = new Item(15, "armor", "To block zombie attacks", true);
		wagon = new Item(0, "wagon", "To help carry stuff", true);
		adrenaline = new Item(1, "adrenaline",
				"(Special Item) An extra boost of strength to help"
						+ "fight off the zombies", false);
		grenades = new Item(1, "grenades",
				"(Special Item) To blow the crap out of zombies", false);

		// adds the items to the rooms

		swamp.addItemToRoom(knife);

		northSwamp.addItemToRoom(shotgun);

		abandonedShack.addItemToRoom(wagon);

		westSwamp.addItemToRoom(shield);

		oldTree.addItemToRoom(grenades);
		oldTree.addItemToRoom(adrenaline);

		cave.addItemToRoom(armor);

		marsh.addItemToRoom(sword);
	}

	/**
	 * The main method to run the game
	 */
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}

	/**
	 * Main play routine. Loops until end of play.
	 */
	public void play() {
		printWelcome();

		// Enter the main command loop. Here we repeatedly read commands and
		// execute them until the game is over.

		boolean finished = false;
		while (!finished) {
			Command command = parser.getCommand();
			finished = processCommand(command);
			countUntilZombiesAttack++;
			if (countUntilZombiesAttack == 50) {
				System.out
						.println("All of a sudden a horde of zombies came charging out of the trees."
								+ "\nSince you did not gather the necessary items before they charged, you"
								+ "\nwere unable to fight off the zombie masses. You were killed by zombies.");
				finished = true;
			}
			for (int k = 0; k < listOfBuildings.size(); k++) {
				Room roomTemp = listOfBuildings.get(k);
				if (playa.getCurrentRoom().getName().equals(roomTemp.getName())) {
					if (roomTemp.getItemsInRoomAL().size()
							+ playa.getInventory().size() == 8) {
						System.out
								.println("You managed to stockpile all of the items with time to spare before the zombies"
										+ "\nattacked. You're ready to destroy the zombies when they come. Now all that's left to do is"
										+ "\nwait for them to come.");
						finished = true;
						break;
					}
				}
			}

		}
		System.out.println("Thank you for playing.  Good bye.");
	}

	/**
	 * Print out the opening message for the player.
	 */
	private void printWelcome() {
		System.out.println();
		System.out.println("Welcome to Zombie Attack v1.0\n");
		System.out
				.println("The date is July 5, 2049, 10 days after the zombie"
						+ "\napocalypse. You have wandered for 5 days, searching for any"
						+ "\nsurvivors, but you haven't found any. You're starting to"
						+ "\nthink you're the only one who survived. After almost a week"
						+ "\nof running, you come to a dark and creepy swamp. You decide to go in,"
						+ "\nthinking you might be able to lose the zombies chasing you. Be careful when you"
						+ "\nchoose your actions, because each one may be the difference between life"
						+ "\nor death. Stockpile 8 different items to fight off the zombies when they attack.");
		System.out.println("Type 'help' if you need help.");
		System.out.println();
		System.out.println(playa.getCurrentRoom().getLongDescription());
	}

	/**
	 * Given a command, process (that is: execute) the command.
	 * 
	 * @param command
	 *            The command to be processed.
	 * @return true If the command ends the game, false otherwise.
	 */
	private boolean processCommand(Command command) {
		boolean wantToQuit = false;

		CommandWord commandWord = command.getCommandWord();

		if (commandWord == CommandWord.UNKNOWN) {
			System.out.println("I don't know what you mean...");
			return false;
		}

		if (commandWord == CommandWord.HELP) {
			printHelp();
		} else if (commandWord == CommandWord.GO) {
			previousRooms.add(playa.getCurrentRoom());
			goRoom(command);
		} else if (commandWord == CommandWord.QUIT) {
			wantToQuit = quit(command);
		} else if (commandWord == CommandWord.TAKE) {
			String temp = command.getSecondWord();
			Item tempItem = playa.getCurrentRoom().getItemsInRoom().get(temp);
			if (tempItem == null) {
				System.out.println("That item isn't in this room!");
			} else {
				playa.pickUpItem(tempItem);
				playa.getCurrentRoom().removeItem(tempItem);
				System.out.println("You picked up a(n) " + tempItem.getName());
			}
		} else if (commandWord == CommandWord.WEIGHT) {
			System.out.println("You can still carry "
					+ playa.getWeightCanCarry() + " more pounds.");
		} else if (commandWord == CommandWord.DROP) {
			String temp = command.getSecondWord();
			Item tempItem = playa.getInventory().get(temp);
			if (playa.getInventory().containsValue(tempItem)) {
				playa.dropItem(tempItem);
				playa.getInventory().remove(tempItem.getName());
				playa.getCurrentRoom().addItemToRoom(tempItem);
				playa.setWeightCanCarry(playa.getWeightCanCarry()
						+ tempItem.getWeight());
				System.out.println("You dropped a(n) " + tempItem.getName());
			} else {
				System.out.println("You aren't carrying that item!!");
			}
		} else if (commandWord == CommandWord.SEARCH) {
			searchRoom(playa.getCurrentRoom());
		} else if (commandWord == CommandWord.BACK) {
			if (previousRooms.size() == 0) {
				System.out
						.println("You can't go back beyond the start of the game!");
			} else {
				playa.setCurrentRoom(previousRooms.get(previousRooms.size() - 1));
				previousRooms.remove(previousRooms.size() - 1);
				System.out.println(playa.getCurrentRoom().getLongDescription());
			}
		} else if (commandWord == CommandWord.SHOW) {
			ArrayList<String> inventory = playa.showInventory();
			if (inventory.isEmpty()) {
				System.out.println("You aren't carrying anything right now!");
			} else {
				for (String temp : inventory) {
					System.out.println(temp);
				}
			}
		} else if (commandWord == CommandWord.LOOK) {
			lookRoom(command);
		}
		// else command not recognized.
		return wantToQuit;
	}

	/**
	 * Print out a list of the command words.
	 */
	private void printHelp() {
		System.out.println("Your command words are:");
		parser.showCommands();
	}

	public void searchRoom(Room tempRoom) {
		ArrayList<String> items = tempRoom.getItemsInRoom();
		if (items.isEmpty()) {
			System.out.println("There are no items in this room");
		} else {
			for (int k = 0; k < items.size(); k++) {
				if (playa.getCurrentRoom().getName().equals("old tree")) {
					System.out
							.println("This time when you search, you notice a small rock that seems out of"
									+ "\nplace. You lift up the rock and see the following item:");
					System.out.println(items.get(k));
				} else {
					System.out.println(items.get(k));
				}
			}
		}
	}

	/**
	 * Try to go to one direction. If there is an exit, enter the new room,
	 * otherwise print an error message.
	 */
	private void goRoom(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			System.out.println("Go where?");
			return;
		}

		String direction = command.getSecondWord();

		// Try to leave current room.
		Room nextRoom = playa.getCurrentRoom().getExit(direction);

		if (nextRoom == null) {
			System.out
					.println("If you went that way, you would be attacked and killed by zombies."
							+ "\nTry another way.");
		} else {
			playa.setCurrentRoom(nextRoom);
			System.out.println(playa.getCurrentRoom().getLongDescription());
		}
	}

	/**
	 * Looks in the specific direction inputted and prints the room's
	 * description in that direction
	 */
	public void lookRoom(Command command) {

		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to look...
			System.out.println("Look where?");
			return;
		}

		String direction = command.getSecondWord();

		// Try to leave current room.
		Room nextRoom = playa.getCurrentRoom().getExit(direction);

		if (nextRoom == null) {
			System.out
					.println("You can see outside of the swamp. But you know if you went there,"
							+ "\nyou would be attacked by zombies and would most likely die. Try another way.");
		} else {
			System.out.println(nextRoom.getShortDescription());
		}
	}

	/**
	 * "Quit" was entered. Check the rest of the command to see whether we
	 * really quit the game.
	 * 
	 * @return true, if this command quits the game, false otherwise.
	 */
	private boolean quit(Command command) {
		if (command.hasSecondWord()) {
			System.out.println("Quit what?");
			return false;
		} else {
			return true; // signal that we want to quit
		}
	}
}
