import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AboutScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AboutScreen extends World
{

    /**
     * Constructor for objects of class AboutScreen.
     * 
     */
    String Paragraf="";
    public AboutScreen()
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
        goBack goback = new goBack();
        addObject(goback,33,28);
        showText("About", 75, 25);
        
        Paragraf += "\nRead more Credit in README.TXT";
        Paragraf += "\nby JOELwindows7, Perkedel Technologies";
        Paragraf += "\nSoftware: GNU GPL v3; Documents: CC4.0-BY-SA";
        Paragraf += "\n";
        Paragraf += "\n Explosion bin video by Spion of YouTube";
        Paragraf += "\n WarioWare by Nintendo";
        Paragraf += "\n Trollface Quest by Spill games";
        Paragraf += "\n Greenfoot by Greenfoot dudes";
        showText(Paragraf, getWidth()/2, getHeight()/2);
    }
}
