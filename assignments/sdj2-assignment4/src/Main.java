import actors.Accountant;
import actors.King;
import actors.ValuablesMiner;
import actors.ValuablesTransporter;
import adapter_producer_consumer.Buffer;
import adapter_producer_consumer.Deposit;
import proxy_readers_writers.Guardsman;
import proxy_readers_writers.TreasureRoomDoor;

public class Main
{
  public static void main(String[] args)
  {
    Buffer deposit = new Deposit();
    TreasureRoomDoor treasureRoom = new Guardsman();

    new Thread(new King(treasureRoom)).start();

    new Thread(new ValuablesMiner(deposit)).start();
    new Thread(new ValuablesMiner(deposit)).start();
    new Thread(new ValuablesMiner(deposit)).start();

    new Thread(new ValuablesTransporter(deposit, treasureRoom)).start();
    new Thread(new ValuablesTransporter(deposit, treasureRoom)).start();

    new Thread(new Accountant(treasureRoom)).start();
    new Thread(new Accountant(treasureRoom)).start();
  }
}
