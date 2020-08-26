import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level_5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_5 extends Gameplay
{
    String Kuote= "";
    private int nonDeltaTimeKey = 1000;
    private boolean flag_addKuote = false;
    /**
     * Constructor for objects of class Level_5.
     * 
     */
    public Level_5()
    {
        Kuote += "Not Demo! stay Tuned.";
        Kuote += "\nSorry for Inconveniences";
        Kuote += "\nWe are still working on levels.";
        Kuote += "\nIf you would like to help us, FEEL FREE!";
        Kuote += "\nand THANK YOU for that!";
        Kuote += "\nSimply follow Instruction on README.TXT";
        Kuote += "\nand template at Level_6()";
        //showText(Kuote, getWidth()/2, getHeight()/2);

        prepare();
    }

    public void setField(){
        levelKount = 5;
        levelName = "Demo Version?!";
        levelCommand = "Fullfill!";
        levelControlType = 1;
    }

    public void nextLevel(){
        //Greenfoot.setWorld(new Level_6());
        Greenfoot.setWorld(new Level_6());
    }

    public void restartLevel(){
        Greenfoot.setWorld(new Level_5());
    }

    public void act(){
        if(nonDeltaTimeKey > 0) nonDeltaTimeKey -= 10;
        if(nonDeltaTimeKey <= 0){
            if(flag_addKuote == false){
                showText(Kuote, getWidth()/2, getHeight()/2);
                flag_addKuote = true;
            }
        }
        if(Greenfoot.mouseClicked(null)){
            endTheLevel(true);

        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    int Range0 = 50;
    int Range1 = 100;
    int Range2 = 150;
    private void prepare()
    {
        //Guess this Easter egg. correct answerer gets abstract candy! inherit with your own sweetness methods!
        WhatdToADD whatdtoadd = new WhatdToADD();
        addObject(whatdtoadd,getWidth()/2,getHeight()/2 + 125);

        WhatdToHMSTDVE whatdtohmstdve = new WhatdToHMSTDVE();
        addObject(whatdtohmstdve,getWidth()/2 + Range0,getHeight()/2 + 125);

        WhatdToWHATSTDVE whatdtowhatstdve = new WhatdToWHATSTDVE();
        addObject(whatdtowhatstdve,getWidth()/2 - Range0,getHeight()/2 + 125);

        WhatdToWHOMSTDVE whatdtowhomstdve = new WhatdToWHOMSTDVE();
        addObject(whatdtowhomstdve,getWidth()/2 - Range1,getHeight()/2 + 125);

        VIKING_jamanNOW viking_jamannow = new VIKING_jamanNOW();
        addObject(viking_jamannow,getWidth()/2 + Range1,getHeight()/2 + 125);

        STOP_RACISM_DOT stop_racism_dot = new STOP_RACISM_DOT();
        addObject(stop_racism_dot,getWidth()/2 - Range2,getHeight()/2 + 125);
        //I think I have saw these alienic family. what is it? Joel knows what it is.
        Press_E_to_Activate press_e_to_activate = new Press_E_to_Activate();
        addObject(press_e_to_activate,89,82);
        press_e_to_activate.setLocation(84,78);
    }
}
