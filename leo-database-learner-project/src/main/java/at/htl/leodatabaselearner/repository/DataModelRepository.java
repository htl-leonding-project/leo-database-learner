package at.htl.leodatabaselearner.repository;


import at.htl.leodatabaselearner.entity.DataModel;
import at.htl.leodatabaselearner.entity.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class DataModelRepository implements PanacheRepository<DataModel> {

    public void addDataModel(DataModel entity){
        getEntityManager().merge(entity);
    }

    public List<DataModel> findAllModels(){
        var query = getEntityManager().createQuery("Select dm from DataModel dm", DataModel.class);
        return query.getResultList();
    }

    public DataModel findById(Long id){
        return find("id", id).firstResult();
    }

    public List<DataModel> findByOwner(Person person){
        var query = getEntityManager().createQuery("select dm from DataModel dm" +
                " where dm.owner = :owner", DataModel.class);
        query.setParameter("owner", person.getId());
        return query.getResultList();
    }
}
