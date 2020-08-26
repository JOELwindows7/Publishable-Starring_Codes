import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class testResult2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class testResult2 extends testAreas
{

    /**
     * Constructor for objects of class testResult2.
     * 
     */
    public testResult2()
    {
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        levelNumber levelnumber = new levelNumber(12, "Windowsl");
        addObject(levelnumber,getWidth()/2,12);
        DuarImage duarimage = new DuarImage();
        addObject(duarimage,255,202);
        BoomImage boomimage = new BoomImage();
        addObject(boomimage,446,202);
        
    }
}
