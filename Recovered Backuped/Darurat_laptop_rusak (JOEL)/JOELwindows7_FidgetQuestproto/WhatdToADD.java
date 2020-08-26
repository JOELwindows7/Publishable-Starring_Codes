import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WhatdToADD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WhatdToADD extends Stuff_5
{
    private String didYouMentionMyName = "name";
    private boolean imReadyToBeMentioned = false;
    /**
     * Act - do whatever the WhatdToADD wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if((Greenfoot.isKeyDown("e") == true && imReadyToBeMentioned == false)){
            //
            
            imReadyToBeMentioned = true;
        }
        if(imReadyToBeMentioned && Greenfoot.mouseClicked(this)){
            //didYouMentionMyName = Greenfoot.ask("Who is the Main Character?");
        }
    }    
}
