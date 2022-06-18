/* Student.java
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
public class Student implements Serializable {

    @NotNull
    @Id
    private String studentId;
    @NotNull
    private String email;
    @Embedded
    private Name name;

    protected Student(){};

    private Student(Builder builder){
        this.studentId = builder.studentId;
        this.email = builder.email;
        this.name = name;
    }

    public String getStudentId() {return studentId;}

    public String getEmail() {return email;}

    public za.ac.cput.domain.Name getName() {return name;}


    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", email='" + email + '\'' +
                ", name=" + name +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId) && Objects.equals(email, student.email) && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, email, name);
    }

    public static class Builder{
        private String studentId;
        private String email;
        private Name name;

        public Student.Builder studentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public Student.Builder email(String email) {
            this.email = email;
            return this;
        }

        public Student.Builder name(Name name) {
            this.name = name;
            return this;
        }

        public Builder copy(Student student){
            this.studentId= student.studentId;
            this.email = student.email;
            this.name = name;
            return this;
        }

        public Student build(){ return new Student(this);}

    }


}
