//package at.htl.leodatabaselearner.repository;
//
//import at.htl.leodatabaselearner.entity.Person;
//import at.htl.leodatabaselearner.entity.Role;
//import io.quarkus.test.junit.QuarkusTest;
//import org.assertj.db.type.Table;
//import org.junit.jupiter.api.*;
//import org.postgresql.ds.PGSimpleDataSource;
//
//
//import javax.inject.Inject;
//import javax.sql.DataSource;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.db.output.Outputs.output;
//
//
//@QuarkusTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class PersonRepositoryTest {
//
//    @Inject
//    PersonRepository personRepository;
//
//
//    @Test
//    @Order(1)
//    public void addPerson() {
//
//        Person person = new Person("Susi","Snow", Role.ADMIN);
//        Table personTable = new Table(getDataSource(), "person");
//        output(personTable).toConsole();
//
//        personRepository.addPerson(person);
//
//        personTable = new Table(getDataSource(), "person");
//        output(personTable).toConsole();
//
//        assertThat(person.getId()).isEqualTo(3L);
//
//    }
//
//    @Test
//    @Order(2)
//    public void findById(){
//
//        Person foundPerson = personRepository.findById(2L);
//
//        Table personTable = new Table(getDataSource(), "person");
//        output(personTable).toConsole();
//
//        assertThat(foundPerson.firstName).isEqualTo("madschi");
//        assertThat(foundPerson.lastName).isEqualTo("stei");
//
//    }
//
//    @Test
//    @Order(0)
//    public void findAll(){
//
//        List<Person> foundPersons = personRepository.findAll().list();
//
//        Table personTable = new Table(getDataSource(), "person");
//        output(personTable).toConsole();
//
//        assertThat(foundPersons.size()).isEqualTo(2);
//
//    }
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
//}
