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
      props.setProperty("user","postgres");
      props.setProperty("password","app");
      Connection connection = DriverManager.getConnection(url, props);


      StringBuilder sb = new StringBuilder();
           PreparedStatement ps = connection.prepareStatement(" SELECT * FROM emp");
           ResultSet rs = ps.executeQuery();
        while (rs.next()) {
          sb.append(rs.getString("ename")).append("\n");
        }

      System.out.println(sb.toString());

    }


}
