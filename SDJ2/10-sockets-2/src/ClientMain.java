import client.model.Model;
import client.view.SimpleClientConsoleView;
import client.model.Mediator;

public class ClientMain
{
  public static void main(String[] args)
  {
    Model model = new Mediator();
    new SimpleClientConsoleView(model).start();
  }
}
