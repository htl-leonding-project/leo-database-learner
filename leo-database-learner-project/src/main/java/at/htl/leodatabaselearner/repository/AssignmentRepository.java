package at.htl.leodatabaselearner.repository;

import at.htl.leodatabaselearner.entity.Assignment;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class AssignmentRepository implements PanacheRepository<Assignment> {

    public void addAssignment(Assignment entity) {
        getEntityManager().merge(entity);
    }

    public List<Assignment> findAllAssignments(){
        var query = getEntityManager().createQuery("Select a from Assignment a", Assignment.class);
        return query.getResultList();
    }


}
