import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestWorld4WithMyKara here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestWorld4WithMyKara extends World
{

    private static final int WORLD_WIDTH = 20;  // Number of horizontal cells
    private static final int WORLD_HEIGHT = 20;  // Number of vertical cells
    private static final int SPEED = 40;
    private static final int CELL_SIZE = 28; // Size of one cell
    private static final int BASELINE = 18;
    private static final int LIMIT = 10;

    public TestWorld4WithMyKara()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WORLD_WIDTH, WORLD_HEIGHT, CELL_SIZE);
        Greenfoot.setSpeed(SPEED);
        setPaintOrder(Kara.class, Tree.class, Mushroom.class, Leaf.class);

        Greenfoot.setSpeed(40);

        showText("TestWorld4WithMyKara", 5, 0);
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
        Tree lowerTree = new Tree();
        Tree upperTree = new Tree();
        MyKara kara = new MyKara();
        kara.turnLeft();
        
        addObject(upperTree,column,BASELINE-LIMIT-2);
        int lowestLeafRow = BASELINE-2;
        addObject(kara,column,BASELINE-1);
        addObject(lowerTree,column,BASELINE);
        
        for (int i = 0; i<numberOfLeaves; i++){
            Leaf leaf = new Leaf();
            addObject(leaf,column, lowestLeafRow-i);
        }
    }
}
