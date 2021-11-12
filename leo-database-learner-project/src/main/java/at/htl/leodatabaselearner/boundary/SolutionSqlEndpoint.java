package at.htl.leodatabaselearner.boundary;

import at.htl.leodatabaselearner.SolutionSqlRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/solution_sql")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SolutionSqlEndpoint {

    @Inject
    SolutionSqlRepository solutionSqlRepository;

    @GET
    @Path("result/{id}")
    public Response getResultset(@PathParam("id") long id) {

        final List result = solutionSqlRepository.getSqlResultsFromDB(id);

        return Response.ok(result).build();

    }
}
