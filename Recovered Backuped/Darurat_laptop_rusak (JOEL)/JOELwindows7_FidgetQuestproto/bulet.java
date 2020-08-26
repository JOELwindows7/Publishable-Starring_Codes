import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bulet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bulet extends Stuff_7
{
    private boolean existed = false;
    private boolean hitted = false;
    
    public bulet(){
        existed = true;
        //Greenfoot.playSound("8bit_laser.wav");
    }
    /**
     * Act - do whatever the bulet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        move(5);
        if(isAtEdge()){
            Greenfoot.playSound("Explode_8bit.wav");
            ((Gameplay)getWorld()).addObject(new DuarImage(), getX(), getY());
            ((Gameplay)getWorld()).removeObject(this);
        }
        /*
        if(existed){
            if(isTouching(WiruWiru.class)){
                existed = false;
                //removeTouching(WiruWiru.class);
                if(hitted == false){
                    ((Gameplay)getWorld()).addObject(new DuarImage(), getX(), getY());
                    hitted = true;
                    getWorld().removeObject(this);
                }
                //existed= false;
            }
        }
        */
        
    }    
}
