package at.htl.leodatabaselearner.boundary;

import com.intuit.karate.junit5.Karate;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class DataModelEndpointTest {

    @Karate.Test
    Karate testDataModelEndpoint(){
        return Karate.run("datamodel").relativeTo(getClass());
    }
}
