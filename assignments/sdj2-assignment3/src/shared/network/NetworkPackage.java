package shared.network;

public abstract class NetworkPackage
{
  private NetworkType type;

  public enum NetworkType{
    BROADCAST, USERLIST;
  }

  public NetworkPackage(NetworkType type)
  {
    this.type = type;
  }

  public NetworkType getType()
  {
    return type;
  }
}
