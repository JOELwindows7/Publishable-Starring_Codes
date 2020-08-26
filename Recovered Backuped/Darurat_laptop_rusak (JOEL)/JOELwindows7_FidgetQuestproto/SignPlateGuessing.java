import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SignPlateGuessing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SignPlateGuessing extends Stuff_9
{
    private World refWorld;
    private Level_9 refSpecific;
    public void addedToWorld(World world){
        refWorld = world;
        //refSpecific = (Level_9)getWorld();
    }
    /**
     * Act - do whatever the SignPlateGuessing wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        setImage(new GreenfootImage("Ten Guesses: "+ ((Level_9)getWorld()).returnNum(), 24, Color.BLACK, Color.WHITE));
    }    
}
