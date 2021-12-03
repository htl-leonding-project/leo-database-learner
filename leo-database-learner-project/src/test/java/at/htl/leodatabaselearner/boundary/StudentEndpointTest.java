package at.htl.leodatabaselearner.boundary;

import com.intuit.karate.junit5.Karate;
import io.quarkus.test.junit.QuarkusTest;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class StudentEndpointTest {

    @Karate.Test
    Karate testStudentEndpoint(){
        return Karate.run("student").relativeTo(getClass());
    }

}