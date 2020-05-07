package singleton;

public class Test
{
  public static void main(String[] args)
  {
//    LogLine ll = new LogLine("hey, whats app?");
//    System.out.println(ll);

    Logger logger1 = Logger.getInstance();
    Logger logger2 = Logger.getInstance();

    logger1.addLog("this is from logger one");
    logger2.addLog("message from logger two");
  }
}
