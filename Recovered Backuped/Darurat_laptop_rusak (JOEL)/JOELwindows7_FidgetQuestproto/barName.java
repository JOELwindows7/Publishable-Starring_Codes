import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class barName here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class barName extends barParts
{
    
    /**
     * Constructors
     */
    public barName(String nama){
        setImage(new GreenfootImage(""+nama, sizing, Color.BLACK, new Color(0,0,0,0)));
    }
    public barName(String nama, int Sizerd){
        setImage(new GreenfootImage(""+nama, Sizerd, Color.BLACK, new Color(0,0,0,0)));
    }
    /**
     * Act - do whatever the barName wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
