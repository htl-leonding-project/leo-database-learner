package at.htl.leodatabaselearner.entity;

import org.junit.jupiter.api.Test;

class PersonTest {
    @Test
    void testToString() {
        Person person = new Person("Max", "Muster", Role.INSTRUCTOR);
        String testString = person.toString();
        String rightString = "Person mit der " + "id"
                + person.getId() + "namens "
                + person.getFirstName() + "" + person.getLastName() + "hat die Rolle "
                + person.getRole() + ".\n";



    }
}


