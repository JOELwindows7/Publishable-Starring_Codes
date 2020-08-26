import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.*;
import java.util.*;

/**
 * Write a description of class Gameplay here.
 * 
 * @author JOELwindows7 
 * @version 2018
 */
public class Gameplay extends World
{

    /**
     * Constructor for objects of class Gameplay.
     * 
     */
    
    protected int uniNonDeltaTimeKey = 0;
    private int skore; //danpost of Greenfoot, modified for this area; Score number
    protected int levelKount = -2; //Level Number
    protected String levelName = "<Untitled>"; //Level Title
    protected String levelCommand = "<Unknown>"; //Level what mission to do
    protected int levelControlType = 0;
    protected int levelControlType2= 0;
    //private static Actor scoreText; // actor to display score
    //private static Actor levelText; // actor to display level
    
    private int nonDeltaTimeKey = 0;
    public Gameplay()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
        
    }
    private void prepare(){
        setField();
        initScreen(levelKount, levelName, levelCommand, levelControlType, levelControlType2);
        nonDeltaTimeKey = 100;
        //gamePlayBar(levelKount, levelName);
    }
    
    public void initScreen(int levelNumRightNow, String levelNameRightNow, String levelCommandRightNow, int levelControlRightNow, int levelControlRightNow2){
        addObject(new levelInitBox(levelNumRightNow, levelNameRightNow, levelCommandRightNow, levelControlRightNow, levelControlRightNow2), getWidth()/2, 30);
    }
    public void gamePlayBar(int levelNumRightNow, String levelNameRightNow){
        addObject(new levelNumber(levelNumRightNow, levelNameRightNow), getWidth()/2, 12);
        //addObject(levelText, getWidth() - 287, getHeight()-287);
    }
    public void endTheLevel(boolean statement){
        addObject(new endLevelBar(statement), getWidth()/2, getHeight()-25);
    }
    public void endTheLevel(boolean statement, String CustomSay){
        addObject(new endLevelBar(statement, CustomSay), getWidth()/2, getHeight()-25);
    }
    
    /*
    private void setLevelText()
    {
        levelText.setImage(new GreenfootImage(""+levelKount+"   "+levelName, 24, Color.BLACK, new Color(0, 0, 0, 0)));
    }
    */
    
    public void setField(){}
    public void nextLevel(){}
    public void restartLevel(){}
    
    public void started(){
        //gamePlayBar(levelKount, levelName);
        /*
        if ("Gameplay".equals(getClass().getName()))
        {
            startOver();
        }
        */ 
    }
    /*
    public void startOver() //danpost's portions
    {
        // initialize static fields in this class
        //scoreText = getNewStillActor();
        levelText = new barName();
        
        skore = 0; // initialize score
        levelKount = -2; // initialize level
        levelName  = "<Untitled>";
        
        // start first world (beyond title screen)
        Greenfoot.setWorld(new Level_0());
    }
    */

   public void act(){
       uniNonDeltaTimeKey += 1;
    }
}
