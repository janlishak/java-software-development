package client.viewmodel;

import client.model.ClientModel;
import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import server.model.Message;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ChatViewModel implements PropertyChangeListener
{
  private ClientModel model;

  public ChatViewModel(ClientModel model)
  {
    this.model = model;
  }

  public void getAll()
  {
  }

  @Override public void propertyChange(PropertyChangeEvent propertyChangeEvent)
  {

  }
}
