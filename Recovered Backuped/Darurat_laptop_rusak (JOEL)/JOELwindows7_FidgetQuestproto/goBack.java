import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class goBack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class goBack extends Selects
{
    /**
     * Act - do whatever the goBack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        letsGoBack();
    }    
    private void actMe(){
        
    }
    private void letsGoBack(){
        if(Greenfoot.mouseClicked(this)){
            //actMe();
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
