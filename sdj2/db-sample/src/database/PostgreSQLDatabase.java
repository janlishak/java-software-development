package database;

import model.Person;

import java.sql.*;
import java.util.ArrayList;

public class PostgreSQLDatabase implements Database
{
  private static final boolean DEBUG = true;
  private Connection connection = null;

  public PostgreSQLDatabase()
  {
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String user = "postgres";
    String password = "";
    //magic that check if the driver works
    try { Class.forName("org.postgresql.Driver"); } catch (ClassNotFoundException e){ e.printStackTrace(); }
    //create the connection to the server
    try { connection = DriverManager.getConnection(url, user, password); debug("connected");}
    catch (SQLException e) { debug("connection error");e.printStackTrace(); }

    //https://www.tutorialspoint.com/postgresql/postgresql_java.htm
  }

  @Override public void deleteAllData()
  {
    String sql = "DROP SCHEMA IF EXISTS warehouse CASCADE;";
    PreparedStatement preparedStatement = connection.prepareStatement("");
    preparedStatement.

    try{ Statement statement = connection.createStatement(); statement.executeUpdate(sql); statement.close(); }
    catch (Exception e ){ e.printStackTrace(); debug("error in statement execution");}
  }

  @Override public void setupStructure()
  {
    String sql = "CREATE SCHEMA warehouse;";


  }

  @Override public void loadSampleData()
  {

  }

  @Override public void close()
  {

  }

  @Override public void addPerson(String name, int age)
  {
    debug("adding person with name " + name + " and age " + age);
    PreparedStatement preparedStatement;
    preparedStatement.
  }

  @Override public void deletePersonById(int id)
  { debug("deleting person with id " + id);

  }

  @Override public Person getPersonById(int id)
  {
    debug("getting person by id " + id);
    return null;
  }

  @Override public ArrayList<Person> getAllAdults()
  { debug("getting all adults");
    return new ArrayList<Person>();
  }

  @Override public ArrayList<Person> getAllPeople()
  { debug("getting all people");

    return new ArrayList<Person>();
  }

  private void executeSingleSQL(String sql)
  {
    try{ Statement statement = connection.createStatement(); statement.executeUpdate(sql); statement.close(); }
    catch (Exception e ){ e.printStackTrace(); debug("error in statement execution");}
  }

    private void executeMultipleSQL(String[] sqls){
      for (String sql : sqls)
      {
      } }
  private static void debug(String line) {
    if(DEBUG){ System.out.println("database debug>> " + line); } }
}
