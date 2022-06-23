import greenfoot.*;

/**
 * AUTHOR: danpost (greenfoot.org username)
 * DATE: February 11, 2014
 * MODIFIED: June 17, 2014 (minor changes and finished documentation)
 *           August 8, 2014 (made some methods static and added the 'startOver' method)
 *           January 19, 2017 (changed starting condition/removed boolean 'started' field)
 * 
 * CLASS: Level -- a superclass to assist in many aspects of a world level changing scenario.
 * (1) provides an easy splash screen
 * (2) provides score and level fields whose values are not lost between levels
 * (3) provides display of the score and level values
 * (4) provides easy access to the 'nextLevel' and 'resetLevel' methods of your sub-world levels (see Bug class code)
 * (5) provides a place for any fields and methods that are shared among all your sub-world levels (such as 'String[] map',
 * which can be assigned in the 'setFields' method of that subclass, or 'public void createMap()' which need only be
 * placed in this class).
 */
public class Level extends World
{
    private static int score; // score value
    protected static int level; // level value
    private static Actor scoreText; // actor to display score
    private static Actor levelText; // actor to display level
    public static Actor bug; // the main actor
      // declare all additional fields shared among your subclasses here
    // protected static String[] map;
    
    /**
     * This initial constructor creates a world that provides a splash screen for your project and
     * contains the static fields to for the project which are reset by the 'startOver' method, in
     * turn called by the 'started' method when the 'Run' button is clicked (or called otherwise)
     */
    public Level()
    {
        super(800, 600, 1); // set dimensions to largest width and height of subworlds
        
        // create the splash screen image
        GreenfootImage bg = new GreenfootImage(6, 4); // for background design
        bg.setColor(Color.DARK_GRAY);
        bg.fill();
        bg.setColor(Color.RED);
        bg.drawLine(0, 0, 5, 3);
        bg.drawLine(5, 0, 0, 3);
        setBackground(bg); // tile of background image
        // the title
        bg = getBackground(); // full background image
        GreenfootImage text = new GreenfootImage(" TITLE \nSCREEN", 180, Color.ORANGE.darker(), new Color(0, 0, 0, 0));
        int tw = text.getWidth()*3/2;
        GreenfootImage title = new GreenfootImage(tw, tw);
        title.drawImage(text, (tw-text.getWidth())/2, (tw-text.getHeight())/2);
        title.rotate(-30);
        bg.drawImage(title, (bg.getWidth()-tw)/2-20, (bg.getHeight()-tw)/2-20);
    }
    
    /**
     * Level Constructor: calls Level(int, int, int, boolean) constructor with default bounding as true
     *
     * @param w the width of (or number of cells across) the world as an integer value
     * @param h the height of (or number of cells down) the world as an integer value
     * @param c the cellsize (width and height of a single cell) as an integer value
     */
    public Level(int w, int h, int c)
    {
        this(w, h, c, true);
    }
    
    /**
     * This main constructor creates the common objects and sets the field values; common steps in construction among
     * all levels can be appended to the code; steps that are not common to all levels should be done in the constructor
     * of those particular levels
     *
     * @param w the width of (or number of cells across) the world as an integer value
     * @param h the height of (or number of cells down) the world as an integer value
     * @param c the cellsize (width and height of a single cell) as an integer value
     * @param b the bounding flag (whether the world is bounded or not) as a boolean value
     */
    public Level(int w, int h, int c, boolean b)
    {
        super(w, h, c, b);
        adjustScore(0); // sets display of score without changing the current score
        addObject(scoreText, 75, 20); // adds score display to world
        setFields(); // initializes the value of all additional shared fields declared above
        setLevelText(); // sets text display of level
        addObject(levelText, w-75, 20); // add level display to world
        // createMap() can be called here if using maps with the added method below
        showInstructions(); // example of added method call that is shared by all levels
    }
    
    // private void createMap() // method to read map and create and add actors to the world here;
    // download and view the code of the 'Platformer Tutorial' scenario by askGriff to see how mapping would work with this
    // (the Level class there was a precursor to this)
    
