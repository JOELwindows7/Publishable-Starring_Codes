import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level_10 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_10 extends Gameplay
{

    /**
     * Constructor for objects of class Level_10.
     * 
     */
    private int inTier = 0;
    private boolean readyLaunch = false;
    private boolean letsLaunch = false;
    private boolean heartAttack = false;
    private boolean heCanDieLegallyNow = false;
    private Actor valueBar;
    private int value = 100;
    private int maxValue = value;
    public Level_10()
    {
        valueBar = new SimpleActor();
        updateValueDisplay();
        addObject(valueBar,getWidth()/2,getHeight()-90);
        prepare();
    }
    
    public void adjustValue(int amount){
        value = amount;
        if(value<0) value = 0;
        if(value>maxValue) value = maxValue;
        updateValueDisplay();
    }
    
    int percentage = 100;
    boolean hitReady = false;
    private void updateValueDisplay(){
        //color bar
        int wide = 300; 
        int high = 12 ;//create full color bar at max value
        GreenfootImage fullImg = new GreenfootImage(wide,high);
        if(percentage > wide*30/maxValue){
            fullImg.setColor(Color.GREEN);
            hitReady = false;
        }
        else {
            fullImg.setColor(Color.RED);
            hitReady = true;
        }
        fullImg.fill();
        //create color bar at value
        GreenfootImage colorBar = new GreenfootImage(wide,high);
        percentage = wide*value/maxValue;
        colorBar.drawImage(fullImg,percentage-wide, 0);
        //create actor image
        GreenfootImage image = new GreenfootImage(wide+4,high+4);
        image.setColor(Color.WHITE);
        image.fill(); //the bg
        image.setColor(Color.BLACK);
        image.drawRect(0,0,wide+3,high+3); //the frame
        image.drawImage(colorBar, 2,2); //the color bar
        valueBar.setImage(image);
    }

    public void setField(){ //to Adjust Level bar and init box
        levelKount = 10;
        levelName = "BoxBomb";
        levelCommand = "Target the Box!";
        levelControlType = 1;
        levelControlType2= 0;
    }

    public void nextLevel(){ //To go to next level when nextButton is clicked
        //Greenfoot.setWorld(new Level_6());
        Greenfoot.setWorld(new Level_11()); //set the world raise by 1 in N number, 
        //e.g. if you are in Level_6(), then you should go to Level_7().
    }

    public void restartLevel(){ //to retry level when retryButton is clicked
        Greenfoot.setWorld(new Level_10()); //set the world as same as this was
    }

    private Actor Spinninger;
    private Sepinner Spinningle;
    private Actor Remoteder;
    private Actor TargetCrash;
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Sepinner sepinner = new Sepinner();
        Spinninger = sepinner;
        Spinningle = sepinner;
        addObject(sepinner,90,228);

        LaunchButton launchbutton = new LaunchButton();
        Remoteder = launchbutton;
        addObject(launchbutton,98,299);

        CrashDummy crashdummy = new CrashDummy();
        TargetCrash = crashdummy;
        addObject(crashdummy,469,228);
    }
    
    public void act(){
        updateValueDisplay();
        if((!letsLaunch && !heartAttack) && !Spinningle.isDedNau()) value--;
        if(value < 0){
            value = 0;
            Spinningle.setTier(0);
        }
        if(inTier >= 3){
            readyLaunch = true;
        } else {
            readyLaunch = false;
        }
        if(Greenfoot.mouseClicked(Remoteder)){
            if(hitReady){
                letsLaunch = true;
            } else {
                readyLaunch = false;
                hitReady = false;
                heartAttack = true;
            }
        }
        if(Greenfoot.mouseClicked(Spinninger)){
            value = 100;
            if(hitReady){
                Spinningle.increaseTier();
                inTier++;
            } else {
                //Spinningle.Fibrilations();
                readyLaunch = false;
                hitReady = false;
                heartAttack = true;
            }
        }
        
        if(heartAttack){
            heCanDieLegallyNow = false;
            Spinningle.Fibrilations();
        }
        if(letsLaunch){
            Spinningle.whenYouWalkingXD(readyLaunch);
        }
        
        if(Spinningle.iGotEm()){
            heCanDieLegallyNow = true;
            //endTheLevel(heCanDieLegallyNow);
        }
        if(Spinningle.isDedNau()){
            endTheLevel(heCanDieLegallyNow);
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

