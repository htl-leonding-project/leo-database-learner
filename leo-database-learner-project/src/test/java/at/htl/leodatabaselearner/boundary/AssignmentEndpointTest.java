package at.htl.leodatabaselearner.boundary;

import com.intuit.karate.junit5.Karate;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class AssignmentEndpointTest {

    @Karate.Test
    Karate AssignmentEndpoint(){
        return Karate.run("assignment").relativeTo(getClass());
    }
}
