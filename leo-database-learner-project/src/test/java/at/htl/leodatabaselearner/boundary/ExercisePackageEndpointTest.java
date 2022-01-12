package at.htl.leodatabaselearner.boundary;

import com.intuit.karate.junit5.Karate;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class ExercisePackageEndpointTest {

    @Karate.Test
    Karate testExercisePackageEndpoint(){
        return Karate.run("exercisePackage").relativeTo(getClass());
    }
}
