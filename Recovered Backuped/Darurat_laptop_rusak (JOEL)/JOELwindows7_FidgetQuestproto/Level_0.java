import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level_0 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_0 extends Gameplay
{
    /**
     * Constructor for objects of class Level_0.
     * 
     */
    
    private Level_1 nextLevel = new Level_1();
    
    public Level_0()
    {
        prepare();
        CompleteClicked();
        FailedClicked();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private int buttonPlacerX[] = new int[]{getWidth() / 3, getWidth() / 2 + 100};
    private void prepare()
    {
        
        showText("Choose Wisely!", getWidth()/2, getHeight()/3);
        showText("Complete", buttonPlacerX[0], 275);
        showText("Failed" , buttonPlacerX[1], 275);
        
        
        PressComplete presscomplete = new PressComplete();
        addObject(presscomplete,buttonPlacerX[0],200);
        PressFail pressfail = new PressFail();
        addObject(pressfail,buttonPlacerX[1],200);
        
        //levelKount = 0;
        //levelName = "Press the button";
        //levelCommand = "Choose!";
        //setField();
    }
    
    public void setField(){
        levelKount = 0;
        levelName = "Press the button";
        levelCommand = "Choose!";
        levelControlType = 1;
    }
    
    public void nextLevel(){
        Greenfoot.setWorld(new Level_1());
    }
    public void restartLevel(){
        Greenfoot.setWorld(new Level_0());
    }
    
    private void CompleteClicked(){
        
    }
    private void FailedClicked(){
        
    }
}
