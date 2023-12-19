public class Date{
  private int day, month, year;

  public Date(int year, int month, int day){
    this.day = day;
    this.month = month;
    this.year = year;
  }
  public String format(){

    return ""+day+"."+month+"."+year;
  }
}
