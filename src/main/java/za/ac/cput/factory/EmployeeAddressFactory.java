package za.ac.cput.factory;
/*
Factory for the EmployeeAddress
Author: Abdul Aleem Chilwan
StudNo: 220108447
Date:june 2022
 */
import za.ac.cput.domain.Address;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.util.Helper;

public class EmployeeAddressFactory {
    public static EmployeeAddress build(String staffId, Address address){
        Helper.checkStringParam("staffId", staffId);

        if(address == null){
            throw new IllegalArgumentException("Address is null");
        }
        return new EmployeeAddress.Builder().StaffId(staffId).Address(address).build();
    }
/*
    public static EmployeeAddress.EmployeeAddressId buildId(EmployeeAddress employeeAddress){
        return new EmployeeAddress.EmployeeAddressId(employeeAddress.getStaffId(),
                employeeAddress.getAddress());
    }*/
}