package database;

import model.Person;
import java.util.ArrayList;

public interface Database
{
  //Database Operations
  void deleteAllData();
  void setupStructure();
  void loadSampleData();
  void close();

  //Database Queries
  void addPerson(String name, int age);
  void deletePersonById(int id);
  Person getPersonById(int id);
  ArrayList<Person> getAllAdults();
  ArrayList<Person> getAllPeople();
}
