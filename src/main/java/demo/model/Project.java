package demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by poo2 on 17/06/2015.
 */
@Entity
public class Project  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)///OBTENER PRIMARY KEY
    private Long id;

    @Column
    String description;

    @NotNull
    @Column(name = "start_date")
    private Date startDate;


    @Column(name = "end_date")
    private Date endtDate;

    /****RELACION 1,N ETC****/
    private Set<Developer> developers = new HashSet<>();
    @ManyToOne//muchos proyectos para un manager
    private Manager manager;//este nombre manager ha de ser igual al de la clase Manager(para hacer relacion 1:N)

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

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
