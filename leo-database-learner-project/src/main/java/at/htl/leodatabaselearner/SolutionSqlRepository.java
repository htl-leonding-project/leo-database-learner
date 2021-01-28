package at.htl.leodatabaselearner;

import at.htl.leodatabaselearner.entity.Question;
import io.quarkus.agroal.DataSource;
import org.checkerframework.checker.units.qual.A;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Table;
import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@ApplicationScoped
@Transactional
public class SolutionSqlRepository {

    @Inject
    EntityManager em;

//    public String getSolutionSql(long id){
//        return em.find(Question.class, id).getSql();
//    }

    public List getSqlResultsFromDB(long id){
        String sql = em.find(Question.class, id).getSql();

        return em.createQuery(sql).getResultList();
    }

}
