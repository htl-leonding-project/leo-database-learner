package at.htl.leodatabaselearner.repository;

import at.htl.leodatabaselearner.entity.DataModel;
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

  public void addQuestion(Question entity) {
    getEntityManager().merge(entity);
  }

  public Question findById(Long id) {
    return find("id", id).firstResult();
  }

  public String getSqlFromQuestionById(Long id) {
    var question = find("id", id).firstResult();;
    return question.sql;
  }

  public List<Question> findAllQuestions() {
    var query = getEntityManager().createQuery("Select q from Question q", Question.class);
    return query.getResultList();
  }

  public List<Question> findByOwner(Person person) {
    var query = getEntityManager().createQuery("select q from Question q" +
            " where q.owner = :owner", Question.class);
    query.setParameter("owner", person.getId());
    return query.getResultList();
  }
}
