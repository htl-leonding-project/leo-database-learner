package at.htl.leodatabaselearner;

import at.htl.leodatabaselearner.entity.Person;
import at.htl.leodatabaselearner.entity.Role;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class AutoStart {

    @Inject
    EntityManager em;

    @Transactional
    void startup(@Observes StartupEvent event) {
        System.out.println("It works!");
        Person p1 = new Person("vani","prim", Role.ADMIN);
        Person p2 = new Person("madschi","stei", Role.ADMIN);
        em.persist(p1);
        em.persist(p2);
    }

}
