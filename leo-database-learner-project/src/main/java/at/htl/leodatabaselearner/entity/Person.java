package at.htl.leodatabaselearner.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Entity
@XmlRootElement
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person extends PanacheEntityBase {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private Long id;

  public String firstName;
  public String lastName;
  public String password;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

//
//    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    private List<DataModel> dataModels = new ArrayList<>();
//    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    private List<Question> questions = new ArrayList<>();

  public Person() {
  }

  public Person(String firstName, String lastName, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
  }
}
