import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level_11 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_11 extends Gameplay
{
    private int nonDeltaTimeKey = 2000;
    private Actor Booer = new booImage();
    private boolean flag_jumpscared = false;
    /**
     * Constructor for objects of class Level_11.
     * 
     */
    public Level_11()
    {
        prepare();
    }

    public void setField(){ //to Adjust Level bar and init box
        levelKount = 11;
        levelName = "Annoying";
        levelCommand = "This is Annoying!";
        levelControlType = 0;
        levelControlType2= 0;
    }

    public void nextLevel(){ //To go to next level when nextButton is clicked
        //Greenfoot.setWorld(new Level_6());
        Greenfoot.setWorld(new Level_12()); //set the world raise by 1 in N number, 
        //e.g. if you are in Level_6(), then you should go to Level_7().
    }

    public void restartLevel(){ //to retry level when retryButton is clicked
        Greenfoot.setWorld(new Level_11()); //set the world as same as this was
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Annoying_object annoying_object = new Annoying_object();
        addObject(annoying_object,289,220);
    }
    
    public void act(){
        if(nonDeltaTimeKey > 0) nonDeltaTimeKey -= 10;
        if(nonDeltaTimeKey <= 0){
            if(!flag_jumpscared){
                addObject(Booer, getWidth()/2, getHeight()/2);
                flag_jumpscared = true;
            }
        }
    }
}
