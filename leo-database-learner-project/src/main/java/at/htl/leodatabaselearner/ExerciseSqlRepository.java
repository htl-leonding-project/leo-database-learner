package at.htl.leodatabaselearner;

import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ExerciseSqlRepository {

  @Inject
  AgroalDataSource prodDataSource;

  @Inject
  @DataSource("student")
  AgroalDataSource studentDataSource;

  public List<String> getSqlResultsFromDB(String sql) {

    List<String> list = new ArrayList<String>();
    List<String> head = new ArrayList<String>();

    try {
    Connection cStudent = studentDataSource.getConnection();

    StringBuilder sbStudent = new StringBuilder();
    Statement stStudent = cStudent.createStatement();
    ResultSet rsStudent = stStudent.executeQuery(sql);

      for (int i = 1; i < rsStudent.getMetaData().getColumnCount(); i++) {
        if (i < rsStudent.getMetaData().getColumnCount() - 1) {
          sbStudent.append(rsStudent.getMetaData().getColumnName(i)).append(" ");
          head.add(rsStudent.getMetaData().getColumnName(i));
        } else {
          sbStudent.append(rsStudent.getMetaData().getColumnName(i));
          head.add(rsStudent.getMetaData().getColumnName(i));
        }
      }

      list.add(sbStudent.toString());

      while (rsStudent.next()) {
        sbStudent = new StringBuilder();
        for (int i = 0; i < head.size(); i++) {
          if (i < head.size() - 1) {
            sbStudent.append(rsStudent.getString(head.get(i).toString())).append(" ");
          } else {
            sbStudent.append(rsStudent.getString(head.get(i).toString()));
          }
        }
        list.add(sbStudent.toString());
      }
    } catch (SQLException exception) {
      return List.of(exception.getMessage());
    }

    return list;
  }

  public String compareSqlResults(String sql) throws SQLException {

    // Zwei Datenbank verbindungen gehen nicht

    try {
      Connection connection = studentDataSource.getConnection();
      //StringBuilder sbStudent = new StringBuilder();
      Statement statement = connection.createStatement();
      ResultSet rsStudent = statement.executeQuery(sql);

      connection = prodDataSource.getConnection();
      // StringBuilder sbSolution = new StringBuilder();
      statement = connection.createStatement();
      ResultSet rsSolution = statement.executeQuery(sql);
      connection.close();

      return rsStudent.toString();
     // return rsSolution.getMetaData().toString();

/*      var allMyErrors = new ArrayList<ErrorResult>();
      while (rsStudent.next() && rsSolution.next()){
        int count = rsStudent.getMetaData().getColumnCount();
        for (int i = 0; i < count; i++) {
          var row1 = rsStudent.getString(rsStudent.getMetaData().getColumnLabel(i));
          var row2 = rsSolution.getString(rsStudent.getMetaData().getColumnLabel(i));
          var save = compareRow(row1, row2);
          for (int j = 0; j < save.size(); j++) {
            allMyErrors.add(save.get(i));
          }
*//*          if (compareRow(row1, row2).size() > 0){
            allMyErrors.add(new ErrorResult("Values not correct",row1));
            break;
          }*//*
        }
      }
      if (rsStudent.next() && !rsSolution.next()
        || !rsStudent.next() && rsSolution.next()){
        System.out.println("Incorrect number of rows in result set");
      }*/
      //return allMyErrors;
    } catch (SQLException exception) {
      return null;
    }

  }

  private ArrayList<ErrorResult> compareRow(String row1, String row2) {

    ArrayList<ErrorResult> allMyErrors = new ArrayList<>();

    System.out.println(row1);
/*    for (var kv : row1.split("")){
      var key = kv.getKey();
      if (!row2.containsKey(key)){
        resultCollection.add()
        System.out.println("Result set does not contain col "+ key);
      }
      var val1 = row1.get(key);
      var val2 = row2.get(key);
      if (!val1.equals(val2)){
        System.out.println("value of col "+key+" is not equal");
      }
    }*/

    return allMyErrors;

  }

  record ErrorResult<T>(String columnAffected, T valueExpected){}

}
