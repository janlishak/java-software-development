package mediator;

import model.Model;

import java.net.ServerSocket;

public class Connector
{
  private final int PORT = 9876;
  private boolean running;
  private ServerSocket serverSocket;
  private Model model;

  public Connector(Model model)
  {
    this.model = model;
  }

}