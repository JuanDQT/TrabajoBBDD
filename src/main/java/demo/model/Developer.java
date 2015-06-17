package demo.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Created by poo2 on 17/06/2015.
 */
@Entity
@PrimaryKeyJoinColumn(name="id")//Junta las tablas por la primary key, para relizar el join
public class Developer extends Employee {
    //@Column
    @Enumerated(EnumType.STRING)
    private Category category;

    public Developer(){}

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {

        String developer = super.toString();

        return developer + "Developer{" +
                "category=" + category +
                '}';
    }
}
