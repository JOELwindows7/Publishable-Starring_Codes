import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PressComplete here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PressComplete extends PressToGet
{
    World refferencing;
     //protected World whereAreWe = ((Gameplay)getWorld());
    public void addedToWorld(World world){
        refferencing = world;
    }
    /**
     * Act - do whatever the PressComplete wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private HUD hud = new HUD();
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            getWorld().showText("Complete!", 300, 200);
            //hud.levelIsAidingSomeTests(456);
            //levelCompleted triggerComplete = new levelCompleted();
            //getWorld().addObject(triggerComplete, getX(), getY());
            //endLevelBar endlevelbar = new endLevelBar(true);
            //getWorld().addObject(endlevelbar,300,376);
            ((Gameplay)getWorld()).endTheLevel(true);
            //triggerEnd(true);
        }
    }    
}
