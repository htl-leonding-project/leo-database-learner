package at.htl.leodatabaselearner.boundary;

import at.htl.leodatabaselearner.ExerciseSqlRepository;
import at.htl.leodatabaselearner.entity.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/exercise_sql")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExerciseSqlEndpoint {

    @Inject
    ExerciseSqlRepository exerciseSqlRepository;

    @GET
    @Path("result/{sql}")
    public Response getResultset(@PathParam("sql") String sql) {

        //final List result = exerciseSqlRepository.getSqlResultsFromDB(sql);

        return Response.ok().build();

    }

    @GET
    @Path("person")
    public Response foo() {
        //Person p = new Person("susi", "primerl");
        return Response.ok().build();
    }
}
