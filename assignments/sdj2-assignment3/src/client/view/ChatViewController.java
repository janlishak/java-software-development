package client.view;

import client.viewmodel.ChatViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class ChatViewController
{
  @FXML private TextArea messages;
  @FXML private TextField prompt;
  private Region root;
  private ChatViewModel viewModel;
  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler, ChatViewModel chatViewModel, Region root)
  {
    this.viewHandler = viewHandler;
    this.root = root;
    this.viewModel = chatViewModel;

    messages.textProperty().bind(viewModel.chatMessagesProperty());
    prompt.textProperty().bindBidirectional(viewModel.messageToSendProperty());
  }

  public void reset()
  {
    viewModel.getAll();
  }

  public Region getRoot()
  {
    return root;
  }

  public void users(ActionEvent actionEvent)
  {
    viewHandler.openView("logView");
  }

  public void exit(ActionEvent actionEvent)
  {
    System.exit(0);
  }

  public void send(ActionEvent actionEvent)
  {
    viewModel.send();
  }
}
