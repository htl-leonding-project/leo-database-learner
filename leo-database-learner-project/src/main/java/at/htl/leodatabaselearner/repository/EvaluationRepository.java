package at.htl.leodatabaselearner.repository;

import at.htl.leodatabaselearner.entity.Evaluation;
import at.htl.leodatabaselearner.entity.ExercisePackage;
import at.htl.leodatabaselearner.entity.Student;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class EvaluationRepository implements PanacheRepository<Evaluation> {

    public Evaluation addEvaluation(Evaluation entity){
        return getEntityManager().merge(entity);
    }

}
