import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Annoying_object here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Annoying_object extends Stuff_11
{
    private int nonDeltaTimeKey = 2200;
    private boolean existed = false;
    public void addedToWorld(World world){
        existed = true;
        
    }
    /**
     * Act - do whatever the Annoying_object wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(existed){
            if(nonDeltaTimeKey > 0){
                nonDeltaTimeKey -= 10;
            } else {
                Greenfoot.playSound("Explosion bin cropped.wav");
                Greenfoot.playSound("bad_explosion.wav");
                Greenfoot.playSound("Ali-A.wav");
                //Greenfoot.playSound("FitnessGram_Cut.wav");
                ((Gameplay)getWorld()).addObject(new DuarImage(), getX(), getY());
                ((Gameplay)getWorld()).endTheLevel(true, "You've just jumpscared!");
                getWorld().removeObject(this);
            }
        }
    }    
}
