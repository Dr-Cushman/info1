import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyKara here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyKara extends Kara
{
    /**
     * Act - do whatever the MyKara wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        int n = 20;
        for(int i = 0; i < n; i++){
            putNMove(i);
            turnRight();
        }
    }
    
    public void putNMove(int n){
        for(int i = 0; i <= n; i++){
            putLeaf();
            move();
        }
    }
}
