package server;

import server.model.ServerModel;
import server.model.ServerModelManager;
import server.view.SimpleConsoleView;

public class ServerMain
{
  public static void main(String[] args)
  {
    //setup view and server
    ServerModel server = new ServerModelManager();
    SimpleConsoleView view = new SimpleConsoleView(server);

    //start the server
    server.start();
  }
}
