package at.htl.leodatabaselearner.repository;

import at.htl.leodatabaselearner.entity.DataModel;
import at.htl.leodatabaselearner.entity.SqlScript;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class SqlScriptRepository {

    @Inject
    EntityManager em;

    public void addSqlScript(SqlScript entity){
        em.persist(entity);
    }

}
