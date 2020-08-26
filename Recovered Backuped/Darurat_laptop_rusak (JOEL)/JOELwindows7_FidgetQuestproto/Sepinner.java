import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sepinner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sepinner extends Stuff_10
{
    private int nonDeltaTimeKey = 100;
    private boolean destructed = false;
    private boolean fatalError = false;
    private boolean kickedAPontecs = false;
    private int spinTier = 0;
    private int angling = 0;
    private int fib = 0;
    /**
     * Act - do whatever the Sepinner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private void selfDestruct(){
        if(destructed == false) {
            ((Gameplay)getWorld()).addObject(new Smokoh(), getX(), getY());
            ((Gameplay)getWorld()).addObject(new DuarImage(), getX(), getY());
            Greenfoot.playSound("bad_explosion.wav");
            getImage().setTransparency(0);
            destructed = true;
        }
        
    }
    
    public boolean isDedNau(){
        return destructed;
    
    }
    public boolean iGotEm(){
        return kickedAPontecs;
    }
    
    public void increaseTier(){
        spinTier++;
    }
    public void setTier(int what){
        spinTier = what;
    }
    private void spinning(int speed){
        if(!fatalError) angling += speed;
        if(angling >= 360) angling = 0;
        if(angling < 0) angling = 0;
        if(!fatalError) setRotation(angling);
    }
    public void whenYouWalkingXD(boolean ideal){
        if(ideal){
            setLocation(getX() + 4, getY());
        } else {
            setLocation(getX() + 4, getY()+(4-spinTier));
        }
    }
    
    //https://www.greenfoot.org/topics/3019 <- thx guys
    private GreenfootSound SoundReffer;
    private void funnySound(int select){
        //String SoundName = "MemeMan said E low quality.wav";
        switch(select){
            default:
            break;
            
            case 0:
            SoundReffer = new GreenfootSound("FitnessGram_Cut.wav");
            break;
            
            case 1:
            SoundReffer = new GreenfootSound("oof_robloc.wav");
            break;
        }
        //return SoundName;
    }
    private boolean randInstantiated = false;
    public void Fibrilations(){
        int selector;
        if(!randInstantiated){
            selector = Greenfoot.getRandomNumber(2);
            funnySound(selector);
            randInstantiated = true;
        }
        
        fatalError = true;
        if(nonDeltaTimeKey > 0){
            if(fib == 0){
                setRotation(45);
                fib = 1;
            } else
            if(fib == 1){
                setRotation(60);
                fib = 0;
            }
            SoundReffer.playLoop();
            nonDeltaTimeKey -= 1;
        } else {
            SoundReffer.stop();
            selfDestruct();
        }
    }
    public void act() 
    {
        // Add your action code here.
        //spinning(90);
        //whenYouWalkingXD(false);
        //selfDestruct();
        //Fibrilations();
        switch(spinTier){
            case 0:
            break;
            
            case 1:
            spinning(20);
            break;
            
            case 2:
            spinning(40);
            break;
            
            case 3:
            spinning(80);
            break;
            
            case 4:
            spinning(160);
            break;
            
            default:
            selfDestruct();
            break;
        }
        if(isTouching(CrashDummy.class)){
            removeTouching(CrashDummy.class);
            kickedAPontecs = true;
            Greenfoot.playSound("wood_destroy.wav");
            selfDestruct();
        }
        if(isAtEdge()){
            selfDestruct();
        }
    }    
}
