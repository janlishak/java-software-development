package client.view;

import client.viewmodel.UserViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class UserViewController
{
  @FXML private TextField prompt;
  @FXML private TextArea userlist;
  private ViewHandler viewHandler;
  private UserViewModel viewModel;
  private Region root;

  public void init(ViewHandler viewHandler, UserViewModel userViewModel, Region root)
  {
    this.root = root;
    this.viewHandler = viewHandler;
    this.viewModel = userViewModel;

    prompt.textProperty().bindBidirectional(viewModel.nameProperty());
    userlist.textProperty().bindBidirectional(viewModel.userlistProperty());
  }

  public void reset()
  {
    prompt.textProperty().setValue("");
    userlist.textProperty().setValue("");
    viewModel.getAll();
  }

  public Region getRoot()
  {
    return root;
  }

  public void messages(ActionEvent actionEvent)
  {
    viewHandler.openView("mainView");
  }

  public void exit(ActionEvent actionEvent)
  {
    System.exit(0);
  }

  public void setName(ActionEvent actionEvent)
  {
    viewModel.setName();
  }
}
