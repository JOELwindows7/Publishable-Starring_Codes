import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.*;
import java.util.*;

/**
 * Write a description of class Page1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Page1 extends LVLselect
{
    int Inkrement = 1;
    /**
     * Constructor for objects of class Page1.
     * 
     */
    public Page1()
    {
        prepare();
        //Emit Label
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 5; j++){
                showText("" + ButtonLabel[i][j], eXer[j], eYer[i]);
            }
        }
        /*
        //1
        showText("" + ButtonLabel[0][0], eXer[0], eYer[0]);
        showText("" + ButtonLabel[0][1], eXer[1], eYer[0]);
        showText("" + ButtonLabel[0][2], eXer[2], eYer[0]);
        showText("" + ButtonLabel[0][3], eXer[3], eYer[0]);
        showText("" + ButtonLabel[0][4], eXer[4], eYer[0]);
        //2
        showText("" + ButtonLabel[1][0], eXer[0], eYer[1]);
        showText("" + ButtonLabel[1][1], eXer[1], eYer[1]);
        showText("" + ButtonLabel[1][2], eXer[2], eYer[1]);
        showText("" + ButtonLabel[1][3], eXer[3], eYer[1]);
        showText("" + ButtonLabel[1][4], eXer[4], eYer[1]);
        //3
        showText("" + ButtonLabel[2][0], eXer[0], eYer[2]);
        showText("" + ButtonLabel[2][1], eXer[1], eYer[2]);
        showText("" + ButtonLabel[2][2], eXer[2], eYer[2]);
        showText("" + ButtonLabel[2][3], eXer[3], eYer[2]);
        showText("" + ButtonLabel[2][4], eXer[4], eYer[2]);
        */
        //end emit
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        //ButtonLabel = new int[][]{{1,2,3,4,5},{6,7,8,9,20},{11,12,13,14,16}};
        //ButtonLabel[0][0] = 122;
        //setButtonLabel(new int[]{1,2,3,4,5}, new int[]{6,7,8,9,20}, new int[]{11,12,13,14,16});
        //ButtonLabel = new int[][]{{1,2,3,4,5},{6,7,8,9,20},{11,12,13,14,15}};
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 5; j++){
                ButtonLabel[i][j] = Inkrement;
                Inkrement++;
            }
        }
    }
    
    public void act(){
        List objectslookingfor = getObjects(PressLevelButton.class);
        if(Greenfoot.mouseClicked(objectslookingfor.get(0))){
            //showText("Mein", 100, 100);
            Greenfoot.setWorld(new Level_0());
        } else if(Greenfoot.mouseClicked(objectslookingfor.get(1))){
            Greenfoot.setWorld(new Level_1());
        } else if(Greenfoot.mouseClicked(objectslookingfor.get(2))){
            Greenfoot.setWorld(new Level_2());
        } else if(Greenfoot.mouseClicked(objectslookingfor.get(3))){
            Greenfoot.setWorld(new Level_3());
        } else if(Greenfoot.mouseClicked(objectslookingfor.get(4))){
            Greenfoot.setWorld(new Level_4());
        } else if(Greenfoot.mouseClicked(objectslookingfor.get(5))){
            Greenfoot.setWorld(new Level_5());
        } else if(Greenfoot.mouseClicked(objectslookingfor.get(6))){
            Greenfoot.setWorld(new Level_6());
        } else if(Greenfoot.mouseClicked(objectslookingfor.get(7))){
            Greenfoot.setWorld(new Level_7());
        } else if(Greenfoot.mouseClicked(objectslookingfor.get(8))){
            Greenfoot.setWorld(new Level_8());
        } else if(Greenfoot.mouseClicked(objectslookingfor.get(9))){
            Greenfoot.setWorld(new Level_9());
        } else if(Greenfoot.mouseClicked(objectslookingfor.get(10))){
            Greenfoot.setWorld(new Level_10());
        } else if(Greenfoot.mouseClicked(objectslookingfor.get(11))){
            Greenfoot.setWorld(new Level_11());
        } else if(Greenfoot.mouseClicked(objectslookingfor.get(12))){
            Greenfoot.setWorld(new Level_12());
        } else if(Greenfoot.mouseClicked(objectslookingfor.get(13))){
            Greenfoot.setWorld(new Level_13());
        } else if(Greenfoot.mouseClicked(objectslookingfor.get(14))){
            Greenfoot.setWorld(new Level_14());
        }
    }
}
