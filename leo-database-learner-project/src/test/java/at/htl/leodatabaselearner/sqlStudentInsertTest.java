package at.htl.leodatabaselearner;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class sqlStudentInsertTest {

    static Scanner scanner = new Scanner(System.in);

    //    @Test
//    @Order(1)
//    void test_getSQLWithUserInput() throws SQLException {
//        String url = "jdbc:postgresql://localhost:5433/postgres";
//        Properties props = new Properties();
//        props.setProperty("user", "postgres");
//        props.setProperty("password", "app");
//        Connection connection = DriverManager.getConnection(url, props);
//
//        System.out.print("SQL Statement:")
//        String sql = scanner.nextLine();
//
//        System.out.println(sql);
//
//        StringBuilder sb = new StringBuilder();
//        PreparedStatement ps = connection.prepareStatement(sql);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            sb.append(rs.getString("ename")).append("\n");
//        }
//
//        System.out.println(sb.toString());
//    }
    @Test
    @Order(2)
    void t020_getResultset() throws SQLException {
        String url = "jdbc:postgresql://localhost:5433/postgres";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "app");
        Connection connection = DriverManager.getConnection(url, props);

        String sql = "select * from emp where job = 'CLERK'";

        StringBuilder sb = new StringBuilder();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);


        System.out.println("SQL-Statement: " + sql + "\n");

        for (int i = 1; i < rs.getMetaData().getColumnCount(); i++) {
            System.out.print(rs.getMetaData().getColumnName(i) + " ");
        }
        System.out.println("");

        while (rs.next()) {
            sb.append(rs.getString("empno")).append(" ");
            sb.append(rs.getString("ename")).append(" ");
            sb.append(rs.getString("job")).append(" ");
            sb.append(rs.getString("mgr")).append(" ");
            sb.append(rs.getString("hiredate")).append(" ");
            sb.append(rs.getString("sal")).append(" ");
            sb.append(rs.getString("comm")).append(" ");
            sb.append(rs.getString("deptno")).append("\n");
        }
        System.out.println(sb.toString());
    }

    @Test
    @Order(3)
    void t030_getResultsetRowCount() throws SQLException {
        String url = "jdbc:postgresql://localhost:5433/postgres";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "app");
        Connection connection = DriverManager.getConnection(url, props);

        String sql = "select * from emp where job = 'CLERK'";

        Statement  statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        System.out.println("SQL-Statement: " + sql);
        System.out.print("\n");

        int size = 0;
        while (rs.next()) {
            size++;
        }
        System.out.println("Rows: " + size);
    }

    @Test
    @Order(4)
    void t040_getResultsetColumnCount() throws SQLException {
        String url = "jdbc:postgresql://localhost:5433/postgres";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "app");
        Connection connection = DriverManager.getConnection(url, props);

        String sql = "select * from emp where job = 'CLERK'";

        Statement  statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        ResultSetMetaData meta = rs.getMetaData();


        System.out.println("SQL-Statement: " + sql);
        System.out.println("\nSpalten: " + meta.getColumnCount());

    }

    @Test
    @Order(5)
    void t050_ResultsetAsTable_01() throws SQLException {

        String url = "jdbc:postgresql://localhost:5433/postgres";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "app");
        Connection connection = DriverManager.getConnection(url, props);

        String sql = "select * from emp where job = 'CLERK'";

        Statement  statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        ResultSetMetaData meta = rs.getMetaData();
        int columnsnr = meta.getColumnCount();

        System.out.println("SQL-Statement: " + sql + "\n");

        for (int j = 1; j <= columnsnr; j++) {
            System.out.printf("%10s", meta.getColumnName(j));
        }

        System.out.println("\n");

        while (rs.next()) {
            for (int i = 0; i <= columnsnr-1; i++) {
                if (i > 0 && i < columnsnr){
                    System.out.print(",");
                }

                System.out.printf("%10s",
                        rs.getString(i+1));
            }
            System.out.println("");
        }
    }

}

