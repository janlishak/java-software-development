package custom_blocking_queue;

public class Counter
{
  private int value;

  private int min;
  private int max;

  public Counter(int min, int max)
  {
    this.value = 0;
    this.min = min;
    this.max = max;
  }

  public synchronized void increment()
  {
    while (value >= max){
      try { wait(); } catch (InterruptedException e) { }
    }
    value++;System.out.println(value);
    notifyAll();
  }

  public synchronized void decrement()
  {
    while (value <= min){
      try { wait(); } catch (InterruptedException e) { }
    }
    value--;System.out.println(value);
    notifyAll();
  }
}
