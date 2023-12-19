import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestWorld5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestWorld5 extends World
{

    private static final int WORLD_WIDTH = 20;  // Number of horizontal cells
    private static final int WORLD_HEIGHT = 20;  // Number of vertical cells
    private static final int SPEED = 40;
    private static final int CELL_SIZE = 28; // Size of one cell
    private static final int BASELINE = 15;
    private static final int LEFT = 5;
    
    private static final int LIMIT = 10;

    public TestWorld5()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WORLD_WIDTH, WORLD_HEIGHT, CELL_SIZE);
        Greenfoot.setSpeed(SPEED);
        setPaintOrder(Kara.class, Tree.class, Mushroom.class, Leaf.class);

        Greenfoot.setSpeed(40);

        showText("TestWorld5", 8, BASELINE-LIMIT-3);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        prepareColumn(LEFT,6);
        prepareColumn(LEFT+2,3);
        prepareColumn(LEFT+4,9);
        prepareColumn(LEFT+6,0);
        prepareColumn(LEFT+8,1);
        prepareColumn(LEFT+10,8);
    }

    private void prepareColumn(int column, int numberOfLeaves){

        MoveUpAndCountTester kara = new MoveUpAndCountTester();
        addObject(kara,column,BASELINE-1);
        
        /*
        Tree lowerTree = new Tree();
        Tree upperTree = new Tree();
        addObject(upperTree,column,BASELINE-LIMIT-1);
        addObject(lowerTree,column,BASELINE);
        */
       
        int lowestLeafRow = BASELINE-2;
        for (int i = 0; i<numberOfLeaves; i++){
            Leaf leaf = new Leaf();
            addObject(leaf,column, lowestLeafRow-i);
        }
    }
}
