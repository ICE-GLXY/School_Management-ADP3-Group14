/* StudentAddressServiceImplTest.java
Author: Chante Lewis:216118395
16/06/2022
 */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.CountryFactory;
import za.ac.cput.factory.StudentAddressFactory;
import za.ac.cput.service.IStudentAddressService;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentAddressServiceImplTest {

    private final Country country = CountryFactory.build("20111", "South African");
    private final  City city = CityFactory.build("10111", "Saldanha", country);
    private final Address address = AddressFactory.build("12", "seacrest", "104", "Flurry", 7395, city);
    private final StudentAddress studentAddress = StudentAddressFactory.build("216118395", address);
    @Autowired
    private IStudentAddressService service;


    @Test
    @Order(1)
    void save() {
        StudentAddress saved = this.service.save(this.studentAddress);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(this.studentAddress, saved)
        );
    }


    @Test
    @Order(2)
    void read() {
        Optional<StudentAddress> read = this.service.read(this.studentAddress.getStudentId());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.studentAddress, read.get()));
    }

    @Test
    @Order(5)
    void delete() {
        this.service.delete(this.studentAddress);
        List<StudentAddress> studentAddressList = this.service.findAll();
        assertEquals(0, studentAddressList.size());

    }


    @Test
    @Order(3)
    void findAll() {
        List<StudentAddress> studentAddressList = this.service.findAll();
        assertEquals(1, studentAddressList.size());
    }

    @Test
    @Order(4)
    void findByAddressCityCountryName() {
        List<StudentAddress> studentAddressList = this.service.findAll();
        assertEquals(1, studentAddressList.size());
    }
}