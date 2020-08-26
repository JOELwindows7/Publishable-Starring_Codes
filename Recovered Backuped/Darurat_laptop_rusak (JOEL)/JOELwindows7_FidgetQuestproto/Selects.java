import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Selects here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Selects extends Actor
{
    /**
     * Act - do whatever the Selects wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    public void WriterZ(String name){
        getWorld().showText(name, getX() + 10, getY());
    }
    protected void transferWorld(){
        
    }
    protected void terminateApp(){
        
    }
}
