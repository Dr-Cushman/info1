import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CountTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CountTester extends DigitDisplayKara
{
    public CountTester(){
        super(true);
    }

    /**
     * Act - do whatever the CountTester wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        int numberOfLeaves =  count();
        System.out.println("Column "+getX()+": "+numberOfLeaves + " leaves");       
    }
}
