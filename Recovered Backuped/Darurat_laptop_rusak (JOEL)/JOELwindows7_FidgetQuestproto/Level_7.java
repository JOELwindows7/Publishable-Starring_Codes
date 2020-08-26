import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level_7 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_7 extends Gameplay
{
    private Actor guyHold;
    private Actor anItem;
    private Actor terbangTerbang;
    private boolean targetsEliminated = false;
    /**
     * Constructor for objects of class Level_7.
     * 
     */
    public Level_7()
    {
        prepare();
    }

    public void setField(){ //to Adjust Level bar and init box
        levelKount = 7;
        levelName = "2D Uncomfortable";
        levelCommand = "Conquer";
        levelControlType = 3;
        levelControlType2= 1;
    }

    public void nextLevel(){ //To go to next level when nextButton is clicked
        //Greenfoot.setWorld(new Level_6());
        Greenfoot.setWorld(new Level_8()); //set the world raise by 1 in N number, 
        //e.g. if you are in Level_6(), then you should go to Level_7().
    }

    public void restartLevel(){ //to retry level when retryButton is clicked
        Greenfoot.setWorld(new Level_7()); //set the world as same as this was
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        dudeBlu dudeblu = new dudeBlu();
        guyHold = dudeblu;
        addObject(dudeblu,74,367);

        wepon Wepon = new wepon();
        anItem = Wepon;
        addObject(Wepon,dudeblu.getX()-20,dudeblu.getY());

        WiruWiru wiruwiru = new WiruWiru();
        terbangTerbang = wiruwiru;
        addObject(wiruwiru,75,112);
        bulet bulet = new bulet();
        addObject(bulet,80,233);
        WiruWiru wiruwiru2 = new WiruWiru();
        addObject(wiruwiru2,272,214);
        WiruWiru wiruwiru3 = new WiruWiru();
        addObject(wiruwiru3,479,132);
        WiruWiru wiruwiru4 = new WiruWiru();
        addObject(wiruwiru4,239,93);
        WiruWiru wiruwiru5 = new WiruWiru();
        addObject(wiruwiru5,483,232);
        WiruWiru wiruwiru6 = new WiruWiru();
        addObject(wiruwiru6,383,163);
        WiruWiru wiruwiru7 = new WiruWiru();
        addObject(wiruwiru7,54,203);
        WiruWiru wiruwiru8 = new WiruWiru();
        addObject(wiruwiru8,345,321);
        WiruWiru wiruwiru9 = new WiruWiru();
        addObject(wiruwiru9,396,82);
        WiruWiru wiruwiru10 = new WiruWiru();
        addObject(wiruwiru10,136,43);
        WiruWiru wiruwiru11 = new WiruWiru();
        addObject(wiruwiru11,544,59);
        WiruWiru wiruwiru12 = new WiruWiru();
        addObject(wiruwiru12,173,316);
        WiruWiru wiruwiru13 = new WiruWiru();
        addObject(wiruwiru13,528,351);
        WiruWiru wiruwiru14 = new WiruWiru();
        addObject(wiruwiru14,177,166);
    }
    
    /**
     * Act - do whatever the dudeBlu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        anItem.setLocation(guyHold.getX()-20, guyHold.getY());
        //https://www.greenfoot.org/topics/5236 (mouse location)
        if(guyHold.getY() < (getHeight() - 30)){
            guyHold.setLocation(guyHold.getX(),guyHold.getY()+5);
        }
        //http://www.greenfoot.org/scenarios/10808 (downward pull)
        
        /*
        if(getObjects(WiruWiru.class) != null && terbangTerbang.getY() > getHeight()/2){
            terbangTerbang.setLocation(terbangTerbang.getX(), 10);
        }
        */
        
        if(getObjects(WiruWiru.class).isEmpty()){
            targetsEliminated = true;
        } else targetsEliminated = false;
        
        if(targetsEliminated){
            OperationCompleted();
        }
    }
    private boolean flag_addTouchLevelComplete = false;
    private void OperationCompleted(){
        if(!flag_addTouchLevelComplete){
            addObject(new TouchToComplete(), getWidth()-40, getHeight()-40);
            flag_addTouchLevelComplete = true;
        }
    }
}
//
//
//
//
//
//
//
//
//
//
