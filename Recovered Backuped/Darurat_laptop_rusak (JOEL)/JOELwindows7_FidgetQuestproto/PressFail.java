import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PressFail here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PressFail extends PressToGet
{
    /**
     * Act - do whatever the PressFail wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            getWorld().showText("Failed!", 300, 200);
            //endLevelBar endlevelbar = new endLevelBar(false);
            //getWorld().addObject(endlevelbar,300,376);
            ((Gameplay)getWorld()).endTheLevel(false);
        }
    }    
}
