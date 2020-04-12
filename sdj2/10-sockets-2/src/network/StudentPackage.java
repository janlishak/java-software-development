package network;

import server.model.Student;

public class StudentPackage extends NetworkPackage
{
  private Student student;

  public StudentPackage(Student student)
  {
    super(NetworkType.STUDENT);
    this.student = student;
  }

  public Student getStudent()
  {
    return student;
  }

  public String toString()
  {
    return getType() + ": " + student;
  }

}
