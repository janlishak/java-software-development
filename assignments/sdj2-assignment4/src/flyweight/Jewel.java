package flyweight;

public class Jewel extends Valuable
{
  public Jewel()
  {
    super("Jewel");
  }

  @Override int getValue()
  {
    return 75;
  }
}
