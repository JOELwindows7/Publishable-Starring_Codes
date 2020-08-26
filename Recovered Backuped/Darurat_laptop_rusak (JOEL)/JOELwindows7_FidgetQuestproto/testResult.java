import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class testResult here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class testResult extends testAreas
{
    Kounter skore = new Kounter();
    /**
     * Constructor for objects of class testResult.
     * 
     */
    World deref;
    public testResult()
    {
        prepare();
        restartWorld();
        nextWorld();
        
        Kounter sqore = getSkore();
        sqore.setKounter(-2);
        
    }
    
    public void addedToWorld(World world){
        deref = world;
    }
    
    public Kounter getSkore(){
        return skore;
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        showText("Testsssss", 100, 100);
        
        addObject(skore, 100, 40);

        endLevelBar endlevelbar = new endLevelBar(false);
        addObject(endlevelbar,300,376);

        menuButton menubutton = new menuButton();
        addObject(menubutton,440,330);
        retryButton retrybutton = new retryButton();
        addObject(retrybutton,480,330);
        nextButton nextbutton = new nextButton();
        addObject(nextbutton,580,330);

        testWombat testwombat = new testWombat();
        addObject(testwombat,124,192);
        testWombat testwombat2 = new testWombat();
        addObject(testwombat2,129,268);
        launcheT launchet = new launcheT();
        addObject(launchet,317,72);
        
    }
    
    
    
    public void restartWorld(){ //overidden by its children
        //Greenfoot.setWorld(new testResult());
        
        if(Greenfoot.mouseClicked(retryButton.class)){
            Greenfoot.setWorld(new testResult());
        }
    }
    public void nextWorld(){ //also overidden by its children.
        //Greenfoot.setWorld(new testResult2());
    }
}
