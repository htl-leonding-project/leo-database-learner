package at.htl.leodatabaselearner.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SqlScriptTest {
    @Test
    void testToString() {
        Person owner = new Person("Max", "Muster", Role.INSTRUCTOR);
        DataModel dataModel = new DataModel("DataModel1", owner, "Comment1");
        SqlScript sqlScript = new SqlScript(dataModel, "createScript1", "dropScript1", "insertScript1");
        String testString = sqlScript.toString();
        String rightString = "Das SqlScript hat die" +
                " id " + sqlScript.getId() +
                ", das dataModel " + sqlScript.getDataModel() +
                " das createScript '" + sqlScript.getCreateScript() + '\'' +
                " das dropScript '" + sqlScript.getDropScript() + '\'' +
                " und das insertScript '" + sqlScript.getInsertScript() + '\'' +
                '.';

        assertThat(testString).isEqualTo(rightString);
    }
}