/* StudentServiceImplTest.java
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
import za.ac.cput.domain.Name;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.NameFactory;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.service.IStudentService;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentServiceImplTest {

    private final  Name name = NameFactory.build("test-name", "test-middle", "test-surname");
    private final  Student student = StudentFactory.build("216118395", "chantel@yahoo.com",name);
    @Autowired
    private IStudentService service;


    @Test
    @Order(1)
    void save() {
        Student saved = this.service.save(this.student);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(this.student, saved)
        );

    }

    @Test
    @Order(2)
    void read() {
        Optional<Student> read = this.service.read(this.student.getStudentId());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.student, read.get()));

    }


    @Test
    @Order(5)
    void delete(){
        this.service.delete(this.student);
        List<Student> studentList = this.service.findAll();
        assertEquals(0,studentList.size());

    }}


    /*@Test
    @Order(3)
    void findAll() {
        List<Student> studentList = this.service.findAll();
        assertEquals(1, studentList.size());
    }

    @Test
    @Order(4)
    void findStudentsByName_Surname() {
        List<Student> studentList = this.service.findAll();
        assertEquals(1, studentList.size());
    }
}*/
