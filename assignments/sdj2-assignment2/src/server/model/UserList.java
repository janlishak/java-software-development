package server.model;

import java.util.ArrayList;

public class UserList
{
  private ArrayList<User> users;

  public UserList()
  {
    this.users = new ArrayList<User>();
  }

  public void addUser(User user){
    users.add(user);
  }

  public void removeUser(User user){
    users.remove(user);
  }

  public ArrayList<User> getUsers()
  {
    return users;
  }
}
