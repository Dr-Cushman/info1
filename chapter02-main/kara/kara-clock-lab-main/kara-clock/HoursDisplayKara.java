import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HoursDisplayKara here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HoursDisplayKara extends DigitDisplayKara
{
    public HoursDisplayKara(int rollOverLimit, long placeValue, int stepsToNextDigit){
        super(rollOverLimit, placeValue, stepsToNextDigit);
    }

    /**
     * Act - do whatever the HoursDisplayKara wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }

    public String getDisplayText(int count){
        if (count == 0)
            return "12";
        return ""+count;
    }
}
