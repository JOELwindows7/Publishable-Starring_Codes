import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MoverBeta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MoverBeta extends Stuff_9
{
    private boolean pressing = false;
    private boolean sparsifier = false;
    private boolean onheld = false;
    public boolean iPressed(){
        return pressing;
    }
    /**
     * Act - do whatever the MoverBeta wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("up")){
            setRotation(270);
            move(5);
        } else if(Greenfoot.isKeyDown("left")){
            setRotation(180);
            move(5);
        } else if(Greenfoot.isKeyDown("right")){
            setRotation(0);
            move(5);
        } else if(Greenfoot.isKeyDown("down")){
            setRotation(90);
            move(5);
        } else
        if(Greenfoot.isKeyDown("up") && Greenfoot.isKeyDown("right")){
            setRotation(270+45);
            move(5);
        } else if(Greenfoot.isKeyDown("up") && Greenfoot.isKeyDown("left")){
            setRotation(270-45);
            move(5);
        } else if(Greenfoot.isKeyDown("down") && Greenfoot.isKeyDown("right")){
            setRotation(90-45);
            move(5);
        } else if (Greenfoot.isKeyDown("down") && Greenfoot.isKeyDown("left")){
            setRotation(90+45);
            move(5);
        }
        
        if(Greenfoot.isKeyDown("x")){
            pressing = true;
            if(!onheld){
                Greenfoot.playSound("mouse_click.wav");
                sparsifier = true;
                onheld = true;
            } else {
                sparsifier = false;
            }
            
        } else {
            pressing = false;
            onheld = false;
        }
        if(isTouching(Tombol10.class)){ //correct answer is 10
            if(sparsifier){
                
            }
        }
    }    
}
