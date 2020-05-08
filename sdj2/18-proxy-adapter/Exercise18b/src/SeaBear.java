public class SeaBear implements VisitSeaBear
{
  @Override public void view(String personType)
  {
    log("the sea bear is being view by " + personType);
  }

  @Override public void feed(String personType)
  {
    log("the sea bear is being fed by " + personType);
  }

  @Override public void pet(String personType)
  {
    log("the sea bear is being petted by " + personType);
  }

  private void log(String text){
    System.out.println(text);
  }
}
