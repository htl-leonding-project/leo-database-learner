package at.htl.leodatabaselearner.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Evaluation extends PanacheEntity {

  public int reachedPoints;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinColumn(name = "student_id")
  public Student student;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinColumn(name = "question_id")
  public Question question;

  public Evaluation(int reachedPoints, Student student, Question question) {
    this.reachedPoints = reachedPoints;
    this.student = student;
    this.question = question;
  }

  public Evaluation() {
  }

  @Override
  public String toString() {
    return "Evaluation{" +
      "reachedPoints=" + reachedPoints +
      ", student=" + student +
      ", question=" + question +
      '}';
  }
}
