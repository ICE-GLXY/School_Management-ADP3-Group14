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
import za.ac.cput.domain.City;
import za.ac.cput.service.ICityService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("School_Management-ADP3-Group14/City/")
@Slf4j
public class CityController {
    private final ICityService iCityService;

    @Autowired
    public CityController(ICityService iCityService) {
        this.iCityService = iCityService;
    }

    @PostMapping("Save_City")
    public ResponseEntity<City> save(@Valid @RequestBody City city) {
        log.info("Save request: {}", city);

        try {
            City newCity = iCityService.save(city);
            return ResponseEntity.ok(newCity);

        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("read/{id}")
    public ResponseEntity<City> read(@PathVariable String id) {
        log.info("Read request:{}", id);
        City city = this.iCityService.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(city);
    }

    @DeleteMapping("delete/{city}")
    public ResponseEntity<City> delete(@PathVariable City city) {
        log.info("Delete request: {}", city);
        this.iCityService.delete(city);
        return ResponseEntity.noContent().build();
    }

    //(//_//)
    @GetMapping("Read City-All")
    public ResponseEntity<List<City>> findAll() {
        List<City> list = this.iCityService.findAll();
        return ResponseEntity.ok(list);

    }
}
