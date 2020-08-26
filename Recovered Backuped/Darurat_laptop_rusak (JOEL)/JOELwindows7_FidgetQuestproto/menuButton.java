import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class menuButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class menuButton extends LevelResults
{
    /**
     * Act - do whatever the menuButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Page1());
        }
    }    
}
