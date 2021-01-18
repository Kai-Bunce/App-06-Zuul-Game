/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * Kai Bunce
 * Version 1
 * 
 * Modified and extended by Your name
 */

public class Game 
{
    private final Map map;

    private final Parser parser;

    private Room currentRoom;

    private Player player;
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        map = new Map();
        currentRoom = map.getStartRoom();
        player = new Player("Kai");
        parser = new Parser();
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;

        while (! finished) 
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }

        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Find Your Keys!");
        System.out.println("Find Your Keys is a new, incredibly boring adventure game where you find your car keys.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) 
        {
            case UNKNOWN:
            System.out.println("I don't know what you mean...");
            break;

            case HELP:
            printHelp();
            break;

            case GO:
            goRoom(command);
            break;

            case QUIT:
            wantToQuit = quit(command);
            break;

            case PICKUP:
            pickUp();
            break;

        }
        return wantToQuit;
    }

    private void printPlayerStatus()
    {
        System.out.println ( "player status = " + player.getPanic());
    }

    private void printPlayerScore()
    {
        System.out.println ( "player score = " + player.getScore());
    }
    // implementations of user commands:

    private void pickUp()
    {
        if(currentRoom. getItem()!= Items.NO_ITEMS)
        {
            Items item = currentRoom.getItem();
            player.pickUp(currentRoom. getItem());
            System.out.println("You've just picked up " + item);
        }

    }

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) 
        {
            System.out.println("There is no door!");
            return;
        }

        Items requiredItem = nextRoom.getRequiredItem();
        if( requiredItem != Items.NO_ITEMS)
        {
            if(player.hasItem(requiredItem))
            {
                enterNextRoom(nextRoom);
            }
            else
            {
                System.out.println("You cannot enter as you do not have " + requiredItem);
            }
        }
        else
        {
            enterNextRoom(nextRoom);
            
        }
        
    }
    
    private void enterNextRoom(Room nextRoom)
    {
        currentRoom = nextRoom;
        
        System.out.println(currentRoom.getLongDescription());
        printPlayerStatus();
        printPlayerScore();
        player.increasePanic(5);
        player.increaseScore(50);
    }
    
    private void enterCarRoom(Room nextRoom)
    {
        boolean isCarRoom = nextRoom.getShortDescription().contains("car");

        if ((player.hasItem(Items.CARKEYS) & isCarRoom) || !isCarRoom )
        {
            currentRoom = nextRoom; 
        }
        else 
        {
            System.out.println("You don't have the required key");
        }
    }

    private void enterReceptionRoom(Room nextRoom)
    {
        boolean isReceptionRoom = nextRoom.getShortDescription().contains("reception");

        if ((player.hasItem(Items.RECEPTION_KEY) & isReceptionRoom) )
        {
            currentRoom = nextRoom; 
        }
        else 
        {
            System.out.println("You don't have the required key");
        }

    }   
    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
