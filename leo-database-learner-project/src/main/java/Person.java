import at.htl.Role;

import javax.persistence.Entity;

@Entity
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private Role role;

}
