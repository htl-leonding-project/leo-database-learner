package at.htl.leodatabaselearner.repository;

import at.htl.leodatabaselearner.entity.DataModel;
import at.htl.leodatabaselearner.entity.Person;
import at.htl.leodatabaselearner.entity.Role;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;
import org.postgresql.ds.PGSimpleDataSource;

import javax.inject.Inject;
import javax.sql.DataSource;
import javax.transaction.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.db.output.Outputs.output;

@QuarkusTest
class DataModelRepositoryTest {
    @Inject
    DataModelRepository dataModelRepo;

    @Inject
    PersonRepository personRepo;

    @Inject
    UserTransaction tx;

    @Test
    public void addDataModel() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {

        Person person = new Person("Susi", "Snow", Role.ADMIN);

        tx.begin();
        personRepo.addPerson(person);
        tx.commit();

        DataModel dataModel = new DataModel("Marah", person, "Hi");
        Table datamodelTable = new Table(getDataSource(), "datamodel");
        output(datamodelTable).toConsole();

        tx.begin();
        dataModelRepo.addDataModel(dataModel);
        tx.commit();

        datamodelTable = new Table(getDataSource(), "datamodel");
        output(datamodelTable).toConsole();

        assertThat(dataModel.getId()).isEqualTo(1L);
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
