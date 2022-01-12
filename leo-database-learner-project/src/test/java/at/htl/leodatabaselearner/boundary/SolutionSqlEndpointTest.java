package at.htl.leodatabaselearner.boundary;

import com.intuit.karate.junit5.Karate;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class SolutionSqlEndpointTest {

    @Karate.Test
    Karate testSolutionSqlEndpoint(){
        return Karate.run("solution_sql").relativeTo(getClass());
    }
}
