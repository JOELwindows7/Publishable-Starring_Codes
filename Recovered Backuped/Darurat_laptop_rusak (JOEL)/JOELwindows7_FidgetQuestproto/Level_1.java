import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level_1 here.
 * 
 * @author JOELwindows7 
 * @version 2018
 */
public class Level_1 extends Gameplay
{

    /**
     * Constructor for objects of class Level_1.
     * 
     */
    
    //int SpeakLoud;
    
    public Level_1()
    {
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        SpeakHere speakhere = new SpeakHere();
        addObject(speakhere,305,205);
        //levelKount = 1;
        //levelName = "AAA so loud!";
        //levelCommand = "AAAAAAAAAAAAAAAAAAAAAAAAAA!!!!!";
        //setField();
    }
    
    
    public void setField(){
        levelKount = 1;
        levelName = "AAA so loud!";
        levelCommand = "AAAAAAAAAAAAAAAAAAAAAAAAAA!!!!!";
        levelControlType = 5;
    }
    
    public void nextLevel(){
        Greenfoot.setWorld(new Level_2());
    }
    public void restartLevel(){
        Greenfoot.setWorld(new Level_1());
    }
}
