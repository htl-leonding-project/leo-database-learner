package at.htl.leodatabaselearner;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.sql.*;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class compareResultsets {


  @Test
  @Order(1)
  void t0010_compareResultsetSizeRows() throws SQLException {
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

    url = "jdbc:postgresql://localhost:5433/postgres";
    props = new Properties();
    props.setProperty("user", "postgres");
    props.setProperty("password", "app");
    connection = DriverManager.getConnection(url, props);

    ps = connection.prepareStatement(sql);
    rs = ps.executeQuery();

    int sizeOP = 0;
    while (rs.next()) {
      sizeOP++;
    }


    url = "jdbc:postgresql://localhost:5433/postgres";
    props = new Properties();
    props.setProperty("user", "postgres");
    props.setProperty("password", "app");
    connection = DriverManager.getConnection(url, props);

    sql = "Select * from salgrade";

    Statement  statement = connection.createStatement();
    rs = statement.executeQuery(sql);

    int sizeST = 0;
    while (rs.next()) {
      sizeST++;
    }

    assertThat(sizeOP).isEqualTo(sizeST);

  }


}
