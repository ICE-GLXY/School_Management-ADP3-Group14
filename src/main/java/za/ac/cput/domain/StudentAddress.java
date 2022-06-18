/* StudentAddress.java
Author: Chante Lewis:216118395
12/06/2022
 */
package za.ac.cput.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class StudentAddress implements Serializable {

    @NotNull
    @Id
    private String studentId;

    @Embedded
    private Address address;

    protected StudentAddress() {}

    private StudentAddress (Builder builder){
        this.studentId = builder.studentId;
        this.address = builder.address;
    }

    //Getters
    public String getStudentId() {return studentId;}
    public za.ac.cput.domain.Address getAddress() {return address;}


    //toString
    @Override
    public String toString() {
        return "StudentAddress{" +
                "studentId='" + studentId + '\'' +
                ", address=" + address +
                '}';
    }

    //Equals and Hash
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentAddress that = (StudentAddress) o;
        return studentId.equals(that.studentId) && address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, address);
    }

    public static class Builder{
        private String studentId;
        private Address address;

        public StudentAddress.Builder studentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public StudentAddress.Builder address(Address address) {
            this.address = address;
            return this;
        }

        public StudentAddress.Builder copy(StudentAddress studentAddress){
            this.studentId = studentAddress.studentId;
            this.address = studentAddress.address;
            return this;
        }

        public StudentAddress build(){ return new StudentAddress(this);}

    }
}




