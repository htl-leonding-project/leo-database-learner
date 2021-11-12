package at.htl.leodatabaselearner.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Assignment extends PanacheEntity {

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinColumn(name = "student_id")
  public Student student;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinColumn(name = "exPackage_id")
  public ExercisePackage exPackage;

  public Assignment(Student student, ExercisePackage exPackage) {
    this.student = student;
    this.exPackage = exPackage;
  }

  public Assignment() {
  }

  @Override
  public String toString() {
    return "Assignment{" +
      "student=" + student +
      ", exPackage=" + exPackage +
      '}';
  }
}
