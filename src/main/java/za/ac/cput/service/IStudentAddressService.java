/* IStudentAddressService.java
Author: Chante Lewis:216118395
16/06/2022
 */

package za.ac.cput.service;

import za.ac.cput.domain.StudentAddress;

import java.util.List;

public interface IStudentAddressService extends IService <StudentAddress,String> {

    List<StudentAddress> findAll();

    void deleteByID(String id);
    List <StudentAddress> findByAddressCityCountryName (String name);

}