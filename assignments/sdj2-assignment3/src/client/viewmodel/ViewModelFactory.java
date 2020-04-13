package client.viewmodel;

import client.model.ClientModel;

public class ViewModelFactory
{
  private ChatViewModel chatViewModel;
  private UserViewModel userViewModel;

  public ViewModelFactory(ClientModel model)
  {
    this.chatViewModel = new ChatViewModel(model);
    this.userViewModel = new UserViewModel(model);
  }

  public ChatViewModel getChatViewModel()
  {
    return chatViewModel;
  }

  public UserViewModel getUserViewModel()
  {
    return userViewModel;
  }
}
