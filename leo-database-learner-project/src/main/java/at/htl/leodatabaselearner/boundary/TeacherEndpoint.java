package at.htl.leodatabaselearner.boundary;

import at.htl.leodatabaselearner.entity.Student;
import at.htl.leodatabaselearner.entity.Teacher;
import at.htl.leodatabaselearner.repository.StudentRepository;
import at.htl.leodatabaselearner.repository.TeacherRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/teacher")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeacherEndpoint {

    @Inject
    TeacherRepository teacherRepository;

    @POST
    @Path("add_teacher")
    @Transactional
    public void addTeacher(Teacher teacher) {
        teacherRepository.addTeacher(teacher);
    }

    @GET
    @Path("get_all")
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAllTeachers();
    }

    @GET
    @Path("getbyid/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Teacher getById(@PathParam("id") Long id) {
        return teacherRepository.findById(id);
    }

}
