package at.htl.leodatabaselearner.repository;

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

    @Inject
    EntityManager em;

    public void addPerson(Person entity){
            em.persist(entity);
    }

    public Person findById(Long id){
        var query = em.createQuery("select p from Person p where p.id = :id", Person.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }

    public List<Person> findAllPerson(){
        var query = em.createQuery("select p from Person p", Person.class);
        return query.getResultList();
    }

}
