package demo.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by poo2 on 15/06/2015.
 */
@Entity
@Inheritance (strategy = InheritanceType.JOINED)//SOLO EN LA SUPER
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    private String name;
    private String surname;
    private Double salary;
    @Temporal(TemporalType.DATE)
    private Date dtIni;


    public Employee(String name, Double salary, Date dtIni, String surname) {
        this.name = name;
        this.salary = salary;
        this.dtIni = dtIni;
        this.surname = surname;
    }

    public Employee() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getDtIni() {
        return dtIni;
    }

    public void setDtIni(Date dtIni) {
        this.dtIni = dtIni;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", dtIni=" + dtIni +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!id.equals(employee.id)) return false;
        if (!name.equals(employee.name)) return false;
        if (!surname.equals(employee.surname)) return false;
        if (!salary.equals(employee.salary)) return false;
        return dtIni.equals(employee.dtIni);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + salary.hashCode();
        result = 31 * result + dtIni.hashCode();
        return result;
    }
}
