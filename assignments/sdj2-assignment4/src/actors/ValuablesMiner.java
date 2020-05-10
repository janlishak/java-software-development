package actors;

import adapter_producer_consumer.Buffer;
import flyweight.Mine;
import flyweight.Valuable;

public class ValuablesMiner implements Runnable
{
  private Buffer<Valuable> deposit;
  public ValuablesMiner(Buffer<Valuable> deposit)
  {
    this.deposit = deposit;
  }

  @Override public void run()
  {
    while(true){
      //Mine a valuable from the mine
      Valuable minedValuable = Mine.getRandomValuable();

      //Put the valuable into the blocking queue (deposit)
      deposit.put(minedValuable);
    }
  }
}
