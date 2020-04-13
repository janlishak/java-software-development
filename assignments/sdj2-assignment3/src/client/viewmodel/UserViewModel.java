package client.viewmodel;

import client.model.ClientModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class UserViewModel implements PropertyChangeListener
{
  private ClientModel model;

  public UserViewModel(ClientModel model)
  {
    this.model = model;
  }

  @Override public void propertyChange(PropertyChangeEvent propertyChangeEvent)
  {
  }
}
