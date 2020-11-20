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


}
