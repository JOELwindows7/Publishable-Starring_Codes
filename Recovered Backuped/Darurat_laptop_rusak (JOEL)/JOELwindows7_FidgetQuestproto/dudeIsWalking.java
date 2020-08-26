import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class dudeIsWalking here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class dudeIsWalking extends Stuff_12
{
    private int stepStory = 0;
    private Actor Dialoug = new dialogBalon();
    private boolean clicked = false;
    private boolean flag_addDialog;
    private boolean existed = false;
    private boolean annoyed = false;
    
    public void addedToWorld(World world){
        
    }
    /**
     * Act - do whatever the dudeIsWalking wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            if(!clicked){
                stepStory++;
                clicked = true;
            }
        } else if(!Greenfoot.mouseClicked(null)){
            clicked = false;
        }
        
        switch(stepStory){
            default:
            //setLocation(getX()+2, getY());
            if(!annoyed){
                Greenfoot.playSound("Explosion bin cropped.wav");
                Greenfoot.playSound("bad_explosion.wav");
                Greenfoot.playSound("Explosion bin cropped.wav");
                Greenfoot.playSound("bad_explosion.wav");
                Greenfoot.playSound("Explosion bin cropped.wav");
                Greenfoot.playSound("bad_explosion.wav");
                Greenfoot.playSound("Explosion bin cropped.wav");
                Greenfoot.playSound("bad_explosion.wav");
                Greenfoot.playSound("Explosion bin cropped.wav");
                Greenfoot.playSound("bad_explosion.wav");
                Greenfoot.playSound("Ali-A.wav");
                
                ((Gameplay)getWorld()).addObject(new DuarImage(), getX(), getY());
                ((Gameplay)getWorld()).endTheLevel(false, "STOP BEGGING ME!!!");
                
                getImage().setTransparency(0);
                
                annoyed = true;
            }
            break;
            
            case 0:
            break;
            
            case 1:
            if(!flag_addDialog){
                ((Gameplay)getWorld()).addObject(Dialoug, getX(), getY()-50);
                flag_addDialog = true;
            }
            break;
            
            case 2:
            if(flag_addDialog){
                ((Gameplay)getWorld()).removeObject(Dialoug);
                flag_addDialog = false;
            }
            setLocation(getX()+1, getY());
            break;
            
            case 3:
            setLocation(getX()+2, getY());
            break;
            
            case 4:
            setLocation(getX()+2, getY());
            break;
            
            
        }
        
        if(isAtEdge()){
            ((Gameplay)getWorld()).endTheLevel(true, "Press Next Level!");
            getWorld().removeObject(this);
        }
    }    
}
