package at.htl.leodatabaselearner.entity;

import at.htl.leodatabaselearner.entity.DataModel;
import at.htl.leodatabaselearner.entity.Person;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@Entity
@XmlRootElement
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String text;
    private String sql;
    private int points;
    private LocalDate localDate;

    @ManyToOne
//    @JoinColumn(name = "dataModel_id")
    private DataModel dataModel;

    @ManyToOne
//    @JoinColumn(name = "person_id")
    private Person owner;

    public Question() {
    }

    public Question(String text, String sql, int points, DataModel dataModel, Person owner) {
        this.text = text;
        this.sql = sql;
        this.points = points;
        this.dataModel = dataModel;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public DataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", sql='" + sql + '\'' +
                ", points=" + points +
                ", localDate=" + localDate +
                ", dataModel=" + dataModel +
                ", owner=" + owner +
                '}';
    }
}
