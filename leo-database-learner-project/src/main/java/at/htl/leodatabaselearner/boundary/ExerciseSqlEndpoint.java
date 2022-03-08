package at.htl.leodatabaselearner.boundary;

import at.htl.leodatabaselearner.ExerciseSqlRepository;
import at.htl.leodatabaselearner.entity.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.transaction.Transactional;
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
  @Transactional
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response getValidation(JsonObject json) throws SQLException {

    List<String> result = exerciseSqlRepository.compareSqlResults(json);

    return Response.ok(result).build();
  }

}
