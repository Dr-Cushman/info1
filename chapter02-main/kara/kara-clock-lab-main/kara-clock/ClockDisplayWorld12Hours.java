import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World7Increment here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClockDisplayWorld12Hours extends World
{

    private static final int WORLD_WIDTH = 20;  // Number of horizontal cells
    private static final int WORLD_HEIGHT = 20;  // Number of vertical cells
    private static final int SPEED = 40;
    private static final int CELL_SIZE = 28; // Size of one cell
    private static final int BASELINE = 15;
    private static final int RIGHT = 10;
    private static final int STEPS_TO_FIRST_DIGIT = 5;
    public ClockDisplayWorld12Hours()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WORLD_WIDTH, WORLD_HEIGHT, CELL_SIZE);
        Greenfoot.setSpeed(SPEED);
        setPaintOrder(Kara.class, Tree.class, Mushroom.class, Leaf.class);

        Greenfoot.setSpeed(40);

        showText("ClockDisplayWorld12Hours", 5, BASELINE-14);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        prepareColumns();
        
        ClockDisplayKara displayKara = new ClockDisplayKara(STEPS_TO_FIRST_DIGIT);
        addObject(displayKara,RIGHT+STEPS_TO_FIRST_DIGIT,BASELINE+1);

        displayKara.count();
        
    }
    
    private void prepareColumns(){
        
        DigitDisplayKara minutes = new DigitDisplayKara(10,1,1);
        DigitDisplayKara tenMinutes = new DigitDisplayKara(6,10,2);
        HoursDisplayKara hours = new HoursDisplayKara(12,60,0);
        
        addObject(minutes,RIGHT,BASELINE);
        addObject(tenMinutes,RIGHT-1,BASELINE);
        showText(":", RIGHT-2,BASELINE+3);
        addObject(hours,RIGHT-3,BASELINE);
         
    }
}
