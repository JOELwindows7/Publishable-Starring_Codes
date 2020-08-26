import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpeakHere here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpeakHere extends Stuff_1
{
    private int speakLoudly;
    private boolean activateDoor = false;
    /**
     * Constructors
     */
    public SpeakHere(){
        //getWorld().showText("Speak and clic[K]!", getX(), getY() - 100);
    }
    public void addedToWorld(World world){
        getWorld().showText("Speak and clic[K]!", getX(), getY() - 100);
    }
    
    /**
     * Act - do whatever the SpeakHere wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here
        speakLoudly = Greenfoot.getMicLevel();
        getWorld().showText("say AAA level: " + speakLoudly, getX(), getY() + 100);
        if(speakLoudly > 25){
            activateDoor = true;
        }
        if(Greenfoot.mouseClicked(this)){
            if(activateDoor){
                ((Gameplay)getWorld()).endTheLevel(true);
            } else{
                ((Gameplay)getWorld()).endTheLevel(false);
            }
        }
    }    
}
