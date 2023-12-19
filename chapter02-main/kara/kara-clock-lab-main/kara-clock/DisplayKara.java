import greenfoot.*;
import java.util.List;

/**
 * CallingKara is a subclass of Kara. Therefore, it inherits all methods of Kara: <p>
 * 
 * <i>CallingKara ist eine Unterklasse von Kara. Sie erbt damit alle Methoden der Klasse Kara:</i> <p>
 * 
 * Actions:     move(), turnLeft(), turnRight(), putLeaf(), removeLeaf() <b>
 * Sensors:     onLeaf(), treeFront(), treeLeft(), treeRight(), mushroomFront()
 */
public class DisplayKara extends Kara
{

    int stepsToFirstKara = 1;

    public DisplayKara(int stepsToFirstKara){
        super();
        this.stepsToFirstKara = stepsToFirstKara;
    }

    /**
     * In the 'act()' method you can write your program for Kara <br>
     * <i>In der Methode 'act()' koennen die Befehle fuer Kara programmiert werden</i>
     */
    public void act() 
    {
        tick();
    } 

    public long count(){
        int stepsToNext = stepsToFirstKara;
        long sum = 0;
        // at last kara, facing left
        while(stepsToNext != 0){
            multiMove(stepsToNext);
            turnRight();
            DigitDisplayKara digitKara = getKaraAbove();
            int value = digitKara.count();
            showTextAtOffset(digitKara.getDisplayText(value),0,2);
            sum = sum + value * digitKara.getPlaceValue();
            stepsToNext = digitKara.getStepsToNext();
            turnLeft();
        }
        turnAround();
        while(!treeFront()) move();
        turnAround();
        return sum;

    }

    public void tick(){
        int stepsToNext = stepsToFirstKara;
        // at last kara, facing left
        while(stepsToNext != 0){
            multiMove(stepsToNext);
            turnRight();
            DigitDisplayKara digitKara = getKaraAbove();
            int value = digitKara.increment();
            showTextAtOffset(digitKara.getDisplayText(value),0,2);
            if (value == 0)
                stepsToNext = digitKara.getStepsToNext();
            else 
                stepsToNext = 0; // done

            turnLeft();
        }
        turnAround();
        while(!treeFront()) move();
        turnAround();
    }

    public void setValue(long newValue){
        int stepsToNext = stepsToFirstKara;
        // at last kara, facing left
        while(stepsToNext != 0){
            multiMove(stepsToNext);
            turnRight();
            DigitDisplayKara digitKara = getKaraAbove();
            int faceValue = (int)(newValue / digitKara.getPlaceValue());
            faceValue = faceValue % digitKara.getRollOverLimit();
            digitKara.initialize(faceValue); 
            stepsToNext = digitKara.getStepsToNext();
            showTextAtOffset(digitKara.getDisplayText(faceValue),0,2);
            turnLeft();
        }
        turnAround();
        while(!treeFront()) move();
        turnAround();
    }

    private void turnAround(){
        turnRight();turnRight();
    }

    private void multiMove(int n){
        if (n<0)
            turnAround();
        int steps = Math.abs(n);
        for(int i=0;i<steps;i++)
            move();
        if (n<0)
            turnAround();
    }

    private DigitDisplayKara getKaraAbove(){
        List<DigitDisplayKara> objects = getWorld().getObjectsAt(getX(),getY()-1,DigitDisplayKara.class);
        if (objects != null && objects.size() > 0)
            return objects.get(0);
        else 
            return null;
    }

    private void showTextAtOffset(String text, int deltaX, int deltaY){
        getWorld().showText(text,getX()+deltaX,getY()+deltaY);
    }

    protected void addedToWorld(World world){
        turnLeft();
        turnLeft();
        Tree tree = new Tree();
        world.addObject(tree,getX()+1,getY());
    }

}
