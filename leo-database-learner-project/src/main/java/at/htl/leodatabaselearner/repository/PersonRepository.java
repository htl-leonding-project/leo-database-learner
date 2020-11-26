package at.htl.leodatabaselearner.repository;

import at.htl.leodatabaselearner.entity.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PersonRepository {

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

    public List<Person> findAll(){
        var query = em.createQuery("select p.id, p.firstName, p.lastName, p.role from Person p", Person.class);
        return query.getResultList();
    }

}
