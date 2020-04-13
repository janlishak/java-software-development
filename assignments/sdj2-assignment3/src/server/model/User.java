package server.model;

import java.io.Serializable;

public class User implements Serializable
{
  private String nickName;
  private String fullName;
  private String ipAddress;

  public User(String nickName, String fullName, String ipAddress)
  {
    this.nickName = nickName;
    this.fullName = fullName;
    this.ipAddress = ipAddress;
  }

  public String getNickName()
  {
    return nickName;
  }

  public void setNickName(String nickName)
  {
    this.nickName = nickName;
  }

  public String getFullName()
  {
    return fullName;
  }

  public void setFullName(String fullName)
  {
    this.fullName = fullName;
  }

  public String getIpAddress()
  {
    return ipAddress;
  }

  public void setIpAddress(String ipAddress)
  {
    this.ipAddress = ipAddress;
  }

  @Override public String toString()
  {
    return "User{" + "nickName='" + nickName + '\'' + ", fullName='" + fullName + '\'' + ", ipAddress='" + ipAddress + '\'' + '}';
  }
}
