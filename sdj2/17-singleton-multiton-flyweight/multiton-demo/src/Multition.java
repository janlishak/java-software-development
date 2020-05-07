import java.util.HashMap;
import java.util.Map;

public class Multition
{
  private static Map<String, Multition> instances = new HashMap();

  private Multition()
  {
    //todo
  }

  public Multition getInstance(String key)
  {
    Multition instance = instances.get(key);
    if(instance == null){
      synchronized (instances){
        if(instances.get(key) == null){
          instance = new Multition();
          instances.put(key, instance);
        }
      }
    }
    return instance;
  }
}
