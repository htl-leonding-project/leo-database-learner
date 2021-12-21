package at.htl.leodatabaselearner.repository;

import at.htl.leodatabaselearner.entity.Teacher;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;


@ApplicationScoped
public class TeacherRepository implements PanacheRepository<Teacher> {

    public Teacher addTeacher(Teacher entity) {
        return getEntityManager().merge(entity);
    }

    public List<Teacher> findAllTeachers(){
        var query = getEntityManager().createQuery("Select t from Teacher t", Teacher.class);
        return query.getResultList();
    }
}
