package actors;

import adapter_producer_consumer.Buffer;
import flyweight.Mine;
import flyweight.Valuable;
import singleton.Logger;

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
      Logger.getInstance().addLog("a miner has mined " + minedValuable.getName() + " with value of " + minedValuable.getValue());

      //Put the valuable into the blocking queue (deposit)
      deposit.put(minedValuable);
      Logger.getInstance().addLog("a miner put a new valuable into the deposit");
    }
  }
}
