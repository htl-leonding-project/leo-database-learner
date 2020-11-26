package at.htl.leodatabaselearner.repository;

import at.htl.leodatabaselearner.entity.*;
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
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class SqlScriptRepositoryTest {

    @Inject
    SqlScriptRepository sqlScriptRepo;

    @Inject
    PersonRepository personRepo;

    @Inject
    DataModelRepository dataModelRepo;

    @Inject
    UserTransaction tx;


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