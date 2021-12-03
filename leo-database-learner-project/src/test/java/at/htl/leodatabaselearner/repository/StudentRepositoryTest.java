package at.htl.leodatabaselearner.repository;

import at.htl.leodatabaselearner.entity.Student;
import at.htl.leodatabaselearner.entity.Teacher;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@QuarkusTest
class StudentRepositoryTest {

    @Inject
    StudentRepository studentRepository;


    @Test
    @Transactional
    void save(){
        Student student = new Student("Franz","Huber","passme123","5AHITM");
        int sizeBeforeSaving = studentRepository.findAllStudents().size();

        student = studentRepository.addStudent(student);

        assertThat(studentRepository.listAll().size()).isEqualTo(sizeBeforeSaving + 1);
        assertThat(studentRepository.listAll()).contains(student);
    }

    @Test
    @Transactional
    void findAllStudentsByClassname() {

        Student student = new Student("Susi","Snow","test123","5AHITM");
        student = studentRepository.addStudent(student);

        List<Student> foundStudents = studentRepository.findAllStudentsByClassname(student.classname);

        assertThat(foundStudents).contains(student);
    }

}
