package demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by poo2 on 25/06/2015.
 */
@Entity
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String name;

    /*ESPECIALIDADES PARA DEVELOPERS*/
    @JsonIgnore
    @ManyToMany(mappedBy = "specialties")
    private Set<Developer> developers = new HashSet<>();

    @OneToMany(mappedBy = "specialty")
    private Set<Review> reviews = new HashSet<>();

    /*ESPACIALIDADES PARA PROYECTOS*/
    @ManyToMany(mappedBy = "specialties")
    private Set<Project> projects = new HashSet<>();

    public Specialty() {
    }

    public Specialty(String name) {
        this.name = name;
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

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Specialty that = (Specialty) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}