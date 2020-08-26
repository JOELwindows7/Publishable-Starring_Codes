import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.*;
import java.util.*;

/**
 * Write a description of class ExplosionImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExplosionImage extends Stuff_2
{
    private boolean existed = false;
    //private int Sequence = 0;
    //private int [] DynaSize = new int[] {0,0};
    //private int [] Ukuran = new int[]{getImage().getWidth(), getImage().getHeight()};
    //private int nonDeltaTimeKey = 100;
    public void addedToWorld(){
        existed = true;
        //Sequence = 0;
    }
    /**
     * Act - do whatever the ExplosionImage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        /*
        if(existed){
            if(nonDeltaTimeKey > 0) nonDeltaTimeKey -= 20;
            else if(nonDeltaTimeKey <= 0) nonDeltaTimeKey = 0;
            switch(Sequence){
                case 0:
                    if(DynaSize[0] < Ukuran[0] || DynaSize[1] < Ukuran[1]){
                        DynaSize[0] += 10; DynaSize[0] += 10;
                        getImage().scale(DynaSize[0], DynaSize[1]);
                    } else if(DynaSize[0] >= Ukuran[0] || DynaSize[1] > Ukuran[1]){
                        Sequence = 1;
                    }
                    break;
                case 1:
                    if(DynaSize[0] > 0 || DynaSize[1] > 0){
                        DynaSize[0] -= 10; DynaSize[0] -= 10;
                        getImage().scale(DynaSize[0], DynaSize[1]);
                    } else if(DynaSize[0] <= 0 || DynaSize[1] <= 0){
                        getImage().setTransparency(0);
                    }
                    break;
                default:
                    break;
            }
        }
        */
    }    
}
