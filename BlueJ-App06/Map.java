/**
 * Write a description of class Map here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Map 
{
    private Room outside;
    private Room theate;
    private Room pub;
    private Room lab;
    private Room office;
    
    private Room startRoom;
    
    public Map()
    {
        createRooms();
    }
    
    private void createRooms()
    {
     Room outside, theater, pub, lab, office, gym, carpark, reception;
      
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        gym = new Room("in the gym");
        carpark = new Room("in the carpark");
        reception = new Room("in the reception");
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        outside.setExit("north", carpark);

        theater.setExit("west", outside);
        theater.setExit("east", gym);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);
        office.setExit("south", reception);

        startRoom = outside;  // start game outside
    }
    
    public void createGym()
    {
        gym = new Room("A gym");
        gym.setExit("east", theater);
        theate,setExit("west",gym);
    }
    
    
    public Room getStartRoom()
    {
        return startRoom;
    }
    
}

