import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.*;

//import java.awt.*;

/**
 * Write a description of class popHalios here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class popHalios extends Stuff_9
{
    private int nonDeltaTimeKey = 100;
    private int Transparant = 255;
    private GreenfootImage groovy;
    private boolean existed = false;
    public void addedToWorld(World world){
        existed = true;
    }
    private Color randColor(){
        int select = Greenfoot.getRandomNumber(10);
        Color Wound = Color.BLACK;
        switch(select){
            default:
            Wound = Color.DARK_GRAY;
            break;
            
            case 0:
            Wound = Color.BLACK;
            break;
            
            case 1:
            Wound = Color.WHITE;
            break;
            
            case 2:
            Wound = Color.RED;
            break;
            
            case 3:
            Wound = Color.GREEN;
            break;
            
            case 4:
            Wound = Color.BLUE;
            break;
            
            case 5:
            Wound = Color.CYAN;
            break;
            
            case 6:
            Wound = Color.MAGENTA;
            break;
            
            case 7:
            Wound = Color.YELLOW;
            break;
            
            case 8:
            Wound = Color.ORANGE;
            break;
            
            case 9:
            Wound = Color.PINK;
            break;
        }
        return Wound;
    }
    /**
     * Act - do whatever the popHalios wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        //groovy = new GreenfootImage("HALIOTEN", 72, new Color(Greenfoot.getRandomNumber(255), Greenfoot.getRandomNumber(255), Greenfoot.getRandomNumber(255), 1), Color.BLACK);
        groovy = new GreenfootImage("HALIOTEN", 72, randColor(), Color.BLACK);
        // Add your action code here.
        setImage(groovy);
        if(existed){
            if(nonDeltaTimeKey > 0){
                nonDeltaTimeKey--;
            } else if(nonDeltaTimeKey <= 0){
                nonDeltaTimeKey = 0;
                if(Transparant > 1) Transparant -= 10;
            }
        }
        if(Transparant <= 1) {
            Transparant = 1;
            getWorld().removeObject(this);
        }
        getImage().setTransparency(Transparant);
    }    
}
//

//

//

//

//

//

//

//

//

