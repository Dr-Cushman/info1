import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MultiMoveTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MultiMoveTester extends DigitDisplayKara
{
    int steps = 0;
    public MultiMoveTester(int steps){
        super();
        this.steps = steps;
    }
    /**
     * Act - do whatever the MultiMoveTester wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        multiMove(steps);
    }
}
