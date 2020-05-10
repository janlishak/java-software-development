package actors;

import adapter_producer_consumer.Buffer;
import flyweight.Valuable;
import proxy_readers_writers.Guardsman;
import proxy_readers_writers.TreasureRoom;
import proxy_readers_writers.TreasureRoomDoor;
import utility.collection.ArrayList;

import java.util.Random;

public class ValuablesTransporter implements Runnable
{
  private Buffer<Valuable> deposit;
  private TreasureRoomDoor treasureRoom;

  private ArrayList<Valuable> valuablesInTransport;
  private Random random;

  public ValuablesTransporter(Buffer<Valuable> deposit, TreasureRoomDoor treasureRoom)
  {
    this.deposit = deposit;
    this.treasureRoom = treasureRoom;
    random = new Random();

  }

  @Override public void run()
  {
    while (true)
    {
      // start with empty list
      valuablesInTransport = new ArrayList<Valuable>();
      // bound value between 50 and 200
      int minimalValue = random.nextInt(150) + 51;
      int currentValue = 0;

      // wait until the transporter has enough valuables for the transport
      while (currentValue < minimalValue)
      {
        Valuable valuable = deposit.take();
        valuablesInTransport.add(valuable);
        currentValue+=valuable.getValue();
      }

      // simulate the journey to take some time
      try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

      treasureRoom.acquireWriteAccess();
      for (int i = 0; i < valuablesInTransport.size(); i++)
      {
        treasureRoom.add(valuablesInTransport.get(i));
        // simulate it takes some time to add valuables to the treasure room
        try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
      }
      treasureRoom.releaseWriteAccess();

    }
  }
}
