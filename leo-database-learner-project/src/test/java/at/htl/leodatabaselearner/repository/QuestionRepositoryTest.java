package at.htl.leodatabaselearner.repository;

import at.htl.leodatabaselearner.entity.DataModel;
import at.htl.leodatabaselearner.entity.Person;
import at.htl.leodatabaselearner.entity.Question;
import at.htl.leodatabaselearner.entity.Role;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.postgresql.ds.PGSimpleDataSource;

import javax.inject.Inject;
import javax.sql.DataSource;
import javax.transaction.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.db.output.Outputs.output;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class QuestionRepositoryTest {

    @Inject
    QuestionRepository questionRepo;

    @Inject
    PersonRepository personRepo;

    @Inject
    DataModelRepository dataModelRepo;

    @Inject
    UserTransaction tx;

    @Test
    public void addQuestion() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {

        Person person = new Person("Susi","Snow", Role.ADMIN);
        DataModel dataModel = new DataModel("Test01", person, "comment1");

        tx.begin();
        dataModelRepo.addDataModel(dataModel);
        personRepo.addPerson(person);
        tx.commit();

        Question question = new Question("text2", "select * from person", 2, dataModel, person);

        Table questionTable = new Table(getDataSource(), "question");
        output(questionTable).toConsole();

        tx.begin();
        questionRepo.addQuestion(question);
        tx.commit();

        questionTable = new Table(getDataSource(), "question");
        output(questionTable).toConsole();

        assertThat(question.getId()).isEqualTo(2L);
        tx.begin();
        tx.rollback();
    }
    @Test
    public void findById() {

        Question foundQuestion = questionRepo.findById(1L);

        Table personTable = new Table(getDataSource(), "question");
        output(personTable).toConsole();

        assertThat(foundQuestion.getText()).isEqualTo("text01");
    }

    @Test
    public void findAll() {

        List<Question> foundQuestions = questionRepo.findAll();

        Table personTable = new Table(getDataSource(), "question");
        output(personTable).toConsole();

        assertThat(foundQuestions.size()).isEqualTo(1);

    }

        static final String DATABASE = "db";
    static final String USERNAME = "app";
    static final String PASSWORD = "app";
    public static final String URL = "jdbc:postgresql://localhost:5432/db";

    public static DataSource getDataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setDatabaseName(DATABASE);
        dataSource.setUser(USERNAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }
}