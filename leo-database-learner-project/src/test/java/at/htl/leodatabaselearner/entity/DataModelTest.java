package at.htl.leodatabaselearner.entity;

import org.junit.jupiter.api.Test;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DataModelTest {

    @Test
    void testToString() {
       Teacher teacher = new Teacher("Max", "Muster","test123");
        DataModel dataModel = new DataModel("Webshop",teacher, "Das Modell zeigt einen Webshop uns seine " +
                "jeweiligen Attribute.");

        String testString = dataModel.toString();
        String rightString = "" +
                "DataModel mit der Id " + dataModel.getId() +
                ", dem Namen '" + dataModel.name + '\'' +
                ", dem owner " + dataModel.owner +
                " hat das comment '" + dataModel.comment +
                '.';

        assertThat(testString).isEqualTo(rightString);
    }
}
