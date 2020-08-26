import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class testWombat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class testWombat extends testObjects
{
    /**
     * Act - do whatever the testWombat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            getWorld().showText("Hello World!", getX(), getY());
        }
    }    
}
