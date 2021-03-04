package at.htl.leodatabaselearner;

import at.htl.leodatabaselearner.boundary.ExerciseSqlEndpoint;
import at.htl.leodatabaselearner.entity.*;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Scanner;

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
        Question question1 = new Question("text01", "Select p from Person p order by p.firstName", 2, dataModel, p2);
        Question question2 = new Question("text02", "Select * from dept d order by d.deptno",2, dataModel, p2);
        Question question3 = new Question("text03", "Select e.ename from emp e order by e.ename",2, dataModel, p2);
        Question question4 = new Question("text04", "Select * from salgrade",1, dataModel, p2);


      SqlScript sqlScript = new SqlScript(dataModel, "createScript", "dropScript", "insertScript");

        em.persist(p1);
        em.persist(p2);
        em.persist(dataModel);
        em.persist(question1);
        em.persist(question2);
        em.persist(question3);
        em.persist(question4);
        em.persist(sqlScript);

    }

}
