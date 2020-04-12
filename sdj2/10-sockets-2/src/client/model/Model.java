package client.model;

import server.model.Student;
import utility.UnnamedPropertyChangeSubject;

public interface Model extends server.model.Model
{
  void connect();
  void disconnect();
}
