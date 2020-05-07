package singleton;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Logger
{
  private static Logger instance;
  private BufferedWriter out;

  private Logger() { }

  public static Logger getInstance(){
    if(instance == null){
      synchronized (Logger.class){
        if(instance == null){
          instance = new Logger();
        }
      }
    }
    return instance;
  }

  public void addLog(String log)
  {
    LogLine logLine = new LogLine(log);
    System.out.println(logLine);
    addToFile(logLine);
  }

  private synchronized void addToFile(LogLine log)
  {
    if (log == null)
    {
      return;
    }

    try
    {
      File logFile = new File("Log.txt");
      out = new BufferedWriter(new FileWriter(logFile, true));
      out.write(log + "\n");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        out.close();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
  }
}

//  private Logger(String filename) throws IOException
//  {
//    File logFile = new File(filename + ".txt");
//    out = new BufferedWriter(new FileWriter(logFile, true));
//  }
