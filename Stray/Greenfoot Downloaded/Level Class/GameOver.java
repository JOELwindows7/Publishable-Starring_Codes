import greenfoot.*;

public class GameOver extends World
{
    /** Creates a game over world showing the final score */
    public GameOver()
    {
        super(800, 600, 1);
        // create background image
        GreenfootImage bg = new GreenfootImage(6, 4); // for background design
        bg.setColor(Color.BLACK);
        bg.fill();
        bg.setColor(Color.BLUE.brighter());
        bg.drawLine(0, 0, 5, 3);
        bg.drawLine(5, 0, 0, 3);
        setBackground(bg); // tile of background image
        // the game over text
        bg = getBackground(); // full background image
        GreenfootImage text = new GreenfootImage(" GAME \n OVER ", 180, Color.CYAN.darker(), new Color(0, 0, 0, 0));
        int tw = text.getWidth()*3/2;
        GreenfootImage title = new GreenfootImage(tw, tw);
        title.drawImage(text, (tw-text.getWidth())/2-50, (tw-text.getHeight())/2-50);
        title.rotate(-30);
        bg.drawImage(title, (bg.getWidth()-tw)/2-20, (bg.getHeight()-tw)/2-20);
        // the final score text
        text = new GreenfootImage("FINAL SCORE\n"+Level.getScore(), 42, Color.BLACK, new Color(0, 0, 0, 0));
        bg.drawImage(text, 500, 450);
    }
    
    /** Starts a new game when the mouse is clicked while the game over screen is showing */
    public void act()
    {
        if (Greenfoot.mouseClicked(null)) Level.startOver();
    }
}