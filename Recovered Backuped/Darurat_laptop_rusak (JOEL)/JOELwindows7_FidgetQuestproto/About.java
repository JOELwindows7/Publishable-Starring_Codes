import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class About here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class About extends Selects
{
    /**
     * Act - do whatever the About wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here
        WriterZ("About");
        transferWorld();
    }    
    protected void transferWorld(){
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld( new AboutScreen());
        }
    }
}
