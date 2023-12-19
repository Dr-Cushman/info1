import java.awt.*;
import java.awt.geom.*;


public class Spiral
{
    private int finalAngle;
    private double factor;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;

    public static void plop(){
        Spiral s = new Spiral();
        s.makeVisible();
    }

    /**
     * Create a new spiral at default position with default color.
     */
    public Spiral()
    {
        finalAngle = 13*360;
        factor = 0.07;
        xPosition = 400;
        yPosition = 400;
        color = "black";
    }

    /**
     * Make this spiral visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }

    /**
     * Make this spiral invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }

    /**
     * Move the spiral a few pixels to the right.
     */
    public void moveRight()
    {
        moveHorizontal(20);
    }

    /**
     * Move the spiral a few pixels to the left.
     */
    public void moveLeft()
    {
        moveHorizontal(-20);
    }

    /**
     * Move the spiral a few pixels up.
     */
    public void moveUp()
    {
        moveVertical(-20);
    }

    /**
     * Move the spiral a few pixels down.
     */
    public void moveDown()
    {
        moveVertical(20);
    }

    /**
     * Move the spiral horizontally by 'distance' pixels.
     */
    public void moveHorizontal(int distance)
    {
        erase();
        xPosition += distance;
        draw();
    }

    /**
     * Move the spiral vertically by 'distance' pixels.
     */
    public void moveVertical(int distance)
    {
        erase();
        yPosition += distance;
        draw();
    }

    /**
     * Slowly move the circle horizontally by 'distance' pixels.
     */
    public void slowMoveHorizontal(int distance)
    {
        int delta;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            xPosition += delta;
            draw();
        }
    }

    /**
     * Slowly move the circle vertically by 'distance' pixels.
     */
    public void slowMoveVertical(int distance)
    {
        int delta;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            yPosition += delta;
            draw();
        }
    }

    /**
     * Change the steps to the new steps. Size must be >= 0.
     */
    public void changeFinalAngle(int finalAngle)
    {
        erase();
        this.finalAngle = finalAngle;
        draw();
    }

    /**
     * Change the color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor)
    {
        color = newColor;
        draw();
    }

    /**
     * Draw the circle with current specifications on screen.
     */
    private void draw()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, generatePath());
            canvas.wait(10);
        }
    }

    private Path2D generatePath(){
        Path2D.Float path = new Path2D.Float();
        path.moveTo(xPosition,yPosition);
        for(int angle=0; angle < finalAngle; angle++){
            PolarPoint nextPoint = new PolarPoint(angle, factor*angle);   
            path.lineTo(xPosition+nextPoint.getX(),yPosition+nextPoint.getY());
        }
        return path;
    }

    /**
     * Erase the circle on screen.
     */
    private void erase()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
