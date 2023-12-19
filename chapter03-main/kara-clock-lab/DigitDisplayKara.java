import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This will be one Digit in the KaraClock
 */
public class DigitDisplayKara extends Kara
{
    boolean placeTrees = true;
    int stepsToNextDigit, rollOverLimit;
    long placeValue;
    int zeroValue = 0;
    boolean treeLeaf = false;

    public DigitDisplayKara(){
        this(10,1,0);
        placeTrees = false;
    }

    public DigitDisplayKara(boolean placeTrees){
        this(10,1,0);
        this.placeTrees = placeTrees;
    }

    public DigitDisplayKara(int rollOverLimit, long placeValue, int stepsToNextDigit)
    {
        this.rollOverLimit = rollOverLimit;
        this.stepsToNextDigit = stepsToNextDigit;
        this.placeValue = placeValue;

    }

    public void act()
    {
    }

    /*
     * ------- replace with your methods from lab 02 : start -----------
     */
    public int moveUpAndCount(){
        int count = 0;
        while(!treeFront()){
            move();
            if(onLeaf()){
                count++;
            }
            if(!onLeaf()){
                break;
            }
        }
        if(treeFront() && onLeaf()){
            treeLeaf = true;
        }
        return count; // has to return something to compile
    }

    public void multiMove(int n){
        int i = 0;
        if(n<0){
            turnAround();
            n = Math.abs(n);
            while(i<n){
                move();
                i++;
            }
            turnAround();
        }
        else{
            while(i<n){
                move();
                i++;
            }
        }
    }
    
    public void turnAround(){
        turnRight();
        turnRight();
    }

    /*
     * ------- replace with your methods from lab 02 : end -----------
     * ------- (don't forget the turnaround method!) -----------
     */

    public int count(){
        int count = moveUpAndCount();
        if(treeLeaf){
            multiMove(-count);
            treeLeaf = false;
        }
        else multiMove(-count - 1);
    
        return count;
    }

    public int increment(){
        int count = moveUpAndCount();
        int temp = 0;
        int i = 0;
        if(!onLeaf()){
            putLeaf();
            multiMove(-count - 1);
            temp = count + 1;
        }
        if(treeFront()){
            turnAround();
            while(i<count){
                removeLeaf();
                move();
                i++;
            }
            turnAround();
            temp = 0;     
        }
        return temp;
    }

    public void initialize(int leaves){
        int i = 0;
        while(i < leaves){
            increment();
            i++;
        }
    }

    public String getDisplayText(int count){
        return ""+count;
    }

    /*
     * 
     * You don't need to change anything in the methods below.
     * 
     * 
     * 
     */

    public void setPlaceTrees(boolean doPlaceTrees){
        placeTrees = doPlaceTrees;
    }

    public void setStepsToNextDigit(int i){
        stepsToNextDigit = i;
    }

    public int getStepsToNext(){
        return stepsToNextDigit;
    }

    public long getPlaceValue(){
        return placeValue;
    }

    public int getRollOverLimit(){
        return rollOverLimit;
    }

    protected void addedToWorld(World world){
        addTrees(world);
    }

    private void addTrees(World world){
        if (!placeTrees)
            return;
        turnLeft();
        int x = getX();
        int y = getY();
        Tree bottomTree = new Tree();
        world.addObject(bottomTree,x,y+2);
        Tree topTree = new Tree();
        world.addObject(topTree,x,y-rollOverLimit);
    }

}
