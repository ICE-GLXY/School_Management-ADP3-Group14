/*
TITILAYO AKINJOLE
220283982
 */
package za.ac.cput.factory;


import za.ac.cput.domain.Name;
import za.ac.cput.util.Helper;

public class NameFactory {
    public static Name build (String firstName, String middleName, String surname){
        Helper.checkStringParam("firstName", firstName);
        Helper.checkStringParam("surname", surname);
       // Helper.isEmptyOrNull(surname);
      //  Helper.checkFirstName(firstName);

        return new Name.Builder().firstName(firstName)
                .middleName(middleName)
                .surname(surname)
                .build();
    }


}