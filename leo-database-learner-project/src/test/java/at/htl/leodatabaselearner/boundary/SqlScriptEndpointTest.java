package at.htl.leodatabaselearner.boundary;

import com.intuit.karate.junit5.Karate;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class SqlScriptEndpointTest {

    @Karate.Test
    Karate testSqlScriptEndpoint(){
        return Karate.run("sqlscript").relativeTo(getClass());
    }
}
