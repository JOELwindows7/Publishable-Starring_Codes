import greenfoot.*;

public class Level2 extends Level
{
    public Level2()
    {
        super(600, 400, 1);
        addObject(Level.bug, getWidth()/2, getHeight()/2);
    }
    
    public void setFields()
    {
        level = 2;
    }
    
    public void nextLevel()
    {
        Greenfoot.setWorld(new Level3());
    }
    
    public void resetLevel()
    {
        Greenfoot.setWorld(new Level2());
    }
}