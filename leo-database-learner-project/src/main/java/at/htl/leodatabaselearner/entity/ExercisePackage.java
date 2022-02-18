package at.htl.leodatabaselearner.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

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


  public Long getId() {
    return id;
  }


  @Override
  public String toString() {
    return "ExercisePackage{" +
      "name='" + name + '\'' +
      ", dataModel=" + dataModel +
      '}';
  }
}
