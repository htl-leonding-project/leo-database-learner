package at.htl.leodatabaselearner.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Entity
@XmlRootElement
public class DataModel extends PanacheEntity {

    public String name;
    public String comment;

    //TODO: Blob
    //@Lob
    //private byte[] erd;
    //private Blob erd;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "person_id")
    public Teacher owner;

    public DataModel() {
    }

    public DataModel(String name, Teacher owner, String comment) {
        this.name = name;
        this.owner = owner;
        this.comment = comment;
        //this.erd = erd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DataModel mit der Id " + id +
                ", dem Namen '" + name + '\'' +
                ", dem owner " + owner +
                " hat das comment '" + comment +
                '.';
    }
}
