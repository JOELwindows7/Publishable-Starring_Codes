import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tombol9 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tombol9 extends Stuff_9
{
    private boolean answerWrong = false;
    public void addedToWorld(World world){
        getWorld().showText("9", getX(), getY());
    }
    /**
     * Act - do whatever the Tombol9 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(isTouching(MoverBeta.class)){
            if(Greenfoot.isKeyDown("x")){
                if(!answerWrong){
                    ((Level_9)getWorld()).wrongAnswer();
                    answerWrong = true;
                }
            } else if(!Greenfoot.isKeyDown("x")){
                answerWrong = false;
            }
        }
    }    
}
