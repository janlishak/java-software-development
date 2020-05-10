package flyweight;

public class GoldNugget extends Valuable
{
  public GoldNugget()
  {
    super("Gold Nugget");
  }

  @Override public int getValue()
  {
    return 16;
  }
}
