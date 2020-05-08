public class SeeBearGuard implements VisitSeaBear
{
  enum visitorType{
    EVERYONE,
    CHILDREN,
    ZOOKEEPER,
  }

  SeaBear realSubject;

  public SeeBearGuard()
  {
    realSubject = new SeaBear();
  }

  @Override public void view(String personType)
  {
    realSubject.view(personType);
  }

  @Override public void feed(String personType)
  {
    if(getVisitorType(personType).equals(visitorType.ZOOKEEPER))
      realSubject.feed(personType);
    else
      notAllowedMessage();
  }

  @Override public void pet(String personType)
  {
    if(getVisitorType(personType).equals(visitorType.CHILDREN))
      realSubject.feed(personType);
    else
      notAllowedMessage();
  }

  private visitorType getVisitorType(String personType){
    switch (personType.toLowerCase()){
      case "kid": case "child": case "children":
        return visitorType.CHILDREN;
      case "zookeeper":
        return visitorType.ZOOKEEPER;
      default:
        return visitorType.EVERYONE;
    }
  }

  private void notAllowedMessage()
  {
    System.out.println("Your are not allowed to make this action.");
  }
}
