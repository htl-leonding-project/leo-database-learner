package at.htl.leodatabaselearner.repository;

import at.htl.leodatabaselearner.entity.Teacher;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
class TeacherRepositoryTest {



    @Inject
    TeacherRepository teacherRepository;


    @Test
    @Transactional
    void save(){
        Teacher teacher = new Teacher();
        int sizeBeforeSaving = teacherRepository.findAllTeachers().size();

        teacher = teacherRepository.addTeacher(teacher);

        assertThat(teacherRepository.listAll().size()).isEqualTo(sizeBeforeSaving + 1);
        assertThat(teacherRepository.listAll()).contains(teacher);


    }

    @Test
    @Transactional
    void findAllTeachers() {
        Teacher teacher = new Teacher("Fritz", "Hauser", "pass1234");
        teacherRepository.addTeacher(teacher);

        List<Teacher> foundTeachers = teacherRepository.findAllTeachers();

        assertThat(foundTeachers).isNotNull();
    }

}
