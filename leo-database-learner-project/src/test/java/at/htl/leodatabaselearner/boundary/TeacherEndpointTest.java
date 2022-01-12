package at.htl.leodatabaselearner.boundary;

import com.intuit.karate.junit5.Karate;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class TeacherEndpointTest {

    @Karate.Test
    Karate testTeacherEndpoint(){
        return Karate.run("teacher").relativeTo(getClass());
    }
}
