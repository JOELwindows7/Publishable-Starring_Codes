import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class theNemesis here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class theNemesis extends Stuff_3
{
    boolean iHaveCameAlong = false;
    boolean bukaKuping = true;
    public void addedToWorld(World world){
        iHaveCameAlong = true;
    }
    /**
     * Act - do whatever the theNemesis wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(((Level_3)getWorld()).playerIsDead() == true){
            aaaahBerisik();
            //kenaKau();
        } else {
            getWorld().showText("" + Greenfoot.getRandomNumber(99) + " HAHAHAHA KASIHAN DEH LOE! xd!!! " + Greenfoot.getRandomNumber(99), getWorld().getWidth()/2, 13);
        }
    }    
    public void aaaahBerisik(){
        if(Greenfoot.getMicLevel()>2){
            setRotation(Greenfoot.getRandomNumber(90)*Greenfoot.getMicLevel());
        }
        if(Greenfoot.getMicLevel()>25){
            iHaveCameAlong = false;
            getWorld().removeObject(this);
        }
    }
    /*
    public void kenaKau(){ //metode ini masuk akal sehat!
        if(getWorld().getObjects(turtlei.class).isEmpty()){
            //removeTouching(turtlei.class);
            //((Gameplay)getWorld()).endTheLevel(false);
            bukaKuping = false;
        }
    }
    */
}
