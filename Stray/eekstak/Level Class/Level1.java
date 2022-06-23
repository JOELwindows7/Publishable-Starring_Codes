import greenfoot.*;

public class Level1 extends Level
{
    public Level1()
    {
        super(800, 600, 1);
        addObject(Level.bug, getWidth()/2, getHeight()/2);
    }
    
    public void setFields()
    {
        level = 1;
    }
    
    public void nextLevel()
    {
        Greenfoot.setWorld(new Level2());
    }
    
    public void resetLevel()
    {
        Greenfoot.setWorld(new Level1());
    }
}