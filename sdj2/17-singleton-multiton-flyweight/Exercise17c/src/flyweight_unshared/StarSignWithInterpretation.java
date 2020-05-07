package flyweight_unshared;

import java.util.Calendar;
import java.util.Random;

public class StarSignWithInterpretation extends AbstractStarSign
{
  public StarSignWithInterpretation(String name, Calendar birthday, String location)
  {
    super(name);
  }

  public String getInterpretation(){
    Random random = new Random();
    String[] interpretations = new String[]{"you are cool", "this will be your year", "well, nothing special here"};
    return interpretations[random.nextInt(interpretations.length)];
  }

  @Override public String toString()
  {
    return super.toString() + " " + getInterpretation();
  }
}
