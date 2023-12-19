import LEDs.*;

public class LedDisplay extends ClockDisplay
{
    static{
        WITH_AM_PM = true;
    }
    private LEDClockDisplay leds;
    private NumberDisplay ampm;
    private NumberDisplay hours;
    private NumberDisplay minutes;

    public LedDisplay(){
        super();
    }

    public LedDisplay(int hours, int minutes){
        super(hours, minutes);
    }

    public void initRealDisplay(int hour, int minute)
    {
        leds = new LEDClockDisplay(WITH_AM_PM);
        hours = new NumberDisplay(); 
        minutes = new NumberDisplay();
        ampm = new NumberDisplay();

        leds.add(hours,minutes);
        leds.add(ampm);
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void updateRealDisplay()
    {
        int currentMinutes = getMinutesInDay();
        int valueMinutes = currentMinutes % MINUTES_IN_HOUR;
        int hour_limit = HOURS_IN_DAY;
        int valueHours = (currentMinutes % (hour_limit*MINUTES_IN_HOUR)) / MINUTES_IN_HOUR;
        
        if(valueHours < 12){
            hours.updateDisplay(valueHours);
            ampm.updateDisplay("AM");
        } else if(valueHours == 12) {
            hours.updateDisplay(12);
            ampm.updateDisplay("PM");
        } else {
            hours.updateDisplay(valueHours - 12);
            ampm.updateDisplay("PM");
        }
        minutes.updateDisplay(valueMinutes);

    }

}
