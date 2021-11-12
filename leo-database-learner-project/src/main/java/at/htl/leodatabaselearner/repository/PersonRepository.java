package at.htl.leodatabaselearner.repository;

import at.htl.leodatabaselearner.entity.DataModel;
import at.htl.leodatabaselearner.entity.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

    public void addPerson(Person entity) {
        getEntityManager().merge(entity);
    }

    public List<Person> findAllPerson() {
        var query = getEntityManager().createQuery("Select p from Person p", Person.class);
        return query.getResultList();
    }

    public Person findById(Long id) {
        return find("id", id).firstResult();
    }

}
