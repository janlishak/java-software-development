package actors;

import flyweight.Valuable;
import proxy_readers_writers.TreasureRoomDoor;
import singleton.Logger;
import utility.collection.ArrayList;

import java.util.Random;

public class King implements Runnable
{
  private TreasureRoomDoor treasureRoom;
  private Random random;

  public King(TreasureRoomDoor treasureRoom)
  {
    this.treasureRoom = treasureRoom;
    random = new Random();
  }

  @Override public void run()
  {
    while (true)
    {
      int partyCost = random.nextInt(100) + 51;
      Logger.getInstance().addLog("##### King is planning a party that costs " + partyCost + " gold");
      treasureRoom.acquireWriteAccess();
      Valuable valuable;

      ArrayList<Valuable> valuablesInKingsHands = new ArrayList<>();
      int sum = 0;

      while ((valuable = treasureRoom.retrieve()) != null)
      {
        sum += valuable.getValue();
        valuablesInKingsHands.add(valuable);
      }

      if (sum >= partyCost)
      {
        Logger.getInstance().addLog("##### King is throwing a party!");
        valuablesInKingsHands = null;
      }
      else
      {
        for (int i = 0; i < valuablesInKingsHands.size(); i++)
        {
          treasureRoom.add(valuablesInKingsHands.remove(i));
        }
        Logger.getInstance().addLog("##### King does not have enough gold for party");
      }

      treasureRoom.releaseWriteAccess();
      try
      {
        Thread.sleep(12000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
