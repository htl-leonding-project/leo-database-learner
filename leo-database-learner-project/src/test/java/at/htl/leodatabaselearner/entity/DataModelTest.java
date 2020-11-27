package at.htl.leodatabaselearner.entity;

import org.junit.jupiter.api.Test;

import javax.sql.DataSource;


class DataModelTest {

    @Test
    void testToString() {
        Person owner = new Person("Max", "Muster", Role.INSTRUCTOR);
        DataModel dataModel = new DataModel("DataModel1", owner, "Comment1");

        String testString = dataModel.toString();
        String rightString = "" +
                "DataModel mit der Id " + dataModel.getId() +
                ", dem Namen '" + dataModel.getName() + '\'' +
                ", dem owner " + dataModel.getOwner() +
                " hat das comment '" + dataModel.getComment() +
                '.';
    }
}