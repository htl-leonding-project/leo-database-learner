package at.htl.leodatabaselearner.boundary;

import com.intuit.karate.junit5.Karate;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class QuestionEndpointTest {

    @Karate.Test
    Karate testQuestionEndpoint(){
        return Karate.run("question").relativeTo(getClass());
    }
}
