import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level_12 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_12 extends Gameplay
{

    /**
     * Constructor for objects of class Level_12.
     * 
     */
    public Level_12()
    {
        prepare();
    }

    public void setField(){ //to Adjust Level bar and init box
        levelKount = 12;
        levelName = "inVerging";
        levelCommand = "Getting closer";
        levelControlType = 1;
        levelControlType2= 0;
    }

    public void nextLevel(){ //To go to next level when nextButton is clicked
        //Greenfoot.setWorld(new Level_6());
        Greenfoot.setWorld(new Level_13()); //set the world raise by 1 in N number, 
        //e.g. if you are in Level_6(), then you should go to Level_7().
    }

    public void restartLevel(){ //to retry level when retryButton is clicked
        Greenfoot.setWorld(new Level_12()); //set the world as same as this was
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        dudeIsWalking dudeiswalking = new dudeIsWalking();
        addObject(dudeiswalking,105,233);
    }
}
