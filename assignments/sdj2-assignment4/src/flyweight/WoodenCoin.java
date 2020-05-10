package flyweight;

public class WoodenCoin extends Valuable
{
  public WoodenCoin()
  {
    super("Wooden Coin");
  }

  @Override public int getValue()
  {
    return 10;
  }
}
