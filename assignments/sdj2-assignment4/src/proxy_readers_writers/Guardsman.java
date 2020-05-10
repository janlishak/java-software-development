package proxy_readers_writers;

import flyweight.Valuable;
import utility.collection.ArrayList;

public class Guardsman implements TreasureRoomDoor
{
  private TreasureRoom treasureRoom;

  public Guardsman()
  {
    treasureRoom = new TreasureRoom();
  }

  @Override public void acquireReadAccess()
  {
    treasureRoom.acquireReadAccess();

  }

  @Override public void releaseReadAccess()
  {
    treasureRoom.releaseReadAccess();
  }

  @Override public void acquireWriteAccess()
  {
    treasureRoom.acquireWriteAccess();
  }

  @Override public void releaseWriteAccess()
  {
    treasureRoom.releaseWriteAccess();

  }

  @Override public void add(Valuable valuable)
  {
    treasureRoom.add(valuable);
  }

  @Override public Valuable retrieve()
  {
    return treasureRoom.retrieve();
  }

  @Override public ArrayList<Valuable> look()
  {
    return treasureRoom.look();
  }
}
