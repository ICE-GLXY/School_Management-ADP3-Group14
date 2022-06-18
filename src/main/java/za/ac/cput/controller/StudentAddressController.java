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
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.StudentAddress;
import za.ac.cput.service.IStudentAddressService;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("school_management/student_address/")
@Slf4j
public class StudentAddressController {

    private IStudentAddressService iStudentAddressService;

    @Autowired
    public StudentAddressController(IStudentAddressService iStudentAddressService) {
        this.iStudentAddressService = iStudentAddressService;
    }


    @PostMapping("save")
    public ResponseEntity<StudentAddress> save(@Valid @RequestBody StudentAddress studentAddress) {
        log.info("Save request: {}", studentAddress);
        StudentAddress save = iStudentAddressService.save(studentAddress);
        return ResponseEntity.ok(save);

    }


    @GetMapping("read/{id}")
    public ResponseEntity<StudentAddress> read(@PathVariable String id) {
        log.info("Read request: {}", id);
        StudentAddress studentAddress = this.iStudentAddressService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(studentAddress);

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Delete request: {}", id);
        this.iStudentAddressService.deleteByID(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<StudentAddress>> findAll() {
        List<StudentAddress> studentAddresses = this.iStudentAddressService.findAll();
        return ResponseEntity.ok(studentAddresses);
    }

    @GetMapping("readByAddressCityCountry/{studentCountry}")
    public ResponseEntity<List<StudentAddress>> getAddressByCityCountry (@RequestParam String name) {
        log.info("readByAddressCityCountry request: {}", name);

        try {
            List<StudentAddress> readByAddressCityCountry = iStudentAddressService.findByAddressCityCountryName(name);
            return ResponseEntity.ok(readByAddressCityCountry);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

}
