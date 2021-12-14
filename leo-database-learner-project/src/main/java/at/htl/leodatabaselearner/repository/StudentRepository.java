package at.htl.leodatabaselearner.repository;

import at.htl.leodatabaselearner.entity.Student;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class StudentRepository implements PanacheRepository<Student> {

    public void addStudent(Student entity) {
        getEntityManager().merge(entity);
    }

    public List<Student> findAllStudents(){
        var query = getEntityManager().createQuery("Select st from Student st", Student.class);
        return query.getResultList();
    }

    public List<Student> findAllStudentsByClassname(String classname){
        var query = getEntityManager().createQuery("Select st from Student st " +
                "where st.classname = :classname", Student.class);
        query.setParameter("classname", classname);
        return query.getResultList();
    }

}
