package flyweight;

public abstract class Valuable
{
  String name;

  public Valuable(String name)
  {
    this.name = name;
  }

  public String getName(){
    return name;
  }
  public abstract int getValue();
}
