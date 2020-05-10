package flyweight;

public class Diamond extends Valuable
{
  public Diamond()
  {
    super("Diamond");
  }

  @Override int getValue()
  {
    return 100;
  }
}
