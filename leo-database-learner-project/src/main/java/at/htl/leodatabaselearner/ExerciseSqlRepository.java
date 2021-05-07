package at.htl.leodatabaselearner;

import at.htl.leodatabaselearner.entity.Question;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@ApplicationScoped
public class ExerciseSqlRepository {

    @Inject
    EntityManager em;

    public List getSqlResultsFromOracleDB(String sql){
        return em.createQuery(sql).getResultList();
    }

}
