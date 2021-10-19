package at.htl.leodatabaselearner.boundary;

import at.htl.leodatabaselearner.entity.Person;
import at.htl.leodatabaselearner.entity.Student;
import at.htl.leodatabaselearner.repository.PersonRepository;
import at.htl.leodatabaselearner.repository.StudentRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/student")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentEndpoint {

    @Inject
    StudentRepository studentRepository;

    @POST
    @Path("add_student")
    @Transactional
    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    @GET
    @Path("get_all")
    public List<Student> getAllStudents() {
        return studentRepository.findAllStudents();
    }

    @GET
    @Path("getbyid/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Student getById(@PathParam("id") Long id) {
        return this.studentRepository.findById(id);
    }

}
