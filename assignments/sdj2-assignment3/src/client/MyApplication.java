package client;

import client.model.ClientModel;
import client.model.ClientModelManager;
import client.view.ViewHandler;
import client.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class MyApplication extends Application
{
  private ClientModel model;

  @Override public void start(Stage primaryStage)
  {
    model = new ClientModelManager();
    model.connect();

    ViewModelFactory viewModelFactory = new ViewModelFactory(model);
    ViewHandler viewHandler = new ViewHandler(viewModelFactory);
    viewHandler.start(primaryStage);
  }

  @Override public void stop()
  {
    //disconnect from server on exit
    //model.disconnect();
  }

}
