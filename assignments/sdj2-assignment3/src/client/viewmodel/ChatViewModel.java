package client.viewmodel;

import client.model.ClientModel;
import javafx.beans.property.SimpleStringProperty;
import server.model.Message;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ChatViewModel implements PropertyChangeListener
{
  private ClientModel model;
  private SimpleStringProperty chatMessages;
  private SimpleStringProperty messageToSend;

  public ChatViewModel(ClientModel model)
  {
    this.model = model;
    chatMessages = new SimpleStringProperty();
    chatMessages.setValue("");
    messageToSend = new SimpleStringProperty();
    model.addListener(this);
  }

  public void getAll()
  {
    //todo request history
  }

  public void send(){
    Message message = new Message(messageToSend.getValue(), model.getUser());
    model.broadCast(message);
  }

  @Override public void propertyChange(PropertyChangeEvent event)
  {
    switch (event.getPropertyName()){
      case "broadcast":
        chatMessages.setValue(chatMessages.getValue() + ((Message)event.getNewValue()).StringFormat() + "\n");break;
    }
  }

  public SimpleStringProperty chatMessagesProperty()
  {
    return chatMessages;
  }

  public SimpleStringProperty messageToSendProperty()
  {
    return messageToSend;
  }
}
