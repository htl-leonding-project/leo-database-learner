package at.htl.leodatabaselearner;

import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.inject.Inject;
import java.sql.*;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class CompareResultsets {

  @Inject
  AgroalDataSource prodDataSource;

  @Inject
  @DataSource("student")
  AgroalDataSource studentDataSource;

  @Test
  @Order(1)
  void t0010_compareResultsetSizeRows() throws SQLException {
//    String url = "jdbc:postgresql://localhost:5432/postgres";
//    Properties props = new Properties();
//    props.setProperty("user", "postgres");
//    props.setProperty("password", "app");
//    Connection connection = DriverManager.getConnection(url, props);

    Connection connection = prodDataSource.getConnection();

    StringBuilder sb = new StringBuilder();
    PreparedStatement ps = connection.prepareStatement(" SELECT * FROM question");
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      if (rs.getInt("id") == 4) {
        sb.append(rs.getString("sql")).append("\n");
      }
    }

    String sql = sb.toString();

//    url = "jdbc:postgresql://localhost:5433/postgres";
//    props = new Properties();
//    props.setProperty("user", "postgres");
//    props.setProperty("password", "app");
//    connection = DriverManager.getConnection(url, props);

    connection = studentDataSource.getConnection();

    ps = connection.prepareStatement(sql);
    rs = ps.executeQuery();

    int sizeOP = 0;
    while (rs.next()) {
      sizeOP++;
    }

//    url = "jdbc:postgresql://localhost:5433/postgres";
//    props = new Properties();
//    props.setProperty("user", "postgres");
//    props.setProperty("password", "app");
//    connection = DriverManager.getConnection(url, props);

    sql = "Select * from salgrade";

    Statement statement = connection.createStatement();
    rs = statement.executeQuery(sql);

    int sizeST = 0;
    while (rs.next()) {
      sizeST++;
    }

    assertThat(sizeOP).isEqualTo(sizeST);

  }

  @Test
  @Order(2)
  void t0020_compareResultsetSizeColumns() throws SQLException {

//    String url = "jdbc:postgresql://localhost:5432/postgres";
//    Properties props = new Properties();
//    props.setProperty("user", "postgres");
//    props.setProperty("password", "app");
//    Connection connection = DriverManager.getConnection(url, props);

    Connection connection = prodDataSource.getConnection();


    StringBuilder sb = new StringBuilder();
    PreparedStatement ps = connection.prepareStatement(" SELECT * FROM question");
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      if (rs.getInt("id") == 4) {
        sb.append(rs.getString("sql")).append("\n");
      }
    }

    String sql = sb.toString();

//    url = "jdbc:postgresql://localhost:5433/postgres";
//    props = new Properties();
//    props.setProperty("user", "postgres");
//    props.setProperty("password", "app");
//    connection = DriverManager.getConnection(url, props);

    connection = studentDataSource.getConnection();


    ps = connection.prepareStatement(sql);
    rs = ps.executeQuery();
    ResultSetMetaData meta = rs.getMetaData();
    int sizeOP = meta.getColumnCount();

