package client.model;

import client.mediator.ChatClient;
import client.mediator.Client;
import server.mediator.ChatServer;
import server.model.Message;
import server.model.User;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class ClientModelManager implements ClientModel
{
  private ChatClient client;
  private ChatServer server;
  private User user;

  public ClientModelManager()
  {
    try
    {
      client = new Client(this);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    user = new User("New User", "", "");
  }

  @Override public void connect()
  {
    try {
      //connect to the registry
      Registry registry = LocateRegistry.getRegistry("localhost", 1099);
      server = (ChatServer) registry.lookup("server");
    } catch (Exception exception){
      System.out.println("connection failed");
      System.exit(0);
    }

//    try
//    {
//      System.out.println(server.ping());
//    }
//    catch (RemoteException e)
//    {
//      e.printStackTrace();
//    }

    registerClient();
  }

  @Override public void registerClient()
  {
    try
    {
      server.registerClient(client, user);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void broadCast(Message message)
  {
    try
    {
      server.broadCast(message, client);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void requestUserList()
  {
    try
    {
      server.requestUserList(client);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void receiveMessage(Message message)
  {
    System.out.println(message);
  }

  @Override public void receiveUserList(ArrayList<User> users)
  {
    System.out.println(users);
  }

}
