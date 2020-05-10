package flyweight;

public class Diamond extends Valuable
{
  public Diamond()
  {
    super("Diamond");
  }

  @Override public int getValue()
  {
    return 100;
  }
}
