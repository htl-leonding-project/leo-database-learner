package at.htl.leodatabaselearner.entity;

import at.htl.leodatabaselearner.entity.DataModel;
import at.htl.leodatabaselearner.entity.Person;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@Entity
@XmlRootElement
public class Question extends PanacheEntity {

  public String name;
  public String text;
  public String sql;
  public int points;
  @JsonbDateFormat("dd-MM-yyyy")
  public LocalDate localDate;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinColumn(name = "exPackage_id")
  public ExercisePackage exercisePackage;

  public Question(String name, String text, String sql, int points, ExercisePackage exercisePackage) {
    this.name = name;
    this.text = text;
    this.sql = sql;
    this.points = points;
    this.exercisePackage = exercisePackage;
  }

  public Question() {
  }

  @Override
  public String toString() {
    return "Question{" +
      "name='" + name + '\'' +
      ", text='" + text + '\'' +
      ", sql='" + sql + '\'' +
      ", points=" + points +
      ", localDate=" + localDate +
      ", exercisePackage=" + exercisePackage +
      '}';
  }
}
