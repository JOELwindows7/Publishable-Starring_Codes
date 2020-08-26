import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level_6 here.
 * 
 * template! write your description here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_6 extends Gameplay
{

    /**
     * Constructor for objects of class Level_6.
     * 
     */
    public Level_6()
    {
        prepare();
    }
    public void setField(){ //to Adjust Level bar and init box
        levelKount = 6;
        levelName = "<Insert Level Name>";
        levelCommand = "<Insert objective>";
        levelControlType = 1;
    }

    public void nextLevel(){ //To go to next level when nextButton is clicked
        //Greenfoot.setWorld(new Level_6());
        Greenfoot.setWorld(new Level_7()); //set the world raise by 1 in N number, 
        //e.g. if you are in Level_6(), then you should go to Level_7().
    }

    public void restartLevel(){ //to retry level when retryButton is clicked
        Greenfoot.setWorld(new Level_6()); //set the world as same as this was
    }
    
    private void prepare()
    {
        //add method that will run once here.
        w1_Please_Place_your w1_please_place_your = new w1_Please_Place_your();
        addObject(w1_please_place_your,125,117);
        w6_otherWorlds_thankYou w6_otherworlds_thankyou = new w6_otherWorlds_thankYou();
        addObject(w6_otherworlds_thankyou,201,124);
        w2_actor_that_are_goingToBe w2_actor_that_are_goingtobe = new w2_actor_that_are_goingToBe();
        addObject(w2_actor_that_are_goingtobe,278,122);
        w4_also_come_from_thisLevel w4_also_come_from_thislevel = new w4_also_come_from_thisLevel();
        addObject(w4_also_come_from_thislevel,352,127);
        w5_toBeUsed_for_here_and w5_tobeused_for_here_and = new w5_toBeUsed_for_here_and();
        addObject(w5_tobeused_for_here_and,426,125);
        w7_seeExample_above_ifConfused w7_seeexample_above_ifconfused = new w7_seeExample_above_ifConfused();
        addObject(w7_seeexample_above_ifconfused,164,194);
        w3_used_for_thisLevel w3_used_for_thislevel = new w3_used_for_thisLevel();
        addObject(w3_used_for_thislevel,262,204);
        Jangkarrr jangkarrr = new Jangkarrr();
        addObject(jangkarrr,378,215);
        PressComplete presscomplete = new PressComplete();
        addObject(presscomplete,209,302);
        PressFail pressfail = new PressFail();
        addObject(pressfail,410,314);
    }
    
    public void act(){
        //add method that will run per act button (forever if run) here.
    }
}
