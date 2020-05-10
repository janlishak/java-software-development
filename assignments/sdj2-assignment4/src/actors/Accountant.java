package actors;

import flyweight.Valuable;
import proxy_readers_writers.TreasureRoomDoor;
import singleton.Logger;
import utility.collection.ArrayList;

public class Accountant implements Runnable
{
  private TreasureRoomDoor treasureRoom;

  public Accountant(TreasureRoomDoor treasureRoom)
  {
    this.treasureRoom = treasureRoom;
  }

  @Override public void run()
  {
    treasureRoom.acquireReadAccess();
    int sum = 0;

    ArrayList<Valuable> valuablesInTreasureRoom = treasureRoom.look();

    Logger.getInstance().addLog("the accountant is counting the valuables");
    try { wait(1000); } catch (InterruptedException e) { e.printStackTrace(); }
    for (int i = 0; i < valuablesInTreasureRoom.size(); i++)
    {
      sum+=valuablesInTreasureRoom.get(i).getValue();
    }
    treasureRoom.releaseReadAccess();
    Logger.getInstance().addLog("the sum of valuables is " + sum);

    try { wait(10000); } catch (InterruptedException e) { e.printStackTrace(); }
  }
}
