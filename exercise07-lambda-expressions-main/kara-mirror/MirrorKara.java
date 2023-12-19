import java.util.List;

import greenfoot.*;

/**
 * MirrorKara is a subclass of Kara. Therefore, it inherits all methods of Kara: <p>
 * 
 * <i>MirrorKara ist eine Unterklasse von Kara. Sie erbt damit alle Methoden der Klasse Kara:</i> <p>
 * 
 * Actions:     move(), turnLeft(), turnRight(), putLeaf(), removeLeaf() <b>
 * Sensors:     onLeaf(), treeFront(), treeLeft(), treeRight(), mushroomFront()
 */
public class MirrorKara extends Kara
{
    /**
     * In the 'act()' method you can write your program for Kara <br>
     * <i>In der Methode 'act()' koennen die Befehle fuer Kara programmiert werden</i>
     */
    public void act() 
    {
        move();
        mirrorRow();
        if (treeFront())
            Greenfoot.stop();
    }  

    public void mirrorRow(){
        turnLeft();
        List<Boolean> row = scanRow();
        layRow(row);
        turnRight();
    }
}
