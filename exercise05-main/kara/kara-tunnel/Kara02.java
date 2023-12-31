import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kara02 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kara02 extends Kara
{
    /**
     * Act - do whatever the Kara02 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean hasEnteredTunnel = false;

    public boolean isInTunnel(){
        return (treeLeft() && treeRight());
    }

    public void act() 
    {
        move();
        if (isInTunnel()) {
            if (!hasEnteredTunnel){
                putLeaf();
                hasEnteredTunnel = true;
            }
        }else{
            if (hasEnteredTunnel)
                Greenfoot.stop();
        }
    }    
}

