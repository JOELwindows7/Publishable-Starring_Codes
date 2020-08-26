import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SettingLevel extends World
{

    /**
     * Constructor for objects of class SettingLevel.
     * 
     */
    public SettingLevel()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    private void prepare(){
        showText("Setting!", 75, 25);
        
        //Go Back button
        goBack goback = new goBack();
        addObject(goback,28,31);
        
    }
}
