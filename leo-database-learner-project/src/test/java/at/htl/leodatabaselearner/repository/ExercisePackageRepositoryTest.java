package at.htl.leodatabaselearner.repository;

import at.htl.leodatabaselearner.entity.*;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class ExercisePackageRepositoryTest {
    @Inject
    ExercisePackageRepository exercisePackageRepository;

    @Test
    @Transactional
    void save(){
        Teacher teacher = new Teacher("Fritz", "Fliege", "test1234");
        DataModel dataModel = new DataModel("Leodatabaselearner", teacher, "comment");
        ExercisePackage exercisePackage = new ExercisePackage("ExercisePackage", dataModel);

        int sizeBeforeSaving = exercisePackageRepository.findAllExercisePackages().size();

        exercisePackage = exercisePackageRepository.addExercisePackage(exercisePackage);

        assertThat(exercisePackageRepository.listAll().size()).isEqualTo(sizeBeforeSaving + 1);
        assertThat(exercisePackageRepository.listAll()).contains(exercisePackage);
    }
}
