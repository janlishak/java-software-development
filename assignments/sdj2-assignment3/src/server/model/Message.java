package server.model;

import java.io.Serializable;

public class Message implements Serializable
{
  private String message;
  private User fromUser;

  public Message(String message, User fromUser)
  {
    this.message = message;
    this.fromUser = fromUser;
  }

  public String getMessage()
  {
    return message;
  }

  public User getFromUser()
  {
    return fromUser;
  }

  public String StringFormat(){
    return fromUser.getNickName() + ": " + message;
  }

  @Override public String toString()
  {
    return "Message{" + "message='" + message + '\'' + '}';
  }
}
