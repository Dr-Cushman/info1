
/**
 * Write a description of class Tree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tree
{
    // instance variables - replace the example below with your own
    private Square trunk;
    private Triangle leafes;
    

    /**
     * Constructor for objects of class Tree
     */
    public Tree()
    {
         setup();
    }

    public void setup() {
        trunk = new Square();
        trunk.changeColor("Black");
        trunk.changeSize(100);
        
        leafes = new Triangle();
        leafes.moveRight();
        leafes.moveRight();
        leafes.moveRight();
        leafes.moveRight();
        
        trunk.makeVisible();
        leafes.makeVisible();
    }
}
