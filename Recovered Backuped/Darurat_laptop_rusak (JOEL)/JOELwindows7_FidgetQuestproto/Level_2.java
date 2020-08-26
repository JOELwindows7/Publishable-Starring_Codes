import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level_2 here.
 * 
 * @author JOELwindows7
 * @version 2018
 */
public class Level_2 extends Gameplay
{

    /**
     * Constructor for objects of class Level_2.
     * 
     */
    public Level_2()
    {
        prepare();
    }

    public void setField(){
        levelKount = 2;
        levelName = "Hmst'd've";
        levelCommand = "Hmmm";
        levelControlType = 2;
    }

    public void nextLevel(){
        Greenfoot.setWorld(new Level_3());
    }

    public void restartLevel(){
        Greenfoot.setWorld(new Level_2());
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        turtlei turtlei = new turtlei();
        addObject(turtlei,300,200);
        TouchToComplete touchtocomplete = new TouchToComplete();
        addObject(touchtocomplete,245,12);
    }
    
    public void act(){
        
    }
}
