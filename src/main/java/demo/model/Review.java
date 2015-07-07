package demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by poo2 on 06/07/2015.
 */
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String comment;
    private Long score;
    private Date dtIni;
    private Date dtEnd;

    @ManyToOne//fet
    private Developer developer;

    @ManyToOne//fet
    private Project project;

    public Review(String comment, Long score, Date dtIni, Date dtEnd, Developer developer, Project project, Specialty specialty) {
        this.comment = comment;
        this.score = score;
        this.dtIni = dtIni;
        this.dtEnd = dtEnd;
        this.developer = developer;
        this.project = project;
        this.specialty = specialty;
    }

    public Review() {
    }

    @JsonIgnore
    @ManyToOne
    private Specialty specialty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Date getDtIni() {
        return dtIni;
    }

    public void setDtIni(Date dtIni) {
        this.dtIni = dtIni;
    }

    public Date getDtEnd() {
        return dtEnd;
    }

    public void setDtEnd(Date dtEnd) {
        this.dtEnd = dtEnd;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", score=" + score +
                ", dtIni=" + dtIni +
                ", dtEnd=" + dtEnd +
                ", developer=" + developer +
                ", project=" + project +
                ", specialty=" + specialty +
                '}';
    }
}
