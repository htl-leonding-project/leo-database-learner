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

      System.out.println(sql);

      List result = exerciseSqlRepository.getSqlResultsFromDB(sql);

      return Response.ok(result).build();
    }

    @GET
    @Path("person")
    public Response foo() {
        //Person p = new Person("susi", "primerl");
        return Response.ok().build();
    }
}
