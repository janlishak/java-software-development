import server.mediator.Connector;
import server.model.Model;
import server.model.ModelManager;
import server.view.SimpleConsoleView;

public class ServerMain
{
  public static void main(String args[])
  {
    Model model = new ModelManager();
    SimpleConsoleView view = new SimpleConsoleView(model);
    new Connector(model).run();
  }
}