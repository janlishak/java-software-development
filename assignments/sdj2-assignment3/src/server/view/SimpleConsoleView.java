package server.view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SimpleConsoleView implements PropertyChangeListener
{
  public SimpleConsoleView()
  {
    // TODO: 3/30/20 add listener to this class;
  }

  @Override public void propertyChange(PropertyChangeEvent propertyChangeEvent)
  {
    System.out.println(">>>" + propertyChangeEvent.getNewValue());
  }
}
