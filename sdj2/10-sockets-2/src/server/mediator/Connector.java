package server.mediator;

import server.model.Model;

import java.net.ServerSocket;

public class Connector implements Runnable
{
  private final int PORT = 9876;
  private boolean running;
  private ServerSocket serverSocket;
  private Model model;

  public Connector(Model model)
  {
    this.model = model;
  }

  @Override public void run()
  {
    try
    {
      this.serverSocket = new ServerSocket(PORT);
      ThreadGroup threadGroup = new ThreadGroup("clientHandlers");
      while (true)
      {
        Thread thread = new Thread(new ClientHandler(serverSocket.accept(), model, threadGroup));
        System.out.println("got new client!");
        thread.setDaemon(true);
        thread.start();
      }
    }
    catch (Exception e)
    {
      System.out.println("error: in server socket mainloop");
    }
  }
}