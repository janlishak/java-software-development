package flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Mine
{
  private static Random random = new Random();
  private static final String[] VALUABLE_TYPES = {"ruby", "coin", "nugget", "jewel", "diamond"};
  private static Map<String, Valuable> valuables = new HashMap<>();

  public static Valuable getValuable(String ValuableType)
  {
    Valuable valuable = valuables.get(ValuableType);
    if(valuable == null){
      synchronized (valuables){
        if(valuables.get(ValuableType) == null){
          switch (ValuableType){
            case "ruby":
              valuable = new Ruby();break;
            case "coin":
              valuable = new WoodenCoin(); break;
            case "nugget":
              valuable = new GoldNugget();break;
            case "jewel":
              valuable = new Jewel();break;
            case "diamond":
              valuable = new Diamond();break;
            default:
              System.out.println("B");
          }
          valuables.put(ValuableType, valuable);
        }
      }
    }
    if(valuable == null){
      System.out.println("A");
    }
    return valuable;
  }
  public static Valuable getRandomValuable()
  {
    return getValuable(VALUABLE_TYPES[random.nextInt(VALUABLE_TYPES.length)]);
  }
}
