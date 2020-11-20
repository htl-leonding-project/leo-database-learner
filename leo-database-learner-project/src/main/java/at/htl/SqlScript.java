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

}
