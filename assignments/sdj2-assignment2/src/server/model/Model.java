package server.model;

import java.util.ArrayList;

public interface Model
{
  void newMessage(Message message);
  ArrayList<Message> getAllMessages();

  void addUser(User user);
  void changeUserName(User user);
}
