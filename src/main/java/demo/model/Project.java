package demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    /*PROYECTOS PARA UN DEVELOPERS*/
    @JsonIgnore
    @ManyToMany
    private Set<Developer> developers = new HashSet<>();

    /*PROYECTOS TIENEN UN MANAGER*/
    @ManyToOne
    private Manager manager;

    @JsonIgnore
    @ManyToMany
    private Set<Specialty> specialties =  new HashSet<>();

    @OneToMany(mappedBy = "project")
    private Set<Review> reviews = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)///OBTENER PRIMARY KEY
    private Long id;

    @Column
    String description;

    @NotNull
    private Date startDate;

    private Date endtDate;

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

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
