/*
TITILAYO AKINJOLE
220283982
 */


package za.ac.cput.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable

public class Name implements Serializable {
    @NotNull
    private String firstName;

    @NotNull
    private String middleName;

  //  @NotNull
    private String surname;

    protected Name(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    private Name(Builder builder) {
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.surname = builder.surname;

    }

    @Override
    public int hashCode (){return Objects.hash(firstName, middleName, surname);}

    @Override
    public String toString(){
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", surname='" + surname + '\'' +
                ']';
    }

    public static class Builder {
        private String firstName, middleName, surname;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder copy(Name name) {
            this.firstName = name.firstName;
            this.middleName = name.middleName;
            this.surname = name.surname;
            return this;
        }

        public Name build() {
            return new Name(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return firstName.equals(name.firstName) && middleName.equals(name.middleName) && surname.equals(name.surname);
    }


    }


