package at.htl.leodatabaselearner.boundary;

import at.htl.leodatabaselearner.entity.DataModel;
import at.htl.leodatabaselearner.entity.Question;
import at.htl.leodatabaselearner.repository.QuestionRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/question")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuestionEndpoint {

    @Inject
    QuestionRepository questionRepository;

    @POST
    @Path("add_question")
    @Transactional
    public void addQuestion(Question question) {
        questionRepository.addQuestion(question);
    }

    @GET
    @Path("get_all")
    public List<Question> getAllQuestions() {
        return questionRepository.findAllQuestions();
    }

    @GET
    @Path("getbyid/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Question getById(@PathParam("id") Long id) {
        return this.questionRepository.findById(id);
    }
}
