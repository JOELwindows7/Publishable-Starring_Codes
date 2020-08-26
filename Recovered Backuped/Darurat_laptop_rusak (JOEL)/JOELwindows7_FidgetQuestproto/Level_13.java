import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level_13 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_13 extends Gameplay
{
    private int nonDeltaTimeKey = 2000;
    private int nonDeltaTimeKoy = 100;
    private int notCrabFlib = 0;
    private Surto surtod;
    //Detroit: Become Human (c) Sony, quantic dream [100%]
    //Batman: The Dark Knight (c) DC Comic, Warner Bros [100%] <-(? right?) coin flip always lucky turns into basic by a terrible explodion
    private Actor valueBar;
    private int value = nonDeltaTimeKey;
    private int maxValue = value;
    private boolean flag_setup[] = new boolean[]{false, false, false};
    /**
     * Constructor for objects of class Level_13.
     * 
     */
    public Level_13()
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
        if(percentage > wide*100/maxValue){
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
        levelKount = 13;
        levelName = "(UN)LUCK";
        levelCommand = "dat number dude!";
        levelControlType = 0;
        levelControlType2= 0;
    }

    public void nextLevel(){ //To go to next level when nextButton is clicked
        //Greenfoot.setWorld(new Level_6());
        Greenfoot.setWorld(new Level_14()); //set the world raise by 1 in N number, 
        //e.g. if you are in Level_6(), then you should go to Level_7().
    }

    public void restartLevel(){ //to retry level when retryButton is clicked
        Greenfoot.setWorld(new Level_13()); //set the world as same as this was
    }

    public void act(){
        updateValueDisplay();
        adjustValue(nonDeltaTimeKey);
        surtod.setImage(new GreenfootImage("Percent Flippo:\n" + notCrabFlib, 48, Color.WHITE, Color.BLUE));
        if(nonDeltaTimeKey > 0){
            notCrabFlib = Greenfoot.getRandomNumber(100);
            nonDeltaTimeKey -= 2;
        } else {
            if(!flag_setup[0]){
                Greenfoot.playSound("gong.wav");
                flag_setup[0] = true;
            }
            if(nonDeltaTimeKoy > 0){
                nonDeltaTimeKoy -= 1;
            } else {
                if(notCrabFlib > 50){
                    endTheLevel(true, "Luckiness is approaching");
                    if(!flag_setup[1]){
                        Greenfoot.playSound("dingDong.wav");
                        flag_setup[1] = true;
                    }
                } else {
                    endTheLevel(false, "UnLuckiness is approaching");
                    if(!flag_setup[1]){
                        Greenfoot.playSound("sadTrombone.wav");
                        flag_setup[1] = true;
                    }
                }
            }
        }

    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Surto surto = new Surto();
        surtod = surto;
        addObject(surto,302,212);
    }
}
