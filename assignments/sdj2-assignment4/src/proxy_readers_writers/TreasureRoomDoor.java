package proxy_readers_writers;

public interface TreasureRoomDoor
{
  void acquireReadAccess();
  void releaseReadAccess();
  void acquireWriteAccess();
  void releaseWriteAccess();

  void add();
  void retrieve();
  void look();
}
