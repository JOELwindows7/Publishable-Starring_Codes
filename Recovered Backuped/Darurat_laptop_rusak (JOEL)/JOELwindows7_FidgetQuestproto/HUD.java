import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class HUD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HUD extends Actor
{
    private World deference;
    /**
     * Act - do whatever the HUD wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int angka;
    private static int skore; //danpost of Greenfoot, modified for this area; Score number
    protected static int levelKount; //Level Number
    protected static String levelName; //Level Title
    protected static String levelCommand = "<Unknown>"; //Level what mission to do
    private static Actor scoreText; // actor to display score
    private static Actor levelText; // actor to display level
    private void spitTheText(String teks, int xKord, int yKord){
        getWorld().showText(teks, xKord, yKord);
    }
    
    public void act() 
    {
        // Add your action code here.
        getWorld().showText("ddddddd" , 300, 375);
    }    
    public void levelIntros(){
        
    }
    public void levelIsCompleted(){
        
    }
    public void levelisFailed(){
        
    }
    public void levelIsAidingSomeTests(int number){
        angka = number;
        System.out.println(angka);
        //spitTheText("Angka: ", 300, 100);
        //getWorld().showText("This is the Test Aiding Toolship." + angka , 300, 375);
    }
    
    private static void setLevelText()
    {
        levelText.setImage(new GreenfootImage(""+levelKount+"   "+levelName, 24, Color.BLACK, new Color(0, 0, 0, 0)));
    }
    
    public static Actor getNewStillActor()
    {
        return new Actor()
        {
            public void setLocation(int x, int y){}
        };
    }
}
