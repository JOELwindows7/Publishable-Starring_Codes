import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level_3 here.
 * 
 * @author JOELwindows7 
 * @version 2018
 */
public class Level_3 extends Gameplay
{

    /**
     * Constructor for objects of class Level_3.
     * 
     */
    public boolean playerHasBeenDead = false;
    
    public Level_3()
    {
        prepare();
    }

    public void setField(){
        levelKount = 3;
        levelName = "Enemies!!!";
        levelCommand = "Go through!";
        levelControlType = 2;
    }

    public void nextLevel(){
        Greenfoot.setWorld(new Level_4());
    }

    public void restartLevel(){
        Greenfoot.setWorld(new Level_3());
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        theNemesis thenemesis = new theNemesis();
        addObject(thenemesis,95,91);
        theNemesis thenemesis2 = new theNemesis();
        addObject(thenemesis2,537,89);
        theNemesis thenemesis3 = new theNemesis();
        addObject(thenemesis3,184,75);
        theNemesis thenemesis4 = new theNemesis();
        addObject(thenemesis4,431,93);
        theNemesis thenemesis5 = new theNemesis();
        addObject(thenemesis5,311,102);
        theNemesis thenemesis6 = new theNemesis();
        addObject(thenemesis6,409,165);
        theNemesis thenemesis7 = new theNemesis();
        addObject(thenemesis7,266,281);
        theNemesis thenemesis8 = new theNemesis();
        addObject(thenemesis8,119,187);
        theNemesis thenemesis9 = new theNemesis();
        addObject(thenemesis9,518,368);
        theNemesis thenemesis10 = new theNemesis();
        addObject(thenemesis10,95,354);
        theNemesis thenemesis11 = new theNemesis();
        addObject(thenemesis11,214,347);
        theNemesis thenemesis12 = new theNemesis();
        addObject(thenemesis12,372,355);
        theNemesis thenemesis13 = new theNemesis();
        addObject(thenemesis13,453,363);
        theNemesis thenemesis14 = new theNemesis();
        addObject(thenemesis14,551,181);
        theNemesis thenemesis15 = new theNemesis();
        addObject(thenemesis15,567,258);
        theNemesis thenemesis16 = new theNemesis();
        addObject(thenemesis16,570,325);
        turtlei turtlei = new turtlei();
        addObject(turtlei,38,276);
        TouchToComplete touchtocomplete = new TouchToComplete();
        addObject(touchtocomplete,478,256);
    }
    public boolean playerIsDead(){
        if(playerHasBeenDead){
            return true;
        } else return false;
        //return playerHasBeenDead;
    }
    public void act(){
        if(getObjects(turtlei.class).isEmpty() != true){
            playerHasBeenDead = true;
        } else playerHasBeenDead = false;
    }
}
