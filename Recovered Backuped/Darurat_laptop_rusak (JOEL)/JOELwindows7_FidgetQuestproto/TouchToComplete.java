import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TouchToComplete here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TouchToComplete extends Stuff_2
{
    /**
     * Act - do whatever the TouchToComplete wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        eatButton();
    } 
    public void eatButton(){
        if(isTouching(turtlei.class) || isTouching(dudeBlu.class)){
            ((Gameplay)getWorld()).endTheLevel(true);
            getWorld().removeObject(this);
        }
    }
}
