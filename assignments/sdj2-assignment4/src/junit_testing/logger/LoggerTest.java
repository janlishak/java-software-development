package junit_testing.logger;

import org.junit.jupiter.api.Test;
import singleton.Logger;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTest
{

  @Test void getInstance()
  {
    Logger logger1 = Logger.getInstance();
    Logger logger2 = Logger.getInstance();
    System.out.println(logger1.hashCode() + "\n" + logger2.hashCode());
    assertEquals(logger1.hashCode(), logger2.hashCode());
  }

  @Test void addLog()
  {
    Logger logger1 = Logger.getInstance();
    logger1.addLog("test1");
    logger1.addLog("test2");
    logger1.addLog("test3");
  }
}