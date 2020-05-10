package flyweight;

public class WoodenCoin extends Valuable
{
  public WoodenCoin()
  {
    super("Wooden Coin");
  }

  @Override int getValue()
  {
    return 5;
  }
}
