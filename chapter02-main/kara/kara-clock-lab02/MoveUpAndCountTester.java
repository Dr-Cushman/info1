import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MoveUpAndCountTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MoveUpAndCountTester extends DigitDisplayKara
{
    /**
     * Act - do whatever the MoveUpAndCountTester wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   public void act()
    {
        int numberOfLeaves =  moveUpAndCount();
        System.out.println("Column "+getX()+": "+numberOfLeaves + " leaves");       
    }
}
