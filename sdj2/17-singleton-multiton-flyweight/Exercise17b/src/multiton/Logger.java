package multiton;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class Logger
{
  private static Map<String, Logger> instances = new HashMap<String, Logger>();
  private BufferedWriter out;
  private File file;

  private Logger(String filename)
  {
    file = new File(filename + ".txt");
  }

  public static Logger getInstance(String filename)
  {
    Logger instance = instances.get(filename);
    if (instance == null)
    {
      synchronized (Logger.class)
      {
        if (instances.get(filename) == null)
        {
          instance = new Logger(filename);
          instances.put(filename, instance);
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
      out = new BufferedWriter(new FileWriter(file, true));
      out.write(log + "\n");
      out.flush();
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
