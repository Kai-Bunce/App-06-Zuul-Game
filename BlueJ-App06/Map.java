
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
    
    public void print()
    {
        
    }
   
    public Map()
    {
        createRooms();
    }
    
    private void createRooms()
    {
     Room outside, theater, pub, lab, office;
      
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        startRoom = outside;  // start game outside
    }
    
    public Room getStartRoom()
    {
        return startRoom;
    }
    
}

