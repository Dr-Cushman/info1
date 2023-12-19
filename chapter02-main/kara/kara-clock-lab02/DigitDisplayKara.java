import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This will be one Digit in the KaraClock
 */
public class DigitDisplayKara extends Kara
{

    public void act()
    {
    }
    
    public void turnAround(){
        turnRight();
        turnRight();
    }

    public int moveUpAndCount(){
        return -1; // has to return something to compile
    }

    public void multiMove(int n){
        if(n>=0){
            int i = 0;
            while(i<n){
                move();
                i++;
            }
        }
        else{
            turnAround();
            int i = 0;
            while(i>n){
                move();
                i--;
            }
            }
        }

}
