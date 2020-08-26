import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BoomImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoomImage extends ExplosionImage
{
    private boolean existed = false;
    private int Sequence = 0;
    private int [] DynaSize = new int[] {0,0};
    private int DynaX = 0;
    private int DynaY = 0;
    private int [] Ukuran = new int[]{getImage().getWidth(), getImage().getHeight()};
    private int nonDeltaTimeKey = 100;
    private GreenfootImage baseImg = new GreenfootImage("BoomImage.png");
    private GreenfootImage imaging = new GreenfootImage(baseImg);
    public BoomImage(){
        DynaSize[0] = 1;
        DynaSize[1] = 1;
        //imaging.scale(Ukuran[0], Ukuran[1]);
        //setImage(imaging);
        setImage(new GreenfootImage(imaging));
        getImage().scale(Ukuran[0], Ukuran[1]);
        //existed = true;
    }
    public void addedToWorld(World world){
        existed = true;
        Sequence = 0;
        
    }
    /**
     * Act - do whatever the ExplosionImage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        //DynaSize[0] += 10;
        //DynaSize[1] += 10;
        //imaging.scale(DynaSize[0], DynaSize[1]);
        //setImage(imaging);
        if(existed == true){
            
            if(Sequence == 0){
                if(DynaSize[0] < Ukuran[0] || DynaSize[1] < Ukuran[1]){
                    DynaSize[0] += 10; 
                    DynaSize[1] += 10;
                    
                } else if(DynaSize[0] >= Ukuran[0] || DynaSize[1] > Ukuran[1]){
                    Sequence = 1;
                }
            } else if(Sequence == 1){
                if(DynaSize[0] > 2 || DynaSize[1] > 2){
                    DynaSize[0] -= 10; 
                    DynaSize[1] -= 10;
                    
                } else if(DynaSize[0] <= 2 || DynaSize[1] <= 2){
                        
                    imaging.setTransparency(0);
                    Sequence = 2;
                }
            }
            //imaging.scale(DynaSize[0], DynaSize[1]);
            //setImage(imaging);
            setImage(new GreenfootImage(imaging));
            getImage().scale(DynaSize[0], DynaSize[1]);
        }
    }    
}
