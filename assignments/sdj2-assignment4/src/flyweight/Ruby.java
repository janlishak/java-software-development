package flyweight;

public class Ruby extends Valuable
{
  public Ruby()
  {
    super("Ruby");
  }

  @Override public int getValue()
  {
    return 11;
  }
}
