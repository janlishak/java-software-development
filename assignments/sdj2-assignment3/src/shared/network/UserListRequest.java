package shared.network;

import server.model.User;

import java.util.ArrayList;

public class UserListRequest extends NetworkPackage
{
  private ArrayList<User> users;

  public UserListRequest(ArrayList<User> users)
  {
    super(NetworkType.USERLIST);
    this.users = users;
  }

  public ArrayList<User> getUsers()
  {
    return users;
  }
}
