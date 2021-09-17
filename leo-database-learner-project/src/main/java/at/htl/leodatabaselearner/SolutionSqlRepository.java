package at.htl.leodatabaselearner;

import at.htl.leodatabaselearner.entity.Question;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class SolutionSqlRepository {

    @Inject
    EntityManager em;

//    public String getSolutionSql(long id){
//        return em.find(Question.class, id).getSql();
//    }

    public List<Question> getSqlResultsFromDB(long id){
        String sql = em.find(Question.class, id).sql;
        return em.createQuery(sql,Question.class).getResultList();
    }

}
