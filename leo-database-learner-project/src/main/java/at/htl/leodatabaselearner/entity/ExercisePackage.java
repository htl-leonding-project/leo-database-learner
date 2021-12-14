package at.htl.leodatabaselearner.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ExercisePackage extends PanacheEntity {

  public String name;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinColumn(name = "dataModel_id")
  public DataModel dataModel;

  public ExercisePackage(String name, DataModel dataModel) {
    this.name = name;
    this.dataModel = dataModel;
  }

  public ExercisePackage() {
  }

  @Override
  public String toString() {
    return "ExercisePackage{" +
      "name='" + name + '\'' +
      ", dataModel=" + dataModel +
      '}';
  }
}
