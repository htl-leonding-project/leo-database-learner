package at.htl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Blob;

@Entity
public class SqlScript {

    @Id //@GeneratedValue(generator = GenerationType.TABLE)
    Long id;

    private DataModel dataModel;
    private String createScript;
    private String dropScript;
    private String insertScript;

    public SqlScript() {
    }

    public SqlScript(Long id, DataModel dataModel, String createScript, String dropScript, String insertScript) {
        this.id = id;
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
}
