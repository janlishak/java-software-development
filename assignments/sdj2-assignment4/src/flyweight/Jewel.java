package flyweight;

public class Jewel extends Valuable
{
  public Jewel()
  {
    super("Jewel");
  }

  @Override public int getValue()
  {
    return 14;
  }
}
