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

  @Inject
  EntityManager em;

  public void addQuestion(Question entity) {
    em.persist(entity);
  }

  public Question findById(Long id) {
    var query = em.createQuery("select q from Question q where q.id = :id", Question.class);
    query.setParameter("id", id);
    return query.getResultStream().findFirst().orElse(null);
  }

  public String getSqlFromQuestionById(Long id) {
    var question = this.findById(id);
    return question.sql;
  }

  public List<Question> findAllQuestions() {
    var query = em.createQuery("select q from Question q", Question.class);
    return query.getResultList();
  }

  public List<Question> findByOwner(Person person) {
    var query = em.createQuery("select q.id, q.localDate, q.points, q.sql, q.text, q.dataModel," +
      " q.owner from Question q where q.owner = :owner", Question.class);
    query.setParameter("owner", person.getId());
    return query.getResultList();
  }
}
