import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.*;
import java.util.*;

/**
 * Write a description of class Press_E_to_Activate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Press_E_to_Activate extends Stuff_5
{
    GreenfootImage imageReffer = new GreenfootImage("EggssLever.png");
    private String Question;
    private String yourAnswer;
    private boolean existed = false; 
    private boolean keyPressed = false;
    private boolean flag_addCorrectButton = false;
    public Press_E_to_Activate(){
        Question = "Who is the main character? (Case sensitive!)\n";
        Question += ", redButton\n";
        Question += ", club\n";
        Question += ", spade\n";
        Question += ", heart\n";
        Question += ", diamond\n";
        Question += ", or blueButton?\n";
    }
    public void addedToWorld(){
        existed = true;
        
        Question = "Who is the main character? (Case sensitive!)\n";
        Question += "-redButton\n";
        Question += "-club\n";
        Question += "-spade\n";
        Question += "-heart\n";
        Question += "-diamond\n";
        Question += "-blueButton\n";
    }
    /**
     * Act - do whatever the Press_E_to_Activate wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
        if((Greenfoot.isKeyDown("e") == true && keyPressed == false)){
            //
            setImage(new GreenfootImage(imageReffer));
            getImage().setTransparency(255);
            Greenfoot.playSound("MemeMan said E low quality.wav");
            keyPressed = true;
        }
        if(keyPressed == false){
            getImage().setTransparency(0);
        } else if(keyPressed){
            getImage().setTransparency(255);
            if(Greenfoot.mouseClicked(this)){
                yourAnswer = Greenfoot.ask(Question);
            }
        }
        if("heart".equals(yourAnswer) && flag_addCorrectButton == false){
            ((Gameplay)getWorld()).addObject(new YourAnswerIsCorrect(), 550, 100);
            //getWorld().showText("Correct", getX(), getY()+50);
            flag_addCorrectButton = true;
        }
        //etWorld().showText(yourAnswer, getX(), getY());
        //https://www.greenfoot.org/topics/490
        //thx
    }    
}
