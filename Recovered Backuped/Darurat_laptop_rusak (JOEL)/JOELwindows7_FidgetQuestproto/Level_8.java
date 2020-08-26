import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level_8 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_8 extends Gameplay
{
    private Actor deButton;
    private Actor valueBar;
    private int value = 3600;
    private int maxValue = value;
    private int tapStatuss = 0;
    private boolean tapHasBeenMax = false;
    /**
     * Constructor for objects of class Level_8.
     * 
     */
    
    public Level_8()
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
    
    private void updateValueDisplay(){
        //color bar
        int wide = 300; 
        int high = 12 ;//create full color bar at max value
        GreenfootImage fullImg = new GreenfootImage(wide,high);
        fullImg.setColor(Color.GREEN);
        fullImg.fill();
        //create color bar at value
        GreenfootImage colorBar = new GreenfootImage(wide,high);
        int percentage = wide*value/maxValue;
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
        levelKount = 8;
        levelName = "Heungh!";
        levelCommand = "Try hard";
        levelControlType = 1;
        levelControlType2= 0;
    }

    public void nextLevel(){ //To go to next level when nextButton is clicked
        //Greenfoot.setWorld(new Level_6());
        Greenfoot.setWorld(new Level_9()); //set the world raise by 1 in N number, 
        //e.g. if you are in Level_6(), then you should go to Level_7().
    }

    public void restartLevel(){ //to retry level when retryButton is clicked
        Greenfoot.setWorld(new Level_8()); //set the world as same as this was
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        tapHasBeenMax = false;
        TapTapQuickly taptapquickly = new TapTapQuickly();
        deButton = taptapquickly;
        addObject(taptapquickly,getWidth()/2,getHeight()/2);
        //adjustValue(100);
    }
    
    public void act(){
        //adjustValue(Greenfoot.getRandomNumber(maxValue));
        if(tapHasBeenMax == false){
            if(tapStatuss > 0 && tapHasBeenMax == false)tapStatuss -= 5;
            if(tapStatuss <= 0) tapStatuss = 0;
            if(tapStatuss >= maxValue) {
                tapStatuss = maxValue;
                tapHasBeenMax = true;
            }
        } else if(tapHasBeenMax){
            tapStatuss = maxValue;
            endTheLevel(true, "Duper Awesome!!!");
        }
        adjustValue(tapStatuss);
        showText(""+tapStatuss, (getWidth()/2)-200, getHeight()-90);
        if(Greenfoot.mouseClicked(deButton)){
            tapStatuss += 100;
        }
    }
}
