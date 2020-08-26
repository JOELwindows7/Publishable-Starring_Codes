import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.*;
import java.util.*; //why the fak didn't import List method libraries?

/**
 * Write a description of class endLevelBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class endLevelBar extends LevelResults
{
    private String wording = "";
    private Boolean levelBool = false;
    private Boolean itHasCustomString = false;
    private String whatDoesItSays;
    private GreenfootImage barTemplate = new GreenfootImage("levelEndBar.png");
    private GreenfootImage refferBar = new GreenfootImage(barTemplate);
    
    World refferencing = (World)getWorld();
    nextButton theButtonNext = new nextButton();
    public endLevelBar(Boolean satus){
        /*
        if(satus != false){
            wording = "Completed!";
        } else {
            wording = "Failed!";
        }
        */
        //refferencing.addObject(new menuButton(), 440,330);
        //refferencing.addObject(new retryButton(), 480,330);
        levelBool = satus;
        itHasCustomString = false;
        //setImage(new GreenfootImage("Level " + wording, 48, Color.RED, Color.BLACK));
    }
    public endLevelBar(Boolean satus, String SayCustom){
        /*
        if(satus != false){
            wording = "Completed!";
        } else {
            wording = "Failed!";
        }
        */
        //refferencing.addObject(new menuButton(), 440,330);
        //refferencing.addObject(new retryButton(), 480,330);
        levelBool = satus;
        itHasCustomString = true;
        whatDoesItSays = SayCustom;
        //setImage(new GreenfootImage("Level " + wording, 48, Color.RED, Color.BLACK));
    }
    
    protected void addedToWorld(World world)
    {
        world.addObject(new retryButton(), 480,330);
        world.addObject(new menuButton(), 440,330);
        /*
        if(levelBool!=false){
            
            world.addObject(theButtonNext, 580,330);
        }
        */
        refferencing = world;
    }
    /**
     * Act - do whatever the endLevelBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
        if(levelBool){
            //
            setImage(new GreenfootImage(refferBar));
            getImage().setColor(Color.GREEN);
            if(itHasCustomString == true) wording = ""+whatDoesItSays;
            if(itHasCustomString == false) wording = "Level Completed!";
            List objectslookingfor = getWorld().getObjects(nextButton.class);
            if (objectslookingfor.size() == 0) refferencing.addObject(theButtonNext, 580, 330);
            //refferencing.addObject(new nextButton(), 580,330);
        } else {
            setImage(new GreenfootImage(refferBar));
            getImage().setColor(Color.RED);
            if(itHasCustomString == true) wording = ""+whatDoesItSays;
            if(itHasCustomString == false) wording = "Level Failed!";
            getWorld().removeObjects(getWorld().getObjects(nextButton.class));
        }
        getWorld().showText(wording, getX()/2, getY());
        //getWorld().showText("Level " + wording, getX()-200, getY());
    }
    public void setLevelBool(boolean choices){
        levelBool = choices;
    }
}
