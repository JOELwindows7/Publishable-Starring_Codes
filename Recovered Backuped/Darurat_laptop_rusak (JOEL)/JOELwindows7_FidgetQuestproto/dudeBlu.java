import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class dudeBlu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class dudeBlu extends Stuff_7
{
    //private int bottomPos = (int)(getWorld().getHeight()) - 50;
    //private int currY = getY();
    private int Jumpu = 0;
    /**
     * Act - do whatever the dudeBlu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("D")){
            move(5);
            
        } else if(Greenfoot.isKeyDown("A")){
            move(-5);
        }
        
    }    
}
