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
import java.util.ArrayList;
import java.util.List;
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
        t1 = teacherRepository.addTeacher(t1);

        Teacher t2 = new Teacher("madschi","stei","1234");
        t2 = teacherRepository.addTeacher(t2);

        Student s1 = new Student("Bernd","test","1234","test");
        s1 = studentRepository.addStudent(s1);

        DataModel dataModel = new DataModel("Hundeschule", t1, "Das Modell zeigt eine Hundeschule mit seinen jeweiligen Attributen");
        dataModel = dataModelRepository.addDataModel(dataModel);

        ExercisePackage dogSchoolPackage = new ExercisePackage("Hundeschule",dataModel);
        dogSchoolPackage = exercisePackageRepository.addExercisePackage(dogSchoolPackage);

        SqlScript dogSchoolSqlScript = new SqlScript(dataModel,"CREATE TABLE DOGSCHOOL(id number not null, name varchar2(255), location varchar2(255), zip number ",
        "DROP TABLE DOGSCHOOL;",
        "INSERT INTO DOGSCHOOL(id, name, location, zip) VALUES (1, 'Hundeschule Mayr', 'Leonding', 4060)");

        dogSchoolSqlScript = sqlScriptRepository.addSqlScript(dogSchoolSqlScript);

        Question dogSchoolQuestion1 = new Question("1. Übung - Select - Easy","Geben Sie alle Daten der Tabelle Dogschool aus", "Select * from Dogschool", 1,dogSchoolPackage);
        dogSchoolQuestion1 = questionRepository.addQuestion(dogSchoolQuestion1);
        Question dogSchoolQuestion2 = new Question("2. Übung - Select - Middle","Geben Sie den Namen der Hundeschule jener aus dessen Sitz in Leonding ist.", "Select ds.name from Dogschool ds", 2,dogSchoolPackage);
        dogSchoolQuestion2 = questionRepository.addQuestion(dogSchoolQuestion2);
        Question dogSchoolQuestion3 = new Question("3. Übung - Select - Hard","Geben Sie jene Daten der Tabelle Dogschool aus, ", "Select * from Dogschool", 3,dogSchoolPackage);
        dogSchoolQuestion3 = questionRepository.addQuestion(dogSchoolQuestion3);

        Evaluation evaluation = new Evaluation(10,s1,dogSchoolQuestion1);
        evaluation = evaluationRepository.addEvaluation(evaluation);

        Assignment assignment = new Assignment(s1,dogSchoolPackage);
        assignment = assignmentRepository.addAssignment(assignment);


        DataModel empDatamodel = new DataModel("Emp", t1, "Das Modell zeigt die EMP Tabelle mit seinen jeweiligen Attributen");
        empDatamodel = dataModelRepository.addDataModel(empDatamodel);

        ExercisePackage empPackage = new ExercisePackage("EMP",empDatamodel);
        empPackage = exercisePackageRepository.addExercisePackage(empPackage);

        SqlScript empSqlScript = new SqlScript(empDatamodel,"CREATE TABLE EMP (\n" +
                " EMPNO               NUMBER(4) CONSTRAINT EMP_PRIMARY_KEY PRIMARY KEY , \n" +
                " ENAME               VARCHAR2(10),\n" +
                " JOB                 VARCHAR2(9),\n" +
                " MGR                 NUMBER(4) CONSTRAINT EMP_SELF_KEY REFERENCES EMP (EMPNO),\n" +
                " HIREDATE            DATE,\n" +
                " SAL                 NUMBER(7,2),\n" +
                " COMM                NUMBER(7,2),\n" +
                " DEPTNO              NUMBER(2) NOT NULL CONSTRAINT EMP_FOREIGN_KEY REFERENCES DEPT (DEPTNO));\n",
                "DROP TABLE EMP;",
                "INSERT INTO EMP VALUES (7369,'SMITH','CLERK',7902,TO_DATE('17/12/1980','DD/MM/YYYY'),800,NULL,20);\n" +
                        "INSERT INTO EMP VALUES (7499,'ALLEN','SALESMAN',7698,TO_DATE('20/02/1981','DD/MM/YYYY'),1600,300,30);\n");
        empSqlScript = sqlScriptRepository.addSqlScript(empSqlScript);


        Question empQuestion1 = new Question("1. Übung - Select - Easy","Geben Sie alle Daten der Tabelle EMP aus", "Select * from emp", 1,empPackage);
        empQuestion1 = questionRepository.addQuestion(empQuestion1);
        Question empQuestion2 = new Question("2. Übung - OrderBy - Middle","Geben Sie alle Daten der Tabelle EMP aus geordnet nach der empno.", "Select ds.name from Dogschool ds", 2,empPackage);
        empQuestion2 = questionRepository.addQuestion(empQuestion2);
        Question empQuestion3 = new Question("3. Übung - Select - Hard","Geben Sie jene Daten der Tabelle EMP aus, ", "Select * from EMP", 3,empPackage);
        empQuestion3 = questionRepository.addQuestion(empQuestion3);



        DataModel deptdataModel = new DataModel("Hundeschule", t1, "Das Modell zeigt eine Hundeschule mit seinen jeweiligen Attributen");
        deptdataModel = dataModelRepository.addDataModel(deptdataModel);

        ExercisePackage deptPackage = new ExercisePackage("DEPT",deptdataModel);
        deptPackage = exercisePackageRepository.addExercisePackage(deptPackage);


        SqlScript deptSqlScript = new SqlScript(deptdataModel,"CREATE TABLE DEPT (\n" +
                " DEPTNO              NUMBER(2) CONSTRAINT DEPT_PRIMARY_KEY PRIMARY KEY,\n" +
                " DNAME               VARCHAR2(14),\n" +
                " LOC                 VARCHAR2(13));",
                "DROP TABLE DEPT;",
                "INSERT INTO DEPT VALUES (10,'ACCOUNTING','NEW YORK');\n" +
                        "INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');\n" +
                        "INSERT INTO DEPT VALUES (30,'SALES','CHICAGO');\n" +
                        "INSERT INTO DEPT VALUES (40,'OPERATIONS','BOSTON');");
        deptSqlScript = sqlScriptRepository.addSqlScript(deptSqlScript);

        Question deptQuestion1 = new Question("1. Übung - Select - Easy","Geben Sie alle Daten der Tabelle DEPT aus", "SELECT * FROM DEPT;", 1,deptPackage);
        deptQuestion1 = questionRepository.addQuestion(deptQuestion1);
        Question deptQuestion2 = new Question("2. Übung - OrderBy - Middle","Geben Sie alle Daten Tabelle DEPT aus geordnet nach der DEPTNO.", "SELECT * FROM DEPT ORDER BY DEPTNO;", 2,deptPackage);
        deptQuestion2 = questionRepository.addQuestion(deptQuestion2);
        Question deptQuestion3 = new Question("3. Übung - Select - Hard","Geben Sie jene Daten der Tabelle DEPT aus, ", "Select * from DEPT", 3,deptPackage);
        deptQuestion3 = questionRepository.addQuestion(deptQuestion3);


    }
}
