package client.view;

import client.viewmodel.ChatViewModel;
import javafx.event.ActionEvent;
import javafx.scene.layout.Region;

public class ChatViewController
{
  private Region root;
  private ChatViewModel viewModel;
  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler, ChatViewModel chatViewModel, Region root)
  {
    this.viewHandler = viewHandler;
    this.root = root;
    this.viewModel = chatViewModel;

  }

  public void reset()
  {
    viewModel.getAll();
  }

  public Region getRoot()
  {
    return root;
  }

  public void TemperatureLog(ActionEvent actionEvent)
  {
    viewHandler.openView("logView");
  }

  public void HeaterDown(ActionEvent actionEvent)
  {
  }

  public void HeaterUp(ActionEvent actionEvent)
  {
  }

  public void ApplySettings(ActionEvent actionEvent)
  {
  }

  public void users(ActionEvent actionEvent)
  {
  }

  public void exit(ActionEvent actionEvent)
  {
  }

  public void send(ActionEvent actionEvent)
  {
  }
}
