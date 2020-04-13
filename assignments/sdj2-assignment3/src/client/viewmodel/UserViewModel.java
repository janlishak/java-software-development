package client.viewmodel;

import client.model.ClientModel;
import javafx.beans.property.SimpleStringProperty;
import server.model.User;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class UserViewModel implements PropertyChangeListener
{
  private ClientModel model;

  private SimpleStringProperty userlist;
  private SimpleStringProperty name;

  public UserViewModel(ClientModel model)
  {
    this.model = model;
    model.addListener(this);

    userlist = new SimpleStringProperty();
    userlist.setValue("");
    name = new SimpleStringProperty();

    getAll();
  }

  public void getAll(){
    name.setValue(model.getUser().getNickName());
    model.requestUserList();
  }

  public void setName(){
    model.setUser(new User(name.getValue(), "unspecified", "hidden"));
  }

  @Override public void propertyChange(PropertyChangeEvent event)
  {
    switch (event.getPropertyName()){
      case "userlist":{
        userlist.setValue("");
        ArrayList<User> users = (ArrayList<User>) event.getNewValue();
        for (User user : users)
          {
            userlist.setValue(userlist.getValue() + user.stringFormat() + "\n");
          }
        }
      }
  }

  public SimpleStringProperty userlistProperty()
  {
    return userlist;
  }

  public SimpleStringProperty nameProperty()
  {
    return name;
  }
}
