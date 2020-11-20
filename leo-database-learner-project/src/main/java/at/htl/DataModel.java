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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Blob getErd() {
        return erd;
    }

    public void setErd(Blob erd) {
        this.erd = erd;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", comment='" + comment + '\'' +
                ", erd=" + erd +
                '}';
    }
}
