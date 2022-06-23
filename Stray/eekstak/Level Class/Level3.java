import greenfoot.*;

public class Level3 extends Level
{
    public Level3()
    {
        super(500, 500, 1);
        addObject(new Gate(), 450, 450);
        addObject(Level.bug, getWidth()/2, getHeight()/2);
    }
    
    public void setFields()
    {
        level = 3;
    }
    
    public void nextLevel()
    {
        Greenfoot.setWorld(new GameOver());
    }
    
    public void resetLevel()
    {
        Greenfoot.setWorld(new Level3());
    }
}