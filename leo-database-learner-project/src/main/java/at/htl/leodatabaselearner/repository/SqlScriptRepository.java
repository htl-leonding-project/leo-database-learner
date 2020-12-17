package at.htl.leodatabaselearner.repository;

import at.htl.leodatabaselearner.entity.DataModel;
import at.htl.leodatabaselearner.entity.SqlScript;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class SqlScriptRepository {

    // test

    @Inject
    EntityManager em;

    public void addSqlScript(SqlScript entity){
        em.persist(entity);
    }

    public SqlScript findById(Long id){
        var query = em.createQuery("select ss from SqlScript ss where ss.id = :id", SqlScript.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }

    public List<SqlScript> findAll(){
        var query = em.createQuery("select ss from SqlScript ss", SqlScript.class);
        return query.getResultList();
    }
}
