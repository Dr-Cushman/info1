import java.awt.Color;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class BallDemo   
{
    public static final boolean LEAVE_TRACES_ON_GROUND = false;
    public static final boolean LEAVE_TRACE = false;
    private Canvas myCanvas;
    private Random random;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500,LEAVE_TRACE);
        random = new Random();
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        if (LEAVE_TRACES_ON_GROUND)
            myCanvas.drawLine(50, ground, 550, ground);
        else
            myCanvas.drawLine(50, ground+1, 550, ground+1);
        // create and show the balls
        BouncingBall ball = new BouncingBall(50, -40, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(300, random.nextInt(0, 50), 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            System.out.println(ball.getYPosition());
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }

    public static void main(String[] args) {
        BallDemo demo = new BallDemo();
        demo.bounce();
    }
}
