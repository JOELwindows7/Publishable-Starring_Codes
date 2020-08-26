import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author JOELwindows7 
 * @version 2018
 * 
 * LOAD THIS WORLD FIRST
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Play play = new Play();
        addObject(play,60,200);
        Setting setting = new Setting();
        addObject(setting,60,275);
        Exit exit = new Exit();
        addObject(exit,60,350);

        //Write text!
        showText("The Quest of the Fidgets", 200, 50);
        About about = new About();
        addObject(about,300,200);
    }
	// KUmpul 2 Minggu lagi! (=4 Juni 2018)
}
