package at.htl.leodatabaselearner.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Entity
@XmlRootElement
public class Person extends PanacheEntityBase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  ;

  public String firstName;
  public String lastName;
  @Enumerated(EnumType.STRING)
  public Role role;
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


  @Override
  public String toString() {
    return "Person mit der " +
      "id " + id +
      ", namens " + firstName + '\'' +
      " " + lastName + '\'' +
      " hat die Rolle " + role;
  }
}
