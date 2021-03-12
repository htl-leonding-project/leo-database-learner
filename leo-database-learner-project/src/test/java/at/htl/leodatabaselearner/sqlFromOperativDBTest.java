package at.htl.leodatabaselearner;

import org.junit.jupiter.api.*;

import java.sql.*;
import java.util.Properties;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class sqlFromOperativDBTest {

  @Test
  @Order(1)
  void t0010_getEmp_pictureOnTerminal() throws SQLException {

    String url = "jdbc:postgresql://localhost:5433/postgres";
    Properties props = new Properties();
    props.setProperty("user", "postgres");
    props.setProperty("password", "app");
    Connection connection = DriverManager.getConnection(url, props);


    StringBuilder sb = new StringBuilder();
    PreparedStatement ps = connection.prepareStatement(" SELECT * FROM emp");
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      sb.append(rs.getString("ename")).append("\n");
    }

    System.out.println(sb.toString());

  }

  @Test
  @Order(2)
  void t0020_getQuestion_pictureSQLOnTerminal() throws SQLException {

    String url = "jdbc:postgresql://localhost:5432/postgres";
    Properties props = new Properties();
    props.setProperty("user", "postgres");
    props.setProperty("password", "app");
    Connection connection = DriverManager.getConnection(url, props);


    StringBuilder sb = new StringBuilder();
    PreparedStatement ps = connection.prepareStatement(" SELECT * FROM question");
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      sb.append(rs.getString("sql")).append("\n");
    }

    System.out.println(sb.toString());

  }

  @Test
  @Order(3)
  void t0030_pictureResultsetSize() throws SQLException {

    String url = "jdbc:postgresql://localhost:5432/postgres";
    Properties props = new Properties();
    props.setProperty("user", "postgres");
    props.setProperty("password", "app");
    Connection connection = DriverManager.getConnection(url, props);


    StringBuilder sb = new StringBuilder();
    PreparedStatement ps = connection.prepareStatement(" SELECT * FROM question");
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      if (rs.getInt("id") == 4) {
        sb.append(rs.getString("sql")).append("\n");
      }
    }

    String sql = sb.toString();

    System.out.println(sql);

    url = "jdbc:postgresql://localhost:5433/postgres";
    props = new Properties();
    props.setProperty("user", "postgres");
    props.setProperty("password", "app");
    connection = DriverManager.getConnection(url, props);

    ps = connection.prepareStatement(sql);
    rs = ps.executeQuery();

    int size = 0;
    while (rs.next()) {
      size++;
    }

    System.out.println(size);

  }

  @Test
  @Order(4)
  void t0040_pictureResultsetTable() throws SQLException {

    String url = "jdbc:postgresql://localhost:5432/postgres";
    Properties props = new Properties();
    props.setProperty("user", "postgres");
    props.setProperty("password", "app");
    Connection connection = DriverManager.getConnection(url, props);


    StringBuilder sb = new StringBuilder();
    PreparedStatement ps = connection.prepareStatement(" SELECT * FROM question");
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      if (rs.getInt("id") == 4) {
        sb.append(rs.getString("sql")).append("\n");
      }
    }

    String sql = sb.toString();

    System.out.println(sql);

    url = "jdbc:postgresql://localhost:5433/postgres";
    props = new Properties();
    props.setProperty("user", "postgres");
    props.setProperty("password", "app");
    connection = DriverManager.getConnection(url, props);

    ps = connection.prepareStatement(sql);
    rs = ps.executeQuery();

    ResultSetMetaData rsmd = rs.getMetaData();
    int columnsNumber = rsmd.getColumnCount();

    for (int j = 1; j <= columnsNumber; j++) {
      System.out.print(rsmd.getColumnName(j) + " ");
    }

    System.out.println("\n");

    while (rs.next()) {
      for (int i = 1; i <= columnsNumber; i++) {
        if (i > 1) System.out.print(",  ");
        String columnValue = rs.getString(i);
        System.out.print(columnValue);
      }
      System.out.println("");
    }
  }
}
