import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class YourAnswerIsCorrect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YourAnswerIsCorrect extends Stuff_5
{
    private boolean flag_addPrinterActor;
    /**
     * Act - do whatever the YourAnswerIsCorrect wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this) && flag_addPrinterActor == false){
            ((Gameplay)getWorld()).addObject(new I_system_out_println_pront(), getWorld().getWidth()/2, 30);
            flag_addPrinterActor = true;
        }
    }    
}
