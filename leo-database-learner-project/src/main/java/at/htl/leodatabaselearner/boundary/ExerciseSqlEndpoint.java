package at.htl.leodatabaselearner.boundary;

import at.htl.leodatabaselearner.ExerciseSqlRepository;
import at.htl.leodatabaselearner.entity.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/exercise_sql")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExerciseSqlEndpoint {

    @Inject
    ExerciseSqlRepository exerciseSqlRepository;

    @POST
    @Path("result")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response getResultset(String sql) throws SQLException {

      List result = exerciseSqlRepository.getSqlResultsFromDB(sql);

      return Response.ok(result).build();
    }


  @POST
  @Path("validation")
  @Consumes(MediaType.TEXT_PLAIN)
  public Response getValidation(String sql) throws SQLException {

    String result = exerciseSqlRepository.compareSqlResults(sql);

    return Response.ok(result).build();
  }

}
