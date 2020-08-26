import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class levelInitBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class levelInitBox extends LevelInits
{
    /**
     * Constructors
     */
    private int currNum; //num level
    private String currName; //title
    private String currCommand; //command
    private int currControl = 0; //control type
    private int currControl2 = 0;
    private Actor scoreText; // actor to display score
    private Actor levelText; // actor to display level
    private Actor levelInte; // actor to display number of level
    private Actor levelComm; // actor to display command objective
    private boolean existed = false;
    private int Transparant = 255;
    private boolean flag_addGameBar = false;
    private boolean flag_addInitBox = false;
    private boolean flag_addControlBox = false;
    private int nonDeltaTimeKey = 0;
    public levelInitBox(int NumberNow, String NameNow, String CommandNow, int ControlNow){
        currNum = NumberNow;
        currName = NameNow;
        currCommand = CommandNow;
        currControl = ControlNow;
        currControl2= 0;
        prepare();
    }
    public levelInitBox(int NumberNow, String NameNow, String CommandNow, int ControlNow, int ControlNow2){
        currNum = NumberNow;
        currName = NameNow;
        currCommand = CommandNow;
        currControl = ControlNow;
        currControl2= ControlNow2;
        prepare();
    }
    private void prepare(){
        //getWorld().addObject(_object_, _x_, _y_);
    }
    public void addedToWorld(World world){
        //getWorld().addObject(_object_, _x_, _y_);
        //world.showText("" + currNum, getX() + 20, getY() + 20);
        //world.showText("" + currName, getX() + 25, getY() + 20);
        //setStarted = true;
        existed = true;
        nonDeltaTimeKey = 100;
        Transparant = 255;
        scoreText = getNewStillActor();
        levelText = new barName(currName, 48);
        levelInte = new barNumber(currNum, 48);
        //levelComm = new LevelCommandBox(currCommand, 48);
        
        world.addObject(levelInte, getX()-270, getY());
        world.addObject(levelText, getX(), getY());
    }
    /**
     * Act - do whatever the levelInitBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(existed){
            if(flag_addControlBox == false){
                if(currControl2 == 0){
                    ((Gameplay)getWorld()).addObject(new BasePlate(currControl), getWorld().getWidth()/2, getWorld().getHeight()/2);
                } else {
                    ((Gameplay)getWorld()).addObject(new BasePlate(currControl), (getWorld().getWidth()/2)-150, getWorld().getHeight()/2);
                    ((Gameplay)getWorld()).addObject(new BasePlate(currControl2), (getWorld().getWidth()/2)+150, getWorld().getHeight()/2);
                }
                
                flag_addControlBox = true;
            }
            
            if(nonDeltaTimeKey > 0)nonDeltaTimeKey -= 2;
            
            //getWorld().showText(" time " + nonDeltaTimeKey, 100, 100);
            if(nonDeltaTimeKey <= 00){
                nonDeltaTimeKey = 0;
                Transparant -= 5;
                if(Transparant < 0) Transparant = 0;
                getImage().setTransparency(Transparant);
                levelText.getImage().setTransparency(Transparant);
                levelInte.getImage().setTransparency(Transparant);
                if(flag_addGameBar == false){
                    if(flag_addInitBox == false){
                        ((Gameplay)getWorld()).addObject(new LevelCommandBox(currCommand), getWorld().getWidth()/2, getWorld().getHeight()/2);
                        flag_addInitBox = true;
                    }
                    //removeObject(getObjects(levelInitBox.class));
                    if(Transparant <= 0){
                        
                        ((Gameplay)getWorld()).gamePlayBar(currNum, currName);
                        flag_addGameBar = true;
                    }
                }
            }
            if(flag_addGameBar && Transparant <= 0){    
                getWorld().removeObject(this);
            }
        }
    }    
}
