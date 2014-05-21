import java.util.HashMap;

/**
 * Zombie Attack is a text-based zombie-apocalypse survival game. The goal is to
 * stockpile all 8 items before the zombies come to attack you.
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class CommandWords
{
    // A mapping between a command word and the CommandWord
    // associated with it.
    private HashMap<String, CommandWord> validCommands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        validCommands = new HashMap<String, CommandWord>();
        validCommands.put("go", CommandWord.GO);
        validCommands.put("help", CommandWord.HELP);
        validCommands.put("quit", CommandWord.QUIT);
        validCommands.put("back", CommandWord.BACK);
        validCommands.put("drop", CommandWord.DROP);
        validCommands.put("look", CommandWord.LOOK);
        validCommands.put("search", CommandWord.SEARCH);
        validCommands.put("take", CommandWord.TAKE);
        validCommands.put("show", CommandWord.SHOW);
        validCommands.put("weight", CommandWord.WEIGHT);
    }

    /**
     * Find the CommandWord associated with a command word.
     * @param commandWord The word to look up.
     * @return The CommandWord correspondng to commandWord, or UNKNOWN
     *         if it is not a valid command word.
     */
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = validCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }
    
    /**
     * Check whether a given String is a valid command word. 
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }

    /**
     * Print all valid commands to System.out.
     */
    public void showAll() 
    {
        for(String command : validCommands.keySet()) {
            if (command.equals("go")) {
            	System.out.println(command +": (i.e. \"go north\") - moves your player to the room in the specified" +
            			" direction");
            }
            if (command.equals("help")) {
            	System.out.println(command +": (i.e. \"help\") - prints help commands");
            }
            if (command.equals("quit")) {
            	System.out.println(command +": (i.e. \"quit\") - quits the game");
            }
            if (command.equals("look")) {
            	System.out.println(command +": (i.e. \"look north\") - gives the description of the specified room");
            }
            if (command.equals("back")) {
            	System.out.println(command +": (i.e. \"back\") - moves the player back to the previous room");
            }
            if (command.equals("drop")) {
            	System.out.println(command +": (i.e. \"drop item\") - drops the specified item");
            }
            if (command.equals("take")) {
            	System.out.println(command +": (i.e. \"take item\") - takes the specified item");
            }
            if (command.equals("search")) {
            	System.out.println(command +": (i.e. \"search\") - searches the current room for items");
            }
            if (command.equals("show")) {
            	System.out.println(command +": (i.e. \"show\") - shows the player's inventory");
            }
            if (command.equals("weight")) {
            	System.out.println(command +": (i.e. \"weight\") - get the amount of weight the player can still carry");
            }
        }
        System.out.println();
    }
}
