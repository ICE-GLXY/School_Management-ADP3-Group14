/*
Author: Moegammad Tasreeq Adams : 216173027
Date:june 2022
 */
package za.ac.cput.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Country;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.factory.CountryFactory;
import za.ac.cput.service.ICountryService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("School_Management-ADP3-Group14/Country/")
@Slf4j
public class CountryController {
    private final ICountryService iCountryService;

    @Autowired
    public CountryController(ICountryService iCountryService) {
        this.iCountryService = iCountryService;
    }

    @PostMapping("Save_Country")
    public ResponseEntity<Country> save(@Valid @RequestBody Country country) {
        log.info("Save request: {}", country);

        try {
            Country newCountry = CountryFactory.build(country.getId(), country.getName());
            return ResponseEntity.ok(newCountry);

        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Country> read(@PathVariable String id) {
        log.info("Read request:{}", id);
        Country country = this.iCountryService.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(country);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Country> delete(@PathVariable String id) {
        log.info("Read request:{}", id);
        this.iCountryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("Read Country-All")
    public ResponseEntity<List<Country>> findAll() {
        List<Country> country = this.iCountryService.findAll();
        return ResponseEntity.ok(country);

    }
}
