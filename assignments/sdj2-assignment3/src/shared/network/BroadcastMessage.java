package shared.network;

public class BroadcastMessage extends NetworkPackage
{
  private String message;

  public BroadcastMessage(String message)
  {
    super(NetworkType.BROADCAST);
    this.message = message;
  }

  public String getMessage()
  {
    return message;
  }
}
