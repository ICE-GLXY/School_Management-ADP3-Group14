package za.ac.cput.domain;
/*
Mogamad Taariq Phillips (220166153)
ADP3 - June Assessment 2022
Date: 13 June 2022
School Management
 */
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
public class Employee
{
    @Id @NotNull
    private String staffId;
    @NotNull
    private String email;
    @NotNull
    private City city;
    @Embedded
    private Name name;


    protected Employee(){
    }

    private Employee(Builder b){
        this.staffId = b.staffId;
        this.email = b.email;
        this.name = b.name;
        this.city = b.city;
    }

    public String getStaffId() {
        return staffId;
    }

    public String getEmail() {
        return email;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "staffId='" + staffId + '\'' +
                ", email='" + email + '\'' +
                ", name=" + name +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Employee employee = (Employee) o;
        return staffId.equals(employee.staffId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffId);
    }

    public static class Builder{
        private String staffId;
        private String email;
        private Name name;
        private City city;


        public Builder staffId(String staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder name(Name name){
            this.name = name;
            return this;
        }

        public Builder city(City city) {
            this.city = city;
            return this;

        }

        public Builder copy(Employee e){
            this.staffId = e.staffId;
            this.email = e.email;
            this.name = e.name;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }

}