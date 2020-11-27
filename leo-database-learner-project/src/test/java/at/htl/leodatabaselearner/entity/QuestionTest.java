package at.htl.leodatabaselearner.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    @Test
    void testToString() {
        Person owner = new Person("Max", "Muster", Role.INSTRUCTOR);
        DataModel dataModel = new DataModel("DataModel1", owner, "Comment1");
        Question question = new Question("text1", "sql1", 1, dataModel, owner);
        String testString = question.toString();
        String rightString = "Die Question mit der id " + question.getId() +
        ", dem text '" + question.getText() + '\'' +
                ", dem sql '" + question.getSql() + '\'' +
                ", den points " + question.getPoints() +
                ", dem localDate " + question.getLocalDate() +
                ", dem dataModel " + question.getDataModel() +
                " hat den owner " + question.getOwner() +
                '.';

        assertThat(testString).isEqualTo(rightString);

    }
}