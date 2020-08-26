import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class booImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class booImage extends Stuff_11
{
    private int nonDeltaTimeKey = 100;
    private boolean existed = false;
    public void addedToWorld(World world){
        existed = true;
        Greenfoot.playSound("jumpscare_screech.wav");
    }
    /**
     * Act - do whatever the booImage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(existed){
            if(nonDeltaTimeKey > 0){
                nonDeltaTimeKey -= 10;
            } else {
                
                getWorld().removeObject(this);
            }
        }
    }    
}
