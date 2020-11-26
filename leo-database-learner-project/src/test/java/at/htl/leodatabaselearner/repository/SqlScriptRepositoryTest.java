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

    @Test
    public void addSqlScript() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {

        Person person = new Person("Susi","Snow", Role.ADMIN);
        DataModel dataModel = new DataModel("Datamodel2", person,"comment2");

        tx.begin();
        personRepo.addPerson(person);
        dataModelRepo.addDataModel(dataModel);
        tx.commit();

        SqlScript sqlScript = new SqlScript(dataModel,"createScript1","dropScript1", "insertScript1");
        Table sqlScriptTable = new Table(getDataSource(), "sqlscript");
        output(sqlScriptTable).toConsole();

        tx.begin();
        sqlScriptRepo.addSqlScript(sqlScript);
        tx.commit();

        sqlScriptTable = new Table(getDataSource(), "sqlscript");
        output(sqlScriptTable).toConsole();

        assertThat(sqlScript.getId()).isEqualTo(2L);

    }

    @Test
    public void findById(){

        SqlScript foundSqlScript = sqlScriptRepo.findById(1L);

        Table sqlScriptTable = new Table(getDataSource(), "sqlscript");
        output(sqlScriptTable).toConsole();

        assertThat(foundSqlScript.getCreateScript()).isEqualTo("createScript");


    }

    @Test
    public void findAll() {

        List<SqlScript> foundPersons = sqlScriptRepo.findAll();

        Table personTable = new Table(getDataSource(), "sqlscript");
        output(personTable).toConsole();

        assertThat(foundPersons.size()).isEqualTo(1);
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