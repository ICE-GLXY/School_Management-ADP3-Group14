/* StudentController.java
Author: Chante Lewis:216118395
18/06/2022
 */
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.StudentAddress;
import za.ac.cput.service.IStudentService;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("school_management/student/")
@Slf4j
public class StudentController {

    private IStudentService iStudentService;

    @Autowired
    public StudentController(IStudentService iStudentService) {
        this.iStudentService = iStudentService;
    }

    //Save student
    @PostMapping("save_Student")
    public ResponseEntity<Student> save(@Valid @RequestBody Student student) {
        log.info("Save request: {}", student);
        Student save = iStudentService.save(student);
        return ResponseEntity.ok(save);

    }

    //Read student by id
    @GetMapping("read/{id}")
    public ResponseEntity<Student> read(@PathVariable String id) {
        log.info("Read request: {}", id);
        Student student = this.iStudentService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(student);

    }

    //Delete student by id
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Delete request: {}", id);
        this.iStudentService.deleteByID(id);
        return ResponseEntity.noContent().build();
    }

    //Find all students
    @GetMapping("all")
    public ResponseEntity<List<Student>> findAll() {
        List<Student> student = this.iStudentService.findAll();
        return ResponseEntity.ok(student);
    }

    @GetMapping("readByStudentsByName_Surname/{studentSurname}")
    public ResponseEntity<List<Student>> getStudentsByName_Surname(@RequestParam String surname) {
        log.info("readByStudentsByName_Surname request: {}", surname);

        try {
            List<Student> readByStudentsByName_Surname = iStudentService.findStudentsByName_Surname(surname);
            return ResponseEntity.ok(readByStudentsByName_Surname);

        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}