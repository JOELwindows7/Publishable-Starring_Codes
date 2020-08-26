import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level_4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_4 extends Gameplay
{

    /**
     * Constructor for objects of class Level_4.
     * 
     */
    public Level_4()
    {
        prepare();
    }

    public void setField(){
        levelKount = 4;
        levelName = "Dialoug";
        levelCommand = "Answer!";
        levelControlType = 1;
    }

    public void nextLevel(){
        Greenfoot.setWorld(new Level_5());
    }

    public void restartLevel(){
        Greenfoot.setWorld(new Level_4());
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        ActivationKey activationkey = new ActivationKey();
        addObject(activationkey,getWidth()/2,getHeight()/2);
    }
}
