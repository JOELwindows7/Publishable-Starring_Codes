import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class retryButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class retryButton extends LevelResults
{
    World deref;
    public void addedToWorld(World world){
        deref = world;
    }
    /**
     * Act - do whatever the retryButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private World targetGo = getWorld();
    
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            //Greenfoot.setWorld(); //restart current world
            //getWorld().removeObject(this);
            ((Gameplay)getWorld()).restartLevel();
        }
    }    
    private World getWorldName(){
        return getWorld();
    }
}
