import at.htl.Role;

import javax.persistence.Entity;

@Entity
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private Role role;

    public Person() {
    }

    public Person(int id, String firstName, String lastName, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }
}
