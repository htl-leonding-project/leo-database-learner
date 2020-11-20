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

    //private DataModel dataModel;
    private String createScript;
    private String dropScript;
    private String insertScript;


}
