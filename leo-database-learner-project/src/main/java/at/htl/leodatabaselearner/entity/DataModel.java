package at.htl.leodatabaselearner.entity;

import javax.persistence.*;
import java.sql.Blob;

@Entity
public class DataModel {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;;

    private String name;
    private String comment;
    private Blob erd;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person owner;

    public DataModel() {
    }

    public DataModel(String name, Person owner, String comment, Blob erd) {
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