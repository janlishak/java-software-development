package client.mediator;

import server.model.Message;
import server.model.User;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ChatClient extends Remote
{
  void receiveMessage(Message message) throws RemoteException;
  void receiveUserList(ArrayList<User> users) throws RemoteException;
}
