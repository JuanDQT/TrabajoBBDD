package demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by poo2 on 17/06/2015.
 */
@Entity
public class Project  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    String description;

    @NotNull
    @Column(name = "start date")
    private Date startDate;


    @Column(name = "end date")
    private Date endtDate;

    @ManyToOne
    private Manager manager;//este nombre manager ha de ser igual al de la clase Manager(para hacer relacion 1:N)

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndtDate() {
        return endtDate;
    }

    public void setEndtDate(Date endtDate) {
        this.endtDate = endtDate;
    }

    public Project(){}

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endtDate=" + endtDate +
                '}';
    }
}
