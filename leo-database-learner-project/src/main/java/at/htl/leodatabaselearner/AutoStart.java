package at.htl.leodatabaselearner;

import at.htl.leodatabaselearner.entity.*;
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

        DataModel dataModel = new DataModel("Datamodel01", p1, "comment1");

        //Question question = new Question("text01", "Select d from IT160205.DEPT d", 2, dataModel, p2);
        Question question = new Question("text01", "Select p from Person p order by p.firstName", 2, dataModel, p2);

        SqlScript sqlScript = new SqlScript(dataModel, "createScript", "dropScript", "insertScript");

        em.persist(p1);
        em.persist(p2);
        em.persist(dataModel);
        em.persist(question);
        em.persist(sqlScript);
    }

}
