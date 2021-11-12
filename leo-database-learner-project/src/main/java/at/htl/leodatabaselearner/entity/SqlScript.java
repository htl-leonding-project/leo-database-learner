package at.htl.leodatabaselearner.entity;

import at.htl.leodatabaselearner.entity.DataModel;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class SqlScript extends PanacheEntity {

  public String createScript;
  public String dropScript;
  public String insertScript;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinColumn(name = "dataModel_id")
  private DataModel dataModel;

  public SqlScript() {
  }

  public SqlScript(DataModel dataModel, String createScript, String dropScript, String insertScript) {
    this.dataModel = dataModel;
    this.createScript = createScript;
    this.dropScript = dropScript;
    this.insertScript = insertScript;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  @Override
  public String toString() {
    return "Das SqlScript hat die" +
      " id " + id +
      ", das dataModel " + dataModel +
      " das createScript '" + createScript + '\'' +
      " das dropScript '" + dropScript + '\'' +
      " und das insertScript '" + insertScript + '\'' +
      '.';
  }
}
