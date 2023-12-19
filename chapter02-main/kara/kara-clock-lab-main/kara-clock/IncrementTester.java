import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IncrementTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IncrementTester extends DigitDisplayKara
{
    public IncrementTester(){
        super(true);
    }

    /**
     * Act - do whatever the IncrementTester wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        int numberOfLeaves =  increment();
        System.out.println("Column "+getX()+": "+numberOfLeaves + " leaves");       
    }
}
