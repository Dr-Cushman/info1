
/**
 * Write a description of class Screen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Screen
{
    private int xRes, yRes;
    
    public Screen(int xRes, int yRes) {
        this.xRes = xRes;
        this.yRes = yRes;
    }
    
    public int numberOfPixels() {
        int calculatedPixels = xRes * yRes;
        return calculatedPixels;
    }
    
    public void clear(boolean invert) {
        if(invert) {
            
        }
    }
}
