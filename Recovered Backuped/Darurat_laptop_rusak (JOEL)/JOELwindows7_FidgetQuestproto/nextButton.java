import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class nextButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class nextButton extends LevelResults
{
    /**
     * Act - do whatever the nextButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            ((Gameplay)getWorld()).nextLevel(); //thx danpost of Greenfoot! Be imortalize, your name for eternity!
            //No one shall forget, those who helped one, resulting big positive impact for humanity.
            //Solution: http://www.greenfoot.org/scenarios/10808, The system of next, reset, and so on.
            //Discussion: https://www.greenfoot.org/topics/60994, I asked how to retry level.
        }
    }    
    
}
