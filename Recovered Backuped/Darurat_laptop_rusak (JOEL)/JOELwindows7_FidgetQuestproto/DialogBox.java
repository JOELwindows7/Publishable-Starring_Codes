import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.*;
/**
 * Write a description of class DialogBox here.
 * 
 * http://www.greenfoot.org/scenarios/199
 * Joel edited for here.
 * 
 * @author Michael (original), JOELwindows7 (edit)
 * @version 2018
 */ 
public class DialogBox extends Stuff_4
{
    private String message;
    private String title;
    private final int width = 200, height = 50;
    private static final int titleHeight = 20;
    private PressComplete theCompelet = new PressComplete();
    private World Reffers;
    protected void addedToWorld(World world){
        Reffers = world;
    }
    
    /**
     * Create a new MessageDialog with a message and a title
     */
    public DialogBox(String message, String title)
    {
        this.message = message;
        this.title = title;
        makeFrame();
    }
    
    /**
     * Get rid of the box if someone clicks on it
     */
    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse==null) return;
        if(mouse.getActor()==this && mouse.getButton()==1){
            getWorld().removeObject(this);
            //((Gameplay)getWorld()).endTheLevel(true); //optional
            //Reffers.addObject(theCompelet, getWorld().getWidth() - 15, getWorld().getHeight() - 20);
            Reffers.addObject(theCompelet, Reffers.getWidth() -15, Reffers.getHeight() - 20);
        }
    }
    
    /**
     * Create a new MessageDialog with a message and a default title
     */    
    public DialogBox(String message)
    {
        this.message = message;
        title = "Greenfoot";
        makeFrame();
    }
    private void makeFrame()
    {
        GreenfootImage frame = new GreenfootImage(width, height+titleHeight);
        GreenfootImage title = new GreenfootImage(width, titleHeight);
        GreenfootImage body = new GreenfootImage(width, height);
        
        //Now fill in the colours
        title.setColor(Color.BLUE);
        body.setColor(Color.GRAY);
        title.fill();
        body.fill();
        
        //Now write the text onto the frame
        body.setColor(Color.WHITE);
        title.setColor(Color.WHITE);
        title.drawString(this.title, 0, titleHeight/2+5);
        body.drawString(message, 10, body.getHeight()/2);
        
        //Now add the parts of the frame onto the frame
        frame.drawImage(title, 0, 0);
        frame.drawImage(body, 0, titleHeight);
        
        setImage(frame);
    }
}
