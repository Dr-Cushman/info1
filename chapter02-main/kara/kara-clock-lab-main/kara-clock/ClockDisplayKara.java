import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.time.LocalDateTime;

/**
 * Write a description of class ClockDisplayKara here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClockDisplayKara extends DisplayKara
{
    private int modCount = 0;
    private ClockThread clockThread;
    private boolean clockRunning = false;

    public ClockDisplayKara(int stepsToFirstKara){
        super(stepsToFirstKara);
    }

    /**
     * Act - do whatever the ClockDisplayKara wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        tick();
    }

    @Override
    public synchronized void tick(){
        modCount++;
        super.tick();
    }

    public synchronized void setTime(int hours, int minutes){
        super.setValue(hours*60+minutes);
    }

    public void start(){
        clockRunning = true;
        clockThread = new ClockThread(this);
        clockThread.setInitialTime();
        clockThread.start();
        
    }

    public void stop(){
        clockRunning = false;
        try
        {
            clockThread.join();
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }
        clockThread = null;
    }

    protected void addedToWorld(World world){
        super.addedToWorld(world);
        start();
    }

    class ClockThread extends Thread{

        private int pause = 300;
        private int lastMinutes = -1;
        private int clockModCount = -1;
        private ClockDisplayKara clockDisplay;

        public ClockThread(ClockDisplayKara kara){
            clockDisplay = kara;
        }

        protected void pause()
        {
            try {
                Thread.sleep(pause);   
            }
            catch (InterruptedException exc) {
            }
        }
        
        @Override
        public void run()
        {
            while (clockRunning) {
                step();
                pause();
            }
        }

        public void step()
        {
            synchronized(clockDisplay){

                int diff = updateLastMinutes();

                if (diff < 0){
                    setInitialTime();
                    return;
                }
                if (diff > 0)
                    if (checkModCount())
                        for (int i=0;i<diff;i++){
                            clockDisplay.tick();
                            clockModCount++;
                        }
            }
        }

        public void setInitialTime(){
            synchronized(clockDisplay){
                LocalDateTime now = LocalDateTime.now();
                int minutes = now.getMinute();
                int hours = now.getHour();
                setLastMinutes(hours,minutes);
                clockDisplay.setTime(hours, minutes);
                clockModCount = clockDisplay.modCount;
            }
        }

        public int updateLastMinutes(){
            LocalDateTime now = LocalDateTime.now();
            int minutes = now.getMinute();
            int hours = now.getHour();
            return updateLastMinutes(hours, minutes);
        }

        public int updateLastMinutes(int hours,int minutes){
            int newLastMinutes = hours*60+minutes;
            if (lastMinutes == newLastMinutes)
                return 0;
            int diff = newLastMinutes-lastMinutes;
            lastMinutes = newLastMinutes;
            return diff;
        }

        public void setLastMinutes(int hours,int minutes){
            lastMinutes = hours*60+minutes;
        }

        boolean checkModCount(){
            if (clockModCount == clockDisplay.modCount)
                return true;
            setInitialTime();
            return false;
        }
    }

}
