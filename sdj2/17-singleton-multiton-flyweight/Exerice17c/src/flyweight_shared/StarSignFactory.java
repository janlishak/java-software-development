import java.util.HashMap;
import java.util.Map;

public class StarSignFactory
{
  private static Map<String, AbstractStarSign> starSigns = new HashMap<String, AbstractStarSign>();

  public static AbstractStarSign getStarSign(String name)
  {
    AbstractStarSign starSign = starSigns.get(name);
    if(starSign == null){
      starSign = new StarSign(name);
      starSigns.put(name, starSign);
    }
    return starSign;
  }
}
