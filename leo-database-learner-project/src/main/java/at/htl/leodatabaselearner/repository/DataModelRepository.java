package at.htl.leodatabaselearner.repository;


import at.htl.leodatabaselearner.entity.DataModel;
import at.htl.leodatabaselearner.entity.Person;
import at.htl.leodatabaselearner.entity.Question;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import java.util.List;

@ApplicationScoped
public class DataModelRepository {

    @Inject
    EntityManager em;

    public void addDataModel(DataModel entity){
        em.persist(entity);
    }

    public DataModel findById(Long id){
        var query = em.createQuery("select d from DataModel d where d.id = :id", DataModel.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }
    public List<DataModel> findAll(){
        var query = em.createQuery("select dm from DataModel dm", DataModel.class);
        return query.getResultList();
    }

    public List<DataModel> findByOwner(Person person){
        var query = em.createQuery("select dm from DataModel dm" +
                " where dm.owner = :owner", DataModel.class);
        query.setParameter("owner", person.getId());
        return query.getResultList();
    }
}
