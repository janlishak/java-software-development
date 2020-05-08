import Drinks.Drink;

import java.util.ArrayList;

public class DrinkFactory
{
  static String[] DrinkNames = "drink1,drink2,drink3,drink4".split(",");

  public static String getReadableList()
  {
    String readableList = "[ ";
    for (String drinkName : DrinkNames)
    {
      readableList += drinkName + " ";
    }
    return readableList + "]";
  }

  public static Drink getDrink(String drinkName)
  {
    return null;
  }
}
