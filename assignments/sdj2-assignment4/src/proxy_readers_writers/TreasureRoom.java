package proxy_readers_writers;

import flyweight.Valuable;
import singleton.Logger;
import utility.collection.ArrayList;

public class TreasureRoom implements TreasureRoomDoor
{
  ArrayList<Valuable> treasureRoomValuables;

  int activeReaders;
  int waitingReaders;

  boolean activeWriter;
  int waitingWriters;

  @Override public synchronized void acquireReadAccess()
  {
    waitingReaders++;
    while(activeWriter || waitingWriters > 0){
      Logger.getInstance().addLog("a reader is waiting");
      try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
    }
    waitingReaders--;
    activeReaders++;
  }

  @Override public synchronized void releaseReadAccess()
  {
    activeReaders--;
    if(activeReaders == 0){
      notifyAll();
    }
  }

  @Override public synchronized void acquireWriteAccess()
  {
    waitingWriters++;
    while (activeReaders > 0 || activeWriter){
      Logger.getInstance().addLog("a writer is waiting");
      try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
    }
    activeWriter = true;
    waitingWriters--;
  }

  @Override public synchronized void releaseWriteAccess()
  {
    activeWriter = false;
    notifyAll();
  }

  @Override public synchronized void add(Valuable valuable)
  {
    treasureRoomValuables.add(valuable);
  }

  @Override public synchronized Valuable retrieve()
  {
    if(treasureRoomValuables.size() > 0){
      return treasureRoomValuables.remove(0);
    }else
      return null;
  }

  @Override public synchronized ArrayList<Valuable> look()
  {
    return treasureRoomValuables;
  }
}
