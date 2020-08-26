import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WiruWiru here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WiruWiru extends Stuff_7
{
    /**
     * Act - do whatever the WiruWiru wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        setLocation(getX()+10, getY()+1);
        if(isAtEdge()){
            setLocation(0, getY()-50);
        }
        if(getY()>getWorld().getHeight()/2){
            setLocation(getX(), 20);
        }
        if(isTouching(bulet.class)){
            removeTouching(bulet.class);//ate bulet
            Greenfoot.playSound("Explode_8bit.wav");
            ((Gameplay)getWorld()).addObject(new BoomImage(), getX(), getY());
            ((Gameplay)getWorld()).removeObject(this);
        }
    }    
}
