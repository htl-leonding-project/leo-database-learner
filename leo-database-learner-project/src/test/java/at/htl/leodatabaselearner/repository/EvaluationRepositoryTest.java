package at.htl.leodatabaselearner.repository;

import at.htl.leodatabaselearner.entity.*;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class EvaluationRepositoryTest {

    @Inject
    EvaluationRepository evaluationRepository;

    @Test
    @Transactional
    void save(){
        Student student = new Student("Franz","Huber","passme123","5AHITM");
        Teacher teacher = new Teacher("Fritz", "Fliege", "test1234");
        DataModel dataModel = new DataModel("Leodatabaselearner", teacher, "comment");
        ExercisePackage exercisePackage = new ExercisePackage("ExercisePackage", dataModel);
        Question question = new Question("","","",2, exercisePackage);
        Evaluation evaluation = new Evaluation(10, student, question);

        int sizeBeforeSaving = (int) evaluationRepository.findAll().count();

        evaluation = evaluationRepository.addEvaluation(evaluation);

        assertThat(evaluationRepository.listAll().size()).isEqualTo(sizeBeforeSaving + 1);
        assertThat(evaluationRepository.listAll()).contains(evaluation);
    }
}
