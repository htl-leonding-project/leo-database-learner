package at.htl.leodatabaselearner.repository;

import at.htl.leodatabaselearner.entity.DataModel;
import at.htl.leodatabaselearner.entity.SqlScript;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import java.util.List;

@ApplicationScoped
public class SqlScriptRepository implements PanacheRepository<SqlScript> {

    // test

    @Inject
    //@PersistenceUnit(name = "prod")
    EntityManager em;

    public void addSqlScript(SqlScript entity){
        em.persist(entity);
    }

    public SqlScript findById(Long id){
        var query = em.createQuery("select ss from SqlScript ss where ss.id = :id", SqlScript.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }

    public List<SqlScript> findAllSqlScripts(){
        var query = em.createQuery("select ss from SqlScript ss", SqlScript.class);
        return query.getResultList();
    }
}
