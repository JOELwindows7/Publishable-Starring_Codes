import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.*;
//import java.awt.*;

/**
 * Write a description of class barNumber here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class barNumber extends barParts
{
    /**
     * Constructors
     */
    public barNumber(int nomor){
        setImage(new GreenfootImage(""+nomor, sizing, Color.BLACK, new Color(0,0,0,0)));
    }
    public barNumber(int nomor, int Sizerd){
        setImage(new GreenfootImage(""+nomor, Sizerd, Color.BLACK, new Color(0,0,0,0)));
    }
    /**
     * Act - do whatever the barNumber wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
