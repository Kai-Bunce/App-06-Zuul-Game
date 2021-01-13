/**
 * Write a description of class Map here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Map 
{
    private Room outside;
    private Room theater;
    private Room pub;
    private Room lab;
    private Room office;
    private Room gym;
    private Room carpark;
    private Room reception;
    private Room car;
   
    
    private Room startRoom;
    
    public Map()
    {
        createRooms();
    }
    
    private void createRooms()
    {
      
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in the computing lab");
        office = new Room("in the computing admin office");
        gym = new Room("in the gym");
        carpark = new Room("in the carpark");
        reception = new Room("in the reception");
        car = new Room("you are in the car congratulations you win");
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        outside.setExit("north", carpark);

        theater.setExit("west", outside);
        theater.setExit("east", gym);

        pub.setExit("east", outside);
        pub.setItem(Items.LITRE_WATER);
        
        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);
        office.setExit("south", reception);
        office.setItem(Items.RECEPTION_KEY);
        

        startRoom = carpark; 
        
        setGymExits();
        setCarparkExits();
        setReception();
        
    }
    
    public void setGymExits()
    {
        gym.setExit("west", theater);
        theater.setExit("east",gym);
    }
    
    public void setCarparkExits()
    {
        carpark.setExit("south", outside);
        carpark.setExit("north", car);
        outside.setExit("north", carpark);
    }
    
    public void setReception()
    {
        reception.setExit("north", lab);
        lab.setExit("south", reception);
        reception.setItem(Items.CARKEYS);
    }
    
    public void setCar()
    {
        carpark.setExit("north",car);
    }
    
    public Room getStartRoom()
    {
        return startRoom;
    }
    
}

