import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Page2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Page2 extends LVLselect
{

    /**
     * Constructor for objects of class Page2.
     * 
     */
    public Page2()
    {
        prepare();
        //Emit Label
        //1
        showText("" + ButtonLabel[0][0], eXer[0], eYer[0]);
        showText("" + ButtonLabel[0][1], eXer[1], eYer[0]);
        showText("" + ButtonLabel[0][2], eXer[2], eYer[0]);
        showText("" + ButtonLabel[0][3], eXer[3], eYer[0]);
        showText("" + ButtonLabel[0][4], eXer[4], eYer[0]);
        //2
        showText("" + ButtonLabel[1][0], eXer[0], eYer[1]);
        showText("" + ButtonLabel[1][1], eXer[1], eYer[1]);
        showText("" + ButtonLabel[1][2], eXer[2], eYer[1]);
        showText("" + ButtonLabel[1][3], eXer[3], eYer[1]);
        showText("" + ButtonLabel[1][4], eXer[4], eYer[1]);
        //3
        showText("" + ButtonLabel[2][0], eXer[0], eYer[2]);
        showText("" + ButtonLabel[2][1], eXer[1], eYer[2]);
        showText("" + ButtonLabel[2][2], eXer[2], eYer[2]);
        showText("" + ButtonLabel[2][3], eXer[3], eYer[2]);
        showText("" + ButtonLabel[2][4], eXer[4], eYer[2]);
        //end emit
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        //ButtonLabel = new int[][]{{1,2,3,4,5},{6,7,8,9,20},{11,12,13,14,16}};
        //ButtonLabel[0][0] = 122;
        //setButtonLabel(new int[]{1,2,3,4,5}, new int[]{6,7,8,9,20}, new int[]{11,12,13,14,16});
        ButtonLabel = new int[][]{{16,17,18,19,20},{21,22,23,24,25},{26,27,28,29,30}};
    }
}
