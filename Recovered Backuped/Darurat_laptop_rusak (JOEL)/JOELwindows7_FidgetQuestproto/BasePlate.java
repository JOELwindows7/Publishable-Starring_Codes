import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BasePlate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BasePlate extends ControlTypeBox
{
    private String ControlName = "";
    private int KontrolNum = 0;
    private boolean existed = false;
    private int nonDeltaTimeKey = 0;
    private boolean flag_addPlacingPlate = false;
    private int [] Skalin = new int[]{getImage().getWidth(), getImage().getWidth()};
    private int Scalingsis = 0;
    public BasePlate(String filenamess){
        ControlName = filenamess;
        existed = true;
        nonDeltaTimeKey = 100;
        
        Skalin = new int[]{getImage().getWidth(), getImage().getWidth()};
        Scalingsis = 100;
    }
    public BasePlate(int KontrolType){
        KontrolNum = KontrolType;
        existed = true;
        nonDeltaTimeKey = 100;
        
        Skalin = new int[]{getImage().getWidth(), getImage().getWidth()};
        Scalingsis = 100;
    }
    //Actor plating = new PlacingPlate(ControlName);
    public void addedToWorld(World world){
        if(KontrolNum == 0){
            ControlName = "NoneControl.png";
        } else if(KontrolNum == 1){
            ControlName = "MouseControl.png";
        } else if(KontrolNum == 2){
            ControlName = "ArrowKeyControl.png";
        } else if(KontrolNum == 3){
            ControlName = "WASDcontrol.png";
        } else if(KontrolNum == 4){
            ControlName = "ZXcontrol.png";
        } else if(KontrolNum == 5){
            ControlName = "MicControl.png";
        }
        else {
            ControlName = "ErrorControl.png";
        }
        if(flag_addPlacingPlate == false){
            ((Gameplay)getWorld()).addObject(new PlacingPlate(ControlName), getX(), getY());
            flag_addPlacingPlate = true;
        }
    }
    /**
     * Act - do whatever the BasePlate wants to do. This method is called whenever
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
