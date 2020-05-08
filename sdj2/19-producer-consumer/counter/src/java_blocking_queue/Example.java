package java_blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Example
{
  public static void main(String[] args)
  {
    BlockingQueue<Item> queue = new ArrayBlockingQueue<>(10);

    // Producer
    final Runnable runnable = () -> {
      while (true){
        try
        {
          queue.put(new Item());
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
    };
  }
}
