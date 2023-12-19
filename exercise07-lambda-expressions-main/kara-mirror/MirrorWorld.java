import greenfoot.*;

/**
 * This class creates a world for Kara. It contains settings for height and 
 * width of the world and initializes the Actors.
 * 
 * @author Marco Jakob (majakob@gmx.ch)
 * @version 1.3 (2012-07-04)
 */
import java.util.Random;
public class MirrorWorld extends World 
{   
    private static final int WORLD_WIDTH = 35;  // Number of horizontal cells
    private static final int WORLD_HEIGHT = 16;  // Number of vertical cells

    private static final int CELL_SIZE = 28; // Size of one cell
    private Random random = new Random();
    /**
     * Creates a world for Kara.
     */
    public MirrorWorld() 
    {
        // Create the new world
        super(WORLD_WIDTH, WORLD_HEIGHT, CELL_SIZE);

        setPaintOrder(Kara.class, Tree.class, Mushroom.class, Leaf.class);
        Greenfoot.setSpeed(40);

        // Initialize actors
        prepare();
    }

    /**
     * Prepare the world, i.e. create all initial actors.
     * 
     * Hint:
     * First create and position all Actors with the mouse in the world.
     * Then right-click on the world and choose 'Save the World'. This will
     * automatically generate the content of this method.
     */
    private void prepare() 
    {
        int x = 17; int y=14;
        MirrorKara myKara = new MirrorKara();
        addObject(myKara,x,y);
        myKara.turnLeft();
        int height= 12;
        int widthToLeft = 14;
        for(int i=0;i<height;i++){
            randomRow(x-1,y-1-i,widthToLeft);
        }
        Tree tree14 = new Tree();
        addObject(tree14,x,y-1-height);
    }

    private void randomRow(int middlex,int y, int widthToLeft){
        Tree tree = new Tree();
        addObject(tree,middlex-widthToLeft,y);
        for (int col=0;col<widthToLeft;col++){
            if (random.nextInt(100) < 60){
                Leaf leaf = new Leaf();
                addObject(leaf,middlex-col,y);
            }
        }

    }
}
