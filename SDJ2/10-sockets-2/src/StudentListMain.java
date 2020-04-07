import model.Model;
import model.ModelManager;
import view.SimpleConsoleView;

public class StudentListMain
{
  public static void main(String args[])
  {
    Model model = new ModelManager();
    SimpleConsoleView view = new SimpleConsoleView(model);
  }
}