import ch.aplu.jgamegrid.*;
import java.awt.Color;

public class JGameEx1 extends GameGrid
{
  public JGameEx1()
  {
    super(10, 10, 60, Color.red, "sprites/reef.gif");
    Fish nemo = new Fish();
    addActor(nemo, new Location(2, 4));
    show();
  }
  
  public static void main(String[] args)
  {
    new JGameEx1();
  }
}

// ------------- class Fish --------------------
class Fish extends Actor
{
  public Fish()
  {
    super("sprites/nemo.gif");
  }

  public void act()
  {
    move();
    if (isNearBorder())
      turn(180);
  }
}