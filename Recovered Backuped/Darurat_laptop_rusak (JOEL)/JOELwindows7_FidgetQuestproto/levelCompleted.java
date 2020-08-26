import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.*;

/**
 * Write a description of class levelCompleted here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class levelCompleted extends LevelStatuser
{
    //Constructor setting
    public levelCompleted(){
        setImage(new GreenfootImage("Level Completed!", 48, Color.RED, Color.BLACK));
        //getWorld().addObject(new endLevelBar(), getWorld().getWidth() / 3, getWorld().getHeight() - 100);
    }
    
    /**
     * Act - do whatever the levelCompleted wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
}
