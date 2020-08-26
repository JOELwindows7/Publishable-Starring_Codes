import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tombol10 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tombol10 extends Stuff_9
{
    private int nonDeltaTimeKey = 100;
    private boolean answerCorrect;
    private World refferd;
    public void addedToWorld(World world){
        getWorld().showText("10", getX(), getY());
        refferd = world;
    }
    /**
     * Act - do whatever the Tombol10 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(isTouching(MoverBeta.class)){
            if(Greenfoot.isKeyDown("x")){
                if(!answerCorrect && !((Level_9)getWorld()).getLevelWronged()){
                    refferd.addObject(new popHalios(), getWorld().getWidth()/2, getWorld().getHeight()/2);
                    ((Level_9)getWorld()).correctAnswer();
                    answerCorrect = true;
                }
            }
        }    
        
    }
}