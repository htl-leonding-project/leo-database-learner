package at.htl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Blob;

@Entity
public class DataModel {

    @Id //@GeneratedValue(generator = GenerationType.TABLE)
    Long id;

    private String name;
    private Person owner;
    private String comment;
    private Blob erd;

    public DataModel() {
    }

    public DataModel(Long id, String name, Person owner, String comment, Blob erd) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.comment = comment;
        this.erd = erd;
    }
}
