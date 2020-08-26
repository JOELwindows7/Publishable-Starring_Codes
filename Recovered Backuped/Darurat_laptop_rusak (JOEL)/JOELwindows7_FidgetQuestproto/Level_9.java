import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level_9 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_9 extends Gameplay
{
    private int nonDeltaTimeKey = 100;
    public int numOfGuessDown = 5;
    private int lockDown = 5;
    private boolean answerisCorrect;
    private boolean levelEnded = false;
    private boolean levelIsWronged = false;
    /**
     * Constructor for objects of class Level_9.
     * 
     */
    public Level_9()
    {
        prepare();
    }

    public void setField(){ //to Adjust Level bar and init box
        levelKount = 9;
        levelName = "Halio";
        levelCommand = "press correct";
        levelControlType = 4;
        levelControlType2= 2;
    }

    public void nextLevel(){ //To go to next level when nextButton is clicked
        //Greenfoot.setWorld(new Level_6());
        Greenfoot.setWorld(new Level_10()); //set the world raise by 1 in N number, 
        //e.g. if you are in Level_6(), then you should go to Level_7().
    }

    public void restartLevel(){ //to retry level when retryButton is clicked
        Greenfoot.setWorld(new Level_9()); //set the world as same as this was
    }
    
    public void wrongAnswer(){
        boolean sparter = false;
        if(!answerisCorrect) {
            if(!sparter){
                numOfGuessDown--;
                sparter = true;
            }
        }
    }
    public void correctAnswer(){
        if(!levelIsWronged) answerisCorrect = true;
    }
    public boolean getLevelWronged(){
        return levelIsWronged;
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private Tombol8 guess1;
    private Tombol9 guess2;
    private Tombol10 guess3;
    private Actor character;
    private void prepare()
    {
        Tombol8 tombol8 = new Tombol8();
        guess1 = tombol8;
        addObject(tombol8,152,232);

        Tombol9 tombol9 = new Tombol9();
        guess2 = tombol9;
        addObject(tombol9,301,234);

        Tombol10 tombol10 = new Tombol10();
        guess3 = tombol10;
        addObject(tombol10,448,235);

        MoverBeta moverbeta = new MoverBeta();
        character = moverbeta;
        addObject(moverbeta,307,353);
        SignPlateGuessing signplateguessing = new SignPlateGuessing();
        addObject(signplateguessing,107,315);
    }
    
    public int returnNum(){
        return numOfGuessDown;
    }
    
    public void act(){
        //if(numOfGuessDown < 0) numOfGuessDown = 0;
        
        if(numOfGuessDown <= 0){
            //endTheLevel(false);
            if(!levelIsWronged){
                endTheLevel(false, "Masa Kamu gak tahu sih?!?!?!");
                Greenfoot.playSound("bad_explosion.wav");
                levelIsWronged = true;
            }
        }
        
        if(answerisCorrect){
            if(nonDeltaTimeKey > 0) nonDeltaTimeKey--;
            if(nonDeltaTimeKey <= 0){
                if(!levelEnded){
                    nonDeltaTimeKey = 0;
                    endTheLevel(true, "Kok Tahu sih?");
                    levelEnded = true;
                }
            }
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
