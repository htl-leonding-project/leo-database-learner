package at.htl.leodatabaselearner.entity;

import javax.persistence.Entity;

@Entity
public class Teacher extends Person{

  public Teacher(String firstName, String lastName, String password) {
    super(firstName, lastName, password);
  }

  public Teacher() {
  }

  @Override
  public String toString() {
    return "Teacher{" +
      "firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", password='" + password + '\'' +
      '}';
  }
}
