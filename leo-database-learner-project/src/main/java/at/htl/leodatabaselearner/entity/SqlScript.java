package at.htl.leodatabaselearner.entity;

import at.htl.leodatabaselearner.entity.DataModel;

import javax.persistence.*;

@Entity
public class SqlScript {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String createScript;
    private String dropScript;
    private String insertScript;

    @ManyToOne
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

    public DataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    public String getCreateScript() {
        return createScript;
    }

    public void setCreateScript(String createScript) {
        this.createScript = createScript;
    }

    public String getDropScript() {
        return dropScript;
    }

    public void setDropScript(String dropScript) {
        this.dropScript = dropScript;
    }

    public String getInsertScript() {
        return insertScript;
    }

    public void setInsertScript(String insertScript) {
        this.insertScript = insertScript;
    }

    @Override
    public String toString() {
        return "SqlScript{" +
                "id=" + id +
                ", dataModel=" + dataModel +
                ", createScript='" + createScript + '\'' +
                ", dropScript='" + dropScript + '\'' +
                ", insertScript='" + insertScript + '\'' +
                '}';
    }
}
