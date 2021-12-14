package at.htl.leodatabaselearner.entity;

import javax.persistence.Entity;

@Entity
public class Student extends Person {

  public String classname;

  public Student() {
  }

  public Student(String firstName, String lastName, String password, String classname) {
    super(firstName, lastName, password);
    this.classname = classname;
  }

  @Override
  public String toString() {
    return "Student{" +
      "firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", password='" + password + '\'' +
      ", classname='" + classname + '\'' +
      '}';
  }
}
