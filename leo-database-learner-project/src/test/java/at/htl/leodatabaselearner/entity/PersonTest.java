package at.htl.leodatabaselearner.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class PersonTest {
    @Test
    void testToString() {
        Person person = new Person("Max", "Muster", Role.INSTRUCTOR);
        String testString = person.toString();
        String rightString = "Person mit der " +
                "id " + person.getId() +
                ", namens " + person.firstName + '\'' +
                " " + person.lastName + '\'' +
                " hat die Rolle " + person.role;

        assertThat(testString).isEqualTo(rightString);

    }
}



