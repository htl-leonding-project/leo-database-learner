package at.htl.leodatabaselearner.repository;

import at.htl.leodatabaselearner.entity.DataModel;
import at.htl.leodatabaselearner.entity.Person;
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

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DataModelRepositoryTest {
    @Inject
    DataModelRepository dataModelRepo;

    @Inject
    PersonRepository personRepo;

    @Inject
    UserTransaction tx;

    @Test
    @Order(1)
    public void addDataModel() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {

        Person person = new Person("Susi", "Snow", Role.ADMIN);

        tx.begin();
        personRepo.addPerson(person);
        tx.commit();

        DataModel dataModel = new DataModel("Test02", person, "comment2");
        Table datamodelTable = new Table(getDataSource(), "datamodel");
        output(datamodelTable).toConsole();

        tx.begin();
        dataModelRepo.addDataModel(dataModel);
        tx.commit();

        datamodelTable = new Table(getDataSource(), "datamodel");
        output(datamodelTable).toConsole();

        assertThat(dataModel.getId()).isEqualTo(2L);


    }

    @Test
    @Order(2)
    public void findById() {

        DataModel foundDataModel = dataModelRepo.findById(2L);

        Table datamodelTable = new Table(getDataSource(), "datamodel");
        output(datamodelTable).toConsole();

        assertThat(foundDataModel.getName()).isEqualTo("Test02");


    }

    @Test
    @Order(0)
    public void findAll() {

        List<DataModel> foundDataModels = dataModelRepo.findAll();

        Table personTable = new Table(getDataSource(), "datamodel");
        output(personTable).toConsole();

        assertThat(foundDataModels.size()).isEqualTo(1);

    }

//    @Test
//    @Order(3)
//    public void findByOwner() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException{
//        Person person = new Person("Susi", "Snow", Role.ADMIN);
//
//        tx.begin();
//        personRepo.addPerson(person);
//        tx.commit();
//
//        DataModel dataModel = new DataModel("Test02", person, "comment2");
//        Table datamodelTable = new Table(getDataSource(), "datamodel");
//        output(datamodelTable).toConsole();
//
//        tx.begin();
//        dataModelRepo.addDataModel(dataModel);
//        tx.commit();
//
//        List<DataModel> foundDataModels = dataModelRepo.findByOwner(person);
//
//        Table personTable = new Table(getDataSource(), "datamodel");
//        output(personTable).toConsole();
//
//        assertThat(foundDataModels.size()).isEqualTo(2);
//
//    }

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
