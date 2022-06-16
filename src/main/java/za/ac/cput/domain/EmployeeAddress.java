package za.ac.cput.domain;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class EmployeeAddress implements Serializable {
    @Id
    private String staffId;

    @Embedded private Address address;

    public EmployeeAddress() {
    }

    private EmployeeAddress(Builder builder){
        this.staffId = builder.staffId;
        this.address = builder.address;
    }

    public String getStaffId() {
        return staffId;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "staffId='" + staffId + '\'' +
                ", address=" + address +
                '}';
    }

    //Very unsure of this.
    public static class EmployeeAddressId {
        private final String staffId;
        private final Address address;

        public EmployeeAddressId(String staffId, Address address) {
            this.staffId = staffId;
            this.address = address;
        }

        public String getStaffId() {
            return staffId;
        }

        public Address getAddress() {
            return address;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EmployeeAddressId that = (EmployeeAddressId) o;
            return Objects.equals(staffId, that.staffId) && Objects.equals(address, that.address);
        }

        @Override
        public int hashCode() {
            return Objects.hash(staffId, address);
        }
    }

    public static class Builder{
        private String staffId;
        private Address address;

        public Builder StaffId(String staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder Address(Address address) {
            this.address = address;
            return this;
        }

        public Builder copy (EmployeeAddress employeeAddress){
            this.staffId=employeeAddress.staffId;
            this.address=employeeAddress.address;
            return this;
        }
        public EmployeeAddress build(){
            return new EmployeeAddress(this);
        }


    }


}