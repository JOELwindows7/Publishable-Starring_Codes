import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class wepon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class wepon extends Stuff_7
{
    private boolean attachedObject;
    private Actor Attache;
    private MouseInfo mouse = Greenfoot.getMouseInfo();
    private int mx = 0, my = 0;
    /**
     * Act - do whatever the wepon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        //setLocation(_x_, _y_)
        
        if(Greenfoot.mouseMoved(null)){  
            mouse = Greenfoot.getMouseInfo();
            mx = mouse.getX();
            my = mouse.getY();  
           
        }
        turnTowards(mx,my);
        
        //https://www.greenfoot.org/topics/55936/0 (bullet)
        bulet bullet = new bulet(); // creates the bullet object
        bullet.setRotation(getRotation()); // sets the direction of the bullet
        //getWorld().addObject(bullet, getX(), getY()); // adds the bullet into the world
        //bullet.move(20); // initial adjustment of bullet location
        
        //https://www.greenfoot.org/topics/3071/0#post_19516 (Trigger button, danpost)
        if(Greenfoot.mousePressed(null)){
            Greenfoot.playSound("8bit_laser.wav");
            getWorld().addObject(bullet, getX(), getY()); // adds the bullet into the world
        }
    }    
}
