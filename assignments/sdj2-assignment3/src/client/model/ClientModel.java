package client.model;

import server.model.Message;
import server.model.User;
import java.util.ArrayList;

public interface ClientModel
{
  //local model
  void connect();

  //server side
  void registerClient();
  void broadCast(Message message);
  void requestUserList();

  //client side
  void receiveMessage(Message message);
  void receiveUserList(ArrayList<User> users);
}
