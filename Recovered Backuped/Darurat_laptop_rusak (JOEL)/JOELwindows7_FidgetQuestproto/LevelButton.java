import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class LevelButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelButton extends Actor
{
    /**
     * Act - do whatever the LevelButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String labelName = "";
    public void act() 
    {
        // Add your action code here.
        WriterA(labelName);
    } 
    public String getlabelName(){return labelName;}
    public void setLabelName(String newName){this.labelName = newName;}
    
    protected void WriterA(String name){
        getWorld().showText(name, getX(), getY());
    }
}
