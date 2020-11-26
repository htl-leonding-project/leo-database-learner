package at.htl.leodatabaselearner.repository;


import at.htl.leodatabaselearner.entity.DataModel;
import at.htl.leodatabaselearner.entity.Person;
import at.htl.leodatabaselearner.entity.Question;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class DataModelRepository {

    @Inject
    EntityManager em;

    public void addDataModel(DataModel entity){
        em.persist(entity);
    }

}
