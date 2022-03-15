package at.htl.leodatabaselearner.repository;

import at.htl.leodatabaselearner.entity.Assignment;
import at.htl.leodatabaselearner.entity.ExercisePackage;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ExercisePackageRepository implements PanacheRepository<ExercisePackage> {

    public ExercisePackage addExercisePackage(ExercisePackage entity){
        return getEntityManager().merge(entity);
    }

    public List<ExercisePackage> findAllExercisePackages(){
        var query = getEntityManager().createQuery("Select ep from ExercisePackage ep", ExercisePackage.class);
        return query.getResultList();
    }

    public ExercisePackage findExercisePackageByName(String name){
        var query = getEntityManager()
                .createQuery("Select ep from ExercisePackage ep where ep.name =:name", ExercisePackage.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    public ExercisePackage findExercisePackageById(Long id){
        var query = getEntityManager().createQuery("Select ep from ExercisePackage  ep where ep.id =:id", ExercisePackage.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }


}
