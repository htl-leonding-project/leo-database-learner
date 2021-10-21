package at.htl.leodatabaselearner.boundary;

import at.htl.leodatabaselearner.entity.Assignment;
import at.htl.leodatabaselearner.entity.Evaluation;
import at.htl.leodatabaselearner.entity.Question;
import at.htl.leodatabaselearner.repository.AssignmentRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/assignment")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AssignmentEndpoint {

  @Inject
  AssignmentRepository assignmentRepository;

  @POST
  @Path("add_assignment")
  @Transactional
  public void addAssignment(Assignment assignment) { assignmentRepository.addAssignment(assignment);
  }

  @GET
  @Path("get_all")
  public List<Assignment> getAllAssignment() {
    return assignmentRepository.findAllAssignments();
  }


}
