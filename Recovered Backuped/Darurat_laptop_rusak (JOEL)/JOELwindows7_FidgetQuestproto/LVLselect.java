import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.*;

/**
 * Write a description of class LVLselect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LVLselect extends World
{

    /**
     * Constructor for objects of class LVLselect.
     * 
     */
    
    //Level button coordinates
    protected int [] eXer = {50, 175, 300, 425, 550}; //Position X of collumn
    protected int [] eYer = {90, 175, 265}; //Position Y of Row
    
    //Level button label
    protected int [][] ButtonLabel = new int[][]{{0,2,3,4,5},{6,7,8,9,20},{11,12,13,14,15}};
    //public void setButtonLabel(int [] overLabel, int [] overLibil, int [] overLobol){ 
    //    this.ButtonLabel = new int[][]{{overLabel[0],overLabel[1],overLabel[2],overLabel[3],overLabel[4]},{overLibil[0],overLibil[1],overLibil[2],overLibil[3],overLibil[4]},{overLobol[0],overLobol[1],overLobol[2],overLobol[3],overLobol[4]}};
    //}
    
    public LVLselect()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
        
        /*
        //Emit Label
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
        //end emit
        */
    }
    
    private void prepare(){
        showText("Select Level!", 100, 25);
        
        //Go Back button
        goBack goback = new goBack();
        addObject(goback,28,31);
        
        //
        //
        //Add Row 1
        PressLevelButton presslevelbutton = new PressLevelButton();
        addObject(presslevelbutton,eXer[0],eYer[0]);
        PressLevelButton presslevelbutton2 = new PressLevelButton();
        addObject(presslevelbutton2,eXer[1],eYer[0]);
        PressLevelButton presslevelbutton3 = new PressLevelButton();
        addObject(presslevelbutton3,eXer[2],eYer[0]);
        PressLevelButton presslevelbutton4 = new PressLevelButton();
        addObject(presslevelbutton4,eXer[3],eYer[0]);
        PressLevelButton presslevelbutton5 = new PressLevelButton();
        addObject(presslevelbutton5,eXer[4],eYer[0]);
        //end row 1
        //
        //Add Row 2
        PressLevelButton presslevelbutton6 = new PressLevelButton();
        addObject(presslevelbutton6,eXer[0],eYer[1]);
        PressLevelButton presslevelbutton7 = new PressLevelButton();
        addObject(presslevelbutton7,eXer[1],eYer[1]);
        PressLevelButton presslevelbutton8 = new PressLevelButton();
        addObject(presslevelbutton8,eXer[2],eYer[1]);
        PressLevelButton presslevelbutton9 = new PressLevelButton();
        addObject(presslevelbutton9,eXer[3],eYer[1]);
        PressLevelButton presslevelbutton10 = new PressLevelButton();
        addObject(presslevelbutton10,eXer[4],eYer[1]);
        //end row 2
        //
        //Add Row 3
        PressLevelButton presslevelbutton11 = new PressLevelButton();
        addObject(presslevelbutton11,eXer[0],eYer[2]);
        PressLevelButton presslevelbutton12 = new PressLevelButton();
        addObject(presslevelbutton12,eXer[1],eYer[2]);
        PressLevelButton presslevelbutton13 = new PressLevelButton();
        addObject(presslevelbutton13,eXer[2],eYer[2]);
        PressLevelButton presslevelbutton14 = new PressLevelButton();
        addObject(presslevelbutton14,eXer[3],eYer[2]);
        PressLevelButton presslevelbutton15 = new PressLevelButton();
        addObject(presslevelbutton15,eXer[4],eYer[2]);
        //end row 3
    }
    private void pressGoBack(){
        
    }
    public void act(){
        
    }
}
