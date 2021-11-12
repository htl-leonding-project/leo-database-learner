//package at.htl.leodatabaselearner.repository;
//
//import at.htl.leodatabaselearner.entity.*;
//import io.quarkus.test.junit.QuarkusTest;
//import org.assertj.db.type.Table;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.postgresql.ds.PGSimpleDataSource;
//
//import javax.inject.Inject;
//import javax.sql.DataSource;
//import javax.transaction.*;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.db.output.Outputs.output;
//import static org.junit.jupiter.api.Assertions.*;
//
//@QuarkusTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class SqlScriptRepositoryTest {
//
//    @Inject
//    SqlScriptRepository sqlScriptRepo;
//
//    @Inject
//    PersonRepository personRepo;
//
//    @Inject
//    DataModelRepository dataModelRepo;
//
//
//    @Test
//    @Order(1)
//    @Transactional
//    public void addSqlScript() {
//
//        Person person = new Person("Susi","Snow", Role.ADMIN);
//        DataModel dataModel = new DataModel("Datamodel2", person,"comment2");
//
//        personRepo.addPerson(person);
//        dataModelRepo.addDataModel(dataModel);
//
//        SqlScript sqlScript = new SqlScript(dataModel,"createScript1","dropScript1", "insertScript1");
//        Table sqlScriptTable = new Table(getDataSource(), "sqlscript");
//        output(sqlScriptTable).toConsole();
//
//        sqlScriptRepo.addSqlScript(sqlScript);
//
//        sqlScriptTable = new Table(getDataSource(), "sqlscript");
//        output(sqlScriptTable).toConsole();
//
//        assertThat(sqlScript.getId()).isEqualTo(2L);
//
//    }
//
//    @Test
//    @Order(2)
//    public void findById(){
//
//        SqlScript foundSqlScript = sqlScriptRepo.findById(1L);
//
//        Table sqlScriptTable = new Table(getDataSource(), "sqlscript");
//        output(sqlScriptTable).toConsole();
//
//        assertThat(foundSqlScript.createScript).isEqualTo("CREATE TABLE STUDENT(\n" +
//                "     id number not null,\n" +
//                "     firstName varchar2(255) not null,\n" +
//                "     lastName varchar2(255) not null,\n" +
//                ");");
//
//
//    }
//
////    @Test
////    @Order(0)
////    public void findAll() {
////
////        List<SqlScript> foundPersons = sqlScriptRepo.findAll();
////
////        Table personTable = new Table(getDataSource(), "sqlscript");
////        output(personTable).toConsole();
////
////        assertThat(foundPersons.size()).isEqualTo(1);
////    }
//
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
//
//}
