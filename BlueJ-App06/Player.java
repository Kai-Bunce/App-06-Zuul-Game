
import java.util.ArrayList;
/**
 * The player class is the users character and can be used and played with
 *
 * Kai Bunce
 * Version 1
 */
public class Player
{
  private final String name;
  private int score;
  private int count;
  private int panic;
  private ArrayList < Items > items;
  
  public Player(String name)
  {
      this.name = name;
      score = 0;
      panic = 0;
      count = 0;
      items = new ArrayList <Items> ();
  }
  
  public void pickUp(Items item)
  {
      items.add(item);
  }
  
  public int getPanic()
  {
      return panic;
  }
  
  public int getScore()
  {
      return score;
  }
  
  public void resetScore()
  {
      score = 0;
  }
  
  public void increaseScore (int amount)
  {
       if(amount > 0)
          score += amount;
  }  
  
  public void print()
  {
      System.out.println("Player : " + name);
      System.out.println();
  }
}

    

