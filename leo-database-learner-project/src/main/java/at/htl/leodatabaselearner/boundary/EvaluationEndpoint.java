package at.htl.leodatabaselearner.boundary;

import at.htl.leodatabaselearner.entity.Evaluation;
import at.htl.leodatabaselearner.entity.ExercisePackage;
import at.htl.leodatabaselearner.repository.EvaluationRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/evaluation")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EvaluationEndpoint {

  @Inject
  EvaluationRepository evaluationRepository;

  @POST
  @Path("add_evaluation")
  @Transactional
  public void addEvaluation(Evaluation evaluation) { evaluationRepository.addEvaluation(evaluation);
  }


}
