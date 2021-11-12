//package at.htl.leodatabaselearner.repository;
//
//import at.htl.leodatabaselearner.entity.DataModel;
//import at.htl.leodatabaselearner.entity.Person;
//import at.htl.leodatabaselearner.entity.Role;
//import io.quarkus.test.junit.QuarkusTest;
//import org.assertj.db.type.Table;
//import org.junit.jupiter.api.*;
//import org.postgresql.ds.PGSimpleDataSource;
//
//import javax.inject.Inject;
//import javax.sql.DataSource;
//import javax.transaction.*;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.db.output.Outputs.output;
//
//@QuarkusTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class DataModelRepositoryTest {
//    @Inject
//    DataModelRepository dataModelRepo;
//
//    @Inject
//    PersonRepository personRepo;
//
//
//    @Test
//    @Order(1)
//    @Transactional
//    public void addDataModel() {
//
//        Person person = new Person("Susi", "Snow", Role.ADMIN);
//
//        personRepo.addPerson(person);
//
//        DataModel dataModel = new DataModel("Test02", person, "comment2");
//        Table datamodelTable = new Table(getDataSource(), "datamodel");
//        output(datamodelTable).toConsole();
//
//        dataModelRepo.addDataModel(dataModel);
//
//        datamodelTable = new Table(getDataSource(), "datamodel");
//        output(datamodelTable).toConsole();
//
//        assertThat(dataModel.getId()).isEqualTo(7L);
//
//    }
//
//    @Test
//    @Order(2)
//    public void findById() {
//
//        DataModel foundDataModel = dataModelRepo.findById(2L);
//
//        Table datamodelTable = new Table(getDataSource(), "datamodel");
//        output(datamodelTable).toConsole();
//
//        assertThat(foundDataModel.name).isEqualTo("LeodatabaseLearner");
//
//    }
//
//    @Test
//    @Order(0)
//    public void findAll() {
//
//        List<DataModel> foundDataModels = dataModelRepo.findAll().list();
//
//        Table personTable = new Table(getDataSource(), "datamodel");
//        output(personTable).toConsole();
//
//        assertThat(foundDataModels.size()).isEqualTo(6);
//
//    }
//
//    @Test
//    @Order(3)
//    public void findByOwner() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
//        Person person = new Person("Susi", "Snow", Role.ADMIN);
//
//        personRepo.addPerson(person);
//
//        DataModel dataModel = new DataModel("Test02", person, "comment2");
//        Table datamodelTable = new Table(getDataSource(), "datamodel");
//        output(datamodelTable).toConsole();
//
//        dataModelRepo.addDataModel(dataModel);
//
//        List<DataModel> foundDataModels = dataModelRepo.findByOwner(person);
//
//        Table personTable = new Table(getDataSource(), "datamodel");
//        output(personTable).toConsole();
//
//        assertThat(foundDataModels.size()).isEqualTo(0);
//
//    }
//
//    static final String DATABASE = "postgres";
//    static final String USERNAME = "postgres";
//    static final String PASSWORD = "app";
//    public static final String URL = "jdbc:postgresql://localhost:5432/postgres";
//
//    public static DataSource getDataSource() {
//        PGSimpleDataSource dataSource = new PGSimpleDataSource();
//        dataSource.setDatabaseName(DATABASE);
//        dataSource.setUser(USERNAME);
//        dataSource.setPassword(PASSWORD);
//        return dataSource;
//    }
//
//}
