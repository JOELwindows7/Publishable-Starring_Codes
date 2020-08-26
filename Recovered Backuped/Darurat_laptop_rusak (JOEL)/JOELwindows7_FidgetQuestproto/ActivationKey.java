import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ActivationKey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ActivationKey extends Stuff_4
{
    /**
     * Act - do whatever the ActivationKey wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            ((Gameplay)getWorld()).addObject(new DialogBox("Nice to meet you!","Hello!"),220,100);
        }
    }    
}
