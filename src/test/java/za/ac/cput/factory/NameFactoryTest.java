/*
TITILAYO AKINJOLE
220283982
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Name;

import static org.junit.jupiter.api.Assertions.*;

public class NameFactoryTest {

    @Test
    void buildWithErrors(){
      //  Name name = NameFactory;
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                NameFactory.build("jgjfhjg" , "princess", null));
        String exceptionMessage = exception.getMessage();
        System.out.print(exceptionMessage);
    //   assertSame("Invalid value for param: surname",exceptionMessage);
    }

    @Test
    void buildWithSuccess(){
        Name name = NameFactory
                .build("test firstName", "test middleName", "test Surname");
        System.out.println(name);
        assertAll(
                () -> assertNotNull(name),
                () -> assertNotNull(name.getFirstName())
        );
    }
}

