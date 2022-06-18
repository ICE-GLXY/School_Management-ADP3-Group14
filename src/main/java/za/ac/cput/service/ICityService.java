/*
Author: Moegammad Tasreeq Adams : 216173027
Date:june 2022
 */
package za.ac.cput.service;

import za.ac.cput.domain.City;

import java.util.List;
import java.util.Optional;

public interface ICityService extends IService<City, String>{
    City save(City city);

    Optional<City> read(String id);

    void deleteById(String id);

    void delete(City city);

    List<City> findAll();
  
    void delete(String s);

    List<City> findAllCities();
}
