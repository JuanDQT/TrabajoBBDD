package demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by poo2 on 17/06/2015.
 */

@Entity
@PrimaryKeyJoinColumn(name="id")//Junta las tablas por la primary key, para relizar el join
public class Manager extends Employee {
    @Column
    private Double bonusSucces;

    /*MANAGER TIENE PROYECTOS*/
    @OneToMany(mappedBy = "manager")//el nombre "manager" ha de ser igual al de la clase Project
    private Set<Project> projects = new HashSet<>();//no duplicados

    public Manager(){}

    public Double getBonusSucces() {
        return bonusSucces;
    }

    public void setBonusSucces(Double bonusSucces) {
        this.bonusSucces = bonusSucces;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "bonusSucces=" + bonusSucces +
                '}';
    }
}
