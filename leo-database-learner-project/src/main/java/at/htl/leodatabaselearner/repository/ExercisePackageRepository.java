package at.htl.leodatabaselearner.repository;

import at.htl.leodatabaselearner.entity.Assignment;
import at.htl.leodatabaselearner.entity.ExercisePackage;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ExercisePackageRepository implements PanacheRepository<ExercisePackage> {

    public void addExercisePackage(ExercisePackage entity){
        getEntityManager().merge(entity);
    }

    public List<ExercisePackage> findAllExercisePackages(){
        var query = getEntityManager().createQuery("Select ep from ExercisePackage ep", ExercisePackage.class);
        return query.getResultList();
    }

}
