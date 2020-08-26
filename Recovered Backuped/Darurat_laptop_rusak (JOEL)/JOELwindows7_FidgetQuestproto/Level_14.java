import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.*;

/**
 * Write a description of class Level_14 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_14 extends Gameplay
{
    String Kuote= "";
    private int nonDeltaTimeKey = 1000;
    private boolean flag_addKuote = false;
    
    private GreenfootSound songSelect = new GreenfootSound("bad_explosion.wav");
    private int SongStatus = 0;
    private boolean sparser = false;
    /**
     * Constructor for objects of class Level_14.
     * 
     */
    public Level_14()
    {
        Kuote += "This is final level.";
        Kuote += "\nBut Only on this page";
        Kuote += "\nDue to an exhaustion of idea,";
        Kuote += "\nUnfortunately we have to end it here for now, sorry.";
        Kuote += "\nAlso, just to make this ready to play";
        Kuote += "\natleast for now...";
        Kuote += "\nWe shouldn't have done this here";
        Kuote += "\nWe should've done this there instead!";
    }
    
    public void setField(){
        levelKount = 14;
        levelName = "Final Level?!";
        levelCommand = "Reading!";
        levelControlType = 1;
    }

    public void nextLevel(){
        //Greenfoot.setWorld(new Level_6());
        Greenfoot.setWorld(new AboutScreen());
    }

    public void restartLevel(){
        Greenfoot.setWorld(new Level_14());
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
            endTheLevel(true, "Congratulations!");
            songSelect.stop();
        }
        
        if(SongStatus == 0){
            if(Greenfoot.isKeyDown("1")){
                songSelect = new GreenfootSound("Songs/TheFatRat+-+Oblivion+feat.+Lola+Blanc.mp3");
            } else if(Greenfoot.isKeyDown("2")){
                songSelect = new GreenfootSound("Songs/Beat_Your_Competition.mp3");
            } else if(Greenfoot.isKeyDown("`")){
                System.out.println("Man who expect fortune, will suffer. And man who expect friendship, will happy eternally");
            }
        }
        
        if(Greenfoot.isKeyDown("space")){
            if(!sparser){
                if(SongStatus == 0){
                    songSelect.play();
                    SongStatus = 1;
                } else if(SongStatus == 1){
                    songSelect.pause();
                    SongStatus = 2;
                } else if(SongStatus == 2){
                    songSelect.play();
                    SongStatus = 1;
                }
                sparser = true;
            }
        } else {
            sparser = false;
        }
        if(Greenfoot.isKeyDown(".")){
            SongStatus = 0;
            songSelect.stop();
        }
    }
}
