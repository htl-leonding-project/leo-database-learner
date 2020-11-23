package at.htl.leodatabaselearner.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Entity
@XmlRootElement
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String firstName;
    private String lastName;
    @Enumerated(EnumType.ORDINAL)
    private Role role;
//
//    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    private List<DataModel> dataModels = new ArrayList<>();
//    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    private List<Question> questions = new ArrayList<>();

    public Person() {
    }

    public Person(String firstName, String lastName, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                '}';
    }
}
