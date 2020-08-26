import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class testResult3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class testResult3 extends testAreas
{

    /**
     * Constructor for objects of class testResult3.
     * 
     */
    public testResult3()
    {
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Press_E_to_Activate press_e_to_activate2 = new Press_E_to_Activate();
        addObject(press_e_to_activate2,331,182);
    }
}
