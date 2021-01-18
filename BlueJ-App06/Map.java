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
        outside = new Room("outside the main entrance of the university no one is in sight you can go to the theater, lab, pub or the carpark");
        theater = new Room("in a lecture theater luckily no lecture is going on you don't see anything of importance near by");
        pub = new Room("in the campus pub theres a litre of water at the bar which may reduce your stress if you drink it pickup?. ");
        lab = new Room("in the computing lab");
        office = new Room("in the computing admin office you see a key labelled reception it may be of use to you pickup?");
        gym = new Room("in the gym why are you here? You never go here");
        carpark = new Room("in the carpark you see your car in a sea of cars");
        reception = new Room("in the reception the recptionist has gone home for the day however you see a key which looks like your car keys pickup?");
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
        

        startRoom = outside; 
        
        setGymExits();
        setCarparkExits();
        setReception();
        setCar();
        
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
        reception.setRequiredItem(Items.RECEPTION_KEY);
    }
    
    public void setCar()
    {
        carpark.setExit("north",car);
        car.setRequiredItem(Items.CARKEYS);
    }
    
    public Room getStartRoom()
    {
        return startRoom;
    }
    
}

