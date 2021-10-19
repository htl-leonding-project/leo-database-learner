package at.htl.leodatabaselearner.repository;

import at.htl.leodatabaselearner.entity.Evaluation;
import at.htl.leodatabaselearner.entity.Student;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.List;

public class EvaluationRepository implements PanacheRepository<Evaluation> {

    public void addEvaluation(Evaluation entity){
        getEntityManager().merge(entity);
    }

}
