package at.htl.leodatabaselearner.boundary;

import com.intuit.karate.junit5.Karate;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class EvaluationEndpointTest {

    @Karate.Test
    Karate testEvaluationEndpoint(){
        return Karate.run("evaluation").relativeTo(getClass());
    }
}
