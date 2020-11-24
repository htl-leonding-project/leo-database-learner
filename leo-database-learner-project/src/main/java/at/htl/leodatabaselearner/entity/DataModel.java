package at.htl.leodatabaselearner.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Entity
@XmlRootElement
public class DataModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;;

    private String name;
    private String comment;

    //TODO Blob
    //@Lob
    //private byte[] erd;
    //private Blob erd;

    @ManyToOne
//    @JoinColumn(name = "person_id")
    private Person owner;

//    @OneToMany(mappedBy = "datamodel", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    private List<Question> questions = new ArrayList<>();
//    @OneToMany(mappedBy = "datamodel", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    private List<SqlScript> sqlScripts = new ArrayList<>();

    public DataModel() {
    }

    public DataModel(String name, Person owner, String comment) {
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

//    public Blob getErd() {
//        return erd;
//    }
//
//    public void setErd(Blob erd) {
//        this.erd = erd;
//    }

    @Override
    public String toString() {
        return "DataModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", comment='" + comment +
                '}';
    }
}
