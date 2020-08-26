import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.*;

/**
 * Write a description of class Kounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kounter extends HUD
{
    private int Kounters = -1;
    /**
     * Act - do whatever the Kounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        setImage(new GreenfootImage("" + Kounters, 24, Color.GREEN, Color.BLACK));
    }    
    public void increaseKounter(){
        Kounters++;
    }
    public void decreaseKounter(){
        Kounters--;
    }
    public void resetKounter(){
        Kounters = -1;
    }
    public void setKounter(int nombor){
        Kounters = nombor;
    }
}
