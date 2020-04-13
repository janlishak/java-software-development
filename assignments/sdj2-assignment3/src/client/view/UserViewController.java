package client.view;

import client.viewmodel.UserViewModel;
import javafx.event.ActionEvent;
import javafx.scene.layout.Region;

public class UserViewController
{
  private ViewHandler viewHandler;
  private UserViewModel viewModel;
  private Region root;

  public void init(ViewHandler viewHandler, UserViewModel userViewModel, Region root)
  {
    this.root = root;
    this.viewHandler = viewHandler;
    this.viewModel = userViewModel;
  }

  public void reset()
  {
  }

  public Region getRoot()
  {
    return root;
  }

  public void goBack(ActionEvent actionEvent)
  {
    viewHandler.openView("mainView");
  }
}
