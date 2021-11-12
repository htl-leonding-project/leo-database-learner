package at.htl.leodatabaselearner.boundary;

import at.htl.leodatabaselearner.ExerciseSqlRepository;
import at.htl.leodatabaselearner.entity.ExercisePackage;
import at.htl.leodatabaselearner.entity.Teacher;
import at.htl.leodatabaselearner.repository.ExercisePackageRepository;
import at.htl.leodatabaselearner.repository.TeacherRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/exercisePackage")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExercisePackageEndpoint {

    @Inject
    ExercisePackageRepository exercisePackageRepository;

    @POST
    @Path("add_exercisePackage")
    @Transactional
    public void addExercisePackage(ExercisePackage exercisePackage) { exercisePackageRepository.addExercisePackage(exercisePackage);
    }

    @GET
    @Path("get_all")
    public List<ExercisePackage> getAllExercisePackage() {
        return exercisePackageRepository.findAllExercisePackages();
    }

}
