package at.htl.leodatabaselearner;

import at.htl.leodatabaselearner.repository.QuestionRepository;
import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
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

  @Inject
  QuestionRepository questionRepository;

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
      list.add("ERROR");
      list.add(exception.getMessage());
      return list;
    }

    return list;
  }

  public List<String> compareSqlResults(JsonObject json) throws SQLException {
    Long id = Long.valueOf(json.get("id").toString());
    String sql = json.get("sql").toString().replace("\"", "").replace("\\n", "");
    Connection conn;
    Statement stat;
    ResultSet rsStudent;
    Connection connProd;
    Statement statProd;
    ResultSet rsSolution;
    List<String> allMyErrors = new ArrayList<String>();
    String result;
    int countStudent = 0;
    int countResult = 0;

    allMyErrors.add("VALIDATION");

    try {
      conn = studentDataSource.getConnection();
      stat = conn.createStatement();
      try {
        rsStudent = stat.executeQuery(sql);
      }catch (SQLException exception){
        allMyErrors.add(new ErrorResult("Can't execute query", null).toString());
        return allMyErrors;
      }
    } catch (SQLException exception) {
      allMyErrors.add(new ErrorResult("Can't connect to database!", null).toString());
      return allMyErrors;
    }

    try {
      // Musterlösung von proddb holen und musterlösungsSQL auf schüler db abrufen
      // Endpoint umschreiben so dass ich weiß welche Übung ich gerade brauche
      // Frontend übergibt welche id
      connProd = studentDataSource.getConnection();
      statProd = connProd.createStatement();
      result = questionRepository.getMusterSqlByQuestionId(id);
      System.out.println(result);
      if (result != null) {
        rsSolution = statProd.executeQuery(result);
        // rsSolution.next();
        //String musterSQL = rsStudent.getString(rsStudent.getMetaData().getColumnLabel(0));
        // statement = connection.createStatement();
        // rsStudent = statement.executeQuery(musterSQL);
      } else {
        allMyErrors.add(new ErrorResult("No exercise with this id", null).toString());
        return allMyErrors;
      }
    } catch (SQLException exception) {
      allMyErrors.add(new ErrorResult("Can't connect to database!", null).toString());
      return allMyErrors;
    }

    countStudent = rsStudent.getMetaData().getColumnCount();
    countResult = rsSolution.getMetaData().getColumnCount();

    if (countStudent > 0) {
      while (rsStudent.next() && rsSolution.next()) {

        for (int i = 1; i < Math.min(countResult, countStudent) - 2; i++) {
          var row1 = rsStudent.getString(rsStudent.getMetaData().getColumnLabel(i));
          var row2 = rsSolution.getString(rsSolution.getMetaData().getColumnLabel(i));
          var save = compareRow(row1, row2);
          for (int j = 1; j < save.size(); j++) {
            allMyErrors.add(save.get(i).toString());
          }
          if (compareRow(row1, row2).size() > 0) {
            allMyErrors.add(new ErrorResult("Values not correct", row1).toString());
            break;
          }
        }
      }
    } else {
      allMyErrors.add(new ErrorResult("Warning: No rows selected", null).toString());
    }

    if (rsStudent.getMetaData().getColumnCount() != rsSolution.getMetaData().getColumnCount()){
      allMyErrors.add(new ErrorResult("Incorrect number of rows in result set", countResult).toString());
    }

    return allMyErrors;

  }

  private ArrayList<ErrorResult> compareRow(String row1, String row2) {

    ArrayList<ErrorResult> allMyErrors = new ArrayList<>();

    //System.out.println(row1);
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

  record ErrorResult<T>(String columnAffected, T valueExpected) {
  }

}
