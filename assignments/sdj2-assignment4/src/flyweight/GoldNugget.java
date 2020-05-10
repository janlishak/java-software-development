package flyweight;

public class GoldNugget extends Valuable
{
  public GoldNugget()
  {
    super("Gold Nugget");
  }

  @Override int getValue()
  {
    return 50;
  }
}
