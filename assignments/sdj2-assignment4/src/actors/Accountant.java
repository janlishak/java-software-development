package actors;

import flyweight.Valuable;
import proxy_readers_writers.TreasureRoomDoor;
import singleton.Logger;
import utility.collection.ArrayList;

import java.util.Random;

public class Accountant implements Runnable
{
  private TreasureRoomDoor treasureRoom;

  public Accountant(TreasureRoomDoor treasureRoom)
  {
    this.treasureRoom = treasureRoom;
  }

  @Override public void run()
  {
    while(true)
    {
      Logger.getInstance().addLog("the accountant started counting the valuables");
      treasureRoom.acquireReadAccess();
      int sum = 0;

      ArrayList<Valuable> valuablesInTreasureRoom = treasureRoom.look();

      try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
      for (int i = 0; i < valuablesInTreasureRoom.size(); i++)
      {
        sum+=valuablesInTreasureRoom.get(i).getValue();
      }
      treasureRoom.releaseReadAccess();
      Logger.getInstance().addLog("the sum of valuables is " + sum);

      Random random = new Random();
      try { Thread.sleep((random.nextInt(5) + 6) *1000); } catch (InterruptedException e) { e.printStackTrace(); }
    }
  }
}
