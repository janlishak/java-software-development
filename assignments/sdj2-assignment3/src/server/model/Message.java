package server.model;

import java.io.Serializable;

public class Message implements Serializable
{

  public Message(String message)
  {
    this.message = message;
  }

  private String message;

  public String getMessage()
  {
    return message;
  }

  @Override public String toString()
  {
    return "Message{" + "message='" + message + '\'' + '}';
  }
}
