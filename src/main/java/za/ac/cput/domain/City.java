/*
Entity for the city
Author: Moegammad Tasreeq Adams : 216173027
Date:june 2022
 */
package za.ac.cput.domain;

import com.sun.istack.NotNull;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;


//@Embeddable
@Entity
public class City implements Serializable {

    @NotNull @Id
    private String id;
    @NotNull
    private String name;

    @ManyToOne(cascade = { PERSIST, MERGE })
    @NotFound(action = NotFoundAction.IGNORE)
    @NotNull
    private Country country;

    public City() {}

    private City(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.country = builder.country;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id.equals(city.id) && name.equals(city.name) && country.equals(city.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country);
    }

    public static class Builder{
        private String id, name;
        private Country country;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setCountry(Country country) {
            this.country = country;
            return this;
        }

        public Builder copy(City city)
        {
            this.id = city.id;
            this.name = city.name;
            this.country = city.country;
            return this;
        }
        public City build(){
            return new City(this);
        }
    }

}
