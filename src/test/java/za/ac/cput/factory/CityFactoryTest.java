/*
Author: Moegammad Tasreeq Adams : 216173027
Date:june 2022
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.City;

import static org.junit.jupiter.api.Assertions.*;

class CityFactoryTest {

    @Test
    void createCity(){
        City cityCreated = CityFactory.build("12345","Cape Town", CountryFactory.build("12345","Mars"));
        assertNotNull(cityCreated);
        System.out.println(cityCreated);
    }
}
