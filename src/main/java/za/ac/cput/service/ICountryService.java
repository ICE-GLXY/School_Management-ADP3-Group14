/*
Author: Moegammad Tasreeq Adams : 216173027
Date:june 2022
 */
package za.ac.cput.service;

import za.ac.cput.domain.Country;

import java.util.List;

public interface ICountryService extends IService<Country,String>{
    void delete(Country country);
    List<Country> findAll();
    //void delete(String s);
    void deleteById(String id);
}
