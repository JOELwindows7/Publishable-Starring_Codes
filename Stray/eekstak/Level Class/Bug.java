import greenfoot.*;

public class Bug extends Actor
{
    public void act()
    {
        // scoring
        if (Greenfoot.mouseClicked(this)) Level.adjustScore(1);
        // level changing
        if (getX() > getWorld().getWidth()-20) ((Level)getWorld()).nextLevel();
        if (getX() < 20) ((Level)getWorld()).resetLevel();
        if (!getObjectsInRange(10, Gate.class).isEmpty()) Greenfoot.setWorld(new Level1());
        // movement and rotation
        int dx = 0, dy = 0;
        if (Greenfoot.isKeyDown("left")) dx--;
        if (Greenfoot.isKeyDown("right")) dx++;
        if (Greenfoot.isKeyDown("up")) dy--;
        if (Greenfoot.isKeyDown("down")) dy++;
        if (dx == 0 && dy == 0) return;
        setLocation(getX()+dx*2, getY()+dy*2);
        if (dx*dy == 0) setRotation(90*(1-dx)+90*(1-dy)*dy*dy);
        else setRotation((135-90*dx)*dx*dy);
    }
}