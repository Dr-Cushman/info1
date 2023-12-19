import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestWorld0 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestWorld0 extends World
{

    private static final int WORLD_WIDTH = 20;  // Number of horizontal cells
    private static final int WORLD_HEIGHT = 20;  // Number of vertical cells
    private static final int SPEED = 40;
    private static final int CELL_SIZE = 28; // Size of one cell

    /**
     * Constructor for objects of class CopyOfDigitDisplayKaraTestWorld2.
     * 
     */
    public TestWorld0()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WORLD_WIDTH, WORLD_HEIGHT, CELL_SIZE);
        Greenfoot.setSpeed(SPEED);
        setPaintOrder(Kara.class, Tree.class, Mushroom.class, Leaf.class);

        Greenfoot.setSpeed(40);

        showText("TestWorld0", 6, 1);
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        DigitDisplayKara DigitDisplayKara = new DigitDisplayKara();
        addObject(DigitDisplayKara,9,10);
        DigitDisplayKara.turnLeft();
    }
}
