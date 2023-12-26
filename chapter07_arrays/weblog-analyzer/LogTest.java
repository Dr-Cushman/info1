public class LogTest {

    public static void main(String[] args) {
        LogAnalyzer analyzer = new LogAnalyzer();
        analyzer.analyzeHourlyData();
        analyzer.printHourlyCounts();
        analyzer.numberOfAccesses();
        analyzer.busiestHour();
    }
}
