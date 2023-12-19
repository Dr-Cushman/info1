import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestWorld4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestWorld4 extends World
{

    private static final int WORLD_WIDTH = 20;  // Number of horizontal cells
    private static final int WORLD_HEIGHT = 20;  // Number of vertical cells
    private static final int SPEED = 40;
    private static final int CELL_SIZE = 28; // Size of one cell
    private static final int BASELINE = 16;
    private static final int LIMIT = 10;

    public TestWorld4()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WORLD_WIDTH, WORLD_HEIGHT, CELL_SIZE);
        Greenfoot.setSpeed(SPEED);
        setPaintOrder(Kara.class, Tree.class, Mushroom.class, Leaf.class);

        Greenfoot.setSpeed(40);

        showText("TestWorld4", 5, 0);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        prepareColumn(4,6);
    }

    private void prepareColumn(int column, int numberOfLeaves){
        DigitDisplayKara kara = new DigitDisplayKara(10,1,0);

        addObject(kara,column,BASELINE-1);
        int lowestLeafRow = BASELINE-2;
        /*
        Tree lowerTree = new Tree();
        Tree upperTree = new Tree();
        addObject(upperTree,column,BASELINE-LIMIT-2);
        addObject(lowerTree,column,BASELINE);
         */

        for (int i = 0; i<numberOfLeaves; i++){
            Leaf leaf = new Leaf();
            addObject(leaf,column, lowestLeafRow-i);
        }
    }
}
