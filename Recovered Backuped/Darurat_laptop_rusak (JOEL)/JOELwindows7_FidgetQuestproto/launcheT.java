import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class launcheT here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class launcheT extends testObjects
{
    /**
     * Act - do whatever the launcheT wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(retryButton.class)){
            Greenfoot.setWorld(new testResult());
        }
        if(Greenfoot.mouseClicked(this)){
            testResult TestWorlding = (testResult)getWorld();
            Kounter sqore = TestWorlding.getSkore();
            sqore.increaseKounter();
        }
    }    
    
    public void restartWorld(){ //overidden by its children
        //Greenfoot.setWorld(new testResult());
        
    }
    public void nextWorld(){ //also overidden by its children.
        //Greenfoot.setWorld(new testResult2());
    }
}
