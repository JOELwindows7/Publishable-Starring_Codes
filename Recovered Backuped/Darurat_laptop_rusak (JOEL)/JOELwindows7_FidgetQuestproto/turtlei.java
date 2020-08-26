import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class turtlei here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class turtlei extends Stuff_2
{
    private Boolean sudahAmanPak= false;
    private boolean destroyed = false;
    /**
     * Act - do whatever the turtlei wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("Up")){
            move(1);
        }
        if(Greenfoot.isKeyDown("left") && Greenfoot.isKeyDown("right") != true){
            turn(-10);
        } else if (Greenfoot.isKeyDown("right") && Greenfoot.isKeyDown("left") != true){
            turn(10);
        } else if (Greenfoot.isKeyDown("right") && Greenfoot.isKeyDown("left")){
            //turn(Greenfoot.getRandomNumber(20) * -(Greenfoot.getRandomNumber(1)));
            setRotation(Greenfoot.getRandomNumber(360));
        }
        pencetTombol();
        aduhHai();
    }    
    private void pencetTombol(){
        if(isTouching(TouchToComplete.class)){
            sudahAmanPak = true;
        }
    }
    private void aduhHai(){ //metode ini gak masuk akal sehat!
       if(sudahAmanPak != true){ 
           if(isTouching(theNemesis.class)){
               //removeTouching(turtlei.class);
              
               ((Gameplay)getWorld()).endTheLevel(false);
                selfDestruct();
            }
        }
        
       /*
        if (getOneIntersectingObject(theNemesis.class) != null)
        {
            theNemesis enemy = (theNemesis) getOneIntersectingObject(theNemesis.class);
            if ("turle2.png".equals(enemy.getImage()))  getWorld().removeObject(this);
        }
        */
    }
    private void selfDestruct(){
        //getWorld().removeObject(this);
        if(destroyed == false){
            Greenfoot.playSound("Explosion bin cropped.wav"); //https://www.youtube.com/watch?v=YXBhR1EKe7w
            ((Gameplay)getWorld()).addObject(new RIPP(), getX(), getY());
            ((Gameplay)getWorld()).addObject(new DuarImage(), getX(), getY());
            getWorld().showText("Eek Serkat!", getX(), getY() + 50);
            getImage().setTransparency(0);
            destroyed = true;
        }
        if(destroyed) getWorld().removeObject(this);
    }
}
//
//
//
//
//
//
//
//
//
//
//
//