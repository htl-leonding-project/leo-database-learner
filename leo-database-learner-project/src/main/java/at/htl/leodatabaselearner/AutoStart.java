package at.htl.leodatabaselearner;

import at.htl.leodatabaselearner.boundary.ExerciseSqlEndpoint;
import at.htl.leodatabaselearner.entity.*;
import at.htl.leodatabaselearner.repository.*;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Scanner;

@ApplicationScoped
public class AutoStart {

    @Inject
    TeacherRepository teacherRepository;

    @Inject
    StudentRepository studentRepository;

    @Inject
    DataModelRepository dataModelRepository;

    @Inject
    SqlScriptRepository sqlScriptRepository;

    @Inject
    ExercisePackageRepository exercisePackageRepository;

    @Inject
    QuestionRepository questionRepository;

    @Inject
    EvaluationRepository evaluationRepository;

    @Inject
    AssignmentRepository assignmentRepository;


    @Transactional
    void startup(@Observes StartupEvent event) {
        System.out.println("It works!");
        Teacher t1 = new Teacher("vani","prim","1234");
        Teacher t2 = new Teacher("madschi","stei","1234");

        Student s1 = new Student("Bernd","test","1234","test");

        DataModel dataModel = new DataModel("LeodatabaseLearner", t1, "comment1");

        SqlScript sqlScript = new SqlScript(dataModel,"CREATE TABLE DOGSCHOOL(id number not null, name varchar2(255), location varchar2(255), zip number ",
        "DROP TABLE DOGSCHOOL;",
        "INSERT INTO DOGSCHOOL(id, name, location, zip) VALUES (1, 'Hundeschule Mayr', 'Leonding', 4060)");

        ExercisePackage exercisePackage = new ExercisePackage("Datamodel 1",dataModel);

        Question question = new Question("1. Question","text01", "Select d from IT160205.DEPT d", 2,exercisePackage);

        Evaluation evaluation = new Evaluation(10,s1,question);

        Assignment assignment = new Assignment(s1,exercisePackage);

        teacherRepository.addTeacher(t1);
        teacherRepository.addTeacher(t2);
        studentRepository.addStudent(s1);
        dataModelRepository.addDataModel(dataModel);
        sqlScriptRepository.addSqlScript(sqlScript);
        exercisePackageRepository.addExercisePackage(exercisePackage);
        questionRepository.addQuestion(question);
        evaluationRepository.addEvaluation(evaluation);
        assignmentRepository.addAssignment(assignment);

    }
}
