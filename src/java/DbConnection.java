package org.example.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

  public String getResult(String param) {
    Connection connection = null;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "mydbuser", "mydbuser");

      Statement statement;
      statement = connection.createStatement();
      ResultSet resultSet;
      resultSet = statement.executeQuery("select * from designation where title = " + param);
      int code;
      String title = null;
      while (resultSet.next()) {
        code = resultSet.getInt("code");
        title = resultSet.getString("title").trim();
        System.out.println("Code : " + code + " Title : " + title);
      }
      return title;
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }

  public String getResultsBySoftware() {
    String res = getResult("software");
    return res.toLowerCase();
  }

  public String getResultsByHR() {
    String res = getResult("hr");
    return res.toLowerCase();
  }
}