//    url = "jdbc:postgresql://localhost:5433/postgres";
//    props = new Properties();
//    props.setProperty("user", "postgres");
//    props.setProperty("password", "app");
//    connection = DriverManager.getConnection(url, props);

    sql = "Select * from salgrade";

    Statement statement = connection.createStatement();
    rs = statement.executeQuery(sql);
    meta = rs.getMetaData();

    int sizeST = meta.getColumnCount();

    assertThat(sizeOP).isEqualTo(sizeST);

  }

  @Test
  @Order(3)
  void t0030_compareResultsetSizeRows() throws SQLException {
//    String url = "jdbc:postgresql://localhost:5432/postgres";
//    Properties props = new Properties();
//    props.setProperty("user", "postgres");
//    props.setProperty("password", "app");
//    Connection connection = DriverManager.getConnection(url, props);

    Connection connection = prodDataSource.getConnection();

    StringBuilder sb = new StringBuilder();
    PreparedStatement ps = connection.prepareStatement(" SELECT * FROM question");
    ResultSet rs = ps.executeQuery();
    int sizeOP = 0;

    while (rs.next()) {
      if (rs.getInt("id") == 4) {
        sb.append(rs.getString("sql")).append("\n");
      }

    }

    String sql = sb.toString();

//    url = "jdbc:postgresql://localhost:5433/postgres";
//    props = new Properties();
//    props.setProperty("user", "postgres");
//    props.setProperty("password", "app");
//    connection = DriverManager.getConnection(url, props);

    connection = studentDataSource.getConnection();

    ps = connection.prepareStatement(sql);
    rs = ps.executeQuery();

    while(rs.next()){
      sizeOP++;
    }
//    url = "jdbc:postgresql://localhost:5433/postgres";
//    props = new Properties();
//    props.setProperty("user", "postgres");
//    props.setProperty("password", "app");
//    connection = DriverManager.getConnection(url, props);

    sql = "Select * from salgrade";

    Statement statement = connection.createStatement();
    rs = statement.executeQuery(sql);
    int sizeST = 0;
    while (rs.next()){
      sizeST++;
    }
    assertThat(sizeOP).isEqualTo(sizeST);

  }

  @Test
  @Order(4)
  void t0040_compareResultsetColumnLabel() throws SQLException {
//    String url = "jdbc:postgresql://localhost:5432/postgres";
//    Properties props = new Properties();
//    props.setProperty("user", "postgres");
//    props.setProperty("password", "app");
//    Connection connection = DriverManager.getConnection(url, props);

    Connection connection = prodDataSource.getConnection();

    StringBuilder sb = new StringBuilder();
    PreparedStatement ps = connection.prepareStatement(" SELECT * FROM question");
    ResultSet rs = ps.executeQuery();


    while (rs.next()) {
      if (rs.getInt("id") == 4) {
        sb.append(rs.getString("sql")).append("\n");
      }
    }

    String sql = sb.toString();

//    url = "jdbc:postgresql://localhost:5433/postgres";
//    props = new Properties();
//    props.setProperty("user", "postgres");
//    props.setProperty("password", "app");
//    connection = DriverManager.getConnection(url, props);

    connection = studentDataSource.getConnection();

    ps = connection.prepareStatement(sql);
    rs = ps.executeQuery();
    ResultSetMetaData metaOP = rs.getMetaData();
    int columnCountOP = metaOP.getColumnCount();

    sql = "Select * from salgrade";

    Statement statement = connection.createStatement();
    rs = statement.executeQuery(sql);
    ResultSetMetaData metaST = rs.getMetaData();
    int columnCountST = metaST.getColumnCount();
    int sizeST = 0;
    while (rs.next()){
      sizeST++;
    }

    String[] labels = new String[5];


    if (columnCountOP == columnCountST){
      labels = new String[columnCountOP];

      for (int i = 0; i < columnCountST; i++) {
        if (metaST.getColumnLabel(i+1).equals(metaOP.getColumnLabel(i+1))){
          labels[i] = metaST.getColumnLabel(i+1);
        }
      }
    }

    String[] correctLabels = {"grade", "losal", "hisal"};
    //assertThat(columnCountST).isEqualTo(columnCountOP);
    assertThat(labels).isEqualTo(correctLabels);

  }

  @Test
  @Order(5)
  void t0050_compareResultsetColumnType() throws SQLException {
//    String url = "jdbc:postgresql://localhost:5432/postgres";
//    Properties props = new Properties();
//    props.setProperty("user", "postgres");
//    props.setProperty("password", "app");
//    Connection connection = DriverManager.getConnection(url, props);

     Connection connection = prodDataSource.getConnection();

    StringBuilder sb = new StringBuilder();
    PreparedStatement ps = connection.prepareStatement(" SELECT * FROM question");
    ResultSet rs = ps.executeQuery();


    while (rs.next()) {
      if (rs.getInt("id") == 4) {
        sb.append(rs.getString("sql")).append("\n");
      }
    }

    String sql = sb.toString();

//    url = "jdbc:postgresql://localhost:5433/postgres";
//    props = new Properties();
//    props.setProperty("user", "postgres");
//    props.setProperty("password", "app");
//    connection = DriverManager.getConnection(url, props);

    connection = studentDataSource.getConnection();

    ps = connection.prepareStatement(sql);
    rs = ps.executeQuery();
    ResultSetMetaData metaOP = rs.getMetaData();
    int columnCountOP = metaOP.getColumnCount();

    sql = "Select * from salgrade";

    Statement statement = connection.createStatement();
    rs = statement.executeQuery(sql);
    ResultSetMetaData metaST = rs.getMetaData();
    int columnCountST = metaST.getColumnCount();

    String[] labels = new String[5];

    if (columnCountOP == columnCountST){
      labels = new String[columnCountOP];

      for (int i = 0; i < columnCountST; i++) {
        if (metaST.getColumnTypeName(i+1).equals(metaOP.getColumnTypeName(i+1))){
          labels[i] = metaST.getColumnTypeName(i+1);
          System.out.println(labels[i]);
        }
      }
    }

    String[] correctLabels = {"numeric", "numeric", "numeric"};
    //assertThat(columnCountST).isEqualTo(columnCountOP);
    assertThat(labels).isEqualTo(correctLabels);
  }

}
