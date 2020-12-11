
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
  
  public Player(String name)
  {
      this.name = name;
      score = 0;
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

    

