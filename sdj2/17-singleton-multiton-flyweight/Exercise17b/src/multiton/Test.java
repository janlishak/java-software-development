package multiton;

public class Test
{
  public static void main(String[] args)
  {
//    LogLine ll = new LogLine("hey, whats app?");
//    System.out.println(ll);

    Logger logger1 = Logger.getInstance("log1");
    Logger logger2 = Logger.getInstance("log1");
    Logger logger3 = Logger.getInstance("log2");
    Logger logger4 = Logger.getInstance("log2");

    logger1.addLog("message from logger one");
    logger2.addLog("message from logger two");
    logger3.addLog("message from logger three");
    logger4.addLog("message from logger four");
  }
}
