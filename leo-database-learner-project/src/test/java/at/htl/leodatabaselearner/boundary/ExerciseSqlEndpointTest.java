package at.htl.leodatabaselearner.boundary;

import com.intuit.karate.junit5.Karate;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class ExerciseSqlEndpointTest {

    @Karate.Test
    Karate testExerciseSqlEndpoint(){
        return Karate.run("exercise_sql").relativeTo(getClass());
    }
}
