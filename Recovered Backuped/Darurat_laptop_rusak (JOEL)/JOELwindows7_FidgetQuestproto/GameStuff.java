import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameStuff here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameStuff extends Actor
{
    protected Gameplay whereAreWe = ((Gameplay)getWorld());
    /**
     * Act - do whatever the GameStuff wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    public void triggerEnd(boolean triggered){
        whereAreWe.endTheLevel(triggered);
    }
}
