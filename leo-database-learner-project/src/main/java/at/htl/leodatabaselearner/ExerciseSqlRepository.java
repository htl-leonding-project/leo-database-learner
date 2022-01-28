package at.htl.leodatabaselearner;

import at.htl.leodatabaselearner.entity.Question;
import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class ExerciseSqlRepository {

  @Inject
  AgroalDataSource prodDataSource;

  @Inject
  @DataSource("student")
  AgroalDataSource studentDataSource;

    public List getSqlResultsFromDB(String sql) throws SQLException {

      List list = new ArrayList<String>();
      List head = new ArrayList<String>();

      Connection connection = studentDataSource.getConnection();

      StringBuilder sb = new StringBuilder();
      Statement statement = connection.createStatement();
      ResultSet rs = statement.executeQuery(sql);

      for (int i = 1; i < rs.getMetaData().getColumnCount(); i++) {
        if ( i < rs.getMetaData().getColumnCount() - 1) {
          sb.append(rs.getMetaData().getColumnName(i)).append(" ");
          head.add(rs.getMetaData().getColumnName(i));
        }else {
          sb.append(rs.getMetaData().getColumnName(i));
          head.add(rs.getMetaData().getColumnName(i));
        }
      }

      list.add(sb.toString());

      while (rs.next()) {
        sb = new StringBuilder();
        for (int i = 0; i < head.size()-1; i++) {
          if (i < head.size()-2){
            sb.append(rs.getString(head.get(i).toString())).append(" ");
          }else {
            sb.append(rs.getString(head.get(i).toString()));
          }
        }
          list.add(sb.toString());
      }

      return list;
    }

}
