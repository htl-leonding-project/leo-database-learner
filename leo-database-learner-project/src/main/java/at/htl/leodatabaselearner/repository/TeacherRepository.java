package at.htl.leodatabaselearner.repository;

import at.htl.leodatabaselearner.entity.Teacher;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;


@ApplicationScoped
public class TeacherRepository implements PanacheRepository<Teacher> {

    public void addTeacher(Teacher entity) {
        getEntityManager().merge(entity);
    }

    public List<Teacher> findAllTeachers(){
        var query = getEntityManager().createQuery("Select t from Teacher t", Teacher.class);
        return query.getResultList();
    }
}
