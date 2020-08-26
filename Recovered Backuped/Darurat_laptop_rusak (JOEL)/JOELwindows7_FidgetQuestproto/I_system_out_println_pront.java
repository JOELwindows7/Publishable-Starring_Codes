import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.*;
import java.util.*;

/**
 * Write a description of class I_system_out_println_pront here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class I_system_out_println_pront extends Stuff_5
{
    private String pront = "https://perkedel.weebly.com/starbutterfly.html";
    public void addedToWorld(World world){
        setImage(new GreenfootImage("System.out.println(String pront);", 24, Color.GREEN, Color.BLACK));
        System.out.println(pront);
        System.out.println("Thank you so much! I am so proud of you! :D");
    }
    /**
     * Act - do whatever the I_system_out_println_pront wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
