import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.*;
import java.util.*;

/**
 * Write a description of class levelNumber here.
 * 
 * @author JOELwindows7 
 * @version 2018
 */
public class levelNumber extends duringGameplay
{
    /**
     * Constructors
     */
    private int currNum;
    private String currName;
    private String currCommand;
    private Actor scoreText; // actor to display score
    private Actor levelText; // actor to display level
    private Actor levelInte;
    public levelNumber(int NumberNow, String NameNow){
        currNum = NumberNow;
        currName = NameNow;
        //prepare();
    }
    public void addedToWorld(World world){
        //getWorld().addObject(_object_, _x_, _y_);
        //world.showText("" + currNum, getX() - 287, getY());
        //world.showText("" + currName, getX(), getY());
        scoreText = getNewStillActor();
        levelText = new barName(currName);
        levelInte = new barNumber(currNum);
        
        world.addObject(levelInte, getX()-287, getY());
        world.addObject(levelText, getX(), getY());
    }
    /**
     * Act - do whatever the levelNumber wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        //currNum = 0;
        //currName = "J";
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Page1());
        }
    }    
}
