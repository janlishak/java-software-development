package flyweight;

public class Ruby extends Valuable
{
  public Ruby()
  {
    super("Ruby");
  }

  @Override int getValue()
  {
    return 25;
  }
}
