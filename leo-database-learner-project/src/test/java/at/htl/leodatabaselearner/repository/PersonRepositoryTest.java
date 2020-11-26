package at.htl.leodatabaselearner.repository;

import at.htl.leodatabaselearner.entity.Person;
import at.htl.leodatabaselearner.entity.Role;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.postgresql.ds.PGSimpleDataSource;


import javax.inject.Inject;
import javax.sql.DataSource;
import javax.transaction.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.db.output.Outputs.output;


@QuarkusTest
public class PersonRepositoryTest {

    @Inject
    PersonRepository repo;

    @Inject
    UserTransaction tx;

    @Test
    public void addPerson() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {

        Person person = new Person("Susi","Snow", Role.ADMIN);
        Table personTable = new Table(getDataSource(), "person");
        output(personTable).toConsole();

        tx.begin();
        repo.addPerson(person);
        tx.commit();

        personTable = new Table(getDataSource(), "person");
        output(personTable).toConsole();

        assertThat(person.getId()).isEqualTo(3L);

    }

    @Test
    public void findById(){

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
