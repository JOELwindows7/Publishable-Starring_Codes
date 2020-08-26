import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelCommandBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelCommandBox extends LevelInits
{
    
    private boolean existed = false;
    private String Commandss = "";
    private int landSizess=0;
    private int Sizess= 28;
    private int defSizess = 28;
    private int nonDeltaTimeKey = 100;
    private boolean landed = false;
    private int Transparant=255;
    GreenfootImage imagess;
    
    public LevelCommandBox(String receives){
        GreenfootImage reffImages = getImage();
        Commandss = receives;
        Sizess = defSizess+100;
        landSizess = defSizess;
        //imagess = new GreenfootImage(Commandss, Sizess, Color.WHITE, Color.BLACK);
        setImage(new GreenfootImage(""+Commandss, Sizess, Color.WHITE, Color.BLACK));
    }
    public LevelCommandBox(String receives, int sized){
        GreenfootImage reffImages = getImage();
        Commandss = receives;
        Sizess = sized+100;
        landSizess = sized;
        //imagess = new GreenfootImage(Commandss, Sizess, Color.WHITE, Color.BLACK);
        setImage(new GreenfootImage(""+Commandss, Sizess, Color.WHITE, Color.BLACK));
    }
    public void addedToWorld(World world){
        existed = true;
        //Greenfoot.setImage(new GreenfootImage(Commandss, Sizess, Color.WHITE, Color.BLACK));
        //setImage(image);
    }
    /**
     * Act - do whatever the LevelCommandBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(existed){
            //getImage().setImage(new GreenfootImage(Commandss, Sizess, Color.WHITE, Color.BLACK));
            
            //getImage().scale(_width_, _height_)
            if(Sizess > landSizess){
                Sizess -= 20;
                landed = false;
                
                //imagess = new GreenfootImage(Commandss, Sizess, Color.WHITE, Color.BLACK);
                setImage(new GreenfootImage(""+Commandss, Sizess, Color.WHITE, Color.BLACK));
                //setImage(imagess);
                
            } else if (Sizess <= landSizess){
                landed = true;
            }
            if(landed){
                nonDeltaTimeKey -= 5;
                if(nonDeltaTimeKey <= 0){
                    Transparant -= 20;
                    if (Transparant <0) Transparant = 0;
                    getImage().setTransparency(Transparant);
                    nonDeltaTimeKey = 0;
                }
            }
        }
        if(Transparant <= 0){
            Transparant = 0;
            
            if(existed) {
                existed = false;
                getWorld().removeObject(this);
            }
        }
    }    
}
