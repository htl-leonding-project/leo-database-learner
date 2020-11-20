package at.htl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.sql.DataSource;
import java.time.LocalDate;

@Entity
public class Question {

    @Id //@GeneratedValue(generator = GenerationType.TABLE)
    Long id;

    private String text;
    private String sql;
    private int points;
    private LocalDate localDate;
    private DataModel dataModel;
    private Person owner;

    public Question() {
    }

    public Question(Long id, String text, String sql, int points, LocalDate localDate, DataModel dataModel, Person owner) {
        this.id = id;
        this.text = text;
        this.sql = sql;
        this.points = points;
        this.localDate = localDate;
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
}
