package com.websystique.springboot.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="APP_BUSINESS")
public class Business implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name="NAME", nullable=false)
    private String name;

    @Column(name="NUMBER_OF_EMPLOYEES")
    private Integer numberOfEmployees;

    @Column(name="AGE", nullable = false)
    private Integer age;

    public Long getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setNumberOfEmployees(Integer numberOfEmployees) {this.numberOfEmployees = numberOfEmployees;}
    public Integer getNumberOfEmployees(){return numberOfEmployees;}
    public void setAge(Integer age){this.age = age;}
    public Integer getAge(){return age;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Business business = (Business) o;

        if (Integer.compare(business.numberOfEmployees, numberOfEmployees) != 0) return false;
        if (id != null ? !id.equals(business.id) : business.id != null) return false;
        if (name != null ? !name.equals(business.name) : business.name != null) return false;
        return age != null ? age.equals(business.age) : business.age == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        temp = Double.doubleToLongBits(age);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
    }

}
