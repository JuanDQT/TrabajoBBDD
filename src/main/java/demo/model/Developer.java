package demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by poo2 on 17/06/2015.
 */
@Entity
@PrimaryKeyJoinColumn(name="id")//Junta las tablas por la primary key, para relizar el join
public class Developer extends Employee {
    @Enumerated(EnumType.STRING)
    private Category category;

    /*DEVELOPERS CON PROYECTO*/
    @ManyToMany(mappedBy = "developers")
    private Set<Project> projects = new HashSet<>();

    /*DEVELOPERS CON ESPECIALIDADES*/
    @ManyToMany
    private Set<Specialty> specialties = new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "developer")
    private Set<Review> reviews = new HashSet<>();

    public Developer(){}

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {

        String developer = super.toString();

        return developer + "Developer{" +
                "category=" + category +
                '}';
    }
}
