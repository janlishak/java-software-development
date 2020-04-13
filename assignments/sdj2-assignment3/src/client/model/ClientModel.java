package client.model;

import server.model.Message;
import server.model.User;
import utility.ObserverSubject;

import java.util.ArrayList;

public interface ClientModel extends ObserverSubject
{
  //local model
  void connect();
  void setUser(User user);
  User getUser();

  //server side
  void registerClient();
  void updateUser();
  void broadCast(Message message);
  void requestUserList();

  //client side
  void receiveMessage(Message message);
  void receiveUserList(ArrayList<User> users);
}
