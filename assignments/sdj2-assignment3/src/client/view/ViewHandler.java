package client.view;

import client.viewmodel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ViewHandler
{
  private ViewModelFactory viewModelFactory;
  private Scene currentScene;
  private Stage primaryStage;
  private ChatViewController chatViewController;
  private UserViewController userViewController;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
    currentScene = new Scene(new Region());
  }

  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    openView("mainView");
  }

  public void openView(String id)
  {
    Region root = null;
    switch (id)
    {
      case "mainView":
        root = loadChatView("chat-view.fxml");
        break;
      case "logView":
        root = loadUserView("user-view.fxml");
        break;
    }
    currentScene.setRoot(root);
    String title = "";
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  public void closeView()
  {
    primaryStage.close();
  }

  private Region loadChatView(String fxmlFile)
  {
    if (chatViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        chatViewController = loader.getController();
        chatViewController.init(this, viewModelFactory.getChatViewModel(),root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      chatViewController.reset();
    }
    return chatViewController.getRoot();
  }

  private Region loadUserView(String fxmlFile)
  {
    if (userViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        userViewController = loader.getController();
        userViewController.init(this, viewModelFactory.getUserViewModel(), root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      userViewController.reset();
    }
    return userViewController.getRoot();
  }
}