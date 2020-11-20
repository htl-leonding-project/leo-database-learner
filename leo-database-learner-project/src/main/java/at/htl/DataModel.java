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
    //private Person owner;
    private String comment;
    private Blob erd;



}