    /**
     * Example of added method 
     */
    private void showInstructions()
    {
        String text = "Use arrow keys to move ladybug";
        text += "\n\nClick on ladybug to execute 'adjustScore(1)'";
        text += "\n\nMove ladybug to left edge to execute 'resetLevel'";
        text += "\n\nMove ladybug to right edge to execute 'nextLevel'";
        text += "\n(or terminate on level 3)";
        GreenfootImage textImg = new GreenfootImage(text, 28, Color.BLACK, new Color(0, 0, 0, 0));
        getBackground().drawImage(textImg, (getWidth()-textImg.getWidth())/2, (getHeight()-textImg.getHeight())/2);
    }
    
    /**
     * This method controls the proper resetting/compiling of the project;
     * DO NOT modified or remove this method
     */
    public void started()
    {
        if ("Level".equals(getClass().getName()))
        {
            startOver();
        }
    }
    
    /**
     * Use this class method to restart the scenario back at the first level (or menu); all class (static) fields are
     * reset; modify as needed, but the final line should be used to go to initial world following the title screen;
     * you may use 'Level.startOver();' from anywhere;
     * DO NOT remove this method
     */
    public static void startOver()
    {
        // initialize static fields in this class
        scoreText = getNewStillActor();
        levelText = getNewStillActor();
        bug = new Bug();
        score = 0; // initialize score
        level = 0; // initialize level
        // start first world (beyond title screen)
        Greenfoot.setWorld(new Level1());
    }
    
    /**
     * This internal class method is used to set/change the display of the level number; modify the image as needed;
     * DO NOT remove this method
     */
    private static void setLevelText()
    {
        levelText.setImage(new GreenfootImage("Level: "+level, 24, Color.BLACK, new Color(0, 0, 0, 0)));
    }
    
    /**
     * Use this class method to get the current level value from anywhere with 'Level.getLevel()';
     * DO NOT modified or remove this method
     * 
     * @return the current value of the 'level' field
     */
    public static int getLevel()
    {
        return level;
    }
    
    /**
     * Use this class method to change the score (or not) and re-display it from anywhere with 'Level.adjustScore(nn)';
     * modify the image as needed;
     * DO NOT remove this method
     *
     * @param adjustment the change in amount, if any, in the 'score' value
     */
    public static void adjustScore(int adjustment)
    {
        score += adjustment;
        scoreText.setImage(new GreenfootImage("Score: "+score, 24, Color.BLACK, new Color(0, 0, 0, 0)));
    }
    
    /**
     * Use this method to get the current score value from anywhere with 'Level.getScore()';
     * DO NOT modified or remove this method
     * 
     * @return the current value of the 'score' field
     */
    public static int getScore()
    {
        return score;
    }

    /**
     * Create methods in all sub-classes with this name, if needed, to assign values to additional common fields declared above;
     * DO NOT modified or remove this method
     */
    public void setFields(){} // include this method in all subclasses with appropriate code (see subclasses)
    
    /**
     * Create methods in all sub-classes with this name to transfer to the next level from that level;
     * for any actor in any level world, you may use '((Level)getWorld()).nextLevel()';
     * DO NOT modified or remove this method
     */
    public void nextLevel(){} // include this method in all subclasses with appropriate code (see subclasses)
    
    /**
     * Create methods in all sub-classes with this name to reset the current level from that level;
     * for any actor in any level world, you may use '((Level)getWorld()).resetLevel()';
     * DO NOT modified or remove this method
     */
    public void resetLevel(){} // include this method in all subclasses with appropriate code (see subclasses)
    
    /**
     * Use this class method to create and return an actor that is protected from movement commands;
     * (already used for the actors that display the score and level text)
     * DO NOT modified or remove this method
     */
    public static Actor getNewStillActor()
    {
        return new Actor()
        {
            public void setLocation(int x, int y){}
        };
    }
    
    /**
     * Demo act method: this can be removed or revised as needed; added to give all actors a downward pull;
     * (notice how score and level text fields are pinned in place)
     */
    public void act()
    {
        for (Object obj : getObjects(null))
        {
            Actor actor = (Actor)obj;
            actor.setLocation(actor.getX(), actor.getY()+1);
        }
    }
}