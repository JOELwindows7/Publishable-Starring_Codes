import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LaunchButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LaunchButton extends Stuff_10
{
    
    public LaunchButton(){
        
    }
    public void addedToWorld(World world){
        getWorld().showText("Launch", getX(), getY());
    }
    /**
     * Act - do whatever the LaunchButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
