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
public class DataModel extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;;

    public String name;
    public String comment;

    //TODO: Blob
    //@Lob
    //private byte[] erd;
    //private Blob erd;

    @ManyToOne
    @JoinColumn(name = "person_id")
    public Person owner;

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

    @Override
    public String toString() {
        return "DataModel mit der Id " + id +
                ", dem Namen '" + name + '\'' +
                ", dem owner " + owner +
                " hat das comment '" + comment +
                '.';
    }
}
