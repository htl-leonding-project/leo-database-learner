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

    // @Inject
    //@PersistenceUnit(name = "prod")

    public void addSqlScript(SqlScript entity){
        getEntityManager().merge(entity);
    }

    public SqlScript findById(Long id){
        return find("id", id).firstResult();
    }

    public List<SqlScript> findAllSqlScripts(){
        var query = getEntityManager().createQuery("select ss from SqlScript ss", SqlScript.class);
        return query.getResultList();
    }
}
