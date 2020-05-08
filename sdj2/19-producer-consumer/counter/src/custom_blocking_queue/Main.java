package custom_blocking_queue;

public class Main
{
  public static void main(String[] args)
  {
    // Monitor
    Counter counter = new Counter(0, 10);

    //Producer
    new Thread(() -> {
      for (int i = 0; i < 100; i++)
      {
        counter.increment();
      }
    }).start();

    //Consumer
    new Thread(() -> {
      for (int i = 0; i < 100; i++)
      {
        counter.decrement();
      }
    }).start();
  }
}
