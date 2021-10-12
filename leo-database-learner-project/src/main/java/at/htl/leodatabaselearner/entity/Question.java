package at.htl.leodatabaselearner.entity;

import at.htl.leodatabaselearner.entity.DataModel;
import at.htl.leodatabaselearner.entity.Person;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@Entity
@XmlRootElement
public class Question extends PanacheEntityBase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public String text;
  public String name;
  public String sql;
  public int points;
  public LocalDate localDate;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinColumn(name = "dataModel_id")
  private DataModel dataModel;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinColumn(name = "person_id")
  private Person owner;

  public Question() {
  }

  public Question(String name, String text, String sql, int points, DataModel dataModel, Person owner) {
    this.name = name;
    this.text = text;
    this.sql = sql;
    this.points = points;
    this.dataModel = dataModel;
    this.owner = owner;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Die Question mit der id " + id +
      ", dem namen '" + name + '\'' +
      ", dem text '" + text + '\'' +
      ", dem sql '" + sql + '\'' +
      ", den points " + points +
      ", dem localDate " + localDate +
      ", dem dataModel " + dataModel +
      " hat den owner " + owner +
      '.';
  }
}
