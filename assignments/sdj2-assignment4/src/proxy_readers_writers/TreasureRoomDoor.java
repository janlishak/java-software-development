package proxy_readers_writers;

import flyweight.Valuable;
import utility.collection.ArrayList;

public interface TreasureRoomDoor
{
  void acquireReadAccess();
  void releaseReadAccess();
  void acquireWriteAccess();
  void releaseWriteAccess();

  void add(Valuable valuable);
  Valuable retrieve();
  ArrayList<Valuable> look();
}
