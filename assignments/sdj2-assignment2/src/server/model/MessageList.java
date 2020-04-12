package server.model;

import java.util.ArrayList;

public class MessageList
{
  ArrayList<Message> messages;

  public MessageList()
  {
    messages = new ArrayList<Message>();
  }

  public void addMessage(Message message){
    messages.add(message);
  }

  public void removeMessage(Message message){
    messages.remove(message);
  }

  public ArrayList<Message> getMessages()
  {
    return messages;
  }
}
