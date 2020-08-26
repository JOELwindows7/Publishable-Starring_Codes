import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlacingPlate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlacingPlate extends ControlTypeBox
{
    private String ControlName = "";
    private boolean existed = false;
    private int nonDeltaTimeKey = 0;
    private boolean flag_addPlacingPlate = false;
    private int [] Skalin = new int[]{getImage().getWidth(), getImage().getWidth()};
    private int Scalingsis = 0;
    public PlacingPlate(String ControllerImageName){
        setImage(ControllerImageName);
    }
    public void addedToWorld(World world){
        existed = true;
        nonDeltaTimeKey = 100;
        flag_addPlacingPlate = true;
        Skalin = new int[]{getImage().getWidth(), getImage().getWidth()};
        Scalingsis = 100;
        
        
    }
    /**
     * Act - do whatever the PlacingPlate wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(existed){
            if(nonDeltaTimeKey > 0)nonDeltaTimeKey -= 2;
            
            //getWorld().showText(" time " + nonDeltaTimeKey, 100, 100);
            if(nonDeltaTimeKey <= 00){
                //if(Scalingsis > 21) Scalingsis -= 10;
                //else if(Scalingsis <= 21) Scalingsis = 21;
                //getImage().scale(getImage().getWidth()*Scalingsis/100, getImage().getHeight()*Scalingsis/100);
                if(Skalin[0] > 1) Skalin[0] -= 25;
                else if(Skalin[0] <= 26) Skalin[0] = 26;
                if(Skalin[1] > 1) Skalin[1] -= 25;
                else if(Skalin[1] <= 26) Skalin[1] = 26;
                
                getImage().scale(Skalin[0], Skalin[1]);
            }
            if(flag_addPlacingPlate && (Skalin[0] <= 27 || Skalin[1] <=27)){    
                getWorld().removeObject(this);
            }
        }
    }    
}
