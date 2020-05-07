package flyweight_unshared;

import java.util.Calendar;

public class Person
{
  private String name;
  private AbstractStarSign starSign;

  public Person(String name, String starSignName)
  {
    this.name = name;
    this.starSign = StarSignFactory.getStarSign(starSignName);
  }

  public String getName()
  {
    return name;
  }

  public AbstractStarSign getStarSign()
  {
    return starSign;
  }

  @Override public String toString()
  {
    return name + " " + starSign;
  }

  public void setStarSign(Calendar birthday, String location)
  {
    this.starSign = StarSignFactory.getStarSign(name, birthday, location);
  }
}