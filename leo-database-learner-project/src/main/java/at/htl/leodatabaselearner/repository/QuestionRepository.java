package at.htl.leodatabaselearner.repository;

import at.htl.leodatabaselearner.entity.DataModel;
import at.htl.leodatabaselearner.entity.ExercisePackage;
import at.htl.leodatabaselearner.entity.Person;
import at.htl.leodatabaselearner.entity.Question;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import java.util.List;


@ApplicationScoped
public class QuestionRepository implements PanacheRepository<Question> {

  public Question addQuestion(Question entity) {
    return getEntityManager().merge(entity);
  }

  public Question findById(Long id) {
    return find("id", id).firstResult();
  }

  public String getSqlFromQuestionById(Long id) {
    var question = find("id", id).firstResult();
    return question.sql;
  }

  public List<Question> findAllQuestions() {
    var query = getEntityManager()
            .createQuery("Select q from Question q", Question.class);
    return query.getResultList();
  }

  public List<Question>getAllQuestionsFromExercisePackage(String name) {
    ExercisePackage exercisePackage = findExercisePackageByName(name);
    var id = exercisePackage.getId();

    var query = getEntityManager()
            .createQuery("Select q from Question q where q.exercisePackage.id =:id", Question.class);
    query.setParameter("id", id);

    return query.getResultList();
  }

  public ExercisePackage findExercisePackageByName(String name){
    var query = getEntityManager()
            .createQuery("Select ep from ExercisePackage ep where ep.name =:name", ExercisePackage.class);
    query.setParameter("name", name);
    return query.getSingleResult();
  }


  public String getMusterSqlByQuestionId(Long id){

    var query = getEntityManager()
            .createQuery("Select q from Question q where q.id =:id", Question.class);
    query.setParameter("id", id);

    return query.getSingleResult().sql;

  }
}
