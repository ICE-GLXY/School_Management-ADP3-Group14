/*
Author: Moegammad Tasreeq Adams : 216173027
Date:june 2022
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Country;

import static org.junit.jupiter.api.Assertions.*;

class CountryFactoryTest {

    @Test
    public void build (){
        Country country = CountryFactory.build ("123456","Mars");
        System.out.println(country);
        assertNotNull(country);
    }

    @Test
    public void buildWithError() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> CountryFactory
                .build(null ,"Mars"));

        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame(  "Country ID is required!", exceptionMessage);

    }
}
