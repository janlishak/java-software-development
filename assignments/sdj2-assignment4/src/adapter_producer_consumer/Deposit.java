package adapter_producer_consumer;

import flyweight.Valuable;
import singleton.Logger;
import utility.collection.ArrayList;

public class Deposit implements Buffer<Valuable>
{
  private ArrayList<Valuable> valuablesArrayList;

  public Deposit()
  {
    this.valuablesArrayList = new ArrayList<Valuable>();
  }

  @Override public synchronized void put(Valuable element)
  {
    while(valuablesArrayList.isFull()){
      Logger.getInstance().addLog("Deposit full, waiting..");
      try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
    }
    valuablesArrayList.add(element);
  }

  @Override public synchronized Valuable take()
  {
    while (valuablesArrayList.isEmpty()){
      Logger.getInstance().addLog("Deposit empty, waiting..");
      try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
    }
    return valuablesArrayList.remove(0);
  }

  @Override public synchronized Valuable look()
  {
    return valuablesArrayList.get(0);
  }

  @Override public synchronized boolean isEmpty()
  {
    return valuablesArrayList.isEmpty();
  }

  @Override public synchronized boolean isFull()
  {
    return valuablesArrayList.isFull();
  }

  @Override public synchronized int size()
  {
    return valuablesArrayList.size();
  }
}
